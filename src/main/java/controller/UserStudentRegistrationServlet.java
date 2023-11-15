package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.StudentDao;
import models.StudentRegistration;

/**
 * Servlet implementation class UserStudentRegistrationServlet
 */
@WebServlet("/UserStudentRegistrationServlet")
@MultipartConfig
public class UserStudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserStudentRegistrationServlet() {
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
	    PrintWriter out = response.getWriter();

	    String name = request.getParameter("name");
	    String date = request.getParameter("date");
	    String gender = request.getParameter("gender");
	    String phone = request.getParameter("phone");
	    String education = request.getParameter("education");
	    String[] attend1 = request.getParameterValues("attend");

	    Part filePart = request.getPart("part");
	    String photo = filePart.getSubmittedFileName();

	    String uploadPath = "D:\\AIWebDevelopment\\StudentRegistration-Servlet-OJT\\src\\main\\webapp\\image\\" + photo;

	    filePart.write(uploadPath);

	    if (name.equals("") || date.equals("") || gender.equals("null") || phone.equals("") || education.equals("")
	            || attend1 == null || attend1.length == 0 || gender.equals("") || date.equals("") || education.equals("")) {
	        request.setAttribute("error", "Fill in the Blank!!!");
	        request.getRequestDispatcher("STU001-01.jsp").forward(request, response);
	    } else {
	        StudentRegistration srs = new StudentRegistration();

	        srs.setName(name);
	        srs.setDate(date);
	        srs.setGender(gender);
	        srs.setPhone(phone);
	        srs.setEducation(education);

	        String attend = String.join(",", attend1);
	        srs.setAttend(attend);

	        srs.setPhoto(photo);

	        StudentDao dao = new StudentDao();
	        int status = dao.createStudentRegistration(srs);
	        if (status == 1) {
	            request.setAttribute("success", "Success Registration");
	            request.getRequestDispatcher("STU001-01.jsp").forward(request, response);
	        } else {
	            request.setAttribute("error", "StudentId does not match!!!");
	            request.getRequestDispatcher("STU001-01.jsp").forward(request, response);
	        }
	    }
	}
}