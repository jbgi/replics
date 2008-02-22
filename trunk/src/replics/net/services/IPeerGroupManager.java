package replics.net.services;

import java.net.InetAddress;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import replics.ids.IGroupID;
import replics.ids.IPeerID;
import replics.net.messages.IRecordStatus;
import replics.net.protocol.IMessageListener;
import replics.services.IReplicsService;

/**
 * @author Virginie
 *IPeerGroupManager gives some information to other services on the state of the joined groups and 
 *the state of the synchronization with other peers
 */
public interface IPeerGroupManager extends IReplicsService, IMessageListener {
	
	/**
	 * @return all the PeerId which are in the currently joined groups
	 */
	public Set<IPeerID> getAllPeerIDsOfGroup(IGroupID groupID);
	
	public IPeerID getLocalPeerID();
	
	public IGroupID getLocalGroupID();
	
	public Set<IPeerID> getMasterPeerIDs();
	
	public Set<IPeerID> getPeerIDs(IGroupID groupID, int maxHops, Date seenSince);
	
	public Set<IPeerID> getPossibleRoutesToPeer(IPeerID peerID);
	
	public InetAddress getPeerIP(IPeerID peerID);
	
	/**
	 * 
	 * @return the ID of the all groups which have been joined by a peer during his travel
	 */
	public Set<IGroupID> getAllGroupIDs();
	
	/**
	 * @return the ID of the groups currently joined by the peer
	 */
	public Set<IGroupID> getNeighborGroupIDs();
	
	// il faudra implémenter une méthode en interne qui indique quels st les voisins joignables par le peer ex public boolean isMyNeighbor(TTL ttl)
	
	/**
	 * If isUpdated returns false then that method is called and that returns the Last PeerGouprAdvertisement 
	 * @param groupID
	 * @param peerID
	 */
	public IRecordStatus getRecordStatus(IGroupID groupID, Collection<IPeerID> peerIDs);
	
}
