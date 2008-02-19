package replics.net.messages;

import replics.data.IRecordID;

public interface IPeerGroupAdvertisement extends IMessage {
	
	public IRecordID getLastRecordID();
	
	public void setLastRecordID(IRecordID lastRecordID);
	
	public IRecordID getFirstRecordID();
	
	public void setFirstRecordID(IRecordID firstRecordID);
	
	public String getLastTagHash();
	
	public void setLastTagHash();
		
}
