package com.dao;
import com.entity.Message;
import com.util.DBconn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements MessageDao{
	public boolean register(Message message) {
		boolean flag = false;
		DBconn.init();
		int i =DBconn.addUpdDel("insert into message(title,detail,send_time,sender,recipient,shenfen) " +
				"values('"+message.getTitle()+"','"+message.getdetail()+"','"+message.getsend_time()+"','"+message.getsender()+"','"+message.getrecipient()+"','"+message.getshenfen()+"')");
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
	public List<Message> getMessageAll(String id,String shenfen) {
		List<Message> list = new ArrayList<Message>();
    	try {
    		
		    DBconn.init();
			ResultSet rs = DBconn.selectSql("select * from message where recipient='"+id+"' and shenfen='"+shenfen+"'");
			while(rs.next()){
				Message message = new Message();
				message.setTitle(rs.getString("title"));
				message.setdetail(rs.getString("detail"));
				message.setsender(rs.getString("sender"));
				message.setrecipient(rs.getString("recipient"));
				message.setsend_time(rs.getString("send_time"));
				message.setshenfen(rs.getString("shenfen"));
				list.add(message);
			}
			DBconn.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
