/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12081DAO;
import com.sunway.service.IPgt12081Service;
import com.sunway.vo.Pgt12081;
import com.sunway.vo.Pgv12081;

/**
 * @category 审核平方米维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt12081Service implements IPgt12081Service {

	private IPgt12081DAO t12081Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12081Service#GetDeleteCommand(com.sunway.vo.Pgt12081)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt12081 pfmdj) throws Exception {
		return t12081Dao.GetDeleteCommand(pfmdj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12081Service#GetInsertCommand(com.sunway.vo.Pgt12081)
	 */
	@Override
	public boolean GetInsertCommand(Pgt12081 pfmdj) throws Exception {
		return t12081Dao.GetInsertCommand(pfmdj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12081Service#GetUpdateCommand(com.sunway.vo.Pgt12081)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt12081 pfmdj) throws Exception {
		return t12081Dao.GetUpdateCommand(pfmdj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12081Service#LoadAll(com.sunway.vo.Pgv12081)
	 */
	@Override
	public ArrayList<Pgv12081> LoadAll(Pgv12081 pfmdj) throws Exception {
		return t12081Dao.LoadAll(pfmdj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12081Service#LoadByPrimaryKey(com.sunway.vo.Pgt12081)
	 */
	@Override
	public Pgt12081 LoadByPrimaryKey(Pgt12081 pfmdj) throws Exception {
		return t12081Dao.LoadByPrimaryKey(pfmdj);
	}

	/**
	 * @return the t12081Dao
	 */
	public IPgt12081DAO getT12081Dao() {
		return t12081Dao;
	}

	/**
	 * @param t12081Dao the t12081Dao to set
	 */
	public void setT12081Dao(IPgt12081DAO t12081Dao) {
		this.t12081Dao = t12081Dao;
	}


}
