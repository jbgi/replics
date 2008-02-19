package replics.impl.net.messages;

import java.util.Collection;

import replics.net.IGroupID;
import replics.net.IPeerID;
import replics.net.messages.IMessage;

public abstract class Message implements IMessage {

	public Collection<IPeerID> getAddrPeerIDs() {
		// TODO Auto-generated method stub
		return null;
	}

	public IGroupID getGroupID() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getHops() {
		// TODO Auto-generated method stub
		return 0;
	}

	public IPeerID getSourcePeerID() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getTTL() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setAddrPeerIDs(Collection<IPeerID> peerIDs) {
		// TODO Auto-generated method stub

	}

	public void setGroupId(IGroupID groupID) {
		// TODO Auto-generated method stub

	}

	public void setHops() {
		// TODO Auto-generated method stub

	}

	public void setSourcePeerID(IPeerID peerID) {
		// TODO Auto-generated method stub

	}

	public void setTTL() {
		// TODO Auto-generated method stub

	}

}
