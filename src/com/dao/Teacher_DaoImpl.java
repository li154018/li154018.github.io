package com.dao;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import com.entity.Teacher;
import com.util.DBconn;
 
public class Teacher_DaoImpl implements Teacher_Dao{
	
	public boolean register(Teacher teacher) {
		boolean flag = false;
		DBconn.init();
		int i =DBconn.addUpdDel("insert into teacher(id,name,pwd,sex,zhuanye,zhicheng) " +
				"values('"+teacher.getId()+"','"+teacher.getName()+"','"+teacher.getpwd()+"','"+teacher.getSex()+"','"+teacher.getzhicheng()+"','"+teacher.getzhuanye()+"')");
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
				ResultSet rs = DBconn.selectSql("select * from teacher where id='"+id+"' and pwd='"+pwd+"'");
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
	public List<Teacher> getteacherAll() {
		List<Teacher> list = new ArrayList<Teacher>();
    	try {
		    DBconn.init();
			ResultSet rs = DBconn.selectSql("select * from teacher");
			while(rs.next()){
				Teacher teacher = new Teacher();
				teacher.setId(rs.getString("id"));
				teacher.setName(rs.getString("name"));
				teacher.setpwd(rs.getString("pwd"));
				teacher.setSex(rs.getString("sex"));
				teacher.setzhicheng(rs.getString("zhicheng"));
				teacher.setzhuanye(rs.getString("zhuanye"));
				list.add(teacher);
			}
			DBconn.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean update(int id,String name, String pwd,String sex, String zhicheng,String zhuanye) {
		boolean flag = false;
		DBconn.init();
		String sql ="update teacher set name ='"+name
				+"' , pwd ='"+pwd
				+"' , sex ='"+sex
				+"' , zhicheng ='"+zhicheng
				+"' , zhuanye ='"+zhuanye+"' where id = "+id;
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
	public boolean delete(int id) {
		boolean flag = false;
		DBconn.init();
		String sql = "delete  from teacher where id="+id;
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update(String id, String name, String pwd, String sex, String email, String zhuanye) {
		// TODO Auto-generated method stub
		return false;
	}

    
}
