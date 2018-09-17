/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.ICL02090DAO;
import com.sunway.service.ICL02090Service;
import com.sunway.vo.BF00000;
import com.sunway.vo.Pgv02031;

/**
 * @author Andy.Gao
 *
 */
public class CL02090Service implements ICL02090Service {

	private ICL02090DAO cl02090Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.ICL02090Service#LoadJs(com.sunway.vo.Pgv02031)
	 */
	@Override
	public ArrayList<Pgv02031> LoadJs(Pgv02031 bean) throws Exception {
		return cl02090Dao.LoadJs(bean);
	}

	/**
	 * @param cl02090Dao the cl02090Dao to set
	 */
	public void setCl02090Dao(ICL02090DAO cl02090Dao) {
		this.cl02090Dao = cl02090Dao;
	}

	/**
	 * @return the cl02090Dao
	 */
	public ICL02090DAO getCl02090Dao() {
		return cl02090Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ICL02090Service#execRD(com.sunway.vo.Pgv02031)
	 */
	@Override
	public Boolean execRD(Pgv02031 bean) throws Exception {
		return cl02090Dao.execRD(bean);
	}	

	/* (non-Javadoc)
	 * @see com.sunway.service.ICL02090Service#LoadSb(com.sunway.vo.Pgv02031)
	 */
	@Override
	public ArrayList<Pgv02031> LoadSb(Pgv02031 bean) throws Exception {
		return cl02090Dao.LoadSb(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ICL02090Service#execTzs(com.sunway.vo.Pgv02031)
	 */
	@Override
	public ArrayList<BF00000> execTzs(BF00000 bean) throws Exception {
		return cl02090Dao.execTzs(bean);
	}

}
