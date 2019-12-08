package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt02057DAO;
import com.sunway.vo.Pgt02057;
import com.sunway.vo.Pgv02057;

/**
 * @category 收益法资本化率
 * @author Lee
 * @version 1.0
 */
public class Pgt02057DAO extends BaseDAO implements IPgt02057DAO {

	private static final String CD00001FWYTLX = "cd_00001_fwytlx";	//房屋用途类型编号
	private static final String CD00001FWYT = "cd_00001_fwyt";		//房屋用途编号
	private static final String FWYT = "fwyt";						//房屋用途名称
	private static final String CD00001SZQYLX = "cd_00001_szqylx";	//所在区域类型
	private static final String CD00001SZQY = "cd_00001_szqy";;		//所在区域编码
	private static final String SZQY =  "szqy";						//所在区域名称
	private static final String CD00002PSSD = "cd_00002_pssd";		//评税时点
	private static final String ZBHL = "zbhl";						//资本化率(%)
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
	public boolean GetDeleteCommand(Pgt02057 zbhl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02057(?,?,?,?,?,?,?)}");
			call.setString(1, zbhl.getCd00001Fwyt());
			call.setString(2, zbhl.getCd00001Fwytlx());
			call.setString(3, zbhl.getCd00001Szqy());
			call.setString(4, zbhl.getCd00001Szqylx());
			call.setString(5, zbhl.getCd00002Pssd());
			call.setString(6, zbhl.getCd00002Czr());
			call.setString(7, zbhl.getCd00001Ssgx());
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
	public boolean GetInsertCommand(Pgt02057 zbhl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02057(?,?,?,?,?,?,?)}");
			call.setString(1, zbhl.getCd00001Fwyt());
			call.setString(2, zbhl.getCd00001Szqy());
			call.setString(3, zbhl.getCd00002Pssd());
			call.setDouble(4, zbhl.getZbhl());
			call.setString(5, zbhl.getCd00002Czr());
			call.setString(6, zbhl.getNote());
			call.setString(7, zbhl.getCd00001Ssgx());
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
	public boolean GetUpdateCommand(Pgt02057 zbhl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02057(?,?,?,?,?,?,?,?,?)}");
			call.setString(1, zbhl.getCd00001Fwytlx());
			call.setString(2, zbhl.getCd00001Fwyt());
			call.setString(3, zbhl.getCd00001Szqylx());
			call.setString(4, zbhl.getCd00001Szqy());
			call.setString(5, zbhl.getCd00002Pssd());
			call.setDouble(6, zbhl.getZbhl());
			call.setString(7, zbhl.getCd00002Czr());
			call.setString(8, zbhl.getNote());
			call.setString(9, zbhl.getCd00001Ssgx());
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
	public ArrayList<Pgv02057> LoadAll(Pgv02057 zbhl) throws Exception {
		ArrayList<Pgv02057> listResult = new ArrayList<Pgv02057>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02057(?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, zbhl.getPageIndex());
			call.setInt(3, zbhl.getPageSize());
			call.setString(4, zbhl.getCd00001Fwyt());
			call.setString(5, zbhl.getCd00001Szqy());
			call.setString(6, zbhl.getCd00002Pssd());
			call.setString(7, zbhl.getCd00001Ssgx());
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
	protected Pgv02057 SetVParameters(ResultSet rs) throws Exception {
		Pgv02057 e = new Pgv02057();
		e.setCd00001Fwytlx(rs.getString(CD00001FWYTLX));
		e.setCd00001Fwyt(rs.getString(CD00001FWYT));
		e.setFwyt(rs.getString(FWYT));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setSzqy(rs.getString(SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setZbhl(rs.getDouble(ZBHL));
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
	public Pgt02057 LoadByPrimaryKey(Pgt02057 zbhl) throws Exception {
		ArrayList<Pgt02057> listResult = new ArrayList<Pgt02057>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02057(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, zbhl.getCd00001Fwyt());
			call.setString(3, zbhl.getCd00001Fwytlx());
			call.setString(4, zbhl.getCd00001Szqy());
			call.setString(5, zbhl.getCd00001Szqylx());
			call.setString(6, zbhl.getCd00002Pssd());
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
			return zbhl;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt02057 SetTParameters(ResultSet rs) throws Exception {
		Pgt02057 e = new Pgt02057();
		e.setCd00001Fwytlx(rs.getString(CD00001FWYTLX));
		e.setCd00001Fwyt(rs.getString(CD00001FWYT));
		e.setFwyt(rs.getString(FWYT));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setZbhl(rs.getDouble(ZBHL));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExecuteParamCopy(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean ExecuteParamCopy(Pgt02057 zbhl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {	
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02057(?,?,?,?,?)}");
			call.setString(1, zbhl.getSpssd());
			call.setString(2, zbhl.getTpssd());
			call.setString(3, zbhl.getCd00001Szqy());
			call.setString(4, zbhl.getCd00002Czr());
			call.setString(5, zbhl.getCd00001Ssgx());
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
