package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt00359DAO;
import com.sunway.vo.Pgt00359;
import com.sunway.vo.Pgv00359;

/**
 * 所在区域下的参数类型配置
 * @category 所在区域下的参数类型配置
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00359DAO extends BaseDAO implements IPgt00359DAO {

	private static final String CD00001ROOT = "cd_00001_root";		//采光状况类型编号
	private static final String CD00001INFOID = "cd_00001_infoid";	//采光状况编号
	private static final String INFONM = "infonm";					//采光状况名称
	private static final String CD00001SZQYLX = "cd_00001_szqylx";	//所在区域类型
	private static final String CD00001SZQY = "cd_00001_szqy";;		//所在区域编码
	private static final String SZQY =  "szqy";						//所在区域名称
	private static final String CD00001FWLX = "cd_00001_FWLX";		//采光状况类型编号
	private static final String CD00001FWLXLX = "cd_00001_FWLXLX";	//采光状况编号
	private static final String FWLX =  "FWLX";						//所在区域名称
//	private static final String UPDDATE="upddate";					//更改时间
//	private static final String CD00002CZR = "cd_00002_czr";		//操作人编号	
//	private static final String CZR = "czr";						//操作人
//	private static final String NOTE = "note";						//备注信息
//	private static final String RID = "rid";						//行号
//	private static final String TOTAL = "total";					//总纪录数
//	private static final String CZLX = "czlx";						//操作类型
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00359 bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00359(?,?,?,?,?)}");
			call.setString(1, bean.getCd00001Infoid());
			call.setString(2, bean.getCd00001Root());
			call.setString(3, bean.getCd00001Szqy());
			call.setString(4, bean.getCd00001Szqylx());
			call.setString(5, bean.getCd00001Fwlx());
//			call.setString(5, bean.getCd00002Pssd());
//			call.setString(6, bean.getCd00002Czr());
//			call.setString(7, bean.getCd00001Ssgx());
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
	public boolean GetInsertCommand(Pgt00359 bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00359(?,?,?,?,?)}");
			call.setString(1, bean.getCd00001Root());
			call.setString(2, bean.getCd00001Infoid());
			call.setString(3, bean.getCd00001Szqylx());
			call.setString(4, bean.getCd00001Szqy());
			call.setString(5, bean.getCd00001Fwlx());
//			call.setString(5, bean.getCd00002Pssd());
//			call.setString(6, bean.getCd00002Czr());
//			call.setString(7, bean.getNote());
//			call.setString(8, bean.getCd00001Ssgx());
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
	public ArrayList<Pgv00359> LoadAll(Pgv00359 bean) throws Exception {
		ArrayList<Pgv00359> listResult = new ArrayList<Pgv00359>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003591(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setString(2, bean.getCd00001Szqy());
			call.setString(3, bean.getCd00001Fwlx());
//			call.setInt(2, bean.getPageIndex());
//			call.setInt(3, bean.getPageSize());
//			call.setString(4, bean.getCd00001Root());
//			call.setString(5, bean.getCd00001Infoid());
//			call.setString(6, bean.getCd00001Szqy());
//			call.setString(7, bean.getCd00002Pssd());
//			call.setString(8, bean.getCd00001Ssgx());
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
	protected Pgv00359 SetVParameters(ResultSet rs) throws Exception {
		Pgv00359 e = new Pgv00359();
		e.setCd00001Root(rs.getString(CD00001ROOT));
		e.setCd00001Infoid(rs.getString(CD00001INFOID));
		e.setInfonm(rs.getString(INFONM));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setSzqy(rs.getString(SZQY));
		e.setCd00001Fwlxlx(rs.getString(CD00001FWLXLX));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setFwlx(rs.getString(FWLX));
//		e.setCd00002Pssd(rs.getString(CD00002PSSD));
//		e.setXzxs(rs.getDouble(XZXS));
//		e.setUpddate(rs.getTimestamp(UPDDATE));
//		e.setCd00002Czr(rs.getString(CD00002CZR));
//		e.setNote(rs.getString(NOTE));
//		e.setCzr(rs.getString(CZR));
//		e.setRecordCount(rs.getInt(TOTAL));
//		e.setRecordIndex(rs.getInt(RID));
//		e.setCzlx(rs.getInt(CZLX));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt00359 LoadByPrimaryKey(Pgt00359 bean) throws Exception {
		ArrayList<Pgt00359> listResult = new ArrayList<Pgt00359>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00359(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd00001Infoid());
			call.setString(3, bean.getCd00001Root());
			call.setString(4, bean.getCd00001Szqy());
			call.setString(5, bean.getCd00001Szqylx());
			call.setString(6, bean.getCd00001Fwlx());
//			call.setString(6, bean.getCd00002Pssd());
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
			return bean;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00359 SetTParameters(ResultSet rs) throws Exception {
		Pgt00359 e = new Pgt00359();
		e.setCd00001Root(rs.getString(CD00001ROOT));
		e.setCd00001Infoid(rs.getString(CD00001INFOID));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00001Fwlxlx(rs.getString(CD00001FWLXLX));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
//		e.setCd00002Pssd(rs.getString(CD00002PSSD));
//		e.setUpddate(rs.getTimestamp(UPDDATE));
//		e.setCd00002Czr(rs.getString(CD00002CZR));
//		e.setNote(rs.getString(NOTE));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00359DAO#GetUpdateCommand(com.sunway.vo.Pgt00359)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt00359 bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00359(?,?,?)}");
			call.setString(1, bean.getInfoids());
			call.setString(2, bean.getCd00001Szqy());
			call.setString(3, bean.getCd00001Fwlx());
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
	 * @see com.sunway.dao.IPgt00359DAO#LoadParentIdsBySzqy(java.lang.String)
	 */
	
	@Override
	public String LoadParentIdsBySzqy(Pgt00359 bean) throws Exception {
		String listResult = "";
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{?=call FN_GET00359PARENTIDS(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.VARCHAR);			
			//注册输入参数
			call.setString(2, bean.getCd00001Szqy());
			call.setString(3, bean.getCd00001Fwlx());
			
			call.execute();
			
			listResult = call.getString(1);
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

}
