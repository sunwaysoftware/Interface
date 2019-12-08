package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00005DAO;
import com.sunway.service.IPgt00005Service;
import com.sunway.vo.Pgt00005;
import com.sunway.vo.Pgv00005;

/**
 * @author Lee
 *
 */
public class Pgt00005Service implements IPgt00005Service {

	private IPgt00005DAO t00005Dao;
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00005Service#GetDeleteCommand(com.sunway.vo.Pgt00005)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00005 roleRight) throws Exception {
		return t00005Dao.GetDeleteCommand(roleRight);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00005Service#GetInsertCommand(com.sunway.vo.Pgt00005)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00005 roleRight) throws Exception {
		return t00005Dao.GetInsertCommand(roleRight);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00005Service#GetUpdateCommand(com.sunway.vo.Pgt00005)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00005 roleRight) throws Exception {
		return t00005Dao.GetUpdateCommand(roleRight);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00005Service#LoadAll(com.sunway.vo.Pgv00005)
	 */
	@Override
	public ArrayList<Pgv00005> LoadAll(Pgv00005 roleRight) throws Exception {
		return t00005Dao.LoadAll(roleRight);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00005Service#LoadByPrimaryKey(com.sunway.vo.Pgt00005)
	 */
	@Override
	public Pgt00005 LoadByPrimaryKey(Pgt00005 roleRight) throws Exception {
		return t00005Dao.LoadByPrimaryKey(roleRight);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00005Service#LoadT000052(com.sunway.vo.Pgv00005)
	 */
	@Override
	public ArrayList<Pgv00005> LoadT000052(Pgv00005 v00005) throws Exception {
		return t00005Dao.LoadT000052(v00005);
	}

	/**
	 * @return the t00005Dao
	 */
	public IPgt00005DAO getT00005Dao() {
		return t00005Dao;
	}

	/**
	 * @param t00005Dao the t00005Dao to set
	 */
	public void setT00005Dao(IPgt00005DAO t00005Dao) {
		this.t00005Dao = t00005Dao;
	}

}
