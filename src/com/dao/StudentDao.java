package com.dao;
 
import java.util.List;
 
import com.entity.Student;
 
public interface StudentDao {
	public boolean login(String id,String pwd);//��¼
	public boolean register(Student student);//ע��
	public List<Student> getstudentAll();//�����û���Ϣ����
	public boolean delete(String id) ;//����idɾ���û�
	public boolean update(String id,String name, String pwd,String sex, String email,String banji,String address) ;//�����û���Ϣ
}
