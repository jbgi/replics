package replics.services;

import replics.data.IDataProvider;
import replics.net.protocol.IMessageMailer;
import replics.net.services.IMembershipService;
import replics.net.services.IPeerGroupManager;
import replics.net.services.IRecordComparator;
import replics.net.services.IRecordManager;
import replics.net.services.IRecordQuotaManager;

public interface IServiceManager {

	public IDataProvider getDataProvider();
	
	public IPeerGroupManager getPeerGroupManager();
	
	public IMembershipService getMembershipService();
	
	public IRecordManager getRecordManager();
	
	public IRecordComparator getRecordComparator();
	
	public IMessageMailer getMessageMailer();
	
	public IRecordQuotaManager getRecordQuotaManager();
}
