/**
 * 
 */
package com.sunway.service.impl;

import com.sunway.dao.IPgt02032DAO;
import com.sunway.service.IPgt02032Service;
import com.sunway.vo.Pgt02032;

/**
 * 
 * 收益法个案评税结果表
 * @author Andy.Gao
 *
 */
public class Pgt02032Service implements IPgt02032Service {

	private IPgt02032DAO t02032Dao; 
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02032Service#LoadByPrimaryKey(com.sunway.vo.Pgt02032)
	 */
	@Override
	public Pgt02032 LoadByPrimaryKey(Pgt02032 bean) throws Exception {
		return t02032Dao.LoadByPrimaryKey(bean);
	}

	/**
	 * @param t02032Dao the t02032Dao to set
	 */
	public void setT02032Dao(IPgt02032DAO t02032Dao) {
		this.t02032Dao = t02032Dao;
	}

	/**
	 * @return the t02032Dao
	 */
	public IPgt02032DAO getT02032Dao() {
		return t02032Dao;
	}

}
