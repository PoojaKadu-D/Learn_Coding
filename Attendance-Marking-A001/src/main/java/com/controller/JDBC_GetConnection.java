package com.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_GetConnection {
	public static final String url="jdbc:mysql://localhost:3306/attendance_marking";
	public static String username= "root";
	public static String password= "root";
	public static String driver="com.mysql.cj.jdbc.Driver";
	
	public static Connection getConnection(){
		 Connection conn = null;
		
	
		 try {
			 Class.forName(driver);
		 }catch(ClassNotFoundException e) {
			 e.printStackTrace();
			 System.out.println("Unable to find Class");
		 }
		 try {
			 conn = DriverManager.getConnection(url,username, password);
		 }catch(SQLException e) {
			 System.out.println("Unable to Connect with DB");
		 }
		 return conn;
	}
	
	public static void printSQLException(SQLException ex) {
		for(Throwable e : ex) {
			if(e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLSTATE: "+ ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: "+ e.getMessage());
				Throwable t = ex.getCause();
				while(t != null) {
					System.out.println("Cause: "+ t);
					t = t.getCause();
				}
			}
		}
	}
}
