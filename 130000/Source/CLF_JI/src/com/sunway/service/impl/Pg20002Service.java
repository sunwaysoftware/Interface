/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPg20002DAO;
import com.sunway.service.IPg20002Service;
import com.sunway.vo.Pgv02031;
import com.sunway.vo.Pgv12001;

/**
 * 
 * 已評估[收益法]
 * @author Andy.Gao
 * @category 評估
 * @version 1.0
 *
 */
public class Pg20002Service implements IPg20002Service {

	private IPg20002DAO pg20002Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPg20002Service#GetExecPgAgain(com.sunway.vo.Pgv12001)
	 */
	@Override
	public Boolean GetExecPgAgain(Pgv12001 bean) throws Exception {
		return pg20002Dao.GetExecPgAgain(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPg20002Service#GetExecPgAgainAll(com.sunway.vo.Pgv12001)
	 */
	@Override
	public Boolean GetExecPgAgainAll(Pgv12001 bean) throws Exception {
		return pg20002Dao.GetExecPgAgainAll(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPg20002Service#LoadPgOK(com.sunway.vo.Pgv02031)
	 */
	@Override
	public ArrayList<Pgv02031> LoadPgOK(Pgv02031 bean) throws Exception {
		return pg20002Dao.LoadPgOK(bean);
	}

	/**
	 * @param pg20002Dao the pg20002Dao to set
	 */
	public void setPg20002Dao(IPg20002DAO pg20002Dao) {
		this.pg20002Dao = pg20002Dao;
	}

	/**
	 * @return the pg20002Dao
	 */
	public IPg20002DAO getPg20002Dao() {
		return pg20002Dao;
	}

}
