/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IBB00004DAO;
import com.sunway.service.IBB00004Service;
import com.sunway.vo.BF00004;

/**
 * @author Andy.Gao
 *
 */
public class BB00004Service implements IBB00004Service {

	private IBB00004DAO bb00004Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IBB00004Service#LoadAll(com.sunway.vo.BF00004)
	 */
	@Override
	public ArrayList<BF00004> LoadAll(BF00004 bean) throws Exception {
		return bb00004Dao.LoadAll(bean);
	}

	/**
	 * @param bb00004Dao the bb00004Dao to set
	 */
	public void setBb00004Dao(IBB00004DAO bb00004Dao) {
		this.bb00004Dao = bb00004Dao;
	}

	/**
	 * @return the bb00004Dao
	 */
	public IBB00004DAO getBb00004Dao() {
		return bb00004Dao;
	}
}
