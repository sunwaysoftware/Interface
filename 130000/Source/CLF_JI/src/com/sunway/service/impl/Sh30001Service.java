/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.ISh30001DAO;
import com.sunway.service.ISh30001Service;
import com.sunway.vo.Pgv00301;
import com.sunway.vo.Pgv00302;

/**
 * 
 * 未审核操作[市場法]
 * @author Andy.Gao
 *
 */
public class Sh30001Service implements ISh30001Service {

	private ISh30001DAO sh30001Dao;
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.ISh30001Service#GetExecSH(com.sunway.vo.Pgv00302)
	 */
	@Override
	public Boolean GetExecSH(Pgv00302 bean) throws Exception {
		return sh30001Dao.GetExecSH(bean);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.ISh30001Service#LoadSh(com.sunway.vo.Pgv00302)
	 */
	@Override
	public ArrayList<Pgv00302> LoadSh(Pgv00302 bean) throws Exception {
		return sh30001Dao.LoadSh(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISh30001Service#LoadShMxNgList(com.sunway.vo.Pgv00302)
	 */
	@Override
	public ArrayList<Pgv00302> LoadShMxNgList(Pgv00302 bean) throws Exception {
		return sh30001Dao.LoadShMxNgList(bean);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.ISh30001Service#LoadShList(com.sunway.vo.Pgv00302)
	 */
	@Override
	public ArrayList<Pgv00302> LoadShList(Pgv00302 bean) throws Exception {
		return sh30001Dao.LoadShList(bean);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.ISh30001Service#LoadSh0030112(com.sunway.vo.Pgv00301)
	 */
	@Override
	public ArrayList<Pgv00301> LoadSh0030112(Pgv00301 bean) throws Exception {
		return sh30001Dao.LoadSh0030112(bean);
	}

	/**
	 * @param sh30001Dao the sh30001Dao to set
	 */
	public void setSh30001Dao(ISh30001DAO sh30001Dao) {
		this.sh30001Dao = sh30001Dao;
	}

	/**
	 * @return the sh30001Dao
	 */
	public ISh30001DAO getSh30001Dao() {
		return sh30001Dao;
	}

}
