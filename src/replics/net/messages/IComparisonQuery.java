package replics.net.messages;

import replics.data.IMetaRecord;
import replics.ids.IRecordID;
import replics.impl.data.MetaRecord;
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
	 * @return an IRecordID object
	 */
	public IRecordID getFirstRecordID();
	
	/**
	 * 
	 * This method returns the last RecordID object of the comparison interval 
	 * 
	 * @return an IRecordID object
	 */
	public IRecordID getLastRecordID();
	
	/**
	 * This method modifies the ID of the First Record of the comparison interval
	 * @param firstRecordID
	 */
	public void setFirstRecordID(IRecordID firstRecordID);
	
	/**
	 * This method modifies the ID of the last Record of the comparison interval
	 * @param lastRecordID
	 */
	public void setLastRecordID(IRecordID lastRecordID);
	
	/**
	 * This method returns the MetaRecord of the comparison interval
	 * @return an IMetaRecord object
	 */
	public IMetaRecord getMetaRecord();
	
	/**
	 * This methods Modifies a MetaRecord
	 * @param metaRecord
	 */

	public void setMetaRecord(MetaRecord metaRecord);
	
}
