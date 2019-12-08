package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvBb00002_bDAO;
import com.sunway.service.IPgvBb00002_bService;
import com.sunway.vo.PgvBb00002_b;

/**
 * 报表2
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public class PgvBb00002_bService implements IPgvBb00002_bService {

	private IPgvBb00002_bDAO bb00002_bDAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvBb00002_bService#LoadAll(com.sunway.vo.PgvBb00002_b)
	 */
	public ArrayList<PgvBb00002_b> LoadAll(PgvBb00002_b bb00002_b) throws Exception {
		return bb00002_bDAO.LoadAll(bb00002_b);
	}

	/**
	 * @return the bb00002_bDAO
	 */
	public IPgvBb00002_bDAO getBb00002_bDAO() {
		return bb00002_bDAO;
	}
	/**
	 * @param bb00002BDAO the bb00002_bDAO to set
	 */
	public void setBb00002_bDAO(IPgvBb00002_bDAO bb00002BDAO) {
		bb00002_bDAO = bb00002BDAO;
	}
}
