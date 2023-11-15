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
 * Servlet implementation class CourseRegistrationServlet
 */
@WebServlet("/CourseRegistrationServlet")
public class CourseRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String course_name=request.getParameter("name");
		if( !course_name.equals("")) {
		CourseRegistration cr=new CourseRegistration(course_name);
		CourseDao cdao=new CourseDao();
	    int status=cdao.createCourse(cr);
	    if(status==1) {
	    	request.setAttribute("success", "Successfully");
			request.getRequestDispatcher("BUD003.jsp").forward(request, response);
	    }else {
			request.setAttribute("error", "Course Name is do not match!!");
			request.getRequestDispatcher("BUD003.jsp").forward(request, response);
		}
		}else if( course_name.equals("")){
			request.setAttribute("error", "Fill the Blank!");
			request.getRequestDispatcher("BUD003.jsp").forward(request, response);
		}
	}

}
