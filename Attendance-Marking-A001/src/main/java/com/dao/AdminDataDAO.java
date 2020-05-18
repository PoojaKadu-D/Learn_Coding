package com.dao;

import java.util.ArrayList;

import com.java.AdminData;
import com.servlet.*;


public interface AdminDataDAO {
	
	public AdminData addUserDeatails(AdminData admindata);
	
	//Super User Function- Fetch all pending Admin Requests
	public ArrayList<AdminData> getAllAdmin();
	
	//Admin Login
	public AdminData checkLoginStatus(int adminid, String adminpassword);

	//Accept Admin Request 
	public ArrayList<AdminData> acceptRequest(int admin_Id);
	
	//Reject Admin Request
	public ArrayList<AdminData> rejectRequest(int admin_Id);
	
	
}
