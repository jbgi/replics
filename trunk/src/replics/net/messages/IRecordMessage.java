package replics.net.messages;

import replics.data.IRecordID;

public interface IRecordMessage extends IMessage {

	public IRecordID getRecordID();
	
	public void setRecordId(IRecordID recordId);
	
	public void setFullRecord(boolean isFullRecord);
	
	public boolean isFullRecord();
	
	
	

}
