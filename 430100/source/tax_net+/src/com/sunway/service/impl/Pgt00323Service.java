/**
 * 
 */
package com.sunway.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt00323DAO;
import com.sunway.service.IPgt00323Service;
import com.sunway.vo.Pgt00323;
import com.sunway.vo.Pgv00323;





/**
 * @category 市场法楼层系数
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00323Service implements IPgt00323Service {

	private IPgt00323DAO t00323Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#GetDeleteCommand(com.sunway.vo.Pgt00355)
	 */
	public boolean GetDeleteCommand(Pgt00323 lcxs) throws Exception {
		return t00323Dao.GetDeleteCommand(lcxs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#GetInsertCommand(com.sunway.vo.Pgt00355)
	 */
	public boolean GetInsertCommand(Pgt00323 lcxs) throws Exception {
		return t00323Dao.GetInsertCommand(lcxs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#GetUpdateCommand(com.sunway.vo.Pgt00355)
	 */
	public boolean GetUpdateCommand(Pgt00323 lcxs) throws Exception {
		return t00323Dao.GetUpdateCommand(lcxs);
	}
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#GetDeleteCommand(com.sunway.vo.Pgt00355)
	 */
	public boolean GetDeleteSelCommand(Pgv00323 lcxs) throws Exception {
		return t00323Dao.GetDeleteSelCommand(lcxs);
	}
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#LoadAll(com.sunway.vo.Pgv00355)
	 */
	@Override
	public ArrayList<Pgv00323> LoadAll(Pgv00323 lcxs) throws Exception {
		return t00323Dao.LoadAll(lcxs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#LoadByPrimaryKey(com.sunway.vo.Pgt00355)
	 */
	@Override
	public Pgt00323 LoadByPrimaryKey(Pgt00323 lcxs) throws Exception {
		return t00323Dao.LoadByPrimaryKey(lcxs);
	}

	/**
	 * @return the t00355Dao
	 */
	public IPgt00323DAO getT00323Dao() {
		return t00323Dao;
	}

	/**
	 * @param t00355Dao the t00355Dao to set
	 */
	public void setT00323Dao(IPgt00323DAO t00323Dao) {
		this.t00323Dao = t00323Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#ExecuteParamCopy(com.sunway.vo.Pgt00355)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt00323 lcxs) throws Exception {
		return t00323Dao.ExecuteParamCopy(lcxs);
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#ExportLCXZSjcx(com.sunway.vo.Pgv00355)
	 */
	@Override
	public ByteArrayOutputStream ExportLCXZSjcx(Pgv00323 v00323) throws Exception {
		return (ByteArrayOutputStream) t00323Dao.ExportLXCZSjcx(v00323);
	}

	@Override
	public Pgv00323 ImportExcelData(ArrayList<Pgv00323> ebList)
			throws Exception {
		// TODO Auto-generated method stub
		return t00323Dao.ImportExcelData(ebList);
	}

}
