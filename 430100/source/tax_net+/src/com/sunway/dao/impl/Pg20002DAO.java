/**
 * 
 */
package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPg20002DAO;
import com.sunway.vo.Pgv02002;
import com.sunway.vo.Pgv02031;

/**
 * 
 * 已評估[收益法]
 * @author Andy.Gao
 * @category 評估
 * @version 1.0
 *
 */
public class Pg20002DAO extends BaseDAO implements IPg20002DAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPg20002DAO#GetExecPgAgain(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public Boolean GetExecPgAgain(Pgv02002 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02033(?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getFcid());
			call.setString(2, bean.getPgCzr());
			call.setString(3, bean.getSsgx());
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
	 * @see com.sunway.dao.IPg20002DAO#GetExecPgAgainAll(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public Boolean GetExecPgAgainAll(Pgv02002 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;		
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02034(?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getFcid());
			call.setString(2, bean.getZjhm());
			call.setString(3, bean.getNsrmc());
			call.setString(4, bean.getSsgx());
			call.setString(5, bean.getShCzr());
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
	 * @see com.sunway.dao.IPg20002DAO#LoadPgOK(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public ArrayList<Pgv02031> LoadPgOK(Pgv02031 bean) throws Exception {
		ArrayList<Pgv02031> listResult = new ArrayList<Pgv02031>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02032(?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			
			call.setString(4, bean.getCd02002Fcid());
			call.setString(5, bean.getNsrmc());
			call.setString(6, bean.getZjhm());
			call.setString(7, bean.getCd00001Szqy());
			call.setString(8, bean.getCzr());
			call.setString(9, bean.getSysSsgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetV02031Parameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	/**
	 * View數據轉存
	 * @param rs 數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgv02031 SetV02031Parameters(ResultSet rs) throws Exception {
		Pgv02031 e=new Pgv02031();
		e.setRecordCount(rs.getInt("TOTAL"));
		e.setCd02002Fcid(rs.getString("CD_02002_FCID"));
		e.setNsrmc(rs.getString("Nsrmc"));
		e.setZjhm(rs.getString("Zjhm"));
		e.setUpddate(rs.getTimestamp("UPDDATE"));
		e.setCzr(rs.getString("SYPGCZR"));
		return e;
	}

	
	@Override
	public Boolean ExecInfoBg(Pgv02031 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;		
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02032(?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getCd02002Fcid());
			call.setString(2, bean.getPgCzr());
			call.setString(3, bean.getCd00001Ssgx());
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
	public Pgv02031 LoadPgxx(Pgv02031 bean) throws Exception {
		ArrayList<Pgv02031> resList = new ArrayList<Pgv02031>();
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		Session session = null;
		try{
			session = getSession();
		    conn = super.getConnection();
		    call = conn.prepareCall("{call PGSP_GETALLT02035(?,?)}");
		    call.registerOutParameter(1, OracleTypes.CURSOR);
		    call.setString(2, bean.getCd02002Fcid());
		    call.execute();
		    rs = (ResultSet)call.getObject(1);
		    while(null != rs && rs.next()){
		    	resList.add(SetPgxxParameters(rs));
		    }
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		if(null != resList && resList.size() > 0){
			return resList.get(0);
		}else{
			return bean;
		}
	}
	
	/**
	 * 评估信息装载
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	private Pgv02031 SetPgxxParameters(ResultSet rs)throws Exception{
		Pgv02031 e = new Pgv02031();
		e.setCd00001Ssgx(rs.getString("CD_00001_SSGX"));
		e.setCd00002Czr(rs.getString("CD_00002_CZR"));
		e.setCd02002Fcid(rs.getString("CD_02002_FCID"));
		e.setJysj(rs.getTimestamp("JYSJ"));//交易时间
		e.setJzmj(rs.getDouble("JZMJ"));//建筑面积
		e.setNszdxs(rs.getDouble("NSZDXS"));//纳税指导系数
		e.setPgjg(rs.getDouble("PGJG"));//评估价格		
		e.setUpddate(rs.getDate("UPDDATE"));
		return e;
	}
}
