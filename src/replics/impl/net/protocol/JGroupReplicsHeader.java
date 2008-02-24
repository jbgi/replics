package replics.impl.net.protocol;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.jgroups.Header;

public class JGroupReplicsHeader extends Header {

	private String xmlMessage;
	
	public JGroupReplicsHeader(String xmlMessage)
	{
		this.xmlMessage = xmlMessage;
	}
	
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		xmlMessage = in.readUTF();

	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(xmlMessage);
	}
	
	public String toString(){
		return xmlMessage;
	}
	
	public int size() {
        return xmlMessage.length();
    }

}
