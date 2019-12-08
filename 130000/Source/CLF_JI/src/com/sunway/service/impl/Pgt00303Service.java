package com.sunway.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt00303DAO;
import com.sunway.service.IPgt00303Service;
import com.sunway.util.Common;
import com.sunway.vo.ExcelBean;
import com.sunway.vo.Pgt00303;
import com.sunway.vo.Pgv00303;


/**
 * 市场法楼房信息表维护
 * @author Lee
 * @version 1.0
 */
public class Pgt00303Service implements IPgt00303Service {

	private IPgt00303DAO t00303Dao;

	@Override
	public ArrayList<Pgv00303> LoadAll(Pgv00303 v00303) throws Exception {
		return t00303Dao.LoadAll(v00303);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00303Service#LoadByPrimaryKey(com.sunway.vo.Pgt00303)
	 */
	@Override
	public Pgt00303 LoadByPrimaryKey(Pgt00303 t00303) throws Exception {
		return t00303Dao.LoadByPrimaryKey(t00303);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00303Service#GetInsertCommand(com.sunway.vo.Pgt00303)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00303 t00303) throws Exception {
		t00303.setLfid(t00303Dao.LoadMaxLfId());
		return t00303Dao.GetInsertCommand(t00303);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00303Service#GetDeleteCommand(com.sunway.vo.Pgt00303)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00303 t00303) throws Exception {
		return t00303Dao.GetDeleteCommand(t00303);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00303Service#GetUpdateCommand(com.sunway.vo.Pgt00303)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00303 t00303) throws Exception {
		return t00303Dao.GetUpdateCommand(t00303);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00303Service#GetFwtdzl(com.sunway.vo.Pgt00303)
	 */
	@Override
	public ArrayList<String> GetFwtdzl(Pgv00303 v00303) throws Exception {
		return t00303Dao.GetFwtdzl(v00303);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00303Service#GetHbInitList(java.lang.String)
	 */
	@Override
	public ArrayList<Pgv00303> GetHbInitList(String hbLfidList) throws Exception {
		return t00303Dao.GetHbInitList(hbLfidList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00303Service#GetHBCommand(com.sunway.vo.Pgt00303)
	 */
	@Override
	public boolean GetHBCommand(Pgt00303 t00303) throws Exception {
		if(Common.isNullOrEmpty(t00303.getLfid())){
			t00303.setLfid(t00303Dao.LoadMaxLfId());
		}
		return t00303Dao.GetHBCommand(t00303);
	}

	/**
	 * @return the t00303Dao
	 */
	public IPgt00303DAO getT00303Dao() {
		return t00303Dao;
	}
	/**
	 * @param t00303Dao the t00303Dao to set
	 */
	public void setT00303Dao(IPgt00303DAO t00303Dao) {
		this.t00303Dao = t00303Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00303Service#GetLFID(com.sunway.vo.Pgv00303)
	 */
	@Override
	public Pgv00303 GetLFID(Pgv00303 v00303) throws Exception {
		return t00303Dao.GetLFID(v00303);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00303Service#GetFWDZ(com.sunway.vo.Pgv00303)
	 */
	@Override
	public Pgv00303 GetFWDZ(Pgv00303 v00303) throws Exception {
		return t00303Dao.GetFWDZ(v00303);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00303Service#ImportExcelData(java.util.ArrayList)
	 */
	@Override
	public ExcelBean ImportExcelData(ArrayList<ExcelBean> ebList)
			throws Exception {
		return t00303Dao.ImportExcelData(ebList);
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00352Service#ExportGJFQSjcx(com.sunway.vo.Pgv00352)
	 */
	@Override
	public ByteArrayOutputStream ExportlfpcSjcx(Pgv00303 v00303) throws Exception {

		return (ByteArrayOutputStream) t00303Dao.ExportlfpcSjcx(v00303);
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00303Service#GetDyhdz(com.sunway.vo.Pgv00303)
	 */
	@Override
	public ArrayList<String> GetDyhdz(Pgv00303 v00303) throws Exception {
		
		return t00303Dao.GetDyhdz(v00303);
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00303Service#GetFhdz(com.sunway.vo.Pgv00303)
	 */
	@Override
	public ArrayList<String> GetFhdz(Pgv00303 v00303) throws Exception {
		
		return t00303Dao.GetFhdz(v00303);
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00303Service#GetLhdz(com.sunway.vo.Pgv00303)
	 */
	@Override
	public ArrayList<String> GetLhdz(Pgv00303 v00303) throws Exception {
		
		return t00303Dao.GetLhdz(v00303);
	}
}
