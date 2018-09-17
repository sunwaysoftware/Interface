package com.sunway.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt00361DAO;
import com.sunway.service.IPgt00361Service;
import com.sunway.vo.Pgt00361;
import com.sunway.vo.Pgv00361;

/**
 * 建筑成新修正系统维护
 * @author HuanWei
 *
 */
public class Pgt00361Service implements IPgt00361Service {
	
	private IPgt00361DAO t00361Dao;

	@Override
	public boolean ExecuteParamCopy(Pgt00361 test361) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean GetDeleteCommand(Pgt00361 test361) throws Exception {
		
		return t00361Dao.GetDeleteCommand(test361);
	}
	


	@Override
	public boolean GetInsertCommand(Pgt00361 test361) throws Exception {
		
		return t00361Dao.GetInsertCommand(test361);
	}
	


	@Override
	public boolean GetUpdateCommand(Pgt00361 test361) throws Exception {
		
		return t00361Dao.GetUpdateCommand(test361);
	}
	
	

	@Override
	public ArrayList<Pgv00361> LoadAll(Pgv00361 test361) throws Exception {
		
		return t00361Dao.LoadAll(test361);
	}
	
	

	@Override
	public Pgt00361 LoadByPrimaryKey(Pgt00361 test361) throws Exception {
		
		return t00361Dao.LoadByPrimaryKey(test361);
	}
	

	@Override
	public Pgt00361 LoadByPrimaryAddKey(Pgt00361 test361) throws Exception {
		
		return t00361Dao.LoadByPrimaryAddKey(test361);
	}
	
	

	public IPgt00361DAO getT00361Dao() {
		return t00361Dao;
	}

	public void setT00361Dao(IPgt00361DAO t00361Dao) {
		this.t00361Dao = t00361Dao;
	}

	@Override
	public OutputStream ExportT00361(Pgv00361 v00361) throws Exception {
	
		return t00361Dao.ExportT00361(v00361);
	}
	
	

	@Override
	public Pgv00361 ImportExcelData(ArrayList<Pgv00361> v00361List)
			throws Exception {
		
		return t00361Dao.ImportExcelData(v00361List);
	}
	
	

	@Override
	public boolean GetSelDeleteCommand(Pgt00361 test361) throws Exception {
		
		return t00361Dao.GetSelDeleteCommand(test361);
	}
	
	

}
