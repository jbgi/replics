package secolaman.net;

import secolaman.data.MetaMatcher;
import secolaman.data.Ressource;

public interface Subscriber {

	public MetaMatcher getMatcher();

	public String getName();

	public void handle(Ressource ressource);

	public void setMatcher(MetaMatcher matcher);

}
