package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00305yDAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPgt00305yService;
import com.sunway.vo.Pgv00305;

/**
 * 市场法数据操作状态表
 * @category 市场法数据操作状态表
 * @author Lee
 * @version 1.0
 */
public class Pgt00305yService extends BaseDAO implements IPgt00305yService {

	private	IPgt00305yDAO t00305yDao;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00305yService#LoadAll(com.sunway.vo.Pgv00305)
	 */
	@Override
	public ArrayList<Pgv00305> LoadAll(Pgv00305 sjczzt) throws Exception {
		return t00305yDao.LoadAll(sjczzt);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00305yService#GetExecRTJ(com.sunway.vo.Pgv00305)
	 */
	@Override
	public Boolean GetExecRTJ(Pgv00305 v00305) throws Exception {
		return t00305yDao.GetExecRTJ(v00305);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00305yService#GetExecRTJAll(com.sunway.vo.Pgv00305)
	 */
	@Override
	public Boolean GetExecRTJAll(Pgv00305 v00305) throws Exception {
		return t00305yDao.GetExecRTJAll(v00305);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00305yService#GetBackup(com.sunway.vo.Pgv00305)
	 */
	@Override
	public Boolean GetBackup(Pgv00305 v00305) throws Exception {
		return t00305yDao.GetBackup(v00305);
	}

	/**
	 * @return the t00305yDao
	 */
	public IPgt00305yDAO getT00305yDao() {
		return t00305yDao;
	}

	/**
	 * @param t00305yDao the t00305yDao to set
	 */
	public void setT00305yDao(IPgt00305yDAO t00305yDao) {
		this.t00305yDao = t00305yDao;
	}
}
