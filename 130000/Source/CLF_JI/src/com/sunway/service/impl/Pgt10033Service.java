/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt10033DAO;
import com.sunway.service.IPgt10033Service;
import com.sunway.vo.Pgt10033;

/**
 * 
 * 成本法个案评税其它修正参数表
 * @author Andy.Gao
 *
 */
public class Pgt10033Service implements IPgt10033Service {

	private IPgt10033DAO t10033Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10033Service#GetDeleteCommand(com.sunway.vo.Pgt10033)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt10033 bean) throws Exception {
		return t10033Dao.GetDeleteCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10033Service#GetInsertCommand(com.sunway.vo.Pgt10033)
	 */
	@Override
	public boolean GetInsertCommand(Pgt10033 bean) throws Exception {
		return t10033Dao.GetInsertCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10033Service#GetUpdateCommand(com.sunway.vo.Pgt10033)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt10033 bean) throws Exception {
		return t10033Dao.GetUpdateCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10033Service#LoadAll(com.sunway.vo.Pgt10033)
	 */
	@Override
	public ArrayList<Pgt10033> LoadAll(Pgt10033 bean) throws Exception {
		return t10033Dao.LoadAll(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10033Service#LoadByPrimaryKey(com.sunway.vo.Pgt10033)
	 */
	@Override
	public Pgt10033 LoadByPrimaryKey(Pgt10033 bean) throws Exception {
		return t10033Dao.LoadByPrimaryKey(bean);
	}

	/**
	 * @param t10033Dao the t10033Dao to set
	 */
	public void setT10033Dao(IPgt10033DAO t10033Dao) {
		this.t10033Dao = t10033Dao;
	}

	/**
	 * @return the t10033Dao
	 */
	public IPgt10033DAO getT10033Dao() {
		return t10033Dao;
	}

}
