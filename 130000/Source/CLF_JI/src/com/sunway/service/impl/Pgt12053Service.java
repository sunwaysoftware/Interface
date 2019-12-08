package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12053DAO;
import com.sunway.service.IPgt12053Service;
import com.sunway.vo.Pgt12053;
import com.sunway.vo.Pgv12053;

/**
 * 成本法、收益法地段基准
 * @author Lee
 * @version 1.0
 */
public class Pgt12053Service implements IPgt12053Service {

	private IPgt12053DAO t12053Dao;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12053Service#LoadAll(com.sunway.vo.Pgv12053)
	 */
	@Override
	public ArrayList<Pgv12053> LoadAll(Pgv12053 v12053) throws Exception {
		return t12053Dao.LoadAll(v12053);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12053Service#LoadByPrimaryKey(com.sunway.vo.Pgt12053)
	 */
	@Override
	public Pgt12053 LoadByPrimaryKey(Pgt12053 t12053) throws Exception {
		return t12053Dao.LoadByPrimaryKey(t12053);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12053Service#GetInsertCommand(com.sunway.vo.Pgt12053)
	 */
	@Override
	public Integer GetInsertCommand(Pgt12053 t12053) throws Exception {
		return t12053Dao.GetInsertCommand(t12053);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12053Service#GetDeleteCommand(com.sunway.vo.Pgt12053)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt12053 t12053) throws Exception {
		return t12053Dao.GetDeleteCommand(t12053);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12053Service#GetUpdateCommand(com.sunway.vo.Pgt12053)
	 */
	@Override
	public Integer GetUpdateCommand(Pgt12053 t12053) throws Exception {
		return t12053Dao.GetUpdateCommand(t12053);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12053Service#LoadNavigator(com.sunway.vo.Pgt12053)
	 */
	@Override
	public ArrayList<Pgt12053> LoadNavigator(Pgt12053 t12053) throws Exception {
		return t12053Dao.LoadNavigator(t12053);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12053Service#LoadTreeList(com.sunway.vo.Pgt12053)
	 */
	@Override
	public ArrayList<Pgt12053> LoadTreeList(Pgt12053 t12053) throws Exception {
		return t12053Dao.LoadTreeList(t12053);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12053Service#LoadNavStream(java.lang.String)
	 */
	@Override
	public String LoadNavStream(String ddid) throws Exception {
		return t12053Dao.LoadNavStream(ddid);
	}

	/**
	 * @return the t12053Dao
	 */
	public IPgt12053DAO getT12053Dao() {
		return t12053Dao;
	}
	/**
	 * @param t12053Dao the t12053Dao to set
	 */
	public void setT12053Dao(IPgt12053DAO t12053Dao) {
		this.t12053Dao = t12053Dao;
	}
}
