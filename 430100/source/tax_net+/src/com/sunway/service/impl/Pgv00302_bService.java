package com.sunway.service.impl;

import com.sunway.dao.IPgv00302_bDAO;
import com.sunway.service.IPgv00302_bService;
import com.sunway.vo.Pgv00302_b;

/**
 * 住宅国土信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv00302_bService implements IPgv00302_bService {

	private IPgv00302_bDAO v00302_bDAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgv00302_bService#LoadAll(com.sunway.vo.Pgv00302_b)
	 */
	@Override
	public Pgv00302_b LoadAll(Pgv00302_b v00302_b) throws Exception {
		return v00302_bDAO.LoadAll(v00302_b);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgv00302_bService#LoadDetail(com.sunway.vo.Pgv00302_b)
	 */
	@Override
	public Pgv00302_b LoadDetail(Pgv00302_b v00302_b) throws Exception {
		return v00302_bDAO.LoadDetail(v00302_b);
	}

	/**
	 * @return the v00302_bDAO
	 */
	public IPgv00302_bDAO getV00302_bDAO() {
		return v00302_bDAO;
	}
	/**
	 * @param v00302BDAO the v00302_bDAO to set
	 */
	public void setV00302_bDAO(IPgv00302_bDAO v00302BDAO) {
		v00302_bDAO = v00302BDAO;
	}
}
