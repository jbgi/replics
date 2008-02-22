package replics.net.protocol;

import replics.net.messages.IMessage;

public interface IMessageListener {

	/**
	 * This method implements the processing of a received message 
	 * @param message
	 */
	public void handleMessage(IMessage message);

}
