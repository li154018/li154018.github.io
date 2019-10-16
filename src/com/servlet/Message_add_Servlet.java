package com.servlet;
 
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.MessageDao;
import com.dao.MessageDaoImpl;
import com.entity.Message;
import com.util.DBconn;

import java.util.Date;
import java.text.SimpleDateFormat;
 
public class Message_add_Servlet extends HttpServlet {

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

		String title = request.getParameter("title"); //��ȡjspҳ�洫�����Ĳ���
		String title1 = new String(title.getBytes("ISO-8859-1"), "utf-8");
		String recipient = request.getParameter("recipient");
		//String recipient1 = new String(recipient.getBytes("ISO-8859-1"), "utf-8");
		String detail = request.getParameter("detail");
		String detail1 = new String(detail.getBytes("ISO-8859-1"), "utf-8");		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=sdf.format(new Date());
		System.out.println(sdf.format(new Date()));
		String sender = request.getParameter("id");
		String shenfen = request.getParameter("shenfen");
		
		 //ʵ����һ��������װ����
		Message message=new Message();
		message.setTitle(title1);
		message.setrecipient(recipient);
		message.setdetail(detail1);
		message.setsend_time(time);
		message.setsender(sender);
		message.setshenfen(shenfen);
		
		MessageDao md = new MessageDaoImpl();
		if(md.register(message)){
			request.setAttribute("title", title);  //��request���з��ò���
			request.setAttribute("xiaoxi", "���ͳɹ�");
			request.getRequestDispatcher("/liuyan.jsp").forward(request, response);  //ת������¼ҳ��
		}else{
			
			response.sendRedirect("defeat.jsp");//�ض�����ҳ
		}
	}
}
