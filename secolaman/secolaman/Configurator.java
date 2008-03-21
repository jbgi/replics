package secolaman;

import java.util.Set;

import secolaman.net.GroupInfo;

public class Configurator {

	private Set<GroupInfo> groupRegistered;

	private String serviceManager = "secolaman.impl.services.internal.StdServiceManager";

	public Set<GroupInfo> getGroupRegistered() {
		return groupRegistered;
	}

	public String getServiceManager() {
		return serviceManager;
	}

	public void setGroupRegistered(Set<GroupInfo> groupRegistered) {
		this.groupRegistered = groupRegistered;
	}

	public void setServiceManager(String serviceManager) {
		this.serviceManager = serviceManager;
	}

}
