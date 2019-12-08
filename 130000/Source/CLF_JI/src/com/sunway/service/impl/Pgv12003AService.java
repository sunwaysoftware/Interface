package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgv12003ADAO;
import com.sunway.service.IPgv12003AService;
import com.sunway.vo.Pgv12003A;

/**
 * 房产信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv12003AService implements IPgv12003AService {

	private IPgv12003ADAO v12003ADAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgv12003AService#LoadAll(com.sunway.vo.Pgv12003A)
	 */
	@Override
	public ArrayList<Pgv12003A> LoadAll(Pgv12003A v12003A) throws Exception {
		return v12003ADAO.LoadAll(v12003A);
	}

	/**
	 * @return the v12003ADAO
	 */
	public IPgv12003ADAO getV12003ADAO() {
		return v12003ADAO;
	}
	/**
	 * @param v12003adao the v12003ADAO to set
	 */
	public void setV12003ADAO(IPgv12003ADAO v12003adao) {
		v12003ADAO = v12003adao;
	}
}
