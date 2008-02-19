package replics.net.messages;

import replics.data.IMetaRecord;
import replics.data.IRecordID;
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
	
	public void setFirstRecordID(IRecordID firstRecordID);
	
	public void setLastRecordID(IRecordID lastRecordID);
	
	public IMetaRecord getMetaRecord();
	
	public void setMetaRecord(MetaRecord metaRecord);
	
}
