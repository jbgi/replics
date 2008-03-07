package replics.impl.net.messages;

import replics.ids.IGroupID;
import replics.ids.IPeerID;
import replics.ids.IRecordID;
import replics.impl.data.MetaRecord;
import replics.net.messages.IComparisonQuery;
import replics.net.messages.MessageType;

public class ComparisonQuery extends Message implements IComparisonQuery {

	private IRecordID firstRecordID; 
	private IRecordID lastRecordID;
	private MetaRecord metaRecord;

	public IRecordID getFirstRecordID() {
		return firstRecordID;
	}
	public void setFirstRecordID(IRecordID firstRecordID) {
		this.firstRecordID = firstRecordID;
	}
	public IRecordID getLastRecordID() {
		return lastRecordID;
	}
	public void setLastRecordID(IRecordID lastRecordID) {
		this.lastRecordID = lastRecordID;
	}
	public MetaRecord getMetaRecord() {
		return metaRecord;
	}
	public void setMetaRecord(MetaRecord metaRecord) {
		this.metaRecord = metaRecord;
	}

	public MessageType getMessageType() {
		return MessageType.COMPARISON_QUERY;
	}
	
}