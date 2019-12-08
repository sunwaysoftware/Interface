/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt10031aDAO;
import com.sunway.service.IPgt10031aService;
import com.sunway.vo.Pgt10031a;
import com.sunway.vo.Pgv10031a1;

/**
 * 
 * 成本法评税其它修正参数表
 * @author Andy.Gao
 *
 */
public class Pgt10031aService implements IPgt10031aService {

	private IPgt10031aDAO t10031aDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10031aService#GetDeleteCommand(com.sunway.vo.Pgt10031a)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt10031a bean) throws Exception {
		return t10031aDao.GetDeleteCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10031aService#GetInsertCommand(com.sunway.vo.Pgt10031a)
	 */
	@Override
	public boolean GetInsertCommand(Pgt10031a bean) throws Exception {
		return t10031aDao.GetInsertCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10031aService#GetUpdateCommand(com.sunway.vo.Pgt10031a)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt10031a bean) throws Exception {
		return t10031aDao.GetUpdateCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10031aService#LoadAll(com.sunway.vo.Pgt10031a)
	 */
	@Override
	public ArrayList<Pgt10031a> LoadAll(Pgt10031a bean) throws Exception {
		return t10031aDao.LoadAll(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10031aService#LoadByPrimaryKey(com.sunway.vo.Pgt10031a)
	 */
	@Override
	public Pgt10031a LoadByPrimaryKey(Pgt10031a bean) throws Exception {
		return t10031aDao.LoadByPrimaryKey(bean);
	}

	/**
	 * @param t10031aDao the t10031aDao to set
	 */
	public void setT10031aDao(IPgt10031aDAO t10031aDao) {
		this.t10031aDao = t10031aDao;
	}

	/**
	 * @return the t10031aDao
	 */
	public IPgt10031aDAO getT10031aDao() {
		return t10031aDao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10031aService#LoadQtxzDC(com.sunway.vo.Pgv10031a1)
	 */
	@Override
	public ArrayList<Pgv10031a1> LoadQtxzDC(Pgv10031a1 bean) throws Exception {
		return t10031aDao.LoadQtxzDC(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10031aService#LoadQtxzFC(com.sunway.vo.Pgv10031a1)
	 */
	@Override
	public ArrayList<Pgv10031a1> LoadQtxzFC(Pgv10031a1 bean) throws Exception {
		return t10031aDao.LoadQtxzFC(bean);
	}

}
