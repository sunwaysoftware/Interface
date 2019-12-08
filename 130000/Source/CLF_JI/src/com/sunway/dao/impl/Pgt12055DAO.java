package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt12055DAO;
import com.sunway.vo.Pgt12055;
import com.sunway.vo.Pgv12055;

/**
 * @category 成本法建安造价标准
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt12055DAO extends BaseDAO implements IPgt12055DAO {

	
	private static final String CD00001FWYTLX = "cd_00001_fwytlx";	//房屋用途类型
	private static final String CD00001FWYT = "cd_00001_fwyt";		//房屋用途编码
	private static final String FWYT =  "fwyt";						//房屋用途名称
	private static final String SFCBPG = "SFCBPG";					//所在区域类型
	private static final String SFSYPG = "SFSYPG";;					//所在区域编码
	private static final String UPDDATE="upddate";					//更改时间
	private static final String CD00002CZR = "cd_00002_czr";		//操作人编号	
	private static final String CZR = "czr";						//操作人
	private static final String NOTE = "note";						//备注信息
	private static final String RID = "rid";						//行号
	private static final String TOTAL = "total";					//总纪录数
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt12055 pglx) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12055(?,?,?,?)}");
			//传入输入参数
			call.setString(1, pglx.getCd00001Fwyt());
			call.setString(2, pglx.getCd00001Fwytlx());
			call.setString(3, pglx.getCd00002Czr());
			call.setString(4, pglx.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt10051DAO#GetInsertCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt12055 pglx) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT12055(?,?,?,?,?,?)}");			//传入输入参数
			call.setString(1, pglx.getCd00001Fwyt());
			call.setBoolean(2, pglx.getSfcbpg());
			call.setBoolean(3, pglx.getSfsypg());
			call.setString(4, pglx.getCd00002Czr());
			call.setString(5, pglx.getNote());
			call.setString(6, pglx.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt10051DAO#GetUpdateCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt12055 pglx) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT12055(?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, pglx.getCd00001Fwyt());
			call.setBoolean(2, pglx.getSfcbpg());
			call.setBoolean(3, pglx.getSfsypg());
			call.setString(4, pglx.getCd00002Czr());
			call.setString(5, pglx.getNote());
			call.setString(6, pglx.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt10051DAO#LoadAll(com.sunway.vo.Pgv10051)
	 */
	
	@Override
	public ArrayList<Pgv12055> LoadAll(Pgv12055 pglx) throws Exception {
		ArrayList<Pgv12055> listResult = new ArrayList<Pgv12055>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12055(?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, pglx.getPageIndex());
			call.setInt(3, pglx.getPageSize());
			call.setString(4, pglx.getCd00001Fwyt());
			call.execute();
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
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv12055 SetVParameters(ResultSet rs) throws Exception {
		Pgv12055 e = new Pgv12055();
		e.setCd00001Fwytlx(rs.getString(CD00001FWYTLX));
		e.setCd00001Fwyt(rs.getString(CD00001FWYT));
		e.setSfcbpg(rs.getBoolean(SFCBPG));
		e.setSfsypg(rs.getBoolean(SFSYPG));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setFwyt(rs.getString(FWYT));
		e.setCzr(rs.getString(CZR));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt12055 LoadByPrimaryKey(Pgt12055 pglx) throws Exception {
		ArrayList<Pgt12055> listResult = new ArrayList<Pgt12055>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT12055(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, pglx.getCd00001Fwyt());
			call.setString(3, pglx.getCd00001Fwytlx());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetTParameters(rs));			
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return pglx;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt12055 SetTParameters(ResultSet rs) throws Exception {
		Pgt12055 e = new Pgt12055();
		e.setCd00001Fwytlx(rs.getString(CD00001FWYTLX));
		e.setCd00001Fwyt(rs.getString(CD00001FWYT));
		e.setSfcbpg(rs.getBoolean(SFCBPG));
		e.setSfsypg(rs.getBoolean(SFSYPG));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		return e;
	}
}
