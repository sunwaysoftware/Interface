package com.sunway.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.dao.IBB00006DAO;
import com.sunway.service.IBB00006Service;
import com.sunway.vo.BF00006;

/**
 * 交易纳税评估数量统计表
 * @author Light
 *
 */
public class BB00006Service implements IBB00006Service {

	private IBB00006DAO bb00006Dao;

	
	@Override
	public ArrayList<BF00006> LoadAll(BF00006 bean) throws Exception {
		return bb00006Dao.LoadAll(bean);
	}
	
	@Override
	public OutputStream ExportData(BF00006 bean, String fileName) throws Exception {
		return bb00006Dao.ExportData(bean, fileName);
	}
	
	
	
	/***************************   set &   get   *********************/
	public IBB00006DAO getBb00006Dao() {
		return bb00006Dao;
	}

	public void setBb00006Dao(IBB00006DAO bb00006Dao) {
		this.bb00006Dao = bb00006Dao;
	}



	

	
}
