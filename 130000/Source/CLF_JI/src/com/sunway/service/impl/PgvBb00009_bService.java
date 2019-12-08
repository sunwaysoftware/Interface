package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvBb00009_bDAO;
import com.sunway.service.IPgvBb00009_bService;
import com.sunway.vo.PgvBb00009_b;

/**
 * 报表9
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public class PgvBb00009_bService implements IPgvBb00009_bService {

	private IPgvBb00009_bDAO bb00009_bDAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvBb00009_bService#LoadAll(com.sunway.vo.PgvBb00009_b)
	 */
	public ArrayList<PgvBb00009_b> LoadAll(PgvBb00009_b bb00009_b) throws Exception {
		return bb00009_bDAO.LoadAll(bb00009_b);
	}

	/**
	 * @return the bb00009_bDAO
	 */
	public IPgvBb00009_bDAO getBb00009_bDAO() {
		return bb00009_bDAO;
	}
	/**
	 * @param bb00009_bdao the bb00009_bDAO to set
	 */
	public void setBb00009_bDAO(IPgvBb00009_bDAO bb00009_bdao) {
		bb00009_bDAO = bb00009_bdao;
	}
}
