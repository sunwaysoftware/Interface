package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12054DAO;
import com.sunway.service.IPgt12054Service;
import com.sunway.vo.Pgt12054;
import com.sunway.vo.Pgv12054;

/**
 * 成本法、收益法土地等级
 * @author Lee
 * @version 1.0
 */
public class Pgt12054Service implements IPgt12054Service {

	private IPgt12054DAO t12054Dao;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12054Service#LoadAll(com.sunway.vo.Pgv12054)
	 */
	@Override
	public ArrayList<Pgv12054> LoadAll(Pgv12054 v12054) throws Exception {
		return t12054Dao.LoadAll(v12054);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12054Service#LoadByPrimaryKey(com.sunway.vo.Pgt12054)
	 */
	@Override
	public Pgt12054 LoadByPrimaryKey(Pgt12054 t12054) throws Exception {
		return t12054Dao.LoadByPrimaryKey(t12054);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12054Service#GetInsertCommand(com.sunway.vo.Pgt12054)
	 */
	@Override
	public Integer GetInsertCommand(Pgt12054 t12054) throws Exception {
		return t12054Dao.GetInsertCommand(t12054);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12054Service#GetDeleteCommand(com.sunway.vo.Pgt12054)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt12054 t12054) throws Exception {
		return t12054Dao.GetDeleteCommand(t12054);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12054Service#GetUpdateCommand(com.sunway.vo.Pgt12054)
	 */
	@Override
	public Integer GetUpdateCommand(Pgt12054 t12054) throws Exception {
		return t12054Dao.GetUpdateCommand(t12054);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12054Service#LoadNavigator(com.sunway.vo.Pgt12054)
	 */
	@Override
	public ArrayList<Pgt12054> LoadNavigator(Pgt12054 t12054) throws Exception {
		return t12054Dao.LoadNavigator(t12054);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12054Service#LoadTreeList(com.sunway.vo.Pgt12054)
	 */
	@Override
	public ArrayList<Pgt12054> LoadTreeList(Pgt12054 t12054) throws Exception {
		return t12054Dao.LoadTreeList(t12054);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12054Service#LoadNavStream(java.lang.String)
	 */
	@Override
	public String LoadNavStream(String tddjid) throws Exception {
		return t12054Dao.LoadNavStream(tddjid);
	}

	/**
	 * @return the t12054Dao
	 */
	public IPgt12054DAO getT12054Dao() {
		return t12054Dao;
	}
	/**
	 * @param t12054Dao the t12054Dao to set
	 */
	public void setT12054Dao(IPgt12054DAO t12054Dao) {
		this.t12054Dao = t12054Dao;
	}
}
