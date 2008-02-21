/*
 *  Copyright 2008 École des Mines de Nantes.
 * 
 * This file is part of Replics.
 * 
 * Replics <http://replics.googlecode.com> is free software: 
 * you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 * 
 * Replics is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Replics.  If not, see <http://www.gnu.org/licenses/>.
 */

package replics.data;

import java.util.List;

import org.w3c.dom.Document;

import replics.IReplicsService;
import replics.ids.IGroupID;
import replics.ids.IPeerID;
import replics.ids.IRecordID;
import replics.ids.ITagID;

/**
 * Interface used to retrieve and store information from/to the database.
 * 
 * Only one instance of this interface for the whole application, thus the
 * implementation must be thread-safe. The use of a connection pool should
 * reduce the DB server stressing.
 * 
 * @author Jean-Baptiste Giraudeau
 */
public interface IDataProvider extends IReplicsService {


	/**
	 * Deletes a list of records from the local database.
	 * 
	 * @param recordIDs
	 *            recordIDs to be deleted.
	 */
	public void deleteRecords(List<IRecordID> recordIDs);

	/**
	 * Search method to retrieve matching records.
	 * 
	 * @param groupID
	 *            group owner ID of the records.
	 * @param minHeight
	 *            limit search to record ID above this number, included (can be
	 *            null).
	 * @param maxHeight
	 *            limit search to record ID under this number, included (can be
	 *            null).
	 * @param minHeight
	 *            maximum height, included (can be null).
	 * @param maxHeight
	 *            minimum height, included (can be null).
	 * 
	 * @return a List of IRecordID, ordered by increasing recordID.
	 */
	public List<IRecordID> findRecords(IGroupID groupID, Integer minRecordID,
			Integer maxRecordID, Float minHeight, Float maxHeight);

	/**
	 * Generic search method to retrieve matching records.
	 * 
	 * @param groupID
	 *            group owner ID of the records.
	 * @param minRecordID
	 *            limit search to record ID above this number, included (can be
	 *            null).
	 * @param maxRecordID
	 *            limit search to record ID under this number, included (can be
	 *            null).
	 * @param hasTag
	 *            records tagged with this tag (can be null).
	 * @param hasNotTag
	 *            records Not tagged with tag (can be null).
	 * 
	 * @return a List of IRecordID, ordered by increasing recordID.
	 */
	public List<IRecordID> findRecords(IGroupID groupID, Integer minRecordID,
			Integer maxRecordID, Tag hasTag, Tag hasNotTag);

	/**
	 * Retrieves the RecordID of the last stored record in the local database
	 * for a specific group.
	 * 
	 * @param groupID
	 *            ID of a group of record.
	 * 
	 * @return an IRecordID object or null if no record for this group exist in
	 *         the local database.
	 */
	public IRecordID getLastRecordIdForGroup(IGroupID groupID);

	/**
	 * Retrieves the last tag record stored in the local database for a specific
	 * group.
	 * 
	 * @param groupID
	 *            ID of a group of record.
	 * @return the last ITagRecord stored in the database for this group.
	 */
	public ITagRecord getLastTagRecordForGroup(IGroupID groupID);

	/**
	 * Retrieves the meta-record corresponding to this recordID.
	 * 
	 * @param recordID
	 *            recordID of the meta record.
	 * 
	 * @return an IMetaRecord object or null if not found.
	 */
	public IMetaRecord getMetaRecord(IRecordID recordID);

	/**
	 * Retrieves a list of tag record that have been saved after the given tag
	 * record, starting with the one saved just after and no more than
	 * numberOfTags. Tag records being limited to the ones in the same group
	 * than the given previousTagRecord.
	 * 
	 * @param previousTagRecord
	 *            the tag record preceding the returned list.
	 * @param numberOfTags
	 *            the maximum size of the returned list.
	 * 
	 * @return a list of tag record.
	 */
	public List<ITagRecord> getNextTagRecordsForGroup(IGroupID groupID,
			ITagID previousTagRecordID, int numberOfTags);

	/**
	 * Calculates an estimation of the number of new meta-record that can still
	 * be stored in the local database, from free memory and/or allowed quota.
	 * 
	 * @return the number of new meta-record left before database is full.
	 */
	public int getPossibleNewMetaRecord();

	/**
	 * Calculates an estimation of the number of new full record that can still
	 * be stored in the local database, from free memory and/or allowed quota.
	 * 
	 * @return the number of new record left before database is full.
	 */
	public int getPossibleNewRecord();

	/**
	 * Retrieves the full record corresponding to this recordID.
	 * 
	 * @param recordID
	 *            recordID the record.
	 * 
	 * @return an IRecord object or null if not found.
	 */
	public IRecord getRecord(IRecordID recordID);

	/**
	 * Retrieve the tag record identified by the given hash key.
	 * 
	 * @param tagHash
	 *            the unique hash key of a tag record.
	 * 
	 * @return an ItagRecord object or null if not found.
	 */
	public ITagRecord getTagRecord(IGroupID groupID, ITagID tagID);

	/**
	 * Test if a meta-record exists in the local database.
	 * 
	 * @param recordID
	 *            recordID object of a record.
	 * 
	 * @return true if meta-record exist in database.
	 */
	public boolean hasMetaRecord(IRecordID recordID);

	/**
	 * Test if a record exists in the local database and has all (encrypted)
	 * fields.
	 * 
	 * @param recordID
	 *            recordID object of a record.
	 * 
	 * @return true if the full record exists in database.
	 */
	public boolean hasRecord(IRecordID recordID);

	/**
	 * Test if a tag record exist in the local database.
	 * 
	 * @param hashTag
	 *            the unique hash key of a tag record.
	 * 
	 * @return true if the tag record exists.
	 */
	public boolean hasTag(IGroupID groupID, ITagID tagID);

	/**
	 * Test if a tag is associated with a record.
	 * 
	 * @param recordID
	 *            the ID of the record to test.
	 * @param tag
	 *            the tag that is checked for.
	 * 
	 * @return true if the tag is present for the record.
	 */
	public boolean isRecordTaggedWith(IRecordID recordID, Tag tag);

	/**
	 * Empty all the fields of a record not used in the meta-record.
	 * 
	 * @param recordIDs
	 *            list of records to be lightened.
	 */
	public void lightenRecords(List<IRecordID> recordIDs);

	/**
	 * Store a record (or meta-record or tag record) in the local database.
	 * 
	 * @param record
	 *            object to be saved.
	 */
	public void saveRecord(IRecord record);

}
