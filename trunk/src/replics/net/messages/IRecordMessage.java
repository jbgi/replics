package replics.net.messages;

import replics.data.IRecord;
import replics.ids.IRecordID;

public interface IRecordMessage extends IMessage {

	/**
	 * This method would allow to access to the ID of a Recorded Message 
	 * @return IRecordID
	 */
	public IRecordID getRecordID();
	
	/**
	 * This method would allow to modify the ID of a Recorded Message
	 * @param recordID
	 */
	public void setRecordID(IRecordID recordID);
	
	/**
	 * This method would allow to change a complete registration in a incomplete one and vice versa
	 * @param isFullRecord
	 */
	public void setIsFullRecord(boolean isFullRecord);
	
	/**
	 * Return true if the registration is Full
	 * @return a boolean
	 */
	public boolean isFullRecord();

	/**
	 * This method would allow to modify a record
	 * @param record
	 */
	public void setRecord(IRecord record);
	
	/**
	 * This method would allow to access to a Record
	 * @return IRecord
	 */
	public IRecord getRecord();
	
	/**
	 * return true if the record has been memorized ? 
	 * @return a boolean
	 */
	public boolean isRecordPresent();
}
