package replics.ids;

public interface ITagID {

	/**
	 * The ID of the peer that first emitted the tag.
	 * 
	 * @return a peer ID string.
	 */
	public String getPeerID();
	
	public int getTagID();
	
}
