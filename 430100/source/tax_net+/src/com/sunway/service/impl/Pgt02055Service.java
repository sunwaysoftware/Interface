/**
 * 
 */
package com.sunway.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt02055DAO;
import com.sunway.service.IPgt02055Service;
import com.sunway.vo.Pgt02055;
import com.sunway.vo.Pgv02055;

/**
 * @author Andy
 *
 */
public class Pgt02055Service implements IPgt02055Service {

	private IPgt02055DAO t02055Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02055Service#GetDeleteCommand(com.sunway.vo.Pgt02055)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02055 bean) throws Exception {
		return t02055Dao.GetDeleteCommand(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02055Service#GetDeleteCommand(com.sunway.vo.Pgt02055)
	 */
	@Override
	public boolean GetDeleteCommandA(Pgt02055 bean) throws Exception {
		return t02055Dao.GetDeleteCommandA(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02055Service#GetInsertCommand(com.sunway.vo.Pgt02055)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02055 bean) throws Exception {
		return t02055Dao.GetInsertCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02055Service#GetInsertCommand(com.sunway.vo.Pgt02055)
	 */
	@Override
	public boolean GetInsertCommandA(Pgt02055 bean) throws Exception {
		return t02055Dao.GetInsertCommandA(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02055Service#GetUpdateCommand(com.sunway.vo.Pgt02055)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02055 bean) throws Exception {
		return t02055Dao.GetUpdateCommand(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02055Service#GetUpdateCommand(com.sunway.vo.Pgt02055)
	 */
	public boolean GetUpdateCommandA(Pgt02055 bean) throws Exception {
		return t02055Dao.GetUpdateCommandA(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02055Service#LoadAll(com.sunway.vo.Pgt02055)
	 */
	@Override
	public ArrayList<Pgv02055> LoadAll(Pgv02055 bean) throws Exception {
		return t02055Dao.LoadAll(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02055Service#LoadAll(com.sunway.vo.Pgt02055)
	 */
	@Override
	public ArrayList<Pgv02055> LoadAllA(Pgv02055 bean) throws Exception {
		return t02055Dao.LoadAllA(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02055Service#LoadByPrimaryKey(com.sunway.vo.Pgt02055)
	 */
	@Override
	public Pgt02055 LoadByPrimaryKey(Pgt02055 bean) throws Exception {
		return t02055Dao.LoadByPrimaryKey(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02055Service#LoadByPrimaryKey(com.sunway.vo.Pgt02055)
	 */
	@Override
	public Pgt02055 LoadByPrimaryKeyA(Pgt02055 bean) throws Exception {
		return t02055Dao.LoadByPrimaryKeyA(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02055Service#LoadByPrimaryKey(com.sunway.vo.Pgt02055)
	 */
	@Override
	public Pgt02055 LoadByPrimaryAddKey(Pgt02055 bean) throws Exception {
		return t02055Dao.LoadByPrimaryAddKey(bean);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02055Service#LoadByPrimaryKey(com.sunway.vo.Pgt02055)
	 */
	@Override
	public Pgt02055 LoadByPrimaryAddKeyA(Pgt02055 bean) throws Exception {
		return t02055Dao.LoadByPrimaryAddKeyA(bean);
	}
	
	/**
	 * @param t02055Dao the t02055Dao to set
	 */
	public void setT02055Dao(IPgt02055DAO t02055Dao) {
		this.t02055Dao = t02055Dao;
	}

	/**
	 * @return the t02055Dao
	 */
	public IPgt02055DAO getT02055Dao() {
		return t02055Dao;
	}

	@Override
	public OutputStream ExportT02055(Pgv02055 v02055) throws Exception {
		
		return t02055Dao.ExportT02055(v02055);
	}
	
	@Override
	public OutputStream ExportT02055A(Pgv02055 v02055) throws Exception {
		
		return t02055Dao.ExportT02055A(v02055);
	}

	@Override
	public Pgv02055 ImportExcelData(ArrayList<Pgv02055> v02055List)
			throws Exception {
		
		return t02055Dao.ImportExcelData(v02055List);
	}
	
	
	@Override
	public Pgv02055 ImportExcelDataA(ArrayList<Pgv02055> v02055List)
			throws Exception {
		
		return t02055Dao.ImportExcelDataA(v02055List);
	}

	@Override
	public boolean GetSelDeleteCommand(Pgt02055 bean) throws Exception {
		
		return t02055Dao.GetSelDeleteCommand(bean);
	}
	
	@Override
    public boolean GetSelDeleteCommandA(Pgt02055 bean) throws Exception {
		
		return t02055Dao.GetSelDeleteCommandA(bean);
	}
}
