package com.sunway.service.impl;

import com.sunway.dao.IPgvDb000013DAO;
import com.sunway.service.IPgvDb000013Service;
import com.sunway.vo.PgvDb000013;

/**
 * 免税设置对比分析
 * @category 数据对比分析
 * @author Lee
 * @version 1.0
 */
public class PgvDb000013Service implements IPgvDb000013Service {

	private IPgvDb000013DAO db000013DAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IDb000013Service#LoadAll(com.sunway.vo.Db000013)
	 */
	public PgvDb000013 LoadAll(PgvDb000013 db000013) throws Exception {
		return db000013DAO.LoadAll(db000013);
	}

	/**
	 * @return the db000013DAO
	 */
	public IPgvDb000013DAO getDb000013DAO() {
		return db000013DAO;
	}
	/**
	 * @param db000013dao the db000013DAO to set
	 */
	public void setDb000013DAO(IPgvDb000013DAO db000013dao) {
		db000013DAO = db000013dao;
	}
}
