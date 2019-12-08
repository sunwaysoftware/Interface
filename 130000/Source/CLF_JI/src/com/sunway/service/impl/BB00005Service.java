/**
 * 
 */
package com.sunway.service.impl;

import com.sunway.dao.IBB00005DAO;
import com.sunway.service.IBB00005Service;
import com.sunway.vo.BF00005;

/**
 * @author Andy.Gao
 *
 */
public class BB00005Service implements IBB00005Service {

	private IBB00005DAO bb00005Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IBB00005Service#LoadAll(com.sunway.vo.BF00005)
	 */
	@Override
	public BF00005 LoadAll(BF00005 bean) throws Exception {
		return bb00005Dao.LoadAll(bean);
	}

	/**
	 * @param bb00005Dao the bb00005Dao to set
	 */
	public void setBb00005Dao(IBB00005DAO bb00005Dao) {
		this.bb00005Dao = bb00005Dao;
	}

	/**
	 * @return the bb00005Dao
	 */
	public IBB00005DAO getBb00005Dao() {
		return bb00005Dao;
	}
}
