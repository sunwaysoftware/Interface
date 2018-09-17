package com.sunway.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt02020DAO;
import com.sunway.service.IPgt02020Service;
import com.sunway.vo.Pgv02002;
import com.sunway.vo.Pgv02020;

/**
 * 全面评估市场法国土信息
 * @author Light
 *
 */
public class Pgt02020Service implements IPgt02020Service{

	private IPgt02020DAO t02020Dao;
	
	@Override
	public ArrayList<Pgv02020> LoadAll(Pgv02020 v02020) throws Exception {
		
		return t02020Dao.LoadAll(v02020);
	}
	
	@Override
	public ArrayList<Pgv02020> LoadAll1(Pgv02020 v02020) throws Exception {
		
		return t02020Dao.LoadAll1(v02020);
	}
	
	
	@Override
	public Pgv02020 ImportExcelData(ArrayList<Pgv02020> v02020List)
			throws Exception {
		
		return t02020Dao.ImportExcelData(v02020List);
	}
	
	@Override
	public Boolean GetExecPG(Pgv02020 bean) throws Exception {
		return t02020Dao.GetExecPG(bean);
	}


	@Override
	public Pgv02020 LoadPGJG(Pgv02020 bean) throws Exception {
		return t02020Dao.LoadPGJG(bean);
	}


	@Override
	public ArrayList<Pgv02020> LoadPGList(Pgv02020 bean) throws Exception {
		
		return t02020Dao.LoadPGList(bean);
	}


	@Override
	public Pgv02020 LoadByPrimaryKey(Pgv02020 bean) throws Exception {
		
		return t02020Dao.LoadByPrimaryKey(bean);
	}


	@Override
	public ArrayList<Pgv02020> LoadPriceList(Pgv02020 bean) throws Exception {
		
		return t02020Dao.LoadPriceList(bean);
	}


	@Override
	public ArrayList<Pgv02020> LoadByLhXqdm(Pgv02020 bean) throws Exception {
		return t02020Dao.LoadByLhXqdm(bean);
	}


	@Override
	public String executeTZD(Pgv02002 bean) throws Exception {
		return t02020Dao.executeTZD(bean);
	}


	@Override
	public boolean GetDeleteCommand(Pgv02020 bean) throws Exception {
		return t02020Dao.GetDeleteCommand(bean);
	}


	@Override
	public boolean GetSelDeleteCommand(Pgv02020 bean) throws Exception {
		return t02020Dao.GetSelDeleteCommand(bean);
	}


	@Override
	public boolean GetUpdateCommand(Pgv02020 bean) throws Exception {
		return t02020Dao.GetUpdateCommand(bean);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00303Service#GetFwtdzl(com.sunway.vo.Pgt00303)
	 */
	@Override
	public ArrayList<String> GetFwtdzl(Pgv02020 v02020) throws Exception {
		return t02020Dao.GetFwtdzl(v02020);
	}
		
	
	@Override
	public boolean GetDeleteAllCommand(Pgv02020 v02020) throws Exception {
		return t02020Dao.GetDeleteAllCommand(v02020);
	}


	@Override
	public OutputStream ExportData(Pgv02020 v02020) throws Exception {
		return t02020Dao.ExportData(v02020);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02020Service#ImportExcelDataSimple(com.sunway.vo.Pgv02020)
	 */
	@Override
	public Pgv02020 ImportExcelDataSimple(Pgv02020 v02020Bean) throws Exception {
		return t02020Dao.ImportExcelDataSimple(v02020Bean);
	}


	/********************   set && get   ********************/

	public IPgt02020DAO getT02020Dao() {
		return t02020Dao;
	}

	public void setT02020Dao(IPgt02020DAO t02020Dao) {
		this.t02020Dao = t02020Dao;
	}
}
