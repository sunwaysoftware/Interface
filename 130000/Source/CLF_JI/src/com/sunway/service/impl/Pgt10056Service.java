package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt10056DAO;
import com.sunway.service.IPgt10056Service;
import com.sunway.vo.Pgt10056;
import com.sunway.vo.Pgv10056;

/**
 * @category 成本法评税时点修正
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt10056Service implements IPgt10056Service {

	private IPgt10056DAO t10056Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10056Service#GetDeleteCommand(com.sunway.vo.Pgt10056)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt10056 pssdxz) throws Exception {
		return t10056Dao.GetDeleteCommand(pssdxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10056Service#GetInsertCommand(com.sunway.vo.Pgt10056)
	 */
	@Override
	public boolean GetInsertCommand(Pgt10056 pssdxz) throws Exception {
		return t10056Dao.GetInsertCommand(pssdxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10056Service#GetUpdateCommand(com.sunway.vo.Pgt10056)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt10056 pssdxz) throws Exception {
		return t10056Dao.GetUpdateCommand(pssdxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10056Service#LoadAll(com.sunway.vo.Pgv10056)
	 */
	@Override
	public ArrayList<Pgv10056> LoadAll(Pgv10056 pssdxz) throws Exception {
		return t10056Dao.LoadAll(pssdxz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10056Service#LoadByPrimaryKey(com.sunway.vo.Pgt10056)
	 */
	@Override
	public Pgt10056 LoadByPrimaryKey(Pgt10056 pssdxz) throws Exception {
		return t10056Dao.LoadByPrimaryKey(pssdxz);
	}

	/**
	 * @return the t10056Dao
	 */
	public IPgt10056DAO getT10056Dao() {
		return t10056Dao;
	}

	/**
	 * @param t10056Dao the t10056Dao to set
	 */
	public void setT10056Dao(IPgt10056DAO t10056Dao) {
		this.t10056Dao = t10056Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10056Service#ExecuteParamCopy(com.sunway.vo.Pgt10056)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt10056 pssdxz) throws Exception {
		return t10056Dao.ExecuteParamCopy(pssdxz);
	}

}
