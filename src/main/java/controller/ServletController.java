package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import DBOperations.DataBaseOp;
import classes.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(ServletController.class.getName()) ;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("display")!=null) {
			DataBaseOp op = new DataBaseOp() ;
			try {
				List<Student> studentsList = op.getStudents();
				request.setAttribute("studentsList", studentsList ) ;
				logger.info("Student details displayed successfully");
				RequestDispatcher rd = request.getRequestDispatcher("/display.jsp") ;
				rd.forward(request, response) ;
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(request.getParameter("deleteinfo") != null) {
			DataBaseOp op = new DataBaseOp() ;
			String name = request.getParameter("deleteinfo") ;
			try {
				op.deleteStudent(name) ;
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp") ;
				rd.forward(request, response) ;
			} catch (ClassNotFoundException | SQLException e) {
				logger.log(Level.SEVERE, "Error occurred while deleting student with name: " + name, e);
				e.printStackTrace();
			}
		}
		
		else if(request.getParameter("updateinfo") != null) {
			DataBaseOp op = new DataBaseOp() ;
			String name = request.getParameter("updateinfo") ;
			try {
				Student s = op.getStudent(name) ;
				request.setAttribute("student", s) ;
				RequestDispatcher rd = request.getRequestDispatcher("editDetails.jsp") ;
				rd.forward(request, response) ;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
