/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvCz00002DAO;
import com.sunway.service.IPgvCz00002Service;
import com.sunway.vo.PgvCz00002;

/**
 * 审核类型名称
 * @category 审核类型名称
 * @author Lee
 * @version 1.0
 */
public class PgvCz00002Service implements IPgvCz00002Service {

	private IPgvCz00002DAO v00002Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgvCz00002Service#LoadAll(com.sunway.vo.PgvCz00002)
	 */
	@Override
	public ArrayList<PgvCz00002> LoadAll(PgvCz00002 shlxmc) throws Exception {
		return v00002Dao.LoadAll(shlxmc);
	}

	/**
	 * @return the v00002Dao
	 */
	public IPgvCz00002DAO getV00002Dao() {
		return v00002Dao;
	}

	/**
	 * @param v00002Dao the v00002Dao to set
	 */
	public void setV00002Dao(IPgvCz00002DAO v00002Dao) {
		this.v00002Dao = v00002Dao;
	}

}
