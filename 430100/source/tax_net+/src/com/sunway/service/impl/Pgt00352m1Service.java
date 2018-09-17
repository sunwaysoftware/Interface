/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00352m1DAO;
import com.sunway.service.IPgt00352m1Service;
import com.sunway.vo.Pgt00352m1;

public class Pgt00352m1Service implements IPgt00352m1Service {

	private IPgt00352m1DAO t00352m1Dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunway.service.IPgt00352m1Service#GetInsertCommand(com.sunway.vo.
	 * Pgt00352m1)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00352m1 t00352m1) throws Exception {
		return t00352m1Dao.GetInsertCommand(t00352m1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunway.service.IPgt00352m1Service#GetUpdateCommand(com.sunway.vo.
	 * Pgt00352m1)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00352m1 t00352m1) throws Exception {
		return t00352m1Dao.GetUpdateCommand(t00352m1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunway.service.IPgt00352m1Service#LoadAll(com.sunway.vo.Pgt00352m1)
	 */
	@Override
	public ArrayList<Pgt00352m1> LoadAll(Pgt00352m1 t00352m1) throws Exception {
		return t00352m1Dao.LoadAll(t00352m1);
	}

	public IPgt00352m1DAO getT00352m1Dao() {
		return t00352m1Dao;
	}

	public void setT00352m1Dao(IPgt00352m1DAO t00352m1Dao) {
		this.t00352m1Dao = t00352m1Dao;
	}

	@Override
	public boolean GetDeleteAllCommand(Pgt00352m1 t00352m1) throws Exception {
		// TODO Auto-generated method stub
		return t00352m1Dao.GetDeleteAllCommand(t00352m1);
	}

	@Override
	public boolean GetDeleteCommand(Pgt00352m1 t00352m1) throws Exception {
		// TODO Auto-generated method stub
		return t00352m1Dao.GetDeleteCommand(t00352m1);
	}

}
