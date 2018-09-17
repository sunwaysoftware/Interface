/**
 *
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00334cDAO;
import com.sunway.service.IPgt00334cService;
import com.sunway.vo.Pgt00334c;

/**
 * @author Andy.Gao
 *
 */
public class Pgt00334cService implements IPgt00334cService {

	private IPgt00334cDAO t00334cDao;

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00334cService#LoadAll()
	 */
	@Override
	public ArrayList<Pgt00334c> LoadAll(Pgt00334c bean) throws Exception {
		return t00334cDao.LoadAll(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00334cService#LoadAll()
	 */
	@Override
	public ArrayList<Pgt00334c> LoadAll_B(Pgt00334c bean) throws Exception {
		return t00334cDao.LoadAll_B(bean);
	}

	/**
	 * @param t00334cDao the t00334cDao to set
	 */
	public void setT00334cDao(IPgt00334cDAO t00334cDao) {
		this.t00334cDao = t00334cDao;
	}

	/**
	 * @return the t00334cDao
	 */
	public IPgt00334cDAO getT00334cDao() {
		return t00334cDao;
	}

}
