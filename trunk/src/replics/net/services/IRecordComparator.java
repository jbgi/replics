package replics.net.services;

import replics.data.IMetaRecord;

public interface IRecordComparator {

	public void checkMetaRecord(IMetaRecord metaRecord);
	
	public void checkMetaRecord(IMetaRecord metaRecord, IComparisonListener listener);
	
	public void registerListener(IComparisonListener listener);
	
}
