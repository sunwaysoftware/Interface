package com.sunway.service.impl;

import java.util.ArrayList;
import com.sunway.dao.IPgt02057DAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPgt02057Service;
import com.sunway.vo.Pgt02057;
import com.sunway.vo.Pgv02057;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
/**
 * @category 收益法资本化率
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02057Service extends BaseDAO implements IPgt02057Service, java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3616519397213795090L;
	private IPgt02057DAO t02057Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02057Service#GetDeleteCommand(com.sunway.vo.Pgt02057)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02057 zbhl) throws Exception {
		return t02057Dao.GetDeleteCommand(zbhl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02057Service#GetInsertCommand(com.sunway.vo.Pgt02057)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02057 zbhl) throws Exception {
		return t02057Dao.GetInsertCommand(zbhl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02057Service#GetUpdateCommand(com.sunway.vo.Pgt02057)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02057 zbhl) throws Exception {
		return t02057Dao.GetUpdateCommand(zbhl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02057Service#LoadAll(com.sunway.vo.Pgv02057)
	 */
	@Override
	public ArrayList<Pgv02057> LoadAll(Pgv02057 zbhl) throws Exception {
		return t02057Dao.LoadAll(zbhl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02057Service#LoadByPrimaryKey(com.sunway.vo.Pgt02057)
	 */
	@Override
	public Pgt02057 LoadByPrimaryKey(Pgt02057 zbhl) throws Exception {
		return t02057Dao.LoadByPrimaryKey(zbhl);
	}

	/**
	 * @return the t02057Dao
	 */
	public IPgt02057DAO getT02057Dao() {
		return t02057Dao;
	}

	/**
	 * @param t02057Dao the t02057Dao to set
	 */
	public void setT02057Dao(IPgt02057DAO t02057Dao) {
		this.t02057Dao = t02057Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02057Service#ExecuteParamCopy(com.sunway.vo.Pgt02057)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt02057 zbhl) throws Exception {
		return t02057Dao.ExecuteParamCopy(zbhl);
	}
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02057Service#ImportExcelData(java.util.ArrayList)
	 */
	@Override
	public Pgv02057 ImportExcelData(ArrayList<Pgv02057> v02057List) throws Exception {
		return t02057Dao.ImportExcelData(v02057List);
	}
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12001Service#ExportDjxxSjcx(com.sunway.vo.Pgv12001)
	 */
	@Override
	public OutputStream ExportZBHLxtwh(Pgv02057 v02057) throws Exception {
		return t02057Dao.ExportZBHLxtwh(v02057);
	}
/*
 * (non-Javadoc)
 * @see com.sunway.service.IPgt02057Service#GetDeleteImpCommand(com.sunway.vo.ExcelBean)
 */

	@Override
	public ArrayList<Pgv02057> LoadAllA(Pgv02057 v02057) throws Exception {
		// TODO Auto-generated method stub
		return t02057Dao.LoadAllA(v02057);
	}

	@Override
	public Pgt02057 LoadByPrimaryKeyA(Pgt02057 t02057) throws Exception {
		// TODO Auto-generated method stub
		return t02057Dao.LoadByPrimaryKeyA(t02057);
	}

	@Override
	public boolean GetInsertCommandA(Pgt02057 t02057Bean) throws Exception {
		// TODO Auto-generated method stub
		return t02057Dao.GetInsertCommandA(t02057Bean);
	}

	@Override
	public boolean GetUpdateCommandA(Pgt02057 t02057Bean) throws Exception {
		// TODO Auto-generated method stub
		return t02057Dao.GetUpdateCommandA(t02057Bean);
	}

	@Override
	public boolean GetDeleteCommandA(Pgt02057 t02057Bean) throws Exception {
		// TODO Auto-generated method stub
		return t02057Dao.GetDeleteCommandA(t02057Bean);
	}

	@Override
	public Pgv02057 ImportExcelDataA(ArrayList<Pgv02057> v02057List) throws Exception {
		// TODO Auto-generated method stub
		return t02057Dao.ImportExcelDataA(v02057List);
	}

	@Override
	public boolean GetSelDeleteCommand(Pgt02057 t02057) throws Exception {
		// TODO Auto-generated method stub
		return t02057Dao.GetSelDeleteCommand(t02057);
	}

	@Override
	public boolean GetSelDeleteCommandA(Pgt02057 t02057) throws Exception {
		// TODO Auto-generated method stub
		return t02057Dao.GetSelDeleteCommandA(t02057);
	}

	@Override
	public ByteArrayOutputStream ExportJYSJ(Pgv02057 v02057) throws Exception {
		// TODO Auto-generated method stub
		return t02057Dao.ExportJYSJ(v02057);
	}

	@Override
	public ByteArrayOutputStream ExportJYSJA(Pgv02057 v02057) throws Exception {
		// TODO Auto-generated method stub
		return t02057Dao.ExportJYSJA(v02057);
	}	
	
}
