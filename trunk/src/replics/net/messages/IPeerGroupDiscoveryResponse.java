package replics.net.messages;

public interface IPeerGroupDiscoveryResponse extends IMessage {

	public int getHops();
	
	public void setHops(int hops);
	
	public void incrementHops();
	
	public IPeerGroupAdvertisement getPeerGroupAdvertisement();
	
}
