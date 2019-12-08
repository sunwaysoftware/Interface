package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12055DAO;
import com.sunway.service.IPgt12055Service;
import com.sunway.vo.Pgt12055;
import com.sunway.vo.Pgv12055;

/**
 * @author Lee
 *
 */
public class Pgt12055Service implements IPgt12055Service {

	private IPgt12055DAO t12055Dao;

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12055Service#GetDeleteCommand(com.sunway.vo.Pgt12055)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt12055 pgfl) throws Exception {
		return t12055Dao.GetDeleteCommand(pgfl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12055Service#GetInsertCommand(com.sunway.vo.Pgt12055)
	 */
	@Override
	public boolean GetInsertCommand(Pgt12055 pgfl) throws Exception {
		return t12055Dao.GetInsertCommand(pgfl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12055Service#GetUpdateCommand(com.sunway.vo.Pgt12055)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt12055 pgfl) throws Exception {
		return t12055Dao.GetUpdateCommand(pgfl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12055Service#LoadAll(com.sunway.vo.Pgv12055)
	 */
	@Override
	public ArrayList<Pgv12055> LoadAll(Pgv12055 pgfl) throws Exception {
		return t12055Dao.LoadAll(pgfl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12055Service#LoadByPrimaryKey(com.sunway.vo.Pgt12055)
	 */
	@Override
	public Pgt12055 LoadByPrimaryKey(Pgt12055 pgfl) throws Exception {
		// TODO Auto-generated method stub
		return t12055Dao.LoadByPrimaryKey(pgfl);
	}

	/**
	 * @return the t12055Dao
	 */
	public IPgt12055DAO getT12055Dao() {
		return t12055Dao;
	}

	/**
	 * @param t12055Dao the t12055Dao to set
	 */
	public void setT12055Dao(IPgt12055DAO t12055Dao) {
		this.t12055Dao = t12055Dao;
	}

}
