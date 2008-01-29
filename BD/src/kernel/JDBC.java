package kernel;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	
  static Connection con = null;

  public static void main(String args[]) throws SQLException {
	  
	Connect();
	CreateDB();
	
    }
  

    private static void Connect() {
	try {
	      Class.forName("com.mysql.jdbc.Driver").newInstance();
	      con = DriverManager.getConnection("localhost:gin","gin","secret");

	      if(!con.isClosed())
	        System.out.println("Successfully connected to MySQL server using TCP/IP...");

	    } catch(Exception e) {
	      System.err.println("Exception: " + e.getMessage());
	    } finally {
	      try {
	        if(con != null)
	          con.close();
	      } catch(SQLException e) {}
	
	    }	
    }
    
    private static void CreateDB() throws SQLException {
    	
    	Statement stmt = con.createStatement();
    	
    	stmt.executeUpdate( "CREATE TABLE olpc ("  +
    	         "recordId    	INT    		NOT NULL, "    +
    	         "groupId    	VARCHAR(100)    NOT NULL, "    +
    	         "hash    		VARCHAR(100)    NOT NULL, "    +
    	         "xml   		TEXT 			NOT NULL, "    +
    	         "photo        	BINARY 			NOT NULL, "    +
    	         "fingerPrint	BINARY 			NOT NULL, "    +
    	         "height		FLOAT 			NOT NULL, "    +
    	         "PRIMARY KEY( recordID, groupId )"                  +
    	                                            ")" );
    	
      }
}

//system....exec(url); pour executer un program
