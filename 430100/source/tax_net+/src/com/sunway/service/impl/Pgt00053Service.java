package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00053DAO;
import com.sunway.service.IPgt00053Service;
import com.sunway.vo.Pgt00053;
import com.sunway.vo.Pgv00053;

/**
 * 其它修正参数
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00053Service implements IPgt00053Service {

	private IPgt00053DAO t00053Dao;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00053Service#LoadAllXzlx()
	 */
	@Override
	public ArrayList<Pgv00053> LoadAllXzlx() throws Exception {
		return t00053Dao.LoadAllXzlx();
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00053Service#LoadAll(com.sunway.vo.Pgv00053)
	 */
	@Override
	public ArrayList<Pgv00053> LoadAll(Pgv00053 v00053) throws Exception {
		return t00053Dao.LoadAll(v00053);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00053Service#LoadByPrimaryKey(com.sunway.vo.Pgt00053)
	 */
	@Override
	public Pgt00053 LoadByPrimaryKey(Pgt00053 t00053) throws Exception {
		return t00053Dao.LoadByPrimaryKey(t00053);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00053Service#GetInsertCommand(com.sunway.vo.Pgt00053)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00053 t00053) throws Exception {
		return t00053Dao.GetInsertCommand(t00053);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00053Service#GetDeleteCommand(com.sunway.vo.Pgt00053)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00053 t00053) throws Exception {
		return t00053Dao.GetDeleteCommand(t00053);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00053Service#GetUpdateCommand(com.sunway.vo.Pgt00053)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00053 t00053) throws Exception {
		return t00053Dao.GetUpdateCommand(t00053);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00053Service#LoadNavigator(com.sunway.vo.Pgt00053)
	 */
	@Override
	public ArrayList<Pgt00053> LoadNavigator(Pgt00053 t00053) throws Exception {
		return t00053Dao.LoadNavigator(t00053);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00053Service#LoadTreeList(com.sunway.vo.Pgt00053)
	 */
	@Override
	public ArrayList<Pgt00053> LoadTreeList(Pgt00053 t00053) throws Exception {
		return t00053Dao.LoadTreeList(t00053);
	}
	/**
	 * @return the t00053Dao
	 */
	public IPgt00053DAO getT00053Dao() {
		return t00053Dao;
	}
	/**
	 * @param t00053Dao the t00053Dao to set
	 */
	public void setT00053Dao(IPgt00053DAO t00053Dao) {
		this.t00053Dao = t00053Dao;
	}
}
