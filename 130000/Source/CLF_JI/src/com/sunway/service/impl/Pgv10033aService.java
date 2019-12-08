/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgv10033aDAO;
import com.sunway.service.IPgv10033aService;
import com.sunway.vo.Pgv10033a;

/**
 * @author Andy.Gao
 *
 */
public class Pgv10033aService implements IPgv10033aService {

	private IPgv10033aDAO v10033aDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv10033aService#LoadAll(com.sunway.vo.Pgv10033a)
	 */
	@Override
	public ArrayList<Pgv10033a> LoadAll(Pgv10033a bean) throws Exception {
		return v10033aDao.LoadAll(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv10033aService#GetExecCommand(com.sunway.vo.Pgv10033a)
	 */
	@Override
	public Boolean GetExecCommand(Pgv10033a bean) throws Exception {
		return v10033aDao.GetExecCommand(bean);
	}
	
	/**
	 * @param v10033aDao the v10033aDao to set
	 */
	public void setV10033aDao(IPgv10033aDAO v10033aDao) {
		this.v10033aDao = v10033aDao;
	}

	/**
	 * @return the v10033aDao
	 */
	public IPgv10033aDAO getV10033aDao() {
		return v10033aDao;
	}

}
