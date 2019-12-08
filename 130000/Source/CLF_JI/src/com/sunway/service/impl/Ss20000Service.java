/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.ISs20000DAO;
import com.sunway.service.ISs20000Service;
import com.sunway.vo.Pgv00041;
import com.sunway.vo.Pgv12001;
import com.sunway.vo.Ss00000;

/**
 * 
 * 收益法算稅處理
 * @author Andy.Gao
 * @category 算稅處理
 *
 */
public class Ss20000Service implements ISs20000Service {

	private ISs20000DAO ss20000Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.ISs20000Service#GetSsAgainAllCommand(com.sunway.vo.Pgv00041)
	 */
	@Override
	public Boolean GetSsAgainAllCommand(Pgv00041 bean) throws Exception {
		return ss20000Dao.GetSsAgainAllCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISs20000Service#GetSsAgainCommand(com.sunway.vo.Pgv00041)
	 */
	@Override
	public Boolean GetSsAgainCommand(Pgv00041 bean) throws Exception {
		return ss20000Dao.GetSsAgainCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISs20000Service#GetSsCommand(com.sunway.vo.Pgv12001)
	 */
	@Override
	public Boolean GetSsCommand(Pgv12001 bean) throws Exception {
		return ss20000Dao.GetSsCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISs20000Service#LoadSsSwid(com.sunway.vo.Pgv12001)
	 */
	@Override
	public ArrayList<Pgv12001> LoadSsSwid(Pgv12001 bean) throws Exception {
		return ss20000Dao.LoadSsSwid(bean);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.ISs20000Service#LoadNotice(com.sunway.vo.Ss00000)
	 */
	@Override
	public Ss00000 LoadNotice(Ss00000 ss00000) throws Exception {
		return ss20000Dao.LoadNotice(ss00000);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.ISs20000Service#printcz(com.sunway.vo.Ss00000)
	 */
	@Override
	public Boolean printcz(Ss00000 ss00000) throws Exception {
		return ss20000Dao.printcz(ss00000);
	}

	/**
	 * @param ss20000Dao the ss20000Dao to set
	 */
	public void setSs20000Dao(ISs20000DAO ss20000Dao) {
		this.ss20000Dao = ss20000Dao;
	}

	/**
	 * @return the ss20000Dao
	 */
	public ISs20000DAO getSs20000Dao() {
		return ss20000Dao;
	}

}
