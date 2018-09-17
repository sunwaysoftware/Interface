package com.sunway.service.impl;

import com.sunway.dao.IPgvDb000014DAO;
import com.sunway.service.IPgvDb000014Service;
import com.sunway.vo.PgvDb000014;

/**
 * 现行税率行业对比分析
 * @category 数据对比分析
 * @author Lee
 * @version 1.0
 */
public class PgvDb000014Service implements IPgvDb000014Service {

	private IPgvDb000014DAO db000014DAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IDb000014Service#LoadAll(com.sunway.vo.Db000014)
	 */
	public PgvDb000014 LoadAll(PgvDb000014 db000014) throws Exception {
		return db000014DAO.LoadAll(db000014);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvDb000014Service#GetInsertCommand(com.sunway.vo.PgvDb000014)
	 */
	public boolean GetInsertCommand(PgvDb000014 db000014) throws Exception {
		return db000014DAO.GetInsertCommand(db000014);
	}

	/**
	 * @return the db000014DAO
	 */
	public IPgvDb000014DAO getDb000014DAO() {
		return db000014DAO;
	}
	/**
	 * @param db000014dao the db000014DAO to set
	 */
	public void setDb000014DAO(IPgvDb000014DAO db000014dao) {
		db000014DAO = db000014dao;
	}
}
