package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt10054DAO;
import com.sunway.vo.Pgt10054;
import com.sunway.vo.Pgv10054;

/**
 * @category 成本法容积率
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt10054DAO extends BaseDAO implements IPgt10054DAO {

	
	private static final String CD00001TDYTLX = "cd_00001_tdytlx";	//土地用途类型编号
	private static final String CD00001TDYT = "cd_00001_tdyt";		//土地用途编号
	private static final String TDYT =  "tdyt";						//土地用途名称
	private static final String CD00001SZQYLX = "cd_00001_szqylx";	//所在区域类型
	private static final String CD00001SZQY = "cd_00001_szqy";;		//所在区域编码
	private static final String SZQY =  "szqy";						//所在区域名称
	private static final String CD00002PSSD = "cd_00002_pssd";		//评税时点
	private static final String RJL = "rjl";						//容积率
	private static final String XZXS = "xzxs";						//修正系数
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
	public boolean GetDeleteCommand(Pgt10054 rjl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT10054(?,?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, rjl.getCd00001Szqy());
			call.setString(2, rjl.getCd00001Szqylx());
			call.setString(3, rjl.getCd00001Tdyt());
			call.setString(4, rjl.getCd00001Tdytlx());
			call.setString(5, rjl.getCd00002Pssd());
			call.setDouble(6, rjl.getRjl());
			call.setString(7, rjl.getCd00002Czr());
			call.setString(8, rjl.getCd00001Ssgx());
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
	public boolean GetInsertCommand(Pgt10054 rjl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT10054(?,?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, rjl.getCd00001Tdyt());
			call.setString(2, rjl.getCd00001Szqy());
			call.setString(3, rjl.getCd00002Pssd());
			call.setDouble(4, rjl.getRjl());
			call.setDouble(5, rjl.getXzxs());
			call.setString(6, rjl.getCd00002Czr());
			call.setString(7, rjl.getNote());
			call.setString(8, rjl.getCd00001Ssgx());
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
	public boolean GetUpdateCommand(Pgt10054 rjl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT10054(?,?,?,?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, rjl.getCd00001Tdytlx());
			call.setString(2, rjl.getCd00001Tdyt());
			call.setString(3, rjl.getCd00001Szqylx());
			call.setString(4, rjl.getCd00001Szqy());
			call.setString(5, rjl.getCd00002Pssd());
			call.setDouble(6, rjl.getRjl());
			call.setDouble(7, rjl.getXzxs());
			call.setString(8, rjl.getCd00002Czr());
			call.setString(9, rjl.getNote());
			call.setString(10, rjl.getCd00001Ssgx());
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
	public ArrayList<Pgv10054> LoadAll(Pgv10054 rjl) throws Exception {
		ArrayList<Pgv10054> listResult = new ArrayList<Pgv10054>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT10054(?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, rjl.getPageIndex());
			call.setInt(3, rjl.getPageSize());
			call.setString(4, rjl.getCd00001Tdyt());
			call.setString(5, rjl.getCd00001Szqy());
			call.setString(6, rjl.getCd00002Pssd());
			call.setString(7, rjl.getCd00001Ssgx());
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
	protected Pgv10054 SetVParameters(ResultSet rs) throws Exception {
		Pgv10054 e = new Pgv10054();
		e.setCd00001Tdyt(rs.getString(CD00001TDYT));
		e.setCd00001Tdytlx(rs.getString(CD00001TDYTLX));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setRjl(rs.getDouble(RJL));
		e.setXzxs(rs.getDouble(XZXS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setTdyt(rs.getString(TDYT));
		e.setSzqy(rs.getString(SZQY));
		e.setCzr(rs.getString(CZR));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt10054 LoadByPrimaryKey(Pgt10054 rjl) throws Exception {
		ArrayList<Pgt10054> listResult = new ArrayList<Pgt10054>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT10054(?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, rjl.getCd00001Szqy());
			call.setString(3, rjl.getCd00001Szqylx());
			call.setString(4, rjl.getCd00001Tdyt());
			call.setString(5, rjl.getCd00001Tdytlx());
			call.setString(6, rjl.getCd00002Pssd());
			call.setDouble(7, rjl.getRjl());
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
			return rjl;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt10054 SetTParameters(ResultSet rs) throws Exception {
		Pgt10054 e = new Pgt10054();
		e.setCd00001Tdyt(rs.getString(CD00001TDYT));
		e.setCd00001Tdytlx(rs.getString(CD00001TDYTLX));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setRjl(rs.getDouble(RJL));
		e.setXzxs(rs.getDouble(XZXS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setTdyt(rs.getString(TDYT));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExecuteParamCopy(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean ExecuteParamCopy(Pgt10054 rjl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {	
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_10054(?,?,?,?,?)}");
			call.setString(1, rjl.getSpssd());
			call.setString(2, rjl.getTpssd());
			call.setString(3, rjl.getCd00001Szqy());
			call.setString(4, rjl.getCd00002Czr());
			call.setString(5, rjl.getCd00001Ssgx());
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
}
