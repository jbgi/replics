package secolaman.net;

public interface GroupInfo {

	public String getDownloadDirectory();

	public String getMetaDataDirectory();

	public String getName();

	public String getPeerID();

	public String getPeerName();

	public boolean isHidden();

	public boolean isPasswordProtected();

	public boolean isSigned();

	public void setDownloadDirectory(String directory);

	public void setGroupName(String groupName);

	public void setHidden(boolean hidden);

	public void setMetaDataDirectory(String directory);

	public void setPassword(String password);

	public void setPeerID(String peerID);

	public void setPeerName(String peerName);

	public void signRecords(boolean signed);

}
