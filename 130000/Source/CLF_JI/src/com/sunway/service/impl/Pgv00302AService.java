package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgv00302ADAO;
import com.sunway.service.IPgv00302AService;
import com.sunway.vo.Pgv00302A;

/**
 * 住宅房产信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv00302AService implements IPgv00302AService {

	private IPgv00302ADAO v00302ADAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgv00302AService#LoadAll(com.sunway.vo.Pgv00302A)
	 */
	@Override
	public ArrayList<Pgv00302A> LoadAll(Pgv00302A v00302A) throws Exception {
		return v00302ADAO.LoadAll(v00302A);
	}

	/**
	 * @return the v00302ADAO
	 */
	public IPgv00302ADAO getV00302ADAO() {
		return v00302ADAO;
	}
	/**
	 * @param v00302adao the v00302ADAO to set
	 */
	public void setV00302ADAO(IPgv00302ADAO v00302adao) {
		v00302ADAO = v00302adao;
	}
}
