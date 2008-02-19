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

import org.w3c.dom.Document;

/**
 * Generic interface for all records, it extends Serializable but future version
 * will not, when XML serialization is fast and reliable.
 * 
 * @author Jean-Baptiste Giraudeau
 */
public interface IRecord extends Serializable {

	/**
	 * Return an hash string computed from all fields (SHA1 or MD5 hash
	 * function). The computed hash is used to determine either the integrity or
	 * the uniqueness of the record.
	 * 
	 * @return a hash string for the record.
	 */
	public String getHash();

	/**
	 * Return the ID of the record this tag record or meta-record is qualifying. This
	 * corresponding record does not necessarily exist in the database.
	 * 
	 * @return an IRecordID object.
	 */
	public IRecordID getRecordID();

	/**
	 * Serialize the record using XML.
	 * 
	 * @return a string being a valid XML document.
	 */
	public String getXML();

	/**
	 * Return the XML document object for this record. Result is an already
	 * parsed equivalent of getXML().
	 * 
	 * @return an XML document representation of this record.
	 */
	public Document getXMLdocument();

}
