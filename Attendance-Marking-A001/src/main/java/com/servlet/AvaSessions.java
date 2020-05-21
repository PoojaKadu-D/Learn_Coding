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

@WebServlet("/AvaSessions")
public class AvaSessions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SessionDataDAO avasession;

	public void init() {
		avasession = new SessionDataImplementation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String erorr_Msg = "No Available Session";
		ArrayList<SessionData> availableSession = avasession.getAllSession();
		int id = Integer.parseInt(request.getParameter("UserId"));
		
		System.out.println(id+"userId");
	
		if (availableSession != null) {
			request.setAttribute("u_id", id);
			
			request.setAttribute("availableSession", availableSession);
			System.out.println("hii");
			RequestDispatcher rd = request.getRequestDispatcher("/ava-Session.jsp");
			rd.forward(request, response);
			

		} else {
			request.setAttribute("erorr_Msg", erorr_Msg);
			RequestDispatcher rd = request.getRequestDispatcher("/User-Home.jsp");
			rd.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
