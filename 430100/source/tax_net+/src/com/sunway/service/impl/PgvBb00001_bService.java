package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvBb00001_bDAO;
import com.sunway.service.IPgvBb00001_bService;
import com.sunway.vo.PgvBb00001_b;

/**
 * 报表1
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public class PgvBb00001_bService implements IPgvBb00001_bService {

	private IPgvBb00001_bDAO bb00001_bDAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvBb00001_bService#LoadAll(com.sunway.vo.PgvBb00001_b)
	 */
	public ArrayList<PgvBb00001_b> LoadAll(PgvBb00001_b bb00001_b) throws Exception {
		return bb00001_bDAO.LoadAll(bb00001_b);
	}

	/**
	 * @return the bb00001_bDAO
	 */
	public IPgvBb00001_bDAO getBb00001_bDAO() {
		return bb00001_bDAO;
	}
	/**
	 * @param bb00001BDAO the bb00001_bDAO to set
	 */
	public void setBb00001_bDAO(IPgvBb00001_bDAO bb00001BDAO) {
		bb00001_bDAO = bb00001BDAO;
	}
}
