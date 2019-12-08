/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12003fDAO;
import com.sunway.service.IPgt12003fService;
import com.sunway.vo.Pgt12003f;
import com.sunway.vo.Pgv12003f;

/**
 * 
 * 房产相关照片
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt12003fService implements IPgt12003fService {

	private IPgt12003fDAO t12003fDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12003fService#GetDeleteCommand(com.sunway.vo.Pgt12003f)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt12003f t12003f) throws Exception {
		return t12003fDao.GetDeleteCommand(t12003f);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12003fService#GetInsertCommand(com.sunway.vo.Pgt12003f)
	 */
	@Override
	public boolean GetInsertCommand(Pgt12003f t12003f) throws Exception {
		return t12003fDao.GetInsertCommand(t12003f);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12003fService#GetUpdateCommand(com.sunway.vo.Pgt12003f)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt12003f t12003f) throws Exception {
		return t12003fDao.GetUpdateCommand(t12003f);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12003fService#LoadAll(com.sunway.vo.Pgt12003f)
	 */
	@Override
	public ArrayList<Pgv12003f> LoadAll(Pgt12003f t12003f) throws Exception {
		return t12003fDao.LoadAll(t12003f);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12003fService#LoadByPrimaryKey(com.sunway.vo.Pgt12003f)
	 */
	@Override
	public Pgt12003f LoadByPrimaryKey(Pgt12003f t12003f) throws Exception {
		return t12003fDao.LoadByPrimaryKey(t12003f);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12003fService#LoadZplxList()
	 */
	@Override
	public ArrayList<Pgv12003f> LoadZplxList() throws Exception {
		return t12003fDao.LoadZplxList();
	}

	/**
	 * @param t12003fDao the t12003fDao to set
	 */
	public void setT12003fDao(IPgt12003fDAO t12003fDao) {
		this.t12003fDao = t12003fDao;
	}

	/**
	 * @return the t12003fDao
	 */
	public IPgt12003fDAO getT12003fDao() {
		return t12003fDao;
	}

}
