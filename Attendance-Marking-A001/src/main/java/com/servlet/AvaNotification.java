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

import com.dao.NotiDAO;
import com.dao.NotiDataImplementation;
import com.java.Notification;


@WebServlet("/AvaNotification")
public class AvaNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	NotiDAO notifi;

	public void init() {
		notifi = new NotiDataImplementation();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		response.getWriter().println(session.getAttribute("name"));
		int userid = (int) session.getAttribute("u_id");
		ArrayList<Notification> availableNoti = notifi.getAllNotification(userid);
		String erorr_Msg = "No Available Notification";

		if (availableNoti != null) {
			request.setAttribute("availableNoti", availableNoti);
			request.setAttribute("userid", userid);
			System.out.println("hii");
			RequestDispatcher rd = request.getRequestDispatcher("/ava-Noti.jsp");
			rd.forward(request, response);

		} else {
			request.setAttribute("erorr_Msg", erorr_Msg);
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
