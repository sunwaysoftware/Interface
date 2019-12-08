/**
 * 
 */
package com.sunway.service.impl;

import com.sunway.dao.IPgt12003bDAO;
import com.sunway.service.IPgt12003bService;
import com.sunway.vo.Pgt12003b;
import com.sunway.vo.Pgv12003b;

/**
 * 
 * 房产当前承租人表
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt12003bService implements IPgt12003bService {

	private IPgt12003bDAO t12003bDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12003bService#GetDeleteCommand(com.sunway.vo.Pgt12003b)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt12003b t12003b) throws Exception {
		return t12003bDao.GetDeleteCommand(t12003b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12003bService#GetInsertCommand(com.sunway.vo.Pgt12003b)
	 */
	@Override
	public boolean GetInsertCommand(Pgt12003b t12003b) throws Exception {
		return t12003bDao.GetInsertCommand(t12003b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12003bService#GetUpdateCommand(com.sunway.vo.Pgt12003b)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt12003b t12003b) throws Exception {
		return t12003bDao.GetUpdateCommand(t12003b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12003bService#LoadAll(com.sunway.vo.Pgv12003b)
	 */
	@Override
	public Pgv12003b LoadAll(Pgv12003b v12003b) throws Exception {
		return t12003bDao.LoadAll(v12003b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12003bService#LoadByPrimaryKey(com.sunway.vo.Pgt12003b)
	 */
	@Override
	public Pgt12003b LoadByPrimaryKey(Pgt12003b t12003b) throws Exception {
		return t12003bDao.LoadByPrimaryKey(t12003b);
	}

	/**
	 * @param t12003bDao the t12003bDao to set
	 */
	public void setT12003bDao(IPgt12003bDAO t12003bDao) {
		this.t12003bDao = t12003bDao;
	}

	/**
	 * @return the t12003bDao
	 */
	public IPgt12003bDAO getT12003bDao() {
		return t12003bDao;
	}

}
