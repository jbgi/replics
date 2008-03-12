package replics.impl.net.messages;

import replics.ids.IGroupID;
import replics.ids.IPeerID;
import replics.net.messages.IPeerGroupAdvertisement;
import replics.net.messages.IRecordStatus;
import replics.net.messages.MessageType;

public class PeerGroupAdvertissement extends Message implements IPeerGroupAdvertisement {

	private IRecordStatus recordStatus;

	public IRecordStatus getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(IRecordStatus recordStatus) {
		this.recordStatus = recordStatus;
	}

	public MessageType getMessageType() {
		return MessageType.PEER_GROUP_ADVERTISSEMENT;
	}
	
}