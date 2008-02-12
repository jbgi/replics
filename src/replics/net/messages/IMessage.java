package replics.net.messages;

import net.jxta.document.Document;

public interface IMessage extends Cloneable {

	public String getGroupID();
	
	public String getPeerID();
	
	public Document getDocument();
	
	public int getHops();
	
	public void setGroupId ();
	
	public void setDocument(); 
	
}
