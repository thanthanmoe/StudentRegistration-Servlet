package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDao;
import dao.UserDao;
import models.CourseRegistration;
import models.UserRegistration;

/**
 * Servlet implementation class CourseDeleteServlet
 */
@WebServlet("/CourseDeleteServlet")
public class CourseDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		String id=request.getParameter("id");
		CourseDao dao=new CourseDao(); 
		int status=dao.getCourseDelete(id);
		if(status==1) {
			response.sendRedirect("BUD003-01.jsp");
		}else {
			response.sendRedirect("BUD003.jsp");
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}	
}
