package replics.net.messages;

import replics.ids.IRecordID;
import replics.ids.ITagID;

public interface IRecordStatus {

	public IRecordID getLastRecordID();
	
	public void setLastRecordID(IRecordID lastRecordID);
	
	public IRecordID getFirstRecordID();
	
	public void setFirstRecordID(IRecordID firstRecordID);
	
	public ITagID getLastTagID();
	
	public void setLastTagID(ITagID tagID);
	
}
