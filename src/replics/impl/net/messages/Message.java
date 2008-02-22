package replics.impl.net.messages;

import replics.ids.IGroupID;
import replics.ids.IPeerID;
import replics.net.messages.IMessage;

public abstract class Message implements IMessage {

	protected IPeerID sourcePeerID;
	protected IPeerID destPeerID;
	protected IGroupID groupID;
	protected int hops;
	protected int ttl;
	
	public Message(IPeerID sourcePeerID, IPeerID destPeerID, IGroupID groupID,
			int hops, int ttl) {
		super();
		this.sourcePeerID = sourcePeerID;
		this.destPeerID = destPeerID;
		this.groupID = groupID;
		this.hops = hops;
		this.ttl = ttl;
	}

	public IPeerID getDestPeerID() {
		return destPeerID;
	}

	public IGroupID getGroupID() {
		return groupID;
	}

	public int getHops() {
		return hops;
	}

	public IPeerID getSourcePeerID() {
		return sourcePeerID;
	}

	public int getTTL() {
		return ttl;
	}

	public void setSourcePeerID(IPeerID sourcePeerID) {
		this.sourcePeerID = sourcePeerID;
	}

	public void setDestPeerID(IPeerID destPeerID) {
		this.destPeerID = destPeerID;
	}

	public void setGroupID(IGroupID groupID) {
		this.groupID = groupID;
	}

	public void setHops(int hops) {
		this.hops = hops;
	}

	public void setTTL(int ttl) {
		this.ttl = ttl;
	}

	
}
