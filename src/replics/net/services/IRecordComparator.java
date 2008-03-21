package replics.net.services;

import replics.impl.data.MetaRecord;
import replics.services.IReplicsService;

public interface IRecordComparator extends IReplicsService {

	
	/**
	 * This method is called by the UI to check if a MetaRecord is a duplicate of a MetaRecord already in the data Base
	 * @param metaRecord
	 * @param listener
	 */
	public void checkMetaRecord(String listenerName, IComparisonListener listener, MetaRecord metaRecord);
	
	/**
	 * this method allows to have a registration of all the comparisons
	 * @param listener
	 */
	public void unRegisterListener(String listenerName);
	
}
