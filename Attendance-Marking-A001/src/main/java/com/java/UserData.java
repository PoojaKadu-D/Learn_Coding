package com.java;

public class UserData {

	int user_id;
	String userFirstName;
	String userLastName;
	String userEmailId;
	String userPassword;
	int userAge;
	String userGender;
	Long userContactNumber;
	
	
	public UserData() {
		super();
	}

	public UserData(int user_id) {
		super();
		this.user_id = user_id;
	}

	public UserData(String firstName, String lastName, String emailId, String password) {
		super();
		this.userFirstName = firstName;
		this.userLastName = lastName;
		this.userEmailId = emailId;
		this.userPassword = password;
	}
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirstName() {
		return userFirstName;
	}
	public void setFirstName(String firstName) {
		this.userFirstName = firstName;
	}
	public String getLastName() {
		return userLastName;
	}
	public void setLastName(String lastName) {
		this.userLastName = lastName;
	}
	public String getEmailId() {
		return userEmailId;
	}
	public void setEmailId(String emailId) {
		this.userEmailId = emailId;
	}
	public String getPassword() {
		return userPassword;
	}
	public void setPassword(String password) {
		this.userPassword = password;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public Long getUserContactNumber() {
		return userContactNumber;
	}

	public void setUserContactNumber(Long userContactNumber) {
		this.userContactNumber = userContactNumber;
	}

	
}
