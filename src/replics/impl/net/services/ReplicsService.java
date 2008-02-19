package replics.impl.net.services;

import replics.IServiceManager;

public abstract class ReplicsService {

	protected IServiceManager services;
	
	public ReplicsService(IServiceManager serviceManager){
		this.services = serviceManager;
	}
	
}
