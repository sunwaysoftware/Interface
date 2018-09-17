package com.sunway.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;

import com.sunway.dao.IPgt02053DAO;
import com.sunway.service.IPgt02053Service;
import com.sunway.vo.Pgt02053;
import com.sunway.vo.Pgv02053;

/**
 * @category 商业综合修正赋值
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02053Service implements IPgt02053Service {

	private IPgt02053DAO t02053Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02053Service#GetDeleteCommand(com.sunway.vo.Pgt02053)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02053 cgxz) throws Exception {
		return t02053Dao.GetDeleteCommand(cgxz);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02053Service#GetDeleteCommand(com.sunway.vo.Pgt02053)
	 */
	@Override
	public boolean GetDeleteCommandA(Pgt02053 cgxz) throws Exception {
		return t02053Dao.GetDeleteCommandA(cgxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02053Service#GetInsertCommand(com.sunway.vo.Pgt02053)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02053 cgxz) throws Exception {
		return t02053Dao.GetInsertCommand(cgxz);
	}
	
	@Override
	public boolean GetInsertCommandA(Pgt02053 cgxz) throws Exception {
		return t02053Dao.GetInsertCommandA(cgxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02053Service#GetUpdateCommand(com.sunway.vo.Pgt02053)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02053 cgxz) throws Exception {
		return t02053Dao.GetUpdateCommand(cgxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02053Service#GetUpdateCommand(com.sunway.vo.Pgt02053)
	 */
	@Override
	public boolean GetUpdateCommandA(Pgt02053 cgxz) throws Exception {
		return t02053Dao.GetUpdateCommandA(cgxz);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02053Service#LoadAll(com.sunway.vo.Pgv02053)
	 */
	@Override
	public ArrayList<Pgv02053> LoadAll(Pgv02053 cgxz) throws Exception {
		return t02053Dao.LoadAll(cgxz);
	}
	

	public ArrayList<Pgv02053> LoadAllA(Pgv02053 cgxz) throws Exception {
		return t02053Dao.LoadAllA(cgxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02053Service#LoadByPrimaryKey(com.sunway.vo.Pgt02053)
	 */
	@Override
	public Pgt02053 LoadByPrimaryKey(Pgt02053 cgxz) throws Exception {
		return t02053Dao.LoadByPrimaryKey(cgxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02053Service#LoadByPrimaryKey(com.sunway.vo.Pgt02053)
	 */
	@Override
	public Pgt02053 LoadByPrimaryKeyA(Pgt02053 cgxz) throws Exception {
		return t02053Dao.LoadByPrimaryKeyA(cgxz);
	}

	
	/**
	 * @return the t02053Dao
	 */
	public IPgt02053DAO getT02053Dao() {
		return t02053Dao;
	}

	/**
	 * @param t02053Dao the t02053Dao to set
	 */
	public void setT02053Dao(IPgt02053DAO t02053Dao) {
		this.t02053Dao = t02053Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02053Service#ExecuteParamCopy(com.sunway.vo.Pgt02053)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt02053 cgxz) throws Exception {
		return t02053Dao.ExecuteParamCopy(cgxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02053Service#LoadObj()
	 */
	@Override
	public Map<String, String> LoadObj(Pgt02053 cgzk) throws Exception {
		return t02053Dao.LoadObj(cgzk);
	}
	
	@Override
	public OutputStream ExportT053(Pgv02053 v02053) throws Exception {
		
		return t02053Dao.ExportT053(v02053);
	}
	@Override
	public OutputStream ExportT053A(Pgv02053 v02053) throws Exception {
		
		return t02053Dao.ExportT053A(v02053);
	}

	@Override
	public Pgv02053 ImportExcelData(ArrayList<Pgv02053> v02053List)
			throws Exception {
		
		return t02053Dao.ImportExcelData(v02053List);
	}
	
	
	@Override
	public Pgv02053 ImportExcelDataA(ArrayList<Pgv02053> v02053List)
			throws Exception {
		
		return t02053Dao.ImportExcelDataA(v02053List);
	}
	
	@Override
	public boolean GetSelDeleteCommand(Pgt02053 wjzs) throws Exception {
		
		return t02053Dao.GetSelDeleteCommand(wjzs);
	}
	
	@Override
	public boolean GetSelDeleteCommandA(Pgt02053 wjzs) throws Exception {
		
		return t02053Dao.GetSelDeleteCommandA(wjzs);
	}

	@Override
	public String LoadParentIdsBySzqy(String szqy, String fwlx, String xqdm) throws Exception {
		return t02053Dao.LoadParentIdsBySzqy(szqy, fwlx, xqdm);
	}
	
}
