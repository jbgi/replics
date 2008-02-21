package replics.impl.net.services;

import replics.IServiceManager;
import replics.net.messages.IMessage;
import replics.net.messages.IPeerGroupAdvertisement;
import replics.net.messages.IRecordStatus;
import replics.net.messages.MessageType;
import replics.net.protocol.IMessageListener;

public class ReplicationManager extends ReplicsService implements IMessageListener{

	public ReplicationManager(IServiceManager serviceManager) {
		super(serviceManager);
		services.getMessageMailer().register(this, MessageType.PEER_GROUP_ADVERTISSEMENT);
	}

	public void handleMessage(IMessage message) {
		if (!(message instanceof IPeerGroupAdvertisement)
				&& !services.getRecordQuotaManager().isNewRecordAllowed()) {
			return;
		}
		IPeerGroupAdvertisement adv = (IPeerGroupAdvertisement) message;
		IRecordStatus remoteStatus = adv.getRecordStatus();
		IRecordStatus localStatus = services.getPeerGroupManager().getRecordStatus(adv.getGroupID(), adv.getSourcePeerID());
		
		if (remoteStatus.getLastRecordID() != localStatus.ge)
	}

}
