/**
 * 
 */
package com.sunway.service.impl;

import com.sunway.dao.IPgt00332DAO;
import com.sunway.service.IPgt00332Service;
import com.sunway.vo.Pgt00332;

/**
 * 
 * 市场法个案评税结果
 * @author Andy.Gao
 *
 */
public class Pgt00332Service implements IPgt00332Service {

	private IPgt00332DAO t00332Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00332Service#LoadByPrimaryKey(com.sunway.vo.Pgt00332)
	 */
	@Override
	public Pgt00332 LoadByPrimaryKey(Pgt00332 bean) throws Exception {
		return t00332Dao.LoadByPrimaryKey(bean);
	}

	/**
	 * @param t00332Dao the t00332Dao to set
	 */
	public void setT00332Dao(IPgt00332DAO t00332Dao) {
		this.t00332Dao = t00332Dao;
	}

	/**
	 * @return the t00332Dao
	 */
	public IPgt00332DAO getT00332Dao() {
		return t00332Dao;
	}
}
