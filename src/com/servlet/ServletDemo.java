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
			//将数据库中查询到的信息封装在user对象中，use对象保存在request中，之后将通过request对象将数据传递到页面
			//需要的话也可以只传递一个参数request.setAttribute("id", user.getId());
			request.setAttribute("student", student);
			//这里是转发，从Servlet跳转到showinfo.jsp页面，并且带上request和response对象中原有的参数
			request.getRequestDispatcher("/student_info.jsp").forward(request, response);
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 
}