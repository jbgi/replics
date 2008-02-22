package replics.impl.net.services;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import replics.ids.IPeerID;
import replics.ids.ITagID;
import replics.impl.services.ReplicsService;
import replics.net.messages.IMessage;
import replics.net.messages.IPeerGroupAdvertisement;
import replics.net.messages.IRecordStatus;
import replics.net.messages.MessageType;
import replics.net.protocol.IMessageListener;
import replics.services.IServiceManager;

public class ReplicationManager extends ReplicsService implements IMessageListener {

	public void initialize() {
		services.getMessageMailer().register(this, MessageType.PEER_GROUP_ADVERTISSEMENT);
	}

	public void handleMessage(IMessage message) {
		if (!(message instanceof IPeerGroupAdvertisement)) {
			return;
		}
		
		boolean querySent = false;
		boolean responseSent = false;
		
		IPeerGroupAdvertisement adv = (IPeerGroupAdvertisement) message;
		IRecordStatus remoteStatus = adv.getRecordStatus();
		IRecordStatus localStatus = services.getPeerGroupManager().getRecordStatus(remoteStatus.getGroupID(), remoteStatus.getLastTagIDs().keySet());
		
		if (remoteStatus.getLastRecordID().getRecordID() < localStatus.getLastRecordID().getRecordID()
				|| remoteStatus.getFirstRecordID().getRecordID() > localStatus.getFirstRecordID().getRecordID())
		{
			sendRecordMessages(remoteStatus, localStatus);
			responseSent = true;
		}
		else if (remoteStatus.getLastRecordID().getRecordID() < localStatus.getLastRecordID().getRecordID()
				|| remoteStatus.getFirstRecordID().getRecordID() < localStatus.getFirstRecordID().getRecordID())
		{
			askForRecords(localStatus);
			querySent = true;
		}
		
		
		Iterator<Entry<IPeerID, ITagID>> remoteTagsIt = remoteStatus.getLastTagIDs().entrySet().iterator();
		Map<IPeerID, ITagID> localPeersTags = localStatus.getLastTagIDs();
		while (remoteTagsIt.hasNext())
		{
			if (responseSent && querySent){
				break;
			}
			Entry<IPeerID, ITagID> nextTag = remoteTagsIt.next();
			if (localPeersTags.containsKey(nextTag.getKey()))
			{
				ITagID localTagID = localPeersTags.get(nextTag.getKey());
				if (!responseSent && localTagID.getTagID() > nextTag.getValue().getTagID())
				{
					sendRecordMessages(remoteStatus, localStatus);
					responseSent = true;
				}
				else if (!querySent && localTagID.getTagID() > nextTag.getValue().getTagID())
				{
					askForRecords(localStatus);
					querySent = true;
				}
			}
			else if (!querySent)
			{
				askForRecords(localStatus);
				querySent = true;
			}
			
		}
	}

	private void askForRecords(IRecordStatus localStatus) {
		// TODO Auto-generated method stub
		
	}

	private void sendRecordMessages(IRecordStatus remoteStatus,
			IRecordStatus localStatus) {
		// TODO Auto-generated method stub
		
	}

}
