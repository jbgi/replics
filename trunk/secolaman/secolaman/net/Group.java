package secolaman.net;

import java.util.Set;

import secolaman.data.MetaMatcher;
import secolaman.data.Ressource;

public interface Group {

	public void connect();

	public void disconnect();

	public Set<Ressource> findLocally(MetaMatcher matcher);

	public Set<Peer> getAllDiscoveredPeers();

	public Set<Peer> getConnectedPeers();

	public GroupInfo getGroupInfo();

	public boolean isConnected();

	public void publish(Ressource ressource);

	public void register(String subscriberName, PeerSubscriber subscriber);

	public void register(String subscriberName, Subscriber subscriber, long discoveringInterval);
	
	public void registerLocally(String subscriberName, Subscriber subscriber);

	public void registerPassive(String subscriberName, Subscriber subscriber);

	public void sendAll(Ressource ressource);

	public void sendTo(String peerID, Ressource ressource);

	public void unregister(String subscriberName);

}
