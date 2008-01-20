package replics.data;

import java.io.Serializable;

/**
 * Very light structure used to identify a specific record in the whole network.
 * For a given group ID, the record id is a unique number. this number is
 * auto-incremented at each creation of a record.
 * 
 * @author Jean-Baptiste Giraudeau
 */
public interface IRecordID extends Serializable {

	
	/**
	 * Group ID getter. A group ID is a 66 character long string.
	 *  
	 * @return the ID of the group owner for the record. 
	 */
	public String getGroupID();

	
	/**
	 * Record ID getter, identifying a record inside a given group 
	 * (at most 8 digits).
	 * 
	 * @return the ID of the record inside the group.
	 */
	public int getRecordID();

}
