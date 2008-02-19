package replics.impl.net.services;

import replics.IServiceManager;
import replics.net.services.IRecordQuotaManager;

public class RecordQuotaManager extends ReplicsService implements IRecordQuotaManager {

	public RecordQuotaManager(IServiceManager serviceManager) {
		super(serviceManager);
		// TODO Auto-generated constructor stub
	}

	public int getNumberOfPossibleRecord() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isNewRecordAllowed() {
		// TODO Auto-generated method stub
		
		if(getNumberOfPossibleRecord() >= 10) return true;
		
		
		return false;
	}

}
