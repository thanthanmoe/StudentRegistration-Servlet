package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.StudentDao;

/**
 * Servlet implementation class StudentDeleteServlet
 */
@WebServlet("/StudentDeleteServlet")
@MultipartConfig
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentId=request.getParameter("studentId");
		
		StudentDao dao=new StudentDao();
		int status=dao.studentDelete(Integer.parseInt(studentId));
		if(status==1) {
			request.setAttribute("success","Delete Successfully");
			request.getRequestDispatcher("STU002.jsp").forward(request, response);
		}else {
			request.setAttribute("error","Delete Fail");
			request.getRequestDispatcher("STU002.jsp").forward(request, response);
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
