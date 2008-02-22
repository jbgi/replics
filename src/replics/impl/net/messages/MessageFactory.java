package replics.impl.net.messages;

import replics.ids.IGroupID;
import replics.ids.IPeerID;
import replics.impl.services.ReplicsService;
import replics.net.messages.IMessageFactory;
import replics.net.messages.IPeerGroupAdvertisement;
import replics.net.messages.IRecordStatus;

public class MessageFactory extends ReplicsService implements IMessageFactory {

	private int defaultUnicastTTL = 1000;
	private int defaultMulticastTTL = 5;
	private int defaultHops = 0;
	
	private PeerGroupAdvertissement defaultPeerGroupAdvertissement = new PeerGroupAdvertissement()
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	public IPeerGroupAdvertisement createPeerGroupAdvertisement(
			IPeerID destPeerID, IGroupID groupID, IRecordStatus recordStatus) {
		return new PeerGroupAdvertissement
	}

}
