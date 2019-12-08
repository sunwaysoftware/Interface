/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12002eDAO;
import com.sunway.service.IPgt12002eService;
import com.sunway.vo.Pgv12002e;

/**
 * 
 * 成本法土地其它评税参数表
 * @author Andy.Gao
 *
 */
public class Pgt12002eService implements IPgt12002eService {

	private IPgt12002eDAO t12002eDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002eService#LoadAll()
	 */
	@Override
	public ArrayList<Pgv12002e> LoadAll(Pgv12002e v12002e) throws Exception {
		return t12002eDao.LoadAll(v12002e);
	}

	/**
	 * @param t12002eDao the t12002eDao to set
	 */
	public void setT12002eDao(IPgt12002eDAO t12002eDao) {
		this.t12002eDao = t12002eDao;
	}

	/**
	 * @return the t12002eDao
	 */
	public IPgt12002eDAO getT12002eDao() {
		return t12002eDao;
	}

}
