/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPg10001DAO;
import com.sunway.service.IPg10001Service;
import com.sunway.vo.Pgv12001;
import com.sunway.vo.Pgv12004;

/**
 * 
 * 未評估[成本法]
 * @author Andy.Gao
 * @category 評估
 * @version 1.0
 *
 */
public class Pg10001Service implements IPg10001Service {

	private IPg10001DAO pg10001Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPg10001Service#GetExecPG(com.sunway.vo.Pgv12001)
	 */
	@Override
	public Boolean GetExecPG(Pgv12001 bean) throws Exception {
		return pg10001Dao.GetExecPG(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPg10001Service#LoadPg(com.sunway.vo.Pgv12001)
	 */
	@Override
	public ArrayList<Pgv12001> LoadPg(Pgv12001 bean) throws Exception {
		return pg10001Dao.LoadPg(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPg10001Service#LoadPgSwidList(com.sunway.vo.Pgv12001)
	 */
	@Override
	public ArrayList<Pgv12001> LoadPgSwidList(Pgv12001 bean) throws Exception {
		return pg10001Dao.LoadPgSwidList(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPg10001Service#LoadPgMxNgList(com.sunway.vo.Pgv12004)
	 */
	@Override
	public ArrayList<Pgv12004> LoadPgMxNgList(Pgv12004 bean) throws Exception {
		return pg10001Dao.LoadPgMxNgList(bean);
	}
	
	/**
	 * @param pg10001Dao the pg10001Dao to set
	 */
	public void setPg10001Dao(IPg10001DAO pg10001Dao) {
		this.pg10001Dao = pg10001Dao;
	}

	/**
	 * @return the pg10001Dao
	 */
	public IPg10001DAO getPg10001Dao() {
		return pg10001Dao;
	}
}
