package replics.impl.net.services;

import java.net.InetAddress;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import replics.ids.IGroupID;
import replics.ids.IPeerID;
import replics.impl.services.ReplicsService;
import replics.net.messages.IMessage;
import replics.net.messages.IRecordStatus;
import replics.net.services.IPeerGroupManager;

public class PeerGroupManager extends ReplicsService implements
		IPeerGroupManager {
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	public Set<String> getAllGroupIDs() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<IPeerID> getAllPeerIDsOfGroup(IGroupID groupID) {
		// TODO Auto-generated method stub
		return null;
	}

	public IGroupID getLocalGroupID() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLocalPeerID() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<IPeerID> getMasterPeerIDs() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getNeighborGroupIDs() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<IPeerID> getPeerIDs(IGroupID groupID, int maxHops, Date seenSince) {
		// TODO Auto-generated method stub
		return null;
	}

	public InetAddress getPeerIP(IPeerID peerID) {
		// TODO Auto-generated method stub
		return null;
	}

	public IRecordStatus getRecordStatus(IGroupID groupID,
			Collection<IPeerID> peerIDs) {
		// TODO Auto-generated method stub
		return null;
	}

	public void handleMessage(IMessage message) {

	}

	public Set<String> getLocalPeerView() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updatePeerView(String peerID) {
		// TODO Auto-generated method stub
		
	}

	public String getLocalPeerName() {
		// TODO Auto-generated method stub
		return null;
	}

}
