package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.UserDao;
import models.UserRegistration;

/**
 * Servlet implementation class UserSearchServlet
 */
@WebServlet("/UserSearchServlet")
public class UserSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserSearchServlet() {
        super();
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        UserDao dao = new UserDao();

        if (id.equals("") && name.equals("")) {
            List<UserRegistration> urs = dao.getallUser();
            request.setAttribute("ur", urs);
        } else if (!id.equals("")) {
            List<UserRegistration> urs = dao.userId(id);
            if (urs.size() == 0) {
                request.setAttribute("error", "User not found");
            } else {
                request.setAttribute("ur", urs);
            }
        } else {
            List<UserRegistration> urs = dao.userByName(id, name);
            if (urs.size() == 0) {
                request.setAttribute("error", "User not found");
            } else {
                request.setAttribute("ur", urs);
            }
        }

        request.getRequestDispatcher("USR003.jsp").forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
