package replics.impl.net.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.WeakHashMap;

import javax.lang.model.type.NullType;

import replics.impl.services.ReplicsService;
import replics.net.messages.IMessage;
import replics.net.services.IPropagator;

public class Propagator extends ReplicsService implements IPropagator {

	private Map<String, NullType> lastPropagated = new WeakHashMap<String, NullType>(20);
	
	private List<IMessage> propagationQueue = new ArrayList<IMessage>();

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	public void propagate(IMessage message) {
		if (lastPropagated.containsKey(message.getID())
				|| message.getTTL() < 1
				|| message.getDestPeerID().equals(services.getPeerGroupManager().getLocalPeerID().getPeerID()))
		{
			return;
		}
		
		Set<String> extendedView = services.getMessageMailer().getSendersOf(message.getID());
		extendedView.addAll(message.getLastPropagatorView());
		if (extendedView.containsAll(
				services.getPeerGroupManager().getLocalPeerView()))
		{
			propagationQueue.add(message);
			return;
		}
		
		services.getMessageMailer().send(message);
	}
	
	

}
