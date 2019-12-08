/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12004dDAO;
import com.sunway.service.IPgt12004dService;
import com.sunway.vo.Pgv12004d;

/**
 * 
 * 成本法、收益法房屋设施参数表
 * @author Andy.Gao
 *
 */
public class Pgt12004dService implements IPgt12004dService {

	private IPgt12004dDAO t12004dDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004dService#LoadAll(com.sunway.vo.Pgv12004d)
	 */
	@Override
	public ArrayList<Pgv12004d> LoadAll(Pgv12004d v12004d) throws Exception {
		return t12004dDao.LoadAll(v12004d);
	}

	/**
	 * @param t12004dDao the t12004dDao to set
	 */
	public void setT12004dDao(IPgt12004dDAO t12004dDao) {
		this.t12004dDao = t12004dDao;
	}

	/**
	 * @return the t12004dDao
	 */
	public IPgt12004dDAO getT12004dDao() {
		return t12004dDao;
	}

}
