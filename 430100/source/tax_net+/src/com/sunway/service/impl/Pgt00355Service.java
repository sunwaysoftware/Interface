/**
 * 
 */
package com.sunway.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt00355DAO;
import com.sunway.service.IPgt00355Service;
import com.sunway.vo.Pgt00355;
import com.sunway.vo.Pgv00355;

/**
 * @category 市场法楼层系数
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00355Service implements IPgt00355Service {

	private IPgt00355DAO t00355Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#GetDeleteCommand(com.sunway.vo.Pgt00355)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00355 lcxs) throws Exception {
		return t00355Dao.GetDeleteCommand(lcxs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#GetInsertCommand(com.sunway.vo.Pgt00355)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00355 lcxs) throws Exception {
		return t00355Dao.GetInsertCommand(lcxs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#GetUpdateCommand(com.sunway.vo.Pgt00355)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00355 lcxs) throws Exception {
		return t00355Dao.GetUpdateCommand(lcxs);
	}
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#GetDeleteCommand(com.sunway.vo.Pgt00355)
	 */
	@Override
	public boolean GetDeleteSelCommand(Pgv00355 lcxs) throws Exception {
		return t00355Dao.GetDeleteSelCommand(lcxs);
	}
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#LoadAll(com.sunway.vo.Pgv00355)
	 */
	@Override
	public ArrayList<Pgv00355> LoadAll(Pgv00355 lcxs) throws Exception {
		return t00355Dao.LoadAll(lcxs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#LoadByPrimaryKey(com.sunway.vo.Pgt00355)
	 */
	@Override
	public Pgt00355 LoadByPrimaryKey(Pgt00355 lcxs) throws Exception {
		return t00355Dao.LoadByPrimaryKey(lcxs);
	}

	/**
	 * @return the t00355Dao
	 */
	public IPgt00355DAO getT00355Dao() {
		return t00355Dao;
	}

	/**
	 * @param t00355Dao the t00355Dao to set
	 */
	public void setT00355Dao(IPgt00355DAO t00355Dao) {
		this.t00355Dao = t00355Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#ExecuteParamCopy(com.sunway.vo.Pgt00355)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt00355 lcxs) throws Exception {
		return t00355Dao.ExecuteParamCopy(lcxs);
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#ExportLCXZSjcx(com.sunway.vo.Pgv00355)
	 */
	@Override
	public ByteArrayOutputStream ExportLCXZSjcx(Pgv00355 v00355) throws Exception {
		return (ByteArrayOutputStream) t00355Dao.ExportLXCZSjcx(v00355);
	}

	@Override
	public Pgv00355 ImportExcelData(ArrayList<Pgv00355> ebList)
			throws Exception {
		// TODO Auto-generated method stub
		return t00355Dao.ImportExcelData(ebList);
	}

}
