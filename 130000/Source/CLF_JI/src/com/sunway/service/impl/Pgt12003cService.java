/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12003cDAO;
import com.sunway.service.IPgt12003cService;
import com.sunway.vo.Pgv12003c;

/**
 * 
 * 房地产当前承租人历史表
 * @author Andy.Gao
 *
 */
public class Pgt12003cService implements IPgt12003cService {

	private IPgt12003cDAO t12003cDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12003cService#LoadAll()
	 */
	@Override
	public ArrayList<Pgv12003c> LoadAll(Pgv12003c v12003c) throws Exception {
		return t12003cDao.LoadAll(v12003c);
	}

	/**
	 * @param t12003cDao the t12003cDao to set
	 */
	public void setT12003cDao(IPgt12003cDAO t12003cDao) {
		this.t12003cDao = t12003cDao;
	}

	/**
	 * @return the t12003cDao
	 */
	public IPgt12003cDAO getT12003cDao() {
		return t12003cDao;
	}
}
