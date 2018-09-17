package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvBb00004DAO;
import com.sunway.service.IPgvBb00004Service;
import com.sunway.vo.PgvBb00004;

/**
 * 报表4
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public class PgvBb00004Service implements IPgvBb00004Service {

	private IPgvBb00004DAO bb00004DAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvBb00004Service#LoadAll(com.sunway.vo.PgvBb00004)
	 */
	public ArrayList<PgvBb00004> LoadAll(PgvBb00004 bb00004) throws Exception {
		return bb00004DAO.LoadAll(bb00004);
	}

	/**
	 * @return the bb00004DAO
	 */
	public IPgvBb00004DAO getBb00004DAO() {
		return bb00004DAO;
	}
	/**
	 * @param bb00004dao the bb00004DAO to set
	 */
	public void setBb00004DAO(IPgvBb00004DAO bb00004dao) {
		bb00004DAO = bb00004dao;
	}
}
