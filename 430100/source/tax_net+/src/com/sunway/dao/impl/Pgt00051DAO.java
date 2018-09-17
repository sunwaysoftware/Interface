package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00051DAO;
import com.sunway.util.ConvertUtil;
import com.sunway.vo.Pgt00051;
import com.sunway.vo.Pgv00051;

/**
 * @category 税率指数
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00051DAO extends BaseDAO implements IPgt00051DAO {

	private static final String CD00002PSSD = "cd_00002_pssd";	//评税时点
	private static final String JSBL = "jsbl";					//计税比率
	private static final String SL = "sl";						//税率
    private static final String UPDDATE = "upddate";			//更新时间
    private static final String CD00002CZR =  "cd_00002_czr";	//操作人
    private static final String NOTE = "note";					//备份
    private static final String CZR = "czr";					//操作人
	private static final String TOTAL = "total";				//总纪录数
	private static final String CD00001SZQYLX = "CD_00001_SZQYLX";
	private static final String CD00001SZQY = "CD_00001_SZQY";
	private static final String SZQY = "SZQY";
	private static final String CD00001FWLX = "CD_00001_FWLX";
	private static final String FWLX = "FWLX";
	private static final String CD00001JYLX = "CD_00001_JYLX";
	private static final String JYLX = "JYLX";
	
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00051 slzs) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00051(?,?,?,?,?,?)}");
			call.setDate(1, ConvertUtil.utilDateToSqlDate(slzs.getCd00002Pssd()));
			call.setString(2, slzs.getCd00002Czr());
			call.setString(3, slzs.getCd00001Ssgx());
			call.setString(4, slzs.getCd00001Szqy());
			call.setString(5, slzs.getCd00001Fwlx());
			call.setString(6, slzs.getCd00001Jylx());
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
	public boolean GetInsertCommand(Pgt00051 slzs) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00051(?,?,?,?,?,?,?,?,?)}");
			call.setDate(1, ConvertUtil.utilDateToSqlDate(slzs.getCd00002Pssd()));
			call.setDouble(2, slzs.getJsbl());
			call.setDouble(3, slzs.getSl());
			call.setString(4, slzs.getCd00002Czr());
			call.setString(5, slzs.getNote());
			call.setString(6, slzs.getCd00001Ssgx());
			call.setString(7, slzs.getCd00001Szqy());
			call.setString(8, slzs.getCd00001Fwlx());
			call.setString(9, slzs.getCd00001Jylx());
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
	public boolean GetUpdateCommand(Pgt00051 slzs) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00051(?,?,?,?,?,?,?,?,?)}");
			call.setDate(1, ConvertUtil.utilDateToSqlDate(slzs.getCd00002Pssd()));
			call.setDouble(2, slzs.getJsbl());
			call.setDouble(3, slzs.getSl());
			call.setString(4, slzs.getCd00002Czr());
			call.setString(5, slzs.getNote());
			call.setString(6, slzs.getCd00001Ssgx());
			call.setString(7, slzs.getCd00001Szqy());
			call.setString(8, slzs.getCd00001Fwlx());
			call.setString(9, slzs.getCd00001Jylx());
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
	public ArrayList<Pgv00051> LoadAll(Pgv00051 slzs) throws Exception {
		ArrayList<Pgv00051> listResult = new ArrayList<Pgv00051>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00051(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, slzs.getPageIndex());
			call.setInt(3, slzs.getPageSize());
			call.setDate(4, ConvertUtil.utilDateToSqlDate(slzs.getCd00002Pssd()));
			call.setString(5, slzs.getCd00001Szqy());
			call.setString(6, slzs.getCd00001Ssgx());
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
	protected Pgv00051 SetVParameters(ResultSet rs) throws Exception {
		Pgv00051 e = new Pgv00051();
		e.setCd00002Pssd(rs.getDate(CD00002PSSD));
		e.setJsbl(rs.getDouble(JSBL));
		e.setSl(rs.getDouble(SL));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setCzr(rs.getString(CZR));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setSzqy(rs.getString(SZQY));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setFwlx(rs.getString(FWLX));	
		e.setCd00001Jylx(rs.getString(CD00001JYLX));
		e.setJylx(rs.getString(JYLX));	
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt00051 LoadByPrimaryKey(Pgt00051 slzs) throws Exception {
		ArrayList<Pgt00051> listResult = new ArrayList<Pgt00051>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00051(?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setDate(2, ConvertUtil.utilDateToSqlDate(slzs.getCd00002Pssd()));
			call.setString(3, slzs.getCd00001Szqy());
			call.setString(4, slzs.getCd00001Fwlx());
			call.setString(5, slzs.getCd00001Jylx());
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
			return slzs;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00051 SetTParameters(ResultSet rs) throws Exception {
		Pgt00051 e = new Pgt00051();
		e.setCd00002Pssd(rs.getDate(CD00002PSSD));
		e.setJsbl(rs.getDouble(JSBL));
		e.setSl(rs.getDouble(SL));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setFwlx(rs.getString(FWLX));
		e.setCd00001Jylx(rs.getString(CD00001JYLX));
		e.setJylx(rs.getString(JYLX));	
		return e;
	}
}