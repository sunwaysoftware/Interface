package com.sunway.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt00362DAO;
import com.sunway.service.IPgt00362Service;
import com.sunway.vo.Pgt00362;
import com.sunway.vo.Pgv00362;
/**
 * 建筑结构修正系统维护
 * @author HuanWei
 *
 */
public class Pgt00362Service implements IPgt00362Service {
	
	private IPgt00362DAO t00362Dao;

	

	public IPgt00362DAO getT00362Dao() {
		return t00362Dao;
	}

	public void setT00362Dao(IPgt00362DAO t00362Dao) {
		this.t00362Dao = t00362Dao;
	}

	@Override
	public boolean ExecuteParamCopy(Pgt00362 t00362) throws Exception {
		
		return t00362Dao.ExecuteParamCopy(t00362);
	}

	@Override
	public boolean GetDeleteCommand(Pgt00362 t00362) throws Exception {
		
		return t00362Dao.GetDeleteCommand(t00362);
	}
	
	

	@Override
	public boolean GetInsertCommand(Pgt00362 t00362) throws Exception {
		
		return t00362Dao.GetInsertCommand(t00362);
	}
	
	

	@Override
	public boolean GetUpdateCommand(Pgt00362 t00362) throws Exception {
		
		return t00362Dao.GetUpdateCommand(t00362);
	}
	
	
	@Override
	public ArrayList<Pgv00362> LoadAll(Pgv00362 v00362) throws Exception {
		
		return t00362Dao.LoadAll(v00362);
	}

	
	@Override
	public Pgt00362 LoadByPrimaryKey(Pgt00362 t00362) throws Exception {
		
		return t00362Dao.LoadByPrimaryKey(t00362);
	}
	
	
	
	@Override
	public Pgt00362 LoadByPrimaryAddKey(Pgt00362 t00362) throws Exception {
		
		return t00362Dao.LoadByPrimaryAddKey(t00362);
	}
	


	@Override
	public OutputStream ExportJZJG(Pgv00362 v00362) throws Exception {
		
		return t00362Dao.ExportJZJG(v00362);
	}

	
	@Override
	public Pgv00362 ImportExcelData(ArrayList<Pgv00362> v00362List)
			throws Exception {
		
		return t00362Dao.ImportExcelData(v00362List);
	}
	
	
	

	@Override
	public boolean GetSelDeleteCommand(Pgt00362 t00362) throws Exception {
		
		return t00362Dao.GetSelDeleteCommand(t00362);
	}
	
	

}
