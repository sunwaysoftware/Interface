/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00335DAO;
import com.sunway.service.IPgt00335Service;
import com.sunway.vo.Pgt00335;

/**
 * @author Andy.Gao
 *
 */
public class Pgt00335Service implements IPgt00335Service {

	private IPgt00335DAO t00335Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00335Service#LoadAll(com.sunway.vo.Pgt00335)
	 */
	@Override
	public ArrayList<Pgt00335> LoadAll(Pgt00335 bean) throws Exception {
		return t00335Dao.LoadAll(bean);
	}

	/**
	 * @param t00335Dao the t00335Dao to set
	 */
	public void setT00335Dao(IPgt00335DAO t00335Dao) {
		this.t00335Dao = t00335Dao;
	}

	/**
	 * @return the t00335Dao
	 */
	public IPgt00335DAO getT00335Dao() {
		return t00335Dao;
	}

}
