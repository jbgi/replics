package replics.net.services;

import replics.ids.IRecordID;

/**
 * Partial Results of the comparisons between a local record and the others previous record memorized 
 * by the other peers and/or saved on the server
 * @author Virginie
 * 
 */
public interface IComparisonEvent {

	/**
	 * @return the ID of records which have been already compared to the other previous records
	 */
	public IRecordID getCheckedRecordID();
	
	/**
	 * This method would Allow to change an ID of a checked Record
	 * @param recordID
	 */
	public void setCheckedRecordID(IRecordID recordID);
	
	/**
	 * @return the number of the comparisons already done
	 */
	public int getComparisonsDone();
	
	/**
	 * @return the number of comparisons which have to be done
	 */
	public int getTotalComparisons();
	
	/**This method would allow to modify the number of comparisons already done
	 * @param comparisonsDone
	 */
	public void setComparisonsDone(int comparisonsDone);
	
	/**This method would allow to modify the number of comparisons which have to be done
	 * @param totalComparisons
	 */
	public void setTotalComparisons(int totalComparisons);
	
	/**
	 * The method detects if a inhabitant tried to record twice
	 * @return true if a duplicate has already been recorded by another peer 
	 */
	public boolean isDuplicatFound();
	

	public void setIsDuplicatFound(boolean isDuplicatFound);
	
	/**
	 * @return the ID of a duplicated Record
	 */
	public IRecordID getDuplicatedRecordID();
	
	
}
