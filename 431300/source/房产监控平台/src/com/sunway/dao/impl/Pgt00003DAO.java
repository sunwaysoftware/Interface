package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt00003DAO;
import com.sunway.vo.Pgt00003;
public class Pgt00003DAO extends BaseDAO implements IPgt00003DAO {

		private static final String CD00002CZR="CD_00002_CZR";
		private static final String UPDDATE="UPDDATE";
		private static final String EXPIRYDAYS="EXPIRYDAYS";
		@Override
		public boolean GetUpdateCommand(Pgt00003 expriyDays) throws Exception {
			boolean bResult = false;
			CallableStatement call = null;
			Connection conn = null;
			Session session = null;
			Transaction tran = null;
			try {
				session = getSession();
				tran = session.beginTransaction();
				conn = super.getConnection();
				call = conn.prepareCall("{call PGSP_UPDT00003(?,?)}");
				call.setInt(1, expriyDays.getExpriyDays());
				call.setString(2, expriyDays.getCd00002Czr());
				call.execute();
				tran.commit();
				bResult = true;
			} catch (Exception e) {
				tran.rollback();
				throw e;
			} finally {
				getFree(call, conn, session);
			}
			return bResult;
		}

		@Override
		public Pgt00003 LoadByPrimaryKey() throws Exception {
			ArrayList<Pgt00003> listResult = new ArrayList<Pgt00003>();
			ResultSet rs = null;
			CallableStatement call = null;
			Connection conn = null;
			
			try {
				
				conn = super.getConnection();
				call = conn.prepareCall("{call PGSP_GETT00003(?)}");
				// 注册输出参数
				call.registerOutParameter(1, OracleTypes.CURSOR);
				call.execute();
				// 返回数据集
				rs = (ResultSet) call.getObject(1);
				while (null != rs && rs.next()) {
					listResult.add(SetTParameters(rs));
				}
			} catch (Exception e) {
				throw e;
			} finally {
				getFree(rs, call, conn);
			}
			if (listResult != null && listResult.size() > 0)
				return listResult.get(0);
			else
				return null;
		}
		/**
		 * View数据转存
		 * 
		 * @param rs数据集
		 * @return 数据实体
		 * @throws Exception
		 */
		protected Pgt00003 SetTParameters(ResultSet rs) throws Exception {
			Pgt00003 e = new Pgt00003();
			e.setExpriyDays(rs.getInt(EXPIRYDAYS));
			e.setUpddate(rs.getTimestamp(UPDDATE));
			e.setCd00002Czr(rs.getString(CD00002CZR));
			return e;
		}
		
}
