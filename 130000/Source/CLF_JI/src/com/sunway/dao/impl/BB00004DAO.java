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

import com.sunway.dao.IBB00004DAO;
import com.sunway.vo.BF00004;

/**
 * @author Andy.Gao
 *
 */
public class BB00004DAO extends BaseDAO implements IBB00004DAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IBB00004DAO#LoadAll(com.sunway.vo.BF00004)
	 */
	
	@Override
	public ArrayList<BF00004> LoadAll(BF00004 bean) throws Exception {
		ArrayList<BF00004> listResult = new ArrayList<BF00004>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_00004(?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getSsgxId());
			call.setString(3, bean.getCzr());
			call.setString(4, bean.getPssd());
			call.setDouble(5, bean.getJyjgMin());
			call.setDouble(6, bean.getJyjgMax());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				BF00004 e = new BF00004();
				e.setBm(rs.getInt("bm"));
				e.setHs(rs.getInt("hs"));
				e.setSsgxNm(rs.getString("ssgx"));
				e.setPssd(rs.getString("cd_00002_pssd"));
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
