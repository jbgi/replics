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

import java.util.Date;

import replics.ids.IRecordID;
import replics.data.ITagRecord;
import replics.data.Tag;
import replics.ids.ITagID;

public class TagRecord extends Record implements ITagRecord {


	String comments;
	Date date;
	String peerID;
	Tag tag;
	Tag tag2;
	String hash;
	IRecordID recordID;
	String peerID2;
	
	
	public TagRecord(String comments, Date date, String peerID, Tag tag,
			String hash) {
		super();
		this.comments = comments;
		this.date = date;
		this.peerID = peerID;
		this.tag = tag;
		this.hash = hash;
	}


	
	public TagRecord(IRecordID recordID, String peerID2, Tag tag2) {
		super();
		this.recordID=recordID;
		this.peerID2=peerID2;
		this.tag2=tag2;
	}


	public String getComments() {
		// TODO Auto-generated method stub
		return comments;
	}

	
	public Date getDate() {
		// TODO Auto-generated method stub
		return date;
	}

	
	public String getPeerID() {
		// TODO Auto-generated method stub
		return peerID;
	}

	public Tag getTag() {
		// TODO Auto-generated method stub
		return tag;
	}

	
	public String getHash() {
		// TODO Auto-generated method stub
		return hash;
	}

	public ITagID getTagID() {
		// TODO Auto-generated method stub
		return null;
	}

}
