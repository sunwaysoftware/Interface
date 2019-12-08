/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.ISh20002DAO;
import com.sunway.service.ISh20002Service;
import com.sunway.vo.Pgv12001;

/**
 * 
 * 通過审核操作[收益法]
 * @author Andy.Gao
 * @category 數據審核[收益法]
 *
 */
public class Sh20002Service implements ISh20002Service {

	private ISh20002DAO sh20002Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.ISh20002Service#GetExecShAgain(com.sunway.vo.Pgv12001)
	 */
	@Override
	public Boolean GetExecShAgain(Pgv12001 bean) throws Exception {
		return sh20002Dao.GetExecShAgain(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISh20002Service#GetExecShAgainAll(com.sunway.vo.Pgv12001)
	 */
	@Override
	public Boolean GetExecShAgainAll(Pgv12001 bean) throws Exception {
		return sh20002Dao.GetExecShAgainAll(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISh20002Service#LoadShOK(com.sunway.vo.Pgv12001)
	 */
	@Override
	public ArrayList<Pgv12001> LoadShOK(Pgv12001 bean) throws Exception {
		return sh20002Dao.LoadShOK(bean);
	}

	/**
	 * @param sh20002Dao the sh20002Dao to set
	 */
	public void setSh20002Dao(ISh20002DAO sh20002Dao) {
		this.sh20002Dao = sh20002Dao;
	}

	/**
	 * @return the sh20002Dao
	 */
	public ISh20002DAO getSh20002Dao() {
		return sh20002Dao;
	}

}
