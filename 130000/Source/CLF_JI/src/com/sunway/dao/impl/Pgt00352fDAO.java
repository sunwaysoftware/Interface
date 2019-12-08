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

import com.sunway.dao.IPgt00352fDAO;
import com.sunway.vo.Pgt00352f;
import com.sunway.vo.Pgv00352f;

/**
 * 
 * 土地相关照片
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt00352fDAO extends BaseDAO implements IPgt00352fDAO {

	// property constants
	private String zpid = "ZPID";					//图片ID
	private String zplx = "ZPLX";					//照片类型
	private String zplj = "ZPLJ";					//照片路径
	private String upddate = "UPDDATE";				//更新时间
	private String cd00002Czr = "CD_00002_CZR";		//录入人
	private String note = "NOTE";					//备注信息
	private String zplxmc = "ZPLXMC";
	private String czr = "CZR";
	private String zpljMin = "ZPLJ_MIN";
	private String cd00352xqdm="CD_00352_XQDM";
	private String zpLjdownLoad="zpLj_downLoad";
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00352fDAO#GetDeleteCommand(com.sunway.vo.Pgt00352f)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00352f t00352f) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00352F(?)}");
			call.setString(1, t00352f.getZpid());
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
	 * @see com.sunway.dao.IPgt00352fDAO#GetInsertCommand(com.sunway.vo.Pgt00352f)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt00352f t00352f) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		Integer rs = 0;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00352F1(?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.INTEGER);
			call.setString(2, t00352f.getCd00352Xqdm());
			call.setInt(3, t00352f.getZplx());
			call.setString(4, t00352f.getZplj());
			call.setString(5, t00352f.getCd00002Czr());
			call.setString(6, t00352f.getNote());
			call.setString(7, t00352f.getZpljMin());
			call.setString(8, t00352f.getZpLjdownLoad());
			call.execute();
			rs = call.getInt(1);
			if(1 == rs){
				tran.commit();
				bResult = true;
			}else{
				tran.rollback();
			}
		} catch (Exception e) {
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00352fDAO#GetUpdateCommand(com.sunway.vo.Pgt00352f)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt00352f t00352f) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00352F(?,?,?,?,?,?)}");
			call.setString(1, t00352f.getZpid());
			call.setString(2, t00352f.getCd00352Xqdm());
			call.setInt(3, t00352f.getZplx());
			call.setString(4, t00352f.getZplj());
			call.setString(5, t00352f.getCd00002Czr());
			call.setString(6, t00352f.getNote());
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
	 * @see com.sunway.dao.IPgt00352fDAO#LoadAll(com.sunway.vo.Pgt00352f)
	 */
	
	@Override
	public ArrayList<Pgv00352f> LoadAll(Pgt00352f t00352f) throws Exception {
		ArrayList<Pgv00352f> listResult = new ArrayList<Pgv00352f>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00352F(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, t00352f.getCd00352Xqdm());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVParameters(rs, false));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00352fDAO#LoadByPrimaryKey(com.sunway.vo.Pgt00352f)
	 */
	
	@Override
	public Pgt00352f LoadByPrimaryKey(Pgt00352f t00352f) throws Exception {
		ArrayList<Pgt00352f> listResult = new ArrayList<Pgt00352f>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00352F(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, t00352f.getZpid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return null;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00352fDAO#LoadByPrimaryKey(com.sunway.vo.Pgt00352f)
	 */
	
	@Override
	public Pgt00352f LoadByPrimaryKeyFC(Pgt00352f t00352f) throws Exception {
		ArrayList<Pgt00352f> listResult = new ArrayList<Pgt00352f>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00352F1(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, t00352f.getZpid());
			call.setInt(3, t00352f.getZplx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetTParametersFC(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return null;
	}

	/**
	 * Table數據轉存
	 * @param rs 數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgt00352f SetTParameters(ResultSet rs) throws Exception {
		Pgt00352f e = new Pgt00352f();
		e.setCd00002Czr(rs.getString(cd00002Czr));
//		e.setCd00352Dcid(rs.getString(cd00352Dcid));
		e.setNote(rs.getString(note));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setZpid(rs.getString(zpid));
		e.setZplj(rs.getString(zplj));
		e.setZplx(rs.getInt(zplx));
		e.setZpljMin(rs.getString(zpljMin));
		e.setCd00352Xqdm(rs.getString(cd00352xqdm));
		e.setZpLjdownLoad(rs.getString(zpLjdownLoad));
		return e;
	}
	
	/**
	 * Table數據轉存
	 * @param rs 數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgt00352f SetTParametersFC(ResultSet rs) throws Exception {
		Pgt00352f e = new Pgt00352f();
		e.setCd00002Czr(rs.getString(cd00002Czr));
//		e.setCd00352Dcid(rs.getString(cd00352Dcid));
		e.setNote(rs.getString(note));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setZpid(rs.getString(zpid));
		e.setZplj(rs.getString(zplj));
		e.setZplx(rs.getInt(zplx));
		e.setZpljMin(rs.getString(zpljMin));
		//e.setCd00352Xqdm(rs.getString(cd00352xqdm));
		e.setZpLjdownLoad(rs.getString(zpLjdownLoad));
		return e;
	}
	
	/**
	 * Table數據轉存
	 * @param rs 數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgv00352f SetVParameters(ResultSet rs, Boolean bZp) throws Exception {
		Pgv00352f e = new Pgv00352f();
		if(bZp){
			e.setZplx(rs.getInt(zplx));
			e.setZplxmc(rs.getString(zplxmc));
		} else {
			e.setCd00002Czr(rs.getString(cd00002Czr));
//			e.setCd00352Dcid(rs.getString(cd00352Dcid));
			e.setNote(rs.getString(note));
			e.setUpddate(rs.getTimestamp(upddate));
			e.setZpid(rs.getString(zpid));
			e.setZplj(rs.getString(zplj));
			e.setCzr(rs.getString(czr));
			e.setZplx(rs.getInt(zplx));
//			e.setZplxmc(rs.getString(zplxmc));
			e.setZpljMin(rs.getString(zpljMin));
			e.setCd00352xqdm(rs.getString(cd00352xqdm));
			e.setXqnm(rs.getString("XQNM"));
			//e.setQdh(rs.getString("QDH"));
			e.setZpLjdownLoad(rs.getString(zpLjdownLoad));
		}
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00352fDAO#LoadZplxList()
	 */
	
	@Override
	public ArrayList<Pgv00352f> LoadZplxList() throws Exception {
		ArrayList<Pgv00352f> listResult = new ArrayList<Pgv00352f>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call pgsp_getallcz00004(?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVParameters(rs, true));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	
	@Override
	public Boolean GetDeleteByXQCommand(Pgt00352f t00352f) throws Exception {
		boolean result = false;
		Session session = null;
		Connection conn = null;
		CallableStatement call = null;
		Transaction tran = null;
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_DELT00352F1(?)}");
			call.setString(1, t00352f.getCd00352Xqdm());
			call.execute();
			tran.commit();
			result = true;
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call,conn,session);
		}
		return result;
	}

	
	@Override
	public ArrayList<Pgv00352f> LoadAllFC(Pgt00352f t00352f) throws Exception {
		ArrayList<Pgv00352f> listResult = new ArrayList<Pgv00352f>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00352F1(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, t00352f.getCd00352Xqdm());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVParametersFC(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	protected Pgv00352f SetVParametersFC(ResultSet rs) throws Exception {
		Pgv00352f e = new Pgv00352f();
//		e.setZplx(rs.getInt(zplx));
//		e.setZplxmc(rs.getString(zplxmc));
		e.setCd00002Czr(rs.getString(cd00002Czr));
//			e.setCd00352Dcid(rs.getString(cd00352Dcid));
		e.setNote(rs.getString(note));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setZpid(rs.getString(zpid));
		e.setZplj(rs.getString(zplj));
		//e.setCzr(rs.getString(czr));
		e.setZplx(rs.getInt(zplx));
//			e.setZplxmc(rs.getString(zplxmc));
		e.setZpljMin(rs.getString(zpljMin));
		e.setCd00352xqdm(rs.getString(cd00352xqdm));
//		e.setCd00352xqdm(rs.getString("CD_00352_XQDMHM"));
//		e.setXqnm(rs.getString("XQNM"));
//		e.setQdh(Common.formatQDH(rs.getString("QDH")));
		e.setZpLjdownLoad(rs.getString(zpLjdownLoad));
		//e.setT00306Id("CD_00306_ID");
		return e;
	}
}
