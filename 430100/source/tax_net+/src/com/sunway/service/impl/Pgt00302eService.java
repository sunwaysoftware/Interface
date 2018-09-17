package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00302eDAO;
import com.sunway.service.IPgt00302eService;
import com.sunway.vo.Pgv00302e;

/**
 * 
 * 市场法国土其它修正参数表
 * @author Lee
 *
 */
public class Pgt00302eService implements IPgt00302eService {

	private IPgt00302eDAO t00302eDao;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00302eService#LoadAll(com.sunway.vo.Pgv00302e)
	 */
	@Override
	public ArrayList<Pgv00302e> LoadAll(Pgv00302e v00302e) throws Exception {
		return t00302eDao.LoadAll(v00302e);
	}

	/**
	 * @return the t00302eDao
	 */
	public IPgt00302eDAO getT00302eDao() {
		return t00302eDao;
	}
	/**
	 * @param t00302eDao the t00302eDao to set
	 */
	public void setT00302eDao(IPgt00302eDAO t00302eDao) {
		this.t00302eDao = t00302eDao;
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00302eService#LoadAllQM(com.sunway.vo.Pgv00302e)
	 */
	@Override
	public ArrayList<Pgv00302e> LoadAllQM(Pgv00302e v00302e) throws Exception {
		
		return t00302eDao.LoadAllQM(v00302e);
	}
}
