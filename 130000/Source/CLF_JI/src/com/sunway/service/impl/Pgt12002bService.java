/**
 * 
 */
package com.sunway.service.impl;

import com.sunway.dao.IPgt12002bDAO;
import com.sunway.service.IPgt12002bService;
import com.sunway.vo.Pgt12002b;
import com.sunway.vo.Pgv12002b;

/**
 * 
 * 土地当前承租人表
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt12002bService implements IPgt12002bService {

	private IPgt12002bDAO t12002bDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002bService#GetDeleteCommand(com.sunway.vo.Pgt12002b)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt12002b t12002b) throws Exception {
		return t12002bDao.GetDeleteCommand(t12002b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002bService#GetInsertCommand(com.sunway.vo.Pgt12002b)
	 */
	@Override
	public boolean GetInsertCommand(Pgt12002b t12002b) throws Exception {
		return t12002bDao.GetInsertCommand(t12002b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002bService#GetUpdateCommand(com.sunway.vo.Pgt12002b)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt12002b t12002b) throws Exception {
		return t12002bDao.GetUpdateCommand(t12002b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002bService#LoadAll(com.sunway.vo.Pgv12002b)
	 */
	@Override
	public Pgv12002b LoadAll(Pgv12002b v12002b) throws Exception {
		return t12002bDao.LoadAll(v12002b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002bService#LoadByPrimaryKey(com.sunway.vo.Pgt12002b)
	 */
	@Override
	public Pgt12002b LoadByPrimaryKey(Pgt12002b t12002b) throws Exception {
		return t12002bDao.LoadByPrimaryKey(t12002b);
	}

	/**
	 * @param t12002bDao the t12002bDao to set
	 */
	public void setT12002bDao(IPgt12002bDAO t12002bDao) {
		this.t12002bDao = t12002bDao;
	}

	/**
	 * @return the t12002bDao
	 */
	public IPgt12002bDAO getT12002bDao() {
		return t12002bDao;
	}

}
