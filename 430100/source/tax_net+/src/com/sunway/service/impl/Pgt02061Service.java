package com.sunway.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt02061DAO;
import com.sunway.service.IPgt02061Service;
import com.sunway.vo.ExcelBean;
import com.sunway.vo.Pgt02061;
import com.sunway.vo.Pgt02050;
import com.sunway.vo.Pgv02061;

/**
 * 
 * 市场法标准实例库
 * @category 系统维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02061Service implements IPgt02061Service {

	private IPgt02061DAO t02061Dao;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02061Service#LoadAll(com.sunway.vo.Pgv02061)
	 */
	@Override
	public ArrayList<Pgv02061> LoadAll(Pgv02061 v02061) throws Exception {
		return t02061Dao.LoadAll(v02061);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02061Service#LoadByPrimaryKey(com.sunway.vo.Pgt02061)
	 */
	@Override
	public Pgt02061 LoadByPrimaryKey(Pgt02061 t02061) throws Exception {
		return t02061Dao.LoadByPrimaryKey(t02061);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02061Service#GetInsertCommand(com.sunway.vo.Pgt02061)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02061 t02061) throws Exception {
		return t02061Dao.GetInsertCommand(t02061);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02061Service#GetUpdateCommand(com.sunway.vo.Pgt02061)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02061 t02061) throws Exception {
		return t02061Dao.GetUpdateCommand(t02061);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02061Service#GetDeleteCommand(com.sunway.vo.Pgt02061)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02061 t02061) throws Exception {
		return t02061Dao.GetDeleteCommand(t02061);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02061Service#LoadDetail(com.sunway.vo.Pgv02061)
	 */
	@Override
	public Pgv02061 LoadDetail(Pgv02061 v02061) throws Exception {
		return t02061Dao.LoadDetail(v02061);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02061Service#ExecCsSame(com.sunway.vo.Pgv02061)
	 */
	@Override
	public Boolean ExecCsSame(Pgv02061 v02061) throws Exception {
		return t02061Dao.ExecCsSame(v02061);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02061Service#LoadAllCsSame(com.sunway.vo.Pgv02061)
	 */
	@Override
	public ArrayList<Pgv02061> LoadAllCsSame(Pgv02061 v02061) throws Exception {
		return t02061Dao.LoadAllCsSame(v02061);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02061Service#LoadAllCsSameByBzfID(com.sunway.vo.Pgv02061)
	 */
	@Override
	public ArrayList<Pgv02061> LoadAllCsSameByBzfID(Pgv02061 v02061) throws Exception {
		return t02061Dao.LoadAllCsSameByBzfID(v02061);
	}
	
	/**
	 * @return the t02061Dao
	 */
	public IPgt02061DAO getT02061Dao() {
		return t02061Dao;
	}
	/**
	 * @param t02061Dao the t02061Dao to set
	 */
	public void setT02061Dao(IPgt02061DAO t02061Dao) {
		this.t02061Dao = t02061Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02061Service#LoadAllCsDiff(com.sunway.vo.Pgv02061)
	 */
	@Override
	public ArrayList<Pgv02061> LoadAllCsDiffW(Pgv02061 v02061) throws Exception {
		return t02061Dao.LoadAllCsDiffW(v02061);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02061Service#LoadAllCsDiffY(com.sunway.vo.Pgv02061)
	 */
	@Override
	public ArrayList<Pgv02061> LoadAllCsDiffY(Pgv02061 v02061) throws Exception {
		return t02061Dao.LoadAllCsDiffY(v02061);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02061Service#CreateBZF(com.sunway.vo.Pgt02061)
	 */
	@Override
	public Integer CreateBZF(Pgt02061 t02061) throws Exception {
		return t02061Dao.CreateBZF(t02061);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02061Service#LoadXqW()
	 */
	@Override
	public ArrayList<Pgt02050> LoadXqW(Pgt02061 bean) throws Exception {
		return t02061Dao.LoadXqW(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02061Service#LoadXqY()
	 */
	@Override
	public ArrayList<Pgt02050> LoadXqY(Pgt02061 bean) throws Exception {
		return t02061Dao.LoadXqY(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02061Service#ImportExcelData(java.util.ArrayList)
	 */
	@Override
	public ExcelBean ImportExcelData(ArrayList<ExcelBean> ebList)
			throws Exception {
		return t02061Dao.ImportExcelData(ebList);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02061Service#ImportBZF(com.sunway.vo.Pgt02061)
	 */
	@Override
	public Integer ImportBZF(Pgt02061 t02061) throws Exception {
		return t02061Dao.ImportBZF(t02061);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02061Service#ExportDjxx(com.sunway.vo.Pgv02061)
	 */
	@Override
	public OutputStream ExportDjxx(Pgv02061 v02061) throws Exception {
		return t02061Dao.ExportDjxx(v02061);
	}

	@Override
	public boolean GetUpdateDQBZFCommand(Pgt02061 t02061) throws Exception {
		return t02061Dao.GetUpdateDQBZFCommand(t02061);
	}

	@Override
	public Boolean GetExecCS(Pgv02061 v02061) throws Exception {
		
		return t02061Dao.GetExecCS(v02061);
	}

	@Override
	public ArrayList<Pgv02061> findN(Pgv02061 v02061) throws Exception {
		
		return t02061Dao.findN(v02061);
	}

	@Override
	public ArrayList<Pgv02061> findY(Pgv02061 v02061) throws Exception {
		
		return t02061Dao.findY(v02061);
	}
	
	@Override
	public ArrayList<Pgv02061> findYbyID(Pgv02061 v02061) throws Exception {
		
		return t02061Dao.findYbyID(v02061);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02061Service#LoadAllFwlx(com.sunway.vo.Pgv02061)
	 */
	@Override
	public ArrayList<Pgv02061> LoadAllFwlx(Pgv02061 v02061) throws Exception {
		return t02061Dao.LoadAllFwlx(v02061);
	}
	
	public ArrayList<Pgv02061> LoadAllByBZFGLXQ(Pgv02061 v02061) throws Exception{
		return t02061Dao.LoadAllByBZFGLXQ(v02061);
	}

	@Override
	public ArrayList<Pgv02061> LoadAllByBZFGLDQ(Pgv02061 v02061)
			throws Exception {
		
		return t02061Dao.LoadAllByBZFGLDQ(v02061);
	}

	@Override
	public OutputStream ExportCSN(Pgv02061 v02061) throws Exception {

		return t02061Dao.ExportCSN(v02061);
	}

	@Override
	public OutputStream ExportCSY(Pgv02061 v02061) throws Exception {
		
		return t02061Dao.ExportCSY(v02061);
	}

	@Override
	public boolean ExecuteBZFDQCS(Pgv02061 v02061) throws Exception {
		
		return t02061Dao.ExecuteDQCS(v02061);
	}

	@Override
	public boolean ValiBZF(Pgv02061 v02061) throws Exception {
		
		return t02061Dao.ValiBZF(v02061);
	}

	@Override
	public boolean GetSelDeleteCommand(Pgt02061 t02061) throws Exception {
		
		return t02061Dao.GetSelDeleteCommand(t02061);
	}

	@Override
	public boolean GetDeleteAllCommand(Pgv02061 v02061) throws Exception {
		return t02061Dao.GetDeleteAllCommand(v02061);
	}

}
