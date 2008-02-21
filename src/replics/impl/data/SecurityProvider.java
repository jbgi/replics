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

import replics.IServiceManager;
import replics.data.IRecord;
import replics.data.ISecurityProvider;

public class SecurityProvider implements ISecurityProvider {	
	
	public boolean checkPassword(String password) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean isUncorrupted(IRecord record) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Document passwordDecrypt(Document cryptedDocument) {
		// TODO Auto-generated method stub
		return null;
	}


	public String passwordDecrypt(String cryptedText) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Document passwordEncrypt(Document unCryptedDocument) {
		// TODO Auto-generated method stub
		return null;
	}

	public String passwordEncrypt(String unCryptedText) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Document privateDecrypt(Document cryptedDocument) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String privateDecrypt(String cryptedText) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Document publicEncrypt(Document unCryptedDocument) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String publicEncrypt(String unCryptedText) {
		// TODO Auto-generated method stub
		return null;
	}


	public void initialize(IServiceManager serviceManager) {
		// TODO Auto-generated method stub
		
	}

}
