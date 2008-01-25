package replics.net.messages;

import replics.data.IRecordID;
import net.jxta.document.Document;

public interface IPeerGroupAdvertisement extends IMessage {
	
	public IRecordID getLastRecordID();
	
	public void setLastRecordID(IRecordID lastRecord);
	
	public IRecordID getFirstRecordID();
	
	public String getLastTagHash();
	
}
