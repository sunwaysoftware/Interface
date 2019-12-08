/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.ITj00001DAO;
import com.sunway.service.ITj00001Service;
import com.sunway.vo.BFV00006;

/**
 * 
 * 统计：征收单位
 * @author Amani
 *
 */
public class Tj00001Service implements ITj00001Service {

	private ITj00001DAO tj00001Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.ITj00001Service#LoadAll(com.sunway.vo.BFV00006)
	 */
	@Override
	public ArrayList<BFV00006> LoadAll(BFV00006 bean) throws Exception {
		return tj00001Dao.LoadAll(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ITj00001Service#ExportData(com.sunway.vo.BFV00006)
	 */
	@Override
	public ArrayList<BFV00006> ExportData(BFV00006 bean) throws Exception {
		return tj00001Dao.ExportData(bean);
	}
	
	/**
	 * @return the tj00001Dao
	 */
	public ITj00001DAO getTj00001Dao() {
		return tj00001Dao;
	}

	/**
	 * @param tj00001Dao the tj00001Dao to set
	 */
	public void setTj00001Dao(ITj00001DAO tj00001Dao) {
		this.tj00001Dao = tj00001Dao;
	}

}
