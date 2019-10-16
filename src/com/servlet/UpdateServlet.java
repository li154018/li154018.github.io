package com.servlet;
 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
 
public class UpdateServlet extends HttpServlet {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		String name = request.getParameter("name");
		String name1 = new String(name.getBytes("ISO-8859-1"), "utf-8");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String sex1 = new String(sex.getBytes("ISO-8859-1"), "utf-8");
		String email = request.getParameter("email");
		String email1 = new String(email.getBytes("ISO-8859-1"), "utf-8");
		String banji = request.getParameter("banji");
		String banji1 = new String(banji.getBytes("ISO-8859-1"), "utf-8");
		String address = request.getParameter("address");
		String address1 = new String(address.getBytes("ISO-8859-1"), "utf-8");
		
		System.out.println("------------------------------------"+id);
		
		System.out.println(id+" "+name1+" "+pwd+" "+sex1+" "+email1+" "+banji1);
		
		StudentDao sd = new StudentDaoImpl();
		
		if(sd.update(id, name1, pwd, sex1, email1,banji1,address1)){
			request.setAttribute("xiaoxi", "更新成功");
			request.getRequestDispatcher("/student.jsp").forward(request, response);
		}else{
			response.sendRedirect("defeat.jsp");
			System.out.println("更新失败");
		}
	}
}
 
