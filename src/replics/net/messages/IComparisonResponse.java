package replics.net.messages;

import replics.impl.data.RecordID;

public interface IComparisonResponse extends IMessage {

	// renvoi le premier recordID de l'intervale comparé
	public RecordID getFirstRecordID();
	
	// retourne le dernier RecordID de l'intervale comparé
	public RecordID getLastRecordID();

	//retourne false s'il n'y pas de doublon, vrai sinon 
	public boolean isPositiveComparison();
	
	//renvoi le RecordID qui est en doublon ou null 
	public RecordID getPositiveRecordID();
	
}
