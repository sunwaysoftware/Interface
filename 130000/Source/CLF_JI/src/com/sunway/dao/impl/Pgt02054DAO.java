package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt02054DAO;
import com.sunway.vo.Pgt02054;
import com.sunway.vo.Pgv02054;

/**
 * @category 收益法房屋设施
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02054DAO extends BaseDAO implements IPgt02054DAO {

	private static final String CD00001FWSSLX = "cd_00001_fwsslx";	//房屋设施类型编号
	private static final String CD00001FWSS = "cd_00001_fwss";		//房屋设施编号
	private static final String FWSS = "fwss";						//房屋设施名称
	private static final String CD00001SZQYLX = "cd_00001_szqylx";	//所在区域类型
	private static final String CD00001SZQY = "cd_00001_szqy";;		//所在区域编码
	private static final String SZQY =  "szqy";						//所在区域名称
	private static final String CD00002PSSD = "cd_00002_pssd";		//评税时点
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
	public boolean GetDeleteCommand(Pgt02054 fwss) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02054(?,?,?,?,?,?,?)}");
			call.setString(1, fwss.getCd00001Fwss());
			call.setString(2, fwss.getCd00001Fwsslx());
			call.setString(3, fwss.getCd00001Szqy());
			call.setString(4, fwss.getCd00001Szqylx());
			call.setString(5, fwss.getCd00002Pssd());
			call.setString(6, fwss.getCd00002Czr());
			call.setString(7, fwss.getCd00001Ssgx());
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
	public boolean GetInsertCommand(Pgt02054 fwss) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02054(?,?,?,?,?,?,?)}");
			call.setString(1, fwss.getCd00001Fwss());
			call.setString(2, fwss.getCd00001Szqy());
			call.setString(3, fwss.getCd00002Pssd());
			call.setDouble(4, fwss.getXzxs());
			call.setString(5, fwss.getCd00002Czr());
			call.setString(6, fwss.getNote());
			call.setString(7, fwss.getCd00001Ssgx());
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
	public boolean GetUpdateCommand(Pgt02054 fwss) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02054(?,?,?,?,?,?,?,?,?)}");
			call.setString(1, fwss.getCd00001Fwsslx());
			call.setString(2, fwss.getCd00001Fwss());
			call.setString(3, fwss.getCd00001Szqylx());
			call.setString(4, fwss.getCd00001Szqy());
			call.setString(5, fwss.getCd00002Pssd());
			call.setDouble(6, fwss.getXzxs());
			call.setString(7, fwss.getCd00002Czr());
			call.setString(8, fwss.getNote());
			call.setString(9, fwss.getCd00001Ssgx());
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
	public ArrayList<Pgv02054> LoadAll(Pgv02054 fwss) throws Exception {
		ArrayList<Pgv02054> listResult = new ArrayList<Pgv02054>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02054(?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, fwss.getPageIndex());
			call.setInt(3, fwss.getPageSize());
			call.setString(4, fwss.getCd00001Fwss());
			call.setString(5, fwss.getCd00001Szqy());
			call.setString(6, fwss.getCd00002Pssd());
			call.setString(7, fwss.getCd00001Ssgx());
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
	protected Pgv02054 SetVParameters(ResultSet rs) throws Exception {
		Pgv02054 e = new Pgv02054();
		e.setCd00001Fwsslx(rs.getString(CD00001FWSSLX));
		e.setCd00001Fwss(rs.getString(CD00001FWSS));
		e.setFwss(rs.getString(FWSS));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setSzqy(rs.getString(SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setXzxs(rs.getDouble(XZXS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setCzr(rs.getString(CZR));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt02054 LoadByPrimaryKey(Pgt02054 fwss) throws Exception {
		ArrayList<Pgt02054> listResult = new ArrayList<Pgt02054>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02054(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, fwss.getCd00001Fwss());
			call.setString(3, fwss.getCd00001Fwsslx());
			call.setString(4, fwss.getCd00001Szqy());
			call.setString(5, fwss.getCd00001Szqylx());
			call.setString(6, fwss.getCd00002Pssd());
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
			return fwss;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt02054 SetTParameters(ResultSet rs) throws Exception {
		Pgt02054 e = new Pgt02054();
		e.setCd00001Fwsslx(rs.getString(CD00001FWSSLX));
		e.setCd00001Fwss(rs.getString(CD00001FWSS));
		e.setFwss(rs.getString(FWSS));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setXzxs(rs.getDouble(XZXS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExecuteParamCopy(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean ExecuteParamCopy(Pgt02054 fwss) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {	
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02054(?,?,?,?,?)}");
			call.setString(1, fwss.getSpssd());
			call.setString(2, fwss.getTpssd());
			call.setString(3, fwss.getCd00001Szqy());
			call.setString(4, fwss.getCd00002Czr());
			call.setString(5, fwss.getCd00001Ssgx());
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
