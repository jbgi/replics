package replics.impl.services;

import replics.services.IReplicsService;
import replics.services.IServiceManager;

public abstract class ReplicsService implements IReplicsService {

	protected IServiceManager services;
	
	public void initialize(IServiceManager serviceManager){
		this.services = serviceManager;
		initialize();
	}
	
	protected abstract void  initialize();
	
}
