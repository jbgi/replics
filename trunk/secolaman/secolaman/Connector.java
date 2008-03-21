package secolaman;

import java.util.Set;

import secolaman.data.Ressource;
import secolaman.net.Group;
import secolaman.net.GroupInfo;
import secolaman.net.GroupSubscriber;

public interface Connector {

	public Group ConnectTo(GroupInfo groupInfo);

	public GroupInfo createGroup();

	public Ressource createRessource();

	public void deleteGroup(String groupName);

	public Set<GroupInfo> getDiscoveredGroups();

	public Set<Group> getGroups();

	public void register(String groupSubscriberName, GroupSubscriber subscriber);
	
	public void setGroupDiscoveringInterval(long discoveringInterval);
	
	public void unregister(String groupSubscriberName);

}
