package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00354DAO;
import com.sunway.service.IPgt00354Service;
import com.sunway.vo.Pgt00354;
import com.sunway.vo.Pgv00354;

/**
 * @category 市场法房屋朝向修正系数
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00354Service implements IPgt00354Service {

	private IPgt00354DAO t00354Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00354Service#GetDeleteCommand(com.sunway.vo.Pgt00354)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00354 fwcx) throws Exception {
		return t00354Dao.GetDeleteCommand(fwcx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00354Service#GetInsertCommand(com.sunway.vo.Pgt00354)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00354 fwcx) throws Exception {
		return t00354Dao.GetInsertCommand(fwcx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00354Service#GetUpdateCommand(com.sunway.vo.Pgt00354)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00354 fwcx) throws Exception {
		return t00354Dao.GetUpdateCommand(fwcx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00354Service#LoadAll(com.sunway.vo.Pgv00354)
	 */
	@Override
	public ArrayList<Pgv00354> LoadAll(Pgv00354 fwcx) throws Exception {
		return t00354Dao.LoadAll(fwcx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00354Service#LoadByPrimaryKey(com.sunway.vo.Pgt00354)
	 */
	@Override
	public Pgt00354 LoadByPrimaryKey(Pgt00354 fwcx) throws Exception {
		return t00354Dao.LoadByPrimaryKey(fwcx);
	}

	/**
	 * @return the t00354Dao
	 */
	public IPgt00354DAO getT00354Dao() {
		return t00354Dao;
	}

	/**
	 * @param t00354Dao the t00354Dao to set
	 */
	public void setT00354Dao(IPgt00354DAO t00354Dao) {
		this.t00354Dao = t00354Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00354Service#ExecuteParamCopy(com.sunway.vo.Pgt00354)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt00354 fwcx) throws Exception {
		return t00354Dao.ExecuteParamCopy(fwcx);
	}

}
