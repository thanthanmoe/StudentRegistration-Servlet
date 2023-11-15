package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.UserDao;
import models.UserRegistration;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.invalidate();
		request.getRequestDispatcher("LGN001.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name	=request.getParameter("name");
		String password=request.getParameter("password");
		
			UserRegistration lu=new UserRegistration();
			lu.setName(name);
			lu.setPassword(password);
				request.setAttribute("lu", lu);
				if(lu.getName()==null || lu.getPassword()==null || name.equals("") || password.equals("")) {
					request.setAttribute("error", "Fill in the blank!!");
					request.getRequestDispatcher("LGN001.jsp").forward(request, response);
					
				}else {
					UserDao dao=new UserDao(); 
					List<UserRegistration> urs=dao.userBy(name);
					if(urs.size()==0 ) {
						request.setAttribute("error", "Login Fail!!");
						request.getRequestDispatcher("LGN001.jsp").forward(request, response);
					}if(password.equals(urs.get(0).getPassword()) && urs.get(0).getRole().equals("Admin")){
						request.getSession().setAttribute("user", urs.get(0) );
						request.getRequestDispatcher("MNU001.jsp").forward(request, response);
					}else if(password.equals(urs.get(0).getPassword()) && urs.get(0).getRole().equals("User")){
						request.getSession().setAttribute("user", urs.get(0) );
						request.getRequestDispatcher("STU001-01.jsp").forward(request, response);
					}else {
					request.setAttribute("error", "Password do not match");
					request.getRequestDispatcher("LGN001.jsp").forward(request, response);
					
					}
				}
	}

}
