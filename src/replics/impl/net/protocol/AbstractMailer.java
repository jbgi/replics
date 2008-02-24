package replics.impl.net.protocol;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util. Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.WeakHashMap;

import javax.lang.model.type.NullType;

import replics.impl.services.ReplicsService;
import replics.net.messages.IMessage;
import replics.net.messages.MessageType;
import replics.net.protocol.IMessageListener;
import replics.net.protocol.IMessageMailer;

public abstract class AbstractMailer extends ReplicsService implements IMessageMailer, Runnable {
	
	private Thread worker;
	
	private List<IMessage> receptionQueue = new Vector<IMessage>();
	
	private Map<String, Set<String>> lastReceivedMessages = new WeakHashMap<String, Set<String> >(500);
	
	private Map<MessageType, Set<IMessageListener> > listeners = new EnumMap<MessageType, Set<IMessageListener>>(MessageType.class);
	
	public void register(IMessageListener messageListener,
			MessageType typeOfMessage) {
		synchronized (listeners) {
			Set<IMessageListener> typeListners = listeners.get(typeOfMessage);
			if (null == typeListners)
			{
				typeListners = new HashSet<IMessageListener>();
				typeListners.add(messageListener);
				listeners.put(typeOfMessage, typeListners);
			}
			else {
				typeListners.add(messageListener);
			}
		}
	}
	
	public void unregister(IMessageListener messageListener,
			MessageType typeOfMessage) {
		synchronized (listeners) {
			listeners.get(typeOfMessage).remove(messageListener);
		}
	}
	
	private void prepare(IMessage message){
		message.setTTL(message.getTTL() - 1);
		message.setHops(message.getHops() + 1);
		message.setLastPropagaterPeerID(services.getPeerGroupManager().getLocalPeerID());
		message.setLastPropagatorView(services.getPeerGroupManager().getLocalPeerView());
	}
	
	public void send(IMessage message){
		prepare(message);
		sendUnmodified(message);
	}
	
	protected void earlyProcess(IMessage message) {
		
		services.getPeerGroupManager().updatePeerView(message.getLastPropagaterPeerID());
		Set<String> senders = lastReceivedMessages.get(message.getID());
		if (null != senders)
		{ 
			senders.add(message.getLastPropagaterPeerID());
		}
		else 
		{
			senders = new HashSet<String>();
			senders.add(message.getLastPropagaterPeerID());
			lastReceivedMessages.put(message.getID(), senders);
			receptionQueue.add(message);
			synchronized (worker) {
				worker.notify();
			}
		}
	}

	private void callListeners(IMessage message) {
		Set<IMessageListener> currentlisteners = listeners.get(MessageType.ANY);
		if (null != currentlisteners)
		{
			Iterator<IMessageListener> it = currentlisteners.iterator();
			while (it.hasNext())
			{
				it.next().handleMessage(message);
			}
		}
		currentlisteners = listeners.get(message.getMessageType());
		if (null != currentlisteners)
		{
			Iterator<IMessageListener> it = currentlisteners.iterator();
			while (it.hasNext())
			{
				it.next().handleMessage(message);
			}
		}
	}
	
	public Set<String> getSendersOf(String messageID)
	{
		Set<String> senders = lastReceivedMessages.get(messageID);
		if (null != senders)
		{
			return new HashSet<String>(senders);
		}
		else {
			return new HashSet<String>();
		}
	}
	
	protected void initialize()
	{
		worker = new Thread(this);
		worker.start();
	}
	
	public void run()
	{
		Iterator<IMessage> it;
		boolean finished;
		while(true)
		{
			finished = true;
			it = receptionQueue.iterator();
			try {
				while (it.hasNext()) {
					IMessage message = it.next();
					if (message.getDestPeerID() != services
							.getPeerGroupManager().getLocalPeerID()
							|| !services.getPeerGroupManager().getAllGroupIDs()
									.contains(message.getDestGroupID())) {
						services.getMessagePropagator().propagate(message);
					}
					callListeners(message);
					it.remove();
				}
			} catch (Exception e) { 
				e.printStackTrace();
				//finished = false;
				}
			if (finished) {
				synchronized (worker) {
					try {
						worker.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
}
