package com.dao;
 
import java.util.List;
 
import com.entity.Teacher;
 
public interface Teacher_Dao {
	public boolean login(String id,String pwd);//��¼
	public boolean register(Teacher teacher);//ע��
	public List<Teacher> getteacherAll();//�����û���Ϣ����
	public boolean delete(String id) ;//����idɾ���û�
	public boolean update(String id,String name, String pwd,String sex, String email,String zhuanye) ;//�����û���Ϣ
}
