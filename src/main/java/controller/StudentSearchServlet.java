package controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import models.StudentRegistration;


/**
 * Servlet implementation class StudentSearchServlet
 */
@WebServlet("/StudentSearchServlet")
public class StudentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String studentId=request.getParameter("studentId"); 
		
		if(!studentId.equals("") ){
			StudentDao dao=new StudentDao();
			List<StudentRegistration> srs=dao.studentById(Integer.parseInt(studentId));
			
				request.getServletContext().setAttribute("srs", srs);
				request.getRequestDispatcher("STU002.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("STU003.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String studentId = request.getParameter("studentId");
	    String name = request.getParameter("name");
	    String attend = request.getParameter("attend");

	    StudentDao dao = new StudentDao();

	    if (studentId.equals("") && name.equals("") && attend.equals("")) {
	        List<StudentRegistration> srs = dao.allStudentUser();
	        request.setAttribute("list", srs);
	    } else if (!attend.equals("") && studentId.equals("") && name.equals("")) {
	        List<StudentRegistration> srs = dao.studentAttend(attend);
	        if (srs.size() == 0) {
	            request.setAttribute("error", "Student not found");
	        } else {
	            request.setAttribute("list", srs);
	        }
	    } else if (attend.equals("") && !studentId.equals("") && name.equals("")) {
	        List<StudentRegistration> srs = dao.studentById(Integer.parseInt(studentId));
	        if (srs.size() == 0) {
	            request.setAttribute("error", "Student not found");
	        } else {
	            request.setAttribute("list", srs);
	        }
	    } else if (attend.equals("") && studentId.equals("") && !name.equals("")) {
	        List<StudentRegistration> srs = dao.studentName(name);
	        if (srs.size() == 0) {
	            request.setAttribute("error", "Student not found");
	        } else {
	            request.setAttribute("list", srs);
	        }
	    } else if (!studentId.equals("") || !name.equals("") || !attend.equals("")) {
	        List<StudentRegistration> srs = dao.studentMore(studentId, name, attend);
	        if (srs.size() == 0) {
	            request.setAttribute("error", "Student not found");
	        } else {
	            request.setAttribute("list", srs);
	        }
	    }

	    request.getRequestDispatcher("STU003.jsp").forward(request, response);
	}
}
