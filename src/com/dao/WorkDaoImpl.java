package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Work;
import com.util.DBconn;

public class WorkDaoImpl implements WorkDao{
	public boolean register(Work work) {
		boolean flag = false;
		DBconn.init();
		int i =DBconn.addUpdDel("insert into work(work_name,course,name,work_detail,time) " +
				"values('"+work.getWork_name()+"','"+work.getCourse()+"','"+work.getName()+"','"+work.getWork_detail()+"','"+work.getTime()+"')");
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
	public List<Work> getWorkAll() {
		List<Work> list = new ArrayList<Work>();
    	try {
		    DBconn.init();
			ResultSet rs = DBconn.selectSql("select * from work");
			while(rs.next()){
				Work work = new Work();
				work.setWork_name(rs.getString("work_name"));
				work.setName(rs.getString("name"));
				work.setCourse(rs.getString("course"));
				work.setWork_detail(rs.getString("work_detail"));
				work.setTime(rs.getString("time"));
				list.add(work);
			}
			DBconn.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
