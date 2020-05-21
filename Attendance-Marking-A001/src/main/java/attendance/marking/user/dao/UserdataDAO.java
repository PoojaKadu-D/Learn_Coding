package attendance.marking.user.dao;

import attendance.marking.user.obj.UserData;

public interface UserdataDAO {

	public String addUserDeatails(UserData fedata);

	// User Authentication
	public UserData checkLoginStatus(int userid, String userpassword);
	
}
