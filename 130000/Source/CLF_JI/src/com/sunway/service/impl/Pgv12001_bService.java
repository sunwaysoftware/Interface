package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgv12001_bDAO;
import com.sunway.service.IPgv12001_bService;
import com.sunway.vo.Pgv12001_b;
import com.sunway.vo.PgvCzPssd;

/**
 * 登记信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv12001_bService implements IPgv12001_bService {

	private IPgv12001_bDAO v12001_bDAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgv12001_bService#LoadAll(com.sunway.vo.Pgv12001_b)
	 */
	@Override
	public Pgv12001_b LoadAll(Pgv12001_b v12001_b) throws Exception {
		return v12001_bDAO.LoadAll(v12001_b);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgv12001_bService#LoadPssd()
	 */
	@Override
	public ArrayList<PgvCzPssd> LoadPssd() throws Exception{
		return v12001_bDAO.LoadPssd();
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgv12001_bService#LoadDetail(com.sunway.vo.Pgv12001_b)
	 */
	@Override
	public Pgv12001_b LoadDetail(Pgv12001_b v12001_b) throws Exception{
		return v12001_bDAO.LoadDetail(v12001_b);
	}

	/**
	 * @return the v12001_bDAO
	 */
	public IPgv12001_bDAO getV12001_bDAO() {
		return v12001_bDAO;
	}
	/**
	 * @param v12001BDAO the v12001_bDAO to set
	 */
	public void setV12001_bDAO(IPgv12001_bDAO v12001BDAO) {
		v12001_bDAO = v12001BDAO;
	}
}
