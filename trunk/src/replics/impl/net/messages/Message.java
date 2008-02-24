package replics.impl.net.messages;

import java.util.Set;

import replics.net.messages.IMessage;

public abstract class Message implements IMessage {

	protected String sourcePeerID;
	protected String destPeerID;
	protected String destGroupID;
	protected int hops;
	protected int ttl;
	private Set<String> lastView;
	private String lastPropagatorPeer;
	private String id;
	
	public Message(String sourcePeerID, String destPeerID, String groupID,
			int hops, int ttl) {
		super();
		this.sourcePeerID = sourcePeerID;
		this.destPeerID = destPeerID;
		this.destGroupID = destGroupID;
		this.hops = hops;
		this.ttl = ttl;
	}
	
	public String getID(){
		return id;
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

	public void setSourcePeerID(String sourcePeerID) {
		this.sourcePeerID = sourcePeerID;
	}

	public void setDestPeerID(String destPeerID) {
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
	
	public void setLastPropagatorView(Set<String> lastPropagatorView){
		this.lastView = lastPropagatorView;
	}
	
	public void setLastPropagaterPeerID(String lastPropagatorID){
		this.lastPropagatorPeer = lastPropagatorID;
	}
}
