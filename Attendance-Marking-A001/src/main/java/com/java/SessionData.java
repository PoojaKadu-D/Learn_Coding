package com.java;

public class SessionData {

	int session_Id;
	String session_Description;
	String session_SkillSet;
	String session_Date;
	int session_time;
	int available_Slot;

	public SessionData() {
		super();
	}

	public SessionData(int session_Id, String session_Description) {
		super();
		this.session_Id = session_Id;
		this.session_Description = session_Description;
	}

	public SessionData(int session_Id, String session_Description, String session_SkillSet, String session_Date,
			int session_time, int available_Slot) {
		super();
		this.session_Id = session_Id;
		this.session_Description = session_Description;
		this.session_SkillSet = session_SkillSet;
		this.session_Date = session_Date;
		this.session_time = session_time;
		this.available_Slot = available_Slot;
	}

	public int getSession_Id() {
		return session_Id;
	}

	public void setSession_Id(int session_Id) {
		this.session_Id = session_Id;
	}

	public String getSession_Description() {
		return session_Description;
	}

	public void setSession_Description(String session_Description) {
		this.session_Description = session_Description;
	}

	public String getSession_SkillSet() {
		return session_SkillSet;
	}

	public void setSession_SkillSet(String session_SkillSet) {
		this.session_SkillSet = session_SkillSet;
	}

	public String getSession_Date() {
		return session_Date;
	}

	public void setSession_Date(String session_Date) {
		this.session_Date = session_Date;
	}

	public int getSession_time() {
		return session_time;
	}

	public void setSession_time(int session_time) {
		this.session_time = session_time;
	}

	public int getAvailable_Slot() {
		return available_Slot;
	}

	public void setAvailable_Slot(int available_Slot) {
		this.available_Slot = available_Slot;
	}

}
