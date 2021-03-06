package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgvBb00010DAO;
import com.sunway.vo.PgvBb00010;

/**
 * 报表10
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public class PgvBb00010DAO extends BaseDAO implements IPgvBb00010DAO {

	private static final String cd00002Pssd = "CD_00002_PSSD";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String cd00001Tdyt = "CD_00001_TDYT";
	private static final String tdse = "TDSE";
	private static final String fcse = "FCSE";
	private static final String syqmj = "SYQMJ";
	private static final String zjzmj = "ZJZMJ";
	private static final String fcpg = "FCPG";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String mxCount = "MXCOUNT";
	private static final String pgCount = "PGCOUNT";
	private static final String tdyt = "TDYT";
	private static final String bm = "BM";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgvBb00010DAO#LoadAll(com.sunway.vo.PgvBb00010)
	 */
	
	@Override
	public ArrayList<PgvBb00010> LoadAll(PgvBb00010 bb00010) throws Exception {
		ArrayList<PgvBb00010> listResult = new ArrayList<PgvBb00010>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BB_00010(?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, bb00010.getCd00001Ssgx());
			call.setString(3, bb00010.getCd00002Pssd());
			call.setString(4, bb00010.getCd00002Czr());
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
	protected PgvBb00010 SetVParameters(ResultSet rs) throws Exception {
		PgvBb00010 e = new PgvBb00010();
		e.setBm(rs.getInt(bm));
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00001Tdyt(rs.getString(cd00001Tdyt));
		e.setTdse(rs.getDouble(tdse));
		e.setFcse(rs.getDouble(fcse));
		e.setSyqmj(rs.getDouble(syqmj));
		e.setZjzmj(rs.getDouble(zjzmj));
		e.setFcpg(rs.getDouble(fcpg));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setMxCount(rs.getShort(mxCount));
		e.setPgCount(rs.getShort(pgCount));
		e.setTdyt(rs.getString(tdyt));
		return e;
	}
}
