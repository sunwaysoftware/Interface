/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPg20001DAO;
import com.sunway.service.IPg20001Service;
import com.sunway.vo.Pgv12001;
import com.sunway.vo.Pgv12004;

/**
 * 
 * 未評估[收益法]
 * @author Andy.Gao
 * @category 評估
 * @version 1.0
 *
 */
public class Pg20001Service implements IPg20001Service {

	private IPg20001DAO pg20001Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPg20001Service#GetExecPG(com.sunway.vo.Pgv12001)
	 */
	@Override
	public Boolean GetExecPG(Pgv12001 bean) throws Exception {
		return pg20001Dao.GetExecPG(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPg20001Service#LoadPg(com.sunway.vo.Pgv12001)
	 */
	@Override
	public ArrayList<Pgv12001> LoadPg(Pgv12001 bean) throws Exception {
		return pg20001Dao.LoadPg(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPg20001Service#LoadPgMxNgList(com.sunway.vo.Pgv12004)
	 */
	@Override
	public ArrayList<Pgv12004> LoadPgMxNgList(Pgv12004 bean) throws Exception {
		return pg20001Dao.LoadPgMxNgList(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPg20001Service#LoadPgSwidList(com.sunway.vo.Pgv12001)
	 */
	@Override
	public ArrayList<Pgv12001> LoadPgSwidList(Pgv12001 bean) throws Exception {
		return pg20001Dao.LoadPgSwidList(bean);
	}

	/**
	 * @param pg20001Dao the pg20001Dao to set
	 */
	public void setPg20001Dao(IPg20001DAO pg20001Dao) {
		this.pg20001Dao = pg20001Dao;
	}

	/**
	 * @return the pg20001Dao
	 */
	public IPg20001DAO getPg20001Dao() {
		return pg20001Dao;
	}

}
