package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvBb00006_bDAO;
import com.sunway.service.IPgvBb00006_bService;
import com.sunway.vo.PgvBb00006_b;

/**
 * 报表6
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public class PgvBb00006_bService implements IPgvBb00006_bService {

	private IPgvBb00006_bDAO bb00006_bDAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvBb00006_bService#LoadAll(com.sunway.vo.PgvBb00006_b)
	 */
	public ArrayList<PgvBb00006_b> LoadAll(PgvBb00006_b bb00006_b) throws Exception {
		return bb00006_bDAO.LoadAll(bb00006_b);
	}

	/**
	 * @return the bb00006_bDAO
	 */
	public IPgvBb00006_bDAO getBb00006_bDAO() {
		return bb00006_bDAO;
	}
	/**
	 * @param bb00006BDAO the bb00006_bDAO to set
	 */
	public void setBb00006_bDAO(IPgvBb00006_bDAO bb00006BDAO) {
		bb00006_bDAO = bb00006BDAO;
	}
}
