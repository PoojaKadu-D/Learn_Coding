package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.controller.JDBC_GetConnection;
import com.java.AdminData;
import com.java.SessionData;

public class SessionDataImplementation implements SessionDataDAO {

	@Override
	public String addSession(SessionData sessiondata) {
		Connection conn = JDBC_GetConnection.getConnection();
		if (conn != null) {

			try {
				// convertion date = string-java-sql
				String dateS = sessiondata.getSession_Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				java.util.Date date1 = sdf.parse(dateS);
				Date sqlDate = new java.sql.Date(date1.getTime());
				System.out.println(sqlDate);
				String query = "insert into session(Session_desc, Skills_setS, Session_date, Session_time, available_Slots) values(?,?,?,?,?)";
				PreparedStatement prmt = conn.prepareStatement(query);
				prmt.setString(1, sessiondata.getSession_Description());
				prmt.setString(2, sessiondata.getSession_SkillSet());
				prmt.setDate(3, sqlDate);
				prmt.setInt(4, sessiondata.getSession_time());
				prmt.setInt(5, sessiondata.getAvailable_Slot());

				int execute = prmt.executeUpdate();
				System.out.println(execute);
				if (execute > 0) {
					return "Session details are submitted successfully...";
				}
			} catch (SQLException | ParseException e) {
				System.out.println("Error");

			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public ArrayList<SessionData> getAllSession() {

		Connection connection = JDBC_GetConnection.getConnection();
		ArrayList<SessionData> addDataList = new ArrayList<SessionData>();
		SessionData session = null;
		if (connection != null) {
			try {

				String query = " select Session_Id, Session_desc from session";
				PreparedStatement prmt = connection.prepareStatement(query);
				ResultSet result = prmt.executeQuery();
				while (result.next()) {
					session = new SessionData();
					session.setSession_Id(result.getInt("Session_Id"));
					session.setSession_Description(result.getString("Session_desc"));

					addDataList.add(session);
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
	public SessionData getAllDetailSession(int id) {
		Connection connection = JDBC_GetConnection.getConnection();
		SessionData session = null;
		if (connection != null) {
			try {

				String query = " select * from session where Session_Id = ?";
				PreparedStatement prmt = connection.prepareStatement(query);
				prmt.setInt(1, id);
				ResultSet result = prmt.executeQuery();
				while (result.next()) {
					session = new SessionData();
					session.setSession_Id(result.getInt("Session_Id"));
					session.setSession_Description(result.getString("Session_desc"));
					session.setSession_SkillSet(result.getString("Skills_setS"));

					Date date = result.getDate("Session_date");
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
					String strDate = formatter.format(date);
					session.setSession_Date(strDate);
					session.setSession_time(result.getInt("Session_time"));
					session.setAvailable_Slot(result.getInt("available_Slots"));
					if(session !=null) {
						return session;
					}
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
		return null;
	}

	@Override
	public String mapUserSession(int user_Id, int session_Id) {
		Connection conn = JDBC_GetConnection.getConnection();
		if (conn != null) {

			try {
				
				String query = "insert into alot_session (Employee_Id, Sessi_Id) values(?,?)";
				PreparedStatement prmt = conn.prepareStatement(query);
				prmt.setInt(1, user_Id);
				prmt.setInt(2, session_Id);
				int execute = prmt.executeUpdate();
				System.out.println(execute);
				if (execute > 0) {
					return "enrolled for the session successfully, for session id ";
				}
			} catch (SQLException e) {
				System.out.println("Error");

			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public void setNotification(int u_id) {
		Connection conn = JDBC_GetConnection.getConnection();
		if (conn != null) {

			try {
				
				String query = "insert into noti_user value(?,?);";
				PreparedStatement prmt = conn.prepareStatement(query);
				prmt.setInt(1, u_id);
				prmt.setString(2, "You have Enrolled for Session successfully");
				int execute = prmt.executeUpdate();
				System.out.println(execute);
				
			} catch (SQLException e) {
				System.out.println("Error");

			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
