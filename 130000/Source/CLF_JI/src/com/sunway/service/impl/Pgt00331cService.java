/**
 *
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00331cDAO;
import com.sunway.service.IPgt00331cService;
import com.sunway.vo.Pgt00331c;

/**
 * @author Andy.Gao
 *
 */
public class Pgt00331cService implements IPgt00331cService {

	private IPgt00331cDAO t00331cDao;

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00331cService#LoadAll(com.sunway.vo.Pgt00331c)
	 */
	@Override
	public ArrayList<Pgt00331c> LoadAll(Pgt00331c bean) throws Exception {
		return t00331cDao.LoadAll(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00331cService#LoadAll(com.sunway.vo.Pgt00331c)
	 */
	@Override
	public ArrayList<Pgt00331c> LoadAll_B(Pgt00331c bean) throws Exception {
		return t00331cDao.LoadAll_B(bean);
	}

	/**
	 * @param t00331cDao the t00331cDao to set
	 */
	public void setT00331cDao(IPgt00331cDAO t00331cDao) {
		this.t00331cDao = t00331cDao;
	}

	/**
	 * @return the t00331cDao
	 */
	public IPgt00331cDAO getT00331cDao() {
		return t00331cDao;
	}

}
