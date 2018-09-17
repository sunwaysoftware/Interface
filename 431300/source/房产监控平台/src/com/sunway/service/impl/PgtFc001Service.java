package com.sunway.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgtFc001DAO;
import com.sunway.service.IPgtFc001Service;
import com.sunway.vo.PgtFc001;
import com.sunway.vo.PgtFc002;
import com.sunway.vo.PgtFc003;
import com.sunway.vo.PgvFc001;

public class PgtFc001Service implements IPgtFc001Service   {
	private  IPgtFc001DAO tFc001Dao;

	@Override
	public ArrayList<PgvFc001> LoadAll(PgvFc001 fc001) throws Exception {
		return tFc001Dao.LoadAll( fc001);
	}

	@Override
	public PgvFc001 LoadByPrimaryKey(PgtFc001 fc001) throws Exception {
		return tFc001Dao.LoadByPrimaryKey(fc001);
	}

	@Override
	public boolean RegistTax(PgtFc002 fc002) throws Exception {
		return tFc001Dao.RegistTax(fc002);
	}

	public IPgtFc001DAO gettFc001Dao() {
		return tFc001Dao;
	}

	public void settFc001Dao(IPgtFc001DAO tFc001Dao) {
		this.tFc001Dao = tFc001Dao;
	}

	@Override
	public ArrayList<PgvFc001> LoadAllZzYw(PgvFc001 fc001) throws Exception {
		return tFc001Dao.LoadAllZzYw(fc001);
	}

	@Override
	public ArrayList<PgvFc001> LoadAllTsYw(PgvFc001 fc001) throws Exception {
		return tFc001Dao.LoadAllTsYw(fc001);
	}

	@Override
	public ArrayList<PgvFc001> LoadAllCwSjCl(PgvFc001 fc001) throws Exception {
		return tFc001Dao.LoadAllCwSjCl(fc001);
	}

	@Override
	public boolean BreakService(PgtFc002 fc002) throws Exception {
		return tFc001Dao.BreakService(fc002);
	}
	@Override
	public boolean AuditService(PgtFc002 fc002) throws Exception {
		return tFc001Dao.AuditService(fc002);
	}
	@Override
	public boolean RebateTax(PgtFc002 fc002) throws Exception {
		return tFc001Dao.RebateTax(fc002);
	}

	@Override
	public boolean ProcesErrorData(PgtFc002 fc002) throws Exception {
		return tFc001Dao.ProcesErrorData(fc002);
	}

	@Override
	public ArrayList<PgvFc001> LoadAllOverodueTax(PgvFc001 fc001)
			throws Exception {
		return tFc001Dao.LoadAllOverodueTax(fc001);
	}

	@Override
	public ArrayList<PgvFc001> LoadAllPaymentInfo(PgvFc001 fc001)
			throws Exception {
		return tFc001Dao.LoadAllPaymentInfo(fc001);
	}	
	@Override
	public ArrayList<PgvFc001> LoadAllTaxAuditedInfo(PgvFc001 fc001)
			throws Exception {
		return tFc001Dao.LoadAllTaxAuditedInfo(fc001);
	}
	@Override
	public ArrayList<PgvFc001> LoadAllHouseInfo(PgvFc001 fc001)
			throws Exception {
		return tFc001Dao.LoadAllHouseInfo(fc001);
	}

	@Override
	public ArrayList<PgvFc001> LoadAllUnpaidRecord(PgvFc001 fc001)
			throws Exception {
		return tFc001Dao.LoadAllUnpaidRecord(fc001);
	}

	@Override
	public OutputStream ExportOverodueTax(PgvFc001 fc001) throws Exception {
		return tFc001Dao.ExportOverodueTax(fc001);
	}

	@Override
	public OutputStream ExportPaymentInfo(PgvFc001 fc001) throws Exception {
		return tFc001Dao.ExportPaymentInfo(fc001);
	}

	@Override
	public OutputStream ExportHouseInfo(PgvFc001 fc001) throws Exception {
		return tFc001Dao.ExportHouseInfo(fc001);
	}

	@Override
	public OutputStream ExportUnpaidRecord(PgvFc001 fc001) throws Exception {
		return tFc001Dao.ExportUnpaidRecord(fc001);
	}

	@Override
	public PgtFc003 LoadByPrimaryKey(PgtFc003 fc003) throws Exception {		
		return tFc001Dao.LoadByPrimaryKey(fc003);
	}

	@Override
	public PgtFc002 LoadByPrimaryKey(PgtFc002 fc002) throws Exception {		
		return tFc001Dao.LoadByPrimaryKey(fc002);
	}
}
