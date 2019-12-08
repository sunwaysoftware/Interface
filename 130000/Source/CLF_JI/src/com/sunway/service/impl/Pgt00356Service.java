package com.sunway.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt00356DAO;
import com.sunway.service.IPgt00356Service;
import com.sunway.vo.Pgt00356;
import com.sunway.vo.Pgv00356;

/**
 * @category 物价指数修正
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00356Service implements IPgt00356Service {

	private IPgt00356DAO t00356Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00356Service#GetDeleteCommand(com.sunway.vo.Pgt00356)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00356 wjzs) throws Exception {
		return t00356Dao.GetDeleteCommand(wjzs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00356Service#GetInsertCommand(com.sunway.vo.Pgt00356)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00356 wjzs) throws Exception {
		return t00356Dao.GetInsertCommand(wjzs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00356Service#GetUpdateCommand(com.sunway.vo.Pgt00356)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00356 wjzs) throws Exception {
		return t00356Dao.GetUpdateCommand(wjzs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00356Service#LoadAll(com.sunway.vo.Pgv00356)
	 */
	@Override
	public ArrayList<Pgv00356> LoadAll(Pgv00356 wjzs) throws Exception {
		return t00356Dao.LoadAll(wjzs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00356Service#LoadByPrimaryKey(com.sunway.vo.Pgt00356)
	 */
	@Override
	public Pgt00356 LoadByPrimaryKey(Pgt00356 wjzs) throws Exception {
		return t00356Dao.LoadByPrimaryKey(wjzs);
	}

	/**
	 * @return the t00356Dao
	 */
	public IPgt00356DAO getT00356Dao() {
		return t00356Dao;
	}

	/**
	 * @param t00356Dao the t00356Dao to set
	 */
	public void setT00356Dao(IPgt00356DAO t00356Dao) {
		this.t00356Dao = t00356Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00356Service#ExecuteParamCopy(com.sunway.vo.Pgt00356)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt00356 wjzs) throws Exception {
		return t00356Dao.ExecuteParamCopy(wjzs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00357Service#ImportExcelData(java.util.ArrayList)
	 */
	@Override
	public Pgv00356 ImportExcelData(ArrayList<Pgv00356> jyjgzsList)  throws Exception{
		return t00356Dao.ImportExcelData(jyjgzsList);
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00352Service#ExportGJFQSjcx(com.sunway.vo.Pgv00352)
	 */
	@Override
	public ByteArrayOutputStream ExportjyjgSjcx(Pgv00356 v00356) throws Exception {

		return (ByteArrayOutputStream) t00356Dao.ExportjyjgSjcx(v00356);
	}
}
