/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPsjgjySYDAO;
import com.sunway.vo.Pgv020314;
import com.sunway.vo.Pgv120102;
import com.sunway.vo.Pgv12010a2;

/**
 * @author Lee
 *
 */
public class PsjgjySYService implements com.sunway.service.IPsjgjySYService {

	private IPsjgjySYDAO psjgjySYDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjySYService#GetInsert120102Command(com.sunway.vo.Pgv120102)
	 */
	@Override
	public boolean GetInsert120102Command(Pgv120102 sypsjgjy) throws Exception {
		return psjgjySYDao.GetInsert120102Command(sypsjgjy);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjySYService#GetInsert12010A2Command(com.sunway.vo.Pgv12010a2)
	 */
	@Override
	public Integer GetInsert12010A2Command(Pgv12010a2 sypsjgjy)
			throws Exception {
		return psjgjySYDao.GetInsert12010A2Command(sypsjgjy);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjySYService#LoadAll020314(com.sunway.vo.Pgv020314)
	 */
	@Override
	public ArrayList<Pgv020314> LoadAll020314(Pgv020314 sypsjgjy)
			throws Exception {
		return psjgjySYDao.LoadAll020314(sypsjgjy);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjySYService#LoadAll120102(com.sunway.vo.Pgv120102)
	 */
	@Override
	public ArrayList<Pgv120102> LoadAll120102(Pgv120102 sypsjgjy)
			throws Exception {
		return psjgjySYDao.LoadAll120102(sypsjgjy);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjySYService#LoadAll12010A2(com.sunway.vo.Pgv12010a2)
	 */
	@Override
	public ArrayList<Pgv12010a2> LoadAll12010A2(Pgv12010a2 sypsjgjy)
			throws Exception {
		return psjgjySYDao.LoadAll12010A2(sypsjgjy);
	}

	/**
	 * @return the psjgjySYDao
	 */
	public IPsjgjySYDAO getPsjgjySYDao() {
		return psjgjySYDao;
	}

	/**
	 * @param psjgjySYDao the psjgjySYDao to set
	 */
	public void setPsjgjySYDao(IPsjgjySYDAO psjgjySYDao) {
		this.psjgjySYDao = psjgjySYDao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjySYService#DeleteAllCommand()
	 */
	@Override
	public boolean DeleteAllCommand() throws Exception {
		return psjgjySYDao.DeleteAllCommand();
	}

}
