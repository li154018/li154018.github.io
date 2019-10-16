package com.servlet;
 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.entity.Student;
import com.dao.Teacher_Dao;
import com.dao.Teacher_DaoImpl;
import com.entity.Teacher;
 
public class ZhuceServlet extends HttpServlet {

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
		
		String name = request.getParameter("name"); //��ȡjspҳ�洫�����Ĳ���
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String id = request.getParameter("id");
		String shenfen=request.getParameter("shenfen");
		String sheng=request.getParameter("sheng");
		String shi=request.getParameter("shi");
		String qu=request.getParameter("qu");
		
		//ע��ѧ����Ϣ
		if(shenfen.equals("1")) {
		Student student = new Student(); //ʵ����һ��������װ����
		student.setName(name);
		student.setpwd(pwd);
		student.setSex(sex);
		student.setId(id);
		student.setAddress(sheng+shi+qu);
		
		StudentDao sd = new StudentDaoImpl();
		
		if(sd.register(student)){
			request.setAttribute("id", id);  //��request���з��ò���
			request.setAttribute("xiaoxi", "ע��ɹ�");
			request.getRequestDispatcher("/admin.jsp").forward(request, response);  //ת������¼ҳ��
		}else{
			
			response.sendRedirect("defeat.jsp");//�ض�����ҳ
		}
		}else if(shenfen.equals("2")) {     //ע���ʦ�˺�
			Teacher teacher = new Teacher(); //ʵ����һ��������װ����
			teacher.setName(name);
			teacher.setpwd(pwd);
			teacher.setSex(sex);
			teacher.setId(id);
			
			Teacher_Dao td = new Teacher_DaoImpl();
			
			if(td.register(teacher)){
				request.setAttribute("id", id);  //��request���з��ò���
				request.setAttribute("xiaoxi", "ע��ɹ�");
				request.getRequestDispatcher("/admin.jsp").forward(request, response);  //ת������¼ҳ��
			}else{
				
				response.sendRedirect("defeat.jsp");//�ض�����ҳ
			}
		}
	}
}
