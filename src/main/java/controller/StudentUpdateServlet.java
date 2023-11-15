package controller;

import java.io.IOException;


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
 * Servlet implementation class StudentUpdateServlet
 */
@WebServlet("/StudentUpdateServlet")
@MultipartConfig
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateServlet() {
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
		String studentId1=request.getParameter("studentId"); 
		int studentId=Integer.parseInt(studentId1);
		String name=request.getParameter("name");
		String date=request.getParameter("date");
		String gender=request.getParameter("gender");
	    String phone=request.getParameter("phone");
	    String education=request.getParameter("education");
	    String[] attend1=request.getParameterValues("attend");
	    request.setAttribute("attend", attend1);
	    
	    

      String[] attend2= (String[]) request.getAttribute("attend");
    for (String value : attend2) {
    	System.out.println(value);
    }
    
    
 

		Part filePart = request.getPart("part");
	    String photo = filePart.getSubmittedFileName();
	    
	    String uploadPath = "D:\\AIWebDevelopment\\StudentRegistration-Servlet-OJT\\src\\main\\webapp\\image\\" + photo;
	    
	    filePart.write(uploadPath);
	
	StudentRegistration srs=new StudentRegistration();
	srs.setStudentId(studentId);
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
	
		
		 
		  StudentDao dao=new StudentDao();
		  int status=dao.updateStudentRegistration(srs); 
		  if(status>0) {
			  request.setAttribute("success", "Update successfull");  
			  request.getRequestDispatcher("STU002-01.jsp").forward(request, response);
		  
		  }else {
			  request.setAttribute("error", "Update Fail!");
			  response.sendRedirect("STU002-01.jsp");
		  }
		
	}

	
}
