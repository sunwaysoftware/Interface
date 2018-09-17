/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00304DAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPgt00304Service;
import com.sunway.vo.Pgt00304;
import com.sunway.vo.Pgt00304a;
import com.sunway.vo.Pgv00304;

/**
 * @author one
 *
 */
public class Pgt00304Service extends BaseDAO implements IPgt00304Service {

	private IPgt00304DAO t00304Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00304Service#GetDeleteCommand(com.sunway.vo.Pgt00304)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00304 gpsj) throws Exception {
		return t00304Dao.GetDeleteCommand(gpsj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00304Service#GetInsertCommand(com.sunway.vo.Pgt00304)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00304 gpsj) throws Exception {
		return t00304Dao.GetInsertCommand(gpsj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00304Service#GetUpdateCommand(com.sunway.vo.Pgt00304)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00304 gpsj) throws Exception {
		return t00304Dao.GetUpdateCommand(gpsj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00304Service#LoadAll(com.sunway.vo.Pgv00304)
	 */
	@Override
	public ArrayList<Pgv00304> LoadAll(Pgv00304 gpsj) throws Exception {
		return t00304Dao.LoadAll(gpsj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00304Service#LoadByPrimaryKey(com.sunway.vo.Pgt00304)
	 */
	@Override
	public Pgt00304 LoadByPrimaryKey(Pgt00304 gpsj) throws Exception {
		return t00304Dao.LoadByPrimaryKey(gpsj);
	}

	/**
	 * @return the t00304Dao
	 */
	public IPgt00304DAO getT00304Dao() {
		return t00304Dao;
	}

	/**
	 * @param t00304Dao the t00304Dao to set
	 */
	public void setT00304Dao(IPgt00304DAO t00304Dao) {
		this.t00304Dao = t00304Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00304Service#LoadAlla(com.sunway.vo.Pgt00304a)
	 */
	@Override
	public ArrayList<Pgt00304a> LoadAlla(Pgt00304a gpsj) throws Exception {
		return t00304Dao.LoadAlla(gpsj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00304Service#LoadDetail(com.sunway.vo.Pgv00304)
	 */
	@Override
	public Pgv00304 LoadDetail(Pgv00304 gpsj) throws Exception {
		return t00304Dao.LoadDetail(gpsj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00304Service#ImportExcelData(java.util.ArrayList)
	 */
	@Override
	public Pgv00304 ImportExcelData(ArrayList<Pgv00304> gpsjList) throws Exception{
		// TODO Auto-generated method stub
		return t00304Dao.ImportExcelData(gpsjList);
	}

}
