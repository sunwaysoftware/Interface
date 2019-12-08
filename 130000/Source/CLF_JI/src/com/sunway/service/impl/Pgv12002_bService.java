package com.sunway.service.impl;

import com.sunway.dao.IPgv12002_bDAO;
import com.sunway.service.IPgv12002_bService;
import com.sunway.vo.Pgv12002_b;

public class Pgv12002_bService implements IPgv12002_bService {

	private IPgv12002_bDAO v12002_bDAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgv12002_bService#LoadAll(com.sunway.vo.Pgv12002_b)
	 */
	@Override
	public Pgv12002_b LoadAll(Pgv12002_b v12002_b) throws Exception {
		return v12002_bDAO.LoadAll(v12002_b);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgv12002_bService#LoadDetail(com.sunway.vo.Pgv12002_b)
	 */
	@Override
	public Pgv12002_b LoadDetail(Pgv12002_b v12002_b) throws Exception {
		return v12002_bDAO.LoadDetail(v12002_b);
	}

	/**
	 * @return the v12002_bDAO
	 */
	public IPgv12002_bDAO getV12002_bDAO() {
		return v12002_bDAO;
	}
	/**
	 * @param v12002BDAO the v12002_bDAO to set
	 */
	public void setV12002_bDAO(IPgv12002_bDAO v12002BDAO) {
		v12002_bDAO = v12002BDAO;
	}
}
