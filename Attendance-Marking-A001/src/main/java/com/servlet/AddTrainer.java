package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TrainerDataDAO;
import com.dao.TrainerDataImplementation;
import com.java.TarinerData;

/**
 * Servlet implementation class AddTrainer
 */
@WebServlet("/AddTrainer")
public class AddTrainer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddTrainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TrainerDataDAO trainerdao = new TrainerDataImplementation();
		TarinerData trainerdata = new TarinerData();
		 String status ;
		
		String trainer_Name = request.getParameter("trainer_name");
		Long trainer_ContactNo = Long.parseLong(request.getParameter("Trainer_Contact"));
		String trainer_Email = request.getParameter("t_email");
		String trainer_SkillSet = request.getParameter("Skillset");
		int trainer_exp = Integer.parseInt(request.getParameter("experiences"));

		trainerdata.setTrainer_Name(trainer_Name);
		trainerdata.setTrainer_ContactNo(trainer_ContactNo);
		trainerdata.setTrainer_Email(trainer_Email);
		trainerdata.setTrainer_SkillSet(trainer_SkillSet);
		trainerdata.setTrainer_exp(trainer_exp);
		
		status = trainerdao.setTrainer(trainerdata);
		if(status != null) {
	
		request.setAttribute("message",status );
		RequestDispatcher rd = request.getRequestDispatcher("/Add-Trainer.jsp");
		rd.forward(request,response);

	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
