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

import com.sunway.dao.IPgv00333aDAO;
import com.sunway.vo.Pgv00333a;

/**
 * @author Andy.Gao
 *
 */
public class Pgv00333aDAO extends BaseDAO implements IPgv00333aDAO {

	// property constants
	private static final String qtxzid = "QTXZID";
	private static final String cd00302Fcid = "CD_00302_FCID";
	private static final String cd00002Pssd = "CD_00002_PSSD";
	private static final String qtxznm = "QTXZNM";
	private static final String xzlx = "XZLX";
	private static final String xzxs = "XZXS";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String czr = "CZR";
	private static final String czlx = "CZLX";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgv00333aDAO#GetExecCommand(com.sunway.vo.Pgv00333a)
	 */
	
	@Override
	public Boolean GetExecCommand(Pgv00333a bean) throws Exception {
		Boolean listResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00333A(?,?,?,?)}");
			//傳入輸入參數
			call.setString(1, bean.getQtxzid());
			call.setString(2, bean.getCd00302Fcid());
			call.setString(3, bean.getCd00002Czr());
			call.setString(4, bean.getSysSsgx());
			call.execute();
			listResult = true;
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgv00333aDAO#LoadAll(com.sunway.vo.Pgv00333a)
	 */
	
	@Override
	public ArrayList<Pgv00333a> LoadAll(Pgv00333a bean) throws Exception {
		ArrayList<Pgv00333a> listResult = new ArrayList<Pgv00333a>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00333A(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd00302Fcid());
			call.setString(3, bean.getCd00002Pssd());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00333a SetVParameters(ResultSet rs) throws Exception {
		Pgv00333a e = new Pgv00333a();
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setCd00302Fcid(rs.getString(cd00302Fcid));
		e.setCzr(rs.getString(czr));
		e.setNote(rs.getString(note));
		e.setQtxzid(rs.getString(qtxzid));
		e.setQtxznm(rs.getString(qtxznm));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setXzlx(rs.getInt(xzlx));
		e.setXzxs(rs.getDouble(xzxs));
		e.setCzlx(rs.getInt(czlx));
		return e;
	}
	
}
