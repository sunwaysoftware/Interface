/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPg30001DAO;
import com.sunway.service.IPg30001Service;
import com.sunway.vo.Pgv00302;

/**
 * 
 * 未評估[市場法]
 * @author Andy.Gao
 * @category 評估
 * @version 1.0
 *
 */
public class Pg30001Service implements IPg30001Service {

	private IPg30001DAO pg30001Dao;
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPg30001Service#GetExecPG(com.sunway.vo.Pgv00302)
	 */
	@Override
	public Pgv00302 GetExecPG(Pgv00302 bean) throws Exception {
		return pg30001Dao.GetExecPG(bean);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPg30001Service#LoadPg(com.sunway.vo.Pgv00302)
	 */
	@Override
	public ArrayList<Pgv00302> LoadPg(Pgv00302 bean) throws Exception {
		return pg30001Dao.LoadPg(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPg30001Service#LoadPgMxNgList(com.sunway.vo.Pgv00302)
	 */
	@Override
	public ArrayList<Pgv00302> LoadPgMxNgList(Pgv00302 bean) throws Exception {
		return pg30001Dao.LoadPgMxNgList(bean);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPg30001Service#LoadPgList(com.sunway.vo.Pgv00302)
	 */
	@Override
	public ArrayList<Pgv00302> LoadPgList(Pgv00302 bean) throws Exception {
		return pg30001Dao.LoadPgList(bean);
	}

	/**
	 * @param pg30001Dao the pg30001Dao to set
	 */
	public void setPg30001Dao(IPg30001DAO pg30001Dao) {
		this.pg30001Dao = pg30001Dao;
	}

	/**
	 * @return the pg30001Dao
	 */
	public IPg30001DAO getPg30001Dao() {
		return pg30001Dao;
	}

}
