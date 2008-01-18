package replics.data;

import java.util.ArrayList; 

public interface IRecord {

    public String getXML ();

    public IMetaRecord getMetaRecord ();

    public ArrayList<Tag> getTags ();

}

