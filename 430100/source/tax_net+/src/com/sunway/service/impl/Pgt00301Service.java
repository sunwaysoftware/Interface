/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00301DAO;
import com.sunway.service.IPgt00301Service;
import com.sunway.vo.Pgt00301;
import com.sunway.vo.Pgv00301;

/**
 * @author Andy.Gao
 *
 */
public class Pgt00301Service implements IPgt00301Service {

	private IPgt00301DAO t00301Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00301Service#GetDeleteCommand(com.sunway.vo.Pgt00301)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00301 t00301) throws Exception {
		return t00301Dao.GetDeleteCommand(t00301);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00301Service#GetInsertCommand(com.sunway.vo.Pgt00301)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00301 t00301) throws Exception {
		return t00301Dao.GetInsertCommand(t00301);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00301Service#GetUpdateCommand(com.sunway.vo.Pgt00301)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00301 t00301) throws Exception {
		return t00301Dao.GetUpdateCommand(t00301);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00301Service#LoadAll(com.sunway.vo.Pgt00301)
	 */
	@Override
	public ArrayList<Pgv00301> LoadAll(Pgv00301 v00301) throws Exception {
		return t00301Dao.LoadAll(v00301);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00301Service#LoadByPrimaryKey(com.sunway.vo.Pgt00301)
	 */
	@Override
	public Pgt00301 LoadByPrimaryKey(Pgt00301 t00301) throws Exception {
		return t00301Dao.LoadByPrimaryKey(t00301);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00301Service#LoadDetail(com.sunway.vo.Pgv00301)
	 */
	@Override
	public Pgv00301 LoadDetail(Pgv00301 v00301) throws Exception {
		return t00301Dao.LoadDetail(v00301);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00301Service#LoadDetail(com.sunway.vo.Pgv00301)
	 */
	@Override
	public Pgv00301 LoadDetail_B(Pgv00301 v00301) throws Exception {
		return t00301Dao.LoadDetail_B(v00301);
	}

	/**
	 * @param t00301Dao the t00301Dao to set
	 */
	public void setT00301Dao(IPgt00301DAO t00301Dao) {
		this.t00301Dao = t00301Dao;
	}

	/**
	 * @return the t00301Dao
	 */
	public IPgt00301DAO getT00301Dao() {
		return t00301Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00301Service#LoadCount(com.sunway.vo.Pgt00301)
	 */
	@Override
	public Pgt00301 LoadCount(Pgt00301 t00301) throws Exception {
		return t00301Dao.LoadCount(t00301);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00301Service#GetZz(com.sunway.vo.Pgv00301)
	 */
	@Override
	public ArrayList<String> GetZz(Pgv00301 v00301) throws Exception {
		return t00301Dao.GetZz(v00301);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00301Service#LoadPgv003015(com.sunway.vo.Pgv00301)
	 */
	@Override
	public Pgv00301 LoadPgv003015(Pgv00301 v00301) throws Exception {
		return t00301Dao.LoadPgv003015(v00301);
	}
}
