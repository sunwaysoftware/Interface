package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt12005yDAO;
import com.sunway.vo.Pgv12005;

/**
 * 
 * 成本，收益法数据操作状态
 * @category 成本，收益法数据操作状态
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt12005yDAO extends BaseDAO implements IPgt12005yDAO {

	// property constants
	private static final String swid = "SWID";							//税务登记代码
	private static final String nsrmc = "NSRMC";						//纳税人名称
	private static final String cd12001Swid = "CD_12001_SWID";		    //税务登记代码
	private static final String cd00002Pssd = "CD_00002_PSSD";		    //评税时点
	private static final String cbshzt = "CBSHZT";	            		//成本审核状态（审核未通过为0、正常审核：1、强制审核：2）
	private static final String cbpgzt = "CBPGZT";	            		//成本法评税状态（评税通过为1、评税未通过为0）
	private static final String cbskzt = "CBSKZT";	            		//成本应纳税款计算（应纳税款计算为1、应纳税款计算未计算为0）
	private static final String cbdycs = "CBDYCS";	            		//成本房地产税纳税通知单次数
	private static final String syshzt = "SYSHZT";	            		//收益审核状态（审核未通过为0、正常审核：1、强制审核：2）
	private static final String sypgzt = "SYPGZT";	            		//收益法评税状态（评税通过为1、评税未通过为0）
	private static final String syskzt = "SYSKZT";	            		//收益应纳税款计算（应纳税款计算为1、应纳税款计算未计算为0）
	private static final String sydycs = "SYDYCS";	           		    //收益房地产税纳税通知单次数
	private static final String cd00002Cbshczr = "CD_00002_CBSHCZR";	//成本审核操作人
	private static final String cd00002Cbpgczr = "CD_00002_CBPGCZR";	//成本法评税操作人
	private static final String cd00002Cbskczr = "CD_00002_CBSKCZR";	//成本应纳税款计算操作人
	private static final String cd00002Cbdyczr = "CD_00002_CBDYCZR";	//成本房地产税纳税通知单次数操作人
	private static final String cd00002Syshczr = "CD_00002_SYSHCZR";	//收益审核操作人
	private static final String cd00002Sypgczr = "CD_00002_SYPGCZR";	//收益法评税操作人
	private static final String cd00002Syskczr = "CD_00002_SYSKCZR";	//收益应纳税款计算操作人
	private static final String cd00002Sydyczr = "CD_00002_SYDYCZR";	//收益房地产税纳税通知单次数操作人
	private static final String cbshczr = "CBSHCZR";					//成本审核操作人
	private static final String cbpgczr = "CBPGCZR";					//成本法评税操作人
	private static final String cbskczr = "CBSKCZR";					//成本应纳税款计算操作人
	private static final String cbdyczr = "CBDYCZR";					//成本房地产税纳税通知单次数操作人
	private static final String syshczr = "SYSHCZR";					//收益审核操作人
	private static final String sypgczr = "SYPGCZR";					//收益法评税操作人
	private static final String syskczr = "SYSKCZR";					//收益应纳税款计算操作人
	private static final String sydyczr = "SYDYCZR";					//收益房地产税纳税通知单次数操作人
	private static final String cbzt = "CBZT";							//
	private static final String syzt = "SYZT";							//
	private static final String rid = "RID";							//行号
	private static final String total = "TOTAL";						//总纪录数
	
	private static final String cbpgjg = "CBPGJG";						
	private static final String sypgjg = "SYPGJG";						
	private static final String cbskjg = "CBSKJG";						
	private static final String syskjg = "SYSKJG";						
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12005DAO#LoadAll(com.sunway.vo.Pgv12005)
	 */
	
	@Override
	public ArrayList<Pgv12005> LoadAll(Pgv12005 v12005) throws Exception {
		ArrayList<Pgv12005> listResult = new ArrayList<Pgv12005>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12005(?,?,?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setInt(2, v12005.getPageIndex());
			call.setInt(3, v12005.getPageSize());
			call.setString(4, v12005.getCd12001Swid());
			call.setString(5, v12005.getNsrmc());
			call.setString(6, v12005.getCd00001Ssgx());
			call.setString(7, v12005.getCd00002Pssd());
			call.setInt(8, v12005.getCbzt());
			call.setInt(9, v12005.getSyzt());
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
	protected Pgv12005 SetVParameters(ResultSet rs) throws Exception {
		Pgv12005 e = new Pgv12005();
		e.setRecordCount(rs.getInt(total));
		e.setRecordIndex(rs.getInt(rid));
		e.setSwid(rs.getString(swid));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd12001Swid(cd12001Swid);
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setCbshzt(rs.getInt(cbshzt));
		e.setCbpgzt(rs.getInt(cbpgzt));
		e.setCbskzt(rs.getInt(cbskzt));
		e.setCbdycs(rs.getShort(cbdycs));
		e.setSyshzt(rs.getInt(syshzt));
		e.setSypgzt(rs.getInt(sypgzt));
		e.setSyskzt(rs.getInt(syskzt));
		e.setSydycs(rs.getShort(sydycs));
		e.setCd00002Cbshczr(rs.getString(cd00002Cbshczr));
		e.setCd00002Cbpgczr(rs.getString(cd00002Cbpgczr));
		e.setCd00002Cbskczr(rs.getString(cd00002Cbskczr));
		e.setCd00002Cbdyczr(rs.getString(cd00002Cbdyczr));
		e.setCd00002Syshczr(rs.getString(cd00002Syshczr));
		e.setCd00002Sypgczr(rs.getString(cd00002Sypgczr));
		e.setCd00002Syskczr(rs.getString(cd00002Syskczr));
		e.setCd00002Sydyczr(rs.getString(cd00002Sydyczr));
		e.setCbshczr(rs.getString(cbshczr));
		e.setCbpgczr(rs.getString(cbpgczr));
		e.setCbskczr(rs.getString(cbskczr));
		e.setCbdyczr(rs.getString(cbdyczr));
		e.setSyshczr(rs.getString(syshczr));
		e.setSypgczr(rs.getString(sypgczr));
		e.setSyskczr(rs.getString(syskczr));
		e.setSydyczr(rs.getString(sydyczr));
		e.setCbzt(rs.getInt(cbzt));
		e.setSyzt(rs.getInt(syzt));
		e.setCbpgjg(rs.getDouble(cbpgjg));
		e.setSypgjg(rs.getDouble(sypgjg));
		e.setCbskjg(rs.getDouble(cbskjg));
		e.setSyskjg(rs.getDouble(syskjg));
		return e;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt12005yDAO#GetExecRTJ(com.sunway.vo.Pgv12005)
	 */
	
	@Override
	public Boolean GetExecRTJ(Pgv12005 v12005) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12005(?,?,?,?,?,?)}");
			for(Integer step=0; step<v12005.getV12005List().size(); step++){
				//传入输入参数
				call.setString(1, v12005.getCd00002Pssd());
				call.setString(2, v12005.getV12005List().get(step).getCd12001Swid());
				call.setString(3, v12005.getNsrmc());
				call.setString(4, v12005.getCd00001Ssgx());
				call.setInt(5, v12005.getCbzt());
				call.setInt(6, v12005.getSyzt());
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
	 * @see com.sunway.dao.IPgt12005yDAO#GetExecRTJAll(com.sunway.vo.Pgv12005)
	 */
	
	@Override
	public Boolean GetExecRTJAll(Pgv12005 v12005) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12005(?,?,?,?,?,?)}");
			// 传入输入参数
			call.setString(1, v12005.getCd00002Pssd());
			call.setString(2, v12005.getCd12001Swid());
			call.setString(3, v12005.getNsrmc());
			call.setString(4, v12005.getCd00001Ssgx());
			call.setInt(5, v12005.getCbzt());
			call.setInt(6, v12005.getSyzt());
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
	 * @see com.sunway.dao.IPgt12005yDAO#GetBackup(com.sunway.vo.Pgv12005)
	 */
	
	@Override
	public Boolean GetBackup(Pgv12005 v12005) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_12000(?,?,?,?)}");
			// 传入输入参数
			call.setString(1, v12005.getCd00002Pssd());
			call.setString(2, v12005.getCd00001Ssgx());
			call.setString(3, v12005.getCd12001Swid());
			call.setString(4, v12005.getCd00002Czr());
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
