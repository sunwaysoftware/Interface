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
import org.hibernate.Transaction;

import com.sunway.dao.IPgt02031aDAO;
import com.sunway.vo.Pgt02031a;

/**
 * 
 * 收益法评税其它修正参数表
 * @author Andy.Gao
 *
 */
public class Pgt02031aDAO extends BaseDAO implements IPgt02031aDAO {

	private static final String qtxzid = "QTXZID";				//对象编号
	private static final String cd12004Mxid = "CD_12004_MXID";	//房产明细编码
	private static final String cd00002Pssd = "CD_00002_PSSD";	//评税时点
	private static final String xzxs = "XZXS";					//修正值 必须要大于0
	private static final String upddate = "UPDDATE";			//更改时间
	private static final String cd00002Czr = "CD_00002_CZR";	//操作人字段
	private static final String note = "NOTE";					//备注信息
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02031aDAO#GetDeleteCommand(com.sunway.vo.Pgt02031a)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt02031a bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02031A(?,?,?)}");
			call.setString(1, bean.getCd00002Pssd());
			call.setString(2, bean.getCd12004Mxid());
			call.setString(3, bean.getQtxzid());
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

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02031aDAO#GetInsertCommand(com.sunway.vo.Pgt02031a)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt02031a bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02031A(?,?,?,?,?,?)}");
			call.setString(1, bean.getQtxzid());
			call.setString(2, bean.getCd12004Mxid());
			call.setString(3, bean.getCd00002Pssd());
			call.setDouble(4, bean.getXzxs());
			call.setString(5, bean.getCd00002Czr());
			call.setString(6, bean.getNote());
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

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02031aDAO#GetUpdateCommand(com.sunway.vo.Pgt02031a)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt02031a bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02031A(?,?,?,?,?,?)}");
			call.setString(1, bean.getQtxzid());
			call.setString(2, bean.getCd12004Mxid());
			call.setString(3, bean.getCd00002Pssd());
			call.setDouble(4, bean.getXzxs());
			call.setString(5, bean.getCd00002Czr());
			call.setString(6, bean.getNote());
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

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02031aDAO#LoadAll(com.sunway.vo.Pgt02031a)
	 */
	
	@Override
	public ArrayList<Pgt02031a> LoadAll(Pgt02031a bean) throws Exception {
		ArrayList<Pgt02031a> listResult = new ArrayList<Pgt02031a>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02031A(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd12004Mxid());
			call.setString(3, bean.getCd00002Pssd());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02031aDAO#LoadByPrimaryKey(com.sunway.vo.Pgt02031a)
	 */
	
	@Override
	public Pgt02031a LoadByPrimaryKey(Pgt02031a bean) throws Exception {
		ArrayList<Pgt02031a> listResult = new ArrayList<Pgt02031a>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02031A(?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd00002Pssd());
			call.setString(3, bean.getCd12004Mxid());
			call.setString(4, bean.getQtxzid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return null;
	}

	/**
	 * Table數據轉存
	 * @param rs 數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgt02031a SetTParameters(ResultSet rs) throws Exception {
		return new Pgt02031a(rs.getString(qtxzid), 
							 rs.getString(cd00002Pssd), 
					 		 rs.getString(cd12004Mxid), 
					 		 rs.getDouble(xzxs), 
					 		 rs.getTimestamp(upddate), 
					 		 rs.getString(cd00002Czr), 
					 		 rs.getString(note));
	}	
	
}