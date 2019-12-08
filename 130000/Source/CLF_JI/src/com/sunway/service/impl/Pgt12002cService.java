/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12002cDAO;
import com.sunway.service.IPgt12002cService;
import com.sunway.vo.Pgv12002c;

/**
 * @author Andy.Gao
 *
 */
public class Pgt12002cService implements IPgt12002cService {

	private IPgt12002cDAO t12002cDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002cService#LoadAll(com.sunway.vo.Pgv12002b)
	 */
	@Override
	public ArrayList<Pgv12002c> LoadAll(Pgv12002c v12002c) throws Exception {
		return t12002cDao.LoadAll(v12002c);
	}

	/**
	 * @param t12002cDao the t12002cDao to set
	 */
	public void setT12002cDao(IPgt12002cDAO t12002cDao) {
		this.t12002cDao = t12002cDao;
	}
	/**
	 * @return the t12002cDao
	 */
	public IPgt12002cDAO getT12002cDao() {
		return t12002cDao;
	}
}
