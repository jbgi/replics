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

package replics.ids;

import java.io.Serializable;

/**
 * Very light structure used to identify a specific record in the whole network.
 * For a given group ID, the record id is a unique number. this number is
 * auto-incremented at each creation of a record.
 * 
 * @author Jean-Baptiste Giraudeau
 */
public interface IRecordID {

	
	/**
	 * Group ID getter. A group ID is a 66 character long string.
	 *  
	 * @return the ID of the group owner for the record. 
	 */
	public String getGroupID();

	
	/**
	 * Record ID getter, identifying a record inside a given group 
	 * (at most 8 digits).
	 * 
	 * @return the ID of the record inside the group.
	 */
	public int getRecordID();

}
