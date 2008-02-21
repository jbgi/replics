package replics.net.services;

import replics.ids.IRecordID;

public interface IComparisonEvent {

	public IRecordID getCheckedRecordID();
	
	public void setCheckedRecordID(IRecordID recordID);
	
	public int getComparisonsDone();
	
	public int getTotalComparisons();
	
	public void setComparisonsDone(int comparisonsDone);
	
	public void setTotalComparisons(int totalComparisons);
	
	public boolean isDuplicatFound();
	
	public void setIsDuplicatFound(boolean isDuplicatFound);
	
	public IRecordID getDuplicatedRecordID();
	
}
