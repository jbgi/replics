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

package replics.net.services;

import java.util.Map;
import replics.services.IReplicsService;

/**
 * create a new Record's content and send it to the group 
 * Management of the synchronization of tags and replicates between peers inside a replication group.
 *
 * @author 
 */
public interface IRecordManager extends IReplicsService {
	
	public void save(Map<String, String> metaData, Object object);
	
}
