/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00352fDAO;
import com.sunway.service.IPgt00352fService;
import com.sunway.vo.Pgt00352f;
import com.sunway.vo.Pgv00352f;

/**
 * 
 * 土地相关照片
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt00352fService implements IPgt00352fService {

	private IPgt00352fDAO t00352fDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00352fService#GetDeleteCommand(com.sunway.vo.Pgt00352f)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00352f t00352f) throws Exception {
		return t00352fDao.GetDeleteCommand(t00352f);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00352fService#GetInsertCommand(com.sunway.vo.Pgt00352f)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00352f t00352f) throws Exception {
		return t00352fDao.GetInsertCommand(t00352f);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00352fService#GetUpdateCommand(com.sunway.vo.Pgt00352f)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00352f t00352f) throws Exception {
		return t00352fDao.GetUpdateCommand(t00352f);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00352fService#LoadAll(com.sunway.vo.Pgt00352f)
	 */
	@Override
	public ArrayList<Pgv00352f> LoadAll(Pgt00352f t00352f) throws Exception {
		return t00352fDao.LoadAll(t00352f);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00352fService#LoadByPrimaryKey(com.sunway.vo.Pgt00352f)
	 */
	@Override
	public Pgt00352f LoadByPrimaryKey(Pgt00352f t00352f) throws Exception {
		return t00352fDao.LoadByPrimaryKey(t00352f);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00352fService#LoadByPrimaryKey(com.sunway.vo.Pgt00352f)
	 */
	@Override
	public Pgt00352f LoadByPrimaryKeyFC(Pgt00352f t00352f) throws Exception {
		return t00352fDao.LoadByPrimaryKeyFC(t00352f);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00352fService#LoadZplxList()
	 */
	@Override
	public ArrayList<Pgv00352f> LoadZplxList() throws Exception {
		return t00352fDao.LoadZplxList();
	}
	
	@Override
	public Boolean GetDeleteByXQCommand(Pgt00352f t00352f) throws Exception {
		
		return t00352fDao.GetDeleteByXQCommand(t00352f);
	}

	@Override
	public ArrayList<Pgv00352f> LoadAllFC(Pgt00352f t00352f) throws Exception {
		return t00352fDao.LoadAllFC(t00352f);
	}

	/**
	 * @param t00352fDao the t00352fDao to set
	 */
	public void setT00352fDao(IPgt00352fDAO t00352fDao) {
		this.t00352fDao = t00352fDao;
	}

	/**
	 * @return the t00352fDao
	 */
	public IPgt00352fDAO getT00352fDao() {
		return t00352fDao;
	}
}
