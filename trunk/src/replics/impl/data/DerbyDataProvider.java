package replics.impl.data;

import java.io.File;
import java.sql.*;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.derby.iapi.services.io.FileUtil;

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
	
	private File filesDir;
	
	private Statement s;
	private PreparedStatement psInsert;
	
	private PreparedStatement deleteFile;
	private PreparedStatement deleteRecord;
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

	public void deleteFiles(Collection<String> recordIDs) {
		String filePath;
		for (String recordID : recordIDs) {
			filePath = getFilePath(recordID);
			if (null != filePath)
			{
				synchronized (deleteFile) {
					try {
						deleteFile.setString(1, recordID);
						deleteFile.executeUpdate();
					} catch (SQLException e) { e.printStackTrace();	}
				}
				FileUtil.removeDirectory(filePath);
			}
		}
	}
	
	public void deleteDesc(Collection<String> recordIDs) {
		for (String recordID : recordIDs) {
			synchronized (deleteDesc) {
				try {
					deleteDesc.setString(1, recordID);
					deleteDesc.executeUpdate();
				} catch (SQLException e) { e.printStackTrace();	}
			}
		}
	}

	public void deleteRecords(Collection<String> recordIDs) {
		String filePath;
		for (String recordID : recordIDs) {
			filePath = getFilePath(recordID);
			if (null != filePath)
			{
				synchronized (deleteRecord) {
					try {
						deleteRecord.setString(1, recordID);
						deleteRecord.executeUpdate();
					} catch (SQLException e) { e.printStackTrace();	}
				}
				FileUtil.removeDirectory(filePath);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getDesc(String recordID) {
		try {
			ResultSet r;
			synchronized (getDesc) {
				getDesc.setString(1, recordID);
				r = getDesc.executeQuery();
			}
			if (r.first()) {
				return (Map<String, String>) services.getSerializer().fromXML(r.getString(1));
			}
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}

	public Map<String, Map<String, String>> getDescMap(Collection<String> recordIDs) {
		Map<String, Map<String, String>> descMap = new Hashtable<String, Map<String,String>>();
		Map<String, String> desc;
		for (String recordID : recordIDs) {
			desc = getDesc(recordID);
			if (null != desc)
			{
				descMap.put(recordID, desc);
			}
		}
		return descMap;
	}
	
	private String getFilePath(String recordID)
	{
		try {
			ResultSet r;
			synchronized (getfilePath) {
				getfilePath.setString(1, recordID);
				r = getfilePath.executeQuery();
			} 
			if (r.first())
			return r.getString(1);
		} catch (SQLException e) {e.printStackTrace();}
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

	protected void initialize() {
		try {
			Class.forName(driver);
		} catch (java.lang.ClassNotFoundException e) {
			e.printStackTrace();
		}
		String baseDirectory = "";
		try {
			baseDirectory = services.getConfig().getConfigurationValue("DataBase", "DB_directory");
		} catch (Exception e1) {
				try {
					baseDirectory = System.getProperty("user.home") + File.separator + ".replics" 
							+ File.separator + "data" + File.separator + "db";
					services.getConfig().addSection("DataBase");
					services.getConfig().setVariable("DataBase", "DB_directory", baseDirectory, false);
				} catch (Exception e2) {e2.printStackTrace(); }
			}
		
			try {
				conn = DriverManager.getConnection("jdbc:derby:directory:" + baseDirectory);
				logger.fine("Connected to derby database");
			} catch (SQLException e1) {
				try {
					conn = DriverManager.getConnection("jdbc:derby:directory:" + baseDirectory + ";create=true");
					logger.info("Creation of replics (derby) database");
					s = conn.createStatement();
					for (int i=0; i< createStrings.length; i++)
					{
						try {
							s.execute (createStrings[i]);
						}
						catch (SQLSyntaxErrorException e) {e.printStackTrace();};
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			String filesDirPath = "";
			try {
				filesDirPath = services.getConfig().getConfigurationValue("DataBase", "File_directory");
			} catch (Exception e) {
				filesDirPath = System.getProperty("user.home") + File.separator + ".replics" 
				+ File.separator + "data" + File.separator + "files";
				try {
					services.getConfig().setVariable("DataBase", "files_directory", filesDirPath, false);
				} catch (Exception e1) { e1.printStackTrace(); } 
			}
			filesDir = new File(filesDirPath);
			if (!filesDir.exists())
			{
				filesDir.mkdirs();
			}
	}

}
