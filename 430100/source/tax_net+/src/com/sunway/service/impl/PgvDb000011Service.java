package com.sunway.service.impl;

import com.sunway.dao.IPgvDb000011DAO;
import com.sunway.service.IPgvDb000011Service;
import com.sunway.vo.PgvDb000011;

/**
 * 行业分析
 * @category 数据对比分析
 * @author Lee
 * @version 1.0
 */
public class PgvDb000011Service implements IPgvDb000011Service {

	private IPgvDb000011DAO db000011DAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IDb000011Service#LoadAll(com.sunway.vo.Db000011)
	 */
	public PgvDb000011 LoadAll(PgvDb000011 db000011) throws Exception {
		return db000011DAO.LoadAll(db000011);
	}

	/**
	 * @return the db000011DAO
	 */
	public IPgvDb000011DAO getDb000011DAO() {
		return db000011DAO;
	}
	/**
	 * @param db000011dao the db000011DAO to set
	 */
	public void setDb000011DAO(IPgvDb000011DAO db000011dao) {
		db000011DAO = db000011dao;
	}
}
