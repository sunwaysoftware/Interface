package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00013DAO;
import com.sunway.service.IPgt00013Service;
import com.sunway.vo.Pgt00013;
import com.sunway.vo.Pgv00013;

/**
 * @category 用户操作概要记录
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00013Service implements IPgt00013Service {

	private IPgt00013DAO t00013Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00013Service#GetDeleteCommand(com.sunway.vo.Pgt00013)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00013 operaRecord) throws Exception {
		return t00013Dao.GetDeleteCommand(operaRecord);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00013Service#GetInsertCommand(com.sunway.vo.Pgt00013)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00013 operaRecord) throws Exception {
		return t00013Dao.GetInsertCommand(operaRecord);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00013Service#GetUpdateCommand(com.sunway.vo.Pgt00013)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00013 operaRecord) throws Exception {
		return t00013Dao.GetUpdateCommand(operaRecord);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00013Service#LoadAll(com.sunway.vo.Pgv00013)
	 */
	@Override
	public ArrayList<Pgv00013> LoadAll(Pgv00013 operaRecord) throws Exception {
		return t00013Dao.LoadAll(operaRecord);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00013Service#LoadByPrimaryKey(com.sunway.vo.Pgt00013)
	 */
	@Override
	public Pgt00013 LoadByPrimaryKey(Pgt00013 operaRecord) throws Exception {
		return t00013Dao.LoadByPrimaryKey(operaRecord);
	}

	/**
	 * @return the t00013Dao
	 */
	public IPgt00013DAO getT00013Dao() {
		return t00013Dao;
	}

	/**
	 * @param t00013Dao the t00013Dao to set
	 */
	public void setT00013Dao(IPgt00013DAO t00013Dao) {
		this.t00013Dao = t00013Dao;
	}

}
