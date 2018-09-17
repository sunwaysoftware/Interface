/**
 * 
 */
package com.sunway.dao.impl;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IFc003DAO;

/**
 * @author Amani
 * 
 */
public class Fc003DAO extends BaseDAO implements IFc003DAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunway.dao.IFc003DAO#insData()
	 */
	@Override
	public boolean insData(int id, String slid, String ssqy, InputStream image)
			throws Exception {
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;

		session = getSession();
		tran = session.beginTransaction();
		conn = super.getConnection();
		call = conn
				.prepareCall("INSERT INTO FC003(id, slid, ssqy, image) VALUES (:pID,:pSLID,:pSSQY,:pIMAGE)");
		// 傳入輸入參數
		call.setInt("pID", id);
		call.setString("pSLID", slid);
		call.setString("pSSQY", ssqy);
		call.setBlob("pIMAGE", image);
		call.execute();
		tran.commit();
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunway.dao.IFc003DAO#readData()
	 */
	@Override
	public InputStream readData(int id) throws Exception {
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("SELECT image FROM fc003 WHERE id=?");
			// 注册输出参数
			call.setInt(1, id);
			call.execute();
			// 返回數據集
			rs = call.getResultSet();
			while (null != rs && rs.next()) {
				return rs.getBlob("image").getBinaryStream();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
