package replics.net.services;

import replics.IReplicsService;

/**
 * @author Virginie
 * IQuotaManager manage the Disk Quota memory 
 * 
 *
 */
public interface IRecordQuotaManager extends IReplicsService {
	
	/**
	 * @return the number of possible new record, calculated from the free space available on the disk and the erasable records)
	 */ 
	public int getNumberOfPossibleRecord();
	
	/**
	 * @return true if a new record is allowed to be stored on the disk 
	 */
	public boolean isNewRecordAllowed();
	

}
