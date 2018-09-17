/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPg30001gDAO;
import com.sunway.service.IPg30001gService;
import com.sunway.vo.Pgv00331;

/**
 * 
 * 市場法讀取个案评税數據列表
 * @author Andy.Gao
 *
 */
public class Pg30001gService implements IPg30001gService {

	private IPg30001gDAO g30001gDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPg30001gService#LoadPgMx(com.sunway.vo.Pgv00331)
	 */
	@Override
	public ArrayList<Pgv00331> LoadPgMx(Pgv00331 bean) throws Exception {
		return g30001gDao.LoadPgMx(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPg30001gService#GetPgCommand(com.sunway.vo.Pgv00331)
	 */
	@Override
	public Boolean GetPgCommand(Pgv00331 bean) throws Exception {
		return g30001gDao.GetPgCommand(bean);
	}
	
	/**
	 * @param g30001gDao the g30001gDao to set
	 */
	public void setG30001gDao(IPg30001gDAO g30001gDao) {
		this.g30001gDao = g30001gDao;
	}

	/**
	 * @return the g30001gDao
	 */
	public IPg30001gDAO getG30001gDao() {
		return g30001gDao;
	}
}
