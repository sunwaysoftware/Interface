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

import com.sunway.dao.IPgt12004dDAO;
import com.sunway.vo.Pgv12004d;

/**
 * 
 * 成本法、收益法房屋设施参数表
 * @author Andy.Gao
 *
 */
public class Pgt12004dDAO extends BaseDAO implements IPgt12004dDAO {

	private static final String cd00001Fwss = "CD_00001_FWSS";
	private static final String fwssNm = "FWSS";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12004dDAO#LoadAll(com.sunway.vo.Pgv12004e)
	 */
	
	@Override
	public ArrayList<Pgv12004d> LoadAll(Pgv12004d v12004d) throws Exception {
		ArrayList<Pgv12004d> listResult = new ArrayList<Pgv12004d>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12004D(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注冊輸入參數
			call.setString(2, v12004d.getCd12004Mxid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				Pgv12004d e = new Pgv12004d();
				e.setCd00001Fwss(rs.getString(cd00001Fwss));
				e.setFwss(rs.getString(fwssNm));
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
