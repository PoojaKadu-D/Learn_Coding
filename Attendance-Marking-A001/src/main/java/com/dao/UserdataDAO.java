package com.dao;

import com.java.*;

public interface UserdataDAO {

	public UserData addUserDeatails(UserData fedata);

	// User Authentication
	public UserData checkLoginStatus(int userid, String userpassword);
	
}
