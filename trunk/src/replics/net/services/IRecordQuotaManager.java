/**
 * 
 */
package replics.net.services;

/**
 * @author Virginie
 * IQuotaManager manage the Disk Quota memory 
 * 
 *
 */
public interface IRecordQuotaManager {
	
	/**
	 * @return the number of possible new record, calculated from the free space available on the disk and the erasable records)
	 */ 
	public int getNumberOfPossibleRecord();
	
	public boolean isNewRecordAllowed();
	

}
