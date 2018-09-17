/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt02034DAO;
import com.sunway.service.IPgt02034Service;
import com.sunway.vo.Pgt02034;

/**
 * 
 * 市场法参与评税的实例库
 * @author Andy.Gao
 *
 */
public class Pgt02034Service implements IPgt02034Service {

	private IPgt02034DAO t02034Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02034Service#LoadAll(com.sunway.vo.Pgt02034)
	 */
	@Override
	public ArrayList<Pgt02034> LoadAll(Pgt02034 bean) throws Exception {
		return t02034Dao.LoadAll(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02034Service#LoadAll(com.sunway.vo.Pgt02034)
	 */
	@Override
	public ArrayList<Pgt02034> LoadAll_B(Pgt02034 bean) throws Exception {
		return t02034Dao.LoadAll_B(bean);
	}

	/**
	 * @param t02034Dao the t02034Dao to set
	 */
	public void setT02034Dao(IPgt02034DAO t02034Dao) {
		this.t02034Dao = t02034Dao;
	}

	/**
	 * @return the t02034Dao
	 */
	public IPgt02034DAO getT02034Dao() {
		return t02034Dao;
	}
}
