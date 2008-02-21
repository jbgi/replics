package replics.net.messages;

import replics.ids.IRecordID;

public interface IPeerGroupAdvertisement extends IMessage {
	
	public IRecordStatus getRecordStatus();
	
	public void setRecordStatus(IRecordStatus recordStatus); 

}
