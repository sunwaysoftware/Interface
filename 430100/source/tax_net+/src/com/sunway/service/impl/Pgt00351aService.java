package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00351aDAO;
import com.sunway.service.IPgt00351aService;
import com.sunway.vo.Pgt00351a;
import com.sunway.vo.Pgv00351a;

/**
 * 市场法标准房价格维护交易价格
 * @category 系统维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00351aService implements IPgt00351aService {

	private IPgt00351aDAO t00351aDao;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00301aService#LoadAll(com.sunway.vo.Pgv00351a)
	 */
	@Override
	public ArrayList<Pgv00351a> LoadAll(Pgv00351a v00351a) throws Exception {
		return t00351aDao.LoadAll(v00351a);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00301aService#GetInsertCommand(com.sunway.vo.Pgt00351a)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00351a t00351a) throws Exception {
		return t00351aDao.GetInsertCommand(t00351a);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00301aService#GetDeleteCommand(com.sunway.vo.Pgt00351a)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00351a t00351a) throws Exception {
		return t00351aDao.GetDeleteCommand(t00351a);
	}

	/**
	 * @return the t00351aDao
	 */
	public IPgt00351aDAO getT00351aDao() {
		return t00351aDao;
	}
	/**
	 * @param t00351aDao the t00351aDao to set
	 */
	public void setT00351aDao(IPgt00351aDAO t00351aDao) {
		this.t00351aDao = t00351aDao;
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00351aService#LoadByPrimaryKey(com.sunway.vo.Pgt00351a)
	 */
	@Override
	public ArrayList<Pgv00351a> LoadByPrimaryKey(Pgt00351a t00351a) throws Exception {
		
		return t00351aDao.LoadByPrimaryKey(t00351a);
	}

	
}
