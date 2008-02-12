package replics.net.messages;

import replics.data.IRecordID;

public interface IPeerGroupDiscoveryResponse extends IMessage {

	public int getHops();
	
	/**
	 * To change the value of the initial TTL
	 */
	public void setTTL(int initialTTL); 
	
	public IPeerGroupAdvertisement getPeerGroupAdvertisement();
	
	public IRecordID getLastRecordID();
	
	public void setLastRecordID(IRecordID lastRecord);
	
	public IRecordID getFirstRecordID();
	
	public String getLastTagHash();
	
}
