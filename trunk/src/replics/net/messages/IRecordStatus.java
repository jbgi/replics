package replics.net.messages;

import java.util.Map;

import replics.ids.IPeerID;
import replics.ids.IRecordID;
import replics.ids.ITagID;

/**
 * @author Virginie
 * For a Record Status, the group and the comparison peers are known
 */


public interface IRecordStatus {

	/**
	 * @return the last RecordId recorded by the owner of the Record
	 * 
	 */
	public IRecordID getLastRecordID();
	
	
	/**
	 * @return the ID of the First record recorded by the owner of the Record 
	 */
	public IRecordID getFirstRecordID();
	

	/**
	 * @return the PeerId and the TagID 
	 */
	public Map<IPeerID, ITagID> getLastTagIDs();
	
}
