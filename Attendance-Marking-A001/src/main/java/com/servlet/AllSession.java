package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SessionDataDAO;
import com.dao.SessionDataImplementation;
import com.java.AdminData;
import com.java.SessionData;

/**
 * Servlet implementation class AllSession
 */
@WebServlet("/AllSession")
public class AllSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SessionDataDAO sessionData;

	public void init() {
		sessionData = new SessionDataImplementation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("Session_Id"));
		SessionData session = sessionData.getAllDetailSession(id);
		String erorr_Msg = "No Available Session";
		int id1 = Integer.parseInt(request.getParameter("UserId"));
		
		System.out.println(id+"session"+id1);
		if (session != null) {
			request.setAttribute("session", session);
			System.out.println("hii");
			request.setAttribute("u_id", id1);
			request.setAttribute("Session_Id", id);
			RequestDispatcher rd = request.getRequestDispatcher("/ava-all-Session.jsp");
			rd.forward(request, response);

		} else {
			request.setAttribute("erorr_Msg", erorr_Msg);
			request.setAttribute("userId", id1);
			request.setAttribute("Session_Id", id);
			RequestDispatcher rd = request.getRequestDispatcher("/User-Home.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
