package util;

import javax.servlet.*;
import javax.servlet.http.*;

public abstract class MyListener implements ServletContextListener,HttpSessionListener,ServletRequestListener{

	public void contextInitializable(ServletContextEvent arg0){
		System.out.println("ServletContext对象被创建了");
	}
	public void contextDestoryed(ServletContextEvent arg0){
		System.out.println("ServletContext对象被销毁了");
	}
	public void requestInitialized(ServletContextEvent arg0){
		System.out.println("ServletRequest对象被创建了");
	}
	public void requestDestoryed(ServletContextEvent arg0){
		System.out.println("ServletRequest对象被销毁了了");
	}
	public void sessionCreated(ServletContextEvent arg0){
		System.out.println("HttpSession对象被创建了");
	}
	public void sessionDestory(ServletContextEvent arg0){
		System.out.println("HttpSession对象被销毁了");
	}
	
}
