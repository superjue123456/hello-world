package servlets;
 
import java.io.IOException;
import java.io.PrintWriter;
import DAO.UserDAO;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.Admin;
import beans.Student;
 
public class login extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");//��ȡ�˺�
		String password = request.getParameter("password");//��ȡ����
		String user=request.getParameter("user");//�ж��û���ݣ�ѧ�����ǹ���Ա
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
			//System.out.println(user);
		if(user.equals("student")){//ѧ����¼ʱ
			try {
				Student student=UserDAO.findstudent(userid); //����ѧ���˺��Ƿ����
				if(student.getPassword() != null && student.getPassword().equals(password)){ 
					//������������ȷ
					HttpSession session = request.getSession();
					session.setAttribute("student",student);
					session.setAttribute("userid", userid);
					System.out.println("��¼�ɹ���");
					response.sendRedirect("stu_showscore.jsp");
					
					
				}else if (student.getPassword() == null) {
					//�˺Ų�����
					out.print("<script>alert('��¼ʧ�ܣ��˺Ų����ڣ�����ϵ����Աע��');"
							+ "window.location.href='index.jsp'</script>");
				} else {
					// ���ڵ��������
					System.out.println("��¼ʧ�ܣ�");
					out.print("<script>alert('��¼ʧ�ܣ���������ȷ������');"
							+ "window.location.href='index.jsp'</script>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{//����Ա��¼ʱ
			try {
				Admin admin=UserDAO.findadmin(userid);
				if(admin.getPassword().equals(password)){
					HttpSession session = request.getSession();
					session.setAttribute("admin",admin);
					System.out.println("��¼�ɹ���");
					response.sendRedirect("admin_menu.jsp");
				}else{
					System.out.println("��¼ʧ�ܣ�");
					out.print("<script>alert('��¼ʧ�ܣ���ȷ���˺ź�����');"
							+ "window.location.href='index.jsp'</script>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}
		
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}
 
}
