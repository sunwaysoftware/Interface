package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt02064DAO;
import com.sunway.service.IPgt02064Service;
import com.sunway.vo.Pgt02064;

public class Pgt02064Service implements IPgt02064Service {
	private IPgt02064DAO t02064Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02064Service#GetDeleteCommand(com.sunway.vo.Pgt02064)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02064 bean) throws Exception {
		// TODO Auto-generated method stub
		return t02064Dao.GetDeleteCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02064Service#GetInsertCommand(com.sunway.vo.Pgt02064)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02064 bean) throws Exception {
		// TODO Auto-generated method stub
		return t02064Dao.GetInsertCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02064Service#GetUpdateCommand(com.sunway.vo.Pgt02064)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02064 bean) throws Exception {
		// TODO Auto-generated method stub
		return t02064Dao.GetUpdateCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02064Service#LoadAll(com.sunway.vo.Pgt02064)
	 */
	@Override
	public ArrayList<Pgt02064> LoadAll(Pgt02064 bean) throws Exception {
		// TODO Auto-generated method stub
		return t02064Dao.LoadAll(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02064Service#LoadByPrimaryKey(com.sunway.vo.Pgt02064)
	 */
	@Override
	public Pgt02064 LoadByPrimaryKey(Pgt02064 bean) throws Exception {
		// TODO Auto-generated method stub
		return t02064Dao.LoadByPrimaryKey(bean);
	}
	/**
	 * @return the t02064Dao
	 */
	public IPgt02064DAO getT02064Dao() {
		return t02064Dao;
	}

	/**
	 * @param t02064Dao the t02064Dao to set
	 */
	public void setT02064Dao(IPgt02064DAO t02064Dao) {
		this.t02064Dao = t02064Dao;
	}	
	
}
