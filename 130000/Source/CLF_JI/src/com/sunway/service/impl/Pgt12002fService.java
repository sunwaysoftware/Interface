/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12002fDAO;
import com.sunway.service.IPgt12002fService;
import com.sunway.vo.Pgt12002f;
import com.sunway.vo.Pgv12002f;

/**
 * 
 * 土地相关照片
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt12002fService implements IPgt12002fService {

	private IPgt12002fDAO t12002fDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002fService#GetDeleteCommand(com.sunway.vo.Pgt12002f)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt12002f t12002f) throws Exception {
		return t12002fDao.GetDeleteCommand(t12002f);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002fService#GetInsertCommand(com.sunway.vo.Pgt12002f)
	 */
	@Override
	public boolean GetInsertCommand(Pgt12002f t12002f) throws Exception {
		return t12002fDao.GetInsertCommand(t12002f);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002fService#GetUpdateCommand(com.sunway.vo.Pgt12002f)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt12002f t12002f) throws Exception {
		return t12002fDao.GetUpdateCommand(t12002f);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002fService#LoadAll(com.sunway.vo.Pgt12002f)
	 */
	@Override
	public ArrayList<Pgv12002f> LoadAll(Pgt12002f t12002f) throws Exception {
		return t12002fDao.LoadAll(t12002f);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002fService#LoadByPrimaryKey(com.sunway.vo.Pgt12002f)
	 */
	@Override
	public Pgt12002f LoadByPrimaryKey(Pgt12002f t12002f) throws Exception {
		return t12002fDao.LoadByPrimaryKey(t12002f);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12002fService#LoadZplxList()
	 */
	@Override
	public ArrayList<Pgv12002f> LoadZplxList() throws Exception {
		return t12002fDao.LoadZplxList();
	}
	
	/**
	 * @param t12002fDao the t12002fDao to set
	 */
	public void setT12002fDao(IPgt12002fDAO t12002fDao) {
		this.t12002fDao = t12002fDao;
	}

	/**
	 * @return the t12002fDao
	 */
	public IPgt12002fDAO getT12002fDao() {
		return t12002fDao;
	}
}
