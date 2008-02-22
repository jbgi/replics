package replics.impl.net.services;

import replics.impl.services.ReplicsService;
import replics.net.services.IRecordQuotaManager;
import replics.services.IServiceManager;

public class RecordQuotaManager extends ReplicsService implements IRecordQuotaManager {

	public int getNumberOfPossibleRecord() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isNewRecordAllowed() {
		// TODO Auto-generated method stub
		
		if(getNumberOfPossibleRecord() >= 10) return true;
		
		
		return false;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

}
