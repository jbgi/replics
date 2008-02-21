package replics.impl.net.messages;

import java.util.Collection;

import replics.ids.IGroupID;
import replics.ids.IPeerID;
import replics.net.messages.IMessage;

public abstract class Message implements IMessage {

	protected IPeerID sourcePeerID;
	protected IPeerID addrPeerID;
	protected IGroupID groupID;
	protected int hops;
	protected int ttl;
	
	public IPeerID getAddrPeerID() {
		return addrPeerID;
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

	public void setAddrPeerID(IPeerID addrPeerIDs) {
		addrPeerIDs = addrPeerIDs;
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
