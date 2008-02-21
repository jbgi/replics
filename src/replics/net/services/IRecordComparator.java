package replics.net.services;

import replics.IReplicsService;
import replics.data.IMetaRecord;

public interface IRecordComparator extends IReplicsService {

	
	/**
	 * This method is called by the UI to check if a MetaRecord is a duplicate of a MetaRecord already in the data Base
	 * @param metaRecord
	 * @param listener
	 */
	public void checkMetaRecord(IMetaRecord metaRecord, IComparisonListener listener);
	
	public void registerListener(IComparisonListener listener);
	
}
