

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

import com.sunway.dao.IPgt00310fDAO;
import com.sunway.vo.Pgv00310f;

public class Pgt00310fDAO extends BaseDAO implements IPgt00310fDAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgv00310fDAO#GetDeleteCommand(com.sunway.vo.Pgv00310f)
	 */
	@Override
	public boolean GetDeleteCommand(Pgv00310f b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;	
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = getConnection();
			call = conn.prepareCall("{call PGSP_Delt00310f(?)}");
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
	 * @see com.sunway.dao.IPgv00310fDAO#GetInsertCommand(com.sunway.vo.Pgv00310f)
	 */
	@Override
	public boolean GetInsertCommand(Pgv00310f b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00310f(?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, b.getCd00302Fcid());
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
	 * @see com.sunway.dao.IPgv00310fDAO#LoadAll(com.sunway.vo.Pgv00310f)
	 */
	@Override
	public ArrayList<Pgv00310f> LoadAll(Pgv00310f b) throws Exception {
		ArrayList<Pgv00310f> listResult = new ArrayList<Pgv00310f>();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00310F(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, b.getCd00302Fcid());
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
	 * @see com.sunway.dao.IPgv00310fDAO#LoadAll(com.sunway.vo.Pgv00310f)
	 */
	@Override
	public ArrayList<Pgv00310f> LoadAllB(Pgv00310f b) throws Exception {
		ArrayList<Pgv00310f> listResult = new ArrayList<Pgv00310f>();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00310F_B(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, b.getCd00302Fcid());
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
	 * @see com.sunway.dao.IPgv00310fDAO#GetUpdateCommand(com.sunway.vo.Pgv00310f)
	 */
	@Override
	public boolean GetUpdateCommand(Pgv00310f b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00310F(?,?,?,?,?,?,?,?)}");
			//传入输入参数
				call.setString(1, b.getCd00302Fcid());
				
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
	 * @see com.sunway.dao.IPgv00310fDAO#LoadByPrimaryKey(com.sunway.vo.Pgv00310f)
	 */
	@Override
	public Pgv00310f LoadByPrimaryKey(Pgv00310f b) throws Exception {
		Pgv00310f bResult = new Pgv00310f();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00310F(?,?)}");
			//注冊输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, b.getId());
          
			call.execute();
			//返回数据集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				bResult.setCd00302Fcid(rs.getString(Pgv00310f.CD_00302_FCID));
				bResult.setId(rs.getString(Pgv00310f.ID));
				bResult.setZtlx(rs.getShort(Pgv00310f.ZTLX));
				bResult.setZlfjm(rs.getString(Pgv00310f.ZLFJM));
				bResult.setBcljm(rs.getString(Pgv00310f.BCLJM));
				bResult.setUpddate(rs.getDate(Pgv00310f.UPDDATE));
				bResult.setCd00002Czr(rs.getString(Pgv00310f.CD_00002_CZR));
				bResult.setCzr(rs.getString(Pgv00310f.CZR));
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
	protected Pgv00310f SetParameters(ResultSet rs)throws Exception{
		Pgv00310f tmpB = new Pgv00310f();
		tmpB.setCd00302Fcid(rs.getString(Pgv00310f.CD_00302_FCID));
		tmpB.setId(rs.getString(Pgv00310f.ID));
		tmpB.setZtlx(rs.getShort(Pgv00310f.ZTLX));
		tmpB.setZlfjm(rs.getString(Pgv00310f.ZLFJM));
		tmpB.setBcljm(rs.getString(Pgv00310f.BCLJM));
		tmpB.setUpddate(rs.getTimestamp(Pgv00310f.UPDDATE));
		tmpB.setCd00002Czr(rs.getString(Pgv00310f.CD_00002_CZR));
		tmpB.setCzr(rs.getString(Pgv00310f.CZR));
		return tmpB;
	}
	
}
