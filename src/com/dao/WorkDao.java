package com.dao;

import java.util.List;

import com.entity.Work;

public interface WorkDao {
	public boolean register(Work work);//ע��
	public List<Work> getWorkAll();//�����û���Ϣ����
}
