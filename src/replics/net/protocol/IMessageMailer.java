package replics.net.protocol;

import replics.net.messages.IMessage;
import replics.net.messages.MessageType;

public interface IMessageMailer {

	public void register(IMessageListener messageListener, MessageType typeOfMessage);
	
	/**
	 * that method is a protocol to send Messages to a peer or a group, it depends on the framwork chosen
	 * @param message
	 */
	public void send(IMessage message);
	
}
