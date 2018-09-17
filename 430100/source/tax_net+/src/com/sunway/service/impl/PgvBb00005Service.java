package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvBb00005DAO;
import com.sunway.service.IPgvBb00005Service;
import com.sunway.vo.PgvBb00005;

/**
 * 报表5
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public class PgvBb00005Service implements IPgvBb00005Service {

	private IPgvBb00005DAO bb00005DAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvBb00005Service#LoadAll(com.sunway.vo.PgvBb00005)
	 */
	public ArrayList<PgvBb00005> LoadAll(PgvBb00005 bb00005) throws Exception {
		return bb00005DAO.LoadAll(bb00005);
	}

	/**
	 * @return the bb00005DAO
	 */
	public IPgvBb00005DAO getBb00005DAO() {
		return bb00005DAO;
	}
	/**
	 * @param bb00005dao the bb00005DAO to set
	 */
	public void setBb00005DAO(IPgvBb00005DAO bb00005dao) {
		bb00005DAO = bb00005dao;
	}
}
