package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDataDAO;
import com.dao.AdminDataImplementation;
import com.java.AdminData;

/**
 * Servlet implementation class AdminRequests
 */
@WebServlet("/AdminRequests")
public class AdminRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AdminDataDAO adminlogin;

	public void init() {
		adminlogin = new AdminDataImplementation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// AdminData admin = new AdminData();
		ArrayList<AdminData> adminPendinlist = adminlogin.getAllAdmin();
		String erorr_Msg = "No Request is Pending";
		HttpSession session = request.getSession(false);
		
		if (session.getAttribute("name") != null && adminPendinlist != null) {
			request.setAttribute("welcome", " Welcome ");
			/* request.setAttribute("admin", admin); */
			request.setAttribute("adminPendinlist", adminPendinlist);
			System.out.println("hii");
			RequestDispatcher rd = request.getRequestDispatcher("/Admin-request.jsp");
			rd.forward(request, response);

		} else {
			request.setAttribute("erorr_Msg", erorr_Msg);
			RequestDispatcher rd = request.getRequestDispatcher("/SuperUser-functions.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
