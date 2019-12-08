package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvBb00003DAO;
import com.sunway.service.IPgvBb00003Service;
import com.sunway.vo.PgvBb00003;

/**
 * 报表3
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public class PgvBb00003Service implements IPgvBb00003Service {

	private IPgvBb00003DAO bb00003DAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvBb00003Service#LoadAll(com.sunway.vo.PgvBb00003)
	 */
	public ArrayList<PgvBb00003> LoadAll(PgvBb00003 bb00003) throws Exception {
		return bb00003DAO.LoadAll(bb00003);
	}

	/**
	 * @return the bb00003DAO
	 */
	public IPgvBb00003DAO getBb00003DAO() {
		return bb00003DAO;
	}
	/**
	 * @param bb00003dao the bb00003DAO to set
	 */
	public void setBb00003DAO(IPgvBb00003DAO bb00003dao) {
		bb00003DAO = bb00003dao;
	}
}
