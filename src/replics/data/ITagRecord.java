package replics.data;

import java.util.Date; 

public interface ITagRecord {

    public String getTagHash ();

    public int getRecordID ();

    public String getGroupID ();

    public String getPeerID ();

    public Date getDate ();

    public Tag getTag ();

}

