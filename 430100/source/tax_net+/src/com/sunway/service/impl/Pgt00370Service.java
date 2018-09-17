package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00370DAO;
import com.sunway.service.IPgt00370Service;
import com.sunway.vo.Pgt00370;
import com.sunway.vo.Pgv00370;

public class Pgt00370Service implements IPgt00370Service{
	
	private IPgt00370DAO t00370Dao;

	@Override
	public boolean GetInsertCommand(Pgt00370 t00370) throws Exception {
		
		return t00370Dao.GetInsertCommand(t00370);
	}
	
	@Override
	public boolean GetDeleteCommand(Pgt00370 t00370) throws Exception {
		
		return t00370Dao.GetDeleteCommand(t00370);
	}

	@Override
	public boolean GetUpdateCommand(Pgt00370 t00370) throws Exception {
		
		return t00370Dao.GetUpdateCommand(t00370);
	}

	@Override
	public ArrayList<Pgv00370> LoadAll(Pgv00370 v00370) throws Exception {
		
		return t00370Dao.LoadAll(v00370);
	}

	@Override
	public ArrayList<Pgv00370> LoadByPrimaryKey(Pgv00370 v00370) throws Exception {
		
		return t00370Dao.LoadByPrimaryKey(v00370);
	}
	
	@Override
	public ArrayList<Pgv00370> LoadByPrimaryKey_B(Pgv00370 v00370) throws Exception {
		
		return t00370Dao.LoadByPrimaryKey_B(v00370);
	}

	public IPgt00370DAO getT00370Dao() {
		return t00370Dao;
	}

	public void setT00370Dao(IPgt00370DAO t00370Dao) {
		this.t00370Dao = t00370Dao;
	}

	@Override
	public boolean GetInsertCommandFPSP(Pgv00370 v00370) throws Exception {
		return t00370Dao.GetInsertCommandFPSP(v00370);
	}

}
