package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00010DAO;
import com.sunway.service.IPgt00010Service;
import com.sunway.vo.Pgt00010;
import com.sunway.vo.Pgv00010;

/**
 * @author Lee
 *
 */
public class Pgt00010Service implements IPgt00010Service {
	
	private IPgt00010DAO t00010Dao;
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00010Service#GetDeleteCommand(com.sunway.vo.Pgt00010)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00010 userRole) throws Exception {
		return t00010Dao.GetDeleteCommand(userRole);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00010Service#GetInsertCommand(com.sunway.vo.Pgt00010)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00010 userRole) throws Exception {
		return t00010Dao.GetInsertCommand(userRole);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00010Service#GetUpdateCommand(com.sunway.vo.Pgt00010)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00010 userRole) throws Exception {
		return t00010Dao.GetUpdateCommand(userRole);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00010Service#LoadAll(com.sunway.vo.Pgv00010)
	 */
	@Override
	public ArrayList<Pgv00010> LoadAll(Pgv00010 userRole) throws Exception {
		return t00010Dao.LoadAll(userRole);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00010Service#LoadByPrimaryKey(com.sunway.vo.Pgt00010)
	 */
	@Override
	public Pgt00010 LoadByPrimaryKey(Pgt00010 userRole) throws Exception {
		return t00010Dao.LoadByPrimaryKey(userRole);
	}

	/**
	 * @return the t00010Dao
	 */
	public IPgt00010DAO getT00010Dao() {
		return t00010Dao;
	}

	/**
	 * @param t00010Dao the t00010Dao to set
	 */
	public void setT00010Dao(IPgt00010DAO t00010Dao) {
		this.t00010Dao = t00010Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00010Service#GetBatchInsCommand(com.sunway.vo.Pgt00010)
	 */
	@Override
	public boolean GetBatchInsCommand(Pgt00010 userRole) throws Exception {
		return t00010Dao.GetBatchInsCommand(userRole);
	}

}
