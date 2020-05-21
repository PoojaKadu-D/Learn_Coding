package attendance.marking.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import attendance.marking.user.dao.UserDataImplementation;
import attendance.marking.user.dao.UserdataDAO;
import attendance.marking.user.obj.UserData;

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
		
		userdata.setFirstName(request.getParameter("empfname"));
		userdata.setLastName(request.getParameter("emplname"));
		userdata.setEmailId(request.getParameter("email"));
		userdata.setPassword(request.getParameter("password"));
		
		String addUserdetails = userdao.addUserDeatails(userdata);
		
		if(addUserdetails !=null)
		{
	
		RequestDispatcher rd = request.getRequestDispatcher("/UserLogin.jsp");
		rd.forward(request,response);
	
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
