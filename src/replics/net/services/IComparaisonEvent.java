package replics.net.services;

import replics.data.IRecordID;

public interface IComparaisonEvent {

	public IRecordID getCheckedRecordID();
	
	public void setCheckedRecordID(IRecordID recordID);
	
	public int getComparisonState();
	
	public int getNumberOfComparison();
	
	public void setComparisonState();
	
	public void setNumberOfComparison();
	
	public boolean isDuplicatFound();
	
	public void setIsDuplicatFound(boolean isDuplicatFound);
	
	public IRecordID getDuplicateRecordID();
	
}
