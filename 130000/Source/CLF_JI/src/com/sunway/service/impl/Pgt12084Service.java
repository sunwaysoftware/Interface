/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12084DAO;
import com.sunway.service.IPgt12084Service;
import com.sunway.vo.Pgv12084;

/**
 * 
 * 成本，收益审核和评税未过原因说明
 * @author Andy.Gao
 *
 */
public class Pgt12084Service implements IPgt12084Service {

	private IPgt12084DAO t12084Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12084Service#LoadAll(com.sunway.vo.Pgv12084)
	 */
	@Override
	public ArrayList<Pgv12084> LoadAll(Pgv12084 bean) throws Exception {
		return t12084Dao.LoadAll(bean);
	}

	/**
	 * @param t12084Dao the t12084Dao to set
	 */
	public void setT12084Dao(IPgt12084DAO t12084Dao) {
		this.t12084Dao = t12084Dao;
	}

	/**
	 * @return the t12084Dao
	 */
	public IPgt12084DAO getT12084Dao() {
		return t12084Dao;
	}

}
