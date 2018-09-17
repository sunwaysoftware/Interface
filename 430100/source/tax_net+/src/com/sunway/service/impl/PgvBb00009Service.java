package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvBb00009DAO;
import com.sunway.service.IPgvBb00009Service;
import com.sunway.vo.PgvBb00009;

/**
 * 报表9
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public class PgvBb00009Service implements IPgvBb00009Service {

	private IPgvBb00009DAO bb00009DAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvBb00009Service#LoadAll(com.sunway.vo.PgvBb00009)
	 */
	public ArrayList<PgvBb00009> LoadAll(PgvBb00009 bb00009) throws Exception {
		return bb00009DAO.LoadAll(bb00009);
	}

	/**
	 * @return the bb00009DAO
	 */
	public IPgvBb00009DAO getBb00009DAO() {
		return bb00009DAO;
	}
	/**
	 * @param bb00009dao the bb00009DAO to set
	 */
	public void setBb00009DAO(IPgvBb00009DAO bb00009dao) {
		bb00009DAO = bb00009dao;
	}
}
