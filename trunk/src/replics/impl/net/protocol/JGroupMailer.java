package replics.impl.net.protocol;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.jgroups.Address;
import org.jgroups.Channel;
import org.jgroups.ChannelClosedException;
import org.jgroups.ChannelException;
import org.jgroups.ChannelNotConnectedException;
import org.jgroups.Header;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.Receiver;
import org.jgroups.View;

import replics.ids.IPeerID;
import replics.impl.services.ReplicsService;
import replics.net.messages.IMessage;
import replics.net.messages.MessageType;
import replics.net.protocol.IMessageListener;
import replics.net.protocol.IMessageMailer;

public class JGroupMailer extends AbstractMailer implements IMessageMailer, Receiver  {

	String props="UDP(mcast_addr=228.1.2.3;mcast_port=45567;ip_ttl=32):" +
	"PING:" +
	"pbcast.NAKACK(gc_lag=10;retransmit_timeout=3000):" +
	"UNICAST:" +
	"FRAG:" +
	"pbcast.GMS(print_local_addr=false);";
	
	private Channel channel;
	
	private Map<String, Address> routes = new WeakHashMap<String, Address>(1000);

	public void sendUnmodified(IMessage message) {
		Message msg = new Message();
		try {
			msg.setBuffer(services.getSerializer().toXML(message).getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (null != message.getDestPeerID())
		{
			msg.setDest(routes.get(message.getDestPeerID()));
		}
		else {
			msg.setDest(null);
		}
		try {
			channel.send(msg);
		} catch (ChannelNotConnectedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ChannelClosedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void initialize() {
		try {
			channel = new JChannel(props);
			channel.connect(services.getPeerGroupManager().getGlobalContext());
			channel.setReceiver(this);
			super.initialize();
		} catch (ChannelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public byte[] getState() {
		// TODO Auto-generated method stub
		return null;
	}

	public void receive(Message msg) {
		IMessage message = null;
		try {
			message = (IMessage) services.getSerializer().fromXML(
					new ByteArrayInputStream(msg.getBuffer()));
		} catch (Exception e) { }
		if (null == message) {
			 logger.warning("Unreconized message received: dismissed");
			 return;
		}
		routes.put(message.getSourcePeerID(), msg.getSrc());
		routes.put(message.getLastPropagaterPeerID(), msg.getSrc());
		earlyProcess(message);
	}

	public void setState(byte[] state) {
		// TODO Auto-generated method stub
		
	}

	public void block() {
		// TODO Auto-generated method stub
		
	}

	public void suspect(Address suspected_mbr) {
		// TODO Auto-generated method stub
		
	}

	public void viewAccepted(View new_view) {
		// TODO Auto-generated method stub
		
	}

}
