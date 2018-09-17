

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

import com.sunway.dao.IPgt02010fDAO;
import com.sunway.vo.Pgv02010f;

public class Pgt02010fDAO extends BaseDAO implements IPgt02010fDAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgv02010fDAO#GetDeleteCommand(com.sunway.vo.Pgv02010f)
	 */
	@Override
	public boolean GetDeleteCommand(Pgv02010f b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;	
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = getConnection();
			call = conn.prepareCall("{call PGSP_Delt02010f(?)}");
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
	 * @see com.sunway.dao.IPgv02010fDAO#GetInsertCommand(com.sunway.vo.Pgv02010f)
	 */
	@Override
	public boolean GetInsertCommand(Pgv02010f b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02010f(?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, b.getCd02002Fcid());
			call.setShort(2, b.getZtlx());
			call.setString(3, b.getZlfjm());
			call.setString(4, b.getBcljm());
			call.setString(5, b.getCd00002Czr());
			call.setString(6, b.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgv02010fDAO#LoadAll(com.sunway.vo.Pgv02010f)
	 */
	@Override
	public ArrayList<Pgv02010f> LoadAll(Pgv02010f b) throws Exception {
		ArrayList<Pgv02010f> listResult = new ArrayList<Pgv02010f>();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02010F(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, b.getCd02002Fcid());
			call.setShort(3, b.getZtlx());
			call.execute();
			//返回数据集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgv02010fDAO#LoadAll(com.sunway.vo.Pgv02010f)
	 */
	@Override
	public ArrayList<Pgv02010f> LoadAllB(Pgv02010f b) throws Exception {
		ArrayList<Pgv02010f> listResult = new ArrayList<Pgv02010f>();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02010F_B(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, b.getCd02002Fcid());
			call.setShort(3, b.getZtlx());
			call.execute();
			//返回数据集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
		

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgv02010fDAO#GetUpdateCommand(com.sunway.vo.Pgv02010f)
	 */
	@Override
	public boolean GetUpdateCommand(Pgv02010f b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02010F(?,?,?,?,?,?,?,?)}");
			//传入输入参数
				call.setString(1, b.getCd02002Fcid());
				
				/*call.setShort(9, b.getSbzt());
				call.setString(10, b.getSlyj());
				call.setString(12, b.getCd00002Slczr());
				call.setShort(13, b.getSlzt());
				call.setShort(14, b.getDcyj());
				call.setString(16, b.getCd00002Dcczr());
				call.setShort(17, b.getDczt());
				call.setString(18, b.getCljd());
				call.setString(20, b.getCd00002Clczr());
				call.setShort(21, b.getClzt());
				call.setString(22, b.getSlsy());
				call.setDouble(23, b.getDcjg());
				call.setDouble(24, b.getDcdsfjg());
				call.setBoolean(25, b.getDcsfcx());
				call.setString(26, b.getDcbcxyy());*/

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
	 * @see com.sunway.dao.IPgv02010fDAO#LoadByPrimaryKey(com.sunway.vo.Pgv02010f)
	 */
	@Override
	public Pgv02010f LoadByPrimaryKey(Pgv02010f b) throws Exception {
		Pgv02010f bResult = new Pgv02010f();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02010F(?,?)}");
			//注冊输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, b.getId());
          
			call.execute();
			//返回数据集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				bResult.setCd02002Fcid(rs.getString(Pgv02010f.CD_02002_FCID));
				bResult.setId(rs.getString(Pgv02010f.ID));
				bResult.setZtlx(rs.getShort(Pgv02010f.ZTLX));
				bResult.setZlfjm(rs.getString(Pgv02010f.ZLFJM));
				bResult.setBcljm(rs.getString(Pgv02010f.BCLJM));
				bResult.setUpddate(rs.getDate(Pgv02010f.UPDDATE));
				bResult.setCd00002Czr(rs.getString(Pgv02010f.CD_00002_CZR));
				bResult.setCzr(rs.getString(Pgv02010f.CZR));
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
	protected Pgv02010f SetParameters(ResultSet rs)throws Exception{
		Pgv02010f tmpB = new Pgv02010f();
		tmpB.setCd02002Fcid(rs.getString(Pgv02010f.CD_02002_FCID));
		tmpB.setId(rs.getString(Pgv02010f.ID));
		tmpB.setZtlx(rs.getShort(Pgv02010f.ZTLX));
		tmpB.setZlfjm(rs.getString(Pgv02010f.ZLFJM));
		tmpB.setBcljm(rs.getString(Pgv02010f.BCLJM));
		tmpB.setUpddate(rs.getTimestamp(Pgv02010f.UPDDATE));
		tmpB.setCd00002Czr(rs.getString(Pgv02010f.CD_00002_CZR));
		tmpB.setCzr(rs.getString(Pgv02010f.CZR));
		return tmpB;
	}
	
}
