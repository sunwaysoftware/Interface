/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPg10002DAO;
import com.sunway.service.IPg10002Service;
import com.sunway.vo.Pgv10031;
import com.sunway.vo.Pgv12001;

/**
 * 
 * 已評估[成本法]
 * @author Andy.Gao
 * @category 評估
 * @version 1.0
 *
 */
public class Pg10002Service implements IPg10002Service {

	private IPg10002DAO pg10002Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPg10002Service#GetExecPgAgain(com.sunway.vo.Pgv12001)
	 */
	@Override
	public Boolean GetExecPgAgain(Pgv12001 bean) throws Exception {
		return pg10002Dao.GetExecPgAgain(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPg10002Service#GetExecPgAgainAll(com.sunway.vo.Pgv12001)
	 */
	@Override
	public Boolean GetExecPgAgainAll(Pgv12001 bean) throws Exception {
		return pg10002Dao.GetExecPgAgainAll(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPg10002Service#LoadPgOK(com.sunway.vo.Pgv10031)
	 */
	@Override
	public ArrayList<Pgv10031> LoadPgOK(Pgv10031 bean) throws Exception {
		return pg10002Dao.LoadPgOK(bean);
	}

	/**
	 * @param pg10002Dao the pg10002Dao to set
	 */
	public void setPg10002Dao(IPg10002DAO pg10002Dao) {
		this.pg10002Dao = pg10002Dao;
	}

	/**
	 * @return the pg10002Dao
	 */
	public IPg10002DAO getPg10002Dao() {
		return pg10002Dao;
	}
}