package replics.net.messages;

import replics.data.IRecordID;

public interface IRecordQuery extends IMessage {

	
	/**
	 * @return the missing RecordID
	 */
	public IRecordID getRecordID();
	
	
	
}
