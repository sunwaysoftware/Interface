package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00305wDAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPgt00305wService;
import com.sunway.vo.Pgv00302;

/**
 * 市场法数据操作状态(没有添加到操作列表的数据)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */
public class Pgt00305wService extends BaseDAO implements IPgt00305wService{

	private IPgt00305wDAO t00305wDao;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00305wService#LoadAll(com.sunway.vo.Pgv00302)
	 */
	@Override
	public ArrayList<Pgv00302> LoadAll(Pgv00302 v00302) throws Exception {
		return t00305wDao.LoadAll(v00302);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00305wService#GetExecTJ(com.sunway.vo.Pgv00302)
	 */
	@Override
	public Boolean GetExecTJ(Pgv00302 v00302) throws Exception {
		return t00305wDao.GetExecTJ(v00302);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00305wService#GetExecTJAll(com.sunway.vo.Pgv00302)
	 */
	public Boolean GetExecTJAll(Pgv00302 v00302) throws Exception {
		return t00305wDao.GetExecTJAll(v00302);
	}

	/**
	 * @return the t00305wDao
	 */
	public IPgt00305wDAO getT00305wDao() {
		return t00305wDao;
	}

	/**
	 * @param t00305wDao the t00305wDao to set
	 */
	public void setT00305wDao(IPgt00305wDAO t00305wDao) {
		this.t00305wDao = t00305wDao;
	}
}
