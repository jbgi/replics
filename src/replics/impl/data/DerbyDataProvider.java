package replics.impl.data;

import java.io.File;
import java.sql.*;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

import org.clapper.util.io.FileUtil;

import replics.data.IDataProvider;
import replics.impl.services.ReplicsService;

public class DerbyDataProvider extends ReplicsService implements IDataProvider {

	// ## DEFINE VARIABLES SECTION ##
	// define the driver to use
	private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	// the database name
	private static String dbName = "derbyDB";
	// define the Derby connection URL to use
	private static String connectionURL = "jdbc:derby:directory:"
			+ System.getProperty("user.home") + File.separator + ".replics"
			+ File.separator + "data" + File.separator + dbName
			+ ";create=true";

	private static String[] createStrings = {
		"DROP TABLE FILES_TAGS", 
		"DROP TABLE TAGS",
		"DROP TABLE FILES", 
		 
		"CREATE TABLE TAGS (" 
		+ "	ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," 
		+ "	NAME VARCHAR(128)," 
		+ "	VAL LONG VARCHAR," 
		+ "	PRIMARY KEY (ID))", 
		 
		"CREATE TABLE FILES (" 
		+ "	ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," 
		+ "	FILEID VARCHAR(128)," 
		+ "	FILEPATH LONG VARCHAR," 
		+ "	TAGS LONG VARCHAR," 
		+ "	PRIMARY KEY (ID))", 

		"CREATE TABLE FILES_TAGS (" 
		+ "	TAG_ID INTEGER NOT NULL," 
		+ "	FILE_ID INTEGER NOT NULL )", 

		"ALTER TABLE FILES_TAGS"
		+ "	ADD CONSTRAINT TAG_FK Foreign Key (TAG_ID)" 
		+ "		REFERENCES TAGS (ID) ON DELETE CASCADE ON UPDATE RESTRICT", 
		
		"ALTER TABLE FILES_TAGS" 
		+ "	ADD CONSTRAINT FILE_FK Foreign Key (FILE_ID)" 
		+ "		REFERENCES FILES (ID) ON DELETE CASCADE ON UPDATE RESTRICT",
		
		" CREATE function matchRegex(source varchar(3000), regex varchar(128))"
		+ "	returns int"
		+ "	language java"
		+ " parameter style java"
		+ "	no sql"
		+ "	external name 'replics.impl.data.matchRegexp'" };
	
	

	private Connection conn = null;
	private Statement s;
	private PreparedStatement psInsert;
	
	private PreparedStatement deleteFile;
	private PreparedStatement deleteRecords;
	private PreparedStatement deleteDesc;
	private PreparedStatement getDesc;
	private PreparedStatement getfilePath;
	private PreparedStatement addFile;
	private PreparedStatement addDesc;
	private PreparedStatement saveDesc;
	
	public static int matchRegex(String src, String pattern)
	{
	      int retval=0;
	      if (Pattern.matches(pattern, src))
	         retval=1;
	      return retval;
	}
	
	private void deleteFile(String pathToFile){
		org.apache.derby.iapi.services.io.FileUtil.removeDirectory("");
	}

	public void deleteFiles(Collection<String> recordIDs) {
		
	}
	
	public void deleteDesc(Collection<String> recordIDs) {
		
	}

	public void deleteRecords(Collection<String> recordIDs) {
		// TODO Auto-generated method stub
	}

	public Map<String, String> getDesc(String recordID) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Map<String, String>> getDescMap(
			Collection<String> recordIDs) {
		// TODO Auto-generated method stub
		return null;
	}

	public byte[] getFile(String recordID) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<String> getMatches(Map<String, String> descMatcher) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<String> getMatches(Map<String, String> descMatcher,
			int sinceRevision) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveDesc(String recordID, Map<String, String> desc) {
		// TODO Auto-generated method stub

	}

	public void saveDescMap(Map<String, Map<String, String>> descMap) {
		// TODO Auto-generated method stub

	}

	public void saveFile(String recordID, byte[] file) {
		// TODO Auto-generated method stub
	}
	
	public void addFile(String recordID, String filePath) {
		// TODO Auto-generated method stub
	}

	public void saveRecord(String recordID, Map<String, String> desc,
			byte[] file) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initialize() {
		try {
			Class.forName(driver);
			System.out.println(driver + " loaded. ");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {
			conn = DriverManager.getConnection(connectionURL);
			System.out.println("Connected to database " + dbName);
			s = conn.createStatement();
			System.out.println(" . . . . creating tables");
			for (int i=0; i< createStrings.length; i++)
			{
				try {
					s.execute (createStrings[i]);
				}
				catch (SQLSyntaxErrorException e) {e.printStackTrace();};
			}
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		
		

	}

}
