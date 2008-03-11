package replics.facade;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Date;

import replics.kernel.JDBC;

public class FacadeDB {
	
	Session session;	
	static JDBC jdbc = new JDBC();
	
	/** A1
	 * This method receives the administrator information and validates it.
	 * @param login the login of the administrator
	 * @param password the password of the administrator
	 * @return SUCCESS the administrator is identified
	 * @return LOGIN_NOT_VALID the login is not valid
	 * @return PASS_NOT_VALID the password is not valid
	 */
	public static ErrorTag adminLogin(String login, String password) {
		ErrorTag et = ErrorTag.SUCCESS;
		et = ErrorTag.LOGIN_NOT_VALID;
		et = ErrorTag.PASSWORD_NOT_VALID;
		return et;
	}

	/** A3
	 * This method adds a administrator to the database.
	 * @param login the login of the administrator
	 * @param fingerPrint the finger print of the administrator
	 * @param photo the photo of the administrator
	 * @param name the name of the administrator
	 * @param lastname the last name of the administrator
	 * @param birthday the birthday of the administrator
	 * @param birthplace the city of birth of the administrator
	 * @param address the address of the administrator
	 * @return SUCCESS the administrator was successfully registered
	 * @return LOGIN_NOT_AVAILABLE the login is already taken
	 * @return INVALID_DATA some of the data is not valid
	 */
	public static ErrorTag addAdmin(String login, String password, String name, File photo,
						String lastname,Date birthday, String birthplace, String address) {
		ErrorTag et = ErrorTag.SUCCESS;
		et = ErrorTag.LOGIN_NOT_AVAILABLE;
		et = ErrorTag.INVALID_DATA;
		return et;
	}
	
	/** A4
	 * This method changes the password of an administrator.
	 * @param login the login of the administrator
	 * @param password the old password of the administrator
	 * @param newPass the new password of the administrator
	 * @return SUCCESS the password was successfully changed
	 * @return LOGIN_NOT_VALID the login is not valid 
	 * @return PASSWORD_NOT_VALID the password is not valid
	 */
	public static ErrorTag adminChangePassword(String login, String password, String newPass) {
		ErrorTag et = ErrorTag.SUCCESS;
		et = ErrorTag.LOGIN_NOT_VALID;
		et = ErrorTag.PASSWORD_NOT_VALID;
		return et;
	}
	
	/** A5
	 * This method adds a member to the database.
	 * @param idTag	the type of member being added
	 * @param login the login of the member
	 * @param fingerPrint the finger print of the member
	 * @param photo the photo of the member
	 * @param name the name of the member
	 * @param lastname the last name of the member
	 * @param birthday the birthday of the member
	 * @param birthplace the city of birth of the member
	 * @param address the address of the member
	 * @return SUCCESS the member was successfully registered
	 * @return LOGIN_NOT_AVAILABLE the login is already taken
	 * @return INVALID_DATA some of the data is not valid
	 */
	public static ErrorTag addMember(IdTag it, String login, FingerPrint fp, String name, File photo,
						String lastname,Date birthday, String birthplace, String address) {
		ErrorTag et = ErrorTag.SUCCESS;
		et = ErrorTag.LOGIN_NOT_AVAILABLE;
		et = ErrorTag.INVALID_DATA;
		return et;
	}
	
	
	/** A6
	 * This method removes a member from the database.
	 * @param idTag	the type of member being removed
	 * @param login the login of the member
	 * @return SUCCESS the member was successfully removed
	 * @return LOGIN_NOT_VALID the login is not valid
	 */
	public static ErrorTag removeMember(IdTag it, String login, FingerPrint fp) {
		ErrorTag et = ErrorTag.SUCCESS;
		et = ErrorTag.LOGIN_NOT_VALID;
		return et;
	}

	/** B1
	 * This method opens an already existing session
	 * @param sessoinID the identifier of the session
	 * @return SUCCESS the session was successfully opened
	 * @return SESSION_NOT_VALID the session does not exist
	 */	
	public static ErrorTag openSession(Integer sessionID){
		ErrorTag et = ErrorTag.SUCCESS;
		et = ErrorTag.SESSION_NOT_VALID;
		return et;
	}

