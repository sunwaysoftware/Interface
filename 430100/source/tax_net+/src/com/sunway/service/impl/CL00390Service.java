/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.ICL00390DAO;
import com.sunway.service.ICL00390Service;
import com.sunway.vo.BF00000;
import com.sunway.vo.Pgv00331;

/**
 * @author Andy.Gao
 *
 */
public class CL00390Service implements ICL00390Service {

	private ICL00390DAO cl00390Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.ICL00390Service#LoadJs(com.sunway.vo.Pgv00331)
	 */
	@Override
	public ArrayList<Pgv00331> LoadJs(Pgv00331 bean) throws Exception {
		return cl00390Dao.LoadJs(bean);
	}

	/**
	 * @param cl00390Dao the cl00390Dao to set
	 */
	public void setCl00390Dao(ICL00390DAO cl00390Dao) {
		this.cl00390Dao = cl00390Dao;
	}

	/**
	 * @return the cl00390Dao
	 */
	public ICL00390DAO getCl00390Dao() {
		return cl00390Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ICL00390Service#execRD(com.sunway.vo.Pgv00331)
	 */
	@Override
	public Boolean execRD(Pgv00331 bean) throws Exception {
		return cl00390Dao.execRD(bean);
	}	

	/* (non-Javadoc)
	 * @see com.sunway.service.ICL00390Service#LoadSb(com.sunway.vo.Pgv00331)
	 */
	@Override
	public ArrayList<Pgv00331> LoadSb(Pgv00331 bean) throws Exception {
		return cl00390Dao.LoadSb(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ICL00390Service#execTzs(com.sunway.vo.Pgv00331)
	 */
	@Override
	public ArrayList<BF00000> execTzs(BF00000 bean) throws Exception {
		return cl00390Dao.execTzs(bean);
	}

}
