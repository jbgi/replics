package replics.impl.data;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.spi.DateFormatProvider;

import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.apache.derby.client.am.DateTime;
import org.apache.derby.client.am.SqlCode;
import org.apache.derby.iapi.services.io.FileUtil;

import replics.data.IDataProvider;
import replics.impl.services.ReplicsService;
import sun.util.calendar.BaseCalendar;
import sun.util.calendar.BaseCalendar.Date;

public class DerbyDataProvider extends ReplicsService implements IDataProvider {

	private static String[] createStrings = {
		 
		"CREATE TABLE TAGS (" 
		+ "	ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," 
		+ "	NAME VARCHAR(128) NOT NULL," 
		+ "	VAL VARCHAR(512) NOT NULL," 
		+ "	PRIMARY KEY (ID),"
		+ " UNIQUE (NAME, VAL))",
		
		"CREATE INDEX TAG_NAME_INDEX ON TAGS (NAME)",
		 
		"CREATE TABLE FILES (" 
		+ "	ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," 
		+ "	RECORDID VARCHAR(128) NOT NULL," 
		+ "	FILEPATH VARCHAR(512)," 
		+ "	TAGS LONG VARCHAR,"
		+ "	PRIMARY KEY (ID),"
		+ " UNIQUE (RECORDID))",

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
		+ "	external name 'replics.impl.data.DerbyDataProvider.matchRegex'" };

	private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	public static int matchRegex(String src, String pattern)
	{
	      int retval=0;
	      if (Pattern.matches(pattern, src))
	         retval=1;
	      return retval;
	}
	private PreparedStatement addFile;
	private PreparedStatement addFileForTag;
	private PreparedStatement addRecord;
	private PreparedStatement clearMatches;
	private Connection conn = null;
	private PreparedStatement deleteDesc;
	private PreparedStatement deleteFilePath;
	private PreparedStatement deleteRecord;
	private PreparedStatement deleteRecordID;
	private File filesDir;
	private PreparedStatement findFurtherMatches;
	private PreparedStatement findMatches;
	private PreparedStatement getDesc;
	private PreparedStatement getFileID;
	private PreparedStatement getFilePath;
	private PreparedStatement getFilePathFromID;
	private PreparedStatement getMatchesID;
	private PreparedStatement getMatchesRecordID;
	private PreparedStatement getTagID;
	private PreparedStatement insertTag;
	
	private Statement s;
	
	private int sessionCounter = 0;
	
	private PreparedStatement updateRecord;
	
	private void addFileForTag(int fileID, int tagID)
	{
		synchronized (addFileForTag) {
			try {
				addFileForTag.setInt(1, tagID);
				addFileForTag.setInt(2, fileID);
				addFile.execute();
			} catch (SQLException e) { e.printStackTrace();	}
		}
	}

	private void createTagIndexForFile(int fileID, Map<String, String> tags) {
		Iterator<Entry<String, String>> it = tags.entrySet().iterator();
		Entry<String, String> e;
		
		while(it.hasNext())
		{
			e = it.next();
			int tagID = getTagID(e.getKey(), e.getValue());
			
			if (0 == tagID)
			{
				tagID = insertTag(e.getKey(), e.getValue());
			}
			
			addFileForTag(fileID, tagID);
			
		}
	}
	
	public void deleteFileForRecord(String recordID) {
		FileUtil.removeDirectory(getFilePath(recordID));
	}

	public void deleteRecord(String recordID) {
		synchronized (deleteRecord) {
			try {
				deleteRecord.setString(1, recordID);
				deleteRecord.executeUpdate();
			} catch (SQLException e) { e.printStackTrace();	}
		}
	}
	
