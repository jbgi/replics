package replics.impl.net.messages;

import replics.net.messages.ITextMessage;
import replics.net.messages.MessageType;

public class TextMessage extends Message implements ITextMessage {

	private String content;
	
	private String peerName;
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}

	public MessageType getMessageType() {
		return MessageType.TEXT_MESSAGE;
	}

	public String getSourcePeerName() {
		return peerName;
	}
	
	public void setSourcePeerName(String peerName)
	{
		this.peerName = peerName;
	}

}
