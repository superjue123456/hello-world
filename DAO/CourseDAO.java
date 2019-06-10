package DAO;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import beans.Course;
import beans.Student;
 
public class CourseDAO {
	private static Connection conn=null;
	
	
	public static Course findclasses(String courseid) throws Exception{//查找课程
	Class.forName("com.mysql.jdbc.Driver");
	    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","password");
	Statement state =null;
	ResultSet rs = null;
	Course course=new Course();
	try{
	String sql = "select * from course where courseid = '"+courseid+"'";
	state = conn.createStatement();
	rs=state.executeQuery(sql);
	while(rs.next()){
		course.setCourseid(rs.getString("courseid"));
		course.setCoursename(rs.getString("coursename"));
	}
	}catch(Exception e){
		e.printStackTrace();
		}finally{
		closeConnection();
	}
	return course;
	}
	
	public static int addcourse(String courseid,String coursename) throws Exception{//增加课程
		Statement state =null;
		int rs = 0;
		try{
		String sql = "insert into course(courseid,coursename) values('"+courseid+"','"+coursename+"')";
		state = conn.createStatement();
		rs=state.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
			}finally{
			closeConnection();
		}
		return rs;
		}
	
	public static void closeConnection() throws Exception{//断开连接
		conn.close();
	}
}

