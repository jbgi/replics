package secolaman.data;

import java.util.Iterator;

import org.apache.commons.math.complex.Complex;

import secolaman.data.entries.ComplexMetaEntry;
import secolaman.data.entries.StringMetaEntry;

public interface MetaData {

	public void addComplex(String key, Complex val);

	public void addString(String key, String val);

	public Iterator<ComplexMetaEntry> getComplexEntriesIterator();

	public Iterator<StringMetaEntry> getStringEntriesIterator();

	public void removeComplexEntry(String key);

	public void removeStringEntry(String key);
}
