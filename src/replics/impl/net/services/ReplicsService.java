package replics.impl.net.services;

import replics.IReplicsService;
import replics.IServiceManager;

public abstract class ReplicsService implements IReplicsService {

	protected IServiceManager services;
	
	public void initialize(IServiceManager serviceManager){
		this.services = serviceManager;
		initialize();
	}
	
	protected abstract void  initialize();
	
}
