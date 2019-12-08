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
import com.sunway.dao.IBB00002DAO;
import com.sunway.vo.BF00002;

/**
 * 
 * 正常评估查询
 * @author Lee
 *
 */
public class BB00002DAO extends BaseDAO implements IBB00002DAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IBB00002DAO#LoadAll(com.sunway.vo.BF00002)
	 */
	
	@Override
	public ArrayList<BF00002> LoadAll(BF00002 bean) throws Exception {
		ArrayList<BF00002> listResult = new ArrayList<BF00002>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_00002(?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd00001Ssgx());
			call.setString(3, bean.getCd00002Pssd());
			call.setString(4, bean.getCd00002Czr());
			call.setString(5, bean.getFwlxids());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				BF00002 e = new BF00002();
				e.setBm(rs.getInt("bm"));
				e.setCd00001Ssgx(rs.getString("CD_00001_SSGX"));
				e.setCd00002Pssd(rs.getString("CD_00002_PSSD"));
				e.setHs(rs.getInt("hs"));
				e.setSbjg(rs.getBigDecimal("sbjg"));
				e.setPgjg(rs.getBigDecimal("pgjg"));
				e.setCd00002Czr(rs.getString("CD_00002_CZR"));
				e.setHdjg(rs.getBigDecimal("hdjg"));
				e.setCd00001Ssgx1(rs.getString("CD_00001_SSGX1"));
				e.setSsgx(rs.getString("hy"));
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




















