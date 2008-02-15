package replics.net.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.jxta.document.AdvertisementFactory;
import net.jxta.document.XMLDocument;
import net.jxta.document.StructuredDocumentFactory;
import net.jxta.document.MimeMediaType;
import net.jxta.endpoint.Message;
import net.jxta.endpoint.MessageElement;
import net.jxta.endpoint.StringMessageElement;
import net.jxta.endpoint.MessageTransport;
import net.jxta.endpoint.TextDocumentMessageElement;
import net.jxta.exception.PeerGroupException;
import net.jxta.id.IDFactory;
import net.jxta.peer.PeerID;
import net.jxta.peergroup.PeerGroup;
import net.jxta.pipe.InputPipe;
import net.jxta.pipe.OutputPipe;
import net.jxta.pipe.PipeID;
import net.jxta.pipe.PipeMsgEvent;
import net.jxta.pipe.PipeMsgListener;
import net.jxta.pipe.PipeService;
import net.jxta.platform.NetworkManager;
import net.jxta.protocol.PipeAdvertisement;
import net.jxta.protocol.RouteAdvertisement;
import net.jxta.impl.endpoint.router.RouteControl;
import net.jxta.impl.endpoint.router.EndpointRouter;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Map;
import java.util.Hashtable;
import net.jxta.discovery.DiscoveryService;
import net.jxta.document.AdvertisementFactory;
import net.jxta.document.TextDocument;
import net.jxta.id.IDFactory;
import net.jxta.peergroup.PeerGroup;
import net.jxta.peergroup.PeerGroupID;
import net.jxta.protocol.ModuleImplAdvertisement;
import net.jxta.protocol.PeerGroupAdvertisement;

/**
 * Simple example to illustrate the use of propagated pipes
 */

public class PropagatedGroupServer implements PipeMsgListener {

	/**
	 * Source PeerID
	 */
	public final static String SRCIDTAG = "SRCID";

	/**
	 * Source Peer Name
	 */
	public final static String SRCNAMETAG = "SRCNAME";

	/**
	 * GroupInfo TAG name
	 */
	public final static String GROUPINFO = "GROUPINFO";

	/**
	 * Replics message name space
	 */
	public final static String NAMESPACE = "REPLICS";
	private PeerGroup netPeerGroup = null;

	/**
	 * Common propagated pipe id
	 */
	public final static String PIPEIDSTR = "urn:jxta:uuid-59616261646162614E504720503250336FA944D18E8A4131AA74CE6F4BF85DEF04";
	private final static String completeLock = "completeLock";
	private static PipeAdvertisement pipeAdv = null;
	private static PipeService pipeService = null;
	InputPipe inputPipe = null;
	private transient Map<PeerID, OutputPipe> pipeCache = new Hashtable<PeerID, OutputPipe>();
	public static final String ROUTEADV = "ROUTE";
	private RouteControl routeControl = null;
	private MessageElement routeAdvElement;

	private PeerGroupAdvertisement grpAdv;

	private ModuleImplAdvertisement groupImplAdv;

	private PeerGroup privateGroup;

	private Message grpInfo;

	public PropagatedGroupServer() {
		routeAdvElement = null;
	}

