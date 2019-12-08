/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00334DAO;
import com.sunway.service.IPgt00334Service;
import com.sunway.vo.Pgt00334;

/**
 * 
 * 市场法参与评税的实例库
 * @author Andy.Gao
 *
 */
public class Pgt00334Service implements IPgt00334Service {

	private IPgt00334DAO t00334Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00334Service#LoadAll(com.sunway.vo.Pgt00334)
	 */
	@Override
	public ArrayList<Pgt00334> LoadAll(Pgt00334 bean) throws Exception {
		return t00334Dao.LoadAll(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00334Service#LoadAll(com.sunway.vo.Pgt00334)
	 */
	@Override
	public ArrayList<Pgt00334> LoadAll_B(Pgt00334 bean) throws Exception {
		return t00334Dao.LoadAll_B(bean);
	}

	/**
	 * @param t00334Dao the t00334Dao to set
	 */
	public void setT00334Dao(IPgt00334DAO t00334Dao) {
		this.t00334Dao = t00334Dao;
	}

	/**
	 * @return the t00334Dao
	 */
	public IPgt00334DAO getT00334Dao() {
		return t00334Dao;
	}
}
