package util;

import javax.servlet.*;
import javax.servlet.http.*;

public abstract class MyListener implements ServletContextListener,HttpSessionListener,ServletRequestListener{

	public void contextInitializable(ServletContextEvent arg0){
		System.out.println("ServletContext���󱻴�����");
	}
	public void contextDestoryed(ServletContextEvent arg0){
		System.out.println("ServletContext����������");
	}
	public void requestInitialized(ServletContextEvent arg0){
		System.out.println("ServletRequest���󱻴�����");
	}
	public void requestDestoryed(ServletContextEvent arg0){
		System.out.println("ServletRequest������������");
	}
	public void sessionCreated(ServletContextEvent arg0){
		System.out.println("HttpSession���󱻴�����");
	}
	public void sessionDestory(ServletContextEvent arg0){
		System.out.println("HttpSession����������");
	}
	
}
