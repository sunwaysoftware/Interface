/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12003DAO;
import com.sunway.service.IPgt12003Service;
import com.sunway.vo.Pgt12003;
import com.sunway.vo.Pgv12003;

/**
 * 
 * 成本法、收益法房地产信息
 * @author Andy.Gao
 *
 */
public class Pgt12003Service implements IPgt12003Service {

	private IPgt12003DAO t12003Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12003Service#GetDeleteCommand(com.sunway.vo.Pgt12003)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt12003 t12003) throws Exception {
		return t12003Dao.GetDeleteCommand(t12003);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12003Service#GetInsertCommand(com.sunway.vo.Pgt12003)
	 */
	@Override
	public boolean GetInsertCommand(Pgt12003 t12003) throws Exception {
		return t12003Dao.GetInsertCommand(t12003);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12003Service#GetUpdateCommand(com.sunway.vo.Pgt12003)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt12003 t12003) throws Exception {
		return t12003Dao.GetUpdateCommand(t12003);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12003Service#LoadAll(com.sunway.vo.Pgv12003)
	 */
	@Override
	public Pgv12003 LoadAll(Pgv12003 v12003) throws Exception {
		return t12003Dao.LoadAll(v12003);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12003Service#LoadByPrimaryKey(com.sunway.vo.Pgt12003)
	 */
	@Override
	public Pgt12003 LoadByPrimaryKey(Pgt12003 t12003) throws Exception {
		return t12003Dao.LoadByPrimaryKey(t12003);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12003Service#LoadMaxFcId()
	 */
	@Override
	public String LoadMaxFcId() throws Exception {
		return t12003Dao.LoadMaxFcId();
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12003Service#LoadDetail(com.sunway.vo.Pgv12003)
	 */
	@Override
	public Pgv12003 LoadDetail(Pgv12003 v12003) throws Exception {
		return t12003Dao.LoadDetail(v12003);
	}

	/**
	 * @param t12003Dao the t12003Dao to set
	 */
	public void setT12003Dao(IPgt12003DAO t12003Dao) {
		this.t12003Dao = t12003Dao;
	}

	/**
	 * @return the t12003Dao
	 */
	public IPgt12003DAO getT12003Dao() {
		return t12003Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12003Service#GetFczhByFcid(com.sunway.vo.Pgt12003)
	 */
	@Override
	public Boolean GetFczhByFcid(Pgt12003 t12003) throws Exception {
		return t12003Dao.GetFczhByFcid(t12003);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12003Service#LoadFWZLDZ(com.sunway.vo.Pgv12003)
	 */
	@Override
	public ArrayList<String> LoadFWZLDZ(Pgv12003 v12003) throws Exception {
		return t12003Dao.LoadFWZLDZ(v12003);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt12003Service#LoadPgv120035(com.sunway.vo.Pgv12003)
	 */
	@Override
	public Pgv12003 LoadPgv120035(Pgv12003 v12003) throws Exception{
		return t12003Dao.LoadPgv120035(v12003);
	}
}
