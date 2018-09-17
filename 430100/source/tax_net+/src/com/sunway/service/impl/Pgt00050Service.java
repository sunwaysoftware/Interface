

/**
 * @author sunxdd
 *
 */

package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00050DAO;
import com.sunway.service.IPgt00050Service;
import com.sunway.vo.Pgv00050;

public class Pgt00050Service implements IPgt00050Service {

	private IPgt00050DAO t00050Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00050Service#GetDeleteCommand(com.sunway.vo.Pgv00050)
	 */
	@Override
	public boolean GetDeleteCommand(Pgv00050 b) throws Exception {
		return getT00050Dao().GetDeleteCommand(b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00050Service#GetInsertCommand(com.sunway.vo.Pgv00050)
	 */
	@Override
	public boolean GetInsertCommand(Pgv00050 b) throws Exception {
		return getT00050Dao().GetInsertCommand(b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00050Service#GetUpdateCommand(com.sunway.vo.Pgv00050)
	 */
	@Override
	public boolean GetUpdateCommand(Pgv00050 b) throws Exception {
		return getT00050Dao().GetUpdateCommand(b);
	}	

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00050Service#LoadAll(com.sunway.vo.Pgv00050)
	 */
	@Override
	public ArrayList<Pgv00050> LoadAll(Pgv00050 b) throws Exception {
		return getT00050Dao().LoadAll(b);
	}		

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00050Service#LoadByPrimaryKey(com.sunway.vo.Pgv00050)
	 */
	@Override
	public Pgv00050 LoadByPrimaryKey(Pgv00050 b) throws Exception {
		return getT00050Dao().LoadByPrimaryKey(b);
	}

	/**
	 * @return the t00050Dao
	 */
	public IPgt00050DAO getT00050Dao() {
		return t00050Dao;
	}

	/**
	 * @param t00050Dao the t00050Dao to set
	 */
	public void setT00050Dao(IPgt00050DAO t00050Dao) {
		this.t00050Dao = t00050Dao;
	}
	

	
}
