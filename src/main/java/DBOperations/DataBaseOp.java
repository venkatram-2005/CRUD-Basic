package DBOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes.Student;

public class DataBaseOp {
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver") ;
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "valluri200513") ;

		return connect ;
	}
	
	public void insertStudent(Student s)throws ClassNotFoundException, SQLException{
		Connection connect = getConnection() ;
		String query = "Insert into students values(?, ?, ?, ?, ?)" ;
		PreparedStatement p = connect.prepareStatement(query) ;
		
		p.setString(1, s.getName());
		p.setString(2, s.getEmail());
		p.setString(3, s.getDate());
		p.setString(4, s.getPassword());
		p.setString(5, s.getGender());
		
		p.executeUpdate();
	}
	
	public List<Student> getStudents() throws ClassNotFoundException, SQLException{
		String query = "Select * from students" ;
		List<Student> li = new ArrayList<>() ;
		Connection connect = getConnection() ;
		Statement st = connect.createStatement() ;
		ResultSet res = st.executeQuery(query) ;
		
		while(res.next()) {
			String name = res.getString(1) ;
			String email = res.getString(2) ;
			String dob = res.getString(3) ;
			String password = res.getString(4) ;
			String gender = res.getString(5) ;
			Student s = new Student(name, email, dob, password, gender) ;
			li.add(s) ;
		}
		return li;
	}
	
	public void deleteStudent(String name)throws ClassNotFoundException, SQLException{
		String query = "Delete from students where name = ?" ;
		Connection connect = getConnection() ;
		PreparedStatement p = connect.prepareStatement(query) ;
		p.setString(1, name);
		p.executeUpdate() ;
	}

	public Student getStudent(String sname)throws ClassNotFoundException, SQLException {
		String query = "Select * from students where name = ?" ;
		Connection connect = getConnection() ;
		PreparedStatement p = connect.prepareStatement(query) ;
		p.setString(1, sname) ;
		ResultSet res = p.executeQuery();
		Student s = null ;
		if(res.next()) {
			String name = res.getString(1);
			String email = res.getString(2) ;
			String dob = res.getString(3) ;
			String password = res.getString(4) ;
			String gender = res.getString(5) ;
			s = new Student(name, email, dob, password, gender) ;
		}
		return s ;
	}

	public void updateDetails(Student s)throws ClassNotFoundException, SQLException {
		String query = "update students set name = ? , email = ?, date = ?, password = ?, gender = ?" ;
		Connection connect = getConnection() ;
		PreparedStatement p = connect.prepareStatement(query) ;
		p.setString(1, s.getName());
		p.setString(2, s.getEmail());
		p.setString(3, s.getDate());
		p.setString(4, s.getPassword());
		p.setString(5, s.getGender());
		p.executeUpdate();
		
	}
}
