package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt02070DAO;
import com.sunway.service.IPgt02070Service;
import com.sunway.vo.Pgt02070;

public class Pgt02070Service implements IPgt02070Service{
	
	private IPgt02070DAO t02070Dao;

	@Override
	public boolean GetInsertCommand(Pgt02070 t02070) throws Exception {
		
		return t02070Dao.GetInsertCommand(t02070);
	}
	
	@Override
	public boolean GetDeleteCommand(Pgt02070 t02070) throws Exception {
		
		return t02070Dao.GetDeleteCommand(t02070);
	}

	@Override
	public boolean GetUpdateCommand(Pgt02070 t02070) throws Exception {
		
		return t02070Dao.GetUpdateCommand(t02070);
	}

	@Override
	public ArrayList<Pgt02070> LoadAll(Pgt02070 v02070) throws Exception {
		
		return t02070Dao.LoadAll(v02070);
	}

	@Override
	public ArrayList<Pgt02070> LoadByPrimaryKey(Pgt02070 v02070) throws Exception {
		
		return t02070Dao.LoadByPrimaryKey(v02070);
	}
	
	@Override
	public ArrayList<Pgt02070> LoadByPrimaryKey_B(Pgt02070 v02070) throws Exception {
		
		return t02070Dao.LoadByPrimaryKey_B(v02070);
	}

	public IPgt02070DAO getT02070Dao() {
		return t02070Dao;
	}

	public void setT02070Dao(IPgt02070DAO t02070Dao) {
		this.t02070Dao = t02070Dao;
	}

	/*@Override
	public boolean GetInsertCommandFPSP(Pgt02070 v02070) throws Exception {
		return t02070Dao.GetInsertCommandFPSP(v02070);
	}*/

}
