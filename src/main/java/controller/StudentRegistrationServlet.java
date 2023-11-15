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
 * Servlet implementation class StudentRegistrationServlet
 */
@WebServlet("/StudentRegistrationServlet")
@MultipartConfig
	

public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
	
		String name=request.getParameter("name");
		String date=request.getParameter("date");
		String gender=request.getParameter("gender");
	    String phone=request.getParameter("phone");
	    String education=request.getParameter("education");
		String[] attend1=request.getParameterValues("attend");
		
		 Part filePart = request.getPart("part");
		    String photo = filePart.getSubmittedFileName();
		    
		    String uploadPath = "D:\\AIWebDevelopment\\StudentRegistration-Servlet-OJT\\src\\main\\webapp\\image\\" + photo;
		    
		    filePart.write(uploadPath);
		
		StudentRegistration srs=new StudentRegistration();
		
		srs.setName(name);
		srs.setDate(date);
		srs.setGender(gender);
		srs.setPhone(phone);
		srs.setEducation(education);
		if (attend1 != null) {
			String attend = String.join(",", attend1);
			srs.setAttend(attend);
		}
		
		srs.setPhoto(photo);
		
			
			
		 if( name.equals("") || date.equals("") || gender.equals("null") || phone.equals("") || 
				 education.equals("") || attend1.equals("") || attend1==null || gender==null || date==null || education==null || photo==null) {
				request.setAttribute("errors", "Fill in the Blank!!");
				request.setAttribute("sr", srs);
				request.getRequestDispatcher("STU001.jsp").forward(request, response);
			}else if( !name.equals("") && !date.equals("") && !gender.equals("") && !phone.equals("") && !education.equals("") && !attend1.equals("")){
				
				StudentDao dao=new StudentDao();
				int status=dao.createStudentRegistration(srs);
				if(status==1) {
					request.setAttribute("success", "Success Registiration");
					request.getRequestDispatcher("STU001.jsp").forward(request, response);
				}else {
					request.setAttribute("errors", "Insert Fail!!");
					request.getRequestDispatcher("STU001.jsp").forward(request, response);
				}
			}

	}
}