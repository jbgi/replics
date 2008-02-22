package replics.data;

import org.w3c.dom.Document;

import replics.ids.IGroupID;
import replics.ids.IPeerID;
import replics.ids.IRecordID;
import replics.services.IReplicsService;

public interface IDataFactory extends IReplicsService{

	/**
	 * Creates the corresponding IRecordID object.
	 * 
	 * @param groupID
	 *            group owner ID of the record.
	 * @param recordID
	 *            ID of the record.
	 * 
	 * @return an IRecord object.
	 */
	public IRecordID createRecordID(IGroupID groupID, int recordID);

	/**
	 * Creates an ITagRecord object from given fields.
	 * 
	 * @param recordID
	 *            ID of the record this tag qualify.
	 * @param PeerID
	 *            ID of the peer which has emitted this tag.
	 * @param tag
	 *            the tag itself.
	 * 
	 * @return an ITagRecord object.
	 */
	public ITagRecord createTagRecord(IRecordID recordID, IPeerID PeerID, Tag tag, String comment);
	
	/**
	 * Create an IRecord (or IMetaRecord or ITagRecord) object from its XML
	 * representation.
	 * 
	 * @param xmlRecord
	 *            XML text.
	 * 
	 * @return an IRecord object or null if parsing error.
	 */
	public IRecord readFromXML(String xmlRecord);

	/**
	 * Create an IRecord (or IMetaRecord or ITagRecord) object from its XML
	 * document representation.
	 * 
	 * @param xmlRecord
	 *            XML document.
	 * 
	 * @return an IRecord object or null if parsing error.
	 */
	public IRecord readFromXMLdocument(Document xmlDocumentRecord);
	
}
