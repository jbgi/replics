package replics.impl.net.messages;

import replics.ids.IGroupID;
import replics.ids.IPeerID;
import replics.ids.IRecordID;
import replics.impl.data.MetaRecord;
import replics.impl.data.RecordID;
import replics.net.messages.IComparisonResponse;
import replics.net.messages.MessageType;

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

	public MessageType getMessageType() {
		return MessageType.COMPARISON_RESPONSE;
	}

}