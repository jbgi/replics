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

import org.w3c.dom.Document;

/**
 * Interface for the representation of a full record
 * (civil part and meta part)
 * 
 * @author Jean-Baptiste Giraudeau
 */
public interface IFullRecord extends IRecord {

	/**
	 * Returns the meta record part of this full record 
	 * 
	 * @return an IMetaRecord object.
	 */
	public IMetaRecord getMetaRecord();
	
	/**
	 * Returns the XML representation without the meta part.
	 * 
	 * @return an (encrypted) XML document.
	 */
	public Document getXMLcivilRecord();
	
}
