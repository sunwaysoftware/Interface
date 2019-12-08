package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00009DAO;
import com.sunway.service.IPgt00009Service;
import com.sunway.vo.Pgt00009;
import com.sunway.vo.Pgv00009;

/**
 * @author Lee
 *
 */
public class Pgt00009Service implements IPgt00009Service {

	private IPgt00009DAO t00009Dao;
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00009Service#GetDeleteCommand(com.sunway.vo.Pgt00009)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00009 ssgx) throws Exception {
		return t00009Dao.GetDeleteCommand(ssgx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00009Service#GetInsertCommand(com.sunway.vo.Pgt00009)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00009 ssgx) throws Exception {
		return t00009Dao.GetInsertCommand(ssgx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00009Service#GetUpdateCommand(com.sunway.vo.Pgt00009)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00009 ssgx) throws Exception {
		return t00009Dao.GetUpdateCommand(ssgx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00009Service#LoadAll(com.sunway.vo.Pgv00009)
	 */
	@Override
	public ArrayList<Pgv00009> LoadAll(Pgv00009 ssgx) throws Exception {
		return t00009Dao.LoadAll(ssgx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00009Service#LoadByPrimaryKey(com.sunway.vo.Pgt00009)
	 */
	@Override
	public Pgt00009 LoadByPrimaryKey(Pgt00009 ssgx) throws Exception {
		return t00009Dao.LoadByPrimaryKey(ssgx);
	}

	/**
	 * @return the t00009Dao
	 */
	public IPgt00009DAO getT00009Dao() {
		return t00009Dao;
	}

	/**
	 * @param t00009Dao the t00009Dao to set
	 */
	public void setT00009Dao(IPgt00009DAO t00009Dao) {
		this.t00009Dao = t00009Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00009Service#LoadAllSSGX(java.lang.String)
	 */
	@Override
	public ArrayList<Pgv00009> LoadAllSSGX(String userID) throws Exception {
		return t00009Dao.LoadAllSSGX(userID);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00009Service#GetUpdDef(com.sunway.vo.Pgt00009)
	 */
	@Override
	public boolean GetUpdDef(Pgt00009 t00009) throws Exception {
		return t00009Dao.GetUpdDef(t00009);
	}
}
