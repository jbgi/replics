package replics.net.services;

import replics.net.messages.IMessage;
import replics.services.IReplicsService;

public interface IPropagator extends IReplicsService {
	
	public void propagate(IMessage message);
	
}
