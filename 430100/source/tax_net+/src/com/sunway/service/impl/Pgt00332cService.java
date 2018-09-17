/**
 *
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00332cDAO;
import com.sunway.service.IPgt00332cService;
import com.sunway.vo.Pgt00332c;

/**
 * @author Andy.Gao
 *
 */
public class Pgt00332cService implements IPgt00332cService {

	private IPgt00332cDAO t00332cDao;

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00332cService#LoadAll(com.sunway.vo.Pgt00332c)
	 */
	@Override
	public ArrayList<Pgt00332c> LoadAll(Pgt00332c bean) throws Exception {
		return t00332cDao.LoadAll(bean);
	}

	/**
	 * @param t00332cDao the t00332cDao to set
	 */
	public void setT00332cDao(IPgt00332cDAO t00332cDao) {
		this.t00332cDao = t00332cDao;
	}

	/**
	 * @return the t00332cDao
	 */
	public IPgt00332cDAO getT00332cDao() {
		return t00332cDao;
	}

}
