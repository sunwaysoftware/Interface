package com.sunway.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.dao.IBB00008DAO;
import com.sunway.service.IBB00008Service;
import com.sunway.vo.BF00008;

/**
 * 交易纳税评估分区域统计表
 * @author Light
 *
 */
public class BB00008Service implements IBB00008Service{
	
	private IBB00008DAO bb00008Dao;

	@Override
	public ArrayList<BF00008> LoadAll(BF00008 bean) throws Exception {
		return bb00008Dao.LoadAll(bean);
	}

	@Override
	public OutputStream ExportData(BF00008 bean, String fileName) throws Exception {
		return bb00008Dao.ExportData(bean, fileName);
	}

	
	
	/*********************   set && get   **************************/
	public IBB00008DAO getBb00008Dao() {
		return bb00008Dao;
	}

	public void setBb00008Dao(IBB00008DAO bb00008Dao) {
		this.bb00008Dao = bb00008Dao;
	}

}
