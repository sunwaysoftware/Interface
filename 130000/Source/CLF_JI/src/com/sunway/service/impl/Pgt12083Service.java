package com.sunway.service.impl;

import java.util.ArrayList;
import com.sunway.dao.IPgt12083DAO;
import com.sunway.service.IPgt12083Service;
import com.sunway.vo.Pgt12083;
import com.sunway.vo.Pgv12083;

/**
 * @category 审核土地面积维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt12083Service implements IPgt12083Service {

	private IPgt12083DAO t12083Dao;
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12083Service#GetDeleteCommand(com.sunway.vo.Pgt12083)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt12083 tdmj) throws Exception {
		return t12083Dao.GetDeleteCommand(tdmj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12083Service#GetInsertCommand(com.sunway.vo.Pgt12083)
	 */
	@Override
	public boolean GetInsertCommand(Pgt12083 tdmj) throws Exception {
		return t12083Dao.GetInsertCommand(tdmj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12083Service#GetUpdateCommand(com.sunway.vo.Pgt12083)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt12083 tdmj) throws Exception {
		return t12083Dao.GetUpdateCommand(tdmj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12083Service#LoadAll()
	 */
	@Override
	public ArrayList<Pgv12083> LoadAll(Pgv12083 tdmj) throws Exception {
		return t12083Dao.LoadAll(tdmj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12083Service#LoadByPrimaryKey(com.sunway.vo.Pgt12083)
	 */
	@Override
	public Pgt12083 LoadByPrimaryKey(Pgt12083 tdmj) throws Exception {
		return t12083Dao.LoadByPrimaryKey(tdmj);
	}

	/**
	 * @return the t12083Dao
	 */
	public IPgt12083DAO getT12083Dao() {
		return t12083Dao;
	}

	/**
	 * @param t12083Dao the t12083Dao to set
	 */
	public void setT12083Dao(IPgt12083DAO t12083Dao) {
		this.t12083Dao = t12083Dao;
	}

}
