package replics.impl.services;

import replics.services.ISerializer;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import com.thoughtworks.xstream.XStream;

public class XStreamSerializer extends ReplicsService implements ISerializer {

	private XStream xstream = new XStream();
	
	public Object fromXML(String xml) {
		return xstream.fromXML(xml);
	}

	public Object fromXML(Reader xml) {
		return xstream.fromXML(xml);
	}

	public Object fromXML(InputStream input) {
		return xstream.fromXML(input);
	}

	public String toXML(Object obj) {
		return xstream.toXML(obj);
	}

	public void toXML(Object obj, Writer out) {
		xstream.toXML(obj, out);
	}

	public void toXML(Object obj, OutputStream out) {
		xstream.toXML(obj, out);
	}

	@Override
	protected void initialize() {
	}

}
