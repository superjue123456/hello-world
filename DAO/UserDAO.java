 package DAO;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import beans.Admin;
import beans.Student;
 
public class UserDAO {
	private static Connection conn=null;
	
	public static void initConnection() throws Exception{//建立连接
		Class.forName("com.mysql.jdbc.Driver");
	    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","password");
	}
	
	public static Student findstudent(String studentid) throws Exception{//查找学生
	initConnection();
	Statement state =null;
	ResultSet rs = null;
	Student student=new Student();
	try{
	String sql = "select * from student where studentid = '"+studentid+"'";
	state = conn.createStatement();
	rs=state.executeQuery(sql);
	if(rs.next()){
		student.setStudentid(rs.getString("studentid"));
		student.setPassword(rs.getString("password"));
		student.setStudentname(rs.getString("studentname"));
	}
	}catch(Exception e){
		e.printStackTrace();
		}finally{
		closeConnection();
	}
	return student;
	}
	
	public static boolean addStudent(Student student) {//增加学生
	    boolean flag=false;
	    int i=0;
			try {
				initConnection();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    Statement state =null;
	    String sql= "insert into student (studentid,studentname,password) values('"+student.getStudentid()+"','"+student.getStudentname()+"','"+student.getPassword()+"')"; 
	    try {
	    	state = conn.createStatement();
	    	i=state.executeUpdate(sql);
	      if(i>0){
	        flag=true;
	      }
	    }catch (SQLException e) {
	      e.printStackTrace();
	    }
	    try {
			closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return flag;
	  }
 
	
	public static Admin findadmin(String adminid) throws Exception{//查找管理员
	initConnection();
	Statement state =null;
	ResultSet rs = null;
	Admin admin=new Admin();
	try{
	String sql = "select * from admin where adminid = '"+adminid+"'";
	state = conn.createStatement();
	rs=state.executeQuery(sql);
	if(rs.next()){
		admin.setAdminid(rs.getString("adminid"));
		admin.setPassword(rs.getString("password"));
		admin.setAdminname(rs.getString("adminname"));
	}
	}catch(Exception e){
		e.printStackTrace();
		}finally{
		closeConnection();
	}
	return admin;
	}
	
	public static void closeConnection() throws Exception{//断开连接
		conn.close();
	}
}
