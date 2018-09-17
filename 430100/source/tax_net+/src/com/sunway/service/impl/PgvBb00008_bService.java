package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvBb00008_bDAO;
import com.sunway.service.IPgvBb00008_bService;
import com.sunway.vo.PgvBb00008_b;

/**
 * 报表8
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public class PgvBb00008_bService implements IPgvBb00008_bService {

	private IPgvBb00008_bDAO bb00008_bDAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvBb00008_bService#LoadAll(com.sunway.vo.PgvBb00008_b)
	 */
	public ArrayList<PgvBb00008_b> LoadAll(PgvBb00008_b bb00008_b) throws Exception {
		return bb00008_bDAO.LoadAll(bb00008_b);
	}

	/**
	 * @return the bb00008_bDAO
	 */
	public IPgvBb00008_bDAO getBb00008_bDAO() {
		return bb00008_bDAO;
	}
	/**
	 * @param bb00008BDAO the bb00008_bDAO to set
	 */
	public void setBb00008_bDAO(IPgvBb00008_bDAO bb00008BDAO) {
		bb00008_bDAO = bb00008BDAO;
	}
}
