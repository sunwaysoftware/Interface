/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12082DAO;
import com.sunway.service.IPgt12082Service;
import com.sunway.vo.Pgt12082;
import com.sunway.vo.Pgv12082;

/**
 * @category 审核容积率维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt12082Service implements IPgt12082Service {

	private IPgt12082DAO t12082Dao ;
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12082Service#GetDeleteCommand(com.sunway.vo.Pgt12082)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt12082 rjl) throws Exception {
		return t12082Dao.GetDeleteCommand(rjl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12082Service#GetInsertCommand(com.sunway.vo.Pgt12082)
	 */
	@Override
	public boolean GetInsertCommand(Pgt12082 rjl) throws Exception {
		return t12082Dao.GetInsertCommand(rjl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12082Service#GetUpdateCommand(com.sunway.vo.Pgt12082)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt12082 rjl) throws Exception {
		return t12082Dao.GetUpdateCommand(rjl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12082Service#LoadAll(com.sunway.vo.Pgv12082)
	 */
	@Override
	public ArrayList<Pgv12082> LoadAll(Pgv12082 rjl) throws Exception {
		return t12082Dao.LoadAll(rjl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12082Service#LoadByPrimaryKey(com.sunway.vo.Pgt12082)
	 */
	@Override
	public Pgt12082 LoadByPrimaryKey(Pgt12082 rjl) throws Exception {
		return t12082Dao.LoadByPrimaryKey(rjl);
	}

	/**
	 * @return the t12082Dao
	 */
	public IPgt12082DAO getT12082Dao() {
		return t12082Dao;
	}

	/**
	 * @param t12082Dao the t12082Dao to set
	 */
	public void setT12082Dao(IPgt12082DAO t12082Dao) {
		this.t12082Dao = t12082Dao;
	}

}
