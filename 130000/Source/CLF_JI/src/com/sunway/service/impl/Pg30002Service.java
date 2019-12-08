/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPg30002DAO;
import com.sunway.service.IPg30002Service;
import com.sunway.vo.Pgv00302;
import com.sunway.vo.Pgv00331;

/**
 * 
 * 已評估[市場法]
 * @author Andy.Gao
 * @category 評估
 * @version 1.0
 *
 */
public class Pg30002Service implements IPg30002Service {

	private IPg30002DAO pg30002Dao;
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPg30002Service#GetExecPgAgain(com.sunway.vo.Pgv00302)
	 */
	@Override
	public Boolean GetExecPgAgain(Pgv00302 bean) throws Exception {
		return pg30002Dao.GetExecPgAgain(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPg30002Service#GetExecPgAgainAll(com.sunway.vo.Pgv00301)
	 */
	@Override
	public Boolean GetExecPgAgainAll(Pgv00302 bean) throws Exception {
		return pg30002Dao.GetExecPgAgainAll(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPg30002Service#LoadPgOK(com.sunway.vo.Pgv00331)
	 */
	@Override
	public ArrayList<Pgv00331> LoadPgOK(Pgv00331 bean) throws Exception {
		return pg30002Dao.LoadPgOK(bean);
	}

	/**
	 * @param pg30002Dao the pg30002Dao to set
	 */
	public void setPg30002Dao(IPg30002DAO pg30002Dao) {
		this.pg30002Dao = pg30002Dao;
	}

	/**
	 * @return the pg30002Dao
	 */
	public IPg30002DAO getPg30002Dao() {
		return pg30002Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPg30002Service#ExecInfoBg(com.sunway.vo.Pgv00302)
	 */
	@Override
	public Boolean ExecInfoBg(Pgv00302 bean) throws Exception {
		return pg30002Dao.ExecInfoBg(bean);
	}
}
