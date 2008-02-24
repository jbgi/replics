package replics.impl.services;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

import replics.data.IDataProvider;
import replics.impl.data.MySqlDataProvider;
import replics.impl.net.messages.MessageFactory;
import replics.impl.net.protocol.JGroupMailer;
import replics.impl.net.services.MembershipService;
import replics.impl.net.services.PeerGroupManager;
import replics.impl.net.services.Propagator;
import replics.impl.net.services.RecordComparator;
import replics.impl.net.services.RecordManager;
import replics.impl.net.services.RecordQuotaManager;
import replics.net.messages.IMessageFactory;
import replics.net.protocol.IMessageMailer;
import replics.net.services.IMembershipService;
import replics.net.services.IPeerGroupManager;
import replics.net.services.IPropagator;
import replics.net.services.IRecordComparator;
import replics.net.services.IRecordManager;
import replics.net.services.IRecordQuotaManager;
import replics.services.ISerializer;
import replics.services.IServiceManager;

public class DefaultServiceManager implements IServiceManager {

	private IDataProvider dataProvider;
	private IMembershipService membershipService;
	private IPeerGroupManager peerGroupManager;
	private IRecordComparator recordComparator;
	private IRecordManager recordManager;
	private IMessageMailer messageMailer;
	private IRecordQuotaManager recordQuotaManager;
	private ISerializer serializer;
	private Logger logger;
	private IPropagator propagator;
	private IMessageFactory messageFactory;
	
	public IDataProvider getDataProvider() {
		if (null == dataProvider)
		{
			dataProvider = new MySqlDataProvider();
			dataProvider.initialize(this);
		}
		return dataProvider;
	}

	public IMembershipService getMembershipService() {
		if (null == membershipService)
		{
			membershipService = new MembershipService();
			membershipService.initialize(this);
		}
		return membershipService;
	}

	public IPeerGroupManager getPeerGroupManager() {
		if (null == peerGroupManager)
		{
			peerGroupManager = new PeerGroupManager();
			peerGroupManager.initialize(this);
		}
		return peerGroupManager;
	}

	public IRecordComparator getRecordComparator() {
		if (null == recordComparator)
		{
			recordComparator = new RecordComparator();
			recordComparator.initialize(this);
		}
		return recordComparator;
	}

	public IRecordManager getRecordManager() {
		if (null == recordManager)
		{
			recordManager = new RecordManager();
			recordManager.initialize(this);
		}
		return recordManager;
	}

	public IMessageMailer getMessageMailer() {
		if (null == messageMailer)
		{
			messageMailer = new JGroupMailer();
			messageMailer.initialize(this);
		}
		return messageMailer;
	}

	public IRecordQuotaManager getRecordQuotaManager() {
		if (null == recordQuotaManager)
		{
			recordQuotaManager = new RecordQuotaManager();
			recordQuotaManager.initialize(this);
		}
		return recordQuotaManager;
	}

	public ISerializer getSerializer() {
		if (null == serializer)
		{
			serializer = new XStreamSerializer();
			serializer.initialize(this);
		}
		return serializer;
	}
	
	public Logger getLogger() {
		if (null == logger)
		{
			logger = Logger.getLogger("replics.services");
			logger.addHandler(new ConsoleHandler());
		}
		return logger;
	}

	public IPropagator getMessagePropagator() {
		if (null == propagator)
		{
			propagator = new Propagator();
			propagator.initialize(this);
		}
		return propagator;
	}
	
	public IMessageFactory getMessageFactory() {
		if (null == messageFactory)
		{
			messageFactory = new MessageFactory();
			messageFactory.initialize(this);
		}
		return messageFactory;
	}

}
