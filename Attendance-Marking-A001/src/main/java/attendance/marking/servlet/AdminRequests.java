package attendance.marking.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import attendance.marking.admin.dao.AdminDataDAO;
import attendance.marking.admin.dao.AdminDataImplementation;
import attendance.marking.user.obj.AdminData;

/**
 * Servlet implementation class AdminRequests
 */
@WebServlet("/AdminRequests")
public class AdminRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRequests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminDataDAO adminlogin = new AdminDataImplementation();
		AdminData admin = new AdminData();
		ArrayList<AdminData> adminPendinlist= adminlogin.getAllAdmin();
		String erorr_Msg = "No Request is Pending";	
		if(adminPendinlist != null) {
			request.setAttribute("erorr_Msg", "Welcome");
			RequestDispatcher rd = request.getRequestDispatcher("/Admin-request.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("erorr_Msg", erorr_Msg);
			RequestDispatcher rd = request.getRequestDispatcher("/AdminLogin.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
