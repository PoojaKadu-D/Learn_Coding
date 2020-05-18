package com.java;

public class TarinerData {

	int trainer_Id;
	String trainer_Name;
	Long trainer_ContactNo;
	String trainer_Email;
	String trainer_SkillSet;
	int trainer_exp;

	public TarinerData() {
		super();
	}

	public TarinerData(int trainer_Id, String trainer_Name, Long trainer_ContactNo, String trainer_Email,
			String trainer_SkillSet, int trainer_exp) {
		super();
		this.trainer_Id = trainer_Id;
		this.trainer_Name = trainer_Name;
		this.trainer_ContactNo = trainer_ContactNo;
		this.trainer_Email = trainer_Email;
		this.trainer_SkillSet = trainer_SkillSet;
		this.trainer_exp = trainer_exp;
	}

	public int getTrainer_exp() {
		return trainer_exp;
	}

	public void setTrainer_exp(int trainer_exp) {
		this.trainer_exp = trainer_exp;
	}

	public int getTrainer_Id() {
		return trainer_Id;
	}

	public void setTrainer_Id(int trainer_Id) {
		this.trainer_Id = trainer_Id;
	}

	public String getTrainer_Name() {
		return trainer_Name;
	}

	public void setTrainer_Name(String trainer_Name) {
		this.trainer_Name = trainer_Name;
	}

	public Long getTrainer_ContactNo() {
		return trainer_ContactNo;
	}

	public void setTrainer_ContactNo(Long trainer_ContactNo) {
		this.trainer_ContactNo = trainer_ContactNo;
	}

	public String getTrainer_Email() {
		return trainer_Email;
	}

	public void setTrainer_Email(String trainer_Email) {
		this.trainer_Email = trainer_Email;
	}

	public String getTrainer_SkillSet() {
		return trainer_SkillSet;
	}

	public void setTrainer_SkillSet(String trainer_SkillSet) {
		this.trainer_SkillSet = trainer_SkillSet;
	}

}
