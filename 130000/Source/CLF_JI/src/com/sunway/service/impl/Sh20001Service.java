/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.ISh20001DAO;
import com.sunway.service.ISh20001Service;
import com.sunway.vo.Pgv12001;
import com.sunway.vo.Pgv12004;

/**
 * 
 * 未审核操作[收益法]
 * @author Andy.Gao
 *
 */
public class Sh20001Service implements ISh20001Service {

	private ISh20001DAO sh20001Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.ISh20001Service#GetExecForceSH(com.sunway.vo.Pgv12001)
	 */
	@Override
	public Boolean GetExecForceSH(Pgv12001 bean) throws Exception {
		return sh20001Dao.GetExecForceSH(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISh20001Service#GetExecSH(com.sunway.vo.Pgv12001)
	 */
	@Override
	public Boolean GetExecSH(Pgv12001 bean) throws Exception {
		return sh20001Dao.GetExecSH(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISh20001Service#LoadSh(com.sunway.vo.Pgv12001)
	 */
	@Override
	public ArrayList<Pgv12001> LoadSh(Pgv12001 bean) throws Exception {
		return sh20001Dao.LoadSh(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISh20001Service#LoadShMxNgList(com.sunway.vo.Pgv12004)
	 */
	@Override
	public ArrayList<Pgv12004> LoadShMxNgList(Pgv12004 bean) throws Exception {
		return sh20001Dao.LoadShMxNgList(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISh20001Service#LoadShSwidList(com.sunway.vo.Pgv12001)
	 */
	@Override
	public ArrayList<Pgv12001> LoadShSwidList(Pgv12001 bean) throws Exception {
		return sh20001Dao.LoadShSwidList(bean);
	}

	/**
	 * @param sh20001Dao the sh20001Dao to set
	 */
	public void setSh20001Dao(ISh20001DAO sh20001Dao) {
		this.sh20001Dao = sh20001Dao;
	}

	/**
	 * @return the sh20001Dao
	 */
	public ISh20001DAO getSh20001Dao() {
		return sh20001Dao;
	}

}
