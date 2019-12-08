package com.sunway.service.impl;


import java.util.ArrayList;

import com.sunway.dao.IPgt00357eDAO;
import com.sunway.service.IPgt00357eService;
import com.sunway.vo.Pgv00357e;

/**
 * 
 * 市场法土地其它评税参数表
 * @category 系统维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00357eService implements IPgt00357eService {

	private IPgt00357eDAO t00357eDao;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00357eService#LoadAll(com.sunway.vo.Pgv00357e)
	 */
	@Override
	public ArrayList<Pgv00357e> LoadAll(Pgv00357e v00357e) throws Exception {
		return t00357eDao.LoadAll(v00357e);
	}

	/**
	 * @return the t00357eDao
	 */
	public IPgt00357eDAO getT00357eDao() {
		return t00357eDao;
	}
	/**
	 * @param t00357eDao the t00357eDao to set
	 */
	public void setT00357eDao(IPgt00357eDAO t00357eDao) {
		this.t00357eDao = t00357eDao;
	}
}
