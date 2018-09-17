/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00331DAO;
import com.sunway.service.IPgt00331Service;
import com.sunway.vo.Pgt00331;
import com.sunway.vo.Pgv00331;

/**
 * 
 * 市场法评税结果
 * @author Andy.Gao
 *
 */
public class Pgt00331Service implements IPgt00331Service {

	private IPgt00331DAO t00331Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00331Service#LoadByPrimaryKey(com.sunway.vo.Pgt00331)
	 */
	@Override
	public Pgt00331 LoadByPrimaryKey(Pgt00331 bean) throws Exception {
		return t00331Dao.LoadByPrimaryKey(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00331Service#LoadByPrimaryKey(com.sunway.vo.Pgt00331)
	 */
	@Override
	public Pgt00331 LoadByPrimaryKey_B(Pgt00331 bean) throws Exception {
		return t00331Dao.LoadByPrimaryKey_B(bean);
	}
	

	/**
	 * @param t00331Dao the t00331Dao to set
	 */
	public void setT00331Dao(IPgt00331DAO t00331Dao) {
		this.t00331Dao = t00331Dao;
	}

	/**
	 * @return the t00331Dao
	 */
	public IPgt00331DAO getT00331Dao() {
		return t00331Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00331Service#LoadBySwid(com.sunway.vo.Pgv00331)
	 */
	@Override
	public ArrayList<Pgv00331> LoadBySwid(Pgv00331 bean) throws Exception {
		return t00331Dao.LoadBySwid(bean);
	}
}
