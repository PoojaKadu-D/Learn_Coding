package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SkillsDataDAO;
import com.dao.SkillsDataImplementation;
import com.java.SkillsData;

/**
 * Servlet implementation class AddSkills
 */
@WebServlet("/AddSkills")
public class AddSkills extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSkills() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SkillsDataDAO skillsdao = new SkillsDataImplementation();
		SkillsData skilldata = new SkillsData();
		String status;
		String skill_Type = request.getParameter("skill_type");
		String skill_Description = request.getParameter("S-Descr");
		
		skilldata.setSkill_type(skill_Type);
		skilldata.setSkill_description(skill_Description);
		status = skillsdao.setSkills(skilldata);
		if(status != null) {
	
		request.setAttribute("message",status );
		RequestDispatcher rd = request.getRequestDispatcher("/Add-Skills.jsp");
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
