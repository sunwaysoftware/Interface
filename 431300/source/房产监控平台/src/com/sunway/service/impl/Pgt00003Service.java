package com.sunway.service.impl;

import com.sunway.dao.IPgt00003DAO;
import com.sunway.service.IPgt00003Service;
import com.sunway.vo.Pgt00003;

public class Pgt00003Service implements IPgt00003Service {
	private IPgt00003DAO t00003Dao;
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	
	public boolean GetUpdateCommand(Pgt00003 expriyDays) throws Exception {
		return t00003Dao.GetUpdateCommand(expriyDays);
	}
	@Override
	public Pgt00003 LoadByPrimaryKey() throws Exception {
		return t00003Dao.LoadByPrimaryKey();
	}
	public IPgt00003DAO getT00003Dao() {
		return t00003Dao;
	}
	public void setT00003Dao(IPgt00003DAO t00003Dao) {
		this.t00003Dao = t00003Dao;
	}
	
	
}
