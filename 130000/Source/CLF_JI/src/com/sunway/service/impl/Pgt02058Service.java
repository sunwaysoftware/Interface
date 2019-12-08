package com.sunway.service.impl;

import java.util.ArrayList;
import com.sunway.dao.IPgt02058DAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPgt02058Service;
import com.sunway.vo.Pgt02058;
import com.sunway.vo.Pgv02058;

/**
 * @category 收益法综合修正
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02058Service extends BaseDAO implements IPgt02058Service {

	private IPgt02058DAO t02058Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02058Service#GetDeleteCommand(com.sunway.vo.Pgt02058)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02058 zhxz) throws Exception {
		return t02058Dao.GetDeleteCommand(zhxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02058Service#GetInsertCommand(com.sunway.vo.Pgt02058)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02058 zhxz) throws Exception {
		return t02058Dao.GetInsertCommand(zhxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02058Service#GetUpdateCommand(com.sunway.vo.Pgt02058)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02058 zhxz) throws Exception {
		return t02058Dao.GetUpdateCommand(zhxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02058Service#LoadAll(com.sunway.vo.Pgv02058)
	 */
	@Override
	public ArrayList<Pgv02058> LoadAll(Pgv02058 zhxz) throws Exception {
		return t02058Dao.LoadAll(zhxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02058Service#LoadByPrimaryKey(com.sunway.vo.Pgt02058)
	 */
	@Override
	public Pgt02058 LoadByPrimaryKey(Pgt02058 zhxz) throws Exception {
		return t02058Dao.LoadByPrimaryKey(zhxz);
	}

	/**
	 * @return the t02058Dao
	 */
	public IPgt02058DAO getT02058Dao() {
		return t02058Dao;
	}

	/**
	 * @param t02058Dao the t02058Dao to set
	 */
	public void setT02058Dao(IPgt02058DAO t02058Dao) {
		this.t02058Dao = t02058Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02058Service#ExecuteParamCopy(com.sunway.vo.Pgt02058)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt02058 zhxz) throws Exception {
		return t02058Dao.ExecuteParamCopy(zhxz);
	}

}
