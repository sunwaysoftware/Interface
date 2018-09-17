package com.sunway.service.impl;

import java.util.ArrayList;
import com.sunway.dao.IPgt00006DAO;
import com.sunway.service.IPgt00006Service;
import com.sunway.vo.Pgt00006;
import com.sunway.vo.Pgv00006;

/**
 * @author Lee
 *
 */
public class Pgt00006Service implements IPgt00006Service {

	private IPgt00006DAO t00006Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00006Service#GetDeleteCommand(com.sunway.vo.Pgt00006)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00006 userRight) throws Exception {
		return t00006Dao.GetDeleteCommand(userRight);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00006Service#GetInsertCommand(com.sunway.vo.Pgt00006)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00006 userRight) throws Exception {
		return t00006Dao.GetInsertCommand(userRight);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00006Service#GetUpdateCommand(com.sunway.vo.Pgt00006)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00006 userRight) throws Exception {
		return t00006Dao.GetUpdateCommand(userRight);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00006Service#LoadAll(com.sunway.vo.Pgv00006)
	 */
	@Override
	public ArrayList<Pgv00006> LoadAll(Pgv00006 userRight) throws Exception {
		return t00006Dao.LoadAll(userRight);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00006Service#LoadByPrimaryKey(com.sunway.vo.Pgt00006)
	 */
	@Override
	public Pgt00006 LoadByPrimaryKey(Pgt00006 userRight) throws Exception {
		return t00006Dao.LoadByPrimaryKey(userRight);
	}

	/**
	 * @return the t00006Dao
	 */
	public IPgt00006DAO getT00006Dao() {
		return t00006Dao;
	}

	/**
	 * @param t00006Dao the t00006Dao to set
	 */
	public void setT00006Dao(IPgt00006DAO t00006Dao) {
		this.t00006Dao = t00006Dao;
	}

}
