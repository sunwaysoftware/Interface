/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.ISs30000DAO;
import com.sunway.service.ISs30000Service;
import com.sunway.vo.Pgv00041;
import com.sunway.vo.Pgv00302;
import com.sunway.vo.Ss00000;
import com.sunway.vo.Ss30000;

/**
 * 
 * 市場法算稅處理
 * @author Andy.Gao
 * @category 算稅處理
 *
 */
public class Ss30000Service implements ISs30000Service {

	private ISs30000DAO ss30000Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.ISs30000Service#GetSsAgainAllCommand(com.sunway.vo.Pgv00041)
	 */
	@Override
	public Boolean GetSsAgainAllCommand(Pgv00041 bean) throws Exception {
		return ss30000Dao.GetSsAgainAllCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISs30000Service#GetSsAgainCommand(com.sunway.vo.Pgv00041)
	 */
	@Override
	public Boolean GetSsAgainCommand(Pgv00041 bean) throws Exception {
		return ss30000Dao.GetSsAgainCommand(bean);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.ISs30000Service#GetSsCommand(com.sunway.vo.Pgv00302)
	 */
	@Override
	public Boolean GetSsCommand(Pgv00302 bean) throws Exception {
		return ss30000Dao.GetSsCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISs30000Service#LoadSsSwid(com.sunway.vo.Pgv00301)
	 */
	@Override
	public ArrayList<Pgv00302> LoadSsList(Pgv00302 bean) throws Exception {
		return ss30000Dao.LoadSsList(bean);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.ISs30000Service#LoadNotice(com.sunway.vo.Ss30000)
	 */
	@Override
	public Ss30000 LoadNotice(Ss30000 ss30000) throws Exception {
		return ss30000Dao.LoadNotice(ss30000);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.ISs30000Service#printcz(com.sunway.vo.Ss00000)
	 */
	@Override
	public Boolean printcz(Ss00000 ss00000) throws Exception {
		return ss30000Dao.printcz(ss00000);
	}

	/**
	 * @param ss30000Dao the ss30000Dao to set
	 */
	public void setSs30000Dao(ISs30000DAO ss30000Dao) {
		this.ss30000Dao = ss30000Dao;
	}

	/**
	 * @return the ss30000Dao
	 */
	public ISs30000DAO getSs30000Dao() {
		return ss30000Dao;
	}
}
