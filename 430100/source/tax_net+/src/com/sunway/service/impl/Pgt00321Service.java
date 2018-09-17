/**
 * 
 */
package com.sunway.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt00321DAO;
import com.sunway.service.IPgt00321Service;
import com.sunway.vo.Pgt00321;
import com.sunway.vo.Pgv00321;

/**
 * @category 市场法楼层系数
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00321Service implements IPgt00321Service {

	private IPgt00321DAO t00321Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#GetDeleteCommand(com.sunway.vo.Pgt00355)
	 */
	public boolean GetDeleteCommand(Pgt00321 lcxs) throws Exception {
		return t00321Dao.GetDeleteCommand(lcxs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#GetInsertCommand(com.sunway.vo.Pgt00355)
	 */
	public boolean GetInsertCommand(Pgt00321 lcxs) throws Exception {
		return t00321Dao.GetInsertCommand(lcxs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#GetUpdateCommand(com.sunway.vo.Pgt00355)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00321 lcxs) throws Exception {
		return t00321Dao.GetUpdateCommand(lcxs);
	}
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#GetDeleteCommand(com.sunway.vo.Pgt00355)
	 */
	public boolean GetDeleteSelCommand(Pgv00321 lcxs) throws Exception {
		return t00321Dao.GetDeleteSelCommand(lcxs);
	}
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#LoadAll(com.sunway.vo.Pgv00355)
	 */
	@Override
	public ArrayList<Pgv00321> LoadAll(Pgv00321 lcxs) throws Exception {
		return t00321Dao.LoadAll(lcxs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#LoadByPrimaryKey(com.sunway.vo.Pgt00355)
	 */
	@Override
	public Pgt00321 LoadByPrimaryKey(Pgt00321 lcxs) throws Exception {
		return t00321Dao.LoadByPrimaryKey(lcxs);
	}

	/**
	 * @return the t00355Dao
	 */
	public IPgt00321DAO getT00321Dao() {
		return t00321Dao;
	}

	/**
	 * @param t00355Dao the t00355Dao to set
	 */
	public void setT00321Dao(IPgt00321DAO t00321Dao) {
		this.t00321Dao = t00321Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#ExecuteParamCopy(com.sunway.vo.Pgt00355)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt00321 lcxs) throws Exception {
		return t00321Dao.ExecuteParamCopy(lcxs);
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#ExportLCXZSjcx(com.sunway.vo.Pgv00355)
	 */
	@Override
	public ByteArrayOutputStream ExportLCXZSjcx(Pgv00321 v00321) throws Exception {
		return (ByteArrayOutputStream) t00321Dao.ExportLXCZSjcx(v00321);
	}

	@Override
	public Pgv00321 ImportExcelData(ArrayList<Pgv00321> ebList)
			throws Exception {
		// TODO Auto-generated method stub
		return t00321Dao.ImportExcelData(ebList);
	}

}
