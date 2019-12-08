/**
 * 
 */
package com.sunway.service.impl;

import com.sunway.dao.IPgt12004DAO;
import com.sunway.service.IPgt12004Service;
import com.sunway.vo.Pgt12004;
import com.sunway.vo.Pgv12004;

/**
 * 
 * 成本法、收益法房产明细信息
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt12004Service implements IPgt12004Service {

	private IPgt12004DAO t12004Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004Service#GetDeleteCommand(com.sunway.vo.Pgt12004)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt12004 t12004) throws Exception {
		return t12004Dao.GetDeleteCommand(t12004);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004Service#GetInsertCommand(com.sunway.vo.Pgt12004)
	 */
	@Override
	public boolean GetInsertCommand(Pgt12004 t12004) throws Exception {
		return t12004Dao.GetInsertCommand(t12004);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004Service#GetUpdateCommand(com.sunway.vo.Pgt12004)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt12004 t12004) throws Exception {
		return t12004Dao.GetUpdateCommand(t12004);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004Service#LoadAll(com.sunway.vo.Pgv12004)
	 */
	@Override
	public Pgv12004 LoadAll(Pgv12004 v12004) throws Exception {
		return t12004Dao.LoadAll(v12004);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004Service#LoadByPrimaryKey(com.sunway.vo.Pgt12004)
	 */
	@Override
	public Pgt12004 LoadByPrimaryKey(Pgt12004 t12004) throws Exception {
		return t12004Dao.LoadByPrimaryKey(t12004);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004Service#LoadMaxDcId()
	 */
	@Override
	public String LoadMaxMxId() throws Exception {
		return t12004Dao.LoadMaxMxId();
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12004Service#LoadDetail(com.sunway.vo.Pgv12004)
	 */
	@Override
	public Pgv12004 LoadDetail(Pgv12004 v12004) throws Exception {
		return t12004Dao.LoadDetail(v12004);
	}

	/**
	 * @param t12004Dao the t12004Dao to set
	 */
	public void setT12004Dao(IPgt12004DAO t12004Dao) {
		this.t12004Dao = t12004Dao;
	}

	/**
	 * @return the t12004Dao
	 */
	public IPgt12004DAO getT12004Dao() {
		return t12004Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004Service#LoadDD(com.sunway.vo.Pgv12004)
	 */
	@Override
	public Pgv12004 LoadDD(Pgv12004 v12004) throws Exception {
		return t12004Dao.LoadDD(v12004);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12004Service#LoadPgv120045(com.sunway.vo.Pgv12004)
	 */
	@Override
	public Pgv12004 LoadPgv120045(Pgv12004 v12004) throws Exception {
		return t12004Dao.LoadPgv120045(v12004);
	}
}
