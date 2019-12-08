package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgv12002ADAO;
import com.sunway.service.IPgv12002AService;
import com.sunway.vo.Pgv12002A;

/**
 * 地产信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv12002AService implements IPgv12002AService {

	private IPgv12002ADAO v12002ADAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgv12002AService#LoadAll(com.sunway.vo.Pgv12002A)
	 */
	@Override
	public ArrayList<Pgv12002A> LoadAll(Pgv12002A v12002A) throws Exception {
		return v12002ADAO.LoadAll(v12002A);
	}

	/**
	 * @return the v12002ADAO
	 */
	public IPgv12002ADAO getV12002ADAO() {
		return v12002ADAO;
	}
	/**
	 * @param v12002adao the v12002ADAO to set
	 */
	public void setV12002ADAO(IPgv12002ADAO v12002adao) {
		v12002ADAO = v12002adao;
	}
}
