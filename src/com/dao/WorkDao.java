package com.dao;

import java.util.List;

import com.entity.Work;

public interface WorkDao {
	public boolean register(Work work);//注册
	public List<Work> getWorkAll();//返回用户信息集合
}
