package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgv00301ADAO;
import com.sunway.service.IPgv00301AService;
import com.sunway.vo.Pgv00301A;

/**
 * 住宅登记信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv00301AService implements IPgv00301AService {

	private IPgv00301ADAO v00301ADAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgv00301AService#LoadAll(com.sunway.vo.Pgv00301A)
	 */
	@Override
	public ArrayList<Pgv00301A> LoadAll(Pgv00301A v00301A) throws Exception {
		return v00301ADAO.LoadAll(v00301A);
	}

	/**
	 * @return the v00301ADAO
	 */
	public IPgv00301ADAO getV00301ADAO() {
		return v00301ADAO;
	}
	/**
	 * @param v00301adao the v00301ADAO to set
	 */
	public void setV00301ADAO(IPgv00301ADAO v00301adao) {
		v00301ADAO = v00301adao;
	}
}
