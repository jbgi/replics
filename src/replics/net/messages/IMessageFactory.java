package replics.net.messages;

import replics.ids.IGroupID;
import replics.ids.IPeerID;
import replics.services.IReplicsService;

public interface IMessageFactory extends IReplicsService {

	// classe de création des messages (tous les constructeurs de messages seront appelés uniquement dans cette classe)
	// On a don une méthode par type de message qui fait appelle au constructeur correspondant (nommée createNomDuMessage())
	
	public IPeerGroupAdvertisement newPeerGroupAdvertisement();
	
	public ITextMessage newTextMessage();
		
}
