/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00352mDAO;
import com.sunway.service.IPgt00352mService;
import com.sunway.vo.Pgt00352m;

public class Pgt00352mService implements IPgt00352mService {

	private IPgt00352mDAO t00352mDao;
	
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00352mService#GetInsertCommand(com.sunway.vo.Pgt00352m)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00352m t00352m) throws Exception {
		return t00352mDao.GetInsertCommand(t00352m);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00352mService#GetUpdateCommand(com.sunway.vo.Pgt00352m)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00352m t00352m) throws Exception {
		return t00352mDao.GetUpdateCommand(t00352m);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00352mService#LoadAll(com.sunway.vo.Pgt00352m)
	 */
	@Override
	public ArrayList<Pgt00352m> LoadAll(Pgt00352m t00352m) throws Exception {
		return t00352mDao.LoadAll(t00352m);
	}
	@Override
	public ArrayList<Pgt00352m> LoadAll0(Pgt00352m t00352m) throws Exception {
		return t00352mDao.LoadAll0(t00352m);
	}

	public IPgt00352mDAO getT00352mDao() {
		return t00352mDao;
	}

	public void setT00352mDao(IPgt00352mDAO t00352mDao) {
		this.t00352mDao = t00352mDao;
	}

	@Override
	public boolean GetDeleteAllCommand(Pgt00352m t00352m) throws Exception {
		// TODO Auto-generated method stub
		return t00352mDao.GetDeleteAllCommand(t00352m);
	}

	@Override
	public boolean GetDeleteCommand(Pgt00352m t00352m) throws Exception {
		// TODO Auto-generated method stub
		return t00352mDao.GetDeleteCommand(t00352m);
	}

	
}
