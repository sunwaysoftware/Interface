package com.sunway.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.dao.IBB00007DAO;
import com.sunway.service.IBB00007Service;
import com.sunway.vo.BF00007;

/**
 * 年度湘潭市存量房交易纳税评估已开票完税统计表
 * @author Light
 *
 */
public class BB00007Service implements IBB00007Service{
	
	private IBB00007DAO bb00007Dao;

	@Override
	public ArrayList<BF00007> LoadAll(BF00007 bean) throws Exception {
		return bb00007Dao.LoadAll(bean);
	}

	@Override
	public OutputStream ExportData(BF00007 bean, String fileName) throws Exception {
		return bb00007Dao.ExportData(bean, fileName);
	}
	
	/*************************   set   &   get   ****************************/
	
	public IBB00007DAO getBb00007Dao() {
		return bb00007Dao;
	}

	public void setBb00007Dao(IBB00007DAO bb00007Dao) {
		this.bb00007Dao = bb00007Dao;
	}


	

}
