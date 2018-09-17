package com.sunway.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt02063DAO;
import com.sunway.service.IPgt02063Service;
import com.sunway.vo.Pgt02063;
import com.sunway.vo.Pgv02063;


/**
 * 评估方法权重比维护
 * @author LeiJia
 *
 */
public class Pgt02063Service implements IPgt02063Service {

	
	private IPgt02063DAO t02063Dao;
	
	/**
	 * 
	 * @return the t02063Dao
	 */
	public IPgt02063DAO getT02063Dao() {
		return t02063Dao;
	}

	/**
	 * 
	 * @param t02063Dao the t02063Dao to set
	 */
	public void setT02063Dao(IPgt02063DAO t02063Dao) {
		this.t02063Dao = t02063Dao;
	}

	

	@Override
	public boolean GetDeleteCommand(Pgt02063 t02063) throws Exception {
		
		return t02063Dao.GetDeleteCommand(t02063);
	}

	@Override
	public boolean GetInsertCommand(Pgt02063 t02063) throws Exception {
		
		return t02063Dao.GetInsertCommand(t02063);
	}

	@Override
	public boolean GetUpdateCommand(Pgt02063 t02063) throws Exception {
		
		return t02063Dao.GetUpdateCommand(t02063);
	}

	@Override
	public ArrayList<Pgv02063> LoadAll(Pgv02063 v02063) throws Exception {
		
		return t02063Dao.LoadAll(v02063);
	}

	@Override
	public Pgt02063 LoadByPrimaryKey(Pgt02063 t02063) throws Exception {
		
		return t02063Dao.LoadByPrimaryKey(t02063);
	}

	@Override
	public Pgv02063 ImportExcelData(ArrayList<Pgv02063> pgv02063List) throws Exception {
		return t02063Dao.ImportExcelData(pgv02063List);
	}

	@Override
	public ByteArrayOutputStream ExportQzb(Pgv02063 v02063) throws Exception {
		return t02063Dao.ExportQzb(v02063);
	}

}
