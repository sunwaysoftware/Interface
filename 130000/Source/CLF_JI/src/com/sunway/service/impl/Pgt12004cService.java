/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12004cDAO;
import com.sunway.service.IPgt12004cService;
import com.sunway.vo.Pgv12004c;

/**
 * 
 * 房產明細当前承租人历史表
 * @author Andy.Gao
 *
 */
public class Pgt12004cService implements IPgt12004cService {

	private IPgt12004cDAO t12004cDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004cService#LoadAll()
	 */
	@Override
	public ArrayList<Pgv12004c> LoadAll(Pgv12004c v12004c) throws Exception {
		return t12004cDao.LoadAll(v12004c);
	}

	/**
	 * @param t12004cDao the t12004cDao to set
	 */
	public void setT12004cDao(IPgt12004cDAO t12004cDao) {
		this.t12004cDao = t12004cDao;
	}

	/**
	 * @return the t12004cDao
	 */
	public IPgt12004cDAO getT12004cDao() {
		return t12004cDao;
	}
}
