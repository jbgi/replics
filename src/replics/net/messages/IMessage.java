package replics.net.messages;

import java.util.Collection;

import replics.ids.IGroupID;
import replics.ids.IPeerID;

//import net.jxta.document.Document;

public interface IMessage extends Cloneable {

	public IGroupID getDestGroupID();
	
	public void setDestGroupID(IGroupID destGroupID);
	
	/**
	 * Modify the IDs of the Peer who emitted the message
	 * @param peerID
	 */
	public void setSourcePeerID(IPeerID destPeerID);
	
	public IPeerID getSourcePeerID();
	
	/**
	 * Modify the IDs of the recipients
	 * @param peerID
	 */
	public void setDestPeerID(IPeerID destPeerID);
	
	/**
	 * Return all the IDs of the recipients
	 * @return collection of PeerId
	 */
	public IPeerID getDestPeerID();
	
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
