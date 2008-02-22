package replics.net.services;

import replics.data.IMetaRecord;
import replics.services.IReplicsService;

public interface IRecordComparator extends IReplicsService {

	
	/**
	 * This method is called by the UI to check if a MetaRecord is a duplicate of a MetaRecord already in the data Base
	 * @param metaRecord
	 * @param listener
	 */
	public void checkMetaRecord(IMetaRecord metaRecord, IComparisonListener listener);
	
	/**
	 * this method allows to have a registration of all the comparisons
	 * @param listener
	 */
	public void registerListener(IComparisonListener listener);
	
}