	/** B11
	 * This method receives the member information and validates it.
	 * @param idTag	the type of member being validated
	 * @param login the login of the member
	 * @param fingerPrint the finger print of the member
	 * @return SUCCESS the member is identified
	 * @return LOGIN_NOT_VALID the login is not valid
	 * @return PASSWORD_NOT_VALID the password is incorrect
	 * @return FINGERPRINT_NOT_VALID the password is incorrect
	 * @return MEMBER_NOT_VALID the member is not valid, he does not belong to this session
	 */
	public static ErrorTag memberLoginCreatedSession(IdTag it, String login, String password, FingerPrint fp) {
		ErrorTag et = ErrorTag.SUCCESS;
		et = ErrorTag.LOGIN_NOT_VALID;
		et = ErrorTag.PASSWORD_NOT_VALID;
		et = ErrorTag.FINGERPRINT_NOT_VALID;
		et = ErrorTag.MEMBER_NOT_VALID;
		return et;
	}
	

	/** B2
	 * This method creates a new session
	 * @param reg the region of the session
	 * @param dist the district of the session
	 * @param cent the center of the session
	 * @return SUCCESS the session was successfully created
	 * @return INVALID_DATA the session was not created
	 */
	
	public static ErrorTag createSession(Integer reg, Integer dist, Integer cent){
		
		ErrorTag et = ErrorTag.SUCCESS;
		et = ErrorTag.INVALID_DATA;
		return et;
	}
	
	/** B21
	 * This method receives the member information and adds it to the new session.
	 * @param idTag	the type of member being validated
	 * @param login the login of the member
	 * @param fingerPrint the finger print of the member
	 * @return SUCCESS the member is identified
	 * @return LOGIN_NOT_VALID the login is not valid
	 * @return PASSWORD_NOT_VALID the password is incorrect
	 * @return FINGERPRINT_NOT_VALID the password is incorrect
	 * @return SPOT_ASSINGED this spot already belongs to other member 
	 */
	public static ErrorTag memberLoginNewSession(IdTag it, String login, String password, FingerPrint fp) {
		ErrorTag et = ErrorTag.SUCCESS;
		et = ErrorTag.LOGIN_NOT_VALID;
		et = ErrorTag.PASSWORD_NOT_VALID;
		et = ErrorTag.FINGERPRINT_NOT_VALID;
		et = ErrorTag.SPOT_ASSIGNED;
		return et;
	}
	
	/** B3
	 * This method registers a person into the database.
	 * @param name the name of the person
	 * @param lastname the last name of the person
	 * @param photo the photo of the person
	 * @param fingerPrint the finger print of the person
	 * @param birthday the birthday of the person
	 * @param birthplace the city of birth of the person
	 * @param address the address of the person
	 * @param height the height of the person
	 * @return SUCCESS the person was successfully registered
	 * @return USER_ALREADY_REGISTERED this person is already registered
	 * @return INVALID_DATA some of the data is not valid
	 */
	public static ErrorTag addPerson(String name, String lastname, File photo, FingerPrint fp, 
						Date birthday, String birthplace, String address , float height) {
		ErrorTag et = ErrorTag.SUCCESS;
		et = ErrorTag.USER_ALREADY_REGISTERED;
		et = ErrorTag.INVALID_DATA;
		return et;
		//in a table SESSION_PERSON save the relation between the two
	}	
	
	/** B4
	 * This method saves the information of the session into the database
	 * @param session the session to be saved
	 * @return SUCCESS the session was successfully saved
	 * @return SESSION_NOT_VALID the session was not saved
	 */	
//	public ErrorTag saveSession(Session session){
//		
//		ErrorTag et = ErrorTag.SUCCESS;
//		et = ErrorTag.SESSION_NOT_VALID;
//		return et;
//	}
	
	
	public static boolean confirmNewIdentity(int i){
		
		jdbc.confirmIdentity(i);
		return false;
	}

	public static void saveData(String idGroup, Integer IDU, String hash, File xml, File photo, File fingerPrint, float height) throws FileNotFoundException, SQLException {
		
		jdbc.saveRecord(idGroup, IDU, hash, xml, photo, fingerPrint, height);
	}
	
	
	
	
}
