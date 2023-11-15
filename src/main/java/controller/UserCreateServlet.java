package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.UserDao;

import models.UserRegistration;

/**
 * Servlet implementation class UserCreateServlet
 */
@WebServlet("/UserCreateServlet")
public class UserCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String name=request.getParameter("name");
		  String email=request.getParameter("email");
		  String password=request.getParameter("password"); 
		  String password1=request.getParameter("password1"); 
		  String role=request.getParameter("role");
		
		   
		  if( name.equals("") || email.equals("") || password.equals("") || password1.equals("")){
			  request.setAttribute("error","Fill in the blank!");
			  UserRegistration sr=new UserRegistration();
			 
			  sr.setName(name);
			  sr.setEmail(email);
			  sr.setPassword(password);
			  sr.setRole(role);
			  request.setAttribute("ur", sr);
			  request.getRequestDispatcher("USR001.jsp").include(request, response);
			  
		  }else if(password.equals(password1)) {
			  UserRegistration sr=new UserRegistration(name,email,password,role); 
			  UserDao dao=new UserDao(); 
			  int status=dao.createUserRegistration(sr);
			  if(status==1) {
				  request.setAttribute("success","Successfully Register Please Login..");
				  request.getRequestDispatcher("LGN001.jsp").forward(request, response);
			  }else {
				  request.setAttribute("error", "Id is Duplicate entry,so don't match Id");
				  request.getRequestDispatcher("USR001.jsp").forward(request, response); 
			  }
			  
		  }else if(!password.equals(password1)){
			  request.setAttribute("error", "Password don't match!");
			  request.getRequestDispatcher("USR001.jsp").forward(request, response); 
		  }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		  String name=request.getParameter("name");
		  String email=request.getParameter("email");
		  String password=request.getParameter("password"); 
		  String password1=request.getParameter("password1"); 
		  String role=request.getParameter("role");
		
		   
		  if( name.equals("") || email.equals("") || password.equals("") || password1.equals("")){
			  request.setAttribute("error","Fill in the blank!");
			  UserRegistration sr=new UserRegistration();
			
			  sr.setName(name);
			  sr.setEmail(email);
			  sr.setRole(role);
			  request.setAttribute("list", sr);
			  request.getRequestDispatcher("USR001.jsp").forward(request, response);
			  
		  }else if(password.equals(password1)) {
			  UserRegistration sr=new UserRegistration(name,email,password,role); 
			  UserDao dao=new UserDao(); 
			  int status=dao.createUserRegistration(sr);
			  if(status==1) {
				  request.getRequestDispatcher("USR003.jsp").forward(request, response);
			  }else {
				  request.setAttribute("error", "Id is Duplicate entry,so don't match Id");
				  request.getRequestDispatcher("USR001.jsp").forward(request, response); 
			  }
			  
		  }else if(!password.equals(password1)){
			  request.setAttribute("error", "Password don't match!");
			  request.getRequestDispatcher("USR001.jsp").forward(request, response); 
		  }
		
}
}
