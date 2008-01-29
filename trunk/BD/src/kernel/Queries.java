package kernel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Queries {
	
	 static Connection con = null;
	 
	 public ResultSet Query1() throws SQLException{
		
		  	Statement stmt = con.createStatement();
		  	
		  	ResultSet result = stmt.executeQuery(
		  	        "SELECT xml " +
		  	        "FROM olpc " +
		  	        "ORDER BY id DESC");
		  	
		  	return result;
		  	
	 }
	 

}
