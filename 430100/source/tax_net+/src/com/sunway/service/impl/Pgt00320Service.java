package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00320DAO;
import com.sunway.service.IPgt00320Service;
import com.sunway.vo.Pgv00302;
import com.sunway.vo.Pgv00320;
import com.sunway.vo.Pgv00320e;

/**
 * 全面评估市场法国土信息
 * @author Light
 *
 */
public class Pgt00320Service implements IPgt00320Service{

	private IPgt00320DAO t00320Dao;
	
	@Override
	public ArrayList<Pgv00320> LoadAll(Pgv00320 v00320) throws Exception {
		
		return t00320Dao.LoadAll(v00320);
	}
	
	
	@Override
	public Pgv00320 ImportExcelData(ArrayList<Pgv00320> v00320List)
			throws Exception {
		
		return t00320Dao.ImportExcelData(v00320List);
	}
	
	@Override
	public Boolean GetExecPG(Pgv00320 bean) throws Exception {
		return t00320Dao.GetExecPG(bean);
	}

	@Override
	public ArrayList<Pgv00320> LoadPGList(Pgv00320 bean) throws Exception {
		
		return t00320Dao.LoadPGList(bean);
	}


	@Override
	public Pgv00320 LoadByPrimaryKey(Pgv00320 bean) throws Exception {
		
		return t00320Dao.LoadByPrimaryKey(bean);
	}


	@Override
	public ArrayList<Pgv00320> LoadPriceList(Pgv00320 bean) throws Exception {
		
		return t00320Dao.LoadPriceList(bean);
	}


	@Override
	public ArrayList<Pgv00320> LoadByLhXqdm(Pgv00320 bean) throws Exception {
		return t00320Dao.LoadByLhXqdm(bean);
	}


	@Override
	public String executeTZD(Pgv00302 bean) throws Exception {
		return t00320Dao.executeTZD(bean);
	}




	@Override
	public ArrayList<Pgv00320e> LoadQMPGZhxz(Pgv00320e v00320e)throws Exception {
		return t00320Dao.LoadQMPGZhxz(v00320e);
	}


	@Override
	public boolean GetDeleteCommand(Pgv00320 bean) throws Exception {
		return t00320Dao.GetDeleteCommand(bean);
	}


	@Override
	public boolean GetSelDeleteCommand(Pgv00320 bean) throws Exception {
		return t00320Dao.GetSelDeleteCommand(bean);
	}


	@Override
	public boolean GetUpdateCommand(Pgv00320 bean) throws Exception {
		return t00320Dao.GetUpdateCommand(bean);
	}


	@Override
	public ArrayList<Pgv00320> LoadAllDZ(Pgv00320 bean) throws Exception {
		return t00320Dao.LoadAllDZ(bean);
	}


	/********************   set && get   ********************/

	public IPgt00320DAO getT00320Dao() {
		return t00320Dao;
	}

	public void setT00320Dao(IPgt00320DAO t00320Dao) {
		this.t00320Dao = t00320Dao;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00320Service#LoadQMPGByFCXX(com.sunway.vo.Pgv00320)
	 */
	@Override
	public ArrayList<Pgv00320> LoadQMPGByFCXX(Pgv00320 v00320) throws Exception {

		return t00320Dao.LoadQMPGByFCXX(v00320);
	}

	


	

}
