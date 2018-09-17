package com.sunway.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt02061DAO;
import com.sunway.util.ConvertUtil;
import com.sunway.util.Excel;
import com.sunway.util.FormatUtil;
import com.sunway.vo.ExcelBean;
import com.sunway.vo.Pgt02061;
import com.sunway.vo.Pgt02050;
import com.sunway.vo.Pgv02061;

/**
 *
 * 市场法标准实例库
 * @category 系统维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02061DAO extends BaseDAO implements IPgt02061DAO {

	private static final String total = "TOTAL";
	private static final String slid = "SLID";
	private static final String cd00001Fwlx = "CD_00001_FWLX";
	private static final String cd00001Jylx = "CD_00001_JYLX";
	private static final String cd00001Jzjg = "CD_00001_JZJG";
	private static final String szlc = "SZLC";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String fwlx = "FWLX";
	private static final String jylx = "JYLX";
	private static final String jzjg = "JZJG";
	private static final String cd02050Xqdm = "CD_02050_XQDM";
	private static final String ywdt = "YWDT";
	private static final String zlc = "ZLC";
	private static final String xqnm = "XQNM";
	private static final String xqbm = "XQBM";
	private static final String szqy = "SZQY";
	private static final String cd00001Szqy = "CD_00001_SZQY";
	private static final String czr = "CZR";
	private static final String pfmjg = "PFMJG";
	private static final String dypfmjg = "DYPFMJG";
	private static final String zhxz = "ZHXZ";
	private static final String parentnm = "PARENTNM";
	private static final String fwtdzl = "FWTDZL";
	private static final String slks = "SLKS";
	private static final String sfsc = "sfsc";


	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt02061DAO#LoadAll(com.sunway.vo.Pgv02061)
	 */
	
	@Override
	public ArrayList<Pgv02061> LoadAll(Pgv02061 v02061) throws Exception {
		ArrayList<Pgv02061> listResult = new ArrayList<Pgv02061>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02061(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v02061.getPageIndex());
			call.setInt(3, v02061.getPageSize());
			call.setString(4, v02061.getCd02050Xqdm());
			call.setString(5, v02061.getXqnm());
			call.setString(6, v02061.getCd00001Szqy());
			call.setString(7, v02061.getSsgx());
			call.setString(8, v02061.getSlid());
			call.setString(9, v02061.getCd00001Fwlx());
			call.setDate(10, ConvertUtil.toSqlDate(v02061.getJysjMonth()));
			call.setInt(11, ConvertUtil.toInteger(v02061.getQyxz()));
			call.setInt(12, v02061.getBzfjg());
			call.setInt(13, v02061.getSfsc());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetVParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt02061DAO#LoadByPrimaryKey(com.sunway.vo.Pgt02061)
	 */
	
	@Override
	public Pgt02061 LoadByPrimaryKey(Pgt02061 t02061) throws Exception {
		ArrayList<Pgt02061> listResult = new ArrayList<Pgt02061>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02061(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t02061.getSlid());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		if (listResult != null && listResult.size() > 0) {
			return listResult.get(0);
		} else {
			return new Pgt02061();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt02061DAO#GetInsertCommand(com.sunway.vo.Pgt02061)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt02061 t02061) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02061(?,?,?,?,?,?,?,?,?)}");
			// 传入输入参数
			call.setString(1, t02061.getCd02050Xqdm());
			call.setString(2, t02061.getJcsj());			
			call.setString(3, t02061.getCd00001Fwlx());
			call.setDouble(4, t02061.getPfmjg());
			call.setString(5, t02061.getSsgx());
			call.setString(6, t02061.getCd00002Czr());
			call.setString(7, t02061.getNote());
			call.setDate(8, ConvertUtil.utilDateToSqlDate(t02061.getJysj()));
			call.setInt(9, t02061.getSfsc());
			
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
	 * @see com.sunway.dao.IPgt02061DAO#GetUpdateCommand(com.sunway.vo.Pgt02061)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt02061 t02061) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02061(?,?,?,?,?,?,?)}");
			// 传入输入参数
			call.setString(1, t02061.getSlid());
			call.setString(2, t02061.getCd02050Xqdm());
			call.setString(3, t02061.getJcsj());
			call.setString(4, t02061.getCd00001Fwlx());
			call.setString(5, t02061.getSsgx());
			call.setString(6, t02061.getCd00002Czr());
			call.setString(7, t02061.getNote());			
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
	 * @see com.sunway.dao.IPgt02061DAO#GetDeleteCommand(com.sunway.vo.Pgt02061)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt02061 t02061) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02061(?,?,?)}");
			// 传入输入参数
			call.setString(1, t02061.getSlid());
			call.setString(2, t02061.getCd00002Czr());
			call.setString(3, t02061.getSsgx());
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
	 * @see com.sunway.dao.IPgt02061DAO#LoadDetail(com.sunway.vo.Pgv02061)
	 */
	
	@Override
	public Pgv02061 LoadDetail(Pgv02061 v02061) throws Exception {
		ArrayList<Pgv02061> listResult = new ArrayList<Pgv02061>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020610(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v02061.getSlid());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetDParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		if (listResult != null && listResult.size() > 0) {
			return listResult.get(0);
		} else {
			return new Pgv02061();
		}
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv02061 SetVParameters(ResultSet rs) throws Exception {
		Pgv02061 e = new Pgv02061();
		e.setRecordCount(rs.getInt(total));
		e.setCd02050Xqdm(cd02050Xqdm);
		if("".equals(rs.getString(parentnm)) || null == rs.getString(parentnm)){
			e.setParentnm(rs.getString(xqnm));
			e.setXqnm("");
		}else{
			e.setParentnm(rs.getString(parentnm));
			e.setXqnm(rs.getString(xqnm));
		}
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setSlid(rs.getString(slid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setSfsc(rs.getInt(sfsc));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setFwlx(rs.getString(fwlx));
		e.setSzqy(rs.getString(szqy));
		e.setCzr(rs.getString(czr));	
		e.setDypfmjg(rs.getDouble(dypfmjg));
		return e;
	}
	
	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv02061 SetYParameters(ResultSet rs) throws Exception {
		Pgv02061 e = new Pgv02061();
		e.setRecordCount(rs.getInt(total));
		e.setSlid(rs.getString(slid));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setFwlx(rs.getString(fwlx));
		e.setCd02050Xqdm(rs.getString(cd02050Xqdm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCzr(rs.getString(czr));
		e.setDypfmjg(rs.getDouble(dypfmjg));
		if("".equals(rs.getString(parentnm)) || null == rs.getString(parentnm)){
			e.setParentnm(rs.getString(xqnm));
			e.setXqnm("");
		}else{
			e.setParentnm(rs.getString(parentnm));
			e.setXqnm(rs.getString(xqnm));
		}
		e.setSlks(rs.getInt(slks));
		return e;
	}
	
	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv02061 SetFParameters(ResultSet rs) throws Exception {
		Pgv02061 e = new Pgv02061();
		e.setRecordCount(rs.getInt(total));
		e.setSlid(rs.getString(slid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setFwlx(rs.getString(fwlx));	
		e.setCd02050Xqdm(rs.getString(cd02050Xqdm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCzr(rs.getString(czr));
		e.setDypfmjg(rs.getDouble(dypfmjg));
		if("".equals(rs.getString(parentnm)) || null == rs.getString(parentnm)){
			e.setParentnm(rs.getString(xqnm));
			e.setXqnm("");
		}else{
			e.setParentnm(rs.getString(parentnm));
			e.setXqnm(rs.getString(xqnm));
		}
		e.setSlks(rs.getInt(slks));
		return e;
	}

	/**
	 * Edit数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt02061 SetTParameters(ResultSet rs) throws Exception {
		Pgt02061 e = new Pgt02061();
		e.setSlid(rs.getString(slid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd02050Xqdm(rs.getString(cd02050Xqdm));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setXqnm(rs.getString(xqnm));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setSfsc(rs.getInt(sfsc));
		e.setFwlxsc(rs.getString(fwlx));
		e.setJcsj(rs.getString("jcsj"));
		return e;
	}

	/**
	 * Detail数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv02061 SetDParameters(ResultSet rs) throws Exception {
		Pgv02061 e = new Pgv02061();
		
		e.setSlid(rs.getString(slid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
//		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
//		e.setCd00001Cgzk(rs.getString(cd00001Cgzk));
		e.setSzlc(rs.getShort(szlc));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setFwlx(rs.getString(fwlx));
		e.setJylx(rs.getString(jylx));
		e.setJzjg(rs.getString(jzjg));
//		e.setFwcx(rs.getString(fwcx));
//		e.setCgzk(rs.getString(cgzk));
		e.setCd02050Xqdm(rs.getString(cd02050Xqdm));
		e.setYwdt(rs.getString(ywdt));
		e.setZlc(rs.getShort(zlc));
		e.setXqnm(rs.getString(xqnm));
		e.setParentnm(rs.getString(parentnm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCzr(rs.getString(czr));
		e.setZhxz(rs.getString(zhxz));
		e.setJcsj(rs.getString("jcsj"));
		//e.setPfmjg(rs.getDouble(pfmjg));
		//e.setJysj(rs.getDate("jysj"));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02061DAO#ExecCsSame(com.sunway.vo.Pgv02061)
	 */
	
	@Override
	public Boolean ExecCsSame(Pgv02061 v02061) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02061_UPD(?,?,?,?,?,?)}");
			// 输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			// 输入参数
			call.setString(2, v02061.getSlid());
			call.setDate(3, ConvertUtil.utilDateToSqlDate(v02061.getJysj()));
			call.setString(4, v02061.getCd00002Czr());
			call.setDouble(5, v02061.getGpqz());
			call.setDouble(6, v02061.getGpxf());
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
	 * @see com.sunway.dao.IPgt02061DAO#LoadAllCsSame(com.sunway.vo.Pgv02061)
	 */
	
	@Override
	public ArrayList<Pgv02061> LoadAllCsSame(Pgv02061 v02061) throws Exception {
		ArrayList<Pgv02061> listResult = new ArrayList<Pgv02061>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02061_CS(?,?,?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v02061.getPageIndex());
			call.setInt(3, v02061.getPageSize());
			call.setString(4, v02061.getCd00001Szqy());
			call.setString(5, v02061.getCd02050Xqdm());
			call.setString(6, v02061.getCd00001Fwlx());
			call.setString(7, v02061.getCd00001Jzjg());
			call.setString(8, v02061.getCd00001Jylx());
			call.setString(9, v02061.getYwdt());
			call.setDate(10, ConvertUtil.utilDateToSqlDate(v02061.getJysj()));
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgv02061 e = new Pgv02061();
				e.setRecordCount(rs.getInt(total));
				e.setSlid(rs.getString(slid));
				e.setXqnm(rs.getString(xqnm));
				e.setFwlx(rs.getString(fwlx));
				e.setJylx(rs.getString(jylx));
				e.setJzjg(rs.getString(jzjg));
				e.setYwdt(rs.getString(ywdt));	
				e.setSlCount(rs.getInt("SLCNT"));
				e.setGpCount(rs.getInt("GPCNT"));
				e.setFwtdzl(rs.getString(fwtdzl));
				listResult.add(e);
				e = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02061DAO#LoadAllCsSameByBzfID(com.sunway.vo.Pgv02061)
	 */
	
	@Override
	public ArrayList<Pgv02061> LoadAllCsSameByBzfID(Pgv02061 v02061) throws Exception {
		ArrayList<Pgv02061> listResult = new ArrayList<Pgv02061>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02061_CS1(?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v02061.getCd00001Szqy());
			call.setString(3, v02061.getCd02050Xqdm());
			call.setString(4, v02061.getCd00001Fwlx());
			call.setString(5, v02061.getCd00001Jzjg());
			call.setString(6, v02061.getCd00001Jylx());
			call.setString(7, v02061.getYwdt());
			call.setDate(8, ConvertUtil.utilDateToSqlDate(v02061.getJysj()));
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgv02061 e = new Pgv02061();
				e.setSlid(rs.getString(slid));
				listResult.add(e);
				e = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02061DAO#LoadAllCsDiff(com.sunway.vo.Pgv02061)
	 */
	
	@Override
	public ArrayList<Pgv02061> LoadAllCsDiffW(Pgv02061 v02061) throws Exception {
		ArrayList<Pgv02061> listResult = new ArrayList<Pgv02061>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02061_CS2(?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v02061.getPageIndex());
			call.setInt(3, v02061.getPageSize());
			call.setString(4, v02061.getCd02050Xqdm());
			call.setDate(5, ConvertUtil.utilDateToSqlDate(v02061.getJysj()));
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgv02061 e = new Pgv02061();
				e.setRecordCount(rs.getInt(total));
				e.setSlid(rs.getString(slid));
				e.setXqnm(rs.getString(xqnm));
				e.setFwlx(rs.getString(fwlx));
				e.setJylx(rs.getString(jylx));
				e.setJzjg(rs.getString(jzjg));
				e.setYwdt(rs.getString(ywdt));	
				e.setFwtdzl(rs.getString(fwtdzl));
				listResult.add(e);
				e = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02061DAO#LoadAllCsDiffY(com.sunway.vo.Pgv02061)
	 */
	
	@Override
	public ArrayList<Pgv02061> LoadAllCsDiffY(Pgv02061 v02061) throws Exception {
		ArrayList<Pgv02061> listResult = new ArrayList<Pgv02061>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02061_CS3(?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v02061.getPageIndex());
			call.setInt(3, v02061.getPageSize());
			call.setString(4, v02061.getCd02050Xqdm());
			call.setDate(5, ConvertUtil.utilDateToSqlDate(v02061.getJysj()));
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgv02061 e = new Pgv02061();
				e.setRecordCount(rs.getInt(total));
				e.setSlid(rs.getString(slid));
				e.setXqnm(rs.getString(xqnm));
				e.setFwlx(rs.getString(fwlx));
				e.setJylx(rs.getString(jylx));
				e.setJzjg(rs.getString(jzjg));
				e.setYwdt(rs.getString(ywdt));	
				e.setPfmjg(rs.getDouble(pfmjg));
				listResult.add(e);
				e = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02061DAO#CreateBZF(com.sunway.vo.Pgt02061)
	 */
	
	@Override
	public Integer CreateBZF(Pgt02061 t02061) throws Exception {
		Integer bResult = 0;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02061_ADD_F(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			//传入输入参数
			call.setString(2, t02061.getCd00001Szqy());
			call.setString(3, t02061.getCd02050Xqdm());
			call.setString(4, t02061.getCd00001Fwlx());
			call.setString(5, t02061.getSsgx());
			call.setString(6, t02061.getCd00002Czr());
			call.execute();
			
			bResult = call.getInt(1);
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02061DAO#LoadXqW()
	 */
	
	@Override
	public ArrayList<Pgt02050> LoadXqW(Pgt02061 bean) throws Exception {
		ArrayList<Pgt02050> listResult = new ArrayList<Pgt02050>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020504(?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd00001Szqy());
			call.setDate(3, ConvertUtil.utilDateToSqlDate(bean.getJysj()));	
			call.setString(4, bean.getCd02050Xqdm());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetNParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02061DAO#LoadXqY()
	 */
	
	@Override
	public ArrayList<Pgt02050> LoadXqY(Pgt02061 bean) throws Exception {
		ArrayList<Pgt02050> listResult = new ArrayList<Pgt02050>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020505(?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd00001Szqy());
			call.setDate(3, ConvertUtil.utilDateToSqlDate(bean.getJysj()));	
			call.setString(4, bean.getCd02050Xqdm());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetNParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	/**
	 * Tree数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt02050 SetNParameters(ResultSet rs) throws Exception {
		String xqdm =  "XQDM";
		String cd00001Szqylx = "CD_00001_SZQYLX";
		String cd00001Szqy = "CD_00001_SZQY";
		String parentdm =  "PARENTDM";
		String xqnm =  "XQNM";
		String xqbm =  "XQBM";
		String vieworder = "VIEWORDER";
		String upddate =  "UPDDATE";
		String cd00002Czr =  "CD_00002_CZR";
		String note = "NOTE";
		String isdir = "ISDIR";
		String level =  "level";
		
		Pgt02050 e = new Pgt02050();
		e.setXqdm(rs.getString(xqdm));
		e.setCd00001Szqylx(rs.getString(cd00001Szqylx));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setParentdm(rs.getString(parentdm));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setVieworder(rs.getShort(vieworder));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setIsdir(rs.getBoolean(isdir));
		e.setLevel(rs.getString(level));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02061DAO#ImportExcelData(java.util.ArrayList)
	 */
	
	@Override
	public ExcelBean ImportExcelData(ArrayList<ExcelBean> ebList)  throws Exception{
		ExcelBean excelBean = new ExcelBean();
		ArrayList<ExcelBean> tempList = new ArrayList<ExcelBean>();
		Integer resultValue = 0;
		Integer sResultCount = 0;
//		Integer fResultCount = 0;
		ResultSet rs = null;
		Session session = null;
		Connection conn = null;
		CallableStatement call = null;
		Transaction tran = null;
		try{
			session = getSession();
			conn = super.getConnection();	
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_ADDT020611(?,?,?,?,?,?,?,?,?,?,?,?)}");
			for(int i=0; i<ebList.size(); i++){
				
				ExcelBean bean = ebList.get(i);
				try {
					
					call.registerOutParameter(1, OracleTypes.CURSOR);
					// 传入输入参数
					call.setString(2, bean.getFwlxNm());
					call.setDouble(3, bean.getPfmjg());
					call.setString(4, bean.getXqNm());
					call.setString(5, bean.getSzqyNm());
					call.setString(6, bean.getCd00001Ssgx());
					call.setString(7, bean.getCd00002Czr());
					call.setString(8, bean.getNote());
					call.setDate(9, ConvertUtil.utilDateToSqlDate(bean.getJysj()));
					call.setDate(10, ConvertUtil.utilDateToSqlDate(bean.getJcsj()));
					call.setString(11,bean.getDmh());
					call.setInt(12,bean.getSfsc());
									
					call.execute();
					
					rs = (ResultSet) call.getObject(1); 
					if (null!=rs && rs.next()) {
						if (rs.getInt("flag") == 0) {
							sResultCount++;
							//标记哪一列字段错误
							
							bean.setXqId(rs.getString("TXQDM"));
							bean.setFwlxId(rs.getString("TFWLX"));
							bean.setSzqyId(rs.getString("SZQYID"));
							bean.setDmhId(rs.getString("TDMH"));
							bean.setImpErrorMsg("若无错误提示，请参考注释查看是否漏填写某项");
							/*bean.setJylxId(rs.getString("TJYLX"));
							bean.setJzjgId(rs.getString("TJZJG"));*/
							
							
							tempList.add(bean);
							//将数据封装到list
							excelBean.setOutExcelList(tempList);
						}
					}
					
				} catch (Exception e) {
					
					sResultCount++;
					e.printStackTrace();
					bean.setImpErrorMsg(e.getMessage());
					tempList.add(bean);
					//将数据封装到list
					excelBean.setOutExcelList(tempList);
					continue;
				}finally{					
					try{
						if(null!=rs) 
							rs.close();
					}catch (Exception e) {
						e.printStackTrace();
					}finally {
						rs = null;
					}
				}	
			}
			tran.commit();
		}catch(Exception e){	
			tran.rollback();
			e.printStackTrace();
		}finally{
			getFree(call, conn, session);
			if(sResultCount == 0){
				resultValue = 2;
//				WriteLogImp(ebList.get(0).getCd00001Ssgx(), "PGT02061", ebList.get(0).getCd00002Czr(), "标准房导入成功");
			}
			else if(sResultCount > 0){
				resultValue = 1;
//				WriteLogImp(ebList.get(0).getCd00001Ssgx(), "PGT02061", ebList.get(0).getCd00002Czr(), "标准房导入有异常");
			}
			excelBean.setExportOutCome(resultValue);
		}
		return excelBean;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02061DAO#ImportBZF(com.sunway.vo.Pgt02061)
	 */
	
	@Override
	public Integer ImportBZF(Pgt02061 t02061) throws Exception {
		Integer bResult = 0;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02061_ADD_T(?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			//传入输入参数
			call.setString(2, t02061.getCd00001Szqy());
			call.setString(3, t02061.getCd02050Xqdm());
			call.setString(4, t02061.getSsgx());
			call.setString(5, t02061.getCd00002Czr());
			call.execute();
			bResult = call.getInt(1);
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02061DAO#ExportDjxx(com.sunway.vo.Pgv02061)
	 */
	
	@Override
	public OutputStream ExportDjxx(Pgv02061 v02061) throws Exception {
		ByteArrayOutputStream strBufResult = null; 
        WritableWorkbook workbook = null; 
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			strBufResult = new ByteArrayOutputStream(); 
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02061(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v02061.getPageIndex());
			call.setInt(3, v02061.getPageSize());
			call.setString(4, v02061.getCd02050Xqdm());
			call.setString(5, v02061.getXqnm());
			call.setString(6, v02061.getCd00001Szqy());
			call.setString(7, v02061.getSsgx());
			call.setString(8, v02061.getSlid());
			call.setString(9, v02061.getCd00001Fwlx());
			call.setDate(10, ConvertUtil.toSqlDate(v02061.getJysjMonth()));
			call.setInt(11,Integer.parseInt(v02061.getQyxz()));
			call.setInt(12, v02061.getBzfjg());
			call.setInt(13, v02061.getSfsc());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			if(rs != null){
				// 创建excel对象
		        Label label;   
		        Number number;

	            workbook = Workbook.createWorkbook(strBufResult);   
	            WritableSheet sheet = workbook.createSheet("标准房信息", 0);
	            WritableCellFormat wcf =Excel.getExcelTitleStyle();
	            // 写入标头	
				label = new Label(0, 0, "所在区域",wcf);
				sheet.addCell(label);		       
				label = new Label(1, 0, "片区名称",wcf);
				sheet.addCell(label);
				label = new Label(2, 0, "小区名称",wcf);
				sheet.addCell(label);
				label = new Label(3, 0, "房屋类型",wcf);
				sheet.addCell(label);
				/*if(v02061.getSfsc()==0){
					label = new Label(4, 0, "当前租赁单价(元/㎡.年)",wcf);
				}else if(v02061.getSfsc()==1){*/
					label = new Label(4, 0, "当前单价(元/㎡)",wcf);
				//}				
				sheet.addCell(label);
				label = new Label(5, 0, "操作人",wcf);
				sheet.addCell(label);
				label = new Label(6, 0, "更新时间",wcf);
				sheet.addCell(label);
				label = new Label(7, 0, "备注",wcf);
				sheet.addCell(label);
	            // 写入数据
				while(null!=rs && rs.next()){
					Integer rowIndex = rs.getRow();	
					label = new Label(0, rowIndex, rs.getString(szqy));
					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString(parentnm));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(xqnm));
					sheet.addCell(label);
					label = new Label(3, rowIndex, rs.getString(fwlx));
					sheet.addCell(label);
					Double pfm = Double.parseDouble(((null == rs.getString(dypfmjg) || "".equals(rs.getString(dypfmjg)))?"0":rs.getString(dypfmjg)));
					number = new Number(4, rowIndex, pfm);
					sheet.addCell(number);
					label = new Label(5, rowIndex, rs.getString(czr));
					sheet.addCell(label);
					label = new Label(6, rowIndex, FormatUtil.toYMDHMS(rs.getTimestamp(upddate)));
					sheet.addCell(label);
					label = new Label(7, rowIndex,rs.getString(note));
					sheet.addCell(label);
				}
	            workbook.write();   
			}
		} catch (Exception e) {
			if(null !=strBufResult){
				try{
					strBufResult.close();
				}catch(Exception e1){}
			}
			throw e;
		}finally{
			if(null != workbook){
				try{
					workbook.close();
				}catch(Exception e){}
			}
			getFree(rs, call, conn, null);
		}
		return strBufResult;
	}

	
	@Override
	public boolean GetUpdateDQBZFCommand(Pgt02061 t02061) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02061A1(?,?,?)}");
			call.registerOutParameter(1, OracleTypes.INTEGER);
			// 传入输入参数
			call.setDate(2, ConvertUtil.utilDateToSqlDate(t02061.getJysj()));
			call.setString(3, t02061.getCd00002Czr());
			call.execute();
			
			if (call.getInt(1)==1) {
				bResult = true;
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	
	@Override
	public Boolean GetExecCS(Pgv02061 v02061) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Transaction tran = null;
		Session session = null;
		
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_020311(?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.INTEGER);
			call.setString(2, v02061.getSlid());
			call.setDate(3, ConvertUtil.utilDateToSqlDate(v02061.getJysj()));
			call.setString(4, v02061.getCd00002Czr());
			//call.setInt(5, v02061.getMonthSet());
			call.setDate(5, ConvertUtil.utilDateToSqlDate(v02061.getJysjMin()));
			call.setDate(6, ConvertUtil.utilDateToSqlDate(v02061.getJysjMax()));
			//call.setTimestamp(7, v02061.getKbslkImps());
			//call.setTimestamp(8, v02061.getKbslkImpe());
			call.execute();
			tran.commit();
			if(call.getInt(1)==1)
				bResult = true;	
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return bResult;
	}
	
	/**
	 * 查询不可测算标准房
	 * @return 数据列表
	 * @throws Exception
	 */
	
	@Override
	public ArrayList<Pgv02061> findYbyID(Pgv02061 v02061) throws Exception {
		ArrayList<Pgv02061> listResult = new ArrayList<Pgv02061>();
		Connection conn = null;
		CallableStatement call = null;
		
		ResultSet rs = null;
		
		try{
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT0206111(?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, v02061.getCd02050Xqdm());
			call.setString(3, v02061.getCd00001Szqy());
			call.setString(4, v02061.getSsgx());
			call.setString(5, v02061.getCd00001Fwlx());
			call.setTimestamp(6, v02061.getKbslkJysjs());
			call.setTimestamp(7, v02061.getKbslkJysje());
			/*call.setInt(7, v02061.getBzfjg());
			call.setString(8, v02061.getZcdzl());*/
			call.setInt(8, v02061.getBzfjg());
			call.setString(9, v02061.getXqnm());
			call.setTimestamp(10, v02061.getKbslkImps());
			call.setTimestamp(11, v02061.getKbslkImpe());
			call.setInt(12, v02061.getSfsc());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				Pgv02061 e = new Pgv02061();
				e.setSlid(rs.getString(slid));
				listResult.add(e);
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return listResult;
	}
	
	/**
	 * 查询不可测算标准房
	 * @return 数据列表
	 * @throws Exception
	 */
	
	@Override
	public ArrayList<Pgv02061> findY(Pgv02061 v02061) throws Exception {
		ArrayList<Pgv02061> listResult = new ArrayList<Pgv02061>();
		Connection conn = null;
		CallableStatement call = null;
		
		ResultSet rs = null;
		
		try{
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020611(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v02061.getPageIndex());
			call.setInt(3, v02061.getPageSize());
			call.setString(4, v02061.getCd02050Xqdm());
			call.setString(5, v02061.getCd00001Szqy());
			call.setString(6, v02061.getSsgx());
			call.setString(7, v02061.getCd00001Fwlx());
			call.setTimestamp(8, v02061.getKbslkJysjs());
			call.setTimestamp(9, v02061.getKbslkJysje());
			call.setInt(10, v02061.getBzfjg());
			call.setString(11, v02061.getXqnm());
			//call.setTimestamp(11, v02061.getCssj());
			call.setTimestamp(12, v02061.getKbslkImps());
			call.setTimestamp(13, v02061.getKbslkImpe());
			call.setInt(14, v02061.getSfsc());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				listResult.add(SetYParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return listResult;
	}
	
	
	/**
	 * 查询可测算标准房
	 * @return 数据列表
	 * @throws Exception
	 */
	
	@Override
	public ArrayList<Pgv02061> findN(Pgv02061 v02061) throws Exception {
		ArrayList<Pgv02061> listResult = new ArrayList<Pgv02061>();
		Connection conn = null;
		
		CallableStatement call = null;
		ResultSet rs = null;
		
		try{
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020612(?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v02061.getPageIndex());
			call.setInt(3, v02061.getPageSize());
			call.setString(4, v02061.getCd02050Xqdm());
			call.setString(5, v02061.getCd00001Szqy());
			call.setString(6, v02061.getSsgx());
			call.setString(7, v02061.getCd00001Fwlx());
			//call.setInt(8, v02061.getMonthSet());
			call.setTimestamp(8, v02061.getKbslkJysjs());
			call.setTimestamp(9, v02061.getKbslkJysje());
			call.setInt(10, v02061.getBzfjg());
			call.setString(11, v02061.getXqnm());
			call.setInt(12, v02061.getSfsc());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				listResult.add(SetFParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return listResult;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt02061DAO#LoadAllFwlx(com.sunway.vo.Pgv02061)
	 */
	
	@Override
	public ArrayList<Pgv02061> LoadAllFwlx(Pgv02061 v02061) throws Exception {
		ArrayList<Pgv02061> listResult = new ArrayList<Pgv02061>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020613(?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v02061.getCd02050Xqdm());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgv02061 e = new Pgv02061();
				e.setFwlx(rs.getString(fwlx));
				e.setSfsc(rs.getInt(sfsc));
				listResult.add(e);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}
	
	
	
	public ArrayList<Pgv02061> LoadAllByBZFGLXQ(Pgv02061 v02061) throws Exception{
		ArrayList<Pgv02061> listResult = new ArrayList<Pgv02061>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try{
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020614(?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v02061.getPageIndex());
			call.setInt(3, v02061.getPageSize());
			call.setString(4, v02061.getCd02050Xqdm());
			call.setString(5, v02061.getXqnm());
			call.setString(6, v02061.getCd00001Szqy());
			call.setString(7, v02061.getSsgx());
			call.setString(8, v02061.getSlid());
			call.setString(9, v02061.getCd00001Fwlx());
			call.setString(10, v02061.getJysjMonth());
			call.setString(11, v02061.getQdh());
			call.setInt(12, v02061.getSfsc());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(rs != null && rs.next()){
				listResult.add(SetVParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	
	@Override
	public ArrayList<Pgv02061> LoadAllByBZFGLDQ(Pgv02061 v02061)
			throws Exception {
		ArrayList<Pgv02061> listResult = new ArrayList<Pgv02061>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		
		try{
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020615(?,?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v02061.getPageIndex());
			call.setInt(3, v02061.getPageSize());
			call.setString(4, v02061.getCd02050Xqdm());
			call.setString(5, v02061.getXqnm());
			call.setString(6, v02061.getCd00001Szqy());
			call.setString(7, v02061.getSsgx());
			call.setString(8, v02061.getSlid());
			call.setString(9, v02061.getCd00001Fwlx());
			call.setString(10, v02061.getJysjMonth());
			call.setInt(12, v02061.getSfsc());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(rs != null && rs.next()){
				listResult.add(SetVParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	
	@Override
	public OutputStream ExportCSY(Pgv02061 v02061) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		WritableWorkbook workbook = null;
		ResultSet rs = null;
		Connection conn = null;
		
		CallableStatement call = null;
		try{
			strBufResult = new ByteArrayOutputStream();
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020611(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v02061.getPageIndex());
			call.setInt(3, v02061.getPageSize());
			call.setString(4, v02061.getCd02050Xqdm());
			call.setString(5, v02061.getCd00001Szqy());
			call.setString(6, v02061.getSsgx());
			call.setString(7, v02061.getCd00001Fwlx());
			//call.setInt(8, v02061.getMonthSet());
			call.setTimestamp(8, v02061.getKbslkJysjs());
			call.setTimestamp(9, v02061.getKbslkJysje());
			call.setInt(10, v02061.getBzfjg());
			call.setString(11, v02061.getXqnm());
			//call.setTimestamp(11, v02061.getCssj());
			call.setTimestamp(12, v02061.getKbslkImps());
			call.setTimestamp(13, v02061.getKbslkImpe());
			call.setInt(14,v02061.getSfsc());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			
			if(rs != null){
				Label label;
				Number number;
				
				workbook = Workbook.createWorkbook(strBufResult);
				WritableSheet sheet = workbook.createSheet("可测算标准房", 0);
				WritableCellFormat wcf =Excel.getExcelTitleStyle();
				label = new Label(0, 0, "编码",wcf);
				sheet.addCell(label);
				label = new Label(1, 0, "所在区域",wcf);
				sheet.addCell(label);
				label = new Label(2, 0, "片区名称",wcf);
				sheet.addCell(label);
				label = new Label(3, 0, "小区名称",wcf);
				sheet.addCell(label);
				//label = new Label(4, 0, "坐落地址");
				//sheet.addCell(label);
				label = new Label(4, 0, "房屋类型",wcf);
				sheet.addCell(label);
				/*label = new Label(6, 0, "历史基准价格");
				sheet.addCell(label);*/
				if(v02061.getSfsc()==0){
					label = new Label(5, 0, "当前租赁单价(元/㎡.年)",wcf);
				}else if(v02061.getSfsc()==1){
					label = new Label(5, 0, "当前单价(元/㎡)",wcf);
				}	
				sheet.addCell(label);
				label = new Label(6, 0, "实例个数", wcf);
				sheet.addCell(label);
				label = new Label(7, 0, "更新时间",wcf);
				sheet.addCell(label);
				label = new Label(8, 0, "操作人",wcf);
				sheet.addCell(label);
				label = new Label(9, 0, "备注",wcf);
				sheet.addCell(label);

				
				while(rs != null && rs.next()){
					Integer rowIndex = rs.getRow();
					
					label = new Label(0, rowIndex, rs.getString(slid));
					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString(szqy));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(parentnm));
					sheet.addCell(label);
					label = new Label(3, rowIndex, rs.getString(xqnm));
					sheet.addCell(label);
					//label = new Label(4, rowIndex, rs.getString(fwtdzl));
					//sheet.addCell(label);
					label = new Label(4, rowIndex, rs.getString(fwlx));
					sheet.addCell(label);
					Double pfm = Double.parseDouble(((null == rs.getString(dypfmjg) || "".equals(rs.getString(dypfmjg)))?"0":rs.getString(dypfmjg)));
					number = new Number(5, rowIndex, pfm);
					sheet.addCell(number);
					label = new Label(6, rowIndex, rs.getString(slks));
					sheet.addCell(label);
					label = new Label(7, rowIndex, FormatUtil.toYMDHMS(rs.getTimestamp(upddate)));
					sheet.addCell(label);
					label = new Label(8, rowIndex, rs.getString(czr));
					sheet.addCell(label);
					label = new Label(9, rowIndex, rs.getString(note));
					sheet.addCell(label);
					
				}
				workbook.write();
			}
		}catch(Exception e){
			if(null !=strBufResult){
				try{
					strBufResult.close();
				}catch(Exception e1){}
			}
			throw e;
		}finally{
			if(null != workbook){
				try{
					workbook.close();
				}catch(Exception e){}
			}
			getFree(rs, call, conn, null);
		}
		return strBufResult;
	}
	
	
	@Override
	public OutputStream ExportCSN(Pgv02061 v02061) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		WritableWorkbook workbook = null;
		Connection conn = null;
		
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			strBufResult = new ByteArrayOutputStream();
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020612(?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v02061.getPageIndex());
			call.setInt(3, v02061.getPageSize());
			call.setString(4, v02061.getCd02050Xqdm());
			call.setString(5, v02061.getCd00001Szqy());
			call.setString(6, v02061.getSsgx());
			call.setString(7, v02061.getCd00001Fwlx());
			//call.setInt(8, v02061.getMonthSet());
			call.setTimestamp(8, v02061.getKbslkJysjs());
			call.setTimestamp(9, v02061.getKbslkJysje());
			call.setInt(10, v02061.getBzfjg());
			call.setString(11, v02061.getXqnm());
			call.setInt(12, v02061.getSfsc());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			
			if(rs != null){
				Label label;
				Number number;
			
				workbook = Workbook.createWorkbook(strBufResult);
				WritableSheet sheet = workbook.createSheet("不可测算标准房", 0);
				WritableCellFormat wcf =Excel.getExcelTitleStyle();
				label = new Label(0, 0, "编码",wcf);
				sheet.addCell(label);
				label = new Label(1, 0, "所在区域",wcf);
				sheet.addCell(label);
				label = new Label(2, 0, "片区名称",wcf);
				sheet.addCell(label);
				label = new Label(3, 0, "小区名称",wcf);
				sheet.addCell(label);
				label = new Label(4, 0, "房屋类型",wcf);
				sheet.addCell(label);
				if(v02061.getSfsc()==0){
					label = new Label(5, 0, "当前租赁单价(元/㎡.年)",wcf);
				}else if(v02061.getSfsc()==1){
					label = new Label(5, 0, "当前单价(元/㎡)",wcf);
				}					
				sheet.addCell(label);
				label = new Label(6, 0, "实例个数",wcf);
				sheet.addCell(label);
				label = new Label(7, 0, "更新时间",wcf);
				sheet.addCell(label);
				label = new Label(8, 0, "操作人",wcf);
				sheet.addCell(label);
				label = new Label(9, 0, "备注",wcf);
				sheet.addCell(label);
				
				
				while(rs != null && rs.next()){
					Integer rowIndex = rs.getRow();
					
					label = new Label(0, rowIndex, rs.getString(slid));
					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString(szqy));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(parentnm));
					sheet.addCell(label);
					label = new Label(3, rowIndex, rs.getString(xqnm));
					sheet.addCell(label);
					label = new Label(4, rowIndex, rs.getString(fwlx));
					sheet.addCell(label);
					Double pfm = Double.parseDouble(((null == rs.getString(dypfmjg) || "".equals(rs.getString(dypfmjg)))?"0":rs.getString(dypfmjg)));
					number = new Number(5, rowIndex, pfm);
					sheet.addCell(number);
					label = new Label(6, rowIndex, rs.getString(slks));
					sheet.addCell(label);
					label = new Label(7, rowIndex, FormatUtil.toYMDHMS(rs.getTimestamp(upddate)));
					sheet.addCell(label);
					label = new Label(8, rowIndex, rs.getString(czr));
					sheet.addCell(label);
					label = new Label(9, rowIndex, rs.getString(note));
					sheet.addCell(label);
				}
				workbook.write();
			}
		}catch(Exception e){
			if(null !=strBufResult){
				try{
					strBufResult.close();
				}catch(Exception e1){}
			}
			throw e;
		}finally{
			if(null != workbook){
				try{
					workbook.close();
				}catch(Exception e){}
			}
			getFree(rs, call, conn, null);
		}
		return strBufResult;
	}

	
	@Override
	public boolean ExecuteDQCS(Pgv02061 v02061) throws Exception {
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		boolean bResult = false;
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_CZ_02061_UPD1(?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.INTEGER );
			call.setString(2, v02061.getCd02050Xqdm());
			call.setDate(3, ConvertUtil.utilDateToSqlDate(v02061.getJysj()));
			call.setString(4, v02061.getSsgx());
			call.setString(5, v02061.getCd00002Czr());
			call.setString(6, v02061.getCd00001Szqy());
			call.setString(7, v02061.getFwlx());
			call.execute();
			tran.commit();
			if(call.getInt(1) == 1){
				bResult = true;
			}
			
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return bResult;
	}

	
	@Override
	public boolean ValiBZF(Pgv02061 v02061) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_020612(?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.INTEGER);
			call.setString(2, v02061.getCd02050Xqdm());
			call.setString(3, v02061.getCd00001Fwlx());
			call.setInt(4, v02061.getSfsc());
			call.execute();
			if(call.getObject(1) != null && (Integer)call.getObject(1) == 0){
				bResult = true;
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return bResult;
	}

	
	@Override
	public boolean GetSelDeleteCommand(Pgt02061 t02061) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT020611(?,?,?)}");
			call.setString(1, t02061.getChkSel());
			call.setString(2, t02061.getCd00002Czr());
			call.setString(3, t02061.getSsgx());
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
	public boolean GetDeleteAllCommand(Pgv02061 v02061) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT020612(?,?,?,?,?,?,?,?,?)}");
			call.setString(1, v02061.getCd02050Xqdm());
			call.setString(2, v02061.getXqnm());
			call.setString(3, v02061.getCd00001Szqy());
			call.setString(4, v02061.getSsgx());
			call.setString(5, v02061.getSlid());
			call.setString(6, v02061.getCd00001Fwlx());
			call.setInt(7, ConvertUtil.toInteger(v02061.getQyxz()));
			call.setInt(8, v02061.getBzfjg());
			call.setString(9, v02061.getCd00002Czr());
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
}
