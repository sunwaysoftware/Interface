package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt10053DAO;
import com.sunway.service.IPgt10053Service;
import com.sunway.vo.Pgt10053;
import com.sunway.vo.Pgv10053;

/**
 * @category 成本法间接费用比率
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt10053Service implements IPgt10053Service {

	private IPgt10053DAO t10053Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10053Service#GetDeleteCommand(com.sunway.vo.Pgt10053)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt10053 jjfybl) throws Exception {
		return t10053Dao.GetDeleteCommand(jjfybl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10053Service#GetInsertCommand(com.sunway.vo.Pgt10053)
	 */
	@Override
	public boolean GetInsertCommand(Pgt10053 jjfybl) throws Exception {
		return t10053Dao.GetInsertCommand(jjfybl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10053Service#GetUpdateCommand(com.sunway.vo.Pgt10053)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt10053 jjfybl) throws Exception {
		return t10053Dao.GetUpdateCommand(jjfybl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10053Service#LoadAll(com.sunway.vo.Pgv10053)
	 */
	@Override
	public ArrayList<Pgv10053> LoadAll(Pgv10053 jjfybl) throws Exception {
		return t10053Dao.LoadAll(jjfybl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10053Service#LoadByPrimaryKey(com.sunway.vo.Pgt10053)
	 */
	@Override
	public Pgt10053 LoadByPrimaryKey(Pgt10053 jjfybl) throws Exception {
		return t10053Dao.LoadByPrimaryKey(jjfybl);
	}

	/**
	 * @return the t10053Dao
	 */
	public IPgt10053DAO getT10053Dao() {
		return t10053Dao;
	}

	/**
	 * @param t10053Dao the t10053Dao to set
	 */
	public void setT10053Dao(IPgt10053DAO t10053Dao) {
		this.t10053Dao = t10053Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10053Service#ExecuteParamCopy(com.sunway.vo.Pgt10053)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt10053 jjfybl) throws Exception {
		return t10053Dao.ExecuteParamCopy(jjfybl);
	}

}
