package replics.net.messages;

import replics.data.IRecordID;

public interface IRecordQuery extends IMessage {

	public IRecordID getRecordID();
	
	public void setRecordID(IRecordID recordID);
	
	public void setIsFullRecordQuery(boolean isFullRecordQuery);
	
	public boolean isFullRecordQuery();

}
