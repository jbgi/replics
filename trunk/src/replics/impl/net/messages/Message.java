package replics.impl.net.messages;

import java.util.Collection;

import replics.net.IGroupID;
import replics.net.IPeerID;
import replics.net.messages.IMessage;

public abstract class Message implements IMessage {

	protected IPeerID sourcePeerID;
	protected Collection<IPeerID> addrPeerIDs;
	protected IGroupID groupID;
	protected int hops;
	protected int ttl;
	
	public Collection<IPeerID> getAddrPeerIDs() {
		return addrPeerIDs;
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

	public void setAddrPeerIDs(Collection<IPeerID> addrPeerIDs) {
		this.addrPeerIDs = addrPeerIDs;
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
