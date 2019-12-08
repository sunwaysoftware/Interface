package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvBb00001DAO;
import com.sunway.service.IPgvBb00001Service;
import com.sunway.vo.PgvBb00001;

/**
 * 报表1
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public class PgvBb00001Service implements IPgvBb00001Service {

	private IPgvBb00001DAO bb00001DAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvBb00001Service#LoadAll(com.sunway.vo.PgvBb00001)
	 */
	public ArrayList<PgvBb00001> LoadAll(PgvBb00001 bb00001) throws Exception {
		return bb00001DAO.LoadAll(bb00001);
	}

	/**
	 * @return the bb00001DAO
	 */
	public IPgvBb00001DAO getBb00001DAO() {
		return bb00001DAO;
	}
	/**
	 * @param bb00001dao the bb00001DAO to set
	 */
	public void setBb00001DAO(IPgvBb00001DAO bb00001dao) {
		bb00001DAO = bb00001dao;
	}
}
