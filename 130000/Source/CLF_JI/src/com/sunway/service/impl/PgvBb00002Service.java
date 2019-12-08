package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvBb00002DAO;
import com.sunway.service.IPgvBb00002Service;
import com.sunway.vo.PgvBb00002;

/**
 * 报表2
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public class PgvBb00002Service implements IPgvBb00002Service {

	private IPgvBb00002DAO bb00002DAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvBb00002Service#LoadAll(com.sunway.vo.PgvBb00002)
	 */
	public ArrayList<PgvBb00002> LoadAll(PgvBb00002 bb00002) throws Exception {
		return bb00002DAO.LoadAll(bb00002);
	}

	/**
	 * @return the bb00002DAO
	 */
	public IPgvBb00002DAO getBb00002DAO() {
		return bb00002DAO;
	}
	/**
	 * @param bb00002dao the bb00002DAO to set
	 */
	public void setBb00002DAO(IPgvBb00002DAO bb00002dao) {
		bb00002DAO = bb00002dao;
	}
}
