package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00351eDAO;
import com.sunway.service.IPgt00351eService;
import com.sunway.vo.Pgv00351e;

/**
 * 
 * 市场法标准实例库其它修正参数表
 * @author Lee
 *
 */
public class Pgt00351eService implements IPgt00351eService {

	private IPgt00351eDAO t00351eDao;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00351eService#LoadAll(com.sunway.vo.Pgv00351e)
	 */
	@Override
	public ArrayList<Pgv00351e> LoadAll(Pgv00351e v00351e) throws Exception {
		return t00351eDao.LoadAll(v00351e);
	}

	/**
	 * @return the t00351eDao
	 */
	public IPgt00351eDAO getT00351eDao() {
		return t00351eDao;
	}
	/**
	 * @param t00351eDao the t00351eDao to set
	 */
	public void setT00351eDao(IPgt00351eDAO t00351eDao) {
		this.t00351eDao = t00351eDao;
	}
}
