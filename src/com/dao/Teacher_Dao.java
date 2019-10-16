package com.dao;
 
import java.util.List;
 
import com.entity.Teacher;
 
public interface Teacher_Dao {
	public boolean login(String id,String pwd);//登录
	public boolean register(Teacher teacher);//注册
	public List<Teacher> getteacherAll();//返回用户信息集合
	public boolean delete(String id) ;//根据id删除用户
	public boolean update(String id,String name, String pwd,String sex, String email,String zhuanye) ;//更新用户信息
}
