/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;
import com.sunway.dao.IPgt02054DAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPgt02054Service;
import com.sunway.vo.Pgt02054;
import com.sunway.vo.Pgv02054;

/**
 * @category 收益法房屋设施
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02054Service extends BaseDAO implements IPgt02054Service {

	private IPgt02054DAO t02054Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02054Service#GetDeleteCommand(com.sunway.vo.Pgt02054)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02054 fwss) throws Exception {
		return t02054Dao.GetDeleteCommand(fwss);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02054Service#GetInsertCommand(com.sunway.vo.Pgt02054)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02054 fwss) throws Exception {
		return t02054Dao.GetInsertCommand(fwss);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02054Service#GetUpdateCommand(com.sunway.vo.Pgt02054)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02054 fwss) throws Exception {
		return t02054Dao.GetUpdateCommand(fwss);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02054Service#LoadAll(com.sunway.vo.Pgv02054)
	 */
	@Override
	public ArrayList<Pgv02054> LoadAll(Pgv02054 fwss) throws Exception {
		return t02054Dao.LoadAll(fwss);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02054Service#LoadByPrimaryKey(com.sunway.vo.Pgt02054)
	 */
	@Override
	public Pgt02054 LoadByPrimaryKey(Pgt02054 fwss) throws Exception {
		return t02054Dao.LoadByPrimaryKey(fwss);
	}

	/**
	 * @return the t02054Dao
	 */
	public IPgt02054DAO getT02054Dao() {
		return t02054Dao;
	}

	/**
	 * @param t02054Dao the t02054Dao to set
	 */
	public void setT02054Dao(IPgt02054DAO t02054Dao) {
		this.t02054Dao = t02054Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02054Service#ExecuteParamCopy(com.sunway.vo.Pgt02054)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt02054 fwss) throws Exception {
		return t02054Dao.ExecuteParamCopy(fwss);
	}

}
