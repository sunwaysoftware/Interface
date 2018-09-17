package com.sunway.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt00357DAO;
import com.sunway.service.IPgt00357Service;
import com.sunway.vo.Pgt00357;
import com.sunway.vo.Pgv00357;

/**
 * 
 * 市场法实例库
 * @category 系统维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00357Service implements IPgt00357Service {

	private IPgt00357DAO t00357Dao;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00357Service#LoadAll(com.sunway.vo.Pgv00357)
	 */
	@Override
	public ArrayList<Pgv00357> LoadAll(Pgv00357 v00357) throws Exception {
		return t00357Dao.LoadAll(v00357);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00357Service#LoadByPrimaryKey(com.sunway.vo.Pgt00357)
	 */
	@Override
	public Pgt00357 LoadByPrimaryKey(Pgt00357 t00357) throws Exception {
		return t00357Dao.LoadByPrimaryKey(t00357);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00357Service#GetInsertCommand(com.sunway.vo.Pgt00357)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00357 t00357) throws Exception {
		return t00357Dao.GetInsertCommand(t00357);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00357Service#GetUpdateCommand(com.sunway.vo.Pgt00357)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00357 t00357) throws Exception {
		return t00357Dao.GetUpdateCommand(t00357);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00357Service#GetDeleteCommand(com.sunway.vo.Pgt00357)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00357 t00357) throws Exception {
		return t00357Dao.GetDeleteCommand(t00357);
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00357Service#GetDeleteCommand(com.sunway.vo.Pgt00357)
	 */
	@Override
	public boolean GetDeleteSelCommand(Pgv00357 v00357) throws Exception {
		return t00357Dao.GetDeleteSelCommand(v00357);
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00357Service#LoadDetail(com.sunway.vo.Pgv00357)
	 */
	@Override
	public Pgv00357 LoadDetail(Pgv00357 v00357) throws Exception {
		return t00357Dao.LoadDetail(v00357);
	}

	/**
	 * @return the t00357Dao
	 */
	public IPgt00357DAO getT00357Dao() {
		return t00357Dao;
	}
	/**
	 * @param t00357Dao the t00357Dao to set
	 */
	public void setT00357Dao(IPgt00357DAO t00357Dao) {
		this.t00357Dao = t00357Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00357Service#ImportExcelData(java.util.ArrayList)
	 */
	@Override
	public Pgv00357 ImportExcelData(ArrayList<Pgv00357> kbslkList)  throws Exception{
		return t00357Dao.ImportExcelData(kbslkList);
	}
    public ByteArrayOutputStream ExportkbslSjcx(Pgv00357 v00357)throws Exception{
    	return (ByteArrayOutputStream)t00357Dao.ExportkbslSjcx(v00357);
    }
    @Override
	public ArrayList<Pgv00357> LoadCSKbslk(Pgv00357 v00357) throws Exception {
		return t00357Dao.LoadCSKbsl(v00357);
	}
    @Override
	public Integer MakeBZF(Pgv00357 v00357) throws Exception {
		return t00357Dao.MakeBZF(v00357);
	}
	
}
