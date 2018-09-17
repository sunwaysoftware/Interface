package com.sunway.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt02053DAO;

import com.sunway.util.Excel;
import com.sunway.util.FormatUtil;
import com.sunway.vo.Pgt02053;
import com.sunway.vo.Pgv02053;

/**
 * @category 非住宅综合修正赋值
 * @author Lee
 * @version 1.0
 * 
 */
public class Pgt02053DAO extends BaseDAO implements IPgt02053DAO {

	private static final String CD00001ROOT = "cd_00001_root"; // 采光状况类型编号
	private static final String ROOTNM = "rootnm"; // 采光状况类型
	private static final String CD00001INFOID = "cd_00001_infoid"; // 采光状况编号
	private static final String INFONM = "infonm"; // 采光状况名称
	private static final String CD00001SZQYLX = "CD_00001_SZQYLX"; // 所在区域类型
	private static final String CD00001SZQY = "CD_00001_SZQY"; // 所在区域编码
	private static final String SZQY = "szqy"; // 所在区域名称
	private static final String XZXS = "xzxs"; // 修正系数
	private static final String UPDDATE = "upddate"; // 更改时间
	private static final String CD00002CZR = "cd_00002_czr"; // 操作人编号
	private static final String CZR = "czr"; // 操作人
	private static final String NOTE = "note"; // 备注信息
	private static final String TOTAL = "total"; // 总纪录数
	private static final String FWLX = "fwlx"; // 房屋类型
	private static final String CD00001FWLXLX = "cd_00001_fwlxlx"; // 房屋类型类型
	private static final String CD00001FWLX = "cd_00001_fwlx"; // 房屋类型
	private static final String CD02050XQDM = "CD_02050_XQDM"; // 小区编码
	private static final String XQNM = "XQNM";
	private static final String SFMR = "sfmr";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt02053 cgzk) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02053(?,?,?,?,?,?)}");

			call.setString(1, cgzk.getCd00001Root());
			call.setString(2, cgzk.getCd00001Infoid());
			call.setString(3, cgzk.getCd00001Szqy());
			call.setString(4, cgzk.getCd00001Fwlx());
			call.setString(5, cgzk.getCd00002Czr());
			call.setString(6, cgzk.getCd00001Ssgx());
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
	 * 
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	
	public boolean GetDeleteCommandA(Pgt02053 cgzk) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02053A(?,?,?,?,?,?)}");

			call.setString(1, cgzk.getCd00001Root());
			call.setString(2, cgzk.getCd00001Infoid());
			call.setString(3, cgzk.getCd02050Xqdm());
			call.setString(4, cgzk.getCd00001Fwlx());
			call.setString(5, cgzk.getCd00002Czr());
			call.setString(6, cgzk.getCd00001Ssgx());
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
	 * 
	 * @see com.sunway.dao.IPgt10051DAO#GetInsertCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt02053 cgzk) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02053(?,?,?,?,?,?,?,?,?)}");
			call.setString(1, cgzk.getCd00001Root());
			call.setString(2, cgzk.getCd00001Infoid());
			call.setString(3, cgzk.getCd00001Szqy());
			call.setDouble(4, cgzk.getXzxs());
			call.setString(5, cgzk.getCd00002Czr());
			call.setString(6, cgzk.getNote());
			call.setString(7, cgzk.getCd00001Ssgx());
			call.setString(8, cgzk.getCd00001Fwlx());
			call.setInt(9, cgzk.getSfmr());
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
	 * 
	 * @see com.sunway.dao.IPgt10051DAO#GetInsertCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetInsertCommandA(Pgt02053 cgzk) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02053A(?,?,?,?,?,?,?,?)}");
			call.setString(1, cgzk.getCd00001Root());
			call.setString(2, cgzk.getCd00001Infoid());
			call.setString(3, cgzk.getCd02050Xqdm());
			call.setDouble(4, cgzk.getXzxs());
			call.setString(5, cgzk.getCd00002Czr());
			call.setString(6, cgzk.getNote());
			call.setString(7, cgzk.getCd00001Ssgx());
			call.setString(8, cgzk.getCd00001Fwlx());
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
	 * 
	 * @see com.sunway.dao.IPgt10051DAO#GetUpdateCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt02053 cgzk) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02053(?,?,?,?,?,?,?,?,?)}");
			call.setString(1, cgzk.getCd00001Root());
			call.setString(2, cgzk.getCd00001Infoid());
			call.setString(3, cgzk.getCd00001Fwlx());
			call.setString(4, cgzk.getCd00001Szqy());
			call.setDouble(5, cgzk.getXzxs());
			call.setString(6, cgzk.getCd00002Czr());
			call.setString(7, cgzk.getNote());
			call.setString(8, cgzk.getCd00001Ssgx());
			call.setInt(9, cgzk.getSfmr());
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
	 * 
	 * @see com.sunway.dao.IPgt10051DAO#GetUpdateCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetUpdateCommandA(Pgt02053 cgzk) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02053A(?,?,?,?,?,?,?,?)}");
			call.setString(1, cgzk.getCd00001Root());
			call.setString(2, cgzk.getCd00001Infoid());
			call.setString(3, cgzk.getCd00001Fwlx());
			call.setString(4, cgzk.getCd02050Xqdm());
			call.setDouble(5, cgzk.getXzxs());
			call.setString(6, cgzk.getCd00002Czr());
			call.setString(7, cgzk.getNote());
			call.setString(8, cgzk.getCd00001Ssgx());
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
	 * 
	 * @see com.sunway.dao.IPgt10051DAO#LoadAll(com.sunway.vo.Pgv10051)
	 */
	
	@Override
	public ArrayList<Pgv02053> LoadAll(Pgv02053 cgzk) throws Exception {
		ArrayList<Pgv02053> listResult = new ArrayList<Pgv02053>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		try {
			conn = super.getConnection();
			call = conn
					.prepareCall("{call PGSP_GETALLT02053(?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 注册输入参数
			call.setInt(2, cgzk.getPageIndex());
			call.setInt(3, cgzk.getPageSize());
			call.setString(4, cgzk.getCd00001Root());
			call.setString(5, cgzk.getCd00001Infoid());
			call.setString(6, cgzk.getCd00001Szqy());
			call.setString(7, cgzk.getCd00001Ssgx());
			call.setString(8, cgzk.getCd00001Fwlx());
			call.execute();
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
	 * 
	 * @see com.sunway.dao.IPgt10051DAO#LoadAll(com.sunway.vo.Pgv10051)
	 */

	
	public ArrayList<Pgv02053> LoadAllA(Pgv02053 cgzk) throws Exception {
		ArrayList<Pgv02053> listResult = new ArrayList<Pgv02053>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			
			conn = super.getConnection();
			call = conn
					.prepareCall("{call PGSP_GETALLT02053A(?,?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 注册输入参数
			call.setInt(2, cgzk.getPageIndex());
			call.setInt(3, cgzk.getPageSize());
			call.setString(4, cgzk.getCd00001Root());
			call.setString(5, cgzk.getCd00001Infoid());
			call.setString(6, cgzk.getCd00001Szqy());
			call.setString(7, cgzk.getCd00001Ssgx());
			call.setString(8, cgzk.getCd00001Fwlx());
			call.setString(9, cgzk.getCd02050Xqdm());
			call.execute();
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetVParametersA(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	/**
	 * View数据转存
	 * 
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv02053 SetVParameters(ResultSet rs) throws Exception {
		Pgv02053 e = new Pgv02053();
		e.setCd00001Root(rs.getString(CD00001ROOT));
		e.setCd00001Infoid(rs.getString(CD00001INFOID));
		e.setRootNm(rs.getString(ROOTNM));
		e.setInfoNm(rs.getString(INFONM));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setSzqy(rs.getString(SZQY));
		e.setXzxs(rs.getDouble(XZXS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setCzr(rs.getString(CZR));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setCd00001Fwlxlx(rs.getString(CD00001FWLXLX));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setFwlx(rs.getString(FWLX));
		e.setSfmr(rs.getInt(SFMR));
		return e;
	}

	/**
	 * View数据转存
	 * 
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv02053 SetVParametersA(ResultSet rs) throws Exception {
		Pgv02053 e = new Pgv02053();
		e.setCd00001Root(rs.getString(CD00001ROOT));
		e.setCd00001Infoid(rs.getString(CD00001INFOID));
		e.setRootNm(rs.getString(ROOTNM));
		e.setInfoNm(rs.getString(INFONM));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setSzqy(rs.getString(SZQY));
		e.setXzxs(rs.getDouble(XZXS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setCzr(rs.getString(CZR));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setCd00001Fwlxlx(rs.getString(CD00001FWLXLX));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setFwlx(rs.getString(FWLX));
		e.setCd02050Xqdm(rs.getString(CD02050XQDM));
		e.setXqnm(rs.getString(XQNM));
		e.setXqdmhm(rs.getString("xqdmhm"));
		return e;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt02053 LoadByPrimaryKey(Pgt02053 cgzk) throws Exception {
		ArrayList<Pgt02053> listResult = new ArrayList<Pgt02053>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02053(?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, cgzk.getCd00001Root());
			call.setString(3, cgzk.getCd00001Infoid());
			call.setString(4, cgzk.getCd00001Szqy());
			call.setString(5, cgzk.getCd00001Fwlx());
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
		if (listResult != null && listResult.size() > 0)
			return listResult.get(0);
		else
			return cgzk;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt02053 LoadByPrimaryKeyA(Pgt02053 cgzk) throws Exception {
		ArrayList<Pgt02053> listResult = new ArrayList<Pgt02053>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02053A(?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, cgzk.getCd00001Root());
			call.setString(3, cgzk.getCd00001Infoid());
			call.setString(4, cgzk.getCd02050Xqdm());
			call.setString(5, cgzk.getCd00001Fwlx());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetTParametersA(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		if (listResult != null && listResult.size() > 0)
			return listResult.get(0);
		else
			return cgzk;
	}

	/**
	 * View数据转存
	 * 
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt02053 SetTParameters(ResultSet rs) throws Exception {
		Pgt02053 e = new Pgt02053();
		e.setCd00001Root(rs.getString(CD00001ROOT));
		e.setCd00001Infoid(rs.getString(CD00001INFOID));
		e.setInfoNm(rs.getString(INFONM));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00001Fwlxlx(rs.getString(CD00001FWLXLX));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setXzxs(rs.getDouble(XZXS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setSfmr(rs.getInt(SFMR));
		return e;
	}

	/**
	 * View数据转存
	 * 
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt02053 SetTParametersA(ResultSet rs) throws Exception {
		Pgt02053 e = new Pgt02053();
		e.setCd00001Root(rs.getString(CD00001ROOT));
		e.setCd00001Infoid(rs.getString(CD00001INFOID));
		e.setInfoNm(rs.getString(INFONM));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00001Fwlxlx(rs.getString(CD00001FWLXLX));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setXzxs(rs.getDouble(XZXS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setCd02050Xqdm(rs.getString(CD02050XQDM));
		e.setXqnm(rs.getString(XQNM));
		return e;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunway.dao.IPgt10051DAO#ExecuteParamCopy(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean ExecuteParamCopy(Pgt02053 cgzk) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02053(?,?,?,?,?)}");
			call.setString(3, cgzk.getCd00001Szqy());
			call.setString(4, cgzk.getCd00002Czr());
			call.setString(5, cgzk.getCd00001Ssgx());
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
	 * 
	 * @see com.sunway.dao.IPgt02053DAO#LoadObj()
	 */
	
	@Override
	public Map<String, String> LoadObj(Pgt02053 cgzk) throws Exception {
		Map<String, String> listResult = new HashMap<String, String>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLCZ02053(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 输入参数
			call.setString(2, cgzk.getCd00001Szqy());
			call.execute();
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.put(rs.getString(1), rs.getString(2));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	
	@Override
	public OutputStream ExportT053(Pgv02053 v02053) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		WritableWorkbook workbook = null;
		Connection conn = null;
		
		CallableStatement call = null;
		ResultSet rs = null;
		try {
			strBufResult = new ByteArrayOutputStream();
			
			conn = super.getConnection();
			call = conn
					.prepareCall("{call PGSP_GETALLT02053(?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 注册输入参数
			call.setInt(2, v02053.getPageIndex());
			call.setInt(3, v02053.getPageSize());
			call.setString(4, v02053.getCd00001Root());
			call.setString(5, v02053.getCd00001Infoid());
			call.setString(6, v02053.getCd00001Szqy());
			call.setString(7, v02053.getCd00001Ssgx());
			call.setString(8, v02053.getCd00001Fwlx());
			call.execute();

			rs = (ResultSet) call.getObject(1);
			if (rs != null) {
				Label label;

				workbook = Workbook.createWorkbook(strBufResult);
				WritableSheet sheet = workbook.createSheet("非住宅综合修正", 0);
				WritableCellFormat wcf = Excel.getExcelTitleStyle();

				label = new Label(0, 0, "所在区域", wcf);
				sheet.addCell(label);
				label = new Label(1, 0, "房屋类型", wcf);
				sheet.addCell(label);
				label = new Label(2, 0, "类型名称", wcf);
				sheet.addCell(label);
				label = new Label(3, 0, "选项名称", wcf);
				sheet.addCell(label);
				label = new Label(4, 0, "修正值(%)", wcf);
				sheet.addCell(label);
				label = new Label(5, 0, "是否默认", wcf);
				sheet.addCell(label);
				label = new Label(6, 0, "更新时间", wcf);
				sheet.addCell(label);
				label = new Label(7, 0, "操作人", wcf);
				sheet.addCell(label);
				label = new Label(8, 0, "备注", wcf);
				sheet.addCell(label);

				while (rs != null && rs.next()) {
					Integer rowIndex = rs.getRow();

					label = new Label(0, rowIndex, rs.getString(SZQY));
					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString(FWLX));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(ROOTNM));
					sheet.addCell(label);
					label = new Label(3, rowIndex, rs.getString(INFONM));
					sheet.addCell(label);
					label = new Label(4, rowIndex, rs.getString(XZXS));
					sheet.addCell(label);
					label = new Label(5, rowIndex, rs.getString(SFMR).equals("1")?"是":"否");
					sheet.addCell(label);
					label = new Label(6, rowIndex, FormatUtil.toYMDHMS(rs.getTimestamp(UPDDATE)));
					sheet.addCell(label);
					label = new Label(7, rowIndex, rs.getString(CZR));
					sheet.addCell(label);
					label = new Label(8, rowIndex, rs.getString(NOTE));
					sheet.addCell(label);

				}

				workbook.write();
				// workbook.close();
			}
			// 填写导出日志
			//WriteLogExp(v02053.getCd00001Ssgx(), "PGT02053",v02053.getCd00002Czr(), "非住宅综合修正导出成功");
		} catch (Exception e) {			
			throw e;
		} finally {
			getFree(rs, call, conn, null);
			if (workbook != null) {
				workbook.close();
			}
			if (strBufResult != null) {
				strBufResult.flush();
				strBufResult.close();
			}
			
		}
		return strBufResult;
	}

	
	@Override
	public OutputStream ExportT053A(Pgv02053 v02053) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		WritableWorkbook workbook = null;
		Connection conn = null;
		
		CallableStatement call = null;
		ResultSet rs = null;
		try {
			strBufResult = new ByteArrayOutputStream();
			
			conn = super.getConnection();
			call = conn
					.prepareCall("{call PGSP_GETALLT02053A(?,?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 注册输入参数
			call.setInt(2, v02053.getPageIndex());
			call.setInt(3, v02053.getPageSize());
			call.setString(4, v02053.getCd00001Root());
			call.setString(5, v02053.getCd00001Infoid());
			call.setString(6, v02053.getCd00001Szqy());
			call.setString(7, v02053.getCd00001Ssgx());
			call.setString(8, v02053.getCd00001Fwlx());
			call.setString(9, v02053.getCd02050Xqdm());
			call.execute();

			rs = (ResultSet) call.getObject(1);
			if (rs != null) {
				Label label;

				workbook = Workbook.createWorkbook(strBufResult);
				WritableSheet sheet = workbook.createSheet("非住宅综合修正", 0);
				WritableCellFormat wcf = Excel.getExcelTitleStyle();

				label = new Label(0, 0, "所在区域", wcf);
				sheet.addCell(label);
				label = new Label(1, 0, "小区名称", wcf);
				sheet.addCell(label);
				label = new Label(2, 0, "房屋类型", wcf);
				sheet.addCell(label);
				label = new Label(3, 0, "类型名称", wcf);
				sheet.addCell(label);
				label = new Label(4, 0, "修正值(%)", wcf);
				sheet.addCell(label);
				label = new Label(5, 0, "更新时间", wcf);
				sheet.addCell(label);
				label = new Label(6, 0, "操作人", wcf);
				sheet.addCell(label);
				label = new Label(7, 0, "备注", wcf);
				sheet.addCell(label);

				while (rs != null && rs.next()) {
					Integer rowIndex = rs.getRow();

					label = new Label(0, rowIndex, rs.getString(SZQY));
					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString(XQNM));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(FWLX));
					sheet.addCell(label);
					label = new Label(3, rowIndex, rs.getString(INFONM));
					sheet.addCell(label);
					label = new Label(4, rowIndex, rs.getString(XZXS));
					sheet.addCell(label);
					label = new Label(5, rowIndex, FormatUtil.toYMDHMS(rs.getTimestamp(UPDDATE)));
					sheet.addCell(label);
					label = new Label(6, rowIndex, rs.getString(CZR));
					sheet.addCell(label);
					label = new Label(7, rowIndex, rs.getString(NOTE));
					sheet.addCell(label);

				}

				workbook.write();
				// workbook.close();
			}
			// 填写导出日志
			//WriteLogExp(v02053.getCd00001Ssgx(), "PGT02053",v02053.getCd00002Czr(), "非住宅综合修正导出成功");
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
			if (workbook != null) {
				workbook.close();
			}
			if (strBufResult != null) {
				strBufResult.flush();
				strBufResult.close();
			}
		}
		return strBufResult;
	}

	
	@Override
	public Pgv02053 ImportExcelData(ArrayList<Pgv02053> zhxzList)
			throws Exception {
		Pgv02053 v02053 = new Pgv02053();
		ArrayList<Pgv02053> tempList = new ArrayList<Pgv02053>();
		Integer resultValue = 0;
		Integer sResultCount = 0;
		Integer fResultCount = 0;
		ResultSet rs = null;
		Session session = null;
		Connection conn = null;
		CallableStatement call = null;
		Transaction tran = null;
		try {
			session = getSession();
			conn = super.getConnection();
			
			call = conn.prepareCall("{call PGSP_ADDT020531(?,?,?,?,?,?,?,?,?)}");
			
			for (int i = 0; i < zhxzList.size(); i++) {
				Pgv02053 zhxz = zhxzList.get(i);
				try {
					tran = session.beginTransaction();
				
					call.registerOutParameter(1, OracleTypes.CURSOR);
					call.setString(2, zhxz.getRootNm());
					call.setString(3, zhxz.getInfoNm());
					call.setDouble(4, zhxz.getXzxs());
					call.setString(5, zhxz.getFwlx());
					call.setString(6, zhxz.getCd00002czr());
					call.setString(7, zhxz.getSsgx());
					call.setString(8, zhxz.getSzqy());
					call.setInt(9, zhxz.getSfmr());
					call.execute();
					rs = (ResultSet) call.getObject(1);
					if (null != rs && rs.next()) {
						if (rs.getInt("flag") == 0) {
							sResultCount++;
							// 标记哪一列字段错误
							zhxz.setCd00001Szqy(rs.getString("SZQYID"));
							zhxz.setCd00001Fwlx(rs.getString("TFWLX"));
							zhxz.setCd00001Infoid(rs.getString("INFOID"));
							zhxz.setImpErrorMsg("");

							tempList.add(zhxz);
							v02053.setOutList(tempList);
						}
					}
					tran.commit();
				} catch (Exception e) {
					tran.rollback();
					sResultCount++;
					e.printStackTrace();
					zhxz.setImpErrorMsg(e.getMessage());
					tempList.add(zhxz);
					v02053.setOutList(tempList);
					continue;
				} finally {
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
			

		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			getFree(rs, call, conn, session);
			if (sResultCount == 0) {
				resultValue = 2;
				//WriteLogImp(zhxzList.get(0).getSsgx(), "PGT02053", zhxzList.get(0).getCd00002czr(), "非住宅综合修正导入成功");
			} else if (sResultCount > 0 && fResultCount == 0) {
				resultValue = 1;
				//WriteLogImp(zhxzList.get(0).getSsgx(), "PGT02053", zhxzList.get(0).getCd00002czr(), "非住宅综合修正导入有异常");
			}
			v02053.setOutFlag(resultValue);
		}
		return v02053;
	}

	
	@Override
	public Pgv02053 ImportExcelDataA(ArrayList<Pgv02053> zhxzList)
			throws Exception {
		Pgv02053 v02053 = new Pgv02053();
		ArrayList<Pgv02053> tempList = new ArrayList<Pgv02053>();
		Integer resultValue = 0;
		Integer sResultCount = 0;
		Integer fResultCount = 0;
		ResultSet rs = null;
		Session session = null;
		Connection conn = null;
		CallableStatement call = null;
		Transaction tran = null;
		try {
			session = getSession();
			conn = super.getConnection();
			
			call = conn
					.prepareCall("{call PGSP_ADDT02053A1(?,?,?,?,?,?,?,?,?,?)}");
			
			for (int i = 0; i < zhxzList.size(); i++) {
				Pgv02053 zhxz = zhxzList.get(i);
				try {
					tran = session.beginTransaction();
				
					call.registerOutParameter(1, OracleTypes.CURSOR);
					call.setString(2, zhxz.getRootNm());
					call.setString(3, zhxz.getInfoNm());
					call.setDouble(4, zhxz.getXzxs());
					call.setString(5, zhxz.getFwlx());
					call.setString(6, zhxz.getCd00002czr());
					call.setString(7, zhxz.getSsgx());
					call.setString(8, zhxz.getSzqy());
					call.setString(9, zhxz.getXqnm());
					call.setString(10, zhxz.getDmh());
					call.execute();
					rs = (ResultSet) call.getObject(1);
					if (null != rs && rs.next()) {
						if (rs.getInt("flag") == 0) {
							sResultCount++;
							// 标记哪一列字段错误
							zhxz.setCd00001Szqy(rs.getString("SZQYID"));
							zhxz.setCd00001Fwlx(rs.getString("TFWLX"));
							zhxz.setCd00001Infoid(rs.getString("INFOID"));
							zhxz.setCd02050Xqdm(rs.getString("XQDM"));
							zhxz.setDmhid(rs.getString("TDMH"));
							zhxz.setImpErrorMsg("");

							tempList.add(zhxz);
							v02053.setOutList(tempList);
						}
					}
					tran.commit();
				} catch (Exception e) {
					tran.rollback();
					sResultCount++;
					e.printStackTrace();
					zhxz.setImpErrorMsg(e.getMessage());
					tempList.add(zhxz);
					v02053.setOutList(tempList);
					continue;
				} finally {
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
			

		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			getFree(rs, call, conn, session);
			if (sResultCount == 0) {
				resultValue = 2;
				//WriteLogImp(zhxzList.get(0).getSsgx(), "PGT02053", zhxzList.get(0).getCd00002czr(), "非住宅综合修正导入成功");
			} else if (sResultCount > 0 && fResultCount == 0) {
				resultValue = 1;
				//WriteLogImp(zhxzList.get(0).getSsgx(), "PGT02053", zhxzList.get(0).getCd00002czr(), "非住宅综合修正导入有异常");
			}
			v02053.setOutFlag(resultValue);
		}
		return v02053;
	}

	
	@Override
	public boolean GetSelDeleteCommand(Pgt02053 wjzs) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT020531(?,?,?)}");
			call.setString(1, wjzs.getChkDel());
			call.setString(2, wjzs.getCd00002Czr());
			call.setString(3, wjzs.getCd00001Ssgx());
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
	public boolean GetSelDeleteCommandA(Pgt02053 wjzs) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02053A1(?,?,?)}");
			call.setString(1, wjzs.getChkDel());
			call.setString(2, wjzs.getCd00002Czr());
			call.setString(3, wjzs.getCd00001Ssgx());
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
	public String LoadParentIdsBySzqy(String szqy, String fwlx, String xqdm) throws Exception {
		String listResult = "";
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{?=call FN_GET02053PARENTIDS(?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			// 注册输入参数
			call.setString(2, szqy);
			call.setString(3, fwlx);
			call.setString(4, xqdm);
			call.execute();
			listResult = call.getString(1);
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return listResult;
	}
}
