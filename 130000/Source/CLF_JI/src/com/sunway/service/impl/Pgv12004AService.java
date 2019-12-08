package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgv12004ADAO;
import com.sunway.service.IPgv12004AService;
import com.sunway.vo.Pgv12004A;

/**
 * 明细信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv12004AService implements IPgv12004AService {

	private IPgv12004ADAO v12004ADAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgv12004AService#LoadAll(com.sunway.vo.Pgv12004A)
	 */
	@Override
	public ArrayList<Pgv12004A> LoadAll(Pgv12004A v12004A) throws Exception {
		return v12004ADAO.LoadAll(v12004A);
	}

	/**
	 * @return the v12004ADAO
	 */
	public IPgv12004ADAO getV12004ADAO() {
		return v12004ADAO;
	}
	/**
	 * @param v12004adao the v12004ADAO to set
	 */
	public void setV12004ADAO(IPgv12004ADAO v12004adao) {
		v12004ADAO = v12004adao;
	}
}
