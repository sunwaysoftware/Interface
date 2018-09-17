package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvBb00010_bDAO;
import com.sunway.service.IPgvBb00010_bService;
import com.sunway.vo.PgvBb00010_b;

/**
 * 报表10
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public class PgvBb00010_bService implements IPgvBb00010_bService {

	private IPgvBb00010_bDAO bb00010_bDAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvBb00010_bService#LoadAll(com.sunway.vo.PgvBb00010_b)
	 */
	public ArrayList<PgvBb00010_b> LoadAll(PgvBb00010_b bb00010_b) throws Exception {
		return bb00010_bDAO.LoadAll(bb00010_b);
	}

	/**
	 * @return the bb00010_bDAO
	 */
	public IPgvBb00010_bDAO getBb00010_bDAO() {
		return bb00010_bDAO;
	}
	/**
	 * @param bb00010BDAO the bb00010_bDAO to set
	 */
	public void setBb00010_bDAO(IPgvBb00010_bDAO bb00010BDAO) {
		bb00010_bDAO = bb00010BDAO;
	}
}
