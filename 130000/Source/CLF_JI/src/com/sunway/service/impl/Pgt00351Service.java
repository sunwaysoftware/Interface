package com.sunway.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt00351DAO;
import com.sunway.service.IPgt00351Service;
import com.sunway.vo.ExcelBean;
import com.sunway.vo.Pgt00351;
import com.sunway.vo.Pgt00352;
import com.sunway.vo.Pgv00351;


/**
 * 
 * 市场法标准实例库
 * @category 系统维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00351Service implements IPgt00351Service {

	private IPgt00351DAO t00351Dao;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00351Service#LoadAll(com.sunway.vo.Pgv00351)
	 */
	@Override
	public ArrayList<Pgv00351> LoadAll(Pgv00351 v00351) throws Exception {
		return t00351Dao.LoadAll(v00351);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00351Service#LoadByPrimaryKey(com.sunway.vo.Pgt00351)
	 */
	@Override
	public Pgt00351 LoadByPrimaryKey(Pgt00351 t00351) throws Exception {
		return t00351Dao.LoadByPrimaryKey(t00351);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00351Service#GetInsertCommand(com.sunway.vo.Pgt00351)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00351 t00351) throws Exception {
		return t00351Dao.GetInsertCommand(t00351);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00351Service#GetUpdateCommand(com.sunway.vo.Pgt00351)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00351 t00351) throws Exception {
		return t00351Dao.GetUpdateCommand(t00351);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00351Service#GetDeleteCommand(com.sunway.vo.Pgt00351)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00351 t00351) throws Exception {
		return t00351Dao.GetDeleteCommand(t00351);
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00351Service#GetDeleteCommand(com.sunway.vo.Pgt00351)
	 */
	@Override
	public boolean GetDeleteSelCommand(Pgv00351 v00351) throws Exception {
		return t00351Dao.GetDeleteSelCommand(v00351);
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00351Service#LoadDetail(com.sunway.vo.Pgv00351)
	 */
	@Override
	public Pgv00351 LoadDetail(Pgv00351 v00351) throws Exception {
		return t00351Dao.LoadDetail(v00351);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00351Service#ExecCsSame(com.sunway.vo.Pgv00351)
	 */
	@Override
	public Boolean ExecCsSame(Pgv00351 v00351) throws Exception {
		return t00351Dao.ExecCsSame(v00351);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00351Service#LoadAllCsSame(com.sunway.vo.Pgv00351)
	 */
	@Override
	public ArrayList<Pgv00351> LoadAllCsSame(Pgv00351 v00351) throws Exception {
		return t00351Dao.LoadAllCsSame(v00351);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00351Service#LoadAllCsSameByBzfID(com.sunway.vo.Pgv00351)
	 */
	@Override
	public ArrayList<Pgv00351> LoadAllCsSameByBzfID(Pgv00351 v00351) throws Exception {
		return t00351Dao.LoadAllCsSameByBzfID(v00351);
	}
	
	/**
	 * @return the t00351Dao
	 */
	public IPgt00351DAO getT00351Dao() {
		return t00351Dao;
	}
	/**
	 * @param t00351Dao the t00351Dao to set
	 */
	public void setT00351Dao(IPgt00351DAO t00351Dao) {
		this.t00351Dao = t00351Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00351Service#LoadAllCsDiff(com.sunway.vo.Pgv00351)
	 */
	@Override
	public ArrayList<Pgv00351> LoadAllCsDiffW(Pgv00351 v00351) throws Exception {
		return t00351Dao.LoadAllCsDiffW(v00351);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00351Service#LoadAllCsDiffY(com.sunway.vo.Pgv00351)
	 */
	@Override
	public ArrayList<Pgv00351> LoadAllCsDiffY(Pgv00351 v00351) throws Exception {
		return t00351Dao.LoadAllCsDiffY(v00351);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00351Service#CreateBZF(com.sunway.vo.Pgt00351)
	 */
	@Override
	public Integer CreateBZF(Pgt00351 t00351) throws Exception {
		return t00351Dao.CreateBZF(t00351);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00351Service#LoadXqW()
	 */
	@Override
	public ArrayList<Pgt00352> LoadXqW(Pgt00351 bean) throws Exception {
		return t00351Dao.LoadXqW(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00351Service#LoadXqY()
	 */
	@Override
	public ArrayList<Pgt00352> LoadXqY(Pgt00351 bean) throws Exception {
		return t00351Dao.LoadXqY(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00351Service#ImportExcelData(java.util.ArrayList)
	 */
	@Override
	public ExcelBean ImportExcelData(ArrayList<ExcelBean> ebList)
			throws Exception {
		return t00351Dao.ImportExcelData(ebList);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00351Service#ImportBZF(com.sunway.vo.Pgt00351)
	 */
	@Override
	public Integer ImportBZF(Pgt00351 t00351) throws Exception {
		return t00351Dao.ImportBZF(t00351);
	}
	public ByteArrayOutputStream ExportbzfwhSjcx(Pgv00351 v00351)throws Exception{
    	return (ByteArrayOutputStream)t00351Dao.ExportbzfwhSjcx(v00351);
    }
	@Override
	public ArrayList<Pgv00351> findY(Pgv00351 v00351) throws Exception {
		
		return t00351Dao.findY(v00351);
	}
	@Override
	public ArrayList<Pgv00351> findN(Pgv00351 v00351) throws Exception {
		
		return t00351Dao.findN(v00351);
	}
	@Override
	public OutputStream ExportCSN(Pgv00351 v00351) throws Exception {

		return t00351Dao.ExportCSN(v00351);
	}

	@Override
	public OutputStream ExportCSY(Pgv00351 v00351) throws Exception {
		
		return t00351Dao.ExportCSY(v00351);
	}
	@Override
	public Boolean GetExecCS(Pgv00351 v00351) throws Exception {
		
		return t00351Dao.GetExecCS(v00351);
	}
}
