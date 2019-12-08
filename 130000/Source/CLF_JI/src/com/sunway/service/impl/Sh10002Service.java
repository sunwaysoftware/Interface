/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.ISh10002DAO;
import com.sunway.service.ISh10002Service;
import com.sunway.vo.Pgv12001;

/**
 * 
 * 通過审核操作[成本法]
 * @author Andy.Gao
 * @category 數據審核[成本法]
 *
 */
public class Sh10002Service implements ISh10002Service {

	private ISh10002DAO Sh10002Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.ISh10002Service#GetExecShAgain(com.sunway.vo.Pgv12001)
	 */
	@Override
	public Boolean GetExecShAgain(Pgv12001 bean) throws Exception {
		return Sh10002Dao.GetExecShAgain(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISh10002Service#GetExecShAgainAll(com.sunway.vo.Pgv12001)
	 */
	@Override
	public Boolean GetExecShAgainAll(Pgv12001 bean) throws Exception {
		return Sh10002Dao.GetExecShAgainAll(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISh10002Service#LoadShOK(com.sunway.vo.Pgv12001)
	 */
	@Override
	public ArrayList<Pgv12001> LoadShOK(Pgv12001 bean) throws Exception {
		return Sh10002Dao.LoadShOK(bean);
	}

	/**
	 * @param sh10002Dao the sh10002Dao to set
	 */
	public void setSh10002Dao(ISh10002DAO sh10002Dao) {
		Sh10002Dao = sh10002Dao;
	}

	/**
	 * @return the sh10002Dao
	 */
	public ISh10002DAO getSh10002Dao() {
		return Sh10002Dao;
	}

}
