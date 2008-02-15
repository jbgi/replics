package replics.net.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.jxta.endpoint.Message;
import net.jxta.endpoint.MessageElement;
import net.jxta.endpoint.StringMessageElement;
import net.jxta.endpoint.TextDocumentMessageElement;
import net.jxta.endpoint.MessageTransport;
import net.jxta.peergroup.PeerGroup;
import net.jxta.pipe.InputPipe;
import net.jxta.pipe.OutputPipe;
import net.jxta.pipe.PipeMsgEvent;
import net.jxta.pipe.PipeMsgListener;
import net.jxta.pipe.PipeService;
import net.jxta.platform.NetworkManager;
import net.jxta.protocol.PeerGroupAdvertisement;
import net.jxta.protocol.PipeAdvertisement;
import net.jxta.protocol.RouteAdvertisement;
import net.jxta.impl.endpoint.router.EndpointRouter;
import net.jxta.impl.endpoint.router.RouteControl;
import net.jxta.document.XMLDocument;
import net.jxta.document.MimeMediaType;

import java.io.File;
import java.io.IOException;

import replics.net.test.PropagatedGroupServer;
import net.jxta.document.Element;
import net.jxta.document.StructuredDocumentFactory;
import net.jxta.impl.peer.PeerInfoServiceInterface;
import net.jxta.impl.pipe.WireHeader;
import net.jxta.impl.protocol.PeerGroupAdv;

/**
 * Simple example to illustrate the use of propagated pipes
 */
public class PropagatedGroupClient implements PipeMsgListener {
	private InputPipe inputPipe;
	private MessageElement routeAdvElement = null;
	private RouteControl routeControl = null;
	public static final String ROUTEADV = "ROUTE";
	private PeerGroup netPeerGroup;
	/**
	 * {@inheritDoc}
	 */
	public synchronized void pipeMsgEvent(PipeMsgEvent event) {

		Message message = event.getMessage();

		if (message == null) {
			return;
		}
		MessageElement gel = message.getMessageElement(
				PropagatedGroupServer.NAMESPACE,
				PropagatedGroupServer.GROUPINFO);
		MessageElement nel = message.getMessageElement(
				PropagatedGroupServer.NAMESPACE,
				PropagatedGroupServer.SRCNAMETAG);
		XMLDocument asDoc = null;
		try {
			asDoc = (XMLDocument) StructuredDocumentFactory.newStructuredDocument(gel.getMimeType(),
			        gel.getStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PeerGroupAdvertisement adv = null;
			try {
				adv = (PeerGroupAdvertisement)
				PeerGroupAdv.Instantiator.class.newInstance().newInstance(asDoc.getRoot());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (adv == null) {
		 return;
		}

		// Since propagation relies on ip multicast whenever possible, it is to
		// to be expected that a unicasted message can be intercepted through ip
		// multicast
		System.out.println("Received a pong from :" + nel.toString());

		MessageElement elem = message.getMessageElement("jxta",
				"JxtaWireHeader");

		WireHeader header;
		try {
			XMLDocument doc = (XMLDocument) StructuredDocumentFactory
					.newStructuredDocument(elem);
			header = new WireHeader(doc);

			System.out.println("Hops :" + header.getHOPS());
			if (header.getHOPS() != 0) {
				System.out.println("NOT joining group: " + adv.getName());
			}
			else if (netPeerGroup.globalRegistry.registeredInstance(adv.getPeerGroupID())){
				System.out.println("Already in group: " + adv.getName());
			}
			else {
				System.out.println("Joining group: " + adv.getName());
				PeerGroup pg = netPeerGroup.newGroup(adv);
				int r = pg.startApp(new String[0]);
				if (r == 0)
					System.out.println("Group " + pg.getPeerGroupName() + " joined.");
			}
				

		} catch (Exception ex) {
			Logger.getLogger(PropagatedGroupClient.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}

	/**
	 * main
	 * 
	 * @param args
	 *            command line args
	 */
	public static void main(String args[]) {
		PropagatedGroupClient client = new PropagatedGroupClient();
		NetworkManager manager = null;

		try {
			manager = new NetworkManager(NetworkManager.ConfigMode.RENDEZVOUS,
					"PropagatedPipeClient", new File(new File(".cache"),
							"PropagatedPipeClient").toURI());
			manager.startNetwork();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		client.netPeerGroup = manager.getNetPeerGroup();
		PipeAdvertisement pipeAdv = PropagatedGroupServer
				.getPipeAdvertisement();
		PipeService pipeService = client.netPeerGroup.getPipeService();

		System.out.println("Creating Propagated InputPipe for "
				+ pipeAdv.getPipeID());
		try {
			client.inputPipe = pipeService.createInputPipe(pipeAdv, client);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		MessageTransport endpointRouter = (client.netPeerGroup.getEndpointService())
				.getMessageTransport("jxta");

		if (endpointRouter != null) {
			client.routeControl = (RouteControl) endpointRouter
					.transportControl(EndpointRouter.GET_ROUTE_CONTROL, null);
			RouteAdvertisement route = client.routeControl.getMyLocalRoute();

			if (route != null) {
				client.routeAdvElement = new TextDocumentMessageElement(
						ROUTEADV, (XMLDocument) route
								.getDocument(MimeMediaType.XMLUTF8), null);
			}
		}

		System.out.println("Creating Propagated OutputPipe for "
				+ pipeAdv.getPipeID());
		OutputPipe output = null;

		try {
			output = pipeService.createOutputPipe(pipeAdv, 1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		int i = 0;

		try {
			while (i < 10000000) {
				Message ping = new Message();
				ping.addMessageElement(PropagatedGroupServer.NAMESPACE,
						new StringMessageElement(
								PropagatedGroupServer.SRCIDTAG, client.netPeerGroup
										.getPeerID().toString(), null));
				ping.addMessageElement(PropagatedGroupServer.NAMESPACE,
						new StringMessageElement(
								PropagatedGroupServer.SRCNAMETAG, client.netPeerGroup
										.getPeerName()
										+ " #" + i++, null));
				if (client.routeAdvElement != null
						&& client.routeControl != null) {
					ping.addMessageElement(PropagatedGroupServer.NAMESPACE,
							client.routeAdvElement);
				}

				System.out.println("Sending message :" + (i - 1));
				boolean sucess = output.send(ping);
				System.out.println("Send outgoing message status :" + sucess);
				Thread.sleep(3000);
			}
			manager.stopNetwork();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

