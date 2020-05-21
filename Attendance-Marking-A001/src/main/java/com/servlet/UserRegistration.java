package com.servlet;

import java.io.IOException;
import java.text.*;
import java.time.*;
import java.util.Calendar;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;
import com.java.*;

@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserdataDAO userdao = new UserDataImplementation();
		UserData userdata = new UserData();
		String status = "Your details are submitted successfully, welcome ";

		
		String fname = request.getParameter("empfname");
	    userdata.setFirstName(fname);
		userdata.setLastName(request.getParameter("emplname"));
		userdata.setEmailId(request.getParameter("email"));
		userdata.setPassword(request.getParameter("password"));
		String userdob = request.getParameter("date");

		// using Calendar Object
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date d;
		try {
			d = sdf.parse(userdob);

			Calendar c = Calendar.getInstance();
			c.setTime(d);
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH) + 1;
			int date = c.get(Calendar.DATE);
			LocalDate local = LocalDate.of(year, month, date);
			LocalDate now1 = LocalDate.now();
			System.out.println(now1 + "fhfhf");
			System.out.println(local + "ddd");
			Period diff1 = Period.between(local, now1);
			int age = diff1.getYears();
			System.out.println("age:" + diff1.getYears() + "years");

			userdata.setUserAge(age);
			userdata.setUserGender(request.getParameter("gender"));
			userdata.setUserContactNumber(Long.parseLong(request.getParameter("contact")));

			UserData addUserdetails = userdao.addUserDeatails(userdata);
			
			if (addUserdetails != null) {
				request.setAttribute("message", status);
				request.setAttribute("id", " and your id is");
				request.setAttribute("userFirstName", fname);
				request.setAttribute("user", addUserdetails);
				RequestDispatcher rd = request.getRequestDispatcher("/UserLogin.jsp");
				rd.forward(request, response);

			}
		} catch (ParseException e) {

			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
