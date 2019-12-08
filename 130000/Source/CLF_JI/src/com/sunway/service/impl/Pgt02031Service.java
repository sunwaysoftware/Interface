/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt02031DAO;
import com.sunway.service.IPgt02031Service;
import com.sunway.vo.Pgt02031;
import com.sunway.vo.Pgv02031;

/**
 * 
 * 收益法评税结果
 * @author Andy.Gao
 *
 */
public class Pgt02031Service implements IPgt02031Service {

	private IPgt02031DAO t02031Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02031Service#LoadByPrimaryKey(com.sunway.vo.Pgt02031)
	 */
	@Override
	public Pgt02031 LoadByPrimaryKey(Pgt02031 bean) throws Exception {
		return t02031Dao.LoadByPrimaryKey(bean);
	}

	/**
	 * @param t02031Dao the t02031Dao to set
	 */
	public void setT02031Dao(IPgt02031DAO t02031Dao) {
		this.t02031Dao = t02031Dao;
	}

	/**
	 * @return the t02031Dao
	 */
	public IPgt02031DAO getT02031Dao() {
		return t02031Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02031Service#LoadBySwid(com.sunway.vo.Pgv02031)
	 */
	@Override
	public ArrayList<Pgv02031> LoadBySwid(Pgv02031 bean) throws Exception {
		return t02031Dao.LoadBySwid(bean);
	}
}
