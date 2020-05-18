package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDataDAO;
import com.dao.AdminDataImplementation;
import com.java.AdminData;

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
		String pending_message = "Your request is pending, try Again!";
		String register_msg = "Please Register your data!";
		String reject_Msg = "Your request is rejected, you don't have permission to access this account. Please try another account...";

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
				RequestDispatcher rd = request.getRequestDispatcher("/Admin-Home.jsp");
				rd.forward(request, response);

			} else if (status.equalsIgnoreCase("rejected")) {
				request.setAttribute("reject_Msg", reject_Msg);
				RequestDispatcher rd = request.getRequestDispatcher("/AdminLogin.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("pending_message", pending_message);
				RequestDispatcher rd = request.getRequestDispatcher("/AdminLogin.jsp");
				rd.forward(request, response);
			}
		} else {
			request.setAttribute("register_msg", register_msg);
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
