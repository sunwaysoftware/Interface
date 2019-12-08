package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgvBb00001_bDAO;
import com.sunway.vo.PgvBb00001_b;

/**
 * 报表1
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public class PgvBb00001_bDAO extends BaseDAO implements IPgvBb00001_bDAO {

	private static final String infonm = "INFONM";
	private static final String tdCount = "TDCOUNT";
	private static final String fcCount = "FCCOUNT";
	private static final String tdmnCount = "TDMNCOUNT";
	private static final String fcmnCount = "FCMNCOUNT";
	private static final String bm = "BM";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgvBb00001_bDAO#LoadAll(com.sunway.vo.PgvBb00001_b)
	 */
	
	@Override
	public ArrayList<PgvBb00001_b> LoadAll(PgvBb00001_b bb00001_b) throws Exception {
		ArrayList<PgvBb00001_b> listResult = new ArrayList<PgvBb00001_b>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BB_00001_B(?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, bb00001_b.getCd00002Pssd());
			call.setBoolean(3, bb00001_b.getSfssgx());
			call.setString(4, bb00001_b.getCd00001Ssgx());
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
	protected PgvBb00001_b SetVParameters(ResultSet rs) throws Exception {
		PgvBb00001_b e = new PgvBb00001_b();
		e.setBm(rs.getInt(bm));
		e.setInfonm(rs.getString(infonm));
		e.setTdCount(rs.getShort(tdCount));
		e.setFcCount(rs.getShort(fcCount));
		e.setTdmnCount(rs.getShort(tdmnCount));
		e.setFcmnCount(rs.getShort(fcmnCount));
		return e;
	}
}
