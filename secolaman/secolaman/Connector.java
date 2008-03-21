package secolaman;

import java.util.Set;

import secolaman.net.Group;
import secolaman.net.GroupInfo;
import secolaman.net.GroupSubscriber;

public interface Connector {

	public Group ConnectTo(GroupInfo groupInfo);

	public GroupInfo createGroupInfo();

	public void deleteGroup(Group group, boolean deleteFiles);

	public Set<GroupInfo> getDiscoveredGroups();

	public Set<Group> getGroups();

	public void register(String groupSubscriberName, GroupSubscriber subscriber);

	public void unregister(String groupSubscriberName);

}
