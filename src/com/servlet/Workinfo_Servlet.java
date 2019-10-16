package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.WorkDao;
import com.dao.WorkDaoImpl;
import com.entity.Work;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.entity.Student;
import com.dao.Teacher_Dao;
import com.dao.Teacher_DaoImpl;
import com.entity.Teacher;

public class Workinfo_Servlet extends HttpServlet{
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
		
		String shenfen=request.getParameter("shenfen");
		
		if(shenfen.equals("1")) {
			StudentDao sd = new StudentDaoImpl();
			List<Student> studentAll = sd.getstudentAll();
			request.setAttribute("studentAll", studentAll);
			request.getRequestDispatcher("/allStudent.jsp").forward(request, response);
		}else if(shenfen.equals("2")) {
			Teacher_Dao td = new Teacher_DaoImpl();
			List<Teacher> teacherAll = td.getteacherAll();
			request.setAttribute("teacherAll", teacherAll);
			request.getRequestDispatcher("/allTeacher.jsp").forward(request, response);			
		}else {
		WorkDao wd = new WorkDaoImpl();
		List<Work> workAll = wd.getWorkAll();
		request.setAttribute("workAll", workAll);
		request.getRequestDispatcher("/workinfo.jsp").forward(request, response);}
	}
}
