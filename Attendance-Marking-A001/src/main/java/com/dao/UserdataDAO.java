package com.dao;

import com.java.*;

public interface UserdataDAO {

	public String addUserDeatails(UserData fedata);

	// User Authentication
	public UserData checkLoginStatus(int userid, String userpassword);
	
}