	/**
	 * Gets the pipeAdvertisement attribute of the PropagatedPipeServer class
	 * 
	 * @return The pipeAdvertisement value
	 */
	public static PipeAdvertisement getPipeAdvertisement() {
		PipeID pipeID = null;

		try {
			pipeID = (PipeID) IDFactory.fromURI(new URI(PIPEIDSTR));
		} catch (URISyntaxException use) {
			use.printStackTrace();
		}
		PipeAdvertisement advertisement = (PipeAdvertisement) AdvertisementFactory
				.newAdvertisement(PipeAdvertisement.getAdvertisementType());

		advertisement.setPipeID(pipeID);
		advertisement.setType(PipeService.PropagateType);
		advertisement.setName("Propagated Pipe Tutorial");
		return advertisement;
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized void pipeMsgEvent(PipeMsgEvent event) {

		Message message = event.getMessage();

		if (message == null) {
			return;
		}
		MessageElement sel = message.getMessageElement(NAMESPACE, SRCIDTAG);
		MessageElement nel = message.getMessageElement(NAMESPACE, SRCNAMETAG);

		// check for a route advertisement and train the endpoint router with
		// the new route
		processRoute(message);
		if (sel == null) {
			return;
		}
		System.out.println("Received a Ping from :" + nel.toString());
		System.out.println("Source PeerID :" + sel.toString());
		Message pong = grpInfo.clone();
		OutputPipe outputPipe = null;
		PeerID pid = null;

		try {
			pid = (PeerID) IDFactory.fromURI(new URI(sel.toString()));
			if (pid != null) {
				// Unicast the Message back. One should expect this to be
				// unicast
				// in Rendezvous only propagation mode.
				// create a op pipe to the destination peer
				if (!pipeCache.containsKey(pid)) {
					// Unicast datagram
					// create a op pipe to the destination peer
					outputPipe = pipeService.createOutputPipe(pipeAdv,
							Collections.singleton(pid), 1);
					pipeCache.put(pid, outputPipe);
				} else {
					outputPipe = pipeCache.get(pid);
				}
				boolean sucess = outputPipe.send(pong);
				System.out.println("Send pong message status :" + sucess);
			} else {
				// send it to all
				System.out.println("unable to create a peerID from :"
						+ sel.toString());
				outputPipe = pipeService.createOutputPipe(pipeAdv, 1000);
				boolean sucess = outputPipe.send(pong);
				System.out.println("Send pong message status :" + sucess);
			}
		} catch (IOException ex) {
			if (pid != null && outputPipe != null) {
				outputPipe.close();
				outputPipe = null;
				pipeCache.remove(pid);
			}
			ex.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Keep running, avoids existing
	 */
	private void waitForever() {
		try {
			System.out.println("Waiting for Messages.");
			synchronized (completeLock) {
				completeLock.wait();
			}
			System.out.println("Done.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void processRoute(final Message msg) {
		try {
			final MessageElement routeElement = msg.getMessageElement(
					NAMESPACE, ROUTEADV);
			if (routeElement != null && routeControl != null) {
				XMLDocument asDoc = (XMLDocument) StructuredDocumentFactory
						.newStructuredDocument(routeElement.getMimeType(),
								routeElement.getStream());
				final RouteAdvertisement route = (RouteAdvertisement) AdvertisementFactory
						.newAdvertisement(asDoc);
				routeControl.addRoute(route);
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	private void createPrivateGroup(String name) {
		try {
			privateGroup = netPeerGroup.newGroup(IDFactory.newPeerGroupID(),
					netPeerGroup.getAllPurposePeerGroupImplAdvertisement(),
					name, name);

			privateGroup.startApp(new String[0]);

			grpInfo = new Message();
			grpInfo.addMessageElement(NAMESPACE, new
					TextDocumentMessageElement(GROUPINFO, (TextDocument)
							privateGroup.getPeerGroupAdvertisement().getDocument(MimeMediaType.XMLUTF8), null));
			grpInfo.addMessageElement(NAMESPACE, new StringMessageElement(
					SRCNAMETAG, netPeerGroup.getPeerName(), null));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * main
	 * 
	 * @param args
	 *            command line args
	 */
	public static void main(String args[]) {
		PropagatedGroupServer server = new PropagatedGroupServer();

		pipeAdv = getPipeAdvertisement();
		NetworkManager manager = null;

		try {
			manager = new NetworkManager(NetworkManager.ConfigMode.RENDEZVOUS,
					"PropagatedPipeServer", new File(new File(".cache"),
							"PropagatedPipeServer").toURI());
			manager.startNetwork();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}

		server.netPeerGroup = manager.getNetPeerGroup();
		pipeService = server.netPeerGroup.getPipeService();

		MessageTransport endpointRouter = (server.netPeerGroup
				.getEndpointService()).getMessageTransport("jxta");

		if (endpointRouter != null) {
			server.routeControl = (RouteControl) endpointRouter
					.transportControl(EndpointRouter.GET_ROUTE_CONTROL, null);
			RouteAdvertisement route = server.routeControl.getMyLocalRoute();

			if (route != null) {
				server.routeAdvElement = new TextDocumentMessageElement(
						ROUTEADV, (XMLDocument) route
								.getDocument(MimeMediaType.XMLUTF8), null);
			}
		}

		System.out.println("Creating Propagated InputPipe for "
				+ pipeAdv.getPipeID());
		try {
			server.inputPipe = pipeService.createInputPipe(pipeAdv, server);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		server.createPrivateGroup(args[0]);
		server.waitForever();
		server.inputPipe.close();
		manager.stopNetwork();
	}

}
