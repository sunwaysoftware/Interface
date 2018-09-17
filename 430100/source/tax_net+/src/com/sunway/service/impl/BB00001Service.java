/**
 * 
 */
package com.sunway.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.dao.IBB00001DAO;
import com.sunway.service.IBB00001Service;
import com.sunway.vo.BF00001;


/**
 * @author Lee
 *
 */
public class BB00001Service implements IBB00001Service {

	private IBB00001DAO bb00001Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IBB00001Service#LoadAll(com.sunway.vo.BF00001)
	 */
	@Override
	public ArrayList<BF00001> LoadAll(BF00001 bean) throws Exception {
		return bb00001Dao.LoadAll(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IBB00001Service#LoadAll(com.sunway.vo.BF00001)
	 */
	@Override
	public OutputStream ExportData(BF00001 bean) throws Exception {
		return bb00001Dao.ExportData(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IBB00001Service#LoadAll(com.sunway.vo.BF00001)
	 */
	@Override
	public ArrayList<BF00001> LoadAll02(BF00001 bean) throws Exception {
		return bb00001Dao.LoadAll02(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IBB00001Service#LoadAll(com.sunway.vo.BF00001)
	 */
	@Override
	public OutputStream ExportData02(BF00001 bean) throws Exception {
		return bb00001Dao.ExportData02(bean);
	}

	/**
	 * @param bb00001Dao the bb00001Dao to set
	 */
	public void setBb00001Dao(IBB00001DAO bb00001Dao) {
		this.bb00001Dao = bb00001Dao;
	}

	/**
	 * @return the bb00001Dao
	 */
	public IBB00001DAO getBb00001Dao() {
		return bb00001Dao;
	}
}
