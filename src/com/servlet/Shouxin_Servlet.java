package com.servlet;
 
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MessageDao;
import com.dao.MessageDaoImpl;
import com.entity.Message;
import com.util.DBconn;
 
 
public class Shouxin_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
 
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String shenfen = request.getParameter("shenfen");
		System.out.println(id);
		MessageDao md = new MessageDaoImpl();
		List<Message> MessageAll = md.getMessageAll(id,shenfen);
		request.setAttribute("MessageAll", MessageAll);
		request.getRequestDispatcher("/shouxin.jsp").forward(request, response);

		//String sql="select * from Student";


	}
 
}