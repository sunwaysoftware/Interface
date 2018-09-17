package com.sunway.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt02050DAO;
import com.sunway.service.IPgt02050Service;
import com.sunway.vo.ExcelBean;

import com.sunway.vo.Pgt02050;

import com.sunway.vo.Pgv02050;

/**
 * 商业评估分区名称维护
 * @author LeiJia
 * @version 1.0
 */
public class Pgt02050Service implements IPgt02050Service {

	private IPgt02050DAO t02050Dao;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02050Service#LoadAll(com.sunway.vo.Pgv02050)
	 */
	@Override
	public ArrayList<Pgv02050> LoadAll(Pgv02050 v02050) throws Exception {
		return t02050Dao.LoadAll(v02050);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02050Service#LoadByPrimaryKey(com.sunway.vo.Pgt02050)
	 */
	@Override
	public Pgt02050 LoadByPrimaryKey(Pgt02050 t02050) throws Exception {
		return t02050Dao.LoadByPrimaryKey(t02050);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02050Service#GetInsertCommand(com.sunway.vo.Pgt02050)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02050 t02050) throws Exception {
		return t02050Dao.GetInsertCommand(t02050);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02050Service#GetDeleteCommand(com.sunway.vo.Pgt02050)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02050 t02050) throws Exception {
		return t02050Dao.GetDeleteCommand(t02050);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02050Service#GetUpdateCommand(com.sunway.vo.Pgt02050)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02050 t02050) throws Exception {
		return t02050Dao.GetUpdateCommand(t02050);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02050Service#LoadNavigator(com.sunway.vo.Pgt02050)
	 */
	@Override
	public ArrayList<Pgt02050> LoadNavigator(Pgt02050 t02050) throws Exception {
		return t02050Dao.LoadNavigator(t02050);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02050Service#LoadTreeList(com.sunway.vo.Pgt02050)
	 */
	@Override
	public ArrayList<Pgt02050> LoadTreeList(Pgt02050 t02050) throws Exception {
		return t02050Dao.LoadTreeList(t02050);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02050Service#LoadNavStream(java.lang.String)
	 */
	@Override
	public String LoadNavStream(String xqdm) throws Exception {
		return t02050Dao.LoadNavStream(xqdm);
	}

	/**
	 * @return the t02050Dao
	 */
	public IPgt02050DAO getT02050Dao() {
		return t02050Dao;
	}
	/**
	 * @param t02050Dao the t02050Dao to set
	 */
	public void setT02050Dao(IPgt02050DAO t02050Dao) {
		this.t02050Dao = t02050Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02050Service#ImportExcelData(java.util.ArrayList)
	 */
	@Override
	public ExcelBean ImportExcelData(ArrayList<ExcelBean> ebList)
			throws Exception {
		return t02050Dao.ImportExcelData(ebList);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02050Service#LoadAllByXqzt(com.sunway.vo.Pgv02050)
	 */
	@Override
	public ArrayList<Pgv02050> LoadAllByXqzt(Pgv02050 v02050) throws Exception {
		return t02050Dao.LoadAllByXqzt(v02050);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02050Service#GetUpdateCommandForXqzt(com.sunway.vo.Pgt02050)
	 */
	@Override
	public boolean GetUpdateCommandForXqzt(Pgt02050 t02050) throws Exception {
		return t02050Dao.GetUpdateCommandForXqzt(t02050);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02050Service#GetXQNM(com.sunway.vo.Pgt02050)
	 */
	@Override
	public ArrayList<String> GetXQNM(Pgt02050 t02050) throws Exception {
		return t02050Dao.GetXQNM(t02050);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02050Service#LoadByXqnm(com.sunway.vo.Pgt02050)
	 */
	@Override
	public Pgt02050 LoadByXqnm(Pgt02050 t02050) throws Exception {
		return t02050Dao.LoadByXqnm(t02050);
	}

	@Override
	public OutputStream ExportGJFQ(Pgv02050 v02050) throws Exception {
		
		return t02050Dao.ExportGJFQ(v02050);
	}

	@Override
	public ArrayList<Pgv02050> loadAllGJFQDQ(Pgv02050 v02050) throws Exception {
		
		return t02050Dao.loadAllGJFQDQ(v02050);
	}

	@Override
	public ArrayList<Pgv02050> loadAllGJFQXQ(Pgv02050 v02050) throws Exception {
		
		return t02050Dao.loadAllGJFQXQ(v02050);
	}

	@Override
	public OutputStream ExportGJFQDQ(Pgv02050 v02050) throws Exception {
		
		return t02050Dao.ExportGJFQDQ(v02050);
	}

	@Override
	public boolean ValidatePG(Pgv02050 v02050) throws Exception {
		
		return t02050Dao.ValidatePG(v02050);
	}

	@Override
	public boolean GetSelDeleteCommand(Pgt02050 t02050) throws Exception {
		
		return t02050Dao.GetSelDeleteCommand(t02050);
	}

	@Override
	public boolean validateXqdmhmIsExist(Pgv02050 v02050) throws Exception {
		return t02050Dao.validateXqdmhmIsExist(v02050);
	}

	@Override
	public Pgv02050 ImportDataSZMS(ArrayList<Pgv02050> v02050List)
			throws Exception {
		
		return t02050Dao.ImportDataSZMS(v02050List);
	}
	
	
	
	
}
