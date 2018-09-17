package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvBb00005_bDAO;
import com.sunway.service.IPgvBb00005_bService;
import com.sunway.vo.PgvBb00005_b;

/**
 * 报表5
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public class PgvBb00005_bService implements IPgvBb00005_bService {

	private IPgvBb00005_bDAO bb00005_bDAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvBb00005_bService#LoadAll(com.sunway.vo.PgvBb00005_b)
	 */
	public ArrayList<PgvBb00005_b> LoadAll(PgvBb00005_b bb00005_b) throws Exception {
		return bb00005_bDAO.LoadAll(bb00005_b);
	}

	/**
	 * @return the bb00005_bDAO
	 */
	public IPgvBb00005_bDAO getBb00005_bDAO() {
		return bb00005_bDAO;
	}
	/**
	 * @param bb00005BDAO the bb00005_bDAO to set
	 */
	public void setBb00005_bDAO(IPgvBb00005_bDAO bb00005BDAO) {
		bb00005_bDAO = bb00005BDAO;
	}
}
