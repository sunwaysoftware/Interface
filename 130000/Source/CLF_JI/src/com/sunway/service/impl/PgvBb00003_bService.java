package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvBb00003_bDAO;
import com.sunway.service.IPgvBb00003_bService;
import com.sunway.vo.PgvBb00003_b;

/**
 * 报表3
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public class PgvBb00003_bService implements IPgvBb00003_bService {

	private IPgvBb00003_bDAO bb00003_bDAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvBb00003_bService#LoadAll(com.sunway.vo.PgvBb00003_b)
	 */
	public ArrayList<PgvBb00003_b> LoadAll(PgvBb00003_b bb00003_b) throws Exception {
		return bb00003_bDAO.LoadAll(bb00003_b);
	}

	/**
	 * @return the bb00003_bDAO
	 */
	public IPgvBb00003_bDAO getBb00003_bDAO() {
		return bb00003_bDAO;
	}
	/**
	 * @param bb00003BDAO the bb00003_bDAO to set
	 */
	public void setBb00003_bDAO(IPgvBb00003_bDAO bb00003BDAO) {
		bb00003_bDAO = bb00003BDAO;
	}
}
