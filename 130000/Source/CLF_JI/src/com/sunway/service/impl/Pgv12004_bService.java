package com.sunway.service.impl;

import com.sunway.dao.IPgv12004_bDAO;
import com.sunway.service.IPgv12004_bService;
import com.sunway.vo.Pgv12004_b;

/**
 * 明细信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv12004_bService implements IPgv12004_bService {

	private IPgv12004_bDAO v12004_bDAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgv12004_bService#LoadAll(com.sunway.vo.Pgv12004_b)
	 */
	@Override
	public Pgv12004_b LoadAll(Pgv12004_b v12004_b) throws Exception {
		return v12004_bDAO.LoadAll(v12004_b);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgv12004_bService#LoadDetail(com.sunway.vo.Pgv12004_b)
	 */
	@Override
	public Pgv12004_b LoadDetail(Pgv12004_b v12004_b) throws Exception{
		return v12004_bDAO.LoadDetail(v12004_b);
	}

	/**
	 * @return the v12004_bDAO
	 */
	public IPgv12004_bDAO getV12004_bDAO() {
		return v12004_bDAO;
	}
	/**
	 * @param v12004BDAO the v12004_bDAO to set
	 */
	public void setV12004_bDAO(IPgv12004_bDAO v12004BDAO) {
		v12004_bDAO = v12004BDAO;
	}
}
