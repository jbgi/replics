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

import org.w3c.dom.Document;

import replics.data.IFullRecord;
import replics.data.IMetaRecord;

public class FullRecord extends Record implements IFullRecord {
	
	String hash;
	IMetaRecord metaRecord;
	Document xmlCivilRecord;
	
	public String getHash() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public IMetaRecord getMetaRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	public Document getXMLcivilRecord() {
		// TODO Auto-generated method stub
		return null;
	}

}
