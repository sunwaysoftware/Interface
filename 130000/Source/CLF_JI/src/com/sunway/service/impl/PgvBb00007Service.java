package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvBb00007DAO;
import com.sunway.service.IPgvBb00007Service;
import com.sunway.vo.PgvBb00007;

/**
 * 报表7
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public class PgvBb00007Service implements IPgvBb00007Service {

	private IPgvBb00007DAO bb00007DAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvBb00007Service#LoadAll(com.sunway.vo.PgvBb00007)
	 */
	public ArrayList<PgvBb00007> LoadAll(PgvBb00007 bb00007) throws Exception {
		return bb00007DAO.LoadAll(bb00007);
	}

	/**
	 * @return the bb00007DAO
	 */
	public IPgvBb00007DAO getBb00007DAO() {
		return bb00007DAO;
	}
	/**
	 * @param bb00007dao the bb00007DAO to set
	 */
	public void setBb00007DAO(IPgvBb00007DAO bb00007dao) {
		bb00007DAO = bb00007dao;
	}
}
