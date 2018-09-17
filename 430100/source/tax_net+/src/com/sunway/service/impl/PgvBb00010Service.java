package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvBb00010DAO;
import com.sunway.service.IPgvBb00010Service;
import com.sunway.vo.PgvBb00010;

/**
 * 报表10
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public class PgvBb00010Service implements IPgvBb00010Service {

	private IPgvBb00010DAO bb00010DAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvBb00010Service#LoadAll(com.sunway.vo.PgvBb00010)
	 */
	public ArrayList<PgvBb00010> LoadAll(PgvBb00010 bb00010) throws Exception {
		return bb00010DAO.LoadAll(bb00010);
	}

	/**
	 * @return the bb00010DAO
	 */
	public IPgvBb00010DAO getBb00010DAO() {
		return bb00010DAO;
	}
	/**
	 * @param bb00010dao the bb00010DAO to set
	 */
	public void setBb00010DAO(IPgvBb00010DAO bb00010dao) {
		bb00010DAO = bb00010dao;
	}
}
