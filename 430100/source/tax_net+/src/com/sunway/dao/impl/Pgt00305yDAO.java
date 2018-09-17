package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00305yDAO;
import com.sunway.vo.Pgv00305;

/**
 *
 * 市场法数据操作状态表
 * @category 市场法数据操作状态表
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00305yDAO extends BaseDAO implements IPgt00305yDAO {

	// property constants
	private static final String total = "TOTAL";						//总纪录数
	private static final String cd00302Fcid = "CD_00302_FCID";			//国土编码
	private static final String cd00002Pssd = "CD_00002_PSSD";			//评税时点
	private static final String scshzt = "SCSHZT";	            		//市场审核状态（审核未通过为0、正常审核：1、强制审核：2）
	private static final String scpgzt = "SCPGZT";	            		//市场法评税状态（评税通过为1、评税未通过为0）
	private static final String scskzt = "SCSKZT";	            		//市场应纳税款计算（应纳税款计算为1、应纳税款计算未计算为0）
	private static final String scdycs = "SCDYCS";	            		//市场房地产税纳税通知单次数
	private static final String cd00002Scshczr = "CD_00002_SCSHCZR";	//市场审核操作人
	private static final String cd00002Scpgczr = "CD_00002_SCPGCZR";	//市场法评税操作人
	private static final String cd00002Scskczr = "CD_00002_SCSKCZR";	//市场应纳税款计算操作人
	private static final String cd00002Scdyczr = "CD_00002_SCDYCZR";	//市场房地产税纳税通知单次数操作人
	private static final String scshczr = "SCSHCZR";					//市场审核操作人
	private static final String scpgczr = "SCPGCZR";					//市场法评税操作人
	private static final String scskczr = "SCSKCZR";					//市场应纳税款计算操作人
	private static final String scdyczr = "SCDYCZR";					//市场房地产税纳税通知单次数操作人
	private static final String sczt = "SCZT";							//市场
	private static final String cd00301Swid = "CD_00301_SWID";			//税务登记代码
	private static final String nsrmc = "NSRMC";						//纳税人名称
	private static final String scpgjg = "SCPGJG";
	private static final String scskjg = "SCSKJG";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00305yDAO#LoadAll(com.sunway.vo.Pgv00305)
	 */
	
	@Override
	public ArrayList<Pgv00305> LoadAll(Pgv00305 v00305) throws Exception {
		ArrayList<Pgv00305> listResult = new ArrayList<Pgv00305>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00305(?,?,?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setInt(2, v00305.getPageIndex());
			call.setInt(3, v00305.getPageSize());
			call.setString(4, v00305.getCd00302Fcid());
			call.setString(5, v00305.getCd00301Swid());
			call.setString(6, v00305.getNsrmc());
			call.setString(7, v00305.getCd00001Ssgx());
			call.setString(8, v00305.getCd00002Pssd());
			call.setInt(9, v00305.getSczt());
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
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00305 SetVParameters(ResultSet rs) throws Exception {
		Pgv00305 e = new Pgv00305();
		e.setRecordCount(rs.getInt(total));
		e.setCd00302Fcid(rs.getString(cd00302Fcid));
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setScshzt(rs.getInt(scshzt));
		e.setScpgzt(rs.getInt(scpgzt));
		e.setScskzt(rs.getInt(scskzt));
		e.setScdycs(rs.getShort(scdycs));
		e.setCd00002Scshczr(rs.getString(cd00002Scshczr));
		e.setCd00002Scpgczr(rs.getString(cd00002Scpgczr));
		e.setCd00002Scskczr(rs.getString(cd00002Scskczr));
		e.setCd00002Scdyczr(rs.getString(cd00002Scdyczr));
		e.setScshczr(rs.getString(scshczr));
		e.setScpgczr(rs.getString(scpgczr));
		e.setScskczr(rs.getString(scskczr));
		e.setScdyczr(rs.getString(scdyczr));
		e.setCd00301Swid(rs.getString(cd00301Swid));
		e.setNsrmc(rs.getString(nsrmc));
		e.setSczt(rs.getInt(sczt));
		e.setScpgjg(rs.getDouble(scpgjg));
		e.setScskjg(rs.getDouble(scskjg));
		return e;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00305yDAO#GetExecRTJ(com.sunway.vo.Pgv00305)
	 */
	
	@Override
	public Boolean GetExecRTJ(Pgv00305 v00305) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00305(?,?,?,?,?,?)}");
			for(Integer step=0; step<v00305.getV00305List().size(); step++){
				//传入输入参数
				call.setString(1, v00305.getCd00002Pssd());
				call.setString(2, v00305.getV00305List().get(step).getCd00302Fcid());
				call.setString(3, v00305.getCd00301Swid());
				call.setString(4, v00305.getNsrmc());
				call.setString(5, v00305.getCd00001Ssgx());
				call.setInt(6, v00305.getSczt());
				call.execute();
			}
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

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00305yDAO#GetExecRTJAll(com.sunway.vo.Pgv00305)
	 */
	
	@Override
	public Boolean GetExecRTJAll(Pgv00305 v00305) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00305(?,?,?,?,?)}");
			// 传入输入参数
			call.setString(1, v00305.getCd00302Fcid());
			call.setString(2, v00305.getCd00301Swid());
			call.setString(3, v00305.getNsrmc());
			call.setString(4, v00305.getCd00001Ssgx());
			call.setInt(5, v00305.getSczt());
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

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00305yDAO#GetBackup(com.sunway.vo.Pgv00305)
	 */
	
	@Override
	public Boolean GetBackup(Pgv00305 v00305) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_00300(?,?,?,?)}");
			// 传入输入参数
			call.setString(1, v00305.getCd00002Pssd());
			call.setString(2, v00305.getCd00001Ssgx());
			call.setString(3, v00305.getCd00301Swid());
			call.setString(4, v00305.getCd00002Czr());
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
