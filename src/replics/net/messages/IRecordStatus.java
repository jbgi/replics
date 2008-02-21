package replics.net.messages;

import replics.data.IRecordID;

public interface IRecordStatus {

	public IRecordID getLastRecordID();
	
	public void setLastRecordID(IRecordID lastRecordID);
	
	public IRecordID getFirstRecordID();
	
	public void setFirstRecordID(IRecordID firstRecordID);
	
	public String getLastTagHash();
	
	public void setLastTagHash();
	
	public String getPreviousTagHash();
	
	public void setPreviousTagHash();
	
}
