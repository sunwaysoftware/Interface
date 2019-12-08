/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12002DAO;
import com.sunway.service.IPgt12002Service;
import com.sunway.vo.Pgt12002;
import com.sunway.vo.Pgv12002;

/**
 * 
 * 成本、收益法地產信息
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt12002Service implements IPgt12002Service {

	private IPgt12002DAO t12002Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002Service#GetDeleteCommand(com.sunway.vo.Pgt12002)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt12002 t12002) throws Exception {
		return t12002Dao.GetDeleteCommand(t12002);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002Service#GetInsertCommand(com.sunway.vo.Pgt12002)
	 */
	@Override
	public boolean GetInsertCommand(Pgt12002 t12002) throws Exception {
		return t12002Dao.GetInsertCommand(t12002);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002Service#GetUpdateCommand(com.sunway.vo.Pgt12002)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt12002 t12002) throws Exception {
		return t12002Dao.GetUpdateCommand(t12002);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002Service#LoadAll(com.sunway.vo.Pgv12002)
	 */
	@Override
	public Pgv12002 LoadAll(Pgv12002 v12002) throws Exception {
		return t12002Dao.LoadAll(v12002);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002Service#LoadByPrimaryKey(com.sunway.vo.Pgt12002)
	 */
	@Override
	public Pgt12002 LoadByPrimaryKey(Pgt12002 t12002) throws Exception {
		return t12002Dao.LoadByPrimaryKey(t12002);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002Service#LoadMaxDcId()
	 */
	@Override
	public String LoadMaxDcId() throws Exception {
		return t12002Dao.LoadMaxDcId();
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12002Service#LoadDetail(com.sunway.vo.Pgv12002)
	 */
	@Override
	public Pgv12002 LoadDetail(Pgv12002 v12002) throws Exception {
		return t12002Dao.LoadDetail(v12002);
	}

	/**
	 * @param t12002Dao the t12002Dao to set
	 */
	public void setT12002Dao(IPgt12002DAO t12002Dao) {
		this.t12002Dao = t12002Dao;
	}

	/**
	 * @return the t12002Dao
	 */
	public IPgt12002DAO getT12002Dao() {
		return t12002Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002Service#GetTdsyqbmByDcid(com.sunway.vo.Pgt12002)
	 */
	@Override
	public Boolean GetTdsyqbmByDcid(Pgt12002 t12002) throws Exception {
		return t12002Dao.GetTdsyqbmByDcid(t12002);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002Service#LoadTDZL(com.sunway.vo.Pgv12002)
	 */
	@Override
	public ArrayList<String> LoadTDZL(Pgv12002 v12002) throws Exception {
		return t12002Dao.LoadTDZL(v12002);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002Service#LoadTDDJ(com.sunway.vo.Pgv12002)
	 */
	@Override
	public Pgv12002 LoadTDDJ(Pgv12002 v12002) throws Exception {
		return t12002Dao.LoadTDDJ(v12002);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12002Service#LoadPgv120025(com.sunway.vo.Pgv12002)
	 */
	@Override
	public Pgv12002 LoadPgv120025(Pgv12002 v12002) throws Exception {
		return t12002Dao.LoadPgv120025(v12002);
	}
}
