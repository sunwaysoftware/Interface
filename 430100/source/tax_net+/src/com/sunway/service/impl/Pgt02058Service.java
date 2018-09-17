package com.sunway.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt02058DAO;
import com.sunway.service.IPgt02058Service;
import com.sunway.vo.Pgt02058;
import com.sunway.vo.Pgv02058;
/**
 * 商业法分区交易日期修正系数(Pgt02058)
 * @category 系统维护
 * @author LeiJia
 * @version 1.0
 */
public class Pgt02058Service implements IPgt02058Service {

	private IPgt02058DAO t02058Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02058Service#GetDeleteCommand(com.sunway.vo.Pgt02058)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02058 wjzs) throws Exception {
		return t02058Dao.GetDeleteCommand(wjzs);
	}
	
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02058Service#GetDeleteCommand(com.sunway.vo.Pgt02058)
	 */
	@Override
	public boolean GetDeleteCommandA(Pgt02058 wjzs) throws Exception {
		return t02058Dao.GetDeleteCommandA(wjzs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02058Service#GetInsertCommand(com.sunway.vo.Pgt02058)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02058 wjzs) throws Exception {
		return t02058Dao.GetInsertCommand(wjzs);
	}
	
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02058Service#GetInsertCommand(com.sunway.vo.Pgt02058)
	 */
	@Override
	public boolean GetInsertCommandA(Pgt02058 wjzs) throws Exception {
		return t02058Dao.GetInsertCommandA(wjzs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02058Service#GetUpdateCommand(com.sunway.vo.Pgt02058)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02058 wjzs) throws Exception {
		return t02058Dao.GetUpdateCommand(wjzs);
	}
	
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02058Service#GetUpdateCommand(com.sunway.vo.Pgt02058)
	 */
	public boolean GetUpdateCommandA(Pgt02058 wjzs) throws Exception {
		return t02058Dao.GetUpdateCommandA(wjzs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02058Service#LoadAll(com.sunway.vo.Pgv02058)
	 */
	@Override
	public ArrayList<Pgv02058> LoadAll(Pgv02058 wjzs) throws Exception {
		return t02058Dao.LoadAll(wjzs);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02058Service#LoadAll(com.sunway.vo.Pgv02058)
	 */
	@Override
	public ArrayList<Pgv02058> LoadAllA(Pgv02058 wjzs) throws Exception {
		return t02058Dao.LoadAllA(wjzs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02058Service#LoadByPrimaryKey(com.sunway.vo.Pgt02058)
	 */
	@Override
	public Pgt02058 LoadByPrimaryKey(Pgt02058 wjzs) throws Exception {
		return t02058Dao.LoadByPrimaryKey(wjzs);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02058Service#LoadByPrimaryKey(com.sunway.vo.Pgt02058)
	 */
	@Override
	public Pgt02058 LoadByPrimaryKeyA(Pgt02058 wjzs) throws Exception {
		return t02058Dao.LoadByPrimaryKeyA(wjzs);
	}

	/**
	 * @return the t02058Dao
	 */
	public IPgt02058DAO getT02058Dao() {
		return t02058Dao;
	}

	/**
	 * @param t02058Dao the t02058Dao to set
	 */
	public void setT02058Dao(IPgt02058DAO t02058Dao) {
		this.t02058Dao = t02058Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02058Service#ExecuteParamCopy(com.sunway.vo.Pgt02058)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt02058 wjzs) throws Exception {
		return t02058Dao.ExecuteParamCopy(wjzs);
	}

	@Override
	public Pgt02058 FormulaVal(Pgt02058 wjzs) throws Exception {
	
		return t02058Dao.FormulaVal(wjzs);
	}

	@Override
	public OutputStream ExportJYSJ(Pgv02058 v02058) throws Exception {
		
		return t02058Dao.ExportJYSJ(v02058);
	}
	
	@Override
	public OutputStream ExportJYSJA(Pgv02058 v02058) throws Exception {
		
		return t02058Dao.ExportJYSJA(v02058);
	}

	@Override
	public Pgv02058 ImportFileData(ArrayList<Pgv02058> v02058List)
			throws Exception {
		
		return t02058Dao.ImportExcelData(v02058List);
	}
	
	@Override
	public Pgv02058 ImportFileDataA(ArrayList<Pgv02058> v02058List)
			throws Exception {
		
		return t02058Dao.ImportExcelDataA(v02058List);
	}

	@Override
	public boolean GetSelDeleteCommand(Pgt02058 wjzs) throws Exception {
		
		return t02058Dao.GetSelDeleteCommand(wjzs);
	}
	
	@Override
	public boolean GetSelDeleteCommandA(Pgt02058 wjzs) throws Exception {
		
		return t02058Dao.GetSelDeleteCommandA(wjzs);
	}
	
	@Override
	public Pgt02058 FormulaVal_JQ(Pgt02058 wjzs) throws Exception {
		return t02058Dao.FormulaVal_JQ(wjzs);
	}

	@Override
	public Pgt02058 FormulaVal_XQ(Pgt02058 wjzs) throws Exception {
		return t02058Dao.FormulaVal_XQ(wjzs);
	}

	@Override
	public Pgt02058 FormulaVal_JQ_XQ(Pgt02058 wjzs) throws Exception {
		return t02058Dao.FormulaVal_JQ_XQ(wjzs);
	}


	@Override
	public Pgt02058 createByAjax(Pgt02058 v02058) throws Exception {
		return t02058Dao.createByAjax(v02058);
	}
	
	@Override
	public Pgt02058 createByAjaxA(Pgt02058 v02058) throws Exception {
		return t02058Dao.createByAjaxA(v02058);
	}


	@Override
	public Pgt02058 FormulaVal_CS_XQ(Pgt02058 wjzs) throws Exception {
		return t02058Dao.FormulaVal_CS_XQ(wjzs);
	}


	@Override
	public Pgt02058 FormulaVal_CS(Pgt02058 wjzs) throws Exception {
		return t02058Dao.FormulaVal_CS(wjzs);
	}

}
