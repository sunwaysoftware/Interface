/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00358DAO;
import com.sunway.service.IPgt00358Service;
import com.sunway.vo.Pgv00358;

/**
 * 
 * 临时的实例库
 * @author Andy.Gao
 *
 */
public class Pgt00358Service implements IPgt00358Service {

	private IPgt00358DAO t00358Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00358Service#LoadAll(com.sunway.vo.Pgv00358)
	 */
	@Override
	public ArrayList<Pgv00358> LoadAll(Pgv00358 bean) throws Exception {
		return t00358Dao.LoadAll(bean);
	}

	/**
	 * @param t00358Dao the t00358Dao to set
	 */
	public void setT00358Dao(IPgt00358DAO t00358Dao) {
		this.t00358Dao = t00358Dao;
	}

	/**
	 * @return the t00358Dao
	 */
	public IPgt00358DAO getT00358Dao() {
		return t00358Dao;
	}
}
