package replics.net.messages;

import replics.data.IRecordID;
import replics.impl.data.RecordID;

/**
 * 
 * Interface used to respond to comparison queries
 * 
 * @author Mickaël Kerfant
 *
 */
public interface IComparisonResponse extends IMessage {

	/**
	 * this method returns the first RecordID object of the comparison interval 
	 * @return an IRecordID object
	 */
	public IRecordID getFirstRecordID();
	
	/**
	 * this method returns the last RecordID object of the comparison interval
	 * @return an IRecordID object
	 */
	public IRecordID getLastRecordID();
	
	/**
	 * This method returns the IRecordID of the record compared
	 * @return an IRecordID object
	 */
	public IRecordID getComparedRecordID();
	
	/**
	 * this method changes the first RecordID object of the comparison interval 
	 * @return an IRecordID object
	 */
	public void setFirstRecordID(IRecordID firstRecordID);
	
	/**
	 * this method changes the last RecordID object of the comparison interval
	 * @return an IRecordID object
	 */
	public void setLastRecordID(IRecordID lastRecordID);
	
	/**
	 * This method changes the IRecordID of the record compared
	 * @return an IRecordID object
	 */
	public void setComparedRecordID(IRecordID comparedRecordID);
	
	/** 
	 * This method tests if a duplicate is found in the comparison interval 
	 * @return true if a duplicate is found during the comparison
	 */
	public boolean isPositiveComparison();
	
	/**
	 * This method returns the IRecordID object which is duplicated or null if there is no duplicate
	 * @return an IRecordID object
	 */
	public IRecordID getPositiveRecordID();
	
	/**
	 * Self explained (cf Jean-Baptiste Giraudeau)
	 * @return an IRecordID object
	 */
	public void setPositiveRecordID(IRecordID positiveRecordID);
	
}
