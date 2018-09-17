/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt02084DAO;
import com.sunway.service.IPgt02084Service;
import com.sunway.vo.Pgv02084;

/**
 * 
 * 市場审核和评税未过原因说明
 * @author Andy.Gao
 *
 */
public class Pgt02084Service implements IPgt02084Service {

	private IPgt02084DAO t02084Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02084Service#LoadAll(com.sunway.vo.Pgv02084)
	 */
	@Override
	public ArrayList<Pgv02084> LoadAll(Pgv02084 bean) throws Exception {
		return t02084Dao.LoadAll(bean);
	}

	/**
	 * @param t02084Dao the t02084Dao to set
	 */
	public void setT02084Dao(IPgt02084DAO t02084Dao) {
		this.t02084Dao = t02084Dao;
	}

	/**
	 * @return the t02084Dao
	 */
	public IPgt02084DAO getT02084Dao() {
		return t02084Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02084Service#LoadYY()
	 */
	@Override
	public ArrayList<Pgv02084> LoadYY(Pgv02084 bean) throws Exception {
		return t02084Dao.LoadYY(bean);
	}

	@Override
	public ArrayList<Pgv02084> LoadQMPG(Pgv02084 bean) throws Exception {
		return t02084Dao.LoadQMPG(bean);
	}

}
