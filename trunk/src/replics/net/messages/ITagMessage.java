package replics.net.messages;

import replics.data.ITagRecord;

/** 
 * Each Message emitted is associated to a TAG and it is important to have an access on those TAGS 
 * to check the synchronization of peers for instance
 * @author Virginie
 *
 */
public interface ITagMessage extends IMessage{

	// dans le cas où l'on a pas de hash, on accepte null comme argument
	public void setPreviousTagHash(String tagHash);
	
	/**
	 * 
	 * @return a hash of the TAG which was recorded before the last TAG memorized by the peer
	 */
	public String getPreviousTagHash();
	
	/**
	 * @return a Tag associated to the Record 
	 */
	
	public ITagRecord getTagRecord();
	
	/**
	 * @param tagRecord
	 * That method allows to modify the Tag associated by the record
	 */
	public void setTagRecord(ITagRecord tagRecord);
	
}
