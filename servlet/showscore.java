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
 
public class showscore extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=gb2312");
		String flag=request.getParameter("flag");//��ѧ�Ż��ǿγ̺Ų���
		String id=request.getParameter("id");//��ȡ��idֵ
		String func=request.getParameter("func");//���ĸ�ҳ�洫���ı�
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if(flag.equals("stu")){//��ѧ�Ų��ҳɼ�
			session.setAttribute("flag", flag);
			try {
				Student student=UserDAO.findstudent(id);
				if(student.getStudentid()!=null){//�����ѧ�Ŵ���
					try {
						ArrayList<Score> list=(ArrayList<Score>) ScoreDAO.findscore1(id);
						session.setAttribute("score", list); 
						if(func.equals("show"))//��admin_showscore.jsp������ֵ
							response.sendRedirect("admin_showscore.jsp");
						else//��admin_updatescore.jsp������ֵ
							response.sendRedirect("admin_updatescore.jsp");
					}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
					}
				}else{//ѧ�Ų�����
					if(func.equals("show")){
					out.print("<script>alert('�����ڸ�ѧ��');"
							+ "window.location.href='admin_showscore.jsp'</script>");
					}else{
						out.print("<script>alert('�����ڸ�ѧ��');"
								+ "window.location.href='admin_updatescore.jsp'</script>");
					}
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					
		}else{//���γ̺Ų��ҳɼ�
			try {
				Course course=CourseDAO.findclasses(id);
				if(course.getCourseid()!=null){
					ArrayList<Score> list;
					try {
						session.setAttribute("flag", flag);
						list = (ArrayList<Score>) ScoreDAO.findscore2(id);
						session.setAttribute("score", list); 
						if(func.equals("show"))
							 response.sendRedirect("admin_showscore.jsp");
						 else
							 response.sendRedirect("admin_updatescore.jsp");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					if(func.equals("show")){
						out.print("<script>alert('�����ڸÿγ�');"
								+ "window.location.href='admin_showscore.jsp'</script>");
						}else{
							out.print("<script>alert('�����ڸÿγ�');"
									+ "window.location.href='admin_updatescore.jsp'</script>");
						}
					
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			 
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
				doGet(request,response);
	}
 
}
