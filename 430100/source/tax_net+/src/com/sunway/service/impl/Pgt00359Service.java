package com.sunway.service.impl;

import java.util.ArrayList;
import com.sunway.dao.IPgt00359DAO;
import com.sunway.service.IPgt00359Service;
import com.sunway.vo.Pgt00359;
import com.sunway.vo.Pgv00359;

/**
 * 所在区域下的参数类型配置
 * @category 所在区域下的参数类型配置
 * @author Lee
 * @version 1.0
 */
public class Pgt00359Service implements IPgt00359Service {

	private IPgt00359DAO t00359Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00359Service#GetDeleteCommand(com.sunway.vo.Pgt00359)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00359 cgxz) throws Exception {
		return t00359Dao.GetDeleteCommand(cgxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00359Service#GetInsertCommand(com.sunway.vo.Pgt00359)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00359 cgxz) throws Exception {
		return t00359Dao.GetInsertCommand(cgxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00359Service#GetUpdateCommand(com.sunway.vo.Pgt00359)
	 
	@Override
	public boolean GetUpdateCommand(Pgt00359 cgxz) throws Exception {
		return t00359Dao.GetUpdateCommand(cgxz);
	}	
	 */
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00359Service#LoadAll(com.sunway.vo.Pgv00359)
	 */
	@Override
	public ArrayList<Pgv00359> LoadAll(Pgv00359 cgxz) throws Exception {
		return t00359Dao.LoadAll(cgxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00359Service#LoadByPrimaryKey(com.sunway.vo.Pgt00359)
	 */
	@Override
	public Pgt00359 LoadByPrimaryKey(Pgt00359 cgxz) throws Exception {
		return t00359Dao.LoadByPrimaryKey(cgxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00359Service#GetUpdateCommand(com.sunway.vo.Pgt00359)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00359 bean) throws Exception {
		return t00359Dao.GetUpdateCommand(bean);
	}
	
	/**
	 * @return the t00359Dao
	 */
	public IPgt00359DAO getT00359Dao() {
		return t00359Dao;
	}

	/**
	 * @param t00359Dao the t00359Dao to set
	 */
	public void setT00359Dao(IPgt00359DAO t00359Dao) {
		this.t00359Dao = t00359Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00359Service#LoadParentIdsBySzqy(java.lang.String)
	 */
	@Override
	public String LoadParentIdsBySzqy(Pgt00359 bean) throws Exception {
		return t00359Dao.LoadParentIdsBySzqy(bean);
	}



}
