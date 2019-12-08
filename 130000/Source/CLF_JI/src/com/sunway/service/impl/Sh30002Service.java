/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.ISh30002DAO;
import com.sunway.service.ISh30002Service;
import com.sunway.vo.Pgv00302;

/**
 * 
 * 通過审核操作[市場法]
 * @author Andy.Gao
 * @category 數據審核[市場法]
 *
 */
public class Sh30002Service implements ISh30002Service {

	private ISh30002DAO sh30002Dao;
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.ISh30002Service#GetExecShAgain(com.sunway.vo.Pgv00302)
	 */
	@Override
	public Boolean GetExecShAgain(Pgv00302 bean) throws Exception {
		return sh30002Dao.GetExecShAgain(bean);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.ISh30002Service#GetExecShAgainAll(com.sunway.vo.Pgv00302)
	 */
	@Override
	public Boolean GetExecShAgainAll(Pgv00302 bean) throws Exception {
		return sh30002Dao.GetExecShAgainAll(bean);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.ISh30002Service#LoadShOK(com.sunway.vo.Pgv00302)
	 */
	@Override
	public ArrayList<Pgv00302> LoadShOK(Pgv00302 bean) throws Exception {
		return sh30002Dao.LoadShOK(bean);
	}

	/**
	 * @param sh30002Dao the sh30002Dao to set
	 */
	public void setSh30002Dao(ISh30002DAO sh30002Dao) {
		this.sh30002Dao = sh30002Dao;
	}

	/**
	 * @return the sh30002Dao
	 */
	public ISh30002DAO getSh30002Dao() {
		return sh30002Dao;
	}

}
