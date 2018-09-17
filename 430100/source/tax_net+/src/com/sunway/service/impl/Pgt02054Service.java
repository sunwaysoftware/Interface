/**
 * 
 */
package com.sunway.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt02054DAO;
import com.sunway.service.IPgt02054Service;
import com.sunway.vo.Pgt02054;
import com.sunway.vo.Pgv02054;

/**
 * @author Andy
 *
 */
public class Pgt02054Service implements IPgt02054Service {

	private IPgt02054DAO t02054Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02054Service#GetDeleteCommand(com.sunway.vo.Pgt02054)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02054 bean) throws Exception {
		return t02054Dao.GetDeleteCommand(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02054Service#GetDeleteCommand(com.sunway.vo.Pgt02054)
	 */
	@Override
	public boolean GetDeleteCommandA(Pgt02054 bean) throws Exception {
		return t02054Dao.GetDeleteCommandA(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02054Service#GetInsertCommand(com.sunway.vo.Pgt02054)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02054 bean) throws Exception {
		return t02054Dao.GetInsertCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02054Service#GetInsertCommand(com.sunway.vo.Pgt02054)
	 */
	@Override
	public boolean GetInsertCommandA(Pgt02054 bean) throws Exception {
		return t02054Dao.GetInsertCommandA(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02054Service#GetUpdateCommand(com.sunway.vo.Pgt02054)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02054 bean) throws Exception {
		return t02054Dao.GetUpdateCommand(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02054Service#GetUpdateCommand(com.sunway.vo.Pgt02054)
	 */
	public boolean GetUpdateCommandA(Pgt02054 bean) throws Exception {
		return t02054Dao.GetUpdateCommandA(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02054Service#LoadAll(com.sunway.vo.Pgt02054)
	 */
	@Override
	public ArrayList<Pgv02054> LoadAll(Pgv02054 bean) throws Exception {
		return t02054Dao.LoadAll(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02054Service#LoadAll(com.sunway.vo.Pgt02054)
	 */
	@Override
	public ArrayList<Pgv02054> LoadAllA(Pgv02054 bean) throws Exception {
		return t02054Dao.LoadAllA(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02054Service#LoadByPrimaryKey(com.sunway.vo.Pgt02054)
	 */
	@Override
	public Pgt02054 LoadByPrimaryKey(Pgt02054 bean) throws Exception {
		return t02054Dao.LoadByPrimaryKey(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02054Service#LoadByPrimaryKey(com.sunway.vo.Pgt02054)
	 */
	@Override
	public Pgt02054 LoadByPrimaryKeyA(Pgt02054 bean) throws Exception {
		return t02054Dao.LoadByPrimaryKeyA(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02054Service#LoadByPrimaryKey(com.sunway.vo.Pgt02054)
	 */
	@Override
	public Pgt02054 LoadByPrimaryAddKey(Pgt02054 bean) throws Exception {
		return t02054Dao.LoadByPrimaryAddKey(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02054Service#LoadByPrimaryKey(com.sunway.vo.Pgt02054)
	 */
	@Override
	public Pgt02054 LoadByPrimaryAddKeyA(Pgt02054 bean) throws Exception {
		return t02054Dao.LoadByPrimaryAddKeyA(bean);
	}
	
	/**
	 * @param t02054Dao the t02054Dao to set
	 */
	public void setT02054Dao(IPgt02054DAO t02054Dao) {
		this.t02054Dao = t02054Dao;
	}

	/**
	 * @return the t02054Dao
	 */
	public IPgt02054DAO getT02054Dao() {
		return t02054Dao;
	}

	@Override
	public OutputStream ExportT02054(Pgv02054 v02054) throws Exception {
		
		return t02054Dao.ExportT02054(v02054);
	}
	
	@Override
	public OutputStream ExportT02054A(Pgv02054 v02054) throws Exception {
		
		return t02054Dao.ExportT02054A(v02054);
	}

	@Override
	public Pgv02054 ImportExcelData(ArrayList<Pgv02054> v02054List)
			throws Exception {
		
		return t02054Dao.ImportExcelData(v02054List);
	}
	
	
	@Override
	public Pgv02054 ImportExcelDataA(ArrayList<Pgv02054> v02054List)
			throws Exception {
		
		return t02054Dao.ImportExcelDataA(v02054List);
	}

	@Override
	public boolean GetSelDeleteCommand(Pgt02054 bean) throws Exception {
		
		return t02054Dao.GetSelDeleteCommand(bean);
	}
	
     public boolean GetSelDeleteCommandA(Pgt02054 bean) throws Exception {
		
		return t02054Dao.GetSelDeleteCommandA(bean);
	}
}
