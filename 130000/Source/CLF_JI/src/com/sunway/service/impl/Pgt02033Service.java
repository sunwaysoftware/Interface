/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt02033DAO;
import com.sunway.service.IPgt02033Service;
import com.sunway.vo.Pgt02033;

/**
 * 
 * 收益法个案评税其它修正参数表
 * @author Andy.Gao
 *
 */
public class Pgt02033Service implements IPgt02033Service {

	private IPgt02033DAO t02033Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02033Service#GetDeleteCommand(com.sunway.vo.Pgt02033)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02033 bean) throws Exception {
		return t02033Dao.GetDeleteCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02033Service#GetInsertCommand(com.sunway.vo.Pgt02033)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02033 bean) throws Exception {
		return t02033Dao.GetInsertCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02033Service#GetUpdateCommand(com.sunway.vo.Pgt02033)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02033 bean) throws Exception {
		return t02033Dao.GetUpdateCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02033Service#LoadAll(com.sunway.vo.Pgt02033)
	 */
	@Override
	public ArrayList<Pgt02033> LoadAll(Pgt02033 bean) throws Exception {
		return t02033Dao.LoadAll(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02033Service#LoadByPrimaryKey(com.sunway.vo.Pgt02033)
	 */
	@Override
	public Pgt02033 LoadByPrimaryKey(Pgt02033 bean) throws Exception {
		return t02033Dao.LoadByPrimaryKey(bean);
	}

	/**
	 * @param t02033Dao the t02033Dao to set
	 */
	public void setT02033Dao(IPgt02033DAO t02033Dao) {
		this.t02033Dao = t02033Dao;
	}

	/**
	 * @return the t02033Dao
	 */
	public IPgt02033DAO getT02033Dao() {
		return t02033Dao;
	}
}
