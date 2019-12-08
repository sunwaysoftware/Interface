/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.ISs10000DAO;
import com.sunway.service.ISs10000Service;
import com.sunway.vo.Pgv00041;
import com.sunway.vo.Pgv12001;
import com.sunway.vo.Ss00000;

/**
 * 
 * 成本法算稅處理
 * @author Andy.Gao
 * @category 算稅處理
 *
 */
public class Ss10000Service implements ISs10000Service {

	private ISs10000DAO ss10000Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.ISs10000Service#GetSsAgainAllCommand(com.sunway.vo.Pgv00041)
	 */
	@Override
	public Boolean GetSsAgainAllCommand(Pgv00041 bean) throws Exception {
		return ss10000Dao.GetSsAgainAllCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISs10000Service#GetSsAgainCommand(com.sunway.vo.Pgv00041)
	 */
	@Override
	public Boolean GetSsAgainCommand(Pgv00041 bean) throws Exception {
		return ss10000Dao.GetSsAgainCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISs10000Service#GetSsCommand(com.sunway.vo.Pgv12001)
	 */
	@Override
	public Boolean GetSsCommand(Pgv12001 bean) throws Exception {
		return ss10000Dao.GetSsCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ISs10000Service#LoadShSwidList(com.sunway.vo.Pgv12001)
	 */
	@Override
	public ArrayList<Pgv12001> LoadShSwidList(Pgv12001 bean) throws Exception {
		return ss10000Dao.LoadSsSwid(bean);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.ISs10000Service#LoadNotice(com.sunway.vo.Ss00000)
	 */
	@Override
	public Ss00000 LoadNotice(Ss00000 ss00000) throws Exception {
		return ss10000Dao.LoadNotice(ss00000);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.ISs10000Service#printcz(com.sunway.vo.Ss00000)
	 */
	@Override
	public Boolean printcz(Ss00000 ss00000) throws Exception {
		return ss10000Dao.printcz(ss00000);
	}

	/**
	 * @param ss10000Dao the ss10000Dao to set
	 */
	public void setSs10000Dao(ISs10000DAO ss10000Dao) {
		this.ss10000Dao = ss10000Dao;
	}

	/**
	 * @return the ss10000Dao
	 */
	public ISs10000DAO getSs10000Dao() {
		return ss10000Dao;
	}
}
