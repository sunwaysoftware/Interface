package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt12005wDAO;
import com.sunway.vo.Pgv12001;

/**
 * 成本、收益法数据操作状态(没有添加到操作列表的数据)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */
public class Pgt12005wDAO extends BaseDAO implements IPgt12005wDAO {

	private static final String total = "TOTAL";
	private static final String rid = "RID";
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
	private static final String ssgx = "SSGX";
	private static final String hy = "HY";
	private static final String jjlx = "JJLX";
	private static final String mssz = "MSSZ";
	private static final String xz = "XZ";
	private static final String czr = "CZR";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt12005wDAO#LoadAll(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public ArrayList<Pgv12001> LoadAll(Pgv12001 v12001) throws Exception {
		ArrayList<Pgv12001> listResult = new ArrayList<Pgv12001>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120051(?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v12001.getPageIndex());
			call.setInt(3, v12001.getPageSize());
			call.setString(4, v12001.getSwid());
			call.setString(5, v12001.getNsrmc());
			call.setString(6, v12001.getCd00001Ssgx());
			call.setString(7, v12001.getSysPssd());
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
	protected Pgv12001 SetVParameters(ResultSet rs) throws Exception {
		Pgv12001 e = new Pgv12001();
		e.setRecordCount(rs.getInt(total));
		e.setRecordIndex(rs.getInt(rid));
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
		e.setSsgx(rs.getString(ssgx));
		e.setHy(rs.getString(hy));
		e.setJjlx(rs.getString(jjlx));
		e.setMssz(rs.getString(mssz));
		e.setXz(rs.getString(xz));
		e.setCzr(rs.getString(czr));
		return e;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt12005wDAO#GetExecTJ(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public Boolean GetExecTJ(Pgv12001 v12001) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_12005(?,?,?,?)}");
			for(Integer step=0; step<v12001.getV12001List().size(); step++){
				//传入输入参数
				call.setString(1, v12001.getSysPssd());
				call.setString(2, v12001.getV12001List().get(step).getSwid());
				call.setString(3, v12001.getNsrmc());
				call.setString(4, v12001.getSysSsgx());
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
	 * @see com.sunway.dao.IPgt12005wDAO#GetExecTJAll(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public Boolean GetExecTJAll(Pgv12001 v12001) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_12005(?,?,?,?)}");
			// 传入输入参数
			call.setString(1, v12001.getSysPssd());
			call.setString(2, v12001.getSwid());
			call.setString(3, v12001.getNsrmc());
			call.setString(4, v12001.getSysSsgx());
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
