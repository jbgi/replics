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

import java.io.Serializable;
import java.util.Date;

import replics.ids.ITagID;

/**
 * Interface for tag records. A tag qualify a record with some information (most
 * import one is if the record have been saved on the backup server). Note that
 * any member of a group can emit a tag for a record of this group, not just the
 * owner. Also multiple tags can be associated with a single record.
 * 
 * @author Jean-Baptiste Giraudeau
 */
public interface ITagRecord extends IRecord {

	public ITagID getTagID();
	
	/**
	 * Returns optional comments about the tag.
	 * 
	 * @return a comment string or null.  
	 */
	public String getComments();

	/**
	 * Returns the date of the first creation of this tag. (not the date of local replication of the record)
	 * 
	 * @return date of creation of the tag.
	 */
	public Date getDate();

	/**
	 * Returns the tag itself.
	 * 
	 * @return the tag of this tag record.
	 */
	public Tag getTag();

}
