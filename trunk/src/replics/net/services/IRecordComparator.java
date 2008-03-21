package replics.net.services;

import replics.services.IReplicsService;
import secolaman.data.Ressource;

public interface IRecordComparator extends IReplicsService {

	
	/**
	 * This method is called by the UI to check if a MetaRecord is a duplicate of a MetaRecord already in the data Base
	 * @param metaRecord
	 * @param listener
	 */
	public void checkMetaRecord(String listenerName, IComparisonListener listener, Ressource ressource);
	
	/**
	 * this method allows to have a registration of all the comparisons
	 * @param listener
	 */
	public void unRegisterListener(String listenerName);
	
}
