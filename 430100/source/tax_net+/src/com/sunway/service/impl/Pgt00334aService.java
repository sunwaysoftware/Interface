/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00334aDAO;
import com.sunway.service.IPgt00334aService;
import com.sunway.vo.Pgt00334a;

/**
 * 
 * 市场法参与评税的实例库
 * @author Andy.Gao
 *
 */
public class Pgt00334aService implements IPgt00334aService {

	private IPgt00334aDAO t00334aDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00334aService#LoadAll(com.sunway.vo.Pgt00334a)
	 */
	@Override
	public ArrayList<Pgt00334a> LoadAll(Pgt00334a bean) throws Exception {
		return t00334aDao.LoadAll(bean);
	}

	/**
	 * @param t00334aDao the t00334aDao to set
	 */
	public void setT00334aDao(IPgt00334aDAO t00334aDao) {
		this.t00334aDao = t00334aDao;
	}

	/**
	 * @return the t00334aDao
	 */
	public IPgt00334aDAO getT00334aDao() {
		return t00334aDao;
	}
}