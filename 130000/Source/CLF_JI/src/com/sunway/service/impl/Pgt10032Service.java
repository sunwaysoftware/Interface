/**
 * 
 */
package com.sunway.service.impl;

import com.sunway.dao.IPgt10032DAO;
import com.sunway.service.IPgt10032Service;
import com.sunway.vo.Pgt10032;

/**
 * 
 * 成本法个案评税结果表
 * @author Andy.Gao
 *
 */
public class Pgt10032Service implements IPgt10032Service {

	private IPgt10032DAO t10032Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10032Service#LoadByPrimaryKey(com.sunway.vo.Pgt10032)
	 */
	@Override
	public Pgt10032 LoadByPrimaryKey(Pgt10032 bean) throws Exception {
		return t10032Dao.LoadByPrimaryKey(bean);
	}

	/**
	 * @param t10032Dao the t10032Dao to set
	 */
	public void setT10032Dao(IPgt10032DAO t10032Dao) {
		this.t10032Dao = t10032Dao;
	}

	/**
	 * @return the t10032Dao
	 */
	public IPgt10032DAO getT10032Dao() {
		return t10032Dao;
	}

}
