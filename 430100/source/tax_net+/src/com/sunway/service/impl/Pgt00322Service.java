/**
 * 
 */
package com.sunway.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt00322DAO;
import com.sunway.service.IPgt00322Service;
import com.sunway.vo.Pgt00322;
import com.sunway.vo.Pgv00322;



/**
 * @category 市场法楼层系数
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00322Service implements IPgt00322Service {

	private IPgt00322DAO t00322Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#GetDeleteCommand(com.sunway.vo.Pgt00355)
	 */
	public boolean GetDeleteCommand(Pgt00322 lcxs) throws Exception {
		return t00322Dao.GetDeleteCommand(lcxs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#GetInsertCommand(com.sunway.vo.Pgt00355)
	 */
	public boolean GetInsertCommand(Pgt00322 lcxs) throws Exception {
		return t00322Dao.GetInsertCommand(lcxs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#GetUpdateCommand(com.sunway.vo.Pgt00355)
	 */
	public boolean GetUpdateCommand(Pgt00322 lcxs) throws Exception {
		return t00322Dao.GetUpdateCommand(lcxs);
	}
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#GetDeleteCommand(com.sunway.vo.Pgt00355)
	 */
	public boolean GetDeleteSelCommand(Pgv00322 lcxs) throws Exception {
		return t00322Dao.GetDeleteSelCommand(lcxs);
	}
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#LoadAll(com.sunway.vo.Pgv00355)
	 */
	@Override
	public ArrayList<Pgv00322> LoadAll(Pgv00322 lcxs) throws Exception {
		return t00322Dao.LoadAll(lcxs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#LoadByPrimaryKey(com.sunway.vo.Pgt00355)
	 */
	@Override
	public Pgt00322 LoadByPrimaryKey(Pgt00322 lcxs) throws Exception {
		return t00322Dao.LoadByPrimaryKey(lcxs);
	}

	/**
	 * @return the t00355Dao
	 */
	public IPgt00322DAO getT00322Dao() {
		return t00322Dao;
	}

	/**
	 * @param t00355Dao the t00355Dao to set
	 */
	public void setT00322Dao(IPgt00322DAO t00322Dao) {
		this.t00322Dao = t00322Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#ExecuteParamCopy(com.sunway.vo.Pgt00355)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt00322 lcxs) throws Exception {
		return t00322Dao.ExecuteParamCopy(lcxs);
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#ExportLCXZSjcx(com.sunway.vo.Pgv00355)
	 */
	@Override
	public ByteArrayOutputStream ExportLCXZSjcx(Pgv00322 v00322) throws Exception {
		return (ByteArrayOutputStream) t00322Dao.ExportLXCZSjcx(v00322);
	}

	@Override
	public Pgv00322 ImportExcelData(ArrayList<Pgv00322> ebList)
			throws Exception {
		// TODO Auto-generated method stub
		return t00322Dao.ImportExcelData(ebList);
	}

}
