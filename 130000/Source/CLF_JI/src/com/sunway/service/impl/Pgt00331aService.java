/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00331aDAO;
import com.sunway.service.IPgt00331aService;
import com.sunway.vo.Pgt00331a;

/**
 * @author Andy.Gao
 *
 */
public class Pgt00331aService implements IPgt00331aService {

	private IPgt00331aDAO t00331aDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00331aService#LoadAll(com.sunway.vo.Pgt00331a)
	 */
	@Override
	public ArrayList<Pgt00331a> LoadAll(Pgt00331a bean) throws Exception {
		return t00331aDao.LoadAll(bean);
	}

	/**
	 * @param t00331aDao the t00331aDao to set
	 */
	public void setT00331aDao(IPgt00331aDAO t00331aDao) {
		this.t00331aDao = t00331aDao;
	}

	/**
	 * @return the t00331aDao
	 */
	public IPgt00331aDAO getT00331aDao() {
		return t00331aDao;
	}

}
