/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgv00333aDAO;
import com.sunway.service.IPgv00333aService;
import com.sunway.vo.Pgv00333a;

/**
 * @author Andy.Gao
 *
 */
public class Pgv00333aService implements IPgv00333aService {

	private IPgv00333aDAO v00333aDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00333aService#GetExecCommand(com.sunway.vo.Pgv00333a)
	 */
	@Override
	public Boolean GetExecCommand(Pgv00333a bean) throws Exception {
		return v00333aDao.GetExecCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00333aService#LoadAll(com.sunway.vo.Pgv00333a)
	 */
	@Override
	public ArrayList<Pgv00333a> LoadAll(Pgv00333a bean) throws Exception {
		return v00333aDao.LoadAll(bean);
	}

	/**
	 * @param v00333aDao the v00333aDao to set
	 */
	public void setV00333aDao(IPgv00333aDAO v00333aDao) {
		this.v00333aDao = v00333aDao;
	}

	/**
	 * @return the v00333aDao
	 */
	public IPgv00333aDAO getV00333aDao() {
		return v00333aDao;
	}

}
