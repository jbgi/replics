package replics.net.protocol;

import replics.net.messages.IMessage;
import replics.net.messages.MessageType;

public interface IMessageMailer {

	public void register(IMessageListener messageListener, MessageType typeOfMessage);
	
	public void send(IMessage message);
	
}
