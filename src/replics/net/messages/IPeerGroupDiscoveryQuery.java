package replics.net.messages;

public interface IPeerGroupDiscoveryQuery extends IMessage {

	public int setTTL(int ttl);
	
	public void decrementTTL();
	
	public int getTTL();
	
}
