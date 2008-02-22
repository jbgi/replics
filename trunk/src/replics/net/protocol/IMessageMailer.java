package replics.net.protocol;

import replics.net.messages.IMessage;
import replics.net.messages.MessageType;
import replics.services.IReplicsService;

public interface IMessageMailer extends IReplicsService {

	public void register(IMessageListener messageListener, MessageType typeOfMessage);
	
	/**
	 * that method implements the communication layer to send Messages to a peer or a group, it depends on the framework chosen
	 * @param message
	 */
	public void send(IMessage message);
	
}
