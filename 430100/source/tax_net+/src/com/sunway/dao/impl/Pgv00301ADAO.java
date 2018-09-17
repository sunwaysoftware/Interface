package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgv00301ADAO;
import com.sunway.vo.Pgv00301A;

/**
 * 住宅登记信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv00301ADAO extends BaseDAO implements IPgv00301ADAO {

	private static final String swid = "SWID";
	private static final String nsrmc = "NSRMC";
	private static final String cd00001Zjlx = "CD_00001_ZJLX";
	private static final String zz = "ZZ";
	private static final String lxdh = "LXDH";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String czh = "CZH";
	private static final String bgsj = "BGSJ";
	private static final String sfbg = "SFBG";
	private static final String bglx = "BGLX";
	private static final String zjlx = "ZJLX";
	private static final String ssgx = "SSGX";
	private static final String czr = "CZR";
	private static final String bgmc = "BGMC";
	private static final String recordCount = "TOTAL";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgv00301ADAO#LoadAll(com.sunway.vo.Pgv00301A)
	 */
	
	@Override
	public ArrayList<Pgv00301A> LoadAll(Pgv00301A v00301A) throws Exception {
		ArrayList<Pgv00301A> listResult = new ArrayList<Pgv00301A>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00301A(?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v00301A.getPageIndex());
			call.setInt(3, v00301A.getPageSize());
			call.setString(4, v00301A.getSwid());
			call.setString(5, v00301A.getNsrmc());
			call.setString(6, v00301A.getCd00001Ssgx());
			call.setString(7, v00301A.getCzh());
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
	protected Pgv00301A SetVParameters(ResultSet rs) throws Exception {
		Pgv00301A e = new Pgv00301A();
		e.setRecordCount(rs.getInt(recordCount));
		e.setSwid(rs.getString(swid));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Zjlx(rs.getString(cd00001Zjlx));
		e.setZz(rs.getString(zz));
		e.setLxdh(rs.getString(lxdh));
		//e.setYddh(rs.getString(yddh));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setCzh(rs.getString(czh));
		e.setBgsj(rs.getDate(bgsj));
		e.setSfbg(rs.getBoolean(sfbg));
		e.setBglx(rs.getBoolean(bglx));
		e.setZjlx(rs.getString(zjlx));
		e.setSsgx(rs.getString(ssgx));
		e.setCzr(rs.getString(czr));
		e.setBgmc(rs.getString(bgmc));
		return e;
	}
}
