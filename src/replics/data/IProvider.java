package replics.data;

import java.util.ArrayList; 
import java.util.Date;
import java.util.List; 

public interface IProvider {

    public List<IEntry> getEntries (ArrayList<Integer> TakerIDs, Date minDate, Date maxDate, int minMultiplicity, int maxMultiplicity, ArrayList<Tag> hasTags, ArrayList<Tag> hasNotTags);

    public void InsertEntry (IEntry entry);

}

