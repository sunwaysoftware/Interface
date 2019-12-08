package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12005wDAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPgt12005wService;
import com.sunway.vo.Pgv12001;

/**
 * 成本、收益法数据操作状态(没有添加到操作列表的数据)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */
public class Pgt12005wService extends BaseDAO implements IPgt12005wService {

	private IPgt12005wDAO t12005wDao;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12005wService#LoadAll(com.sunway.vo.Pgv12001)
	 */
	@Override
	public ArrayList<Pgv12001> LoadAll(Pgv12001 v12001) throws Exception {
		return t12005wDao.LoadAll(v12001);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12005wService#GetExecTJ(com.sunway.vo.Pgv12001)
	 */
	@Override
	public Boolean GetExecTJ(Pgv12001 v12001) throws Exception {
		return t12005wDao.GetExecTJ(v12001);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12005wService#GetExecTJAll(com.sunway.vo.Pgv12001)
	 */
	public Boolean GetExecTJAll(Pgv12001 v12001) throws Exception {
		return t12005wDao.GetExecTJAll(v12001);
	}

	/**
	 * @return the t12005wDao
	 */
	public IPgt12005wDAO getT12005wDao() {
		return t12005wDao;
	}

	/**
	 * @param t12005wDao the t12005wDao to set
	 */
	public void setT12005wDao(IPgt12005wDAO t12005wDao) {
		this.t12005wDao = t12005wDao;
	}
}
