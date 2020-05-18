package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.controller.JDBC_GetConnection;
import com.java.TarinerData;

public class TrainerDataImplementation implements TrainerDataDAO {

	@Override
	public String setTrainer(TarinerData trainerdata) {
		Connection conn = JDBC_GetConnection.getConnection();
		if(conn !=null) {
			
		try {
			String query = "insert into trainers( Trainer_name, Contact_number, Skill_setT, Trainer_email, Trainer_exp) values(?,?,?,?,?)";
			PreparedStatement prmt = conn.prepareStatement(query);
			prmt.setString(1, trainerdata.getTrainer_Name());
			prmt.setLong(2, trainerdata.getTrainer_ContactNo());
			prmt.setString(3, trainerdata.getTrainer_SkillSet());
			prmt.setString(4, trainerdata.getTrainer_Email());
			prmt.setInt(5, trainerdata.getTrainer_exp());
			
			int execute = prmt.executeUpdate();
			if(execute >0){
				return "Your details are submitted successfully...";
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
