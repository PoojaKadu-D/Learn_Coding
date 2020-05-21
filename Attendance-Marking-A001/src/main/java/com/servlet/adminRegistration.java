package com.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDataDAO;
import com.dao.AdminDataImplementation;
import com.java.AdminData;

@WebServlet("/adminRegistration")
public class adminRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminData admindata = new AdminData();
		AdminDataDAO admindao = new AdminDataImplementation();
//		int id = Integer.parseInt(request.getParameter(""));
		String adminFirstName = request.getParameter("empfname");
		String adminLastName = request.getParameter("emplname");
		String admindob = request.getParameter("date");
		String adminGender = request.getParameter("gender");
		Long adminContactNumber = Long.parseLong(request.getParameter("contact"));
		String adminPassword = request.getParameter("password");
		String adminEmail = request.getParameter("email");

		// using Calendar Object
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date d;
		try {
			d = sdf.parse(admindob);

			Calendar c = Calendar.getInstance();
			c.setTime(d);
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH) + 1;
			int date = c.get(Calendar.DATE);
			LocalDate local = LocalDate.of(year, month, date);
			LocalDate now1 = LocalDate.now();
			System.out.println(now1+ "fhfhf");
			System.out.println(local+"ddd");
			Period diff1 = Period.between(local, now1);
			int age = diff1.getYears();
			System.out.println("age:" + diff1.getYears() + "years");
			
			admindata.setAdminFirstName(adminFirstName);
			admindata.setAdminLastName(adminLastName);
			admindata.setAdminAge(age);
			admindata.setAdminGender(adminGender);
			admindata.setAdminContactNumber(adminContactNumber);
			admindata.setAdminPassword(adminPassword);
			admindata.setadminEmailId(adminEmail);
		
			
			AdminData adminTemp = admindao.addAdminDeatails(admindata);
			String status = "Your details are submitted successfully, welcome ";

			if (adminTemp != null) {
				request.setAttribute("message", status);
				request.setAttribute("id", " and your id is");
				request.setAttribute("adminFirstName", adminFirstName);
				request.setAttribute("admin", adminTemp);
				RequestDispatcher rd = request.getRequestDispatcher("/AdminLogin.jsp");
				rd.forward(request, response);
			}
		} catch (ParseException e) {

			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
