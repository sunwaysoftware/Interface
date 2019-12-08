package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00052DAO;
import com.sunway.vo.Pgt00052;
import com.sunway.vo.Pgv00052;


/**
 * 税收管辖与所在区域对应关系
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00052DAO extends BaseDAO implements IPgt00052DAO {

	private static final String cd00001Szqylx =  "CD_00001_SZQYLX";
	private static final String cd00001Szqy =  "CD_00001_SZQY";
	private static final String szqy =  "SZQY";
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00052DAO#LoadAll(com.sunway.vo.Pgv00052)
	 */
	
	@Override
	public ArrayList<Pgv00052> LoadAll(Pgv00052 v00052) throws Exception{
		ArrayList<Pgv00052> listResult = new ArrayList<Pgv00052>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000521(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, v00052.getCd00001Ssgx());
			call.execute();
			//返回數據集
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
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00052DAO#GetUpdateCommand(com.sunway.vo.Pgt00052)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt00052 t00052) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00052(?,?,?,?)}");
			// 传入输入参数
			call.setString(1, t00052.getCd00001Ssgx());
			call.setString(2, t00052.getSzqy());
			call.setString(3, t00052.getCd00002Czr());
			call.setString(4, t00052.getNote());
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

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00052 SetVParameters(ResultSet rs) throws Exception {
		Pgv00052 e = new Pgv00052();
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCd00001Szqylx(rs.getString(cd00001Szqylx));
		e.setSzqy(rs.getString(szqy));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00052DAO#LoadSzqyBySsgx(java.lang.String)
	 */
	
	@Override
	public ArrayList<Pgv00052> LoadSzqyBySsgx(String ssgx) throws Exception {
		ArrayList<Pgv00052> listResult = new ArrayList<Pgv00052>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00052(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, ssgx);
			call.execute();
			//返回數據集
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
}
