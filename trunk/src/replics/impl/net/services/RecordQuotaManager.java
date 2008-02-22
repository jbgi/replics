package replics.impl.net.services;

import replics.impl.services.ReplicsService;
import replics.net.services.IRecordQuotaManager;
import replics.services.IServiceManager;

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
