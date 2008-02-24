package replics.impl.net.services;

import java.net.InetAddress;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
	
	private String peerName;
	private String peerID;
	private String globalContext;
	private Set<String> peerView = new HashSet<String>();
	
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
		return this.peerID;
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

	public IRecordStatus getRecordStatus(IGroupID groupID,
			Collection<IPeerID> peerIDs) {
		// TODO Auto-generated method stub
		return null;
	}

	public void handleMessage(IMessage message) {

	}

	public Set<String> getLocalPeerView() {
		return peerView;
	}

	public void updatePeerView(String peerID) {
		peerView.add(peerID);
	}

	public String getLocalPeerName() {
		return peerName;
	}

	public void setLocalPeerID(String peerID) {
		this.peerID = peerID;
	}

	public void setLocalPeerName(String peerName) {
		this.peerName = peerName;
	}

	public String getGlobalContext() {
		return this.globalContext;
	}

	public void setGlobalContext(String globalContextName) {
		this.globalContext = globalContextName;
	}

}
