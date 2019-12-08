package com.sunway.service.impl;

import java.util.ArrayList;
import com.sunway.dao.IPgt00003DAO;
import com.sunway.service.IPgt00003Service;
import com.sunway.vo.Pgt00002;
import com.sunway.vo.Pgt00003;
import com.sunway.vo.Pgt00004;
import com.sunway.vo.Pgv00003;

/**
 * @category 用户组维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00003Service implements IPgt00003Service {
	
	private IPgt00003DAO t00003Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00003Service#GetDeleteCommand(com.sunway.vo.Pgt00003)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00003 role) throws Exception {
		return t00003Dao.GetDeleteCommand(role);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00003Service#GetInsertCommand(com.sunway.vo.Pgt00003)
	 */
	@Override
	public Integer GetInsertCommand(Pgt00003 role) throws Exception {
		return t00003Dao.GetInsertCommand(role);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00003Service#GetUpdateCommand(com.sunway.vo.Pgt00003)
	 */
	@Override
	public Integer GetUpdateCommand(Pgt00003 role) throws Exception {
		return t00003Dao.GetUpdateCommand(role);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00003Service#LoadAll(com.sunway.vo.Pgv00003)
	 */
	@Override
	public ArrayList<Pgv00003> LoadAll(Pgv00003 role) throws Exception {
		return t00003Dao.LoadAll(role);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00003Service#LoadByPrimaryKey(com.sunway.vo.Pgt00003)
	 */
	@Override
	public Pgt00003 LoadByPrimaryKey(Pgt00003 role) throws Exception {
		return t00003Dao.LoadByPrimaryKey(role);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00003Service#LoadRoleByUserID(com.sunway.vo.Pgt00002)
	 */
	@Override
	public ArrayList<Pgv00003> LoadRoleByUserID(Pgt00002 user) throws Exception {
		return t00003Dao.LoadRoleByUserID(user);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00003Service#LoadRoleByRightID(com.sunway.vo.Pgt00004)
	 */
	@Override
	public ArrayList<Pgv00003> LoadRoleByRightID(Pgt00004 right)
			throws Exception {
		return t00003Dao.LoadRoleByRightID(right);
	}

	
	/**
	 * @return the t00003Dao
	 */
	public IPgt00003DAO getT00003Dao() {
		return t00003Dao;
	}

	/**
	 * @param t00003Dao the t00003Dao to set
	 */
	public void setT00003Dao(IPgt00003DAO t00003Dao) {
		this.t00003Dao = t00003Dao;
	}

}
