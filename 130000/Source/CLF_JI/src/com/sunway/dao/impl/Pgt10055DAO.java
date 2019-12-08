package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt10055DAO;
import com.sunway.vo.Pgt10055;
import com.sunway.vo.Pgv10055;

/**
 * @category 成本法土地基准地价
 * @author Lee
 * @version 1.0						
 */
public class Pgt10055DAO extends BaseDAO implements IPgt10055DAO {

	
//	private static final String CD00001TDDJLX = "cd_00001_tddjlx";	//土地等级类型
	private static final String CD12054TDDJID = "cd_12054_tddjid";		//土地等级编号
	private static final String TDDJ = "tddj";						//土地等级名称
	private static final String CD00001TDYTLX = "cd_00001_tdytlx";	//土地用途类型编号
	private static final String CD00001TDYT = "cd_00001_tdyt";		//土地用途编号
	private static final String TDYT =  "tdyt";						//土地用途名称
//	private static final String CD00001SZQYLX = "cd_00001_szqylx";	//所在区域类型
	private static final String CD00001SZQY = "cd_00001_szqy";;		//所在区域编码
	private static final String SZQY =  "szqy";						//所在区域名称
	private static final String CD00002PSSD = "cd_00002_pssd";		//评税时点
	private static final String JZDJ = "jzdj";						//土地基准地价(元)
	private static final String LMDJ = "lmdj";						//宗地楼面地价(元)
	private static final String PJRJL = "pjrjl";					//平均容积率(%)
	private static final String CQF = "cqf";						//拆迁费(元)
	private static final String FWMS = "fwms";						//范围描述
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
	public boolean GetDeleteCommand(Pgt10055 tdjzdj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT10055(?,?,?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, tdjzdj.getCd00001Szqy());
			call.setString(2, tdjzdj.getCd00001Szqylx());
			call.setString(3, tdjzdj.getCd00001Tddj());
			call.setString(4, tdjzdj.getCd00001Tddjlx());
			call.setString(5, tdjzdj.getCd00001Tdyt());
			call.setString(6, tdjzdj.getCd00001Tdytlx());
			call.setString(7, tdjzdj.getCd00002Pssd());
			call.setString(8, tdjzdj.getCd00002Czr());
			call.setString(9, tdjzdj.getCd00001Ssgx());
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
	public boolean GetInsertCommand(Pgt10055 tdjzdj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT10055(?,?,?,?,?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, tdjzdj.getCd00001Tdyt());
			call.setString(2, tdjzdj.getCd00001Tddj());
			call.setString(3, tdjzdj.getCd00002Pssd());
			call.setDouble(4, tdjzdj.getJzdj());
			call.setDouble(5, tdjzdj.getLmdj());
			call.setDouble(6, tdjzdj.getPjrjl());
			call.setDouble(7, tdjzdj.getCqf());
			call.setString(8, tdjzdj.getCd00002Czr());
			call.setString(9, tdjzdj.getNote());
			call.setString(10, tdjzdj.getFwms());
			call.setString(11, tdjzdj.getCd00001Ssgx());
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
	public boolean GetUpdateCommand(Pgt10055 tdjzdj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT10055(?,?,?,?,?,?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, tdjzdj.getCd00001Tdytlx());
			call.setString(2, tdjzdj.getCd00001Tdyt());
			call.setString(3, tdjzdj.getCd00001Tddj());
			call.setString(4, tdjzdj.getCd00002Pssd());
			call.setDouble(5, tdjzdj.getJzdj());
			call.setDouble(6, tdjzdj.getLmdj());
			call.setDouble(7, tdjzdj.getPjrjl());
			call.setDouble(8, tdjzdj.getCqf());
			call.setString(9, tdjzdj.getCd00002Czr());
			call.setString(10, tdjzdj.getNote());
			call.setString(11, tdjzdj.getFwms());
			call.setString(12, tdjzdj.getCd00001Ssgx());
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
	public ArrayList<Pgv10055> LoadAll(Pgv10055 tdjzdj) throws Exception {
		ArrayList<Pgv10055> listResult = new ArrayList<Pgv10055>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT10055(?,?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, tdjzdj.getPageIndex());
			call.setInt(3, tdjzdj.getPageSize());
			call.setString(4, tdjzdj.getCd00001Tdyt());
			call.setString(5, tdjzdj.getCd00001Tddj());
			call.setString(6, tdjzdj.getCd00001Szqy());
			call.setString(7, tdjzdj.getCd00002Pssd());
			call.setString(8, tdjzdj.getCd00001Ssgx());
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
	protected Pgv10055 SetVParameters(ResultSet rs) throws Exception {
		Pgv10055 e = new Pgv10055();
		e.setCd00001Tdyt(rs.getString(CD00001TDYT));
		e.setCd00001Tdytlx(rs.getString(CD00001TDYTLX));
		//e.setCd00001Tddjlx(rs.getString(CD00001TDDJLX));
		e.setCd00001Tddj(rs.getString(CD12054TDDJID));
		//e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setJzdj(rs.getDouble(JZDJ));
		e.setLmdj(rs.getDouble(LMDJ));
		e.setPjrjl(rs.getDouble(PJRJL));
		e.setCqf(rs.getDouble(CQF));
		e.setFwms(rs.getString(FWMS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setSzqy(rs.getString(SZQY));
		e.setTddj(rs.getString(TDDJ));
		e.setTdyt(rs.getString(TDYT));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		e.setCzr(rs.getString(CZR));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt10055 LoadByPrimaryKey(Pgt10055 tdjzdj) throws Exception {
		ArrayList<Pgt10055> listResult = new ArrayList<Pgt10055>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT10055(?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, tdjzdj.getCd00001Tddj());
			call.setString(3, tdjzdj.getCd00001Tdyt());
			call.setString(4, tdjzdj.getCd00001Tdytlx());
			call.setString(5, tdjzdj.getCd00002Pssd());
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
			return tdjzdj;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt10055 SetTParameters(ResultSet rs) throws Exception {
		Pgt10055 e = new Pgt10055();
		e.setCd00001Tdyt(rs.getString(CD00001TDYT));
		e.setCd00001Tdytlx(rs.getString(CD00001TDYTLX));
//		e.setCd00001Tddjlx(rs.getString(CD00001TDDJLX));
		e.setCd00001Tddj(rs.getString(CD12054TDDJID));
//		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setJzdj(rs.getDouble(JZDJ));
		e.setTddj(rs.getString(TDDJ));
		e.setTdyt(rs.getString(TDYT));
		e.setLmdj(rs.getDouble(LMDJ));
		e.setPjrjl(rs.getDouble(PJRJL));
		e.setCqf(rs.getDouble(CQF));
		e.setFwms(rs.getString(FWMS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExecuteParamCopy(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean ExecuteParamCopy(Pgt10055 tdjzdj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {	
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_10055(?,?,?,?,?)}");
			call.setString(1, tdjzdj.getSpssd());
			call.setString(2, tdjzdj.getTpssd());
			call.setString(3, tdjzdj.getCd00001Szqy());
			call.setString(4, tdjzdj.getCd00002Czr());
			call.setString(5, tdjzdj.getCd00001Ssgx());
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
