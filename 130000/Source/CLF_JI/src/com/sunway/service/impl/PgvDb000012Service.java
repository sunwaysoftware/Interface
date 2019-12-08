package com.sunway.service.impl;

import com.sunway.dao.IPgvDb000012DAO;
import com.sunway.service.IPgvDb000012Service;
import com.sunway.vo.PgvDb000012;

/**
 * 经济类型对比分析
 * @category 数据对比分析
 * @author Lee
 * @version 1.0
 */
public class PgvDb000012Service implements IPgvDb000012Service {

	private IPgvDb000012DAO db000012DAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IDb000012Service#LoadAll(com.sunway.vo.Db000012)
	 */
	public PgvDb000012 LoadAll(PgvDb000012 db000012) throws Exception {
		return db000012DAO.LoadAll(db000012);
	}

	/**
	 * @return the db000012DAO
	 */
	public IPgvDb000012DAO getDb000012DAO() {
		return db000012DAO;
	}
	/**
	 * @param db000012dao the db000012DAO to set
	 */
	public void setDb000012DAO(IPgvDb000012DAO db000012dao) {
		db000012DAO = db000012dao;
	}
}
