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

/**
 * Enumeration of possible tag for a tag record. The order is very important and
 * cannot be change without causing inconsistency in tag records.
 * 
 * @author Jean-Baptiste Giraudeau
 */
public enum Tag {

	/**
	 * Another record already existed with matching bio-metric data.
	 */
	DUPLICATION_ATTEMPT,

	/**
	 * The record have been invalidated by the verification server and should be
	 * re-issued.
	 */
	INVALID,

	/**
	 * The record have been asked to be re-printed, probably because of printing
	 * problems.
	 */
	SECOND_PRINT,

	/**
	 * The record have been saved on the central backup server, and so is
	 * candidate for lightening/deletion.
	 */
	SECURED;

}
