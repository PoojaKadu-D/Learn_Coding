package servlet.com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.com.BookDao;
import model.com.Book;


@WebServlet(name = "BookServlet", urlPatterns = "/")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookDao bookDao;
    
    public void init() {
    	bookDao = new BookDao();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		switch (action) {
		case "/new": {
			 showNewForm(request , response);
			break;
		}
		case "/insert": {
			addNewBook(request, response);
			
			break;
		}
		case "/update": {
			udateBook(request, response);
			break;
		}
		case "/edit": {
			editbookdetails(request, response);
				break;
		}
		case "/delete": {
			deleteBookById(request, response);
			break;
		}
		default:
			booklist(request, response);
			break;
		}
	}
	
	//methods list 
	
	// method to get all book
	private void booklist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Book> list = bookDao.getAllbook();
		System.out.println("hi");
		request.setAttribute("booklist", list);
		RequestDispatcher rd = request.getRequestDispatcher("/BookList.jsp");
		rd.forward(request,response);
	
	}
	
	//method to show new form
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/BookForm.jsp");
		rd.forward(request,response);
	}
	
	//method to add new book
	private void addNewBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));
		
		bookDao.addbook(new Book(title , author , price));
		response.sendRedirect("list");
	}
	
	//method to edit book details
	private void editbookdetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Book book = bookDao.getBookById(id);
		request.setAttribute("book", book);
		RequestDispatcher rd = request.getRequestDispatcher("/BookForm.jsp");
		rd.forward(request, response);
	
	}
	//handle update book
	private void udateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));
		
		bookDao.updatebookById(new Book(id, title, author, price));
		response.sendRedirect("list");
	}
	
	//delete book after selecting id
	private void deleteBookById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		bookDao.deleteBookById(id);
		response.sendRedirect("list");
		
	}
}
