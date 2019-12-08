package com.sunway.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Map;

import com.sunway.dao.IPgt00353DAO;
import com.sunway.service.IPgt00353Service;
import com.sunway.vo.Pgt00353;
import com.sunway.vo.Pgv00353;


/**
 * @category 市场法采光修正系数
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00353Service implements IPgt00353Service {

	private IPgt00353DAO t00353Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00353Service#GetDeleteCommand(com.sunway.vo.Pgt00353)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00353 cgxz) throws Exception {
		return t00353Dao.GetDeleteCommand(cgxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00353Service#GetInsertCommand(com.sunway.vo.Pgt00353)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00353 cgxz) throws Exception {
		return t00353Dao.GetInsertCommand(cgxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00353Service#GetUpdateCommand(com.sunway.vo.Pgt00353)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00353 cgxz) throws Exception {
		return t00353Dao.GetUpdateCommand(cgxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00353Service#LoadAll(com.sunway.vo.Pgv00353)
	 */
	@Override
	public ArrayList<Pgv00353> LoadAll(Pgv00353 cgxz) throws Exception {
		return t00353Dao.LoadAll(cgxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00353Service#LoadByPrimaryKey(com.sunway.vo.Pgt00353)
	 */
	@Override
	public Pgt00353 LoadByPrimaryKey(Pgt00353 cgxz) throws Exception {
		return t00353Dao.LoadByPrimaryKey(cgxz);
	}

	/**
	 * @return the t00353Dao
	 */
	public IPgt00353DAO getT00353Dao() {
		return t00353Dao;
	}

	/**
	 * @param t00353Dao the t00353Dao to set
	 */
	public void setT00353Dao(IPgt00353DAO t00353Dao) {
		this.t00353Dao = t00353Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00353Service#ExecuteParamCopy(com.sunway.vo.Pgt00353)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt00353 cgxz) throws Exception {
		return t00353Dao.ExecuteParamCopy(cgxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00353Service#LoadObj()
	 */
	@Override
	public Map<String, String> LoadObj(Pgt00353 cgzk) throws Exception {
		return t00353Dao.LoadObj(cgzk);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00353Service#ExportLCXZSjcx(com.sunway.vo.Pgv00353)
	 */
	@Override
	public ByteArrayOutputStream ExportZHXZSjcx(Pgv00353 v00353) throws Exception {
		return (ByteArrayOutputStream) t00353Dao.ExportZHXZSjcx(v00353);
	}
	@Override
	public Pgv00353 ImportExcelData(ArrayList<Pgv00353> ebList)
			throws Exception {
		// TODO Auto-generated method stub
		return t00353Dao.ImportExcelData(ebList);
	}
}
