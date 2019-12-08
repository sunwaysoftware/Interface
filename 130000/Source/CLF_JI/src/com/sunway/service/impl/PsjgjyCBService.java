/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPsjgjyCBDAO;
import com.sunway.service.IPsjgjyCBService;
import com.sunway.vo.Pgv100314;
import com.sunway.vo.Pgv120101;
import com.sunway.vo.Pgv12010a1;

/**
 * @author Lee
 *
 */
public class PsjgjyCBService implements IPsjgjyCBService {

	private IPsjgjyCBDAO psjgjyCBDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjyCBService#GetInsert120101Command(com.sunway.vo.Pgv120101)
	 */
	@Override
	public boolean GetInsert120101Command(Pgv120101 cbpsjgjy) throws Exception {
		return psjgjyCBDao.GetInsert120101Command(cbpsjgjy);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjyCBService#GetInsert12010A1Command(com.sunway.vo.Pgv12010a1)
	 */
	@Override
	public Integer GetInsert12010A1Command(Pgv12010a1 cbpsjgjy)
			throws Exception {
		return psjgjyCBDao.GetInsert12010A1Command(cbpsjgjy);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjyCBService#LoadAll100314(com.sunway.vo.Pgv100314)
	 */
	@Override
	public ArrayList<Pgv100314> LoadAll100314(Pgv100314 cbpsjgjy)
			throws Exception {
		return psjgjyCBDao.LoadAll100314(cbpsjgjy);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjyCBService#LoadAll120101(com.sunway.vo.Pgv120101)
	 */
	@Override
	public ArrayList<Pgv120101> LoadAll120101(Pgv120101 cbpsjgjy)
			throws Exception {
		return psjgjyCBDao.LoadAll120101(cbpsjgjy);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjyCBService#LoadAll12010A1(com.sunway.vo.Pgv12010a1)
	 */
	@Override
	public ArrayList<Pgv12010a1> LoadAll12010A1(Pgv12010a1 cbpsjgjy)
			throws Exception {
		return psjgjyCBDao.LoadAll12010A1(cbpsjgjy);
	}

	
	/**
	 * @return the psjgjyCBDao
	 */
	public IPsjgjyCBDAO getPsjgjyCBDao() {
		return psjgjyCBDao;
	}

	/**
	 * @param psjgjyCBDao the psjgjyCBDao to set
	 */
	public void setPsjgjyCBDao(IPsjgjyCBDAO psjgjyCBDao) {
		this.psjgjyCBDao = psjgjyCBDao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjyCBService#GetDeleteCommand(java.lang.String)
	 */
	@Override
	public boolean GetDeleteCommand(String cjid) throws Exception {
		return psjgjyCBDao.GetDeleteCommand(cjid);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjyCBService#DeleteAllCommand()
	 */
	@Override
	public boolean DeleteAllCommand() throws Exception {
		return psjgjyCBDao.DeleteAllCommand();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjyCBService#LoadByPrimaryKey(java.lang.String)
	 */
	@Override
	public Pgv12010a1 LoadByPrimaryKey(String cjid) throws Exception {
		return psjgjyCBDao.LoadByPrimaryKey(cjid);
	}

}
