package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00364DAO;
import com.sunway.service.IPgt00364Service;
import com.sunway.vo.Pgt00364;

public class Pgt00364Service implements IPgt00364Service {
	private IPgt00364DAO t00364Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00364Service#GetDeleteCommand(com.sunway.vo.Pgt00364)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00364 bean) throws Exception {
		// TODO Auto-generated method stub
		return t00364Dao.GetDeleteCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00364Service#GetInsertCommand(com.sunway.vo.Pgt00364)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00364 bean) throws Exception {
		// TODO Auto-generated method stub
		return t00364Dao.GetInsertCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00364Service#GetUpdateCommand(com.sunway.vo.Pgt00364)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00364 bean) throws Exception {
		// TODO Auto-generated method stub
		return t00364Dao.GetUpdateCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00364Service#LoadAll(com.sunway.vo.Pgt00364)
	 */
	@Override
	public ArrayList<Pgt00364> LoadAll(Pgt00364 bean) throws Exception {
		// TODO Auto-generated method stub
		return t00364Dao.LoadAll(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00364Service#LoadByPrimaryKey(com.sunway.vo.Pgt00364)
	 */
	@Override
	public Pgt00364 LoadByPrimaryKey(Pgt00364 bean) throws Exception {
		// TODO Auto-generated method stub
		return t00364Dao.LoadByPrimaryKey(bean);
	}
	/**
	 * @return the t00364Dao
	 */
	public IPgt00364DAO getT00364Dao() {
		return t00364Dao;
	}

	/**
	 * @param t00364Dao the t00364Dao to set
	 */
	public void setT00364Dao(IPgt00364DAO t00364Dao) {
		this.t00364Dao = t00364Dao;
	}
	
	
	
	
	
	
	

	public boolean GetDeleteCommandA(Pgt00364 bean) throws Exception {
	
		return t00364Dao.GetDeleteCommandA(bean);
	}


	public boolean GetInsertCommandA(Pgt00364 bean) throws Exception {
		
		return t00364Dao.GetInsertCommandA(bean);
	}


	public boolean GetUpdateCommandA(Pgt00364 bean) throws Exception {
		
		return t00364Dao.GetUpdateCommandA(bean);
	}

	
	public ArrayList<Pgt00364> LoadAllA(Pgt00364 bean) throws Exception {
		
		return t00364Dao.LoadAllA(bean);
	}


	public Pgt00364 LoadByPrimaryKeyA(Pgt00364 bean) throws Exception {
		
		return t00364Dao.LoadByPrimaryKeyA(bean);
	}
	
	
}
