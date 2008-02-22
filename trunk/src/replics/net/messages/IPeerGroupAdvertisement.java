package replics.net.messages;

public interface IPeerGroupAdvertisement extends IMessage {
	
	public IRecordStatus getRecordStatus();
	
	public void setRecordStatus(IRecordStatus recordStatus); 

}
