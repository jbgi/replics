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

package replics.facade;

/**
 * Enumeration of possible members involved in the registration process. 
 * 
 * @author Ginna Arango
 */
public enum ErrorTag {

	/**
	 * 
	 */
	ADMIN_VALID,

	/**
	 * 
	 */
	ADMIN_NOT_VALID,

	/**
	 * 
	 */
	ADMIN_NOT_EXISTS,
	
	/**
	 * 
	 */
	ADMIN_REGISTERED,

	/**
	 * 
	 */
	ADMIN_ALREADY_REGISTERED,
	
	/**
	 * 
	 */
	LOGIN_NOT_AVAILABLE,
	
	/**
	 * 
	 */
	PASSWORD_CHANGED,
	
	/**
	 * 
	 */
	PASSWORD_NOT_VALID,
	
	/**
	 * 
	 */
	MEMBER_VALID,

	/**
	 * 
	 */
	MEMBER_NOT_VALID,

	/**
	 * 
	 */
	MEMBER_NOT_EXISTS,
	
	/**
	 * 
	 */
	MEMBER_REGISTERED,

	/**
	 * 
	 */
	MEMBER_ALREADY_REGISTERED,
	
	/**
	 * 
	 */
	MEMBER_REMOVED,
	
	/**
	 * 
	 */
	MEMBER_NOT_REMOVED,
	
	/**
	 *
	 */
	USER_REGISTERED,
	
	/**
	 *
	 */
	USER_ALREADY_REGISTERED,

	/**
	 *
	 */
	INVALID_DATA,
	
	/**
	 *
	 */
	SESSION_CREATED,
	
	/**
	 *
	 */
	SESSION_NOT_CREATED;
}

