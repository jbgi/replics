package replics.impl.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

import org.clapper.util.config.Configuration;
import org.clapper.util.config.ConfigurationException;

import replics.data.IDataProvider;
import replics.impl.data.DerbyDataProvider;
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
import replics.services.IReplicsService;
import replics.services.ISerializer;
import replics.services.IServiceManager;
import secolaman.Connector;

public class DefaultServiceManager implements IServiceManager {

	private Connector connector;
	private IMembershipService membershipService;
	private IRecordComparator recordComparator;
	private IRecordManager recordManager;
	private IRecordQuotaManager recordQuotaManager;
	private ISerializer serializer;
	private Logger logger;
	private Configuration config;
	private String configFilePath;
	
	private IReplicsService[] services = {membershipService, recordComparator,
			recordManager, recordQuotaManager, serializer};
	
	public DefaultServiceManager() {}
	
	public DefaultServiceManager(String configFilePath)
	{
		this.configFilePath = configFilePath;
	}

	public IMembershipService getMembershipService() {
		if (null == membershipService)
		{
			membershipService = new MembershipService();
			membershipService.initialize(this);
		}
		return membershipService;
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
		}
		return logger;
	}

	public Configuration getConfig() {
		if (null == config)
		{
			File configFile;
			if (null != configFilePath) {
				configFile = new File(configFilePath);
				if (!configFile.exists())
				{
					configFile = new File(configFilePath + File.separator + "config");
				}
			}
			else {
				configFile = new File(System.getProperty("user.home") + File.separator + ".replics" + File.separator + "config");
			}
			
			if (!configFile.exists())
			{
				configFile.getParentFile().mkdirs();
				try {
					configFile.createNewFile();
				} catch (IOException e) { e.printStackTrace(); }
			}
			
			config = new Configuration();
			try {
				config.load(configFile);
			} catch (Exception e) {	e.printStackTrace(); }
		}
		return config;
	}

	public void shutdown() {
		for (int i = 0; i < services.length; i++)
		{
			if (null != services[i])
			{
				services[i].shutdown();
			}
		}
		if (null != config)
		{
			PrintWriter pw;
			try {
				pw = new PrintWriter(config.getConfigurationFileURL().getPath());
				config.write(pw);
				pw.flush();
				pw.close();
			} catch (Exception e) {	e.printStackTrace(); }
		}
		if (null != logger)
		{
			logger.info("Replics is shutting down now!");
		}
	}

	public Connector getConnector() {
		// TODO Auto-generated method stub
		return null;
	}

}
