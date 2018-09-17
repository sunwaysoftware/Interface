package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00306fDAO;
import com.sunway.vo.Pgt00306f;
import com.sunway.vo.Pgv00306f;

/**
 * 楼房信息图片 
 * @author Light
 *
 */
public class Pgt00306fDAO extends BaseDAO implements IPgt00306fDAO{
	
	private static final String ZPID = "zpid";
	private static final String CD00306ID = "cd_00306_id";
	private static final String ZPLX = "zplx";
	private static final String ZPLJ = "zplj";
	private static final String ZPLJMIN = "zplj_min";
	private static final String ZPLJDOWNLOAD = "zplj_download";
	private static final String UPDDATE = "upddate";
	private static final String CD00002CZR = "cd_00002_czr";
	private static final String NOTE = "note";
	private static final String CZR = "czr";
	private static final String XQNM = "xqnm";
	private static final String CD00352XQDM = "cd_00352_xqdm";
	

	
	@Override
	public ArrayList<Pgv00306f> LoadAll(Pgv00306f v00306f) throws Exception {
		ArrayList<Pgv00306f> resultList = new ArrayList<Pgv00306f>();
		Session session = null;
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00306F(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v00306f.getCd00306Id());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				resultList.add(SetVParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return resultList;
	}
	
	
	@Override
	public ArrayList<Pgv00306f> LoadAllByDz(Pgv00306f v00306f) throws Exception {
		ArrayList<Pgv00306f> resultList = new ArrayList<Pgv00306f>();
		Session session = null;
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00306F1(?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, v00306f.getCd00352Xqdm());
			call.setString(3, v00306f.getLh());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				Pgv00306f e = new Pgv00306f();
				e.setZplj(rs.getString(ZPLJ));
				resultList.add(e);
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return resultList;
	}
	
	/**
	 * 装在数据
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	protected Pgv00306f SetVParameters(ResultSet rs)throws Exception{
		Pgv00306f e = new Pgv00306f();
		e.setZpid(rs.getString(ZPID));
		e.setCd00306Id(rs.getInt(CD00306ID));
		e.setZplx(rs.getInt(ZPLX));
		e.setZplj(rs.getString(ZPLJ));
		e.setZpljMin(rs.getString(ZPLJMIN));
		e.setZpljDownLoad(rs.getString(ZPLJDOWNLOAD));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setCzr(rs.getString(CZR));
		e.setXqnm(rs.getString(XQNM));
		e.setCd00352Xqdm(rs.getString(CD00352XQDM));
		return e;
	}

	
	@Override
	public Boolean GetInsertCommand(Pgt00306f t00306f) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		Transaction tran = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00306F(?,?,?,?,?,?,?)}");
			call.setInt(1, t00306f.getCd00306Id());
			call.setInt(2, t00306f.getZplx());
			call.setString(3, t00306f.getZplj());
			call.setString(4, t00306f.getCd00002Czr());
			call.setString(5, t00306f.getNote());
			call.setString(6, t00306f.getZpljMin());
			call.setString(7, t00306f.getZpljDownLoad());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return bResult;
	}

	
	@Override
	public Pgt00306f LoadByPrimaryKey(Pgt00306f t00306f) throws Exception {
		ArrayList<Pgt00306f> resultList = new ArrayList<Pgt00306f>();
		Session session = null;
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00306F(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, t00306f.getZpid());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(rs != null && rs.next()){
				resultList.add(SetTParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		if(null != resultList && resultList.size() > 0){
			return resultList.get(0);
		}else{
			return t00306f;
		}
	}

	/**
	 * 装载数据 
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	protected Pgt00306f SetTParameters(ResultSet rs)throws Exception{
		Pgt00306f e = new Pgt00306f();
		e.setZpid(rs.getString(ZPID));
		e.setCd00306Id(rs.getInt(CD00306ID));
		e.setZplx(rs.getInt(ZPLX));
		e.setZplj(rs.getString(ZPLJ));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setZpljMin(rs.getString(ZPLJMIN));
		e.setZpljDownLoad(rs.getString(ZPLJDOWNLOAD));
		return e;
	}

	
	@Override
	public Boolean GetDeleteCommand(Pgt00306f t00306f) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		Transaction tran = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00306F(?)}");
			call.setString(1, t00306f.getZpid());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return bResult;
	}

	
	@Override
	public Boolean DelPhotoByLF(Pgt00306f t00306f) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00306F1(?)}");
			call.setInt(1, t00306f.getCd00306Id());
			call.execute();
			tran.commit();
			bResult =  true;
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return bResult;
	}

}
