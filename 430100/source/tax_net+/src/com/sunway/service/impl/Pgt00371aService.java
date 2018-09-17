/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00371aDAO;
import com.sunway.service.IPgt00371aService;
import com.sunway.vo.Pgt00371a;

/**
 * @author Andy.Gao
 *
 */
public class Pgt00371aService implements IPgt00371aService {

	private IPgt00371aDAO t00371aDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00371aService#GetDeleteCommand(com.sunway.vo.Pgt00371a)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00371a t00371a) throws Exception {
		return t00371aDao.GetDeleteCommand(t00371a);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00371aService#GetInsertCommand(com.sunway.vo.Pgt00371a)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00371a t00371a) throws Exception {
		return t00371aDao.GetInsertCommand(t00371a);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00371aService#GetUpdateCommand(com.sunway.vo.Pgt00371a)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00371a t00371a) throws Exception {
		return t00371aDao.GetUpdateCommand(t00371a);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00371aService#LoadAll(com.sunway.vo.Pgt00371a)
	 */
	@Override
	public ArrayList<Pgt00371a> LoadAll(Pgt00371a v00371a) throws Exception {
		return t00371aDao.LoadAll(v00371a);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00371aService#LoadAll(com.sunway.vo.Pgt00371a)
	 */
	@Override
	public ArrayList<Pgt00371a> LoadAll00302(Pgt00371a v00371a) throws Exception {
		return t00371aDao.LoadAll00302(v00371a);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00371aService#LoadAll(com.sunway.vo.Pgt00371a)
	 */
	@Override
	public ArrayList<Pgt00371a> LoadAll00302_B(Pgt00371a v00371a) throws Exception {
		return t00371aDao.LoadAll00302_B(v00371a);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00371aService#LoadAll(com.sunway.vo.Pgt00371a)
	 */
	@Override
	public ArrayList<Pgt00371a> LoadAll02002(Pgt00371a v00371a) throws Exception {
		return t00371aDao.LoadAll02002(v00371a);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00371aService#LoadAll(com.sunway.vo.Pgt00371a)
	 */
	@Override
	public ArrayList<Pgt00371a> LoadAll02002_B(Pgt00371a v00371a) throws Exception {
		return t00371aDao.LoadAll02002_B(v00371a);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00371aService#LoadByPrimaryKey(com.sunway.vo.Pgt00371a)
	 */
	@Override
	public Pgt00371a LoadByPrimaryKey(Pgt00371a t00371a) throws Exception {
		return t00371aDao.LoadByPrimaryKey(t00371a);
	}

	

	/**
	 * @param t00371aDao the t00371aDao to set
	 */
	public void setT00371aDao(IPgt00371aDAO t00371aDao) {
		this.t00371aDao = t00371aDao;
	}

	/**
	 * @return the t00371aDao
	 */
	public IPgt00371aDAO getT00371aDao() {
		return t00371aDao;
	}
	
}
