/**
 * 
 */
package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgt12004eDAO;
import com.sunway.vo.Pgv12004e;

/**
 * 
 * 成本法明細其它评税参数表
 * @author Andy.Gao
 *
 */
public class Pgt12004eDAO extends BaseDAO implements IPgt12004eDAO {

	private static final String qtxzId = "CD_00053_QTXZID";
	private static final String qtxzNm = "QTXZNM";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12004eDAO#LoadAll(com.sunway.vo.Pgv12004e)
	 */
	
	@Override
	public ArrayList<Pgv12004e> LoadAll(Pgv12004e v12004e) throws Exception {
		ArrayList<Pgv12004e> listResult = new ArrayList<Pgv12004e>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12004E(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注冊輸入參數
			call.setString(2, v12004e.getCd12004Mxid());
			call.setInt(3, v12004e.getXzlx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				Pgv12004e e = new Pgv12004e();
				e.setCd00053Qtxzid(rs.getString(qtxzId));
				e.setQtxznm(rs.getString(qtxzNm));
				listResult.add(e);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
}
