package attendance.marking.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import attendance.marking.user.obj.AdminData;
import utils.JDBC_GetConnection;

public class AdminDataImplementation implements AdminDataDAO {

	@Override
	public AdminData addUserDeatails(AdminData admindata) {
		Connection connection = JDBC_GetConnection.getConnection();

		if (connection != null) {

			try {
				String query = "insert into Admins(First_name , Last_name, Admin_age, Admin_Gender, Contact_number, Password, Status) values(?,?,?,?,?,?,?)";
				PreparedStatement prmt = connection.prepareStatement(query);
				prmt.setString(1, admindata.getAdminFirstName());
				prmt.setString(2, admindata.getAdminLastName());
				prmt.setInt(3, admindata.getAdminAge());
				prmt.setString(4, admindata.getAdminGender());
				prmt.setLong(5, admindata.getAdminContactNumber());
				prmt.setString(6, admindata.getAdminPassword());
				prmt.setString(7, "Pending");
				int execute = prmt.executeUpdate();
				if (execute > 0) {
					AdminData adminData = new AdminData();
					String fname = admindata.getAdminFirstName();

					String query2 = "select Admin_Id from Admins where First_name= ?";
					PreparedStatement prmt1 = connection.prepareStatement(query2);
					prmt1.setString(1, fname);
					ResultSet result = prmt1.executeQuery();
					while (result.next()) {
						adminData.setAdmin_Id(result.getInt("Admin_Id"));
					}
					if (adminData != null) {
						return adminData;
					}
				}
			} catch (SQLException e) {
				System.out.println("Error");

			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	@Override
	public ArrayList<AdminData> getAllAdmin() {

		Connection connection = JDBC_GetConnection.getConnection();
		ArrayList<AdminData> addDataList = new ArrayList<AdminData>();
		AdminData adminData = null;
		if (connection != null) {
			try {

				String query = " select Admin_Id, First_name, Last_name, Admin_age, Admin_Gender,\r\n"
						+ "Contact_number, Password from Admins where Status =?";
				PreparedStatement prmt = connection.prepareStatement(query);
				prmt.setString(1, "Pending");
				
				ResultSet result = prmt.executeQuery();
				while (result.next()) {
					adminData = new AdminData();
					
			 		adminData.setAdmin_Id(result.getInt("Admin_Id"));
					adminData.setAdminFirstName(result.getString("First_name"));
					adminData.setAdminLastName(result.getString("Last_name"));
					adminData.setAdminAge(result.getInt("Admin_age"));
					adminData.setAdminGender(result.getString("Admin_Gender"));
					adminData.setAdminContactNumber(result.getLong("Contact_number"));
					adminData.setAdminPassword(result.getString("Password"));
				
					addDataList.add(adminData);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return addDataList;
	}

	@Override
	public AdminData checkLoginStatus(int adminid, String adminpassword) {
		Connection connection = JDBC_GetConnection.getConnection();
		String loginStatus = null;
		AdminData adminData = null;

		if (connection != null) {
			try {
				String query = "select * from Admins where Admin_Id=? and Password=?";
				PreparedStatement prmt = connection.prepareStatement(query);
				prmt.setInt(1, adminid);
				prmt.setString(2, adminpassword);
				ResultSet result = prmt.executeQuery();
				while (result.next()) {
					int admin_id = result.getInt("Admin_Id");
					String first_Name = result.getString("First_name");
					System.out.println(first_Name);
					String last_Name = result.getString("Last_name");
					int age = result.getInt("Admin_age");
					String gender = result.getString("Admin_Gender");
					Long contacts = result.getLong("Contact_number");
					String password = (result.getString("Password"));
					loginStatus = result.getString("Status");
					System.out.println(loginStatus);
					adminData = new AdminData(admin_id, first_Name, last_Name, age, gender, contacts, password,
							loginStatus);
				}
				if (adminData != null) {
					return adminData;
				}
			}

			catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e);
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return null;
	}
}
