package replics.impl.net.services;

import replics.net.services.IRecordQuotaManager;

public class RecordQuotaManager implements IRecordQuotaManager {

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
