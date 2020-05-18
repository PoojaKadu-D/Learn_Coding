package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.controller.JDBC_GetConnection;
import com.java.SessionData;

public class SessionDataImplementation implements SessionDataDAO {

	@Override
	public String addSession(SessionData sessiondata) {
		Connection conn = JDBC_GetConnection.getConnection();
		if(conn !=null) {
			
			
		try {
			//convertion date = string-java-sql
			String dateS = sessiondata.getSession_Date();
			SimpleDateFormat da1= new SimpleDateFormat("DD-MM-YYYY");
			java.util.Date date1 = da1.parse(dateS);	
			Date sqlDate = new java.sql.Date(date1.getTime());
			
			String query = "insert into session (Session_desc, Skills_setS, Session_date, Session_time, available_Slots) values(?,?,?,?,?)";
			PreparedStatement prmt = conn.prepareStatement(query);
			prmt.setString(1, sessiondata.getSession_Description());
			prmt.setString(2, sessiondata.getSession_SkillSet());
			prmt.setDate(3, sqlDate);
			prmt.setInt(4, sessiondata.getSession_time());
			prmt.setInt(5, sessiondata.getAvailable_Slot());
			
			int execute = prmt.executeUpdate();
			System.out.println(execute);
			if(execute > 0){
				return "Your details are submitted successfully...";
			}
		}catch(SQLException | ParseException  e) {
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

}
