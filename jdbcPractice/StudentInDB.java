package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentInDB {
	
	static Connection makeConnection() {
		
		String url = "jdbc:postgresql://localhost/studentDB";
		String username = "postgres";
		String password = "devmalu";
		
		Connection con = null;
		
		
		try {
			con = DriverManager.getConnection(url, username, password);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return con;
		
	}
	
	
	static int insertStudent(Connection con, String studentName, int studentAge, int studentId) {
		String sql = "insert into students(name, age, id) values(?, ?, ?)";
		PreparedStatement prepSt = null;
		int status = 0;
		
		try {
			prepSt = con.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			prepSt.setString(1, studentName);
			prepSt.setInt(2, studentAge);
			prepSt.setInt(3, studentId);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			status = prepSt.executeUpdate();
			System.out.println(status);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return status;
	}
	
	static int insertCourse(Connection con, String courseName, int courseId) {
		String sql = "insert into courses(id, name) values(?, ?)";
		PreparedStatement prepSt = null;
		int status = 0;
		
		try {
			prepSt = con.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			prepSt.setInt(1, courseId);
			prepSt.setString(2, courseName);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			status = prepSt.executeUpdate();
			System.out.println(status);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return status;
	}
	
	static String findStudentByCourse(Connection con, String courseName) {
		String sql = "select * from courses join students on courses.id = students.courseid where courses.name = ?";
		PreparedStatement prepSt = null;
		int status = 0;
		
		try {
			prepSt = con.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			prepSt.setString(1, courseName);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		String finalResult = null;
		
		try {
			ResultSet result = prepSt.executeQuery();
			result.next();
			finalResult = result.getString(3);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return finalResult;
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		Connection con = makeConnection();
		
		System.out.println(findStudentByCourse(con, "Java"));
		
		
		
		
	}
	
	
}
