/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12004fDAO;
import com.sunway.service.IPgt12004fService;
import com.sunway.vo.Pgt12004f;
import com.sunway.vo.Pgv12004f;

/**
 * 
 * 明細相关照片
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt12004fService implements IPgt12004fService {

	private IPgt12004fDAO t12004fDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004fService#GetDeleteCommand(com.sunway.vo.Pgt12004f)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt12004f t12004f) throws Exception {
		return t12004fDao.GetDeleteCommand(t12004f);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004fService#GetInsertCommand(com.sunway.vo.Pgt12004f)
	 */
	@Override
	public boolean GetInsertCommand(Pgt12004f t12004f) throws Exception {
		return t12004fDao.GetInsertCommand(t12004f);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004fService#GetUpdateCommand(com.sunway.vo.Pgt12004f)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt12004f t12004f) throws Exception {
		return t12004fDao.GetUpdateCommand(t12004f);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004fService#LoadAll(com.sunway.vo.Pgt12004f)
	 */
	@Override
	public ArrayList<Pgv12004f> LoadAll(Pgt12004f t12004f) throws Exception {
		return t12004fDao.LoadAll(t12004f);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004fService#LoadByPrimaryKey(com.sunway.vo.Pgt12004f)
	 */
	@Override
	public Pgt12004f LoadByPrimaryKey(Pgt12004f t12004f) throws Exception {
		return t12004fDao.LoadByPrimaryKey(t12004f);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12004fService#LoadZplxList()
	 */
	@Override
	public ArrayList<Pgv12004f> LoadZplxList() throws Exception {
		return t12004fDao.LoadZplxList();
	}

	/**
	 * @param t12004fDao the t12004fDao to set
	 */
	public void setT12004fDao(IPgt12004fDAO t12004fDao) {
		this.t12004fDao = t12004fDao;
	}

	/**
	 * @return the t12004fDao
	 */
	public IPgt12004fDAO getT12004fDao() {
		return t12004fDao;
	}

}
