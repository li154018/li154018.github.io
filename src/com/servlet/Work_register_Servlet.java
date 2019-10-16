package com.servlet;
 
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.WorkDao;
import com.dao.WorkDaoImpl;
import com.entity.Teacher;
import com.entity.Work;
import com.util.DBconn;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.SQLException;
 
public class Work_register_Servlet extends HttpServlet {

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
		System.out.println(id);
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectSql("select name from teacher where id='"+id+"'");
			//Teacher teacher=new Teacher();
			Work work = new Work();
			while(rs.next()) {
				String name=rs.getString("name");
				//String name1 = new String(name.getBytes("ISO-8859-1"), "utf-8");
				//String name1 = name;
				work.setName(name);
				System.out.println(name);
			}
		String work_name = request.getParameter("work_name"); //获取jsp页面传过来的参数
		String work_name1 = new String(work_name.getBytes("ISO-8859-1"), "utf-8");
		String course = request.getParameter("course");
		String course1 = new String(course.getBytes("ISO-8859-1"), "utf-8");
		String work_detail = request.getParameter("work_detail");
		String work_detail1 = new String(work_detail.getBytes("ISO-8859-1"), "utf-8");		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=sdf.format(new Date());
		System.out.println(sdf.format(new Date()));
		//String name1 = name;
		//System.out.println(name);
		
		 //实例化一个对象，组装属性
		work.setWork_name(work_name1);
		work.setCourse(course1);
		work.setWork_detail(work_detail1);
		work.setTime(time);
		//work.setName(name1);
		
		WorkDao wd = new WorkDaoImpl();
		
		if(wd.register(work)){
			request.setAttribute("workname", work_name);  //向request域中放置参数
			request.setAttribute("xiaoxi", "发布成功");
			request.getRequestDispatcher("/teacher.jsp").forward(request, response);  //转发到登录页面
		}else{
			
			response.sendRedirect("defeat.jsp");//重定向到首页
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
