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
 * Interface for the representation of the meta part of a record. The meta part
 * define bio-metric data to identify a unique individual, but it should not be
 * possible to easily associated those bio-metric data with a particular known
 * individual.
 * 
 * @author Jean-Baptiste Giraudeau
 */
public interface IMetaRecord extends IRecord {

	/**
	 * Return a binary representation of a finger-print, It can be the
	 * finger-print image itself or the result of a hash function on this image
	 * (better, more difficult).
	 * 
	 * @return a byte array of the finger-print representation.
	 */
	public byte[] getFingerPrint();

	/**
	 * Return the height of the individual, used for the creation of a sample
	 * pool before the time-consuming finger-print comparison.
	 * Probably, better criteria should be considered for this first selection.
	 * 
	 * @return the height of the individual.
	 */
	public float getHeight();

}
