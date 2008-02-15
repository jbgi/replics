package replics.impl.data.kernel;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import replics.impl.data.MySqlDataProvider;

public class JDBC {
	
  static Connection con = null;

  public static void main(String args[]) throws SQLException, IOException {
	  
	Connect();
//	CreateDB();
	
	String groupID = "groupID";
	Integer IDU = 24474520;
	String hash = "hash";
	File xml = new File("data/fileXML.xml");
	xml.createNewFile();
	File photo = new File("data/photo.jpg");
	photo.createNewFile();
	File fingerPrint = new File("data/fingerPrint.fp");
	fingerPrint.createNewFile();
	float height = (float) 1.65 ;
	
	Insert.saveRecord(con, groupID, IDU, hash, xml, photo, fingerPrint, height);
	
	Disconnect();
	
	MySqlDataProvider mdp = new MySqlDataProvider();
	
	mdp.initialize();
	
	
	mdp.saveRecord(null);
    }
  

    private static void Connect() {
	try {
	      Class.forName("com.mysql.jdbc.Driver").newInstance();
	      String url ="jdbc:mysql://localhost:3306/gin";
	      con = DriverManager.getConnection(url,"root",null);

	      if(!con.isClosed())
	        System.out.println("Successfully connected to MySQL server using TCP/IP...");

	    } catch(Exception e) {
	      System.err.println("Exception: " + e.getMessage());
	    }

    }
    
    private static void Disconnect() {
    	
    	      try {
    	        if(con != null)
    	          con.close();
    	      } catch(SQLException e) {}
    	
	
    }
    
    private static void CreateDB() throws SQLException {
    	
    	Statement stmt = con.createStatement();
    	
    	stmt.executeUpdate( "CREATE TABLE test1 ("  +
    	         "recordId    	INTEGER    		NOT NULL AUTO_INCREMENT, "    +
    	         "groupId    	VARCHAR(100)    NOT NULL, "    +
    	         "IDU    		INTEGER			NOT NULL, "    +
    	         "hash    		VARCHAR(100)    NOT NULL, "    +
    	         "xml   		TEXT 			NOT NULL, "    +
    	         "photo        	LONGBLOB		NOT NULL, "    +
    	         "fingerPrint	LONGBLOB		NOT NULL, "    +
    	         "height		FLOAT 			NOT NULL, "    +
    	         "PRIMARY KEY( recordID, groupId )"                  +
    	                                            ")" );
    	
    	System.out.println("Table successfully created...");
      }
}
