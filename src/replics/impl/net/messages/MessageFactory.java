package replics.impl.net.messages;

import java.util.Random;

import replics.ids.IGroupID;
import replics.ids.IPeerID;
import replics.impl.services.ReplicsService;
import replics.net.messages.IMessage;
import replics.net.messages.IMessageFactory;
import replics.net.messages.IPeerGroupAdvertisement;
import replics.net.messages.IRecordStatus;
import replics.net.messages.ITagMessage;
import replics.net.messages.ITextMessage;
import replics.net.services.IPeerGroupManager;

public class MessageFactory extends ReplicsService implements IMessageFactory {
	
	private Random randomizer = new Random();
	
	protected void initialize() {
	}

	public IPeerGroupAdvertisement newPeerGroupAdvertisement() {
		return (IPeerGroupAdvertisement) getPrepared(new PeerGroupAdvertissement()); 
	}
	
	public ITextMessage newTextMessage()
	{
		return (ITextMessage) getPrepared(new TextMessage()); 
	}
	
	private Message getPrepared(Message message)
	{
		message.setSourcePeerID(services.getPeerGroupManager().getLocalPeerID());
		message.setSourcePeerName(services.getPeerGroupManager().getLocalPeerName());
		message.setID(services.getPeerGroupManager().getLocalPeerID() + ":" + randomizer.nextLong());
		return message;
	}

}
