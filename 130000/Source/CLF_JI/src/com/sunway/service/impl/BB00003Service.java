/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IBB00003DAO;
import com.sunway.service.IBB00003Service;
import com.sunway.vo.BF00003;

/**
 * @author Andy.Gao
 *
 */
public class BB00003Service implements IBB00003Service {

	private IBB00003DAO bb00003Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IBB00003Service#LoadAll(com.sunway.vo.BF00003)
	 */
	@Override
	public ArrayList<BF00003> LoadAll(BF00003 bean) throws Exception {
		return bb00003Dao.LoadAll(bean);
	}

	/**
	 * @param bb00003Dao the bb00003Dao to set
	 */
	public void setBb00003Dao(IBB00003DAO bb00003Dao) {
		this.bb00003Dao = bb00003Dao;
	}

	/**
	 * @return the bb00003Dao
	 */
	public IBB00003DAO getBb00003Dao() {
		return bb00003Dao;
	}
}