package com.servlet;

import java.io.IOException;

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
 * Servlet implementation class AddSession
 */
@WebServlet("/AddSession")
public class AddSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionDataDAO sessiondao = new SessionDataImplementation();
		SessionData sessiondata =  new SessionData();
		
		String session_Description = request.getParameter("sessiondes");
		String session_SkillSet = request.getParameter("skillsets");
		String session_Date = request.getParameter("session-date");
		int session_time = Integer.parseInt(request.getParameter("sessiontime"));
		int available_Slot = Integer.parseInt(request.getParameter("a_slots"));
		
		sessiondata.setSession_Description(session_Description);
		sessiondata.setSession_SkillSet(session_SkillSet);
		sessiondata.setSession_Date(session_Date);
		sessiondata.setSession_time(session_time);
		sessiondata.setAvailable_Slot(available_Slot);
		
		String status = sessiondao.addSession(sessiondata);
		if(status != null) {
			
			request.setAttribute("message",status );
			RequestDispatcher rd = request.getRequestDispatcher("/Add-Session.jsp");
			rd.forward(request,response);

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
