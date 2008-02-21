package replics.impl.net.messages;

import replics.data.IRecordID;
import replics.impl.data.MetaRecord;
import replics.impl.data.RecordID;
import replics.net.messages.IComparisonResponse;

public class ComparisonResponse extends Message implements IComparisonResponse {

	private IRecordID firstRecordID; 
	private IRecordID lastRecordID;
	private IRecordID comparedRecordID;
	private	IRecordID positiveRecordID;

	public IRecordID getFirstRecordID() {
		return firstRecordID;
	}

	public IRecordID getLastRecordID() {
		return lastRecordID;
	}
	
	public IRecordID getComparedRecordID() {
		return comparedRecordID;
	}

	public void setFirstRecordID(IRecordID firstRecordID) {
		this.firstRecordID = firstRecordID;
	}

	public void setLastRecordID(IRecordID lastRecordID) {
		this.lastRecordID = lastRecordID;
	}

	public void setComparedRecordID(IRecordID comparedRecordID) {
		this.comparedRecordID = comparedRecordID;
	}

	public IRecordID getPositiveRecordID() {
		return positiveRecordID;
	}

	public void setPositiveRecordID(IRecordID positiveRecordID) {
		this.positiveRecordID = positiveRecordID;
	}

	public boolean isPositiveComparison() {
		return positiveRecordID == null;
	}

}
