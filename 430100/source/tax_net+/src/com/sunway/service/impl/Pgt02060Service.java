package com.sunway.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt02060DAO;
import com.sunway.service.IPgt02060Service;
import com.sunway.vo.Pgv02002;
import com.sunway.vo.Pgv02060;

/**
 * 全面评估市场法国土信息
 * @author Light
 *
 */
public class Pgt02060Service implements IPgt02060Service{

	private IPgt02060DAO t02060Dao;
	
	@Override
	public ArrayList<Pgv02060> LoadAll(Pgv02060 v02060) throws Exception {
		
		return t02060Dao.LoadAll(v02060);
	}
	
	
	@Override
	public Pgv02060 ImportExcelData(ArrayList<Pgv02060> v02060List)
			throws Exception {
		
		return t02060Dao.ImportExcelData(v02060List);
	}
	
	@Override
	public Boolean GetExecPG(Pgv02060 bean) throws Exception {
		return t02060Dao.GetExecPG(bean);
	}


	@Override
	public Pgv02060 LoadPGJG(Pgv02060 bean) throws Exception {
		return t02060Dao.LoadPGJG(bean);
	}


	@Override
	public ArrayList<Pgv02060> LoadPGList(Pgv02060 bean) throws Exception {
		
		return t02060Dao.LoadPGList(bean);
	}


	@Override
	public Pgv02060 LoadByPrimaryKey(Pgv02060 bean) throws Exception {
		
		return t02060Dao.LoadByPrimaryKey(bean);
	}


	@Override
	public ArrayList<Pgv02060> LoadPriceList(Pgv02060 bean) throws Exception {
		
		return t02060Dao.LoadPriceList(bean);
	}


	@Override
	public ArrayList<Pgv02060> LoadByLhXqdm(Pgv02060 bean) throws Exception {
		return t02060Dao.LoadByLhXqdm(bean);
	}


	@Override
	public String executeTZD(Pgv02002 bean) throws Exception {
		return t02060Dao.executeTZD(bean);
	}


	@Override
	public boolean GetDeleteCommand(Pgv02060 bean) throws Exception {
		return t02060Dao.GetDeleteCommand(bean);
	}


	@Override
	public boolean GetSelDeleteCommand(Pgv02060 bean) throws Exception {
		return t02060Dao.GetSelDeleteCommand(bean);
	}


	@Override
	public boolean GetUpdateCommand(Pgv02060 bean) throws Exception {
		return t02060Dao.GetUpdateCommand(bean);
	}	
	
	@Override
	public boolean GetDeleteAllCommand(Pgv02060 v02060) throws Exception {
		return t02060Dao.GetDeleteAllCommand(v02060);
	}


	@Override
	public OutputStream ExportData(Pgv02060 v02060) throws Exception {
		return t02060Dao.ExportData(v02060);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02060Service#ImportExcelDataSimple(com.sunway.vo.Pgv02060)
	 */
	@Override
	public Pgv02060 ImportExcelDataSimple(Pgv02060 v02060Bean) throws Exception {
		return t02060Dao.ImportExcelDataSimple(v02060Bean);
	}


	/********************   set && get   ********************/

	public IPgt02060DAO getT02060Dao() {
		return t02060Dao;
	}

	public void setT02060Dao(IPgt02060DAO t02060Dao) {
		this.t02060Dao = t02060Dao;
	}
}
