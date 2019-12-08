package com.sunway.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt00303DAO;
import com.sunway.util.Common;
import com.sunway.vo.ExcelBean;
import com.sunway.vo.Pgt00303;
import com.sunway.vo.Pgv00303;


/**
 * 市场法楼房信息表维护
 * @author Lee
 * @version 1.0
 */
public class Pgt00303DAO extends BaseDAO implements IPgt00303DAO {

	private static final String total = "total";
	private static final String rid = "RID";
	private static final String lfid = "LFID";
	private static final String cd00352Xqdm = "CD_00352_XQDM";
	private static final String cd00001Jzjg = "CD_00001_JZJG";
	private static final String ywdt = "YWDT";
	private static final String zlc = "ZLC";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String xqnm = "XQNM";
	private static final String xqbm = "XQBM";
	private static final String szqy = "SZQY";
	private static final String cd00001Szqy = "CD_00001_SZQY";
	private static final String jzjg = "JZJG";
	private static final String czr = "CZR";
	private static final String zcdzl = "ZCDZL";
	private static final String zcdzbm = "ZCDZBM";
	private static final String fwtdzl = "FWTDZL";
	//private static final String ywlf = "YWLF";
	private static final String clh = "clh";
	private static final String ywjkc="YWJKC";	
	//private static final String jysj="JYSJ";
//	private static final String csfzjlx="CSFZJLX";
	//有无架空层
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00303DAO#LoadAll(com.sunway.vo.Pgv00303)
	 */
	
