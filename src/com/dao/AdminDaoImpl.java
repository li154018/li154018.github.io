package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBconn;

public class AdminDaoImpl {
    public boolean login(String id, String pwd) {
		boolean flag = false;
		try {
			    DBconn.init();
				ResultSet rs = DBconn.selectSql("select * from admin where id='"+id+"' and pwd='"+pwd+"'");
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
}
