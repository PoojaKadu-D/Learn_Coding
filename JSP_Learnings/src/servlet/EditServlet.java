package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Details_p.Details_DAO;
import Details_p.Details_Implements;
import Details_p.FetchData;

@WebServlet("/Edit-Servlet")

public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EditServlet() {
        super();
    }
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String userId= request.getParameter("userId");
		int uid = Integer.parseInt(userId);
		response.getWriter().println("You hv Select Userid " + uid);
		
	Details_DAO detail_dao = new Details_Implements();
	System.out.println("done");
	FetchData fetchData = detail_dao.getElementbyId(uid);
	if(fetchData!=null) {
		request.setAttribute("data", fetchData);
		RequestDispatcher rd = request.getRequestDispatcher("/Edit.jsp");
		rd.forward(request, response);
	}
	
	}


}
