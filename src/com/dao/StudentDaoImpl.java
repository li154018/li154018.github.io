package com.dao;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import com.entity.Student;
import com.util.DBconn;
 
public class StudentDaoImpl implements StudentDao{
	
	public boolean register(Student student) {
		boolean flag = false;
		DBconn.init();
		int i =DBconn.addUpdDel("insert into student(id,name,pwd,sex,email,banji,address) " +
				"values('"+student.getId()+"','"+student.getName()+"','"+student.getpwd()+"','"+student.getSex()+"','"+student.getemail()+"','"+student.getbanji()+"','"+student.getAddress()+"')");
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
    public boolean login(String id, String pwd) {
		boolean flag = false;
		try {
			    DBconn.init();
				ResultSet rs = DBconn.selectSql("select * from student where id='"+id+"' and pwd='"+pwd+"'");
				while(rs.next()){
					if(rs.getString("id").equals(id) && rs.getString("pwd").equals(pwd)){
						flag = true;
					}
				}
				DBconn.closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	public List<Student> getstudentAll() {
		List<Student> list = new ArrayList<Student>();
    	try {
		    DBconn.init();
			ResultSet rs = DBconn.selectSql("select * from student");
			while(rs.next()){
				Student student = new Student();
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
				student.setpwd(rs.getString("pwd"));
				student.setSex(rs.getString("sex"));
				student.setemail(rs.getString("email"));
				student.setbanji(rs.getString("banji"));
				student.setAddress(rs.getString("address"));
				list.add(student);
			}
			DBconn.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean update(String id,String name, String pwd,String sex, String email,String banji,String address) {
		boolean flag = false;
		DBconn.init();
		String sql ="update student set name ='"+name+"' , pwd ='"+pwd+"' , sex ='"+sex+"' , email ='"+email+"' , banji ='"+banji+"',address='"+address+"' where id = '"+id+"'";
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
	public boolean delete(String id) {
		boolean flag = false;
		DBconn.init();
		String sql = "delete  from student where id="+id;
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}



}
