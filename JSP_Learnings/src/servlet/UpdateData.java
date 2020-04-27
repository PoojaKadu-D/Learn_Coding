package servlet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Details_p.Details_DAO;
import Details_p.Details_Implements;
import Details_p.FetchData;


@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateData() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FetchData fetchdata = new FetchData();
		
		fetchdata.setId(Integer.parseInt(request.getParameter("id")));
		fetchdata.setUname(request.getParameter("username"));
		fetchdata.setPassword(request.getParameter("password"));
		fetchdata.setEmail(request.getParameter("email"));
		fetchdata.setMobileno(Long.parseLong(request.getParameter("mobileno")));
		
		Details_DAO updateDAO = new Details_Implements();
		boolean updateDetailById= updateDAO.updateDetailById(fetchdata);
		
		if(updateDetailById==true) {
			RequestDispatcher re = request.getRequestDispatcher("/Index.jsp");
			re.forward(request, response);
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	
}
