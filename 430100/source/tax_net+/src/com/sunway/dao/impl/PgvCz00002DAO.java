package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import com.sunway.dao.IPgvCz00002DAO;
import com.sunway.vo.PgvCz00002;

/**
 * 审核类型名称
 * @category 审核类型名称
 * @author Lee
 * @version 1.0
 */

public class PgvCz00002DAO extends BaseDAO implements IPgvCz00002DAO {

	private static final String SHLX = "shlx";
	private static final String SHLXMC = "shlxmc";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgvCz00002DAO#LoadAll(com.sunway.vo.PgvCz00002)
	 */
	
	@Override
	public ArrayList<PgvCz00002> LoadAll(PgvCz00002 shlxmc) throws Exception {
		ArrayList<PgvCz00002> listResult = new ArrayList<PgvCz00002>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLCZ00002(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setString(2, shlxmc.getShlx().toString());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetVParameters(rs));			
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected PgvCz00002 SetVParameters(ResultSet rs) throws Exception {
		PgvCz00002 e = new PgvCz00002();
		e.setShlx(rs.getInt(SHLX));
		e.setShlxmc(rs.getString(SHLXMC));
		return e;
	}
}
