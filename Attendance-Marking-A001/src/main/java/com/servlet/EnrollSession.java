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
import com.java.SessionData;

/**
 * Servlet implementation class EnrollSession
 */
@WebServlet("/EnrollSession")
public class EnrollSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	SessionDataDAO avasession;

	public void init() {
		avasession = new SessionDataImplementation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String erorr_Msg = "No Available Session";
		SessionDataDAO mapSession = new SessionDataImplementation();
		int s_id = Integer.parseInt(request.getParameter("Session_Id"));
		int u_id = Integer.parseInt(request.getParameter("UserId"));
		System.out.println(u_id +" "+s_id );
		
		String status = mapSession.mapUserSession(u_id, s_id);
		mapSession.setNotification(u_id);
		ArrayList<SessionData> availableSession = mapSession.getAllSession();
		if(availableSession != null) {
			request.setAttribute("Session_Id", s_id);
			request.setAttribute("status", status);
			request.setAttribute("u_id", u_id);
			request.setAttribute("users", "User has ");
			System.out.println("hii");
			request.setAttribute("Session_Id", s_id);
			request.setAttribute("availableSession", availableSession);
			RequestDispatcher rd = request.getRequestDispatcher("/ava-Session.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("erorr_Msg", erorr_Msg);
			RequestDispatcher rd = request.getRequestDispatcher("/User-Home.jsp");
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
