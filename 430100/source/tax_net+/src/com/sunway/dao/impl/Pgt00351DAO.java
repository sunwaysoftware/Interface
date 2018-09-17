package com.sunway.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00351DAO;
import com.sunway.util.CheckUtil;
import com.sunway.util.ConvertUtil;
import com.sunway.util.Excel;
import com.sunway.util.FormatUtil;
import com.sunway.vo.ExcelBean;
import com.sunway.vo.Pgt00351;
import com.sunway.vo.Pgt00352;
import com.sunway.vo.Pgv00351;

/**
 *
 * 市场法标准实例库
 * @category 系统维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00351DAO extends BaseDAO implements IPgt00351DAO {

	private static final String total = "TOTAL";
	private static final String slid = "SLID";
	private static final String cd00303Lfid = "CD_00303_LFID";
	private static final String cd00001Fwlx = "CD_00001_FWLX";
//	private static final String cd00001Jylx = "CD_00001_JYLX";
	private static final String cd00001Jzjg = "CD_00001_JZJG";
//	private static final String cd00001Fwcx = "CD_00001_FWCX";
//	private static final String cd00001Cgzk = "CD_00001_CGZK";
//	private static final String szlc = "SZLC";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String fwlx = "FWLX";
	private static final String jylx = "JYLX";
//	private static final String fwcx = "FWCX";
//	private static final String cgzk = "CGZK";
	private static final String cd00352Xqdm = "CD_00352_XQDM";
	private static final String ywdt = "YWDT";
	private static final String zlc = "ZLC";
	private static final String xqnm = "XQNM";
	private static final String xqbm = "XQBM";
	private static final String szqy = "SZQY";
	private static final String cd00001Szqy = "CD_00001_SZQY";
	private static final String czr = "CZR";
	private static final String fwlxSc = "FWLX_SC";
//	private static final String jylxSc = "JYLX_SC";
//	private static final String cgzkSc = "CGZK_SC";
//	private static final String cd00001Jtzk = "CD_00001_JTZK";
//	private static final String cd00001Wyzk = "CD_00001_WYZK";
//	private static final String cd00001Zxzk = "CD_00001_ZXZK";
//	private static final String jtzk = "JTZK";
//	private static final String wyzk = "WYZK";
//	private static final String zxzk = "ZXZK";
//	private static final String hxjg = "HXJG";
	private static final String pfmjg = "PFMJG";
	private static final String dypfmjg = "DYPFMJG";
	private static final String zhxz = "ZHXZ";
	private static final String parentnm = "PARENTNM";
	private static final String fwtdzl = "FWTDZL";
	private static final String clh = "CLH";
	private static final String ywjkc="YWJKC";
	private static final String jzjg ="JZJG";
//	private static final String cd00001Fqwz = "CD_00001_FQWZ";
//	private static final String cd00001Dywz = "CD_00001_DYWZ";
//	private static final String dywz = "DYWZ";
//	private static final String fqwz = "FQWZ";
//	private static final String bwjfh = "BWJFH";
//	private static final String qdh = "QDH";
//	private static final String zh = "ZH";
	private static final String slks = "SLKS";
	
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00351DAO#LoadAll(com.sunway.vo.Pgv00351)
	 */
	
	@Override
	public ArrayList<Pgv00351> LoadAll(Pgv00351 v00351) throws Exception {
		ArrayList<Pgv00351> listResult = new ArrayList<Pgv00351>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00351(?,?,?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v00351.getPageIndex());
			call.setInt(3, v00351.getPageSize());
			call.setString(4, v00351.getCd00352Xqdm());
			call.setString(5, v00351.getZcdzl());
			call.setDate(6,  ConvertUtil.utilDateToSqlDate(v00351.getJysj()));
			call.setString(7, v00351.getCd00001Szqy());
			call.setString(8, v00351.getSsgx());
			call.setString(9, v00351.getSlid());
			call.setString(10, v00351.getCd00001Fwlx());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
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
	 * @see com.sunway.dao.IPgt00351DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00351)
	 */
	
	@Override
	public Pgt00351 LoadByPrimaryKey(Pgt00351 t00351) throws Exception {
		ArrayList<Pgt00351> listResult = new ArrayList<Pgt00351>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00351(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t00351.getSlid());
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
			return new Pgt00351();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00351DAO#GetInsertCommand(com.sunway.vo.Pgt00351)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt00351 t00351) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00351(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 传入输入参数
			call.setString(1, t00351.getCd00303Lfid());
			call.setString(2, t00351.getCd00001Fwlx());
			call.setString(3, t00351.getCd00001Jzjg());
			call.setDouble(4, t00351.getPfmjg());
			call.setString(5, t00351.getCd00002Czr());
			call.setString(6, t00351.getNote());
			call.setString(7, t00351.getJcnf());
			call.setDate(8, ConvertUtil.utilDateToSqlDate(t00351.getJysj()));
			call.setString(9, t00351.getCd00352Xqdm());
			call.setString(10, t00351.getCd00001Jzjg1());
			call.setInt(11, t00351.getYwdt());
			call.setShort(12, t00351.getZlc());
			call.setString(13, t00351.getNote1());
			call.setString(14, t00351.getZcdzl());
			call.setString(15, t00351.getZcdzbm());
			call.setString(16, t00351.getCd00053Qtxzid());
			call.setString(17, t00351.getSsgx());
			call.setString(18, t00351.getZhxz());
			call.setString(19, t00351.getClh());
			call.setBoolean(20, CheckUtil.chkNull(t00351.getYwjkc()));
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
	 * @see com.sunway.dao.IPgt00351DAO#GetUpdateCommand(com.sunway.vo.Pgt00351)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt00351 t00351) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00351(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 传入输入参数
			call.setString(1, t00351.getSlid());
			call.setString(2, t00351.getCd00303Lfid());
			call.setString(3, t00351.getCd00001Fwlx());
			call.setString(4, t00351.getCd00001Jzjg());
			call.setString(5, t00351.getCd00002Czr());
			call.setString(6, t00351.getNote());
			call.setString(7, t00351.getJcnf());
			call.setString(8, t00351.getCd00352Xqdm());
			call.setString(9, t00351.getCd00001Jzjg1());
			call.setInt(10, t00351.getYwdt());
			call.setShort(11, t00351.getZlc());
			call.setString(12, t00351.getNote1());
			call.setString(13, t00351.getZcdzl());
			call.setString(14, t00351.getZcdzbm());
			call.setString(15, t00351.getCd00053Qtxzid());
			call.setString(16, t00351.getSsgx());
			call.setString(17, t00351.getZhxz());
			call.setString(18, t00351.getClh());
			call.setBoolean(19, CheckUtil.chkNull(t00351.getYwjkc()));
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
	 * @see com.sunway.dao.IPgt00352DAO#ExportGJFQSjcx(com.sunway.vo.Pgv00352)
	 */
	
	
	@Override
	public OutputStream ExportbzfwhSjcx(Pgv00351 v00351) throws Exception {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003511(?,?,?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v00351.getPageIndex());
			call.setInt(3, v00351.getPageSize());
			call.setString(4, v00351.getCd00352Xqdm());
			call.setString(5, v00351.getZcdzl());
			call.setDate(6,  ConvertUtil.utilDateToSqlDate(v00351.getJysj()));
			call.setString(7, v00351.getCd00001Szqy());
			call.setString(8, v00351.getSsgx());
			call.setString(9, v00351.getSlid());
			call.setString(10, v00351.getCd00001Fwlx());
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
	          
//	            label = new Label(0, 0, "编码");
//				sheet.addCell(label);	
//				label = new Label(1, 0, "所在区域");
//				sheet.addCell(label);	
//				label = new Label(2, 0, "小区名称");
//				sheet.addCell(label);	
//			    label=new Label(3,0,"楼房地址");
//			    sheet.addCell(label);
//			    label=new Label(4,0,"建筑结构");
//			    sheet.addCell(label);
//			    label=new Label(5,0,"房屋类型");
//			    sheet.addCell(label);
//			    label=new Label(6,0,"所在楼层");
//			    sheet.addCell(label);
//			    label=new Label(7,0,"交易类型");
//			    sheet.addCell(label);
//			    label=new Label(8,0,"更新时间");
//			    sheet.addCell(label);
//			    label=new Label(9,0,"操作人");
//			    sheet.addCell(label);
//			    label=new Label(10,0,"备注");
//			    sheet.addCell(label);
			    
			    
			    label = new Label(0, 0, "所在区域");
				sheet.addCell(label);		
				label = new Label(1, 0, "小区代码号");
				sheet.addCell(label);	
				label = new Label(2, 0, "小区名称");
				sheet.addCell(label);	
				label=new Label(3,0,"房屋类型");
				sheet.addCell(label);
				label=new Label(4,0,"建筑结构");
				sheet.addCell(label);
			    label=new Label(5,0,"建成年份");
			    sheet.addCell(label);
			    label=new Label(6,0,"交易时间");
			    sheet.addCell(label);
			    label=new Label(7,0,"基准价值（元/平方米）");
			    sheet.addCell(label);
			    label=new Label(8,0,"备注");
			    sheet.addCell(label);
			
				   // 写入数据
				while(null!=rs && rs.next()){
					Integer rowIndex = rs.getRow();
//					label = new Label(0, rowIndex, rs.getString(slid));
//					sheet.addCell(label);	
//					label = new Label(1, rowIndex, rs.getString(szqy));
//					sheet.addCell(label);		
//					label = new Label(2, rowIndex, rs.getString(xqnm));
//					sheet.addCell(label);	
//					label = new Label(3, rowIndex, rs.getString(fwtdzl));
//					sheet.addCell(label);	
//					label = new Label(4, rowIndex, rs.getString(jzjg));
//					sheet.addCell(label);
//					label = new Label(5, rowIndex, rs.getString(fwlx));
//					sheet.addCell(label);
//					label = new Label(6, rowIndex, rs.getString(szlc));
//					sheet.addCell(label);
//					label = new Label(7, rowIndex, rs.getString(jylx));
//					sheet.addCell(label);
//					label = new Label(8, rowIndex, rs.getString(upddate));
//					sheet.addCell(label);
//					label = new Label(9, rowIndex, rs.getString(czr));
//					sheet.addCell(label);
//					label = new Label(10, rowIndex, rs.getString(note));
//					sheet.addCell(label);
					
					
					
					label = new Label(0, rowIndex, rs.getString(szqy));
					sheet.addCell(label);		
					label = new Label(1, rowIndex, rs.getString("XQDMHM"));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(xqnm));
					sheet.addCell(label);	
					label = new Label(3, rowIndex, rs.getString(fwlx));
					sheet.addCell(label);
					label = new Label(4, rowIndex, rs.getString(jzjg));
					sheet.addCell(label);
					label = new Label(5, rowIndex, rs.getString("JCSJ"));
					sheet.addCell(label);
					label = new Label(6, rowIndex, FormatUtil.toYYYYMMDD(rs.getDate("JYSJ")));
					sheet.addCell(label);
					label = new Label(7, rowIndex, rs.getString(dypfmjg));
					sheet.addCell(label);
					label = new Label(8, rowIndex, rs.getString(note));
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


	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00351DAO#GetDeleteCommand(com.sunway.vo.Pgt00351)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00351 t00351) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00351(?,?,?)}");
			// 传入输入参数
			call.setString(1, t00351.getSlid());
			call.setString(2, t00351.getCd00002Czr());
			call.setString(3, t00351.getSsgx());
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
	 * @see com.sunway.dao.IPgt00351DAO#GetDeleteCommand(com.sunway.vo.Pgt00351)
	 */
	
	@Override
	public boolean GetDeleteSelCommand(Pgv00351 v00351) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT003511(?,?,?)}");
			// 传入输入参数
			call.setString(1, v00351.getChkSel());
			call.setString(2, v00351.getCd00002Czr());
			call.setString(3, v00351.getSsgx());
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
	 * @see com.sunway.dao.IPgt00351DAO#LoadDetail(com.sunway.vo.Pgv00351)
	 */
	
	@Override
	public Pgv00351 LoadDetail(Pgv00351 v00351) throws Exception {
		ArrayList<Pgv00351> listResult = new ArrayList<Pgv00351>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003510(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v00351.getSlid());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetDParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		if (listResult != null && listResult.size() > 0) {
			return listResult.get(0);
		} else {
			return new Pgv00351();
		}
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00351 SetVParameters(ResultSet rs) throws Exception {
		Pgv00351 e = new Pgv00351();
		e.setRecordCount(rs.getInt(total));
		e.setSlid(rs.getString(slid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setFwlx(rs.getString(fwlx));
		e.setJzjg(rs.getString(jzjg));
		e.setCd00352Xqdm(rs.getString(cd00352Xqdm));
		e.setYwdt(rs.getInt(ywdt));
		e.setZlc(rs.getShort(zlc));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCzr(rs.getString(czr));
		e.setDypfmjg(rs.getDouble(dypfmjg));
		e.setFwtdzl(rs.getString(fwtdzl));
		e.setClh(rs.getString(clh));
		e.setYwjkc(rs.getBoolean(ywjkc));
		e.setJcsj(rs.getString("JCSJ"));
		e.setJysj(rs.getDate("JYSJ"));
		return e;
	}

	/**
	 * Edit数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00351 SetTParameters(ResultSet rs) throws Exception {
		Pgt00351 e = new Pgt00351();
		e.setSlid(rs.getString(slid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setFwlxsc(rs.getString(fwlxSc));
		e.setJzjg(rs.getString(jzjg));
		e.setJcnf(rs.getString("JCSJ"));
		
		return e;
	}

	/**
	 * Detail数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00351 SetDParameters(ResultSet rs) throws Exception {
		Pgv00351 e = new Pgv00351();
		e.setSlid(rs.getString(slid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setFwlx(rs.getString(fwlx));
		e.setJzjg(rs.getString(jzjg));
		e.setCd00352Xqdm(rs.getString(cd00352Xqdm));
		e.setYwdt(rs.getInt(ywdt));
		e.setZlc(rs.getShort(zlc));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCzr(rs.getString(czr));
		e.setZhxz(rs.getString(zhxz));
		e.setClh(rs.getString(clh));
		e.setYwjkc(rs.getBoolean(ywjkc));
		e.setFwtdzl(rs.getString(fwtdzl));
		e.setJcsj(rs.getString("JCSJ"));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00351DAO#ExecCsSame(com.sunway.vo.Pgv00351)
	 */
	
	@Override
	public Boolean ExecCsSame(Pgv00351 v00351) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00351_UPD(?,?,?,?,?,?)}");
			// 输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			// 输入参数
			call.setString(2, v00351.getSlid());
			call.setDate(3, ConvertUtil.utilDateToSqlDate(v00351.getJysj()));
			call.setString(4, v00351.getCd00002Czr());
			call.setDouble(5, v00351.getGpqz());
			call.setDouble(6, v00351.getGpxf());
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
	 * @see com.sunway.dao.IPgt00351DAO#LoadAllCsSame(com.sunway.vo.Pgv00351)
	 */
	
	@Override
	public ArrayList<Pgv00351> LoadAllCsSame(Pgv00351 v00351) throws Exception {
		ArrayList<Pgv00351> listResult = new ArrayList<Pgv00351>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00351_CS(?,?,?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v00351.getPageIndex());
			call.setInt(3, v00351.getPageSize());
			call.setString(4, v00351.getCd00001Szqy());
			call.setString(5, v00351.getCd00352Xqdm());
			call.setString(6, v00351.getCd00001Fwlx());
			call.setString(7, v00351.getCd00001Jzjg());
			call.setString(8, v00351.getCd00001Jylx());
			call.setString(9, v00351.getYwdt().toString());
			call.setDate(10, ConvertUtil.utilDateToSqlDate(v00351.getJysj()));
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgv00351 e = new Pgv00351();
				e.setRecordCount(rs.getInt(total));
				e.setSlid(rs.getString(slid));
				e.setXqnm(rs.getString(xqnm));
				e.setFwlx(rs.getString(fwlx));
				e.setJylx(rs.getString(jylx));
				e.setJzjg(rs.getString(jzjg));
				e.setYwdt(rs.getInt(ywdt));	
				e.setSlCount(rs.getInt("SLCNT"));
				e.setGpCount(rs.getInt("GPCNT"));
				e.setFwtdzl(rs.getString(fwtdzl));
				listResult.add(e);
				e = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00351DAO#LoadAllCsSameByBzfID(com.sunway.vo.Pgv00351)
	 */
	
	@Override
	public ArrayList<Pgv00351> LoadAllCsSameByBzfID(Pgv00351 v00351) throws Exception {
		ArrayList<Pgv00351> listResult = new ArrayList<Pgv00351>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00351_CS1(?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v00351.getCd00001Szqy());
			call.setString(3, v00351.getCd00352Xqdm());
			call.setString(4, v00351.getCd00001Fwlx());
			call.setString(5, v00351.getCd00001Jzjg());
			call.setString(6, v00351.getCd00001Jylx());
			call.setInt(7, v00351.getYwdt());
			call.setDate(8, ConvertUtil.utilDateToSqlDate(v00351.getJysj()));
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgv00351 e = new Pgv00351();
				e.setSlid(rs.getString(slid));
				listResult.add(e);
				e = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00351DAO#LoadAllCsDiff(com.sunway.vo.Pgv00351)
	 */
	
	@Override
	public ArrayList<Pgv00351> LoadAllCsDiffW(Pgv00351 v00351) throws Exception {
		ArrayList<Pgv00351> listResult = new ArrayList<Pgv00351>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00351_CS2(?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v00351.getPageIndex());
			call.setInt(3, v00351.getPageSize());
			call.setString(4, v00351.getCd00352Xqdm());
			call.setDate(5, ConvertUtil.utilDateToSqlDate(v00351.getJysj()));
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgv00351 e = new Pgv00351();
				e.setRecordCount(rs.getInt(total));
				e.setSlid(rs.getString(slid));
				e.setXqnm(rs.getString(xqnm));
				e.setFwlx(rs.getString(fwlx));
				e.setJylx(rs.getString(jylx));
				e.setJzjg(rs.getString(jzjg));
				e.setYwdt(rs.getInt(ywdt));	
				e.setFwtdzl(rs.getString(fwtdzl));
				listResult.add(e);
				e = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00351DAO#LoadAllCsDiffY(com.sunway.vo.Pgv00351)
	 */
	
	@Override
	public ArrayList<Pgv00351> LoadAllCsDiffY(Pgv00351 v00351) throws Exception {
		ArrayList<Pgv00351> listResult = new ArrayList<Pgv00351>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00351_CS3(?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v00351.getPageIndex());
			call.setInt(3, v00351.getPageSize());
			call.setString(4, v00351.getCd00352Xqdm());
			call.setDate(5, ConvertUtil.utilDateToSqlDate(v00351.getJysj()));
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgv00351 e = new Pgv00351();
				e.setRecordCount(rs.getInt(total));
				e.setSlid(rs.getString(slid));
				e.setXqnm(rs.getString(xqnm));
				e.setFwlx(rs.getString(fwlx));
				e.setJylx(rs.getString(jylx));
				e.setJzjg(rs.getString(jzjg));
				e.setYwdt(rs.getInt(ywdt));	
				e.setPfmjg(rs.getDouble(pfmjg));
				listResult.add(e);
				e = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00351DAO#CreateBZF(com.sunway.vo.Pgt00351)
	 */
	
	@Override
	public Integer CreateBZF(Pgt00351 t00351) throws Exception {
		Integer bResult = 0;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00351_ADD_F(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			//传入输入参数
			call.setString(2, t00351.getCd00001Szqy());
			call.setString(3, t00351.getCd00352Xqdm());
			call.setString(4, t00351.getCd00001Fwlx());
			call.setString(5, t00351.getSsgx());
			call.setString(6, t00351.getCd00002Czr());
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
	 * @see com.sunway.dao.IPgt00351DAO#LoadXqW()
	 */
	
	@Override
	public ArrayList<Pgt00352> LoadXqW(Pgt00351 bean) throws Exception {
		ArrayList<Pgt00352> listResult = new ArrayList<Pgt00352>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003524(?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd00001Szqy());
			call.setDate(3, ConvertUtil.utilDateToSqlDate(bean.getJysj()));	
			call.setString(4, bean.getCd00352Xqdm());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetNParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00351DAO#LoadXqY()
	 */
	
	@Override
	public ArrayList<Pgt00352> LoadXqY(Pgt00351 bean) throws Exception {
		ArrayList<Pgt00352> listResult = new ArrayList<Pgt00352>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003525(?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd00001Szqy());
			call.setDate(3, ConvertUtil.utilDateToSqlDate(bean.getJysj()));	
			call.setString(4, bean.getCd00352Xqdm());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetNParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/**
	 * Tree数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00352 SetNParameters(ResultSet rs) throws Exception {
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
		
		Pgt00352 e = new Pgt00352();
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
	 * @see com.sunway.dao.IPgt00351DAO#ImportExcelData(java.util.ArrayList)
	 */
	
	@Override
	public ExcelBean ImportExcelData(ArrayList<ExcelBean> ebList)  throws Exception{
		ExcelBean excelBean = new ExcelBean();
		Integer resultValue = 0;
		Integer sResultCount = 0;
		ResultSet rs = null;
		Session session = null;
		Connection conn = null;
		CallableStatement call = null;
		Transaction tran = null;
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_ADDT003511(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			for(int i=0; i<ebList.size(); i++){
				ExcelBean bean = ebList.get(i);
				try {
					call.registerOutParameter(1, OracleTypes.CURSOR);
					call.setString(2, bean.getLfid());
					call.setString(3, bean.getFwlxNm());
					call.setString(4, bean.getJzjgNm());
					call.setDouble(5, bean.getPfmjg());
					call.setString(6, bean.getCd00002Czr());
					call.setString(7, bean.getNote());
					call.setString(8, bean.getJcnf());
					call.setDate(9, ConvertUtil.utilDateToSqlDate(bean.getJysj()));
					call.setString(10, bean.getXqNm());
					call.setString(11, bean.getCd00001Jzjg1());
					call.setInt(12, 0);
					call.setShort(13, (short) 0); //总楼层
					call.setString(14, bean.getNote1());
					call.setString(15, bean.getZcdzl());
					call.setString(16, bean.getZcdzbm());
					call.setString(17, bean.getCd00053Qtxzid());
					call.setString(18, bean.getSzqyNm());
					call.setString(19, bean.getSsgx());
					call.setString(20, bean.getZhxz());
					call.setString(21, bean.getClh());
					call.setInt(22, CheckUtil.chkNull(bean.getYwjkc()));
					call.setString(23, bean.getXqdmh());
					call.execute();
					/*
					if (call.getInt(1) == 0) {
						sResultCount++;
						v00351.getOutList().add(kbslk);
					}
					*/
					rs = (ResultSet) call.getObject(1); 
					if (null!=rs && rs.next()) {
						if (rs.getInt("flag") == 0) {
							sResultCount++;
							//标记哪一列字段错误
							bean.setXqId(rs.getString("TXQDM"));
							bean.setFwlxId(rs.getString("TFWLX"));
							//bean.setJylxId(rs.getString("TJYLX"));
							bean.setJzjgId(rs.getString("TJZJG"));
							bean.setSzqyId(rs.getString("SZQYID"));
							bean.setQtxzIds(rs.getString("QTXZIDS"));
							bean.setZhxzIds(rs.getString("ZHXZS"));
							bean.setCwxx("");
							//将数据封装到list
							excelBean.getOutExcelList().add(bean);
						}
						rs.close();
					}
				} catch (Exception e) {
					sResultCount++;
					bean.setCwxx(e.getMessage());
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

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00351DAO#ImportBZF(com.sunway.vo.Pgt00351)
	 */
	
	@Override
	public Integer ImportBZF(Pgt00351 t00351) throws Exception {
		Integer bResult = 0;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00351_ADD_T(?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			//传入输入参数
			call.setString(2, t00351.getCd00001Szqy());
			call.setString(3, t00351.getCd00352Xqdm());
			call.setString(4, t00351.getSsgx());
			call.setString(5, t00351.getCd00002Czr());
			call.execute();
			bResult = call.getInt(1);
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}
	
	
	
	/**
	 * 查询可测算标准房
	 * @return 数据列表
	 * @throws Exception
	 */
	
	@Override
	public ArrayList<Pgv00351> findY(Pgv00351 v00351) throws Exception {
		ArrayList<Pgv00351> listResult = new ArrayList<Pgv00351>();
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		ResultSet rs = null;
		
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003513(?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v00351.getPageIndex());
			call.setInt(3, v00351.getPageSize());
			call.setString(4, v00351.getCd00352Xqdm());
			call.setString(5, v00351.getCd00001Szqy());
			call.setString(6, v00351.getSsgx());
			call.setString(7, v00351.getCd00001Fwlx());
			call.setInt(8, v00351.getMonthSet());
			call.setInt(9, v00351.getIsYwjg());
			call.setString(10, v00351.getXqnm());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				listResult.add(SetYParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	/**
	 * 查询不可测算标准房
	 * @return 数据列表
	 * @throws Exception
	 */
	
	@Override
	public ArrayList<Pgv00351> findN(Pgv00351 v00351) throws Exception {
		ArrayList<Pgv00351> listResult = new ArrayList<Pgv00351>();
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		ResultSet rs = null;
		
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003512(?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v00351.getPageIndex());
			call.setInt(3, v00351.getPageSize());
			call.setString(4, v00351.getCd00352Xqdm());
			call.setString(5, v00351.getCd00001Szqy());
			call.setString(6, v00351.getSsgx());
			call.setString(7, v00351.getCd00001Fwlx());
			call.setInt(8, v00351.getMonthSet());
			call.setInt(9, v00351.getBzfjg());
			call.setString(10, v00351.getZcdzl());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				listResult.add(SetFParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	
	
	@Override
	public OutputStream ExportCSY(Pgv00351 v00351) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		WritableWorkbook workbook = null;
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try{
			strBufResult = new ByteArrayOutputStream();
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003513(?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v00351.getPageIndex());
			call.setInt(3, v00351.getPageSize());
			call.setString(4, v00351.getCd00352Xqdm());
			call.setString(5, v00351.getCd00001Szqy());
			call.setString(6, v00351.getSsgx());
			call.setString(7, v00351.getCd00001Fwlx());
			call.setInt(8, v00351.getMonthSet());
			call.setInt(9, v00351.getIsYwjg());
			call.setString(10, v00351.getXqnm());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			
			if(rs != null){
				Label label;
				
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
				label = new Label(5, 0, "当前基准价格(元)",wcf);
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
//					label = new Label(4, rowIndex, rs.getString(fwtdzl));
//					sheet.addCell(label);
					label = new Label(4, rowIndex, rs.getString(fwlx));
					sheet.addCell(label);
					String pfm = String.valueOf(((null == rs.getString(dypfmjg) || "".equals(rs.getString(dypfmjg)))?0:rs.getString(dypfmjg)));
					label = new Label(5, rowIndex, pfm);
					sheet.addCell(label);
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
			//填写导出日志
			//WriteLogExp(v00351.getSsgx(), "PGT00351", v00351.getCd00002Czr(), "可测算标准房导出成功");
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
			getFree(rs, call, conn, session);
		}
		return strBufResult;
	}
	
	
	@Override
	public OutputStream ExportCSN(Pgv00351 v00351) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		WritableWorkbook workbook = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			strBufResult = new ByteArrayOutputStream();
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003512(?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v00351.getPageIndex());
			call.setInt(3, v00351.getPageSize());
			call.setString(4, v00351.getCd00352Xqdm());
			call.setString(5, v00351.getCd00001Szqy());
			call.setString(6, v00351.getSsgx());
			call.setString(7, v00351.getCd00001Fwlx());
			call.setInt(8, v00351.getMonthSet());
			call.setInt(9, v00351.getBzfjg());
			call.setString(10, v00351.getZcdzl());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			
			if(rs != null){
				Label label;
			
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
				label = new Label(5, 0, "当前基准价格(元)",wcf);
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
					String pfm = String.valueOf(((null == rs.getString(dypfmjg) || "".equals(rs.getString(dypfmjg)))?0:rs.getString(dypfmjg)));
					label = new Label(5, rowIndex, pfm);
					sheet.addCell(label);
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
			//填写导出日志
			//WriteLogExp(v00351.getSsgx(), "PGT00351", v00351.getCd00002Czr(), "不可测算标准房导出成功");
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
			getFree(rs, call, conn, session);
		}
		return strBufResult;
	}
	
	
	
	
	@Override
	public Boolean GetExecCS(Pgv00351 v00351) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Transaction tran = null;
		Session session = null;
		
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_003311(?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.INTEGER);
			call.setString(2, v00351.getSlid());
			call.setDate(3, ConvertUtil.utilDateToSqlDate(v00351.getJysj()));
			call.setString(4, v00351.getCd00002Czr());
			call.setInt(5, v00351.getMonthSet());
			call.setString(6, v00351.getGpal());
			call.setString(7, v00351.getYsf());
			call.setString(8, v00351.getZj());
			call.setString(9, v00351.getCjal());
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
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00351 SetYParameters(ResultSet rs) throws Exception {
		Pgv00351 e = new Pgv00351();
		e.setRecordCount(rs.getInt(total));
		e.setSlid(rs.getString(slid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
//		e.setCd00001Jylx(rs.getString(cd00001Jylx));
//		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
//		e.setSzlc(rs.getShort(szlc));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		//e.setNote(rs.getString(note));
		e.setFwlx(rs.getString(fwlx));
//		e.setJylx(rs.getString(jylx));
		e.setJzjg(rs.getString(jzjg));
		e.setCd00352Xqdm(rs.getString(cd00352Xqdm));
   		e.setYwdt1(rs.getString(ywdt));
		e.setZlc(rs.getShort(zlc));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCzr(rs.getString(czr));
		e.setDypfmjg(rs.getDouble(dypfmjg));
		e.setFwtdzl(rs.getString("xqaddr"));
		if("".equals(rs.getString(parentnm)) || null == rs.getString(parentnm)){
			e.setParentnm(rs.getString(xqnm));
			e.setXqnm("");
		}else{
			e.setParentnm(rs.getString(parentnm));
			e.setXqnm(rs.getString(xqnm));
		}
//		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
//		e.setCd00001Fqwz(rs.getString(cd00001Fqwz));
//		e.setCd00001Dywz(rs.getString(cd00001Dywz));
//		e.setFwcx(rs.getString(fwcx));
//		e.setFqwz(rs.getString(fqwz));
//		e.setDywz(rs.getString(dywz));
//		e.setZh(rs.getString(zh));
//		e.setBwjfh(rs.getString(bwjfh));
//		e.setQdh(rs.getString(qdh));
		e.setJcsj(rs.getString("jcsj"));
		e.setSlks(rs.getInt(slks));
		return e;
	}
	
	
	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00351 SetFParameters(ResultSet rs) throws Exception {
		Pgv00351 e = new Pgv00351();
		e.setRecordCount(rs.getInt(total));
		e.setSlid(rs.getString(slid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setFwlx(rs.getString(fwlx));
		e.setJzjg(rs.getString(jzjg));
		e.setCd00352Xqdm(rs.getString(cd00352Xqdm));
		e.setYwdt1(rs.getString(ywdt));
		e.setZlc(rs.getShort(zlc));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCzr(rs.getString(czr));
		e.setDypfmjg(rs.getDouble(dypfmjg));
		e.setFwtdzl(rs.getString("xqaddr"));
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
}
