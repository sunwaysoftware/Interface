package com.sunway.service.impl;

import com.sunway.dao.IPgv12003_bDAO;
import com.sunway.service.IPgv12003_bService;
import com.sunway.vo.Pgv12003_b;

/**
 * 房产信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv12003_bService implements IPgv12003_bService {

	private IPgv12003_bDAO v12003_bDAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgv12003_bService#LoadAll(com.sunway.vo.Pgv12003_b)
	 */
	@Override
	public Pgv12003_b LoadAll(Pgv12003_b v12003_b) throws Exception {
		return v12003_bDAO.LoadAll(v12003_b);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgv12003_bService#LoadDetail(com.sunway.vo.Pgv12003_b)
	 */
	@Override
	public Pgv12003_b LoadDetail(Pgv12003_b v12003_b) throws Exception {
		return v12003_bDAO.LoadDetail(v12003_b);
	}

	/**
	 * @return the v12003_bDAO
	 */
	public IPgv12003_bDAO getV12003_bDAO() {
		return v12003_bDAO;
	}
	/**
	 * @param v12003BDAO the v12003_bDAO to set
	 */
	public void setV12003_bDAO(IPgv12003_bDAO v12003BDAO) {
		v12003_bDAO = v12003BDAO;
	}
}
