package replics.net.messages;

import java.util.Map;

import replics.ids.IPeerID;
import replics.ids.IRecordID;
import replics.ids.ITagID;

public interface IRecordStatus {

	public IRecordID getLastRecordID();
	
	public void setLastRecordID(IRecordID lastRecordID);
	
	public IRecordID getFirstRecordID();
	
	public void setFirstRecordID(IRecordID firstRecordID);
	
	public Map<IPeerID, ITagID> getLastTagIDs();
	
}
