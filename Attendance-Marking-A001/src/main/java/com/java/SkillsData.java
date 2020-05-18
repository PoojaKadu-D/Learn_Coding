package com.java;

public class SkillsData {

	int skill_Id;
	String skill_Type;
	String skill_Description;

	public SkillsData() {
		super();
	}

	public SkillsData(int skill_id, String skill_type, String skill_description) {
		super();
		skill_Id = skill_id;
		skill_Type = skill_type;
		skill_Description = skill_description;
	}

	public int getSkill_id() {
		return skill_Id;
	}

	public void setSkill_id(int skill_id) {
		skill_Id = skill_id;
	}

	public String getSkill_type() {
		return skill_Type;
	}

	public void setSkill_type(String skill_type) {
		skill_Type = skill_type;
	}

	public String getSkill_description() {
		return skill_Description;
	}

	public void setSkill_description(String skill_description) {
		skill_Description = skill_description;
	}

}
