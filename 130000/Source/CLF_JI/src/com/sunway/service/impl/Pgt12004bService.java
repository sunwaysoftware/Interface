/**
 * 
 */
package com.sunway.service.impl;

import com.sunway.dao.IPgt12004bDAO;
import com.sunway.service.IPgt12004bService;
import com.sunway.vo.Pgt12004b;
import com.sunway.vo.Pgv12004b;

/**
 * 
 * 房产明细当前承租人表
 * @author Andy.Gao
 *
 */
public class Pgt12004bService implements IPgt12004bService {

	private IPgt12004bDAO t12004bDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004bService#GetDeleteCommand(com.sunway.vo.Pgt12004b)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt12004b t12004b) throws Exception {
		return t12004bDao.GetDeleteCommand(t12004b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004bService#GetInsertCommand(com.sunway.vo.Pgt12004b)
	 */
	@Override
	public boolean GetInsertCommand(Pgt12004b t12004b) throws Exception {
		return t12004bDao.GetInsertCommand(t12004b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004bService#GetUpdateCommand(com.sunway.vo.Pgt12004b)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt12004b t12004b) throws Exception {
		return t12004bDao.GetUpdateCommand(t12004b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004bService#LoadAll(com.sunway.vo.Pgv12004b)
	 */
	@Override
	public Pgv12004b LoadAll(Pgv12004b v12004b) throws Exception {
		return t12004bDao.LoadAll(v12004b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004bService#LoadByPrimaryKey(com.sunway.vo.Pgt12004b)
	 */
	@Override
	public Pgt12004b LoadByPrimaryKey(Pgt12004b t12004b) throws Exception {
		return t12004bDao.LoadByPrimaryKey(t12004b);
	}

	/**
	 * @param t12004bDao the t12004bDao to set
	 */
	public void setT12004bDao(IPgt12004bDAO t12004bDao) {
		this.t12004bDao = t12004bDao;
	}

	/**
	 * @return the t12004bDao
	 */
	public IPgt12004bDAO getT12004bDao() {
		return t12004bDao;
	}

}
