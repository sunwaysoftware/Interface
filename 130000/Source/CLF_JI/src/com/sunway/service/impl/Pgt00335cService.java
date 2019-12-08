/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00335cDAO;
import com.sunway.service.IPgt00335cService;
import com.sunway.vo.Pgt00335c;

/**
 * @author Andy.Gao
 *
 */
public class Pgt00335cService implements IPgt00335cService {

	private IPgt00335cDAO t00335cDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00335cService#LoadAll(com.sunway.vo.Pgt00335c)
	 */
	@Override
	public ArrayList<Pgt00335c> LoadAll(Pgt00335c bean) throws Exception {
		return t00335cDao.LoadAll(bean);
	}

	/**
	 * @param t00335cDao the t00335cDao to set
	 */
	public void setT00335cDao(IPgt00335cDAO t00335cDao) {
		this.t00335cDao = t00335cDao;
	}

	/**
	 * @return the t00335cDao
	 */
	public IPgt00335cDAO getT00335cDao() {
		return t00335cDao;
	}

}
