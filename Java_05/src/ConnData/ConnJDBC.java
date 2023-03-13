package ConnData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

public class ConnJDBC {
	
	static String url = "jdbc:mysql://127.0.0.1:3306/student";
	static String user = "root";
	static String password = "password";
	public static Connection getConnection() {//connection function 
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		}catch(Exception ex) {
			ex.printStackTrace();
	}
		return connection;
		
}
	//lay tat ca sv
	public static List<Student>findAll(){
		List<Student>studentList = new ArrayList<>();
		String query = "SELECT * FROM student.studentmn;";
		try {
			Connection connection = getConnection();
			Statement stml = connection.createStatement();
			ResultSet rs = stml.executeQuery(query);
			while(rs.next()) {
				Student st = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), 
						rs.getInt("gender"), rs.getString("adress"), rs.getFloat("score"));
				studentList.add(st);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return studentList;
	}
	
	//dua vao list
	public static void insert(Student st) {
		String query = "insert into student.studentmn(id,name, age, gender, adress, score) values(?,?, ?, ?, ?, ?)";
		String sort="select * from student.studentmn order by id ASC";
		String updateById="update student.studentmn set id=?";
		String sqlCount="select count(*) from student.studentmn";
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			PreparedStatement pstmt2 = connection.prepareStatement(sort);
			//update by id
//			Statement st1=connection.createStatement();
//			ResultSet rsCount=st1.executeQuery(sqlCount);
//			PreparedStatement pstmt3 = connection.prepareStatement(updateById);
//			rsCount.next();
//			int n=rsCount.getInt(1);
//            for(int i=1;i<=n;i++) {
//				pstmt3.setInt(1, i);
//				pstmt3.executeUpdate();
//			}
			pstmt.setInt(1, st.getId());
			pstmt.setString(2, st.getName());
			pstmt.setInt(3, st.getAge());
			pstmt.setInt(4, st.getGender());
			pstmt.setString(5, st.getAdress());
			pstmt.setFloat(6, st.getScore());
			pstmt.executeUpdate();
			pstmt2.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public static void delete(Student st) {
		String query = "delete from student.studentmn where name = '"+st.getName()+"'";//truy van
		
		try {
			Connection connection = getConnection();
			PreparedStatement pstml = connection.prepareStatement(query);
			pstml.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void Update (Student st) {
		String query = "Update studentmn set name =?, set age =?, set gender =?, set adress =?, set score =? where name ='"+st.getName()+"'";
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
//			pstmt.setInt(1, st.getId());
			pstmt.setString(1, st.getName());
			pstmt.setInt(2, st.getAge());
			pstmt.setInt(3, st.getGender());
			pstmt.setString(4, st.getAdress());
			pstmt.setFloat(5, st.getScore());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static List<Student>findByName(Student s) {
		List<Student>studentL = new ArrayList<>();
		String query = "SELECT * FROM studentmn where studentmn.name = '"+s.getName()+"'";
		try {
			Connection connection = getConnection();
			Statement stml = connection.createStatement();
			ResultSet rs = stml.executeQuery(query);
			while(rs.next()) {
				Student st = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), 
						rs.getInt("gender"), rs.getString("adress"), rs.getFloat("score"));
				studentL.add(st);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return studentL;
	}

}
