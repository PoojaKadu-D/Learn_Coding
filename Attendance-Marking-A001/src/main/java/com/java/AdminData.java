package com.java;

public class AdminData {

	int admin_Id;
	String adminFirstName;
	String adminLastName;
	int adminAge;
	String adminGender;
	Long adminContactNumber;
	String adminPassword;
	String status;
	
	public AdminData() {
		super();
	}

	public AdminData(int admin_Id) {
		super();
		this.admin_Id = admin_Id;
	}

	public AdminData(String status, int admin_Id, String adminFirstName, String adminLastName)
	 {
		super();
		this.status = status;
		this.admin_Id = admin_Id ;
		this.adminFirstName = adminFirstName;
		this.adminLastName = adminLastName;
	}
	
	public AdminData(int admin_Id, String adminFirstName, String adminLastName, int adminAge, String adminGender,
			Long adminContactNumber, String adminPassword, String status) {
		super();
		this.admin_Id = admin_Id;
		this.adminFirstName = adminFirstName;
		this.adminLastName = adminLastName;
		this.adminAge = adminAge;
		this.adminGender = adminGender;
		this.adminContactNumber = adminContactNumber;
		this.adminPassword = adminPassword;
		this.status = status;
	}

	public AdminData(String adminFirstName, String adminLastName, int adminAge, String adminGender,
			Long adminContactNumber, String adminPassword) {
		super();
		this.adminFirstName = adminFirstName;
		this.adminLastName = adminLastName;
		this.adminAge = adminAge;
		this.adminGender = adminGender;
		this.adminContactNumber = adminContactNumber;
		this.adminPassword = adminPassword;
	}

	public AdminData(int admin_Id, String adminFirstName, String adminLastName, int adminAge, String adminGender, Long adminContactNumber, String adminPassword) {
		super();
		this.admin_Id = admin_Id ;
		this.adminFirstName = adminFirstName;
		this.adminLastName = adminLastName;
		this.adminAge = adminAge;
		this.adminGender = adminGender;
		this.adminContactNumber = adminContactNumber;
		this.adminPassword = adminPassword;
		
	}
	
	public int getAdmin_Id() {
		return admin_Id;
	}

	public void setAdmin_Id(int admin_Id) {
		this.admin_Id = admin_Id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAdminFirstName() {
		return adminFirstName;
	}
	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}
	public String getAdminLastName() {
		return adminLastName;
	}
	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}
	public int getAdminAge() {
		return adminAge;
	}
	public void setAdminAge(int adminAge) {
		this.adminAge = adminAge;
	}
	public String getAdminGender() {
		return adminGender;
	}
	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}
	public Long getAdminContactNumber() {
		return adminContactNumber;
	}
	public void setAdminContactNumber(Long adminContactNumber) {
		this.adminContactNumber = adminContactNumber;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	
}
