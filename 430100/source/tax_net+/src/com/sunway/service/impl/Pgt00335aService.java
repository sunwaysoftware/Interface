/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00335aDAO;
import com.sunway.service.IPgt00335aService;
import com.sunway.vo.Pgt00335a;

/**
 * 
 * 市场法个案参与评估的实例库其它修正
 * @author Andy.Gao
 *
 */
public class Pgt00335aService implements IPgt00335aService {

	private IPgt00335aDAO t00335aDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00335aService#LoadAll(com.sunway.vo.Pgt00335a)
	 */
	@Override
	public ArrayList<Pgt00335a> LoadAll(Pgt00335a bean) throws Exception {
		return t00335aDao.LoadAll(bean);
	}

	/**
	 * @param t00335aDao the t00335aDao to set
	 */
	public void setT00335aDao(IPgt00335aDAO t00335aDao) {
		this.t00335aDao = t00335aDao;
	}

	/**
	 * @return the t00335aDao
	 */
	public IPgt00335aDAO getT00335aDao() {
		return t00335aDao;
	}

}
