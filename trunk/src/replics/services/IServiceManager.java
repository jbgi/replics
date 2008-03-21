package replics.services;

import java.util.logging.Logger;

import org.clapper.util.config.Configuration;

import replics.data.IDataProvider;
import replics.net.messages.IMessageFactory;
import replics.net.protocol.IMessageMailer;
import replics.net.services.IMembershipService;
import replics.net.services.IPeerGroupManager;
import replics.net.services.IPropagator;
import replics.net.services.IRecordComparator;
import replics.net.services.IRecordManager;
import replics.net.services.IRecordQuotaManager;

public interface IServiceManager {
	
	public IMembershipService getMembershipService();
	
	public IRecordManager getRecordManager();
	
	public IRecordComparator getRecordComparator();
	
	public IRecordQuotaManager getRecordQuotaManager();
	
	public ISerializer getSerializer();
	
	public Logger getLogger();
	
	public Configuration getConfig();
	
	public void shutdown();
}
