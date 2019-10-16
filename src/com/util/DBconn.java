package com.util;
 
import java.sql.*;
 
public class DBconn {
	static String url = "jdbc:mysql://localhost:3306/worksys?useSSL=false&serverTimezone=GMT%2B8&useSSL=false"; 
	static String username = "root"; 
	static String password = ""; 
	static Connection  conn = null;
	static ResultSet rs = null;
	static PreparedStatement ps =null;
	public static void init(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			//System.out.println("success");
		} catch (Exception e) {
			System.out.println("init [SQL���������ʼ��ʧ�ܣ�]");
			e.printStackTrace();
		}
	}
	public static int addUpdDel(String sql){
		int i = 0;
		try {
			PreparedStatement ps =  conn.prepareStatement(sql);
			i =  ps.executeUpdate();
			//System.out.println("success");
		} catch (SQLException e) {
			System.out.println("sql���ݿ���ɾ���쳣");
			e.printStackTrace();
		}
		
		return i;
	}
	public static ResultSet selectSql(String sql){
		try {
			ps =  conn.prepareStatement(sql);
			rs =  ps.executeQuery(sql);
			//System.out.println("success");
		} catch (SQLException e) {
			System.out.println("sql���ݿ��ѯ�쳣");
			e.printStackTrace();
		}
		return rs;
	}
	public static void closeConn(){
		try {
			conn.close();
			//System.out.println("success");
		} catch (SQLException e) {
			System.out.println("sql���ݿ�ر��쳣");
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

}
