package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgvBb00001DAO;
import com.sunway.vo.PgvBb00001;

/**
 * 报表1
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public class PgvBb00001DAO extends BaseDAO implements IPgvBb00001DAO {

	private static final String infonm = "INFONM";
	private static final String tdCount = "TDCOUNT";
	private static final String fcCount = "FCCOUNT";
	private static final String tdmnCount = "TDMNCOUNT";
	private static final String fcmnCount = "FCMNCOUNT";
	private static final String bm = "BM";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgvBb00001DAO#LoadAll(com.sunway.vo.PgvBb00001)
	 */
	
	@Override
	public ArrayList<PgvBb00001> LoadAll(PgvBb00001 bb00001) throws Exception {
		ArrayList<PgvBb00001> listResult = new ArrayList<PgvBb00001>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BB_00001(?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, bb00001.getCd00002Pssd());
			call.setString(3, bb00001.getCd00001Ssgx());
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
	protected PgvBb00001 SetVParameters(ResultSet rs) throws Exception {
		PgvBb00001 e = new PgvBb00001();
		e.setBm(rs.getInt(bm));
		e.setInfonm(rs.getString(infonm));
		e.setTdCount(rs.getShort(tdCount));
		e.setFcCount(rs.getShort(fcCount));
		e.setTdmnCount(rs.getShort(tdmnCount));
		e.setFcmnCount(rs.getShort(fcmnCount));
		return e;
	}
}
