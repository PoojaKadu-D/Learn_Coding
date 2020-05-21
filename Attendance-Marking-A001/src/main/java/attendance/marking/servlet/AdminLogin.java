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
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDataDAO adminlogin = new AdminDataImplementation();
		AdminData admin = null;
		String status = null;
		String error_Message = "Your request is pending, try Again!";
		String erorr_Msg = "Please Register your data!";

		int adminid = Integer.parseInt(request.getParameter("adminid"));
		String adminpassword = request.getParameter("adminpassword");
		admin = adminlogin.checkLoginStatus(adminid, adminpassword);

		if (admin != null) {

			status = admin.getStatus();
			System.out.println(status + adminid);
			String fName = admin.getAdminFirstName();
			String lNAme = admin.getAdminLastName();

			// ArrayList<AdminData> adminPendinlist= adminlogin.getAllAdmin(adminid,
			// adminpassword);
			// status = admin.getStatus();

			if (status.equalsIgnoreCase("accepted")) {
				request.setAttribute("adminid", adminid);
				request.setAttribute("fName", fName);
				request.setAttribute("lNAme", lNAme);
				RequestDispatcher rd = request.getRequestDispatcher("/Admin-function.jsp");
				rd.forward(request, response);

			} else {
				request.setAttribute("error_Message", error_Message);
				RequestDispatcher rd = request.getRequestDispatcher("/AdminLogin.jsp");
				rd.forward(request, response);
			}
		} else {
			request.setAttribute("erorr_Msg", erorr_Msg);
			RequestDispatcher rd = request.getRequestDispatcher("/AdminLogin.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
