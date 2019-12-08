/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPsjgjySCDAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPsjgjySCService;
import com.sunway.vo.Pgv00310;
import com.sunway.vo.Pgv00310A;
import com.sunway.vo.Pgv003314;

/**
 * @author one
 *
 */
public class PsjgjySCService extends BaseDAO implements IPsjgjySCService {

	private IPsjgjySCDAO psjgjySCDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjySCService#GetInsert003101Command(com.sunway.vo.Pgv00310)
	 */
	@Override
	public boolean GetInsert003101Command(Pgv00310 scpsjgjy) throws Exception {
		return psjgjySCDao.GetInsert003101Command(scpsjgjy);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjySCService#GetInsert00310A1Command(com.sunway.vo.Pgv00310A)
	 */
	@Override
	public Integer GetInsert00310A1Command(Pgv00310A scpsjgjy) throws Exception {
		return psjgjySCDao.GetInsert00310A1Command(scpsjgjy);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjySCService#LoadAll00310(com.sunway.vo.Pgv00310)
	 */
	@Override
	public ArrayList<Pgv00310> LoadAll00310(Pgv00310 scpsjgjy) throws Exception {
		return psjgjySCDao.LoadAll00310(scpsjgjy);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjySCService#LoadAll00310A(com.sunway.vo.Pgv00310A)
	 */
	@Override
	public ArrayList<Pgv00310A> LoadAll00310A(Pgv00310A scpsjgjy)
			throws Exception {
		return psjgjySCDao.LoadAll00310A(scpsjgjy);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjySCService#LoadAll003314(com.sunway.vo.Pgv003314)
	 */
	@Override
	public ArrayList<Pgv003314> LoadAll003314(Pgv003314 scpsjgjy)
			throws Exception {
		return psjgjySCDao.LoadAll003314(scpsjgjy);
	}

	/**
	 * @return the psjgjySCDao
	 */
	public IPsjgjySCDAO getPsjgjySCDao() {
		return psjgjySCDao;
	}

	/**
	 * @param psjgjySCDao the psjgjySCDao to set
	 */
	public void setPsjgjySCDao(IPsjgjySCDAO psjgjySCDao) {
		this.psjgjySCDao = psjgjySCDao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjySCService#GetDeleteCommand(java.lang.String)
	 */
	@Override
	public boolean GetDeleteCommand(String cjid) throws Exception {
		return psjgjySCDao.GetDeleteCommand(cjid);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjySCService#DeleteAllCommand()
	 */
	@Override
	public boolean DeleteAllCommand() throws Exception {
		return psjgjySCDao.DeleteAllCommand();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPsjgjySCService#LoadByPrimaryKey(java.lang.String)
	 */
	@Override
	public Pgv00310A LoadByPrimaryKey(String cjid) throws Exception {
		return psjgjySCDao.LoadByPrimaryKey(cjid);
	}

}
