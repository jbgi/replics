package replics.impl.net.messages;

import replics.net.messages.ITextMessage;
import replics.net.messages.MessageType;

public class TextMessage extends Message implements ITextMessage {

	private String content;
	
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

}
