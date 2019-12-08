/**
 * 
 */
package com.sunway.service.impl;

import com.sunway.dao.IPgt12001DAO;
import com.sunway.service.IPgt12001Service;
import com.sunway.vo.Pgt12001;
import com.sunway.vo.Pgv12001;

/**
 * @author Andy.Gao
 *
 */
public class Pgt12001Service implements IPgt12001Service {

	private IPgt12001DAO t12001Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12001Service#GetDeleteCommand(com.sunway.vo.Pgt12001)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt12001 t12001) throws Exception {
		return t12001Dao.GetDeleteCommand(t12001);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12001Service#GetInsertCommand(com.sunway.vo.Pgt12001)
	 */
	@Override
	public boolean GetInsertCommand(Pgt12001 t12001) throws Exception {
		return t12001Dao.GetInsertCommand(t12001);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12001Service#GetUpdateCommand(com.sunway.vo.Pgt12001)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt12001 t12001) throws Exception {
		return t12001Dao.GetUpdateCommand(t12001);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12001Service#LoadAll(com.sunway.vo.Pgv12001)
	 */
	@Override
	public Pgv12001 LoadAll(Pgv12001 v12001) throws Exception {
		return t12001Dao.LoadAll(v12001);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12001Service#LoadByPrimaryKey(com.sunway.vo.Pgt12001)
	 */
	@Override
	public Pgt12001 LoadByPrimaryKey(Pgt12001 t12001) throws Exception {
		return t12001Dao.LoadByPrimaryKey(t12001);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12001Service#LoadDetail(com.sunway.vo.Pgv12001)
	 */
	public Pgv12001 LoadDetail(Pgv12001 v12001) throws Exception {
		return t12001Dao.LoadDetail(v12001);
	}

	/**
	 * @param t12001Dao the t12001Dao to set
	 */
	public void setT12001Dao(IPgt12001DAO t12001Dao) {
		this.t12001Dao = t12001Dao;
	}

	/**
	 * @return the t12001Dao
	 */
	public IPgt12001DAO getT12001Dao() {
		return t12001Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12001Service#LoadCount(com.sunway.vo.Pgt12001)
	 */
	@Override
	public Pgt12001 LoadCount(Pgt12001 t12001) throws Exception {
		return t12001Dao.LoadCount(t12001);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12001Service#LoadPgv120015(com.sunway.vo.Pgv12001)
	 */
	@Override
	public Pgv12001 LoadPgv120015(Pgv12001 v12001) throws Exception {
		return t12001Dao.LoadPgv120015(v12001);
	}
}
