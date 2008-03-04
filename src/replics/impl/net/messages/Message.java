 package replics.impl.net.messages;

import java.util.Set;

import replics.net.messages.IMessage;

public abstract class Message implements IMessage {

	private final static int DEFAULT_UNICAST_TTL = 100;
	private final static int DEFAULT_MULTICAST_TTL = 5;
	
	protected String sourcePeerID;
	protected String destPeerID;
	protected String destGroupID;
	protected int hops;
	protected int ttl = Message.DEFAULT_MULTICAST_TTL;
	private Set<String> lastView;
	private String lastPropagatorPeer;
	private String id;
	private String peerName;
	
	public String getID(){
		return id;
	}
	
	public void setID(String messageID){
		this.id = messageID;
	}
	
	public String getSourcePeerName() {
		return peerName;
	}
	
	
	public void setSourcePeerName(String peerName)
	{
		this.peerName = peerName;
	}

	public String getDestPeerID() {
		return destPeerID;
	}

	public String getDestGroupID() {
		return destGroupID;
	}

	public int getHops() {
		return hops;
	}

	public String getSourcePeerID() {
		return sourcePeerID;
	}

	public int getTTL() {
		return ttl;
	}

	/**
	 * Modify the IDs of the Peer who emitted the message
	 * @param peerID
	 */
	public void setSourcePeerID(String sourcePeerID) {
		this.sourcePeerID = sourcePeerID;
	}

	public void setDestPeerID(String destPeerID) {
		this.ttl = Message.DEFAULT_UNICAST_TTL;
		this.destPeerID = destPeerID;
	}

	public void setDestGroupID(String destGroupID) {
		this.destGroupID = destGroupID;
	}

	public void setHops(int hops) {
		this.hops = hops;
	}

	public void setTTL(int ttl) {
		this.ttl = ttl;
	}

	public Set<String> getLastPropagatorView(){
		return lastView;
	}
	
	public String getLastPropagaterPeerID(){
		return lastPropagatorPeer;
	}
	
	public void setLastPropagatorView(Set<String> peerView){
		this.lastView = peerView;
	}
	
	public void setLastPropagaterPeerID(String peerID){
		this.lastPropagatorPeer = peerID;
	}
}
