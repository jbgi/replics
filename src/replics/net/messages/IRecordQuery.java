package replics.net.messages;

import replics.data.IRecordID;

public interface IRecordQuery extends IMessage {

	
	
	public IRecordID getAskedRecordID();
	
}
