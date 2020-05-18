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
 * Servlet implementation class AcceptRequest
 */
@WebServlet("/AcceptRequest")
public class AcceptRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminDataDAO adminlogin;
	
	  public void init() {
		  adminlogin = new AdminDataImplementation();
	    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int adminid = Integer.parseInt(request.getParameter("admin_Id"));
		
		ArrayList<AdminData> adminPendinlist = adminlogin.acceptRequest(adminid);
		if(adminPendinlist  != null)
		{
			request.setAttribute("adminPendinlist", adminPendinlist);
			RequestDispatcher rd = request.getRequestDispatcher("/Admin-request.jsp");
			rd.forward(request, response);
		}
		/*
		 * else { request.setAttribute("request", "There is no Pending Request!");
		 * RequestDispatcher rd = request.getRequestDispatcher("/Admin-request.jsp");
		 * rd.forward(request, response); }
		 */
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
