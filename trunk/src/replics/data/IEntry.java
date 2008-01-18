package replics.data;

import java.util.ArrayList; 
import java.util.Date;

public interface IEntry {

    public int getTakerID ();

    public int getEntryID ();

    public Date getTime ();

    public ArrayList<Tag> getTags ();

}

