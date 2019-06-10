package DAO;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import beans.Score;
import beans.Student;
 
public class ScoreDAO {
	private static Connection conn=null;
	
	public static void initConnection() throws Exception{//建立连接
		Class.forName("com.mysql.jdbc.Driver");
	    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","password");
	}
	
	public static ArrayList<Score> findscore1(String studentid) throws Exception{//按学号查找成绩
	initConnection();
	Statement state =null;
	ResultSet rs = null;
	ArrayList<Score> list=new ArrayList<Score>();
	try{
	String sql = "select score.*,student.studentname,course.coursename from score,student,course where score.studentid=student.studentid and score.courseid=course.courseid and score.studentid = '"+studentid+"'";
	state = conn.createStatement();
	rs=state.executeQuery(sql);
	while(rs.next()){
		Score score=new Score();
		score.setStudentid(rs.getString("studentid"));
		score.setStudentname(rs.getString("studentname"));
		score.setCourseid(rs.getString("courseid"));
		score.setCoursename(rs.getString("coursename"));
		score.setScore(rs.getString("score"));
		list.add(score);
	}
	}catch(Exception e){
		e.printStackTrace();
		}finally{
		closeConnection();
	}
	return list;
	}
	
	public static ArrayList<Score> findscore2(String courseid) throws Exception{//按课程号查找成绩
	initConnection();
	Statement state =null;
	ResultSet rs = null;
	ArrayList<Score> list=new ArrayList<Score>();
	try{
	String sql = "select score.*,student.studentname,course.coursename from score,student,course where score.studentid=student.studentid and score.courseid=course.courseid and score.courseid = '"+courseid+"'";
	state = conn.createStatement();
	rs=state.executeQuery(sql);
	while(rs.next()){
		Score score=new Score();
		score.setStudentid(rs.getString("studentid"));
		score.setStudentname(rs.getString("studentname"));
		score.setCourseid(rs.getString("courseid"));
		score.setCoursename(rs.getString("coursename"));
		score.setScore(rs.getString("score"));
		list.add(score);
	}
	}catch(Exception e){
		e.printStackTrace();
		}finally{
		closeConnection();
	}
	return list;
	}
	
	public static int addscore(String studentid,String courseid,String score) throws Exception{//增加成绩
	initConnection();
	Statement state =null;
	int rs = 0;
	try{
	String sql = "insert into score(studentid,courseid,score) values('"+studentid+"','"+courseid+"','"+score+"')";
	state = conn.createStatement();
	rs=state.executeUpdate(sql);
	}catch(Exception e){
		e.printStackTrace();
		}finally{
		closeConnection();
	}
	return rs;
	}
	
	public static int updatescore(String studentid,String courseid,String score) throws Exception{//修改成绩
	initConnection();
	Statement state =null;
	int rs = 0;
	try{
	String sql = "update score set score='"+score+"' where studentid = '"+studentid+"' and courseid='"+courseid+"'";
	state = conn.createStatement();
	rs=state.executeUpdate(sql);
	}catch(Exception e){
		e.printStackTrace();
		}finally{
		closeConnection();
	}
	return rs;
	}
	
	public static int deletescore(String studentid,String courseid) throws Exception{//删除成绩
	initConnection();
	Statement state =null;
	int rs = 0;
	try{
	String sql = "delete from score where studentid = '"+studentid+"' and courseid='"+courseid+"'";
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
