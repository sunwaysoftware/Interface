package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvBb00006DAO;
import com.sunway.service.IPgvBb00006Service;
import com.sunway.vo.PgvBb00006;

/**
 * 报表6
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public class PgvBb00006Service implements IPgvBb00006Service {

	private IPgvBb00006DAO bb00006DAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvBb00006Service#LoadAll(com.sunway.vo.PgvBb00006)
	 */
	public ArrayList<PgvBb00006> LoadAll(PgvBb00006 bb00006) throws Exception {
		return bb00006DAO.LoadAll(bb00006);
	}

	/**
	 * @return the bb00006DAO
	 */
	public IPgvBb00006DAO getBb00006DAO() {
		return bb00006DAO;
	}
	/**
	 * @param bb00006dao the bb00006DAO to set
	 */
	public void setBb00006DAO(IPgvBb00006DAO bb00006dao) {
		bb00006DAO = bb00006dao;
	}
}
