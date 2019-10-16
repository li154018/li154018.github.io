package com.dao;
 
import java.util.List;
 
import com.entity.Student;
 
public interface StudentDao {
	public boolean login(String id,String pwd);//登录
	public boolean register(Student student);//注册
	public List<Student> getstudentAll();//返回用户信息集合
	public boolean delete(String id) ;//根据id删除用户
	public boolean update(String id,String name, String pwd,String sex, String email,String banji,String address) ;//更新用户信息
}
