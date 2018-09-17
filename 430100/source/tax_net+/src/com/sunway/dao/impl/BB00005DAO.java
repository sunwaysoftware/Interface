/**
 * 
 */
package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IBB00005DAO;
import com.sunway.util.ConvertUtil;
import com.sunway.vo.BF00005;

/**
 * @author Andy.Gao
 *
 */
public class BB00005DAO extends BaseDAO implements IBB00005DAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IBB00005DAO#LoadAll(com.sunway.vo.BF00005)
	 */
	
	@Override
	public BF00005 LoadAll(BF00005 bean) throws Exception {
		BF00005 listResult = new BF00005();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_00005(?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getSsgxId());
			call.setDate(3, ConvertUtil.utilDateToSqlDate(bean.getJysjMin()));
			call.setDate(4,  ConvertUtil.utilDateToSqlDate(bean.getJysjMax()));
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.setPgzh(rs.getDouble("pgzh"));
				listResult.setGpgzh(rs.getDouble("gpgzh"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	@Override
	public BF00005 LoadAll02(BF00005 bean) throws Exception {
		BF00005 listResult = new BF00005();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_02005(?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getSsgxId());
			call.setDate(3, ConvertUtil.utilDateToSqlDate(bean.getJysjMin()));
			call.setDate(4,  ConvertUtil.utilDateToSqlDate(bean.getJysjMax()));
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.setPgzh(rs.getDouble("pgzh"));
				listResult.setGpgzh(rs.getDouble("gpgzh"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
}
