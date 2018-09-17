/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00384DAO;
import com.sunway.service.IPgt00384Service;
import com.sunway.vo.Pgv00384;

/**
 * 
 * 市場审核和评税未过原因说明
 * @author Andy.Gao
 *
 */
public class Pgt00384Service implements IPgt00384Service {

	private IPgt00384DAO t00384Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00384Service#LoadAll(com.sunway.vo.Pgv00384)
	 */
	@Override
	public ArrayList<Pgv00384> LoadAll(Pgv00384 bean) throws Exception {
		return t00384Dao.LoadAll(bean);
	}

	/**
	 * @param t00384Dao the t00384Dao to set
	 */
	public void setT00384Dao(IPgt00384DAO t00384Dao) {
		this.t00384Dao = t00384Dao;
	}

	/**
	 * @return the t00384Dao
	 */
	public IPgt00384DAO getT00384Dao() {
		return t00384Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00384Service#LoadYY()
	 */
	@Override
	public ArrayList<Pgv00384> LoadYY(Pgv00384 bean) throws Exception {
		return t00384Dao.LoadYY(bean);
	}

	@Override
	public ArrayList<Pgv00384> LoadQMPG(Pgv00384 bean) throws Exception {
		return t00384Dao.LoadQMPG(bean);
	}

}
