package replics.impl.data;

import java.util.List;

import org.w3c.dom.Document;

import replics.data.IDataProvider;
import replics.data.IMetaRecord;
import replics.data.IRecord;
import replics.data.IRecordID;
import replics.data.ITagRecord;
import replics.data.Tag;

public class MySqlDataProvider implements IDataProvider {

	@Override
	public IRecord createFromEncryptedXML(Document xmlEncryptedRecord,
			IMetaRecord metaRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMetaRecord createFromXML(Document xmlMetaRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRecordID createRecordID(String groupID, int recordID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITagRecord createTagRecord(IRecordID recordID, String PeerID, Tag tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecords(List<IRecordID> recordIDs) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<IRecordID> findRecords(String groupID, Integer minRecordID,
			Integer maxRecordID, Float minHeight, Float maxHeight) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IRecordID> findRecords(String groupID, Integer minRecordID,
			Integer maxRecordID, Tag hasTag, Tag hasNotTag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRecordID getLastRecordIdForGroup(String groupID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITagRecord getLastTagRecordForGroup(String groupID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMetaRecord getMetaRecord(IRecordID recordID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ITagRecord> getNextTagRecordsForGroup(
			ITagRecord previousTagRecord, int numberOfTags) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPossibleNewMetaRecord() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPossibleNewRecord() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IRecord getRecord(IRecordID recordID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITagRecord getTagRecord(String tagHash) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasMetaRecord(IRecordID recordID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasRecord(IRecordID recordID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasTag(String hashTag) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isRecordTaggedWith(IRecordID recordID, Tag tag) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void lightenRecords(List<IRecordID> recordIDs) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveMetaRecord(IMetaRecord metaRecord) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveRecord(IRecord record) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveTagRecord(ITagRecord tagRecord) {
		// TODO Auto-generated method stub

	}

}
