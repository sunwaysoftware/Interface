package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgvBb00009_bDAO;
import com.sunway.vo.PgvBb00009_b;

/**
 * 报表9
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public class PgvBb00009_bDAO extends BaseDAO implements IPgvBb00009_bDAO {

	private static final String cd00002Pssd = "CD_00002_PSSD";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String cd00001Fwlx = "CD_00001_FWLX";
	private static final String tdse = "TDSE";
	private static final String fcse = "FCSE";
	private static final String syqmj = "SYQMJ";
	private static final String zjzmj = "ZJZMJ";
	private static final String fcpg = "FCPG";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String fcCount = "FCCOUNT";
	private static final String pgCount = "PGCOUNT";
	private static final String fwlx = "FWLX";
	private static final String bm = "BM";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgvBb00009_bDAO#LoadAll(com.sunway.vo.PgvBb00009_b)
	 */
	
	@Override
	public ArrayList<PgvBb00009_b> LoadAll(PgvBb00009_b bb00009_b) throws Exception {
		ArrayList<PgvBb00009_b> listResult = new ArrayList<PgvBb00009_b>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BB_00009_B(?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, bb00009_b.getCd00001Ssgx());
			call.setString(3, bb00009_b.getCd00002Pssd());
			call.setBoolean(4, bb00009_b.getSfssgx());
			call.setString(5, bb00009_b.getCd00002Czr());
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
	protected PgvBb00009_b SetVParameters(ResultSet rs) throws Exception {
		PgvBb00009_b e = new PgvBb00009_b();
		e.setBm(rs.getInt(bm));
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setTdse(rs.getDouble(tdse));
		e.setFcse(rs.getDouble(fcse));
		e.setSyqmj(rs.getDouble(syqmj));
		e.setZjzmj(rs.getDouble(zjzmj));
		e.setFcpg(rs.getDouble(fcpg));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setFcCount(rs.getShort(fcCount));
		e.setPgCount(rs.getShort(pgCount));
		e.setFwlx(rs.getString(fwlx));
		return e;
	}
}
