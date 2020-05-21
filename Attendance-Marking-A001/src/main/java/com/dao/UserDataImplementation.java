package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.java.*;
import com.controller.JDBC_GetConnection;

public class UserDataImplementation implements UserdataDAO {

	@Override
	public UserData addUserDeatails(UserData udata) {
		Connection conn = JDBC_GetConnection.getConnection();
		if(conn !=null) {
			
		try {
			String query = "insert into Users(First_name , Last_name, Email, Password, Age, Gender, ContactNumber) values(?,?,?,?,?,?,?)";
			PreparedStatement prmt = conn.prepareStatement(query);
			prmt.setString(1, udata.getFirstName());
			prmt.setString(2, udata.getLastName());
			prmt.setString(3, udata.getEmailId());
			prmt.setString(4, udata.getPassword());
			prmt.setInt(5, udata.getUserAge());
			prmt.setString(6, udata.getUserGender());
			prmt.setLong(7, udata.getUserContactNumber());
			int execute = prmt.executeUpdate();
			String password = udata.getPassword();
			if(execute >0){
				UserData usdata = new UserData();
				
				String query2 = "select Employee_Id from Users where Password= ?";
				PreparedStatement prmt1 = conn.prepareStatement(query2);
				prmt1.setString(1, password);
				ResultSet result = prmt1.executeQuery();
				while (result.next()) {
					usdata.setUser_id(result.getInt("Employee_Id"));
				}
				if (usdata != null) {
					return usdata;
				}
	
			}
		}catch(SQLException e) {
			System.out.println("Error");

			
		}
		finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		}
		
		
		return null;
	}

	@Override
	public UserData checkLoginStatus(int userid, String userpassword) {
		UserData userdata = new UserData();
		Connection connection = JDBC_GetConnection.getConnection();
		
		if(connection != null) {
		try {
			
			String query = "select * from Users where Employee_Id=? and Password=?";
			PreparedStatement prmt = connection.prepareStatement(query);
			prmt.setInt(1, userid);
			prmt.setString(2, userpassword);
			ResultSet result = prmt.executeQuery();
			
			while (result.next()) {
				userdata.setUser_id(result.getInt("Employee_Id"));
				userdata.setFirstName(result.getString("First_name"));
				userdata.setLastName(result.getString("Last_name"));
				userdata.setEmailId(result.getString("Email"));
				userdata.setPassword(result.getString("Password"));
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
		return userdata;
}
}
