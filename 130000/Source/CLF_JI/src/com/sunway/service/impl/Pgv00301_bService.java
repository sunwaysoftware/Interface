package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgv00301_bDAO;
import com.sunway.service.IPgv00301_bService;
import com.sunway.vo.Pgv00301_b;
import com.sunway.vo.PgvCzPssd;

/**
 * 住宅登记信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv00301_bService implements IPgv00301_bService {

	private IPgv00301_bDAO v00301_bDAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgv00301_bService#LoadAll(com.sunway.vo.Pgv00301_b)
	 */
	@Override
	public Pgv00301_b LoadAll(Pgv00301_b v00301_b) throws Exception {
		return v00301_bDAO.LoadAll(v00301_b);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgv00301_bService#LoadPssd()
	 */
	@Override
	public ArrayList<PgvCzPssd> LoadPssd() throws Exception{
		return v00301_bDAO.LoadPssd();
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgv00301_bService#LoadDetail(com.sunway.vo.Pgv00301_b)
	 */
	@Override
	public Pgv00301_b LoadDetail(Pgv00301_b v00301_b) throws Exception {
		return v00301_bDAO.LoadDetail(v00301_b);
	}

	/**
	 * @return the v00301_bDAO
	 */
	public IPgv00301_bDAO getV00301_bDAO() {
		return v00301_bDAO;
	}
	/**
	 * @param v00301BDAO the v00301_bDAO to set
	 */
	public void setV00301_bDAO(IPgv00301_bDAO v00301BDAO) {
		v00301_bDAO = v00301BDAO;
	}
}
