package com.sunway.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt00352DAO;
import com.sunway.service.IPgt00352Service;
import com.sunway.vo.ExcelBean;
import com.sunway.vo.Pgt00352;
import com.sunway.vo.Pgv00352;

/**
 * 小区名称维护
 * @author Lee
 * @version 1.0
 */
public class Pgt00352Service implements IPgt00352Service {

	private IPgt00352DAO t00352Dao;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00352Service#LoadAll(com.sunway.vo.Pgv00352)
	 */
	@Override
	public ArrayList<Pgv00352> LoadAll(Pgv00352 v00352) throws Exception {
		return t00352Dao.LoadAll(v00352);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00352Service#LoadByPrimaryKey(com.sunway.vo.Pgt00352)
	 */
	@Override
	public Pgt00352 LoadByPrimaryKey(Pgt00352 t00352) throws Exception {
		return t00352Dao.LoadByPrimaryKey(t00352);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00352Service#GetInsertCommand(com.sunway.vo.Pgt00352)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00352 t00352) throws Exception {
		return t00352Dao.GetInsertCommand(t00352);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00352Service#GetDeleteCommand(com.sunway.vo.Pgt00352)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00352 t00352) throws Exception {
		return t00352Dao.GetDeleteCommand(t00352);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00352Service#GetUpdateCommand(com.sunway.vo.Pgt00352)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00352 t00352) throws Exception {
		return t00352Dao.GetUpdateCommand(t00352);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00352Service#LoadNavigator(com.sunway.vo.Pgt00352)
	 */
	@Override
	public ArrayList<Pgt00352> LoadNavigator(Pgt00352 t00352) throws Exception {
		return t00352Dao.LoadNavigator(t00352);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00352Service#LoadTreeList(com.sunway.vo.Pgt00352)
	 */
	@Override
	public ArrayList<Pgt00352> LoadTreeList(Pgt00352 t00352) throws Exception {
		return t00352Dao.LoadTreeList(t00352);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00352Service#LoadNavStream(java.lang.String)
	 */
	@Override
	public String LoadNavStream(String xqdm) throws Exception {
		return t00352Dao.LoadNavStream(xqdm);
	}

	/**
	 * @return the t00352Dao
	 */
	public IPgt00352DAO getT00352Dao() {
		return t00352Dao;
	}
	/**
	 * @param t00352Dao the t00352Dao to set
	 */
	public void setT00352Dao(IPgt00352DAO t00352Dao) {
		this.t00352Dao = t00352Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00352Service#ImportExcelData(java.util.ArrayList)
	 */
	@Override
	public ExcelBean ImportExcelData(ArrayList<ExcelBean> ebList)
			throws Exception {
		return t00352Dao.ImportExcelData(ebList);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00352Service#LoadAllByXqzt(com.sunway.vo.Pgv00352)
	 */
	@Override
	public ArrayList<Pgv00352> LoadAllByXqzt(Pgv00352 v00352) throws Exception {
		return t00352Dao.LoadAllByXqzt(v00352);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00352Service#GetUpdateCommandForXqzt(com.sunway.vo.Pgt00352)
	 */
	@Override
	public boolean GetUpdateCommandForXqzt(Pgt00352 t00352) throws Exception {
		return t00352Dao.GetUpdateCommandForXqzt(t00352);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00352Service#GetXQNM(com.sunway.vo.Pgt00352)
	 */
	@Override
	public ArrayList<Pgv00352> GetXQNM(Pgt00352 t00352) throws Exception {
		return t00352Dao.GetXQNM(t00352);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00352Service#LoadByXqnm(com.sunway.vo.Pgt00352)
	 */
	@Override
	public Pgt00352 LoadByXqnm(Pgt00352 t00352) throws Exception {
		return t00352Dao.LoadByXqnm(t00352);
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00352Service#ExportGJFQSjcx(com.sunway.vo.Pgv00352)
	 */
	@Override
	public ByteArrayOutputStream ExportGJFQSjcx(Pgv00352 v00352) throws Exception {

		return (ByteArrayOutputStream) t00352Dao.ExportGJFQSjcx(v00352);
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00352Service#LoadQX(com.sunway.vo.Pgt00352)
	 */
	@Override
	public Integer LoadQX(Pgt00352 v00352) throws Exception {
		
		return t00352Dao.LoadQX(v00352);
	}
	
	
}
