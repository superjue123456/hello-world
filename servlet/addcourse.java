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
 
public class addcourse extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=utf-8");
		String s1=request.getParameter("check1");//
		String s2=request.getParameter("check2");//
		String s3=request.getParameter("check3");//
		String s4=request.getParameter("check4");//
		String s5=request.getParameter("check5");//
		System.out.println(s1 + s5 + "++++");
		PrintWriter out = response.getWriter();
				 try {
			        	//int i=ScoreDAO.addscore(studentid,courseid,score);
					 int i =1;
					 if(i!=0){
							out.print("<script>alert('添加成功');"
									+ "window.location.href='stu_choosecourse.jsp'</script>");
						}else{
							out.print("<script>alert('添加失败');"
									+ "window.location.href='stu_choosecourse.jsp'</script>");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		doGet(request,response);
	}
 
}
