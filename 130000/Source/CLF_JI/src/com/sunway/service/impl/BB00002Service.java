/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IBB00002DAO;
import com.sunway.service.IBB00002Service;
import com.sunway.vo.BF00002;

/**
 * @author Lee
 *
 */
public class BB00002Service implements IBB00002Service {

	private IBB00002DAO bb00002Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IBB00002Service#LoadAll(com.sunway.vo.BF00002)
	 */
	@Override
	public ArrayList<BF00002> LoadAll(BF00002 bean) throws Exception {
		return bb00002Dao.LoadAll(bean);
	}

	/**
	 * @param bb00002Dao the bb00002Dao to set
	 */
	public void setBb00002Dao(IBB00002DAO bb00002Dao) {
		this.bb00002Dao = bb00002Dao;
	}

	/**
	 * @return the bb00002Dao
	 */
	public IBB00002DAO getBb00002Dao() {
		return bb00002Dao;
	}
}
