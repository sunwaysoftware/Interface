package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvBb00004_bDAO;
import com.sunway.service.IPgvBb00004_bService;
import com.sunway.vo.PgvBb00004_b;

/**
 * 报表4
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public class PgvBb00004_bService implements IPgvBb00004_bService {

	private IPgvBb00004_bDAO bb00004_bDAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvBb00004_bService#LoadAll(com.sunway.vo.PgvBb00004_b)
	 */
	public ArrayList<PgvBb00004_b> LoadAll(PgvBb00004_b bb00004_b) throws Exception {
		return bb00004_bDAO.LoadAll(bb00004_b);
	}

	/**
	 * @return the bb00004_bDAO
	 */
	public IPgvBb00004_bDAO getBb00004_bDAO() {
		return bb00004_bDAO;
	}
	/**
	 * @param bb00004BDAO the bb00004_bDAO to set
	 */
	public void setBb00004_bDAO(IPgvBb00004_bDAO bb00004BDAO) {
		bb00004_bDAO = bb00004BDAO;
	}
}
