package replics.impl.net.messages;

import replics.ids.IGroupID;
import replics.ids.IPeerID;
import replics.ids.IRecordID;
import replics.impl.data.MetaRecord;
import replics.impl.data.RecordID;
import replics.net.messages.IComparisonResponse;

public class ComparisonResponse extends Message implements IComparisonResponse {

	private IRecordID firstRecordID; 
	private IRecordID lastRecordID;
	private IRecordID comparedRecordID;
	private	IRecordID positiveRecordID;
		
	public ComparisonResponse(String sourcePeerID, String destPeerID,
			String groupID, int hops, int ttl, IRecordID firstRecordID,
			IRecordID lastRecordID, IRecordID comparedRecordID,
			IRecordID positiveRecordID) {
		super(sourcePeerID, destPeerID, groupID, hops, ttl);
		this.firstRecordID = firstRecordID;
		this.lastRecordID = lastRecordID;
		this.comparedRecordID = comparedRecordID;
		this.positiveRecordID = positiveRecordID;
	}

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
