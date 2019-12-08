/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12004eDAO;
import com.sunway.service.IPgt12004eService;
import com.sunway.vo.Pgv12004e;

/**
 * 
 * 成本法明細其它评税参数表
 * @author Andy.Gao
 *
 */
public class Pgt12004eService implements IPgt12004eService {

	private IPgt12004eDAO t12004eDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004eService#LoadAll(com.sunway.vo.Pgv12004e)
	 */
	@Override
	public ArrayList<Pgv12004e> LoadAll(Pgv12004e v12004e) throws Exception {
		return t12004eDao.LoadAll(v12004e);
	}

	/**
	 * @param t12004eDao the t12004eDao to set
	 */
	public void setT12004eDao(IPgt12004eDAO t12004eDao) {
		this.t12004eDao = t12004eDao;
	}

	/**
	 * @return the t12004eDao
	 */
	public IPgt12004eDAO getT12004eDao() {
		return t12004eDao;
	}

}
