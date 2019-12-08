/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12005yDAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPgt12005yService;
import com.sunway.vo.Pgv12005;

/**
 * @category 成本，收益法数据操作状态
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt12005yService extends BaseDAO implements IPgt12005yService {

	private IPgt12005yDAO t12005yDao;
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12005yService#LoadAll(com.sunway.vo.Pgv12005)
	 */
	@Override
	public ArrayList<Pgv12005> LoadAll(Pgv12005 v12005) throws Exception {
		return t12005yDao.LoadAll(v12005);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12005yService#GetExecRTJ(com.sunway.vo.Pgv12005)
	 */
	@Override
	public Boolean GetExecRTJ(Pgv12005 v12005) throws Exception {
		return t12005yDao.GetExecRTJ(v12005);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12005yService#GetExecRTJAll(com.sunway.vo.Pgv12005)
	 */
	@Override
	public Boolean GetExecRTJAll(Pgv12005 v12005) throws Exception {
		return t12005yDao.GetExecRTJAll(v12005);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12005yService#GetBackup(com.sunway.vo.Pgv12005)
	 */
	@Override
	public Boolean GetBackup(Pgv12005 v12005) throws Exception {
		return t12005yDao.GetBackup(v12005);
	}

	/**
	 * @return the t12005yDao
	 */
	public IPgt12005yDAO getT12005yDao() {
		return t12005yDao;
	}

	/**
	 * @param t12005yDao the t12005yDao to set
	 */
	public void setT12005yDao(IPgt12005yDAO t12005yDao) {
		this.t12005yDao = t12005yDao;
	}

}
