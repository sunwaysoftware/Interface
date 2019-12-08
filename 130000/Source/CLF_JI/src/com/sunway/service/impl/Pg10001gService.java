/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPg10001gDAO;
import com.sunway.service.IPg10001gService;
import com.sunway.vo.Pgv10031;

/**
 * 
 * 个案评税[成本法]
 * @author Andy.Gao
 * @category 个案评税
 *
 */
public class Pg10001gService implements IPg10001gService {

	private IPg10001gDAO g10001Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgg10001Service#LoadPgMx(com.sunway.vo.Pgv10031)
	 */
	@Override
	public ArrayList<Pgv10031> LoadPgMx(Pgv10031 bean) throws Exception {
		return g10001Dao.LoadPgMx(bean);
	}

	/**
	 * @param g10001Dao the g10001Dao to set
	 */
	public void setG10001Dao(IPg10001gDAO g10001Dao) {
		this.g10001Dao = g10001Dao;
	}

	/**
	 * @return the g10001Dao
	 */
	public IPg10001gDAO getG10001Dao() {
		return g10001Dao;
	}

}
