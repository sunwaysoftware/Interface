package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12085DAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPgt12085Service;
import com.sunway.vo.Pgt12085;
import com.sunway.vo.Pgv12085;

/**
 * 各地区审核类型设置表
 * @category 各地区审核类型
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt12085Service extends BaseDAO implements IPgt12085Service {

	private IPgt12085DAO t12085Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12085Service#GetDeleteCommand(com.sunway.vo.Pgt12085)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt12085 shlx) throws Exception {
		return t12085Dao.GetDeleteCommand(shlx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12085Service#GetInsertCommand(com.sunway.vo.Pgt12085)
	 */
	@Override
	public boolean GetInsertCommand(Pgt12085 shlx) throws Exception {
		return t12085Dao.GetInsertCommand(shlx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12085Service#GetUpdateCommand(com.sunway.vo.Pgt12085)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt12085 shlx) throws Exception {
		return t12085Dao.GetUpdateCommand(shlx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12085Service#LoadAll(com.sunway.vo.Pgt12085)
	 */
	@Override
	public ArrayList<Pgv12085> LoadAll(Pgv12085 shlx) throws Exception {
		return t12085Dao.LoadAll(shlx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12085Service#LoadByPrimaryKey(com.sunway.vo.Pgt12085)
	 */
	@Override
	public Pgt12085 LoadByPrimaryKey(Pgt12085 shlx) throws Exception {
		return t12085Dao.LoadByPrimaryKey(shlx);
	}

	/**
	 * @return the t12085Dao
	 */
	public IPgt12085DAO getT12085Dao() {
		return t12085Dao;
	}

	/**
	 * @param t12085Dao the t12085Dao to set
	 */
	public void setT12085Dao(IPgt12085DAO t12085Dao) {
		this.t12085Dao = t12085Dao;
	}

}
