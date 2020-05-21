package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.controller.JDBC_GetConnection;
import com.java.Notification;
import com.java.SessionData;

public class NotiDataImplementation implements NotiDAO {

	@Override
	public ArrayList<Notification> getAllNotification(int userId) {
		Connection connection = JDBC_GetConnection.getConnection();
		ArrayList<Notification> addDataList = new ArrayList<Notification>();
		SessionData session = null;
		if (connection != null) {
			try {

				String query = " select Noti from noti_user where id=?";
				PreparedStatement prmt = connection.prepareStatement(query);
				prmt.setInt(1, userId);
				ResultSet result = prmt.executeQuery();
				while (result.next()) {
					Notification noti = new Notification();
					noti.setNoti(result.getString("Noti"));

					addDataList.add(noti);
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

}
