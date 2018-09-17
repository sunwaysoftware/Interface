package com.sunway.service.impl;

import com.sunway.dao.IPgt02005DAO;
import com.sunway.service.IPgt02005Service;
import com.sunway.vo.Pgv02005;

/**
 * 收益法国土状态
 * @author Light
 *
 */
public class Pgt02005Service implements IPgt02005Service{

	private IPgt02005DAO t02005Dao;

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02005Service#LoadDetailZT(com.sunway.vo.Pgv02005)
	 */
	@Override
	public Pgv02005 LoadDetailZT(Pgv02005 bean) throws Exception {
		return t02005Dao.LoadDetailZT(bean);
	}
	
	/************************   set && get   *************************/
	/**
	 * @return the t02005Dao
	 */
	public IPgt02005DAO getT02005Dao() {
		return t02005Dao;
	}

	/**
	 * @param t02005Dao the t02005Dao to set
	 */
	public void setT02005Dao(IPgt02005DAO t02005Dao) {
		this.t02005Dao = t02005Dao;
	}


}
