package replics.impl.net.messages;

import replics.ids.IGroupID;
import replics.ids.IPeerID;
import replics.net.messages.IPeerGroupAdvertisement;
import replics.net.messages.IRecordStatus;

public class PeerGroupAdvertissement extends Message implements IPeerGroupAdvertisement {

	private IRecordStatus recordStatus;

	public PeerGroupAdvertissement(String sourcePeerID, String destPeerID,
			String groupID, int hops, int ttl, IRecordStatus recordStatus) {
		super(sourcePeerID, destPeerID, groupID, hops, ttl);
		this.recordStatus = recordStatus;
	}

	public IRecordStatus getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(IRecordStatus recordStatus) {
		this.recordStatus = recordStatus;
	}
	
}
