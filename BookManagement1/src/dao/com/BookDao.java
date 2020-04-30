package dao.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.com.Book;
import utils.jdbcutils;

public class BookDao {

	public ArrayList<Book> getAllbook() {
		
		Connection connection = jdbcutils.getConnection();
		ArrayList<Book> arryBook = new ArrayList<Book>();
		
		if(connection !=null) {
			try {
				
				String getData= "select * from book";
				PreparedStatement prmt= connection.prepareStatement(getData);
				ResultSet result = prmt.executeQuery();
				
				while(result.next()) {
					//Book book;
					int id= result.getInt("book_id");
					String title = result.getString("title");
					String author = result.getString("author");
					float price = result.getFloat("price");
					
					arryBook.add(new Book(id, title , author , price));
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		return arryBook;
	}
	public String addbook(Book book) {
		Connection connection = jdbcutils.getConnection();
			if(connection !=null) {
				
			try {
				String query = "insert into book(title, author, price) values(?,?,?)";
				PreparedStatement prmt = connection.prepareStatement(query);
					
				prmt.setString(1, book.getTitle());
				prmt.setString(2, book.getAuthor());
				prmt.setFloat(3, book.getPrice());
				int execute = prmt.executeUpdate();
				if(execute >0){
					return "Data inserted Successfully!";
				}
			}catch(SQLException e) {
				e.printStackTrace();
				
			}
			finally {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			}
			
			return null;
		}
	public boolean updatebookById(Book book) {
		
		//Book book1 = new Book();
		Connection conn = jdbcutils.getConnection();
		
		try {
			String update ="Update book set title=?, author=?, price=? where book_id=?";
			PreparedStatement prmt = conn.prepareStatement(update);
			
			prmt.setString(1, book.getTitle());
			prmt.setString(2, book.getAuthor());
			prmt.setFloat(3, book.getPrice());
			prmt.setInt(4, book.getId());
			
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

	public boolean deleteBookById(int id) {
		Connection connection = jdbcutils.getConnection();
		try {
			String delete="delete from book where book_id=?";
			PreparedStatement prmt = connection.prepareStatement(delete);
			prmt.setInt(1, id);
			int execute = prmt.executeUpdate();
			if(execute>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		return false;
	}

	
	public  Book getBookById(int id) {
		Book book = null;
		Connection  connection = jdbcutils.getConnection();
		String sql= "select * from book where book_id=?";
		
		try {
		PreparedStatement prmt = connection.prepareStatement(sql);
		prmt.setInt(1, id);
		ResultSet result = prmt.executeQuery();
		while(result.next()) {
			book = new Book();
			int id1 = result.getInt("book_id");
			String title = result.getString("title");
			String author = result.getString("author");
			float price =  result.getFloat("price");
			
			book = new Book(id1, title, author, price);
		}
	
			}catch (SQLException e) {
				e.printStackTrace();
				}
		finally {
			try {
				connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return book;
	}
}
