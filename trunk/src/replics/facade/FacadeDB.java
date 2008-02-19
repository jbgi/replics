package replics.facade;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import replics.kernel.JDBC;

public class FacadeDB {
	
	JDBC jdbc = new JDBC();
	
	public boolean confirmNewIdentity(int i){
		
		jdbc.confirmIdentity(i);
		return false;
	}

	public void saveData(String idGroup, Integer IDU, String hash, File xml, File photo, File fingerPrint, float height) throws FileNotFoundException, SQLException {
		
		jdbc.saveRecord(idGroup, IDU, hash, xml, photo, fingerPrint, height);
		
	}
}