	private String generateRecordID()
	{
		return services.getPeerGroupManager().getLocalPeerID() + 
				"-" + sdf.format(GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT")).getTime()) + 
				"-" + ++sessionCounter;
	}
	
	private File getFile(int fileID) {
		String filePath = getFilePathFromID(fileID);
		if (null != filePath)
		{
			return new File(filePath);
		}
		return null;
	}

	public File getFile(String recordID) {
		String filePath = getFilePath(recordID);
		if (null != filePath)
		{
			return new File(filePath);
		}
		return null;
	}
	
	private int getFileID(String recordID){
		int fileID = 0;
		synchronized (getFileID) {
			try {
				getFileID.setString(1, recordID);
				ResultSet fID = getFileID.executeQuery();
				if (fID.first())
				{
					fileID = fID.getInt(1);
				}
			} catch (SQLException e1) { e1.printStackTrace(); }
		}
		return fileID;
	}

	private String getFilePath(String recordID)
	{
		try {
			ResultSet r;
			synchronized (getFilePath) {
				getFilePath.setString(1, recordID);
				r = getFilePath.executeQuery();
				if (r.first())
				{
					return r.getString(1);
				}
			}
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}

	private String getFilePathFromID(int fileID)
	{
		try {
			ResultSet r;
			synchronized (getFilePathFromID) {
				getFilePathFromID.setInt(1, fileID);
				r = getFilePathFromID.executeQuery();
				if (r.first())
				{
					return r.getString(1);
				}
			}
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}
	
	public Collection<String> getMatchingRecords(Map<String, String> tagMatcher) {
		
		Iterator<Entry<String, String>> it = tagMatcher.entrySet().iterator();
		Entry<String, String> e = it.next();
		Collection<String> mr = null;
		try {
			findMatches.setString(1, e.getKey());
			findMatches.setString(2, e.getValue());
			int n = findMatches.executeUpdate();
			
			while (it.hasNext() && n != 0)
			{
				findFurtherMatches.setString(1, e.getKey());
				findFurtherMatches.setString(2, e.getValue());
				n-=findFurtherMatches.executeUpdate();
			}
			mr = null;
			if (n != 0)
			{
				ResultSet r = getMatchesRecordID.executeQuery();
				mr = new HashSet<String>(n);
				r.first();
				for (int i = 0; i<n; i++)
				{
					mr.add(r.getString(1));
					r.next();
				}
			}
		} catch (SQLException e1) {e1.printStackTrace();}
		return mr;
	}
	
	public Collection<String> getMatchingRecords(Map<String, String> tagMatcher, int sinceRevision) {
		return null;
	}
	
	public int getRevision() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getTagID(String name, String val)
	{
		int tagID = 0;
		synchronized (getTagID) {
			try {
				getTagID.setString(1, name);
				getTagID.setString(2, val);
				ResultSet fID = getTagID.executeQuery();
				if (fID.first())
				{
					tagID = fID.getInt(1);
				}
			} catch (SQLException e1) { e1.printStackTrace(); }
		}
		return tagID;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> getTagsForRecord(String recordID) {
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
			PrepareStatements();
	}

	private int insertTag(String name, String val)
	{
		int tagID = 0;
		synchronized (insertTag) {
			try {
				insertTag.setString(1, name);
				insertTag.setString(2, val);
				insertTag.execute();
				ResultSet rs = insertTag.getGeneratedKeys();
				rs.first();
				tagID = insertTag.getGeneratedKeys().getInt(1);
			} catch (SQLException e1) { e1.printStackTrace(); }
		}
		return tagID;
	}
	
	private int newRecord(String recordID, File file, Map<String, String> tags)
	{
		synchronized (addRecord)
		{
			try {
				addRecord.setString(1, recordID);
				if (null != file)
				{
					addRecord.setString(2, file.getCanonicalPath());
				}
				else
				{
					addRecord.setString(2, null);
				}
				if (null != tags)
				{
					addRecord.setString(3, services.getSerializer().toXML(tags));
				}
				else
				{
					addRecord.setString(3, null);
				}
				addRecord.execute();
				ResultSet rs = addRecord.getGeneratedKeys();
				rs.first();
				return rs.getInt(1);
			} catch (Exception e1) { e1.printStackTrace(); }
			return 0;
		}
	}
	
	private void PrepareStatements()
	{
		try {
			conn.createStatement().execute("DECLARE GLOBAL TEMPORARY TABLE session.MATCHING_FILEIDS (FILE_ID INTEGER NOT NULL) NOT LOGGED");
			
			findMatches = conn.prepareStatement("INSERT INTO session.MATCHING_FILEIDS SELECT FILE_ID FROM FILES_TAGS INNER JOIN TAGS ON " +
					"TAGS.ID = FILES_TAGS.TAG_ID WHERE NAME = ? AND matchRegex(VAL, ?) = 1");
			
			findFurtherMatches = conn.prepareStatement("DELETE FROM session.MATCHING_FILEIDS WHERE FILE_ID IN (SELECT session.MATCHING_FILEIDS.FILE_ID FROM session.MATCHING_FILEIDS INNER JOIN FILES_TAGS ON session.MATCHING_FILEIDS.FILE_ID = FILES_TAGS.FILE_ID INNER JOIN TAGS" +
					" ON TAGS.ID = FILES_TAGS.TAG_ID WHERE NAME = ? AND matchRegex(VAL, ?) <> 1)");
			
			getMatchesID = conn.prepareStatement("SELECT * FROM session.MATCHING_FILEIDS");
			getMatchesRecordID = conn.prepareStatement("SELECT RECORDID FROM FILES INNER JOIN session.MATCHING_FILEIDS ON session.MATCHING_FILEIDS.FILE_ID = FILES.ID");
			clearMatches = conn.prepareStatement("DELETE FROM session.MATCHING_FILEIDS");
			
			getFileID = conn.prepareStatement("SELECT ID FROM FILES WHERE RECORDID = ?");
			
			getTagID = conn.prepareStatement("SELECT ID FROM TAGS WHERE NAME = ? AND VAL = ?");
			
			addRecord = conn.prepareStatement("INSERT INTO FILES (RECORDID, FILEPATH, TAGS) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			updateRecord = conn.prepareStatement("UPDATE FILES SET FILEPATH = ?, TAGS = ? WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
			
			insertTag = conn.prepareStatement("INSERT INTO TAGS (NAME, VAL) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			addFileForTag = conn.prepareStatement("INSERT INTO FILES_TAGS (TAG_ID, FILE_ID) VALUES (?, ?)");
			
			getDesc = conn.prepareStatement("SELECT TAGS FROM FILES WHERE RECORDID = ?");
			getFilePath = conn.prepareStatement("SELECT FILEPATH FROM FILES WHERE RECORDID = ?");
			getFilePathFromID = conn.prepareStatement("SELECT FILEPATH FROM FILES WHERE ID = ?");
			deleteFilePath = conn.prepareStatement("UPDATE FILES SET FILEPATH = NULL WHERE RECORDID = ?");
			deleteRecord = conn.prepareStatement("DELETE FROM FILES WHERE RECORDID = ?");
			deleteRecordID = conn.prepareStatement("DELETE FROM FILES WHERE ID = ?");
			
		} catch (SQLException e) {e.printStackTrace();}
	}

	public boolean recordExists(String recordID) {
		// TODO Auto-generated method stub
		return false;
	}

	public String saveRecord(String recordID, byte[] file,
			Map<String, String> tags) {
		// TODO Auto-generated method stub
		return null;
	}

	public String saveRecord(String recordID, File file, Map<String, String> tags) {
		
		int fileID = 0;
		
		if (null != recordID && !recordID.equals(""))
		{
			fileID = getFileID(recordID);
		}
		
		if (fileID != 0)
		{
			deleteRecord(recordID);
			
		}
		else
		{
			if (null == recordID || recordID.equals(""))
			{
				recordID = generateRecordID();
			}
		}
		
		fileID = newRecord(recordID, file, tags);
		
		createTagIndexForFile(fileID, tags);
		
		return recordID;
	}

}
