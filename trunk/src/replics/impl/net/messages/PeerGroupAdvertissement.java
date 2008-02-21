package replics.impl.net.messages;

import replics.net.messages.IPeerGroupAdvertisement;
import replics.net.messages.IRecordStatus;

public class PeerGroupAdvertissement extends Message implements IPeerGroupAdvertisement {

	private IRecordStatus recordStatus;

	public IRecordStatus getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(IRecordStatus recordStatus) {
		this.recordStatus = recordStatus;
	}
	
}
