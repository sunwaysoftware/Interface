package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvBb00007_bDAO;
import com.sunway.service.IPgvBb00007_bService;
import com.sunway.vo.PgvBb00007_b;

/**
 * 报表7
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public class PgvBb00007_bService implements IPgvBb00007_bService {

	private IPgvBb00007_bDAO bb00007_bDAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvBb00007_bService#LoadAll(com.sunway.vo.PgvBb00007_b)
	 */
	public ArrayList<PgvBb00007_b> LoadAll(PgvBb00007_b bb00007_b) throws Exception {
		return bb00007_bDAO.LoadAll(bb00007_b);
	}

	/**
	 * @return the bb00007_bDAO
	 */
	public IPgvBb00007_bDAO getBb00007_bDAO() {
		return bb00007_bDAO;
	}
	/**
	 * @param bb00007BDAO the bb00007_bDAO to set
	 */
	public void setBb00007_bDAO(IPgvBb00007_bDAO bb00007BDAO) {
		bb00007_bDAO = bb00007BDAO;
	}
}
