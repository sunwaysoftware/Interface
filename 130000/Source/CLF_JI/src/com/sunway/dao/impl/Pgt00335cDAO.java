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

import com.sunway.dao.IPgt00335cDAO;
import com.sunway.vo.Pgt00335c;

/**
 * @author Andy.Gao
 *
 */
public class Pgt00335cDAO extends BaseDAO implements IPgt00335cDAO {

	private static final String cd00302Fcid =  "CD_00302_FCID";
	private static final String cdSlid =  "CD_SLID";
	private static final String cd00001Rootid = "CD_00001_ROOTID";
	private static final String rootnm = "ROOTNM";
	private static final String infonm =  "INFONM";
	private static final String xzxs =  "XZXS";
	private static final String czlx =  "CZLX";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00335cDAO#LoadAll(com.sunway.vo.Pgt00335c)
	 */
	
	@Override
	public ArrayList<Pgt00335c> LoadAll(Pgt00335c bean) throws Exception {
		ArrayList<Pgt00335c> listResult = new ArrayList<Pgt00335c>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00335C(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd00302Fcid());
			call.setString(3, bean.getCdSlid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				Pgt00335c e = new Pgt00335c();
				e.setCd00302Fcid(rs.getString(cd00302Fcid));
				e.setCdSlid(rs.getString(cdSlid));
				e.setCd00001Rootid(rs.getString(cd00001Rootid));
				e.setRootnm(rs.getString(rootnm));
				e.setInfonm(rs.getString(infonm));
				e.setXzxs(rs.getDouble(xzxs));
				e.setCzlx(rs.getInt(czlx));
				listResult.add(e);
				e = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

}
