package com.servlet;
 
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.entity.Student;
import com.util.DBconn;
 
 
@WebServlet("/servlet/ServletDemo")
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletDemo() {
        super();
    }
 
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
 
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		//String sql="select * from Student";

		try {
			//Statement st = conn.createStatement();
			//ResultSet rs = st.executeQuery(sql);
			DBconn.init();
			ResultSet rs = DBconn.selectSql("select * from student where id='"+id+"'");
			Student student = new Student();
			while(rs.next()){
				//Student student = new Student();
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
				student.setpwd(rs.getString("pwd"));
				student.setSex(rs.getString("sex"));
				student.setemail(rs.getString("email"));
				student.setbanji(rs.getString("banji"));
				student.setAddress(rs.getString("address"));
			}
			//�����ݿ��в�ѯ������Ϣ��װ��user�����У�use���󱣴���request�У�֮��ͨ��request�������ݴ��ݵ�ҳ��
			//��Ҫ�Ļ�Ҳ����ֻ����һ������request.setAttribute("id", user.getId());
			request.setAttribute("student", student);
			//������ת������Servlet��ת��showinfo.jspҳ�棬���Ҵ���request��response������ԭ�еĲ���
			request.getRequestDispatcher("/student_info.jsp").forward(request, response);
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 
}