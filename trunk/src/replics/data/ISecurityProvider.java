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

import replics.IReplicsService;

/**
 * Interface for all integrity and encryption methods. 
 * Only one instance will be used in the application.
 * 
 * @author Jean-Baptiste Giraudeau
 */
public interface ISecurityProvider extends IReplicsService {

	/**
	 * Check that the hash of the given password match the one in the configuration file. Save the password for future encryption uses if correct.
	 * 
	 * @param password the password given through the human interface.
	 * 
	 * @return true if the password is correct.
	 */
	public boolean checkPassword(String password);

	/**
	 * Check if a Record is not corrupted, by re-calculating the hash of the record and comparing with getHash().
	 *  
	 * @param record the record to check.
	 * @return true if record has not been corrupted.
	 */
	public boolean isUncorrupted(IRecord record);

	/**
	 * Symmetrical decrypting of a XML document, using local password.
	 * 
	 * @param cryptedDocument an XML document, encrypted using local password.
	 * 
	 * @return the uncrypted XML document.
	 */
	public Document passwordDecrypt(Document cryptedDocument);

	/**
	 * Symmetrical decrypting of a string, using local password.
	 * 
	 * @param cryptedText an encrypted string.
	 * 
	 * @return the uncrypted text.
	 */
	public String passwordDecrypt(String cryptedText);

	/**
	 * Symmetrical encrypting of a XML document, using local password.
	 * 
	 * @param unCryptedDocument an uncrypted XML document.
	 * 
	 * @return the XML document, encrypted using local password.
	 */
	public Document passwordEncrypt(Document unCryptedDocument);

	/**
	 * Symmetrical encrypting of a string, using local password.
	 * 
	 * @param unCryptedText an uncrypted string.
	 * 
	 * @return the crypted text.
	 */
	public String passwordEncrypt(String unCryptedText);

	/**
	 * Asymmetrical decrypting of a XML document, using the private key.
	 * (normaly only used on the server side)
	 * 
	 * @param cryptedDocument an XML document, encrypted using the public key.
	 * 
	 * @return the uncrypted XML document.
	 */
	public Document privateDecrypt(Document cryptedDocument);

	/**
	 * Asymmetrical decrypting of a string, using the private key.
	 * (normaly only used on the server side)
	 * 
	 * @param cryptedText a text encrypted using the public key.
	 * 
	 * @return the uncrypted text.
	 */
	public String privateDecrypt(String cryptedText);

	/**
	 * Asymmetrical encrypting of a string, using the public key.
	 * 
	 * @param unCryptedDocument an uncrypted XML document.
	 * 
	 * @return the XML document, crypted with the public key.
	 */
	public Document publicEncrypt(Document unCryptedDocument);

	/**
	 * Asymmetrical encrypting of a string, using the public key.
	 * 
	 * @param unCryptedText an uncrypted string.
	 * 
	 * @return the crypted text.
	 */
	public String publicEncrypt(String unCryptedText);

}
