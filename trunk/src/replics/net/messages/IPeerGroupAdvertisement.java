package replics.net.messages;

public interface IPeerGroupAdvertisement {

	public String getPeerID();
	
	public String getGroupID();
	
	public int getLastRecordID();
	
	public int getFirstRecordID();
	
	public String getLastTagHash();
	
}
