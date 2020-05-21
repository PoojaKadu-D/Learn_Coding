package attendance.marking.admin.dao;

import java.util.ArrayList;

import attendance.marking.user.obj.AdminData;


public interface AdminDataDAO {
	
	public AdminData addUserDeatails(AdminData admindata);
	
	//Super User Function- Fetch all pending Admin Requests
	public ArrayList<AdminData> getAllAdmin();
	
	//Admin Login
	public AdminData checkLoginStatus(int adminid, String adminpassword);
	
	
	
}
