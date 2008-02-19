package replics.net.protocol;

import replics.net.messages.IMessage;

public interface IMessageListener {

	public void handleMessage(IMessage message);

}
