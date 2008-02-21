package replics.net.messages;

import java.util.Collection;

import replics.ids.IGroupID;
import replics.ids.IPeerID;

//import net.jxta.document.Document;

public interface IMessage extends Cloneable {

	public IGroupID getGroupID(); 
	
	public void setGroupID(IGroupID groupID);
	
	public void setSourcePeerID(IPeerID peerID);
	
	public IPeerID getSourcePeerID();
	
	public void setAddrPeerIDs(Collection<IPeerID> peerIDs);
	
	/**
	 * @return les ID de tous les destinataires
	 */
	public Collection<IPeerID> getAddrPeerIDs();
	
	// specifique jxta
	//public Document getDocument();
	
	public int getHops();
	
	public void setHops(int hops);
	
	public int getTTL();
	
	public void setTTL(int ttl);
	
	
	
	// specifique jxta
	//public void setDocument(); 
	
}
