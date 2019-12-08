/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00012DAO;
import com.sunway.service.IPgt00012Service;
import com.sunway.vo.Pgt00012;
import com.sunway.vo.Pgv00012;

/**
 * @category 系统常规配置
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00012Service implements IPgt00012Service {

	private IPgt00012DAO t00012Dao;
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00012Service#GetDeleteCommand(com.sunway.vo.Pgt00012)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00012 sysConfig) throws Exception {
		return t00012Dao.GetDeleteCommand(sysConfig);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00012Service#GetInsertCommand(com.sunway.vo.Pgt00012)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00012 sysConfig) throws Exception {
		return t00012Dao.GetInsertCommand(sysConfig);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00012Service#GetUpdateCommand(com.sunway.vo.Pgt00012)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00012 sysConfig) throws Exception {
		return t00012Dao.GetUpdateCommand(sysConfig);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00012Service#LoadAll(com.sunway.vo.Pgv00012)
	 */
	@Override
	public ArrayList<Pgv00012> LoadAll(Pgv00012 sysConfig) throws Exception {
		return t00012Dao.LoadAll(sysConfig);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00012Service#LoadByPrimaryKey(com.sunway.vo.Pgt00012)
	 */
	@Override
	public Pgt00012 LoadByPrimaryKey(Pgt00012 sysConfig) throws Exception {
		return t00012Dao.LoadByPrimaryKey(sysConfig);
	}

	/**
	 * @return the t00012Dao
	 */
	public IPgt00012DAO getT00012Dao() {
		return t00012Dao;
	}

	/**
	 * @param t00012Dao the t00012Dao to set
	 */
	public void setT00012Dao(IPgt00012DAO t00012Dao) {
		this.t00012Dao = t00012Dao;
	}

}
