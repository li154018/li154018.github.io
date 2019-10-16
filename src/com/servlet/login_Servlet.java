package com.servlet;
 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.dao.Teacher_Dao;
import com.dao.Teacher_DaoImpl;
 
public class login_Servlet extends HttpServlet {  //需要继承HttpServlet  并重写doGet  doPost方法

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id"); //得到jsp页面传过来的参数
		String pwd = request.getParameter("pwd");
		String shenfen=request.getParameter("shenfen");
		/*System.out.println(shenfen+" "+id+" "+pwd);
		if(shenfen.equals("2")) {
			System.out.println("123"+" "+shenfen+" "+id+" "+pwd);
		}*/
		StudentDao ud = new StudentDaoImpl();
		Teacher_Dao td=new Teacher_DaoImpl();
		if(shenfen.equals("1")) {
		if(ud.login(id, pwd)){
			request.setAttribute("xiaoxi", "欢迎"); //向request域中放置信息
			request.getRequestDispatcher("/student.jsp").forward(request, response);//转发到成功页面
		}else{
			response.sendRedirect("login.jsp?error=1"); //重定向到首页
			System.out.println("登录失败");
		}
		}else if(shenfen.equals("2")) {
			if(td.login(id, pwd)){
				request.setAttribute("xiaoxi", "欢迎"); //向request域中放置信息
				request.getRequestDispatcher("/teacher.jsp").forward(request, response);//转发到成功页面
			}else{
				response.sendRedirect("login.jsp?error=1"); //重定向到首页
				System.out.println("登录失败");
		}
	}else if(shenfen.equals("3")) {
		if(td.login(id, pwd)){
			request.setAttribute("xiaoxi", "欢迎"); //向request域中放置信息
			request.getRequestDispatcher("/admin.jsp").forward(request, response);//转发到成功页面
		}else{
			response.sendRedirect("login.jsp?error=1"); //重定向到首页
			System.out.println("登录失败");
	}
}
		
 
}}
