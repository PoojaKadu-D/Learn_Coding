package com.dao;

import java.util.ArrayList;

import com.java.Notification;


public interface NotiDAO {
	// User Notification
	public ArrayList<Notification> getAllNotification(int userid);
}
