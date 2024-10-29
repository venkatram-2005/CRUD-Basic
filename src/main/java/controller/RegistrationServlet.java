package controller;

import java.io.IOException;
import java.sql.SQLException;

import DBOperations.DataBaseOp;
import classes.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name") ;
		String email = request.getParameter("email") ;
		String dob = request.getParameter("dob") ;
		String gender = request.getParameter("gender") ;
		String password = request.getParameter("password") ;
		Student s = new Student(name, email, dob, gender, password) ;
		DataBaseOp op = new DataBaseOp() ;
		try {
			op.insertStudent(s);
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp") ;
			rd.forward(request, response) ;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
