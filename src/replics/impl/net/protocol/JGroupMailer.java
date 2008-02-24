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

	String props="UDP(mcast_addr=228.1.2.3;mcast_port=45566;ip_ttl=32):" +
	"PING(timeout=3000;num_initial_members=6):" +
	"FD(timeout=5000):" +
	"VERIFY_SUSPECT(timeout=1500):" +
	"pbcast.STABLE(desired_avg_gossip=10000):" +
	"pbcast.NAKACK(gc_lag=10;retransmit_timeout=3000):" +
	"UNICAST(timeout=5000;min_wait_time=2000):" +
	"FRAG:" +
	"pbcast.GMS(initial_mbrs_timeout=4000;join_timeout=5000;" +
	"shun=false;print_local_addr=false)";
	
	private Channel channel;
	
	private Map<String, Address> routes = new WeakHashMap<String, Address>(1000);
	
	public void register(IMessageListener messageListener,
			MessageType typeOfMessage) {
		// TODO Auto-generated method stub

	}

	public void sendUnmodified(IMessage message) {
		byte[] msg = null;
		try { msg = services.getSerializer().toXML(message).getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {	}
		
		try {
		if (null != message.getDestGroupID()
				&& services.getPeerGroupManager().getNeighborGroupIDs().contains(message.getDestGroupID()))
		{
			channel.send(null, null, msg);
			
		}
		else if (null != message.getDestGroupID())
		{
			channel.send(routes.get(message.getDestGroupID()), null, msg);
		}
		if (null != message.getDestPeerID())
		{
			channel.send(routes.get(message.getDestPeerID()), null, msg);
		}
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
			channel.connect(services.getPeerGroupManager().getLocalGroupID().getGroupID());
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
