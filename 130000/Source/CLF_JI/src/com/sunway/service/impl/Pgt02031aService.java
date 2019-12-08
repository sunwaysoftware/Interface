/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt02031aDAO;
import com.sunway.service.IPgt02031aService;
import com.sunway.vo.Pgt02031a;

/**
 * 
 * 收益法评税其它修正参数表
 * @author Andy.Gao
 *
 */
public class Pgt02031aService implements IPgt02031aService {

	private IPgt02031aDAO t02031aDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02031aService#GetDeleteCommand(com.sunway.vo.Pgt02031a)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02031a bean) throws Exception {
		return t02031aDao.GetDeleteCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02031aService#GetInsertCommand(com.sunway.vo.Pgt02031a)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02031a bean) throws Exception {
		return t02031aDao.GetInsertCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02031aService#GetUpdateCommand(com.sunway.vo.Pgt02031a)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02031a bean) throws Exception {
		return t02031aDao.GetUpdateCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02031aService#LoadAll(com.sunway.vo.Pgt02031a)
	 */
	@Override
	public ArrayList<Pgt02031a> LoadAll(Pgt02031a bean) throws Exception {
		return t02031aDao.LoadAll(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02031aService#LoadByPrimaryKey(com.sunway.vo.Pgt02031a)
	 */
	@Override
	public Pgt02031a LoadByPrimaryKey(Pgt02031a bean) throws Exception {
		return t02031aDao.LoadByPrimaryKey(bean);
	}

	/**
	 * @param t02031aDao the t02031aDao to set
	 */
	public void setT02031aDao(IPgt02031aDAO t02031aDao) {
		this.t02031aDao = t02031aDao;
	}

	/**
	 * @return the t02031aDao
	 */
	public IPgt02031aDAO getT02031aDao() {
		return t02031aDao;
	}

}
