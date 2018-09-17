

/**
 * @author sunxdd
 *
 */

package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt02010fDAO;
import com.sunway.service.IPgt02010fService;
import com.sunway.vo.Pgv02010f;

public class Pgt02010fService implements IPgt02010fService {

	private IPgt02010fDAO t02010fDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010fService#GetDeleteCommand(com.sunway.vo.Pgv02010f)
	 */
	@Override
	public boolean GetDeleteCommand(Pgv02010f b) throws Exception {
		return getT02010fDao().GetDeleteCommand(b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010fService#GetInsertCommand(com.sunway.vo.Pgv02010f)
	 */
	@Override
	public boolean GetInsertCommand(Pgv02010f b) throws Exception {
		return getT02010fDao().GetInsertCommand(b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010fService#GetUpdateCommand(com.sunway.vo.Pgv02010f)
	 */
	@Override
	public boolean GetUpdateCommand(Pgv02010f b) throws Exception {
		return getT02010fDao().GetUpdateCommand(b);
	}	

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010fService#LoadAll(com.sunway.vo.Pgv02010f)
	 */
	@Override
	public ArrayList<Pgv02010f> LoadAll(Pgv02010f b) throws Exception {
		return getT02010fDao().LoadAll(b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010fService#LoadAll(com.sunway.vo.Pgv02010f)
	 */
	@Override
	public ArrayList<Pgv02010f> LoadAllB(Pgv02010f b) throws Exception {
		return getT02010fDao().LoadAllB(b);
	}	

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010fService#LoadByPrimaryKey(com.sunway.vo.Pgv02010f)
	 */
	@Override
	public Pgv02010f LoadByPrimaryKey(Pgv02010f b) throws Exception {
		return getT02010fDao().LoadByPrimaryKey(b);
	}

	/**
	 * @return the t02010fDao
	 */
	public IPgt02010fDAO getT02010fDao() {
		return t02010fDao;
	}

	/**
	 * @param t02010fDao the t02010fDao to set
	 */
	public void setT02010fDao(IPgt02010fDAO t02010fDao) {
		this.t02010fDao = t02010fDao;
	}
	

	
}
