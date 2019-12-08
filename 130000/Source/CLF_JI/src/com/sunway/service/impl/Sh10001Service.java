/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.ISh10001DAO;
import com.sunway.service.ISh10001Service;
import com.sunway.vo.Pgv12001;
import com.sunway.vo.Pgv12004;

/**
 * 
 * 审核操作[成本法]
 * @author Andy.Gao
 *
 */
public class Sh10001Service implements ISh10001Service {

	private ISh10001DAO sh10001Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.ISh10001Service#LoadSh(com.sunway.vo.Pgv12001)
	 */
	@Override
	public ArrayList<Pgv12001> LoadSh(Pgv12001 bean) throws Exception {
		return sh10001Dao.LoadSh(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISh10001Service#LoadShMxNgList(com.sunway.vo.Pgv12004)
	 */
	@Override
	public ArrayList<Pgv12004> LoadShMxNgList(Pgv12004 bean) throws Exception {
		return sh10001Dao.LoadShMxNgList(bean);
	}
	
	/**
	 * @param sh10001Dao the sh10001Dao to set
	 */
	public void setSh10001Dao(ISh10001DAO sh10001Dao) {
		this.sh10001Dao = sh10001Dao;
	}

	/**
	 * @return the sh10001Dao
	 */
	public ISh10001DAO getSh10001Dao() {
		return sh10001Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISh10001Service#GetExecSH(com.sunway.vo.Pgv12001)
	 */
	@Override
	public Boolean GetExecSH(Pgv12001 bean) throws Exception {
		return sh10001Dao.GetExecSH(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISh10001Service#LoadShSwidList(com.sunway.vo.Pgv12004)
	 */
	@Override
	public ArrayList<Pgv12001> LoadShSwidList(Pgv12001 bean) throws Exception {
		return sh10001Dao.LoadShSwidList(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISh10001Service#GetExecForceSH(com.sunway.vo.Pgv12001)
	 */
	@Override
	public Boolean GetExecForceSH(Pgv12001 bean) throws Exception {
		return sh10001Dao.GetExecForceSH(bean);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.ISh10001Service#LoadSh1200112(com.sunway.vo.Pgv12001)
	 */
	@Override
	public ArrayList<Pgv12001> LoadSh1200112(Pgv12001 bean) throws Exception {
		return sh10001Dao.LoadSh1200112(bean);
	}
}
