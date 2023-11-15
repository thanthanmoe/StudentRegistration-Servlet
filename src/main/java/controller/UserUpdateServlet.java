package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import models.UserRegistration;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String name=request.getParameter("name");
		 

			if( !name.equals("")){
				UserDao dao=new UserDao(); 
				List<UserRegistration> urs=dao.userBy(name);
				request.setAttribute("ur", urs);
				request.getRequestDispatcher("USR002.jsp").forward(request, response);
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String id1=request.getParameter("id");
		  String name=request.getParameter("name");
		  String email=request.getParameter("email");
		  String password=request.getParameter("password"); 
		  String role=request.getParameter("role");
		  int id=Integer.parseInt(id1);
		 UserRegistration users=new UserRegistration();
		 
		 users.setName(name);
		 users.setEmail(email);
		 users.setPassword(password);
		 users.setRole(role);
		  if(!id1.equals("") && !name.equals("") && !email.equals("") && !password.equals("") && !role.equals("")) {
			
			  UserRegistration user=new UserRegistration(id,name,email,password,role); 
			 UserDao dao=new UserDao(); 
		  int status=dao.updateUserRegistration(user); 
		  if(status==1) {
			  request.setAttribute("success", "Update Successfully.");
			  request.getRequestDispatcher("USR002.jsp").forward(request, response);
		  }else {
			  request.setAttribute("error", "Update Fail!!");
			  request.getRequestDispatcher("USR002.jsp").forward(request, response);
		  }
		  }else if(id1.equals("") || name.equals("") || email.equals("") || password.equals("") || role.equals("")){
			  request.setAttribute("error", "Fill in the Blank!!");
			  request.getRequestDispatcher("USR002.jsp").forward(request, response);
		  }
		
	}

}
