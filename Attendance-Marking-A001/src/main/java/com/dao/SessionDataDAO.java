package com.dao;

import java.util.ArrayList;

import com.java.SessionData;

public interface SessionDataDAO {

	// adding Session details
	public String addSession(SessionData sessiondata);

	// session Id and description
	public ArrayList<SessionData> getAllSession();

	// all session details
	public SessionData getAllDetailSession(int id);
	
	// Map Session and User
	public String mapUserSession(int user_Id, int session_Id);
	
	// Notify user
	public void setNotification(int u_id);
	
}
