package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgv12001ADAO;
import com.sunway.service.IPgv12001AService;
import com.sunway.vo.Pgv12001A;

/**
 * 登记信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv12001AService implements IPgv12001AService {

	private IPgv12001ADAO v12001ADAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgv12001AService#LoadAll(com.sunway.vo.Pgv12001A)
	 */
	@Override
	public ArrayList<Pgv12001A> LoadAll(Pgv12001A v12001A) throws Exception {
		return v12001ADAO.LoadAll(v12001A);
	}

	/**
	 * @return the v12001ADAO
	 */
	public IPgv12001ADAO getV12001ADAO() {
		return v12001ADAO;
	}
	/**
	 * @param v12001adao the v12001ADAO to set
	 */
	public void setV12001ADAO(IPgv12001ADAO v12001adao) {
		v12001ADAO = v12001adao;
	}
}
