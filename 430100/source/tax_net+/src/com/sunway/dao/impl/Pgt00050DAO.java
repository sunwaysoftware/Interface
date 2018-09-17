

/**
 * @author sunxdd
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

import com.sunway.dao.IPgt00050DAO;
import com.sunway.vo.Pgv00050;

public class Pgt00050DAO extends BaseDAO implements IPgt00050DAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgv00050DAO#GetDeleteCommand(com.sunway.vo.Pgv00050)
	 */
	@Override
	public boolean GetDeleteCommand(Pgv00050 b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;	
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = getConnection();
			call = conn.prepareCall("{call PGSP_Delt00050(?)}");
			//传入输入参数
			call.setString(1, b.getId());
          
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
	 * @see com.sunway.dao.IPgv00050DAO#GetInsertCommand(com.sunway.vo.Pgv00050)
	 */
	@Override
	public boolean GetInsertCommand(Pgv00050 b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00050(?,?,?)}");
			//传入输入参数
			call.setString(1, b.getPggsmc());
			call.setString(2, b.getCd00001Ssgx());
			call.setString(3, b.getCd00002Czr());
			
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
	 * @see com.sunway.dao.IPgv00050DAO#LoadAll(com.sunway.vo.Pgv00050)
	 */
	@Override
	public ArrayList<Pgv00050> LoadAll(Pgv00050 b) throws Exception {
		ArrayList<Pgv00050> listResult = new ArrayList<Pgv00050>();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00050(?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setInt(2, b.getPageIndex());
			call.setInt(3, b.getPageSize());
			call.setString(4, b.getPggsmc());
			call.setString(5, b.getCd00001Ssgx());
			call.execute();
			//返回数据集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				Pgv00050 tmpB = new Pgv00050();
				tmpB.setTotal(rs.getInt("total"));
				tmpB.setId(rs.getString(Pgv00050.ID));
				tmpB.setPggsmc(rs.getString(Pgv00050.PGGSMC));
				tmpB.setUpddate(rs.getDate(Pgv00050.UPDDATE));
				tmpB.setCd00001Ssgx(rs.getString(Pgv00050.CD_00001_SSGX));
				tmpB.setSsgx(rs.getString(Pgv00050.SSGX));
				tmpB.setCd00002Czr(rs.getString(Pgv00050.CD_00002_CZR));
				tmpB.setCzr(rs.getString(Pgv00050.CZR));
				listResult.add(tmpB);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
		

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgv00050DAO#GetUpdateCommand(com.sunway.vo.Pgv00050)
	 */
	@Override
	public boolean GetUpdateCommand(Pgv00050 b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00050(?,?,?,?)}");
			//传入输入参数
				call.setString(1, b.getId());
				call.setString(2, b.getPggsmc());
				call.setString(3, b.getCd00001Ssgx());
				call.setString(4, b.getCd00002Czr());

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
	 * @see com.sunway.dao.IPgv00050DAO#LoadByPrimaryKey(com.sunway.vo.Pgv00050)
	 */
	@Override
	public Pgv00050 LoadByPrimaryKey(Pgv00050 b) throws Exception {
		Pgv00050 bResult = new Pgv00050();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00050(?,?)}");
			//注冊输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, b.getId());
          
			call.execute();
			//返回数据集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				bResult = SetParameters(rs);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return bResult;
	}	
	
	/**
	 * 装载数据
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	protected Pgv00050 SetParameters(ResultSet rs)throws Exception{
		Pgv00050 tmpB = new Pgv00050();
		tmpB.setId(rs.getString(Pgv00050.ID));
		tmpB.setPggsmc(rs.getString(Pgv00050.PGGSMC));
		tmpB.setUpddate(rs.getDate(Pgv00050.UPDDATE));
		tmpB.setCd00001Ssgx(rs.getString(Pgv00050.CD_00001_SSGX));
		tmpB.setSsgx(rs.getString(Pgv00050.SSGX));
		tmpB.setCd00002Czr(rs.getString(Pgv00050.CD_00002_CZR));
		tmpB.setCzr(rs.getString(Pgv00050.CZR));
		return tmpB;
	}
	
}
