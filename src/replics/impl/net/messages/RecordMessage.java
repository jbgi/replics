package replics.impl.net.messages;

import java.util.Set;

import replics.data.IRecord;
import replics.ids.IRecordID;
import replics.net.messages.IRecordMessage;
import replics.net.messages.MessageType;

public class RecordMessage implements IRecordMessage {

	public IRecord record;
	
	public IRecord getRecord() {
		return this.record;
	}

	public IRecordID getRecordID() {
		return this.record.getRecordID();
	}

	public boolean isFullRecord() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isRecordPresent() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setIsFullRecord(boolean isFullRecord) {
		// TODO Auto-generated method stub

	}

	public void setRecord(IRecord record) {
		// TODO Auto-generated method stub

	}

	public void setRecordID(IRecordID recordID) {
		// TODO Auto-generated method stub

	}

	public String getDestGroupID() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDestPeerID() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getHops() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLastPropagaterPeerID() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getLastPropagatorView() {
		// TODO Auto-generated method stub
		return null;
	}

	public MessageType getMessageType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSourcePeerID() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSourcePeerName() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getTTL() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setDestGroupID(String destGroupID) {
		// TODO Auto-generated method stub

	}

	public void setDestPeerID(String destPeerID) {
		// TODO Auto-generated method stub

	}

	public void setHops(int hops) {
		// TODO Auto-generated method stub

	}

	public void setLastPropagaterPeerID(String peerID) {
		// TODO Auto-generated method stub

	}

	public void setLastPropagatorView(Set<String> peerView) {
		// TODO Auto-generated method stub

	}

	public void setTTL(int ttl) {
		// TODO Auto-generated method stub

	}

}
