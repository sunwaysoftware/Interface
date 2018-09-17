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

import com.sunway.dao.IPgvCz00006DAO;
import com.sunway.vo.PgvCz00006;

/**
 * 
 * 变更类型
 * @author Andy.Gao
 *
 */
public class PgvCz00006DAO extends BaseDAO implements IPgvCz00006DAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgvCz00006DAO#LoadByUpdate()
	 */
	
	@Override
	public ArrayList<PgvCz00006> LoadByUpdate() throws Exception {
		ArrayList<PgvCz00006> listResult = new ArrayList<PgvCz00006>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLCZ00006(?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(new PgvCz00006(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgvCz00006DAO#LoadByDelete()
	 */
	
	@Override
	public ArrayList<PgvCz00006> LoadByDelete() throws Exception {
		ArrayList<PgvCz00006> listResult = new ArrayList<PgvCz00006>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLCZ00007(?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(new PgvCz00006(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

}
