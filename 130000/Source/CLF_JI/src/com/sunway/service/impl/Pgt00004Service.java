package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00004DAO;
import com.sunway.service.IPgt00004Service;
import com.sunway.vo.Pgt00002;
import com.sunway.vo.Pgt00003;
import com.sunway.vo.Pgt00004;
import com.sunway.vo.Pgv00004;

/**
 * @category 功能权限维护
 * @author Lee
 * @version 1.0
 */
public class Pgt00004Service implements IPgt00004Service {

	private IPgt00004DAO t00004Dao;
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00004Service#GetDeleteCommand(com.sunway.vo.Pgt00004)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00004 right) throws Exception {
		return t00004Dao.GetDeleteCommand(right);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00004Service#GetInsertCommand(com.sunway.vo.Pgt00004)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00004 right) throws Exception {
		return t00004Dao.GetInsertCommand(right);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00004Service#GetUpdateCommand(com.sunway.vo.Pgt00004)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00004 right) throws Exception {
		return t00004Dao.GetUpdateCommand(right);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00004Service#LoadAll(com.sunway.vo.Pgv00004)
	 */
	@Override
	public ArrayList<Pgv00004> LoadAll(Pgv00004 right) throws Exception {
		return t00004Dao.LoadAll(right);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00004Service#LoadByPrimaryKey(com.sunway.vo.Pgt00004)
	 */
	@Override
	public Pgt00004 LoadByPrimaryKey(Pgt00004 right) throws Exception {
		return t00004Dao.LoadByPrimaryKey(right);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00004Service#LoadRightByUserID(com.sunway.vo.Pgt00002)
	 */
	@Override
	public ArrayList<Pgv00004> LoadRightByUserID(Pgt00002 user)
			throws Exception {
		return t00004Dao.LoadRightByUserID(user);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00004Service#LoadRightByRoleID(com.sunway.vo.Pgt00003)
	 */
	@Override
	public ArrayList<Pgv00004> LoadRightByRoleID(Pgt00003 role)
			throws Exception {
		return t00004Dao.LoadRightByRoleID(role);
	}
	
	/**
	 * @return the t00004Dao
	 */
	public IPgt00004DAO getT00004Dao() {
		return t00004Dao;
	}

	/**
	 * @param t00004Dao the t00004Dao to set
	 */
	public void setT00004Dao(IPgt00004DAO t00004Dao) {
		this.t00004Dao = t00004Dao;
	}

}
