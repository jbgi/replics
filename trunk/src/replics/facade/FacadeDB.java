package replics.facade;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Date;

import replics.kernel.JDBC;

public class FacadeDB {
	
	JDBC jdbc = new JDBC();
	
	/**
	 * This method receives the administrator information and validates it.
	 * @param login the login of the administrator
	 * @param password the password of the administrator
	 * @return ADMIN_VALID the administrator is identified
	 * @return ADMIN_NOT_VALID the administrator is not valid
	 * @return ADMIN_NOT_EXISTS the administrator does not exist
	 */
	public ErrorTag adminLogin(String login, String password) {
		ErrorTag et = ErrorTag.ADMIN_VALID;
		return et;
	}
	
	/**
	 * This method changes the password of an administrator.
	 * @param login the login of the administrator
	 * @param password the old password of the administrator
	 * @param newPass the new password of the administrator
	 * @return PASSWORD_CHANGED the password was successfully changed
	 * @return PASSWORD_NOT_VALID the password is not valid
	 */
	public ErrorTag adminChangePassword(String login, String password, String newPass) {
		ErrorTag et = ErrorTag.PASSWORD_CHANGED;
		return et;
	}
	
	/**
	 * This method adds a administrator to the database.
	 * @param login the login of the administrator
	 * @param fingerPrint the finger print of the administrator
	 * @param photo the photo of the administrator
	 * @param name the name of the administrator
	 * @param lastname the last name of the administrator
	 * @param birthday the birthday of the administrator
	 * @param birthplace the city of birth of the administrator
	 * @param address the address of the administrator
	 * @return ADMIN_REGISTERED the administrator was successfully registered
	 * @return ADMIN_ALREADY_REGISTERED this person is already registered
	 * @return LOGIN_NOT_AVAILABLE the login is already taken
	 */
	public ErrorTag addAdmin(String login, String password, String name, File photo,
						String lastname,Date birthday, String birthplace, String address) {
		ErrorTag et = ErrorTag.ADMIN_REGISTERED;
		return et;
	}
	
	/**
	 * This method receives the member information and validates it.
	 * @param idTag	the type of member being validated
	 * @param login the login of the member
	 * @param fingerPrint the finger print of the member
	 * @return MEMBER_VALID the member is identified
	 * @return MEMBER_NOT_VALID the member is not valid
	 * @return MEMBER_NOT_EXISTS the member does not exist
	 */
	public ErrorTag memberLogin(IdTag it, String login, FingerPrint fp) {
		ErrorTag et = ErrorTag.MEMBER_VALID;
		return et;
	}
	
	/**
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
	 * @return MEMBER_REGISTERED the member was successfully registered
	 * @return MEMBER_ALREADY_REGISTERED this member is already registered
	 * @return LOGIN_NOT_AVAILABLE the login is already taken
	 */
	public ErrorTag addMember(IdTag it, String login, FingerPrint fp, String name, File photo,
						String lastname,Date birthday, String birthplace, String address) {
		ErrorTag et = ErrorTag.MEMBER_REGISTERED;
		return et;
	}
	
	/**
	 * This method removes a member from the database.
	 * @param idTag	the type of member being removed
	 * @param login the login of the member
	 * @param fingerPrint the finger print of the member
	 * @return MEMBER_REMOVED the member was successfully removed
	 * @return MEMBER_NOT_REMOVED this member cannot be removed
	 */
	public ErrorTag removeMember(IdTag it, String login, FingerPrint fp, String name, 
						String lastname,Date birthday, String birthplace, String address) {
		ErrorTag et = ErrorTag.MEMBER_REMOVED;
		return et;
	}
	
	
	/**
	 * This method registers a person into the database.
	 * @param name the name of the person
	 * @param lastname the last name of the person
	 * @param photo the photo of the person
	 * @param fingerPrint the finger print of the person
	 * @param birthday the birthday of the person
	 * @param birthplace the city of birth of the person
	 * @param address the address of the person
	 * @return USER_REGISTERED the person was successfully registered
	 * @return USER_ALREADY_REGISTERED this person is already registered
	 */
	public ErrorTag addPerson(IdTag it, FingerPrint fp, String name, File photo,
						String lastname,Date birthday, String birthplace, String address) {
		ErrorTag et = ErrorTag.USER_REGISTERED;
		return et;
	}
	
	/**
	 * This method creates a new session
	 * @param reg the region of the session
	 * @param dist the district of the session
	 * @param cent the center of the session
	 * @return SESSION_CREATED the person was successfully registered
	 * @return SESSION_NOT_CREATED this person is already registered
	 */
	
	public ErrorTag createSession(Integer reg, Integer dist, Integer cent){
		
		ErrorTag et = ErrorTag.SESSION_CREATED;
		return et;
	}
	
	
	
	public boolean confirmNewIdentity(int i){
		
		jdbc.confirmIdentity(i);
		return false;
	}

	public void saveData(String idGroup, Integer IDU, String hash, File xml, File photo, File fingerPrint, float height) throws FileNotFoundException, SQLException {
		
		jdbc.saveRecord(idGroup, IDU, hash, xml, photo, fingerPrint, height);
	}
	
	
	
	
}
