package com.dao;

import java.util.List;

import com.entity.Message;

public interface MessageDao {
	public boolean register(Message message);
	public List<Message> getMessageAll(String id,String shenfen);
}
