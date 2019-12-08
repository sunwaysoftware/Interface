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

import com.sunway.dao.IPgt12002eDAO;
import com.sunway.vo.Pgv12002e;

/**
 * @author Andy.Gao
 *
 */
public class Pgt12002eDAO extends BaseDAO implements IPgt12002eDAO {

	private static final String qtxzId = "CD_00053_QTXZID";
	private static final String qtxzNm = "QTXZNM";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12002eDAO#LoadAll()
	 */
	
	@Override
	public ArrayList<Pgv12002e> LoadAll(Pgv12002e v12002e) throws Exception {
		ArrayList<Pgv12002e> listResult = new ArrayList<Pgv12002e>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12002E(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注冊輸入參數
			call.setString(2, v12002e.getCd12002Dcid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				Pgv12002e e = new Pgv12002e();
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
