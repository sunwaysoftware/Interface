/**
 *
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt02034cDAO;
import com.sunway.service.IPgt02034cService;
import com.sunway.vo.Pgt02034c;

/**
 * @author Andy.Gao
 *
 */
public class Pgt02034cService implements IPgt02034cService {

	private IPgt02034cDAO t02034cDao;

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02034cService#LoadAll()
	 */
	@Override
	public ArrayList<Pgt02034c> LoadAll(Pgt02034c bean) throws Exception {
		return t02034cDao.LoadAll(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02034cService#LoadAll()
	 */
	@Override
	public ArrayList<Pgt02034c> LoadAll_B(Pgt02034c bean) throws Exception {
		return t02034cDao.LoadAll_B(bean);
	}

	/**
	 * @param t02034cDao the t02034cDao to set
	 */
	public void setT02034cDao(IPgt02034cDAO t02034cDao) {
		this.t02034cDao = t02034cDao;
	}

	/**
	 * @return the t02034cDao
	 */
	public IPgt02034cDAO getT02034cDao() {
		return t02034cDao;
	}

}
