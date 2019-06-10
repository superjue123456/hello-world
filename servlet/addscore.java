package servlets;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.CourseDAO;
import DAO.ScoreDAO;
import DAO.UserDAO;
import beans.Course;
import beans.Score;
import beans.Student;
 
public class addscore extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String studentid=request.getParameter("studentid");//获取学号
		String courseid=request.getParameter("courseid");//获取课程号
		String score=request.getParameter("score");//获取成绩
		PrintWriter out = response.getWriter();
		try {
			Student student=UserDAO.findstudent(studentid);//查找学生
			Course course=CourseDAO.findclasses(courseid);//查找课程
			System.out.print(student.getStudentid());
			if(student.getStudentid()!=null){//存在该学生
				if(course.getCourseid()!=null){//存在该课程
				 try {
			        	int i=ScoreDAO.addscore(studentid,courseid,score);
						if(i!=0){
							out.print("<script>alert('添加成功');"
									+ "window.location.href='admin_addscore.jsp'</script>");
						}else{
							out.print("<script>alert('添加失败,该学生已经录入成绩！');"
									+ "window.location.href='admin_addscore.jsp'</script>");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					out.print("<script>alert('课程不存在，添加失败');"
							+ "window.location.href='admin_addscore.jsp'</script>");
				}
			}else{
				out.print("<script>alert('学生不存在，添加失败');"
						+ "window.location.href='admin_addscore.jsp'</script>");
			}
	}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		doGet(request,response);
	}
 
}
