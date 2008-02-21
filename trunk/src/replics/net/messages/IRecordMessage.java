package replics.net.messages;

import replics.data.IRecord;
import replics.data.IRecordID;

public interface IRecordMessage extends IMessage {

	public IRecordID getRecordID();
	
	public void setRecordID(IRecordID recordID);
	
	public void setIsFullRecord(boolean isFullRecord);
	
	public boolean isFullRecord();

	public void setRecord(IRecord record);
	
	public IRecord getRecord();
	
	public boolean isRecordPresent();
}
