package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt12006DAO;
import com.sunway.vo.Pgt12006;

/**
 * 
 * 登记人或承租人信息表(可以给登记提供自动提示功能)
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt12006DAO extends BaseDAO implements IPgt12006DAO {

	private static final String RID = "rid";						//行号
	private static final String TOTAL = "total";					//总纪录数
	private static final String CZRZJH = "czrzjh";					//审核类型
	private static final String CZRMC = "czrmc";					//是否审核
	private static final String UPDDATE="upddate";					//更改时间
	private static final String CD00002CZR = "cd_00002_czr";		//操作人编号
	private static final String NOTE = "note";						//备注信息
	private static final String CD00001SSGX = "cd_00001_ssgx";		//税收管辖
	private static final String CD00001SSGXLX = "cd_00001_ssgxlx";	//税收管辖类型
	private static final String CD00001HY = "cd_00001_hy";			//行业
	private static final String CD00001JJLX = "cd_00001_jjlx";		//经济类型
	private static final String FCSE = "fcse";						//房产税额
	private static final String TDSE = "tdse";						//地产税额
	private static final String SSGX = "ssgx";						//税收管辖
	private static final String HY = "hy";							//行业
	private static final String JJLX = "jjlx";						//经济类型
	private static final String CZR = "czr";						//操作人
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12006DAO#LoadNmById(java.lang.String)
	 */
	
	@Override
	public String LoadNmById(String id) throws Exception {
		String resultValue = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00001(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			//傳入輸入參數
			call.setString(2, id);
			call.execute();
			//返回數據集
			resultValue = (String) call.getObject(1); 
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return resultValue;
	}

	
	@Override
	public boolean GetDeleteCommand(Pgt12006 auto) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12006(?)}");
			call.setString(1, auto.getCzrzjh());
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

	
	@Override
	public boolean GetInsertCommand(Pgt12006 auto) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT12006(?,?,?,?,?,?,?,?,?)}");
			call.setString(1, auto.getCzrzjh());
			call.setString(2, auto.getCzrmc());
			call.setString(3, auto.getCd00002Czr());
			call.setString(4, auto.getNote());
			call.setString(5, auto.getCd00001Ssgx());
			call.setString(6, auto.getCd00001Hy());
			call.setString(7, auto.getCd00001Jjlx());
			call.setDouble(8, auto.getFcse());
			call.setDouble(9, auto.getTdse());
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

	
	
	@Override
	public boolean GetUpdateCommand(Pgt12006 auto) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT12006(?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, auto.getCzrzjh());
			call.setString(2, auto.getCzrmc());
			call.setString(3, auto.getCd00002Czr());
			call.setString(4, auto.getNote());
			call.setString(5, auto.getCd00001Ssgxlx());
			call.setString(6, auto.getCd00001Ssgx());
			call.setString(7, auto.getCd00001Hy());
			call.setString(8, auto.getCd00001Jjlx());
			call.setDouble(9, auto.getFcse());
			call.setDouble(10, auto.getTdse());
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

	
	@Override
	public ArrayList<Pgt12006> LoadAll(Pgt12006 auto) throws Exception {
		ArrayList<Pgt12006> listResult = new ArrayList<Pgt12006>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12006(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, auto.getPageIndex());
			call.setInt(3, auto.getPageSize());
			call.setString(4, auto.getCzrzjh());
			call.setString(5, auto.getCzrmc());
			call.setString(6, auto.getCd00001Ssgx());
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
	protected Pgt12006 SetVParameters(ResultSet rs) throws Exception {
		Pgt12006 e = new Pgt12006();
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		e.setCzrzjh(rs.getString(CZRZJH));
		e.setCzrmc(rs.getString(CZRMC));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setCd00001Ssgxlx(CD00001SSGXLX);
		e.setCd00001Ssgx(CD00001SSGX);
		e.setCd00001Hy(rs.getString(CD00001HY));
		e.setCd00001Jjlx(rs.getString(CD00001JJLX));
		e.setFcse(rs.getDouble(FCSE));
		e.setTdse(rs.getDouble(TDSE));
		e.setSsgx(rs.getString(SSGX));
		e.setHy(rs.getString(HY));
		e.setJjlx(rs.getString(JJLX));
		e.setCzr(rs.getString(CZR));
		return e;
	}

	
	@Override
	public Pgt12006 LoadByPrimaryKey(Pgt12006 auto) throws Exception {
		ArrayList<Pgt12006> listResult = new ArrayList<Pgt12006>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT12006(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, auto.getCzrzjh());
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
			return new Pgt12006();
	}
	
	protected Pgt12006 SetTParameters(ResultSet rs) throws Exception {
		Pgt12006 e = new Pgt12006();
		e.setCzrzjh(rs.getString(CZRZJH));
		e.setCzrmc(rs.getString(CZRMC));
		e.setCd00001Hy(rs.getString(CD00001HY));
		e.setCd00001Jjlx(rs.getString(CD00001JJLX));
		e.setFcse(rs.getDouble(FCSE));
		e.setTdse(rs.getDouble(TDSE));
		e.setHy(rs.getString(HY));
		e.setJjlx(rs.getString(JJLX));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setCd00001Ssgx(CD00001SSGX);
		e.setCd00001Ssgxlx(CD00001SSGXLX);
		return e;
	}


	
	public Boolean ImportExcelData(Pgt12006 bean) throws Exception{
		Boolean bResult = false;
		Session session = null;
		Connection conn = null;
		Transaction tran = null;
		CallableStatement call = null;
		try{	
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_ADDT12006(?,?,?,?,?,?,?,?,?)}");
			
			call.setString(1, bean.getCzrzjh());
			call.setString(2, bean.getCzrmc());
			call.setString(3, bean.getCd00002Czr());
			call.setString(4, bean.getNote());
			call.setString(5, bean.getCd00001Ssgx());
			call.setString(6, bean.getCd00001Hy());
			call.setString(7, bean.getCd00001Jjlx());
			call.setDouble(8, bean.getFcse());
			call.setDouble(9, bean.getTdse());
			call.execute();
			bResult = true;
			tran.commit();
		}catch(Exception e){
			tran.rollback();
//			LOG.error(e.getMessage());
		}finally{
			getFree(call, conn, session);
		}
		return bResult;
	}
	
}
