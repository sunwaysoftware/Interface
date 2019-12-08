package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvBb00008DAO;
import com.sunway.service.IPgvBb00008Service;
import com.sunway.vo.PgvBb00008;

/**
 * 报表8
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public class PgvBb00008Service implements IPgvBb00008Service {

	private IPgvBb00008DAO bb00008DAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvBb00008Service#LoadAll(com.sunway.vo.PgvBb00008)
	 */
	public ArrayList<PgvBb00008> LoadAll(PgvBb00008 bb00008) throws Exception {
		return bb00008DAO.LoadAll(bb00008);
	}

	/**
	 * @return the bb00008DAO
	 */
	public IPgvBb00008DAO getBb00008DAO() {
		return bb00008DAO;
	}
	/**
	 * @param bb00008dao the bb00008DAO to set
	 */
	public void setBb00008DAO(IPgvBb00008DAO bb00008dao) {
		bb00008DAO = bb00008dao;
	}
}
