package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt10057DAO;
import com.sunway.vo.Pgt10057;
import com.sunway.vo.Pgv10057;

/**
 * @category 成新率最小值设置
 * @author Lee
 * @version 1.0
 */
public class Pgt10057DAO extends BaseDAO implements IPgt10057DAO {

	private static final String CD00001FWYTLX = "cd_00001_fwytlx";	//房屋用途类型
	private static final String CD00001FWYT = "cd_00001_fwyt";		//房屋用途编码
	private static final String FWYT =  "fwyt";						//房屋用途名称
	private static final String CD00001SZQYLX = "cd_00001_szqylx";	//所在区域类型
	private static final String CD00001SZQY = "cd_00001_szqy";;		//所在区域编码
	private static final String SZQY =  "szqy";						//所在区域名称
	private static final String CD00002PSSD = "cd_00002_pssd";		//评税时点
	private static final String CXL = "cxl";						//成新率最小值
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
	public boolean GetDeleteCommand(Pgt10057 cxl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT10057(?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, cxl.getCd00001Fwyt());
			call.setString(2, cxl.getCd00001Fwytlx());
			call.setString(3, cxl.getCd00002Pssd());
			call.setString(4, cxl.getCd00001Szqy());
			call.setString(5, cxl.getCd00001Szqylx());
			call.setString(6, cxl.getCd00002Czr());
			call.setString(7, cxl.getCd00001Ssgx());
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
	public boolean GetInsertCommand(Pgt10057 cxl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT10057(?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, cxl.getCd00001Fwyt());
			call.setString(2, cxl.getCd00002Pssd());
			call.setDouble(3, cxl.getCxl());
			call.setString(4, cxl.getCd00002Czr());
			call.setString(5, cxl.getNote());
			call.setString(6, cxl.getCd00001Szqy());
			call.setString(7, cxl.getCd00001Ssgx());
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
	public boolean GetUpdateCommand(Pgt10057 cxl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT10057(?,?,?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, cxl.getCd00001Fwytlx());
			call.setString(2, cxl.getCd00001Fwyt());
			call.setString(3, cxl.getCd00002Pssd());
			call.setDouble(4, cxl.getCxl());
			call.setString(5, cxl.getCd00002Czr());
			call.setString(6, cxl.getNote());
			call.setString(7, cxl.getCd00001Szqy());
			call.setString(8, cxl.getCd00001Szqylx());
			call.setString(9, cxl.getCd00001Ssgx());
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
	public ArrayList<Pgv10057> LoadAll(Pgv10057 cxl) throws Exception {
		ArrayList<Pgv10057> listResult = new ArrayList<Pgv10057>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT10057(?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, cxl.getPageIndex());
			call.setInt(3, cxl.getPageSize());
			call.setString(4, cxl.getCd00001Fwyt());
			call.setString(5, cxl.getCd00001Szqy());
			call.setString(6, cxl.getCd00002Pssd());
			call.setString(7, cxl.getCd00001Ssgx());
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
	protected Pgv10057 SetVParameters(ResultSet rs) throws Exception {
		Pgv10057 e = new Pgv10057();
		e.setCd00001Fwytlx(rs.getString(CD00001FWYTLX));
		e.setCd00001Fwyt(rs.getString(CD00001FWYT));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setCxl(rs.getDouble(CXL));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setSzqy(rs.getString(SZQY));
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
	public Pgt10057 LoadByPrimaryKey(Pgt10057 cxl) throws Exception {
		ArrayList<Pgt10057> listResult = new ArrayList<Pgt10057>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT10057(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, cxl.getCd00001Fwyt());
			call.setString(3, cxl.getCd00001Fwytlx());
			call.setString(4, cxl.getCd00002Pssd());
			call.setString(5, cxl.getCd00001Szqy());
			call.setString(6, cxl.getCd00001Szqylx());
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
			return cxl;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt10057 SetTParameters(ResultSet rs) throws Exception {
		Pgt10057 e = new Pgt10057();
		e.setCd00001Fwytlx(rs.getString(CD00001FWYTLX));
		e.setCd00001Fwyt(rs.getString(CD00001FWYT));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setFwyt(rs.getString(FWYT));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setCxl(rs.getDouble(CXL));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExecuteParamCopy(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean ExecuteParamCopy(Pgt10057 cxl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {	
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_10057(?,?,?,?,?)}");
			call.setString(1, cxl.getSpssd());
			call.setString(2, cxl.getTpssd());
			call.setString(3, cxl.getCd00001Szqy());
			call.setString(4, cxl.getCd00002Czr());
			call.setString(5, cxl.getCd00001Ssgx());
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
