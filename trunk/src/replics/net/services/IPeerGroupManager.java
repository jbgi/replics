package replics.net.services;

import java.util.Collection;

import replics.net.IGroupID;
import replics.net.IPeerID;
import replics.net.messages.IPeerGroupAdvertisement;
import replics.net.protocol.IMessageListener;

/**
 * @author Virginie
 *IPeerGroupManager gives some information to other services on the state of the joined groups and 
 *the state of the synchronization with other peers
 */
public interface IPeerGroupManager extends IMessageListener{
	
	/**
	 * @return all the PeerId which are in the currently joined groups
	 */
	public Collection<IPeerID> getPeerIDOfJoinedGroups(IGroupID groupID);
	
	public IPeerID getLocalPeerID();
	
	public IGroupID getLocalGroupID();
	
	/**
	 * 
	 * @return the ID of the all groups which have been joined by a peer during his travel
	 */
	public Collection <IGroupID> getAllGroupIDs();
	
	/**
	 * @return the ID of the groups currently joined by the peer
	 */
	public Collection <IGroupID> getNeighborGroupIDs();
	
	// il faudra implémenter une méthode en interne qui indique quels st les voisins joignables par le peer ex public boolean isMyNeighbor(TTL ttl)
	
	/**
	 * @param groupID
	 * @param peerID
	 * If isUpdated returns false then that method is called and that returns the Last PeerGouprAdvertisement 
	 * 
	 *
	 */
	public IPeerGroupAdvertisement getLastGroupAdvertisement(IGroupID groupID, IPeerID peerID);
	
}
