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

import com.sunway.dao.IBB00003DAO;
import com.sunway.util.Common;
import com.sunway.vo.BF00003;

/**
 * @author Lee
 *
 */
public class BB00003DAO extends BaseDAO implements IBB00003DAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IBB00003DAO#LoadAll(com.sunway.vo.BF00003)
	 */
	
	@Override
	public ArrayList<BF00003> LoadAll(BF00003 bean) throws Exception {
		ArrayList<BF00003> listResult = new ArrayList<BF00003>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_00003(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd00001Ssgx());
			call.setString(3, bean.getCd00002Pssd());
			call.setString(4, bean.getCd00002Czr());
			call.setString(5, bean.getCd00301Swid());
			call.setString(6, bean.getCd00001Zjlx());
			call.setString(7, bean.getNsrmc());
			call.setString(8, bean.getLxdh());
			call.setString(9, bean.getZcdzl());
			call.setString(10, bean.getZcdzbm());
			call.setString(11, bean.getCd00352Xqdm());
			call.setString(12, bean.getFczh());
			call.setString(13, bean.getCd00001Jzjg());
			call.setShort(14, bean.getSzlc());
			call.setString(15, bean.getCd00001Jylx());
			call.setDouble(16, bean.getJyjg_min());
			call.setDouble(17, bean.getJyjg_max());
			call.setString(18, bean.getCd00001Fwlx());
			call.setDouble(19, bean.getJyjg_min());
			call.setDouble(20, bean.getJyjg_max());
			call.setDate(21, Common.converDate(bean.getDjrq()));
			call.setDate(22, Common.converDate(bean.getJysj()));
			call.setString(23, bean.getCd00001Szqy());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				BF00003 e = new BF00003();
				e.setBm(rs.getInt("bm"));
				e.setCd00001Ssgx(rs.getString("CD_00001_SSGX"));
				e.setCd00002Pssd(rs.getString("CD_00002_PSSD"));
				e.setSbjg(rs.getBigDecimal("sbjg"));
				e.setPgjg(rs.getBigDecimal("pgjg"));
				e.setCd00002Czr(rs.getString("CD_00002_CZR"));
				e.setHdjg(rs.getBigDecimal("hdjg"));
				e.setSsgx(rs.getString("ssgx"));
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
