package replics.impl.net.services;

import replics.data.IRecord;
import replics.data.ITagRecord;
import replics.data.Tag;
import replics.ids.IRecordID;
import replics.impl.services.ReplicsService;
import replics.net.services.IRecordManager;

public class RecordManager extends ReplicsService implements IRecordManager {

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	public boolean addNewRecord(IRecord record) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addNewTag(ITagRecord tagRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addNewTag(IRecordID recordID, Tag tag) {
		// TODO Auto-generated method stub
		return false;
	}

	public void askForRecords(IRecordID records) {
		// TODO Auto-generated method stub

	}

	public void askForTags(ITagRecord tagRecord) {
		// TODO Auto-generated method stub

	}

}
