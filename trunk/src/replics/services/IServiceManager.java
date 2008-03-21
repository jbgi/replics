package replics.services;

import java.util.logging.Logger;

import org.clapper.util.config.Configuration;

import replics.net.services.IMembershipService;
import replics.net.services.IRecordComparator;
import replics.net.services.IRecordManager;
import replics.net.services.IRecordQuotaManager;
import secolaman.Connector;

public interface IServiceManager {
	
	public Connector getConnector();
	
	public IMembershipService getMembershipService();
	
	public IRecordManager getRecordManager();
	
	public IRecordComparator getRecordComparator();
	
	public IRecordQuotaManager getRecordQuotaManager();
	
	public ISerializer getSerializer();
	
	public Logger getLogger();
	
	public Configuration getConfig();
	
	public void shutdown();
	
}
