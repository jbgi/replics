package replics.impl.data.kernel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class Insert {

	 public static void saveRecord(Connection con, String idGroup, Integer IDU, String hash, File xml, File photo, File fingerPrint, float height) throws SQLException, FileNotFoundException{
		
		  	String sql = "INSERT INTO test1 (groupId, IDU, hash, xml, photo, fingerPrint, height) VALUES(?,?,?,?,?,?,?)";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        
	        pstmt.setString(1,idGroup);
	        pstmt.setInt(2,IDU);
	        pstmt.setString(3,hash);
	        
	        FileInputStream is = new FileInputStream(xml);
	        pstmt.setAsciiStream(4, is, xml.length());
	        
	        is = new FileInputStream(photo);
	        pstmt.setBinaryStream(5, is, photo.length());
	        
	        is = new FileInputStream(fingerPrint);
	        pstmt.setBinaryStream(6, is, fingerPrint.length());
	        
	        pstmt.setFloat(7,height);
	        
		  	pstmt.executeUpdate();
		  	
		  	System.out.println("Data successfully added to the DB");
		  	
	 }
	 
	 
}
