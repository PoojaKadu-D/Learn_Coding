package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.controller.JDBC_GetConnection;
import com.java.SkillsData;

public class SkillsDataImplementation implements SkillsDataDAO {

	@Override
	public String setSkills(SkillsData skilldata) {
		Connection conn = JDBC_GetConnection.getConnection();
		if(conn !=null) {
			
		try {
			String query = "insert into skills( Skill_type, Skill_description) values(?,?)";
			PreparedStatement prmt = conn.prepareStatement(query);
			prmt.setString(1, skilldata.getSkill_type());
			prmt.setString(2, skilldata.getSkill_description());
			
			int execute = prmt.executeUpdate();
			if(execute >0){
				return "Skill details are submitted successfully...";
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

}
