package replics.impl.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import replics.services.IReplicsService;
import replics.services.IServiceManager;

public abstract class ReplicsService implements IReplicsService {

	protected IServiceManager services;
	
	protected Logger logger;
	
	public void initialize(IServiceManager serviceManager){
		this.services = serviceManager;
		this.logger = services.getLogger();
		initialize();
	}
	
	protected abstract void  initialize();
	
}
