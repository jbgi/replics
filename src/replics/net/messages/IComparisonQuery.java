package replics.net.messages;

import replics.impl.data.RecordID;

/**
 * Interface used by a peer to send comparison queries
 * 
 * @author Mickaël Kerfant
 *
 */
public interface IComparisonQuery extends IMessage {

	/**
	 * This method returns the first RecordID object of the comparison interval 
	 * 
	 * @return a RecordID object
	 */
	public RecordID getFirstRecordID();
	
	/**
	 * 
	 * This method returns the last RecordID object of the comparison interval 
	 * 
	 * @return a RecordID object
	 */
	public RecordID getLastRecordID();
	
	
	
}
