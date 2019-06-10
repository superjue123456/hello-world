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
		String studentid=request.getParameter("studentid");//��ȡѧ��
		String courseid=request.getParameter("courseid");//��ȡ�γ̺�
		String score=request.getParameter("score");//��ȡ�ɼ�
		PrintWriter out = response.getWriter();
		try {
			Student student=UserDAO.findstudent(studentid);//����ѧ��
			Course course=CourseDAO.findclasses(courseid);//���ҿγ�
			System.out.print(student.getStudentid());
			if(student.getStudentid()!=null){//���ڸ�ѧ��
				if(course.getCourseid()!=null){//���ڸÿγ�
				 try {
			        	int i=ScoreDAO.addscore(studentid,courseid,score);
						if(i!=0){
							out.print("<script>alert('��ӳɹ�');"
									+ "window.location.href='admin_addscore.jsp'</script>");
						}else{
							out.print("<script>alert('���ʧ��,��ѧ���Ѿ�¼��ɼ���');"
									+ "window.location.href='admin_addscore.jsp'</script>");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					out.print("<script>alert('�γ̲����ڣ����ʧ��');"
							+ "window.location.href='admin_addscore.jsp'</script>");
				}
			}else{
				out.print("<script>alert('ѧ�������ڣ����ʧ��');"
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
