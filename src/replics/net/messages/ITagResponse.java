package replics.net.messages;

import replics.data.ITagRecord;

public interface ITagResponse extends IMessage{

	// dans le cas où l'on a pas de hash, on accepte null comme argument
	public void setPreviousTagHash(String tagHash);
	
	public String getPreviousTagHash();
	
	public ITagRecord getTagRecord();
	
	public void setTagRecord(ITagRecord tagRecord);
	
}
