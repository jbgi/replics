package replics.impl.net.protocol;

import replics.impl.services.ReplicsService;
import replics.net.messages.IMessage;
import replics.net.messages.MessageType;
import replics.net.protocol.IMessageListener;
import replics.net.protocol.IMessageMailer;

public class JGroupMailer extends ReplicsService implements IMessageMailer,  {

	public void register(IMessageListener messageListener,
			MessageType typeOfMessage) {
		// TODO Auto-generated method stub

	}

	public void send(IMessage message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

}
