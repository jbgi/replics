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

import java.io.File;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import replics.ids.IGroupID;
import replics.ids.IPeerID;
import replics.ids.IRecordID;
import replics.ids.ITagID;
import replics.services.IReplicsService;

/**
 * Interface used to retrieve and store information from/to the database.
 * 
 * Only one instance of this interface for the whole application, thus the
 * implementation must be thread-safe.
 * 
 * @author Jean-Baptiste Giraudeau
 */
public interface IDataProvider extends IReplicsService {

	public Collection<String> getMatchingRecords(Map<String, String> tagMatcher);
	
	public Collection<String> getMatchingRecords(Map<String, String> tagMatcher, int sinceRevision);
	
	public int getRevision();
	
	public Map<String, String> getTagsForRecord(String recordID);
	
	public File getFile(String recordID);
	
	public void deleteRecord(String recordID);
	
	public void deleteFileForRecord(String recordID);
	
	public boolean recordExists(String recordID);
	
	public String saveRecord(String recordID, File file, Map<String, String> tags);
	
	public String saveRecord(String recordID, byte[] file, Map<String, String> tags);
	
}
