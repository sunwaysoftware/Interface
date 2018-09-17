package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt02061aDAO;
import com.sunway.service.IPgt02061aService;
import com.sunway.vo.Pgt02061a;
import com.sunway.vo.Pgv02061;
import com.sunway.vo.Pgv02061a;

/**
 * 市场法标准房价格维护交易价格
 * @category 系统维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02061aService implements IPgt02061aService {

	private IPgt02061aDAO t02061aDao;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00301aService#LoadAll(com.sunway.vo.Pgv02061a)
	 */
	@Override
	public ArrayList<Pgv02061a> LoadAll(Pgv02061a v02061a) throws Exception {
		return t02061aDao.LoadAll(v02061a);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00301aService#GetInsertCommand(com.sunway.vo.Pgt02061a)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02061a t02061a) throws Exception {
		return t02061aDao.GetInsertCommand(t02061a);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00301aService#GetDeleteCommand(com.sunway.vo.Pgt02061a)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02061a t02061a) throws Exception {
		return t02061aDao.GetDeleteCommand(t02061a);
	}

	/**
	 * @return the t02061aDao
	 */
	public IPgt02061aDAO getT02061aDao() {
		return t02061aDao;
	}
	/**
	 * @param t02061aDao the t02061aDao to set
	 */
	public void setT02061aDao(IPgt02061aDAO t02061aDao) {
		this.t02061aDao = t02061aDao;
	}

	
	@Override
	public Pgv02061 LoadBySlid(Pgt02061a t02061a) throws Exception {
		return t02061aDao.LoadBySlid(t02061a);
	}
}
