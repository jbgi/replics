package replics.net.messages;

import replics.impl.data.RecordID;

public interface IComparisonQuery {

	// renvoi le peerID de celui qui demande la comparaison
	//public String getPeerID();
	
	// renvoi le premier recordID de l'intervale de comparaison
	public RecordID getFirstRecordID();
	
	// retourne le dernier RecordID de l'intervale à comparer
	public RecordID getLastRecordID();
	
	
	
}
