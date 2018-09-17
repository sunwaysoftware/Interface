/**
 *
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt02031cDAO;
import com.sunway.service.IPgt02031cService;
import com.sunway.vo.Pgt02031c;

/**
 * @author Andy.Gao
 *
 */
public class Pgt02031cService implements IPgt02031cService {

	private IPgt02031cDAO t02031cDao;

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02031cService#LoadAll(com.sunway.vo.Pgt02031c)
	 */
	@Override
	public ArrayList<Pgt02031c> LoadAll(Pgt02031c bean) throws Exception {
		return t02031cDao.LoadAll(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02031cService#LoadAll(com.sunway.vo.Pgt02031c)
	 */
	@Override
	public ArrayList<Pgt02031c> LoadAll_B(Pgt02031c bean) throws Exception {
		return t02031cDao.LoadAll_B(bean);
	}

	/**
	 * @param t02031cDao the t02031cDao to set
	 */
	public void setT02031cDao(IPgt02031cDAO t02031cDao) {
		this.t02031cDao = t02031cDao;
	}

	/**
	 * @return the t02031cDao
	 */
	public IPgt02031cDAO getT02031cDao() {
		return t02031cDao;
	}

}
