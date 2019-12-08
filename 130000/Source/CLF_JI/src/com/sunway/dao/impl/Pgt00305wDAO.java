package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00305wDAO;
import com.sunway.vo.Pgv00302;

/**
 * 成本、收益法数据操作状态(没有添加到操作列表的数据)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */
public class Pgt00305wDAO extends BaseDAO implements IPgt00305wDAO {

	private static final String total = "TOTAL";
	private static final String rid = "RID";
	private static final String fcid = "FCID";
	private static final String cd00301Swid = "CD_00301_SWID";
	private static final String cd00303Lfid = "CD_00303_LFID";
	private static final String cd00001Fwlx = "CD_00001_FWLX";
	private static final String cd00001Jylx = "CD_00001_JYLX";
	private static final String cd00001Jzjg = "CD_00001_JZJG";
	private static final String jzmj = "JZMJ";
	private static final String cd00001Fwcx = "CD_00001_FWCX";
	private static final String cd00001Cgzk = "CD_00001_CGZK";
	private static final String szlc = "SZLC";
	private static final String bwjfh = "BWJFH";
	private static final String jyjg = "JYJG";
	private static final String tdsyqmj = "TDSYQMJ";
	private static final String rjl = "RJL";
	private static final String jysj = "JYSJ";
	private static final String fdcdat = "FDCDAT";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String nsrmc = "NSRMC";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String cd00352Xqdm = "CD_00352_XQDM";
	private static final String cd00001Szqy = "CD_00001_SZQY";
	private static final String ywdt = "YWDT";
	private static final String zlc = "ZLC";
	private static final String xqnm = "XQNM";
	private static final String xqbm = "XQBM";
	private static final String szqy = "SZQY";
	private static final String fwlx = "FWLX";
	private static final String jylx = "JYLX";
	private static final String jzjg = "JZJG";
	private static final String fwcx = "FWCX";
	private static final String cgzk = "CGZK";
	private static final String czr = "CZR";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00305wDAO#LoadAll(com.sunway.vo.Pgv00302)
	 */
	
	@Override
	public ArrayList<Pgv00302> LoadAll(Pgv00302 v00302) throws Exception {
		ArrayList<Pgv00302> listResult = new ArrayList<Pgv00302>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003051(?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v00302.getPageIndex());
			call.setInt(3, v00302.getPageSize());
			call.setString(4, v00302.getFcid());
			call.setString(5, v00302.getCd00301Swid());
			call.setString(6, v00302.getNsrmc());
			call.setString(7, v00302.getCd00001Ssgx());
			call.setString(8, v00302.getSysPssd());
			call.execute();
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
	protected Pgv00302 SetVParameters(ResultSet rs) throws Exception {
		Pgv00302 e = new Pgv00302();
		e.setRecordCount(rs.getInt(total));
		e.setRecordIndex(rs.getInt(rid));
		e.setFcid(rs.getString(fcid));
		e.setCd00301Swid(rs.getString(cd00301Swid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJzmj(rs.getDouble(jzmj));
		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
		e.setCd00001Cgzk(rs.getString(cd00001Cgzk));
		e.setSzlc(rs.getShort(szlc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setJyjg(rs.getDouble(jyjg));
		//e.setDtgj(rs.getDouble(dtgj));
		e.setTdsyqmj(rs.getDouble(tdsyqmj));
		e.setRjl(rs.getDouble(rjl));
		e.setJysj(rs.getDate(jysj));
		e.setFdcdat(rs.getString(fdcdat));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00352Xqdm(rs.getString(cd00352Xqdm));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setYwdt(rs.getString(ywdt));
		e.setZlc(rs.getString(zlc));
		//e.setFwtdzl(rs.getString(fwtdzl));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setFwlx(rs.getString(fwlx));
		e.setJylx(rs.getString(jylx));
		e.setJzjg(rs.getString(jzjg));
		e.setFwcx(rs.getString(fwcx));
		e.setCgzk(rs.getString(cgzk));
		e.setCzr(rs.getString(czr));
		return e;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00305wDAO#GetExecTJ(com.sunway.vo.Pgv00302)
	 */
	
	@Override
	public Boolean GetExecTJ(Pgv00302 v00302) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00305(?,?,?,?,?)}");
			for(Integer step=0; step<v00302.getV00302List().size(); step++){
				//传入输入参数
				call.setString(1, v00302.getSysPssd());
				call.setString(2, v00302.getV00302List().get(step).getFcid());
				call.setString(3, v00302.getCd00301Swid());
				call.setString(4, v00302.getNsrmc());
				call.setString(5, v00302.getCd00001Ssgx());
				call.execute();
			}
			tran.commit();
			bResult = true;
		} catch (Exception e) {
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00305wDAO#GetExecTJAll(com.sunway.vo.Pgv00302)
	 */
	
	@Override
	public Boolean GetExecTJAll(Pgv00302 v00302) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00305(?,?,?,?,?)}");
			// 传入输入参数
			call.setString(1, v00302.getSysPssd());
			call.setString(2, v00302.getFcid());
			call.setString(3, v00302.getCd00301Swid());
			call.setString(4, v00302.getNsrmc());
			call.setString(5, v00302.getCd00001Ssgx());
			call.execute();
			tran.commit();
			bResult = true;
		} catch (Exception e) {
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}
}
