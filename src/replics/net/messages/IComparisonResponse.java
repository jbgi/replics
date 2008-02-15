package replics.net.messages;

import replics.impl.data.RecordID;

/**
 * 
 * Interface used to respond to comparison queries
 * 
 * @author Mickaëk Kerfant
 *
 */
public interface IComparisonResponse extends IMessage {

	/**
	 * this method returns the first RecordID object of the comparison interval 
	 * 
	 * @return a RecordID object
	 */
	public RecordID getFirstRecordID();
	
	/**
	 * 
	 * this method returns the last RecordID object of the comparison interval
	 * 
	 * @return a RecordID object
	 */
	public RecordID getLastRecordID();

	/**
	 * 
	 * This method tests if a duplicate is found in the comparison interval
	 * 
	 * @return true if a duplicate is found during the comparison
	 */
	public boolean isPositiveComparison();
	
	/**
	 * 
	 * This method returns the RecordID object which is duplicated or null if there is no duplicate
	 * 
	 * @return a RecordID object
	 */
	public RecordID getPositiveRecordID();
	
}
