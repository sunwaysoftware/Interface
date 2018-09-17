/**
 * 
 */
package com.sunway.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt02052DAO;
import com.sunway.service.IPgt02052Service;
import com.sunway.vo.Pgt02052;
import com.sunway.vo.Pgv02052;

/**
 * @category 商业建筑层次修正
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02052Service implements IPgt02052Service {

	private IPgt02052DAO t02052Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02052Service#GetDeleteCommand(com.sunway.vo.Pgt02052)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02052 lcxs) throws Exception {
		return t02052Dao.GetDeleteCommand(lcxs);
	}
	
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02052Service#GetDeleteCommand(com.sunway.vo.Pgt02052)
	 */
	@Override
	public boolean GetDeleteCommandA(Pgt02052 lcxs) throws Exception {
		return t02052Dao.GetDeleteCommandA(lcxs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02052Service#GetInsertCommand(com.sunway.vo.Pgt02052)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02052 lcxs) throws Exception {
		return t02052Dao.GetInsertCommand(lcxs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02052Service#GetInsertCommand(com.sunway.vo.Pgt02052)
	 */
	@Override
	public boolean GetInsertCommandA(Pgt02052 lcxs) throws Exception {
		return t02052Dao.GetInsertCommandA(lcxs);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02052Service#GetUpdateCommand(com.sunway.vo.Pgt02052)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02052 lcxs) throws Exception {
		return t02052Dao.GetUpdateCommand(lcxs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02052Service#GetUpdateCommand(com.sunway.vo.Pgt02052)
	 */
	@Override
	public boolean GetUpdateCommandA(Pgt02052 lcxs) throws Exception {
		return t02052Dao.GetUpdateCommandA(lcxs);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02052Service#LoadAll(com.sunway.vo.Pgv02052)
	 */
	@Override
	public ArrayList<Pgv02052> LoadAll(Pgv02052 lcxs) throws Exception {
		return t02052Dao.LoadAll(lcxs);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02052Service#LoadAll(com.sunway.vo.Pgv02052)
	 */
	@Override
	public ArrayList<Pgv02052> LoadAllA(Pgv02052 lcxs) throws Exception {
		return t02052Dao.LoadAllA(lcxs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02052Service#LoadByPrimaryKey(com.sunway.vo.Pgt02052)
	 */
	@Override
	public Pgt02052 LoadByPrimaryKey(Pgt02052 lcxs) throws Exception {
		return t02052Dao.LoadByPrimaryKey(lcxs);
	}	
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02052Service#LoadByPrimaryKey(com.sunway.vo.Pgt02052)
	 */
	@Override
	public Pgt02052 LoadByPrimaryAddKey(Pgt02052 lcxs) throws Exception {
		return t02052Dao.LoadByPrimaryAddKey(lcxs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02052Service#LoadByPrimaryKey(com.sunway.vo.Pgt02052)
	 */
	@Override
	public Pgt02052 LoadByPrimaryKeyA(Pgt02052 lcxs) throws Exception {
		return t02052Dao.LoadByPrimaryKeyA(lcxs);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02052Service#LoadByPrimaryKey(com.sunway.vo.Pgt02052)
	 */
	@Override
	public Pgt02052 LoadByPrimaryAddKeyA(Pgt02052 lcxs) throws Exception {
		return t02052Dao.LoadByPrimaryAddKeyA(lcxs);
	}
	
	/**
	 * @return the t02052Dao
	 */
	public IPgt02052DAO getT02052Dao() {
		return t02052Dao;
	}

	/**
	 * @param t02052Dao the t02052Dao to set
	 */
	public void setT02052Dao(IPgt02052DAO t02052Dao) {
		this.t02052Dao = t02052Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02052Service#ExecuteParamCopy(com.sunway.vo.Pgt02052)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt02052 lcxs) throws Exception {
		return t02052Dao.ExecuteParamCopy(lcxs);
	}

	@Override
	public OutputStream ExportT052(Pgv02052 v02052) throws Exception {
		
		return t02052Dao.ExportT052(v02052);
	}

	@Override
	public OutputStream ExportT052A(Pgv02052 v02052) throws Exception {
		
		return t02052Dao.ExportT052A(v02052);
	}

	
	@Override
	public Pgv02052 ImportExcelData(ArrayList<Pgv02052> v02052List)throws Exception {
		
		return t02052Dao.ImportExcelData(v02052List);
	}

	@Override
	public Pgv02052 ImportExcelDataA(ArrayList<Pgv02052> v02052List)throws Exception {
		
		return t02052Dao.ImportExcelDataA(v02052List);
	}
	
	
	@Override
	public boolean GetSelDeleteCommand(Pgt02052 lcxs) throws Exception {
		
		return t02052Dao.GetSelDeleteCommand(lcxs);
	}
	@Override
	public boolean GetSelDeleteCommandA(Pgt02052 lcxs) throws Exception {
		
		return t02052Dao.GetSelDeleteCommandA(lcxs);
	}
	

}
