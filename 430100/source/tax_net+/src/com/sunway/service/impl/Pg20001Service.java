/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPg20001DAO;
import com.sunway.service.IPg20001Service;
import com.sunway.vo.Pgv02002;

/**
 * 
 * 未評估[市場法]
 * @author Andy.Gao
 * @category 評估
 * @version 1.0
 *
 */
public class Pg20001Service implements IPg20001Service {

	private IPg20001DAO pg20001Dao;
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPg30001Service#GetExecPG(com.sunway.vo.Pgv02002)
	 */
	@Override
	public Pgv02002 GetExecPG(Pgv02002 bean) throws Exception {
		return getPg20001Dao().GetExecPG(bean);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPg30001Service#LoadPg(com.sunway.vo.Pgv02002)
	 */
	@Override
	public ArrayList<Pgv02002> LoadPg(Pgv02002 bean) throws Exception {
		return getPg20001Dao().LoadPg(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPg30001Service#LoadPgMxNgList(com.sunway.vo.Pgv02002)
	 */
	@Override
	public ArrayList<Pgv02002> LoadPgMxNgList(Pgv02002 bean) throws Exception {
		return getPg20001Dao().LoadPgMxNgList(bean);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPg30001Service#LoadPgList(com.sunway.vo.Pgv02002)
	 */
	@Override
	public ArrayList<Pgv02002> LoadPgList(Pgv02002 bean) throws Exception {
		return getPg20001Dao().LoadPgList(bean);
	}

	/**
	 * @return the pg20001Dao
	 */
	public IPg20001DAO getPg20001Dao() {
		return pg20001Dao;
	}

	/**
	 * @param pg20001Dao the pg20001Dao to set
	 */
	public void setPg20001Dao(IPg20001DAO pg20001Dao) {
		this.pg20001Dao = pg20001Dao;
	}


}
