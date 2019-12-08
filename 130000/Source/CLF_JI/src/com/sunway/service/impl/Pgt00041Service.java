/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00041DAO;
import com.sunway.service.IPgt00041Service;
import com.sunway.vo.Pgv00041;

/**
 * 
 * 应纳税款计算表
 * @author Andy.Gao
 *
 */
public class Pgt00041Service implements IPgt00041Service {

	private IPgt00041DAO t00041Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00041Service#LoadAllCB(com.sunway.vo.Pgv00041)
	 */
	@Override
	public ArrayList<Pgv00041> LoadAllCB(Pgv00041 bean) throws Exception {
		return t00041Dao.LoadAllCB(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00041Service#LoadAllSC(com.sunway.vo.Pgv00041)
	 */
	@Override
	public ArrayList<Pgv00041> LoadAllSC(Pgv00041 bean) throws Exception {
		return t00041Dao.LoadAllSC(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00041Service#LoadAllSY(com.sunway.vo.Pgv00041)
	 */
	@Override
	public ArrayList<Pgv00041> LoadAllSY(Pgv00041 bean) throws Exception {
		return t00041Dao.LoadAllSY(bean);
	}
	
	/**
	 * @param t00041Dao the t00041Dao to set
	 */
	public void setT00041Dao(IPgt00041DAO t00041Dao) {
		this.t00041Dao = t00041Dao;
	}

	/**
	 * @return the t00041Dao
	 */
	public IPgt00041DAO getT00041Dao() {
		return t00041Dao;
	}
}
