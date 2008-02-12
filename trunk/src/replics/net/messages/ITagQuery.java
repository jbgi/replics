package replics.net.messages;

public interface ITagQuery extends IMessage{

	// dans le cas où l'on a pas de hash, on accepte null comme argument
	public void setPreviousTagHash(String tagHash);
	
	public String getPreviousTagHash();
}
