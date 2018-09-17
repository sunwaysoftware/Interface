package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt02002cDAO;
import com.sunway.service.IPgt02002cService;
import com.sunway.vo.Pgv02002c;

/**
 * 
 * 市场法国土其它修正参数表
 *
 */
public class Pgt02002cService implements IPgt02002cService {

	private IPgt02002cDAO t02002cDao;


	@Override
	public ArrayList<Pgv02002c> LoadAllQM(Pgv02002c v02002c) throws Exception {
		return t02002cDao.LoadAllQM(v02002c);
	}

	/**
	 * @return the t02002cDao
	 */
	public IPgt02002cDAO getT02002cDao() {
		return t02002cDao;
	}

	/**
	 * @param t02002cDao the t02002cDao to set
	 */
	public void setT02002cDao(IPgt02002cDAO t02002cDao) {
		this.t02002cDao = t02002cDao;
	}

	@Override
	public ArrayList<Pgv02002c> LoadAll(Pgv02002c v02002c) throws Exception {
		return t02002cDao.LoadAll(v02002c);
	}
}
