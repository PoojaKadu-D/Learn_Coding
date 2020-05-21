package attendance.marking.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import attendance.marking.admin.dao.AdminDataDAO;
import attendance.marking.admin.dao.AdminDataImplementation;
import attendance.marking.user.obj.AdminData;

@WebServlet("/adminRegistration")
public class adminRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminDataDAO admindao = new AdminDataImplementation();
//		int id = Integer.parseInt(request.getParameter(""));
		String adminFirstName = request.getParameter("empfname");
		String adminLastName = request.getParameter("emplname") ;
		int adminAge = Integer.parseInt(request.getParameter("ageadmin"));
		String adminGender = request.getParameter("gender");
		Long adminContactNumber = Long.parseLong(request.getParameter("contact"));
		String adminPassword = request.getParameter("password");
		AdminData admindata = new AdminData(adminFirstName, adminLastName, adminAge, adminGender, adminContactNumber, adminPassword);
		
		AdminData adminTemp = admindao.addUserDeatails(admindata);
		String status = "Your details are submitted successfully, welcome ";
		
		if(adminTemp != null) {
			request.setAttribute("message",status );
			request.setAttribute("id"," and your id is" );
			request.setAttribute("adminFirstName",adminFirstName );
			request.setAttribute("admin",adminTemp );
			RequestDispatcher rd = request.getRequestDispatcher("/AdminLogin.jsp");
			rd.forward(request,response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
