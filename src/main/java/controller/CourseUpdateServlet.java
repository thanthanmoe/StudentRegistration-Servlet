package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDao;

import models.CourseRegistration;


/**
 * Servlet implementation class CourseUpdateServlet
 */
@WebServlet("/CourseUpdateServlet")
public class CourseUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String id1=request.getParameter("id");
		 String course_name=request.getParameter("name");
		 

			if( !id1.equals("") && !course_name.equals("")){
				 
				int id=Integer.parseInt(id1);
				CourseRegistration course=new CourseRegistration(id,course_name);
				
				request.setAttribute("ur", course);
			
				  request.getRequestDispatcher("BUD003-02.jsp").forward(request, response);
			}else {
				
				  request.getRequestDispatcher("BUD003-02.jsp").forward(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1=request.getParameter("id");
		String course_name=request.getParameter("name");
		
	  CourseRegistration courses=new CourseRegistration(course_name);
	  
	  request.setAttribute("courses", courses);
	
	  if(!id1.equals("") && !course_name.equals("")) {
		  int id=Integer.parseInt(id1);
		  CourseRegistration course=new CourseRegistration(id,course_name); 
		  CourseDao dao=new CourseDao();
	  int status=dao.updateCourse(course); 
	  if(status==1) {
		  request.setAttribute("success", "Update Successfully.");
		  request.getRequestDispatcher("BUD003-02.jsp").forward(request, response);
	  }else {
		  request.setAttribute("error", "Update Fail!!");
		  request.getRequestDispatcher("BUD003-02.jsp").forward(request, response);
	  }
	  }
	}
}
