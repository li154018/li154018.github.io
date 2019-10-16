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
 
public class login_Servlet extends HttpServlet {  //��Ҫ�̳�HttpServlet  ����дdoGet  doPost����

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);  //����Ϣʹ��doPost����ִ��   ��Ӧjspҳ���е�form���е�method
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id"); //�õ�jspҳ�洫�����Ĳ���
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
			request.setAttribute("xiaoxi", "��ӭ"); //��request���з�����Ϣ
			request.getRequestDispatcher("/student.jsp").forward(request, response);//ת�����ɹ�ҳ��
		}else{
			response.sendRedirect("login.jsp?error=1"); //�ض�����ҳ
			System.out.println("��¼ʧ��");
		}
		}else if(shenfen.equals("2")) {
			if(td.login(id, pwd)){
				request.setAttribute("xiaoxi", "��ӭ"); //��request���з�����Ϣ
				request.getRequestDispatcher("/teacher.jsp").forward(request, response);//ת�����ɹ�ҳ��
			}else{
				response.sendRedirect("login.jsp?error=1"); //�ض�����ҳ
				System.out.println("��¼ʧ��");
		}
	}else if(shenfen.equals("3")) {
		if(td.login(id, pwd)){
			request.setAttribute("xiaoxi", "��ӭ"); //��request���з�����Ϣ
			request.getRequestDispatcher("/admin.jsp").forward(request, response);//ת�����ɹ�ҳ��
		}else{
			response.sendRedirect("login.jsp?error=1"); //�ض�����ҳ
			System.out.println("��¼ʧ��");
	}
}
		
 
}}
