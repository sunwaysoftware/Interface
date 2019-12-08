/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPg20001gDAO;
import com.sunway.service.IPg20001gService;
import com.sunway.vo.Pgv02031;

/**
 * 
 * 收益法讀取个案评税數據列表
 * @author Andy.Gao
 *
 */
public class Pg20001gService implements IPg20001gService {

	private IPg20001gDAO g20001gDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPg20001gService#LoadPgMx(com.sunway.vo.Pgv02031)
	 */
	@Override
	public ArrayList<Pgv02031> LoadPgMx(Pgv02031 bean) throws Exception {
		return g20001gDao.LoadPgMx(bean);
	}

	/**
	 * @param g20001gDao the g20001gDao to set
	 */
	public void setG20001gDao(IPg20001gDAO g20001gDao) {
		this.g20001gDao = g20001gDao;
	}

	/**
	 * @return the g20001gDao
	 */
	public IPg20001gDAO getG20001gDao() {
		return g20001gDao;
	}
}
