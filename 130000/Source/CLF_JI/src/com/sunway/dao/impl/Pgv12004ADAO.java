package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgv12004ADAO;
import com.sunway.vo.Pgv12004A;

/**
 * 明细信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv12004ADAO extends BaseDAO implements IPgv12004ADAO {

	private static final String mxid = "MXID";
	private static final String cd12003aFcid = "CD_12003A_FCID";
	private static final String cd12002aDcid = "CD_12002A_DCID";
	private static final String cd12001aSwid = "CD_12001A_SWID";
	private static final String fdcmc = "FDCMC";
	private static final String szcc = "SZCC";
	private static final String bwjfh = "BWJFH";
	private static final String cd00001Jzjg = "CD_00001_JZJG";
	private static final String cd00001Fwyt = "CD_00001_FWYT";
	private static final String ytjzmj = "YTJZMJ";
	private static final String fcyz = "FCYZ";
	private static final String cd00001Xjbz = "CD_00001_XJBZ";
	private static final String cd00001Fwcx = "CD_00001_FWCX";
	private static final String lrdate = "LRDATE";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String cd12053Ddid = "CD_12053_DDID";
	private static final String gytzj = "GYTZJ";
	private static final String cd00001Mssz = "CD_00001_MSSZ";
	private static final String czh = "CZH";
	private static final String bgsj = "BGSJ";
	private static final String sfbg = "SFBG";
	private static final String bglx = "BGLX";
	private static final String ddnm = "DDNM";
	private static final String nsrmc = "NSRMC";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String bgczr = "BGCZR";
	private static final String jzjg = "JZJG";
	private static final String xjbz = "XJBZ";
	private static final String fwcx = "FWCX";
	private static final String fwyt = "FWYT";
	private static final String mssz = "MSSZ";
	private static final String bgmc = "BGMC";
	private static final String czr = "CZR";
	private static final String recordCount = "TOTAL";
	private static final String recordIndex = "RID";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgv12004ADAO#LoadAll(com.sunway.vo.Pgv12004A)
	 */
	
	@Override
	public ArrayList<Pgv12004A> LoadAll(Pgv12004A v12004A) throws Exception {
		ArrayList<Pgv12004A> listResult = new ArrayList<Pgv12004A>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12004A(?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v12004A.getPageIndex());
			call.setInt(3, v12004A.getPageSize());
			call.setString(4, v12004A.getCd12001aSwid());
			call.setString(5, v12004A.getNsrmc());
			call.setString(6, v12004A.getMxid());
			call.setString(7, v12004A.getCd00001Ssgx());
			call.setString(8, v12004A.getCzh());
			call.execute();
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetVParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv12004A SetVParameters(ResultSet rs) throws Exception {
		Pgv12004A e = new Pgv12004A();
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		e.setMxid(rs.getString(mxid));
		e.setCd12003aFcid(rs.getString(cd12003aFcid));
		e.setCd12002aDcid(rs.getString(cd12002aDcid));
		e.setCd12001aSwid(rs.getString(cd12001aSwid));
		e.setFdcmc(rs.getString(fdcmc));
		e.setSzcc(rs.getString(szcc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setCd00001Fwyt(rs.getString(cd00001Fwyt));
		e.setYtjzmj(rs.getDouble(ytjzmj));
		e.setFcyz(rs.getDouble(fcyz));
		e.setCd00001Xjbz(rs.getString(cd00001Xjbz));
		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
		e.setLrdate(rs.getTimestamp(lrdate));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setCd12053Ddid(rs.getString(cd12053Ddid));
		e.setGytzj(rs.getDouble(gytzj));
		e.setCd00001Mssz(rs.getString(cd00001Mssz));
		e.setCzh(rs.getString(czh));
		e.setBgsj(rs.getDate(bgsj));
		e.setSfbg(rs.getBoolean(sfbg));
		e.setBglx(rs.getBoolean(bglx));
		e.setDdnm(rs.getString(ddnm));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setBgczr(rs.getString(bgczr));
		e.setJzjg(rs.getString(jzjg));
		e.setXjbz(rs.getString(xjbz));
		e.setFwcx(rs.getString(fwcx));
		e.setFwyt(rs.getString(fwyt));
		e.setMssz(rs.getString(mssz));
		e.setBgmc(rs.getString(bgmc));
		e.setCzr(rs.getString(czr));
		return e;
	}
}
