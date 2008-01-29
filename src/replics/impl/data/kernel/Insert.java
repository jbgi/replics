package replics.impl.data.kernel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	static Connection con = null;
	 
	 public void Insert1(Byte SQLData[]) throws SQLException{
		
		  	Statement stmt = con.createStatement();
		  	stmt.executeUpdate("INSERT INTO olpc VALUES " + SQLData[0] );
		  	
	 }
}
