package com.sunway.service.impl;

import java.util.ArrayList;
import com.sunway.dao.IPgt02056DAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPgt02056Service;
import com.sunway.vo.Pgt02056;
import com.sunway.vo.Pgv02056;

/**
 * @category 星级标准修正
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02056Service extends BaseDAO implements IPgt02056Service {

	private IPgt02056DAO t02056Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02056Service#GetDeleteCommand(com.sunway.vo.Pgt02056)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02056 xjbz) throws Exception {
		return t02056Dao.GetDeleteCommand(xjbz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02056Service#GetInsertCommand(com.sunway.vo.Pgt02056)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02056 xjbz) throws Exception {
		return t02056Dao.GetInsertCommand(xjbz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02056Service#GetUpdateCommand(com.sunway.vo.Pgt02056)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02056 xjbz) throws Exception {
		return t02056Dao.GetUpdateCommand(xjbz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02056Service#LoadAll(com.sunway.vo.Pgv02056)
	 */
	@Override
	public ArrayList<Pgv02056> LoadAll(Pgv02056 xjbz) throws Exception {
		return t02056Dao.LoadAll(xjbz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02056Service#LoadByPrimaryKey(com.sunway.vo.Pgt02056)
	 */
	@Override
	public Pgt02056 LoadByPrimaryKey(Pgt02056 xjbz) throws Exception {
		return t02056Dao.LoadByPrimaryKey(xjbz);
	}

	/**
	 * @return the t02056Dao
	 */
	public IPgt02056DAO getT02056Dao() {
		return t02056Dao;
	}

	/**
	 * @param t02056Dao the t02056Dao to set
	 */
	public void setT02056Dao(IPgt02056DAO t02056Dao) {
		this.t02056Dao = t02056Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02056Service#ExecuteParamCopy(com.sunway.vo.Pgt02056)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt02056 xjbz) throws Exception {
		return t02056Dao.ExecuteParamCopy(xjbz);
	}

}
