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

package replics.net.services;

import replics.data.IRecord;
import replics.data.IRecordID;
import replics.data.ITagRecord;

/**
 * create a new Record's content and send it to the group 
 * Management of the synchronization of tags and replicates between peers inside a replication group.
 *
 * @author 
 */
public interface IRecordManager {
	
	/**
	 * 
	 * Ask the groups the missing records  
	 * notified : the peerGroupID is contained in the RecordId
	 * 
	 * @param records
	 */
	public void askForRecords(IRecordID records) ;
    
    /**
     * Ask the peer the missing tags
     * @param tagRecord
     */
    public void askForTags(ITagRecord tagRecord) ;
    
    /**
     * Add a record from a local registration or from a response of a peer (loading of missing records)
     * @param record
     * @return
     */
    public boolean addNewRecord(IRecord record);
    
    
}
