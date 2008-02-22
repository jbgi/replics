package replics.net.messages;

import java.util.Collection;

import replics.ids.IGroupID;
import replics.ids.IPeerID;

//import net.jxta.document.Document;

public interface IMessage extends Cloneable {

	public IGroupID getDestGroupID();
	
	public void setGroupID(IGroupID groupID);
	
	/**
	 * Modify the IDs of the Peer who emitted the message
	 * @param peerID
	 */
	public void setSourcePeerID(IPeerID peerID);
	
	public IPeerID getSourcePeerID();
	
	/**
	 * Modify the IDs of the recipients
	 * @param peerIDs
	 */
	public void setDestPeerIDs(Collection<IPeerID> peerIDs);
	
	/**
	 * Return all the IDs of the recipients
	 * @return collection of PeerId
	 */
	public Collection<IPeerID> getDestPeerIDs();
	
	// specifique jxta
	//public Document getDocument();
	
	/**
	 * Give the number of the hops between the sender and the recipient
	 * @return an int
	 */
	public int getHops();
	
	/**
	 * Modify the number of hops
	 * @param hops
	 */
	public void setHops(int hops);
	
	/**
	 * To have the Time To Live associated to a sent message 
	 * @return an int
	 */
	public int getTTL();
	
	/**
	 * To modify the TTL 
	 * @param ttl
	 */
	public void setTTL(int ttl);
	
	
	
	// specifique jxta
	//public void setDocument(); 
	
}
