package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00004DAO;
import com.sunway.service.IPgt00004Service;
import com.sunway.vo.Pgv00004;
import com.sunway.vo.Pgt00004;

import java.io.OutputStream;

/**
 * @category 成本法容积率
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00004Service implements IPgt00004Service, java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7231352671521803695L;
	private IPgt00004DAO t00004Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00004Service#GetDeleteCommand(com.sunway.vo.Pgt00004)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00004 rjl) throws Exception {
		return t00004Dao.GetDeleteCommand(rjl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00004Service#GetInsertCommand(com.sunway.vo.Pgt00004)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00004 rjl) throws Exception {
		return t00004Dao.GetInsertCommand(rjl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00004Service#GetUpdateCommand(com.sunway.vo.Pgt00004)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00004 rjl) throws Exception {
		return t00004Dao.GetUpdateCommand(rjl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00004Service#LoadAll(com.sunway.vo.Pgv00004)
	 */
	@Override
	public ArrayList<Pgv00004> LoadAll(Pgv00004 rjl) throws Exception {
		return t00004Dao.LoadAll(rjl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00004Service#LoadByPrimaryKey(com.sunway.vo.Pgt00004)
	 */
	@Override
	public Pgt00004 LoadByPrimaryKey(Pgt00004 rjl) throws Exception {
		return t00004Dao.LoadByPrimaryKey(rjl);
	}

	/**
	 * @return the t00004Dao
	 */
	public IPgt00004DAO getT00004Dao() {
		return t00004Dao;
	}

	/**
	 * @param t00004Dao the t00004Dao to set
	 */
	public void setT00004Dao(IPgt00004DAO t00004Dao) {
		this.t00004Dao = t00004Dao;
	}
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12006Service#ImportExcelData(java.util.ArrayList)
	 */
	@Override
	public Pgv00004 ImportExcelData(ArrayList<Pgv00004> bean) throws Exception {
		return t00004Dao.ImportExcelData(bean);
	}
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12001Service#ExportDjxxSjcx(com.sunway.vo.Pgv12001)
	 */
	@Override
	public OutputStream ExportRJLxtwh(Pgv00004 v00004) throws Exception {
		return t00004Dao.ExportRJLxtwh(v00004);
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00004Service#GetDeleteImpCommand(com.sunway.vo.Pgv00004)
	 */
	@Override
	public boolean GetDeleteImpCommand(Pgv00004 eBean) throws Exception {
		
		return t00004Dao.GetDeleteImpCommand(eBean);
	}

	@Override
	public ArrayList<Pgt00004> LoadAllMsZcYj() throws Exception {
		// TODO Auto-generated method stub
		return t00004Dao.LoadAllMsZcYj();
	}
}
