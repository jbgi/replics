package secolaman.data;

import java.io.File;

public interface Record {

	public byte[] getBytes();
	
	public File getFile();
	
	public Object getObject();
	
	public void setContent(byte[] content);
	
	public void setContent(Object object);
	
}
