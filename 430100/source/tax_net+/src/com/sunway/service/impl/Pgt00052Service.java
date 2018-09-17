package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00052DAO;
import com.sunway.service.IPgt00052Service;
import com.sunway.vo.Pgt00052;
import com.sunway.vo.Pgv00052;

/**
 * 税收管辖与所在区域对应关系
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00052Service implements IPgt00052Service {

	private IPgt00052DAO t00052Dao;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00052Service#LoadSzqyBySsgx(com.sunway.vo.Pgv00052)
	 */
	@Override
	public ArrayList<Pgv00052> LoadAll(Pgv00052 v00052) throws Exception {
		return t00052Dao.LoadAll(v00052);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00052Service#GetUpdateCommand(com.sunway.vo.Pgt00052)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00052 t00052) throws Exception{
		return t00052Dao.GetUpdateCommand(t00052);
	}

	/**
	 * @return the t00052Dao
	 */
	public IPgt00052DAO getT00052Dao() {
		return t00052Dao;
	}

	/**
	 * @param t00052Dao the t00052Dao to set
	 */
	public void setT00052Dao(IPgt00052DAO t00052Dao) {
		this.t00052Dao = t00052Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00052Service#LoadSzqyBySsgx(java.lang.String)
	 */
	@Override
	public ArrayList<Pgv00052> LoadSzqyBySsgx(String ssgx) throws Exception {
		return t00052Dao.LoadSzqyBySsgx(ssgx);
	}

}