	@Override
	public ArrayList<Pgv00303> LoadAll(Pgv00303 v00303) throws Exception {
		ArrayList<Pgv00303> listResult = new ArrayList<Pgv00303>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00303(?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setInt(2, v00303.getPageIndex());
			call.setInt(3, v00303.getPageSize());
			call.setString(4, v00303.getLfid());
			call.setString(5, v00303.getCd00001Szqy());
			call.setString(6, v00303.getCd00352Xqdm());
			call.setString(7, v00303.getZcdzl());
			call.setString(8, v00303.getSsgx());
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
	 * @see com.sunway.dao.IPgt00303DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00303)
	 */
	
	@Override
	public Pgt00303 LoadByPrimaryKey(Pgt00303 t00303) throws Exception {
		ArrayList<Pgt00303> listResult = new ArrayList<Pgt00303>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00303(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t00303.getLfid());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		if (listResult != null && listResult.size() > 0) {
			return listResult.get(0);
		} else {
			return new Pgt00303();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00303DAO#GetInsertCommand(com.sunway.vo.Pgt00303)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt00303 t00303) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00303(?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 传入输入参数
			call.setString(1, t00303.getLfid());
			call.setString(2, t00303.getCd00352Xqdm());
			call.setString(3, t00303.getCd00001Jzjg());
			call.setBoolean(4, Common.checkNull(t00303.getYwdt()));
			call.setShort(5, t00303.getZlc());
			call.setString(6, t00303.getCd00002Czr());
			call.setString(7, t00303.getNote());
			call.setString(8, t00303.getSsgx());
			call.setString(9, t00303.getZcdzl());
			call.setString(10, t00303.getZcdzbm());
			call.setString(11, t00303.getClh());
			call.setBoolean(12, Common.checkNull(t00303.getYwjkc()));
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
	 * @see com.sunway.dao.IPgt00303DAO#GetDeleteCommand(com.sunway.vo.Pgt00303)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00303 t00303) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00303(?,?,?)}");
			// 传入输入参数
			call.setString(1, t00303.getLfid());
			call.setString(2, t00303.getCd00002Czr());
			call.setString(3, t00303.getSsgx());
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
	 * @see com.sunway.dao.IPgt00303DAO#GetUpdateCommand(com.sunway.vo.Pgt00303)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt00303 t00303) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00303(?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 传入输入参数
			call.setString(1, t00303.getLfid());
			call.setString(2, t00303.getCd00352Xqdm());
			call.setString(3, t00303.getCd00001Jzjg());
			call.setBoolean(4, Common.checkNull(t00303.getYwdt()));
			call.setShort(5, t00303.getZlc());
			call.setString(6, t00303.getCd00002Czr());
			call.setString(7, t00303.getNote());
			call.setString(8, t00303.getSsgx());
			call.setString(9, t00303.getZcdzl());
			call.setString(10, t00303.getZcdzbm());
			call.setString(11, t00303.getClh());
			call.setBoolean(12, Common.checkNull(t00303.getYwjkc()));
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
	 * @see com.sunway.dao.IPgt00303DAO#LoadMaxLfId()
	 */
	
	@Override
	public String LoadMaxLfId() throws Exception {
		String resultValue = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{? = call fn_getlfid()}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.VARCHAR);
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

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00303DAO#GetFwtdzl(com.sunway.vo.Pgv00303)
	 */
	
	@Override
	public ArrayList<String> GetFwtdzl(Pgv00303 v00303) throws Exception {
		ArrayList<String> listResult = new ArrayList<String>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_AUTO_00320A(?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v00303.getSzqy());
			call.setString(3, v00303.getZcdzl());
			call.execute();
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(rs.getString(1));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	@Override
	public ArrayList<String> GetLhdz(Pgv00303 v00303) throws Exception {
		ArrayList<String> listResult = new ArrayList<String>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_AUTO_00320B(?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v00303.getSzqy());
			call.setString(3, v00303.getZcdzl());
			call.setString(4, v00303.getLh());
			call.execute();
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(rs.getString(1));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	@Override
	public ArrayList<String> GetDyhdz(Pgv00303 v00303) throws Exception {
		ArrayList<String> listResult = new ArrayList<String>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_AUTO_00320C(?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v00303.getSzqy());
			call.setString(3, v00303.getZcdzl());
			call.setString(4, v00303.getLh());
			call.setString(5, v00303.getDyh());
			call.execute();
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(rs.getString(1));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	@Override
	public ArrayList<String> GetFhdz(Pgv00303 v00303) throws Exception {
		ArrayList<String> listResult = new ArrayList<String>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_AUTO_00320D(?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v00303.getSzqy());
			call.setString(3, v00303.getZcdzl());
			call.setString(4, v00303.getLh());
			call.setString(5, v00303.getDyh());
			call.setString(6, v00303.getFh());
			call.execute();
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(rs.getString(1));
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
	 * @see com.sunway.dao.IPgt00303DAO#GetHbInitList(java.lang.String)
	 */
	
	@Override
	public ArrayList<Pgv00303> GetHbInitList(String hbLfidList) throws Exception {
		ArrayList<Pgv00303> listResult = new ArrayList<Pgv00303>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003033(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, hbLfidList);
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetHBParameters(rs));
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
	 * @see com.sunway.dao.IPgt00303DAO#GetHBCommand(com.sunway.vo.Pgt00303)
	 */
	
	@Override
	public boolean GetHBCommand(Pgt00303 t00303) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00303(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 传入输入参数
			call.setString(1, t00303.getHbLfidList());
			call.setString(2, t00303.getLfid());
			call.setString(3, t00303.getCd00352Xqdm());
			call.setString(4, t00303.getCd00001Jzjg());
			call.setBoolean(5, Common.checkNull(t00303.getYwdt()));
			call.setShort(6, t00303.getZlc());
			call.setString(7, t00303.getCd00002Czr());
			call.setString(8, t00303.getNote());
			call.setString(9, t00303.getSsgx());
			call.setString(10, t00303.getZcdzl());
			call.setString(11, t00303.getZcdzbm());
			call.setString(12, t00303.getClh());
			call.setBoolean(13, Common.checkNull(t00303.getYwjkc()));
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
	protected Pgv00303 SetVParameters(ResultSet rs) throws Exception {
		Pgv00303 e = new Pgv00303();
		e.setRecordCount(rs.getInt(total));
		e.setRecordIndex(rs.getInt(rid));
		e.setLfid(rs.getString(lfid));
		e.setCd00352Xqdm(rs.getString(cd00352Xqdm));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setYwdt(rs.getBoolean(ywdt));
		e.setZlc(rs.getShort(zlc));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setJzjg(rs.getString(jzjg));
		e.setCzr(rs.getString(czr));
		e.setZcdzbm(rs.getString(zcdzbm));
		e.setFwtdzl(rs.getString(fwtdzl));
		e.setZcdzbm(rs.getString(zcdzbm));
		e.setZcdzl(rs.getString(zcdzl));
		e.setClh(rs.getString(clh));
		e.setYwjkc(rs.getInt(ywjkc));
		//e.setJysj(rs.getTimestamp(jysj));
		
		return e;
	}

	/**
	 * Edit数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00303 SetTParameters(ResultSet rs) throws Exception {
		Pgt00303 e = new Pgt00303();
		e.setLfid(rs.getString(lfid));
		e.setCd00352Xqdm(rs.getString(cd00352Xqdm));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setYwdt(rs.getBoolean(ywdt));
		e.setZlc(rs.getShort(zlc));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setXqnm(rs.getString(xqnm));
		e.setJzjg(rs.getString(jzjg));
		e.setZcdzbm(rs.getString(zcdzbm));
		e.setZcdzl(rs.getString(zcdzl));
		e.setClh(rs.getString(clh));
		e.setYwjkc(rs.getBoolean(ywjkc));
		return e;
	}


	/**
	 * 合并数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00303 SetHBParameters(ResultSet rs) throws Exception {
		Pgv00303 e = new Pgv00303();
		e.setLfid(rs.getString(lfid));
		e.setCd00352Xqdm(rs.getString(cd00352Xqdm));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setYwdt(rs.getBoolean(ywdt));
		e.setZlc(rs.getShort(zlc));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setJzjg(rs.getString(jzjg));
		e.setCzr(rs.getString(czr));
		e.setFwtdzl(rs.getString(fwtdzl));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00303DAO#GetLFID(com.sunway.vo.Pgv00303)
	 */
	
	@Override
	public Pgv00303 GetLFID(Pgv00303 v00303) throws Exception {
		Pgv00303 resultValue = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		ResultSet rs = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003032(?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setString(2, v00303.getZcdzl());
			call.setString(3, v00303.getClh());
			call.setString(4, v00303.getSsgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				resultValue = SetParameters(rs);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return resultValue;
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00303 SetParameters(ResultSet rs) throws Exception {
		Pgv00303 e = new Pgv00303();
		e.setRecordCount(rs.getInt(total));
		e.setRecordIndex(rs.getInt(rid));
		e.setLfid(rs.getString(lfid));
		e.setCd00352Xqdm(rs.getString(cd00352Xqdm));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setYwdt(rs.getBoolean(ywdt));
		e.setZlc(rs.getShort(zlc));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setJzjg(rs.getString(jzjg));
		e.setCzr(rs.getString(czr));
		e.setZcdzbm(rs.getString(zcdzbm));
		e.setFwtdzl(rs.getString(fwtdzl));
		e.setZcdzbm(rs.getString(zcdzbm));
		e.setZcdzl(rs.getString(zcdzl));
		//e.setYwlf(rs.getInt(ywlf));
		e.setClh(rs.getString(clh));
		e.setYwjkc(rs.getInt(ywjkc));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00303DAO#GetFWDZ(com.sunway.vo.Pgv00303)
	 */
	
	@Override
	public Pgv00303 GetFWDZ(Pgv00303 v00303) throws Exception {
		Pgv00303 resultValue = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		ResultSet rs = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003031(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setString(2, v00303.getZcdzbm());
			call.setString(3, v00303.getSsgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				resultValue = SetVParameters(rs);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return resultValue;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00352DAO#ExportGJFQSjcx(com.sunway.vo.Pgv00352)
	 */
	
	
	@Override
	public OutputStream ExportlfpcSjcx(Pgv00303 v00303) throws Exception {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00303(?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
		
			
			call.setInt(2, v00303.getPageIndex());
			call.setInt(3, v00303.getPageSize());
			call.setString(4, v00303.getLfid());
			call.setString(5, v00303.getCd00001Szqy());
			call.setString(6, v00303.getCd00352Xqdm());
			call.setString(7, v00303.getZcdzl());
			call.setString(8, v00303.getSsgx());
			call.execute();
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			if(rs!=null){
				// 创建excel对象
		        Label label;   
		        WritableWorkbook workbook; 
	            workbook = Workbook.createWorkbook(strBufResult);   
	            WritableSheet sheet = workbook.createSheet("查询信息", 0);
	            // 写入标头
	          
				label = new Label(0, 0, "所在区域");
				sheet.addCell(label);	
				label = new Label(1, 0, "小区名称");
				sheet.addCell(label);	
				label = new Label(2, 0, "楼房地址");
				sheet.addCell(label);	          
				label = new Label(3, 0, "地址别名");
				sheet.addCell(label);
				label = new Label(4, 0, "总楼层");
				sheet.addCell(label);	
				label = new Label(5, 0, "测量号");
				sheet.addCell(label);
				label = new Label(6, 0, "备注");
				sheet.addCell(label);
			
				   // 写入数据
				while(null!=rs && rs.next()){
					Integer rowIndex = rs.getRow();
					label = new Label(0, rowIndex, rs.getString(szqy));
					sheet.addCell(label);	
					label = new Label(1, rowIndex, rs.getString(xqnm));
					sheet.addCell(label);		
					label = new Label(2, rowIndex, rs.getString(zcdzl));
					sheet.addCell(label);	
					label = new Label(3, rowIndex, rs.getString(zcdzbm));
					sheet.addCell(label);	
					label = new Label(4, rowIndex, rs.getString(zlc));
					sheet.addCell(label);
					label = new Label(5, rowIndex, rs.getString(clh));
					sheet.addCell(label);	
					label = new Label(6, rowIndex, rs.getString(note));
					sheet.addCell(label);		
					
				}
	            workbook.write();   
	            workbook.close();  }
				
		}catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return strBufResult;
	}
	

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00303DAO#ImportExcelData(java.util.ArrayList)
	 */
	
	@Override
	public ExcelBean ImportExcelData(ArrayList<ExcelBean> ebList) throws Exception {
		ExcelBean excelBean = new ExcelBean();
		Integer resultValue = 0;
		Integer sResultCount = 0;		
		Session session = null;
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		Transaction tran = null;
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_ADDT003032(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			for(int i=0; i<ebList.size(); i++){
				ExcelBean bean = ebList.get(i);
				try {
					call.registerOutParameter(1, OracleTypes.CURSOR);
					
					call.setString(2, bean.getLfid());
					call.setString(3, bean.getXqNm());
					call.setString(4, bean.getJzjgNm());
					call.setShort(5, Common.convertToShort("0"));
					call.setShort(6, bean.getZlc());
					call.setString(7, bean.getCd00002Czr());
					call.setString(8, bean.getNote());
					call.setString(9, bean.getSsgx());
					call.setString(10, bean.getZcdzl());
					call.setString(11, bean.getLfmcbm());
					call.setString(12, bean.getClh());
					call.setInt(13, 0);
					call.setString(14, bean.getSzqyNm());
					call.execute();
					
					rs = (ResultSet) call.getObject(1); 
					if (null!=rs && rs.next()) {
						if (rs.getInt("flag") == 0) {
							sResultCount++;
							//标记哪列字段错误
							bean.setSzqyId(rs.getString("SQZY"));
							bean.setXqId(rs.getString("XQID"));
							bean.setZcdzlId(rs.getString("ZCDZID"));
							bean.setCwxx("");
							//将数据封装到list
							excelBean.getOutExcelList().add(bean);
						}
						rs.close();
					}
				} catch (Exception e) {
					sResultCount++;
					bean.setNote(e.getMessage());
					//将数据封装到list
					excelBean.getOutExcelList().add(bean);
					continue;
				}	
			}
			tran.commit();
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(rs, call, conn, session);
			if(sResultCount == 0)
				resultValue = 2;
			else if(sResultCount > 0)
				resultValue = 1;
			excelBean.setExportOutCome(resultValue);
		}
		return excelBean;
	}
	
	
	
}