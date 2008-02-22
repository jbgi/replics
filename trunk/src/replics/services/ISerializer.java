package replics.services;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;


public interface ISerializer {

	 /**
     * Serialize an object to a pretty-printed XML String.
     */
    public String toXML(Object obj);

    /**
     * Serialize an object to the given Writer as pretty-printed XML.
     */
    public void toXML(Object obj, Writer out);

    /**
     * Serialize an object to the given OutputStream as pretty-printed XML.
     */
    public void toXML(Object obj, OutputStream out);
	
    /**
     * Deserialize an object from an XML String.
     */
    public Object fromXML(String xml);

    /**
     * Deserialize an object from an XML Reader.
     */
    public Object fromXML(Reader xml);

    /**
     * Deserialize an object from an XML InputStream.
     */
    public Object fromXML(InputStream input);
}
