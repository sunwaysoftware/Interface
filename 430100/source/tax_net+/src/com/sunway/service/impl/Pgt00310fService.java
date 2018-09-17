

/**
 * @author sunxdd
 *
 */

package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00310fDAO;
import com.sunway.service.IPgt00310fService;
import com.sunway.vo.Pgv00310f;

public class Pgt00310fService implements IPgt00310fService {

	private IPgt00310fDAO t00310fDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310fService#GetDeleteCommand(com.sunway.vo.Pgv00310f)
	 */
	@Override
	public boolean GetDeleteCommand(Pgv00310f b) throws Exception {
		return getT00310fDao().GetDeleteCommand(b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310fService#GetInsertCommand(com.sunway.vo.Pgv00310f)
	 */
	@Override
	public boolean GetInsertCommand(Pgv00310f b) throws Exception {
		return getT00310fDao().GetInsertCommand(b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310fService#GetUpdateCommand(com.sunway.vo.Pgv00310f)
	 */
	@Override
	public boolean GetUpdateCommand(Pgv00310f b) throws Exception {
		return getT00310fDao().GetUpdateCommand(b);
	}	

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310fService#LoadAll(com.sunway.vo.Pgv00310f)
	 */
	@Override
	public ArrayList<Pgv00310f> LoadAll(Pgv00310f b) throws Exception {
		return getT00310fDao().LoadAll(b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310fService#LoadAll(com.sunway.vo.Pgv00310f)
	 */
	@Override
	public ArrayList<Pgv00310f> LoadAllB(Pgv00310f b) throws Exception {
		return getT00310fDao().LoadAllB(b);
	}	

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310fService#LoadByPrimaryKey(com.sunway.vo.Pgv00310f)
	 */
	@Override
	public Pgv00310f LoadByPrimaryKey(Pgv00310f b) throws Exception {
		return getT00310fDao().LoadByPrimaryKey(b);
	}

	/**
	 * @return the t00310fDao
	 */
	public IPgt00310fDAO getT00310fDao() {
		return t00310fDao;
	}

	/**
	 * @param t00310fDao the t00310fDao to set
	 */
	public void setT00310fDao(IPgt00310fDAO t00310fDao) {
		this.t00310fDao = t00310fDao;
	}
	

	
}
