package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgv12001ADAO;
import com.sunway.vo.Pgv12001A;

/**
 * 登记信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv12001ADAO extends BaseDAO implements IPgv12001ADAO {

	private static final String swid = "SWID";
	private static final String nsrmc = "NSRMC";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String lxdh = "LXDH";
	private static final String zgy = "ZGY";
	private static final String cd00001Hy = "CD_00001_HY";
	private static final String cd00001Jjlx = "CD_00001_JJLX";
	private static final String fcse = "FCSE";
	private static final String tdse = "TDSE";
	private static final String cd00001Mssz = "CD_00001_MSSZ";
	private static final String bh = "BH";
	private static final String cd00001Xz = "CD_00001_XZ";
	private static final String lrdate = "LRDATE";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String czh = "CZH";
	private static final String bgsj = "BGSJ";
	private static final String sfbg = "SFBG";
	private static final String bglx = "BGLX";
	private static final String ssgx = "SSGX";
	private static final String hy = "HY";
	private static final String jjlx = "JJLX";
	private static final String mssz = "MSSZ";
	private static final String xz = "XZ";
	private static final String bgczr = "BGCZR";
	private static final String bgmc = "BGMC";
	private static final String czr = "CZR";
	private static final String recordCount = "TOTAL";
	private static final String recordIndex = "RID";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgv12001ADAO#LoadAll(com.sunway.vo.Pgv12001A)
	 */
	
	@Override
	public ArrayList<Pgv12001A> LoadAll(Pgv12001A v12001A) throws Exception {
		ArrayList<Pgv12001A> listResult = new ArrayList<Pgv12001A>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12001A(?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v12001A.getPageIndex());
			call.setInt(3, v12001A.getPageSize());
			call.setString(4, v12001A.getSwid());
			call.setString(5, v12001A.getNsrmc());
			call.setString(6, v12001A.getCd00001Ssgx());
			call.setString(7, v12001A.getCzh());
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
	protected Pgv12001A SetVParameters(ResultSet rs) throws Exception {
		Pgv12001A e = new Pgv12001A();
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		e.setSwid(rs.getString(swid));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setLxdh(rs.getString(lxdh));
		e.setZgy(rs.getString(zgy));
		e.setCd00001Hy(rs.getString(cd00001Hy));
		e.setCd00001Jjlx(rs.getString(cd00001Jjlx));
		e.setFcse(rs.getDouble(fcse));
		e.setTdse(rs.getDouble(tdse));
		e.setCd00001Mssz(rs.getString(cd00001Mssz));
		e.setBh(rs.getString(bh));
		e.setCd00001Xz(rs.getString(cd00001Xz));
		e.setLrdate(rs.getTimestamp(lrdate));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setCzh(rs.getString(czh));
		e.setBgsj(rs.getDate(bgsj));
		e.setSfbg(rs.getBoolean(sfbg));
		e.setBglx(rs.getBoolean(bglx));
		e.setSsgx(rs.getString(ssgx));
		e.setHy(rs.getString(hy));
		e.setJjlx(rs.getString(jjlx));
		e.setMssz(rs.getString(mssz));
		e.setXz(rs.getString(xz));
		e.setBgczr(rs.getString(bgczr));
		e.setBgmc(rs.getString(bgmc));
		e.setCzr(rs.getString(czr));
		return e;
	}
}
