package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;
import com.java.*;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserdataDAO userdao = new UserDataImplementation();

		String error_Message = "Please Register your data!";
		int userid = Integer.parseInt(request.getParameter("empid"));
		String userpassword = request.getParameter("password");
		UserData user = userdao.checkLoginStatus(userid, userpassword);
		int id = user.getUser_id();
		String name = user.getFirstName();
		System.out.println("sasa" + id);

		if (user != null && id != 0 && id == 1) {
			request.setAttribute("user", user);
			request.setAttribute("name", name);
			RequestDispatcher rd = request.getRequestDispatcher("/SuperUser-functions.jsp");
			rd.forward(request, response);
		} else if (user != null && id != 0) {
			request.setAttribute("user", user);
			request.setAttribute("name", name);
			RequestDispatcher rd = request.getRequestDispatcher("/User-Home.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("error_Message", error_Message);
			RequestDispatcher rd = request.getRequestDispatcher("/UserLogin.jsp");
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
