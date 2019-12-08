/**
 * 
 */
package com.sunway.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt00002DAO;
import com.sunway.service.IPgt00002Service;
import com.sunway.vo.Pgt00002;
import com.sunway.vo.Pgt00003;
import com.sunway.vo.Pgt00004;
import com.sunway.vo.Pgv00002;

/**
 * @category 用户表维护
 * @author Lee
 * @version 1.0
 */
public class Pgt00002Service implements IPgt00002Service {

	private IPgt00002DAO t00002Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00002Service#GetDeleteCommand(com.sunway.vo.Pgt00002)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00002 user) throws Exception {
		return t00002Dao.GetDeleteCommand(user);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00002Service#GetInsertCommand(com.sunway.vo.Pgt00002)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00002 user) throws Exception {
		return t00002Dao.GetInsertCommand(user);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00002Service#GetUpdateCommand(com.sunway.vo.Pgt00002)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00002 user) throws Exception {
		return t00002Dao.GetUpdateCommand(user);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00002Service#LoadAll(com.sunway.vo.Pgv00002)
	 */
	@Override
	public ArrayList<Pgv00002> LoadAll(Pgv00002 user) throws Exception {
		return t00002Dao.LoadAll(user);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00002Service#LoadByPrimaryKey(com.sunway.vo.Pgt00002)
	 */
	@Override
	public Pgt00002 LoadByPrimaryKey(Pgt00002 user) throws Exception {
		return t00002Dao.LoadByPrimaryKey(user);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00002Service#getUsersByRole(com.sunway.vo.Pgt00003)
	 */
	@Override
	public ArrayList<Pgv00002> LoadUsersByRole(Pgt00003 role) throws Exception {
		return t00002Dao.LoadUsersByRole(role);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00002Service#LoadUsersByRight(com.sunway.vo.Pgt00004)
	 */
	@Override
	public ArrayList<Pgv00002> LoadUsersByRight(Pgt00004 right)
			throws Exception {
		return t00002Dao.LoadUsersByRight(right);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00002Service#CheckLogin(com.sunway.vo.Pgt00002)
	 */
	@Override
	public Pgt00002 CheckLogin(Pgt00002 user) throws Exception {
		return t00002Dao.CheckLogin(user);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00002Service#LoadRightByUser(com.sunway.vo.Pgt00002)
	 */
	@Override
	public ArrayList<String> LoadRightByUser(Pgt00002 user) throws Exception {
		return t00002Dao.LoadRightByUser(user);
	}
	

	/**
	 * @return the t00002Dao
	 */
	public IPgt00002DAO getT00002Dao() {
		return t00002Dao;
	}

	/**
	 * @param t00002Dao the t00002Dao to set
	 */
	public void setT00002Dao(IPgt00002DAO t00002Dao) {
		this.t00002Dao = t00002Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00002Service#ChangePWD(com.sunway.vo.Pgt00002)
	 */
	@Override
	public String ChangePWD(Pgt00002 user) throws Exception {
		return t00002Dao.ChangePWD(user);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00002Service#InitPWD(com.sunway.vo.Pgt00002)
	 */
	@Override
	public boolean InitPWD(Pgt00002 user) throws Exception {
		return t00002Dao.InitPWD(user);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00002Service#SettingPersonal(com.sunway.vo.Pgt00002)
	 */
	@Override
	public boolean SettingPersonal(Pgt00002 user) throws Exception {
		return t00002Dao.SettingPersonal(user);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00002Service#ExportAll(com.sunway.vo.Pgv00002)
	 */
	@Override
	public ByteArrayOutputStream ExportAll(Pgv00002 user) throws Exception {
		return (ByteArrayOutputStream)  t00002Dao.ExportAll(user);
	}

}
