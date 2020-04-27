package Details_p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Details_Implements implements Details_DAO {
	public static final String url  = "jdbc:mysql://localhost:3306/java_jdbc";
	public static String username = "root";
	public static String password = "root";
	public static String driver ="com.mysql.cj.jdbc.Driver";
	
	

	public Connection getConnection(){
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
	
	@Override
	public String addUserDeatails(FetchData fedata) {
		System.out.println("adddddd");
		Connection conn = getConnection();
		if(conn !=null) {
			
		try {
			String query = "insert into userData1(name , password, email, mobileNO) values(?,?,?,?)";
			PreparedStatement prmt = conn.prepareStatement(query);
			prmt.setString(1, fedata.getUname());
			prmt.setString(2, fedata.getPassword());
			prmt.setString(3, fedata.getEmail());
			prmt.setLong(4, fedata.getMobileno());
			int execute = prmt.executeUpdate();
			if(execute >0){
				return "Data inserted Successfully!";
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

	@Override
	public FetchData checkLoginCredential(String username, String password) {
		Connection conn = getConnection();
		
		System.out.println(username);
		System.out.println(password);
		FetchData fetchData = null;
		System.out.println("get adadasdasd");
		
		if(conn!=null) {
			
		try {
			String sql = "select * from userData1 where name=? and password=?";
			PreparedStatement prmt= conn.prepareStatement(sql);
			prmt.setString(1,username );
			prmt.setString(2, password);
			ResultSet result = prmt.executeQuery();
			while(result.next()) {
				fetchData = new FetchData();
				fetchData.setId(result.getInt("id"));
				fetchData.setUname(result.getString("name"));
				fetchData.setPassword(result.getString("password"));
				fetchData.setEmail(result.getString("email"));
				fetchData.setMobileno(result.getLong("mobileNO"));
				 
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		}
		
		return fetchData;
	}

	/*
	 * private void log(String string) { // TODO Auto-generated method stub
	 * 
	 * }
	 */

	@Override
	public ArrayList<FetchData> getAllDetails() {

		ArrayList<FetchData> addDataList = new ArrayList<FetchData>();
		Connection conn = getConnection();
			if(conn!=null) {
			//System.out.println("asdasdasddsaa");
			try {
				String checkQuery = "select * from userData1";
				PreparedStatement prmt = conn.prepareStatement(checkQuery);
				ResultSet result = prmt.executeQuery();
				while(result.next()) {
					FetchData fetchdata = new FetchData();
					fetchdata.setId(result.getInt("id"));
					fetchdata.setUname(result.getString("name"));
					fetchdata.setPassword(result.getString("password"));
					fetchdata.setEmail(result.getString("email"));
					fetchdata.setMobileno(result.getLong("mobileNO"));
					addDataList.add(fetchdata);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			}
		return addDataList;
	}

	@Override
	public  FetchData getElementbyId(Integer id) {
		FetchData fetchData = null;
		Connection  conn=getConnection();
		String sql= "select * from userData1 where id=?";
		
		try {
		PreparedStatement prmt = conn.prepareStatement(sql);
		prmt.setInt(1, id);
		ResultSet result = prmt.executeQuery();
		while(result.next()) {
			fetchData = new FetchData();
			fetchData.setId(result.getInt("id"));
			fetchData.setUname(result.getString("name"));
			fetchData.setPassword(result.getString("password"));
			fetchData.setEmail(result.getString("email"));
			fetchData.setMobileno(result.getLong("mobileNO"));
			
		}
		
		
	}catch( SQLException e) {
		e.printStackTrace();
	}
		finally {
			try {
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return fetchData;
	}

	@Override
	public boolean updateDetailById(FetchData fetch_data) {
		
		FetchData f = new FetchData();
		Connection conn = getConnection();
		
		try {
			String update ="Update userData1 set  name=?, password=?, email=?, mobileNO=? where id=?";
			PreparedStatement prmt = conn.prepareStatement(update);
			
			prmt.setString(1, fetch_data.getUname());
			prmt.setString(2, fetch_data.getPassword());
			prmt.setString(3, fetch_data.getEmail());
			prmt.setLong(4, fetch_data.getMobileno());
			prmt.setInt(5, fetch_data.getId());
			
			int executeUpdate = prmt.executeUpdate();
			if(executeUpdate>0) {
				return true;
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
		try {
			conn.close();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		}
		return false;
	}

	@Override
	public boolean deleteDetailById(Integer id) {
		
		Connection conn = getConnection();
		
		try {
			String delete = "delete from userData1 where id=?";
			PreparedStatement prmt = conn.prepareStatement(delete);
			prmt.setInt(1, id);
			int executeUpdate = prmt.executeUpdate();
			if(executeUpdate>0) {
				return true;
			}
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return false;
	}

	
	
}
