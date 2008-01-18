package replics.data;

import java.util.ArrayList; 
import org.w3c.dom.Document; 

public interface IMetaRecord {

    public Document getXML ();

    public ArrayList<Byte> getFingerPrint ();

    public int getHeight ();

    public String getGroupID ();

    public int getRecordID ();

}

