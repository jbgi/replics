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

package replics.impl.data;

import java.util.List;
import java.util.Observable;

import org.w3c.dom.Document;

import replics.IServiceManager;
import replics.data.IDataProvider;
import replics.data.IMetaRecord;
import replics.data.IRecord;
import replics.data.ITagRecord;
import replics.data.Tag;
import replics.ids.IGroupID;
import replics.ids.IRecordID;
import replics.ids.ITagID;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.PooledConnection;



public class MySqlDataProvider implements IDataProvider {
	
	public void deleteRecords(List<IRecordID> recordIDs) {
		// TODO Auto-generated method stub
		
	}
	
	public List<IRecordID> findRecords(IGroupID groupID, Integer minRecordID,
			Integer maxRecordID, Float minHeight, Float maxHeight) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<IRecordID> findRecords(IGroupID groupID, Integer minRecordID,
			Integer maxRecordID, Tag hasTag, Tag hasNotTag) {
		// TODO Auto-generated method stub
		return null;
	}

	public IRecordID getLastRecordIdForGroup(IGroupID groupID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ITagRecord getLastTagRecordForGroup(IGroupID groupID) {
		// TODO Auto-generated method stub
		return null;
	}

	public IMetaRecord getMetaRecord(IRecordID recordID) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<ITagRecord> getNextTagRecordsForGroup(IGroupID groupID,
			ITagID previousTagRecordID, int numberOfTags) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getPossibleNewMetaRecord() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getPossibleNewRecord() {
		// TODO Auto-generated method stub
		return 0;
	}


	public IRecord getRecord(IRecordID recordID) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ITagRecord getTagRecord(IGroupID groupID, ITagID tagID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean hasMetaRecord(IRecordID recordID) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasRecord(IRecordID recordID) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean hasTag(IGroupID groupID, ITagID tagID) {
		// TODO Auto-generated method stub
		return false;
	}

	public void initialize(IServiceManager serviceManager) {
		// TODO Auto-generated method stub
		
	}

	public boolean isRecordTaggedWith(IRecordID recordID, Tag tag) {
		// TODO Auto-generated method stub
		return false;
	}


	public void lightenRecords(List<IRecordID> recordIDs) {
		// TODO Auto-generated method stub
		
	}

	public void saveRecord(IRecord record) {
		// TODO Auto-generated method stub
		
	}

}
