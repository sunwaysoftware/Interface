/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgv02033aDAO;
import com.sunway.service.IPgv02033aService;
import com.sunway.vo.Pgv02033a;

/**
 * @author Andy.Gao
 *
 */
public class Pgv02033aService implements IPgv02033aService {

	private IPgv02033aDAO v02033aDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02033aService#GetExecCommand(com.sunway.vo.Pgv02033a)
	 */
	@Override
	public Boolean GetExecCommand(Pgv02033a bean) throws Exception {
		return v02033aDao.GetExecCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02033aService#LoadAll(com.sunway.vo.Pgv02033a)
	 */
	@Override
	public ArrayList<Pgv02033a> LoadAll(Pgv02033a bean) throws Exception {
		return v02033aDao.LoadAll(bean);
	}

	/**
	 * @param v02033aDao the v02033aDao to set
	 */
	public void setV02033aDao(IPgv02033aDAO v02033aDao) {
		this.v02033aDao = v02033aDao;
	}

	/**
	 * @return the v02033aDao
	 */
	public IPgv02033aDAO getV02033aDao() {
		return v02033aDao;
	}

}
