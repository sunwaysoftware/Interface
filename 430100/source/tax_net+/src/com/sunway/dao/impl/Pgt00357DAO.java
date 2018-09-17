package com.sunway.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00357DAO;
import com.sunway.util.CheckUtil;
import com.sunway.util.ConvertUtil;
import com.sunway.vo.Pgt00357;
import com.sunway.vo.Pgv00357;

/**
 *
 * 市场法实例库
 * @category 系统维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00357DAO extends BaseDAO implements IPgt00357DAO {

	private static final String total = "TOTAL";
	private static final String slid = "SLID";
	private static final String cd00301Swid = "CD_00301_SWID";
	private static final String cd00303Lfid = "CD_00303_LFID";
	private static final String cd00001Fwlx = "CD_00001_FWLX";
	private static final String cd00001Jylx = "CD_00001_JYLX";
	private static final String cd00001Jzjg = "CD_00001_JZJG";
	private static final String jzmj = "JZMJ";
//	private static final String cd00001Fwcx = "CD_00001_FWCX";
//	private static final String cd00001Cgzk = "CD_00001_CGZK";
	private static final String szlc = "SZLC";
	private static final String bwjfh = "BWJFH";
	private static final String pgjg = "PGJG";
	private static final String jysj = "JYSJ";
	private static final String fdcdat = "FDCDAT";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String nsrmc = "NSRMC";
	private static final String cd00352Xqdm = "CD_00352_XQDM";
	private static final String cd00001Szqy = "CD_00001_SZQY";
	private static final String ywdt = "YWDT";
	private static final String zlc = "ZLC";
	private static final String xqnm = "XQNM";
	private static final String xqbm = "XQBM";
	private static final String szqy = "SZQY";
	private static final String fwlx = "FWLX";
	private static final String jylx = "JYLX";
	private static final String jzjg = "JZJG";
//	private static final String fwcx = "FWCX";
//	private static final String cgzk = "CGZK";
	private static final String czr = "CZR";
	private static final String fwlxSc = "FWLX_SC";
	private static final String jylxSc = "JYLX_SC";
//	private static final String cgzkSc = "CGZK_SC";
//	private static final String cd00001Jtzk = "CD_00001_JTZK";
//	private static final String cd00001Wyzk = "CD_00001_WYZK";
//	private static final String cd00001Zxzk = "CD_00001_ZXZK";
//	private static final String jtzk = "JTZK";
//	private static final String wyzk = "WYZK";
//	private static final String zxzk = "ZXZK";
	private static final String fczh = "FCZH";
	private static final String qdh = "QDH";
	private static final String cb = "CB";
	private static final String ghyt = "GHYT";
	private static final String hxjg = "HXJG";
	private static final String jcsj = "JCSJ";
	private static final String zhxz = "ZHXZ";
	private static final String zcdzl = "ZCDZL";
	private static final String clh = "CLH";
	private static final String ywjkc="YWJKC";
	private static final String fwtdzl = "FWTDZL";
	private static final String lh = "LH";
	private static final String dyh = "DYH";
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00357DAO#LoadAll(com.sunway.vo.Pgv00357)
	 */
	
	@Override
	public ArrayList<Pgv00357> LoadAll(Pgv00357 v00357) throws Exception {
		ArrayList<Pgv00357> listResult = new ArrayList<Pgv00357>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00357(?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v00357.getPageIndex());
			call.setInt(3, v00357.getPageSize());
			call.setString(4, v00357.getCd00301Swid());
			call.setString(5, v00357.getNsrmc());
			call.setString(6, v00357.getFdcdat());
			call.setString(7, v00357.getCd00352Xqdm());
			call.setString(8, v00357.getZcdzl());
			call.setString(9, v00357.getZcdzbm());
			call.setString(10, v00357.getCd00001Szqy());
			call.setString(11, v00357.getSsgx());
			call.setString(12, v00357.getSlid());
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
	 * @see com.sunway.dao.IPgt00357DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00357)
	 */
	
	@Override
	public Pgt00357 LoadByPrimaryKey(Pgt00357 t00357) throws Exception {
		ArrayList<Pgt00357> listResult = new ArrayList<Pgt00357>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00357(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t00357.getSlid());
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
			return new Pgt00357();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00357DAO#GetInsertCommand(com.sunway.vo.Pgt00357)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt00357 t00357) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00357(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 传入输入参数
			call.setString(1, t00357.getCd00301Swid());
			call.setString(2, t00357.getNsrmc());
			call.setString(3, t00357.getCd00303Lfid());
			call.setString(4, t00357.getCd00001Fwlx());
			call.setString(5, t00357.getCd00001Jylx());
			call.setString(6, t00357.getCd00001Jzjg());
			call.setBigDecimal(7, t00357.getJzmj());
//			call.setString(8, t00357.getCd00001Fwcx());
//			call.setString(9, t00357.getCd00001Cgzk());
			call.setShort(8, t00357.getSzlc());
			call.setString(9, t00357.getBwjfh());
			call.setBigDecimal(10, t00357.getPgjg());
			call.setDate(11, ConvertUtil.utilDateToSqlDate(t00357.getJysj()));
			call.setString(12, t00357.getFdcdat());
			call.setString(13, t00357.getCd00002Czr());
			call.setString(14, t00357.getNote());
			call.setString(15, t00357.getCd00352Xqdm());
			call.setString(16, t00357.getCd00001Jzjg1());
			call.setBoolean(17, CheckUtil.chkNull(t00357.getYwdt()));
			call.setShort(18, t00357.getZlc());
			call.setString(19, t00357.getNote1());
			call.setString(20, t00357.getZcdzl());
			call.setString(21, t00357.getZcdzbm());
			call.setString(22, t00357.getCd00053Qtxzid());
			call.setString(23, t00357.getSsgx());
			call.setString(24, t00357.getFczh());
			call.setString(25, t00357.getQdh());
			call.setString(26, t00357.getCb());
			call.setString(27, t00357.getGhyt());
			call.setString(28, t00357.getHxjg());
			call.setString(29, t00357.getJcsj());
//			call.setString(32, t00357.getCd00001Jtzk());
//			call.setString(33, t00357.getCd00001Wyzk());
//			call.setString(34, t00357.getCd00001Zxzk());
			call.setString(30, t00357.getZhxz());
			call.setString(31, t00357.getClh());
			call.setBoolean(32, CheckUtil.chkNull(t00357.getYwjkc()));
			call.setString(33, t00357.getLh());
			call.setString(34, t00357.getDyh());
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
	 * @see com.sunway.dao.IPgt00357DAO#GetUpdateCommand(com.sunway.vo.Pgt00357)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt00357 t00357) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00357(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 传入输入参数
			call.setString(1, t00357.getSlid());
			call.setString(2, t00357.getCd00301Swid());
			call.setString(3, t00357.getNsrmc());
			call.setString(4, t00357.getCd00303Lfid());
			call.setString(5, t00357.getCd00001Fwlx());
			call.setString(6, t00357.getCd00001Jylx());
			call.setString(7, t00357.getCd00001Jzjg());
			call.setBigDecimal(8, t00357.getJzmj());
//			call.setString(9, t00357.getCd00001Fwcx());
//			call.setString(10, t00357.getCd00001Cgzk());
			call.setShort(9, t00357.getSzlc());
			call.setString(10, t00357.getBwjfh());
			call.setBigDecimal(11, t00357.getPgjg());
			call.setDate(12, ConvertUtil.utilDateToSqlDate(t00357.getJysj()));
			call.setString(13, t00357.getFdcdat());
			call.setString(14, t00357.getCd00002Czr());
			call.setString(15, t00357.getNote());
			call.setString(16, t00357.getCd00352Xqdm());
			call.setString(17, t00357.getCd00001Jzjg1());
			call.setBoolean(18, CheckUtil.chkNull(t00357.getYwdt()));
			call.setShort(19, t00357.getZlc());
			call.setString(20, t00357.getZcdzl());
			call.setString(21, t00357.getZcdzbm());
			call.setString(22, t00357.getNote1());
			call.setString(23, t00357.getFczh());
			call.setString(24, t00357.getQdh());
			call.setString(25, t00357.getCb());
			call.setString(26, t00357.getGhyt());
			call.setString(27, t00357.getHxjg());
			call.setString(28, t00357.getJcsj());
			call.setString(29, t00357.getCd00053Qtxzid());
			call.setString(30, t00357.getSsgx());
			call.setString(31, t00357.getZhxz());
			call.setString(32, t00357.getClh());
			call.setBoolean(33, CheckUtil.chkNull(t00357.getYwjkc()));
			call.setString(34, t00357.getLh());
			call.setString(35, t00357.getDyh());
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
	 * @see com.sunway.dao.IPgt00357DAO#GetDeleteCommand(com.sunway.vo.Pgt00357)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00357 t00357) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00357(?,?,?)}");
			// 传入输入参数
			call.setString(1, t00357.getSlid());
			call.setString(2, t00357.getCd00002Czr());
			call.setString(3, t00357.getSsgx());
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
	 * @see com.sunway.dao.IPgt00357DAO#GetDeleteCommand(com.sunway.vo.Pgt00357)
	 */
	
	@Override
	public boolean GetDeleteSelCommand(Pgv00357 v00357) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT003571(?,?,?)}");
			// 传入输入参数
			call.setString(1, v00357.getChkSel());
			call.setString(2, v00357.getCd00002Czr());
			call.setString(3, v00357.getSsgx());
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
	 * @see com.sunway.dao.IPgt00357DAO#LoadDetail(com.sunway.vo.Pgv00357)
	 */
	
	@Override
	public Pgv00357 LoadDetail(Pgv00357 v00357) throws Exception {
		ArrayList<Pgv00357> listResult = new ArrayList<Pgv00357>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003570(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v00357.getSlid());
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
			return new Pgv00357();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00352DAO#ExportGJFQSjcx(com.sunway.vo.Pgv00352)
	 */
	
	
	@Override
	public OutputStream ExportkbslSjcx(Pgv00357 v00357) throws Exception {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00357(?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v00357.getPageIndex());
			call.setInt(3, v00357.getPageSize());
			call.setString(4, v00357.getCd00301Swid());
			call.setString(5, v00357.getNsrmc());
			call.setString(6, v00357.getFdcdat());
			call.setString(7, v00357.getCd00352Xqdm());
			call.setString(8, v00357.getZcdzl());
			call.setString(9, v00357.getZcdzbm());
			call.setString(10, v00357.getCd00001Szqy());
			call.setString(11, v00357.getSsgx());
			call.setString(12, v00357.getSlid());
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
				label = new Label(1, 0, "小区代码号");
				sheet.addCell(label);	
				label = new Label(2, 0, "小区名称");
				sheet.addCell(label);
				label = new Label(3, 0, "产权人");
				sheet.addCell(label);
				label = new Label(4, 0, "证件号码");
				sheet.addCell(label);
			    label = new Label(5,0,"房屋类型");
				sheet.addCell(label);
				label = new Label(6,0,"测量号");
			    sheet.addCell(label);
			    label = new Label(7,0,"坐落地址");
			    sheet.addCell(label);
			    label = new Label(8,0,"楼名");
			    sheet.addCell(label);
			    label = new Label(9,0,"单元");
			    sheet.addCell(label);
			    label = new Label(10,0,"房号");
			    sheet.addCell(label);          
			    label = new Label(11,0,"所在楼层");
			    sheet.addCell(label);
			    label = new Label(12,0,"总楼层");
			    sheet.addCell(label);
			    label = new Label(13,0,"建筑结构");
			    sheet.addCell(label);
			    label = new Label(14,0,"建成年份");
			    sheet.addCell(label);
			    label = new Label(15,0,"建筑面积(平方米)");
			    sheet.addCell(label);
			    label = new Label(16,0,"交易时间");
			    sheet.addCell(label);
			    label = new Label(17,0,"成交单价(元/平方米)");
			    sheet.addCell(label);
			    label = new Label(18,0,"备注");
			    sheet.addCell(label);
			    
			    
			
				   // 写入数据
				while(null!=rs && rs.next()){
					Integer rowIndex = rs.getRow();
					label = new Label(0, rowIndex, rs.getString(szqy));
					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString("XQDMHM"));
					sheet.addCell(label);	
					label = new Label(2, rowIndex, rs.getString(xqnm));
					sheet.addCell(label);		
					label = new Label(3, rowIndex, rs.getString(nsrmc));
					sheet.addCell(label);
					label = new Label(4, rowIndex, rs.getString(cd00301Swid));
					sheet.addCell(label);
					label = new Label(5, rowIndex, rs.getString(fwlx));
					sheet.addCell(label);
					label = new Label(6, rowIndex, rs.getString(clh));
					sheet.addCell(label);
					label = new Label(7, rowIndex, rs.getString(zcdzl));
					sheet.addCell(label);	
					label = new Label(8, rowIndex, rs.getString("LH"));
					sheet.addCell(label);	
					label = new Label(9, rowIndex, rs.getString("DYH"));
					sheet.addCell(label);	
					label = new Label(10, rowIndex, rs.getString(bwjfh));
					sheet.addCell(label);	
					label = new Label(11, rowIndex, rs.getString(szlc));
					sheet.addCell(label);
					label = new Label(12, rowIndex, rs.getString(zlc));
					sheet.addCell(label);
					label = new Label(13, rowIndex, rs.getString(jzjg));
					sheet.addCell(label);
					label = new Label(14, rowIndex, rs.getString("JCSJ"));
					sheet.addCell(label);
					label = new Label(15, rowIndex, rs.getString(jzmj));
					sheet.addCell(label);
					Date strJysj = rs.getDate(jysj);
					label = new Label(16, rowIndex, (null == strJysj?" ":strJysj.toString()));
					sheet.addCell(label);
					label = new Label(17, rowIndex, rs.getString(pgjg));
					sheet.addCell(label);
					label = new Label(18, rowIndex, rs.getString(note));
					sheet.addCell(label);
					
					
//					label = new Label(10, rowIndex, rs.getString(jylx));
//					sheet.addCell(label);
//					label = new Label(13, rowIndex, rs.getString(upddate));
//					sheet.addCell(label);
//					label = new Label(14, rowIndex, rs.getString(czr));
//					sheet.addCell(label);
					
					
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

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00357 SetVParameters(ResultSet rs) throws Exception {
		Pgv00357 e = new Pgv00357();
		e.setRecordCount(rs.getInt(total));
		e.setSlid(rs.getString(slid));
		e.setCd00301Swid(rs.getString(cd00301Swid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJzmj(rs.getDouble(jzmj));
//		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
//		e.setCd00001Cgzk(rs.getString(cd00001Cgzk));
		e.setSzlc(rs.getShort(szlc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setPgjg(rs.getDouble(pgjg));
		e.setJysj(rs.getDate(jysj));
		e.setFdcdat(rs.getString(fdcdat));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00352Xqdm(rs.getString(cd00352Xqdm));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setYwdt(rs.getBoolean(ywdt));
		e.setZlc(rs.getString(zlc));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setFwlx(rs.getString(fwlx));
		e.setJylx(rs.getString(jylx));
		e.setJzjg(rs.getString(jzjg));
//		e.setFwcx(rs.getString(fwcx));
//		e.setCgzk(rs.getString(cgzk));
		e.setCzr(rs.getString(czr));
		e.setZcdzl(rs.getString(zcdzl));
		e.setClh(rs.getString(clh));
		e.setYwjkc(rs.getBoolean(ywjkc));
		return e;
	}

	/**
	 * Edit数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00357 SetTParameters(ResultSet rs) throws Exception {
		Pgt00357 e = new Pgt00357();
		e.setSlid(rs.getString(slid));
		e.setCd00301Swid(rs.getString(cd00301Swid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJzmj(rs.getBigDecimal(jzmj));
//		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
//		e.setCd00001Cgzk(rs.getString(cd00001Cgzk));
		e.setSzlc(rs.getShort(szlc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setPgjg(rs.getBigDecimal(pgjg));
		e.setJysj(rs.getTimestamp(jysj));
		e.setFdcdat(rs.getString(fdcdat));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setFwlxsc(rs.getString(fwlxSc));
		e.setJylxsc(rs.getString(jylxSc));
		e.setJzjg(rs.getString(jzjg));
//		e.setFwcx(rs.getString(fwcx));
//		e.setCgzksc(rs.getString(cgzkSc));
//		e.setCd00001Jtzk(rs.getString(cd00001Jtzk));
//		e.setCd00001Wyzk(rs.getString(cd00001Wyzk));
//		e.setCd00001Zxzk(rs.getString(cd00001Zxzk));
//		e.setJtzk(rs.getString(jtzk));
//		e.setWyzk(rs.getString(wyzk));
//		e.setZxzk(rs.getString(zxzk));
		e.setFczh(rs.getString(fczh));
		e.setQdh(rs.getString(qdh));
		e.setCb(rs.getString(cb));
		e.setGhyt(rs.getString(ghyt));
		e.setHxjg(rs.getString(hxjg));
		e.setJcsj(rs.getString(jcsj));
		e.setNsrmc(rs.getString(nsrmc));
		e.setLh(rs.getString(lh));
		e.setDyh(rs.getString(dyh));
		return e;
	}

	/**
	 * Detail数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00357 SetDParameters(ResultSet rs) throws Exception {
		Pgv00357 e = new Pgv00357();
		e.setSlid(rs.getString(slid));
		e.setCd00301Swid(rs.getString(cd00301Swid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJzmj(rs.getDouble(jzmj));
//		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
//		e.setCd00001Cgzk(rs.getString(cd00001Cgzk));
		e.setSzlc(rs.getShort(szlc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setPgjg(rs.getDouble(pgjg));
		e.setJysj(rs.getDate(jysj));
		e.setFdcdat(rs.getString(fdcdat));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00352Xqdm(rs.getString(cd00352Xqdm));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setYwdt(rs.getBoolean(ywdt));
		e.setZlc(rs.getString(zlc));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setFwlx(rs.getString(fwlx));
		e.setJylx(rs.getString(jylx));
		e.setJzjg(rs.getString(jzjg));
//		e.setFwcx(rs.getString(fwcx));
//		e.setCgzk(rs.getString(cgzk));
		e.setCzr(rs.getString(czr));
		e.setZhxz(rs.getString(zhxz));
		e.setClh(rs.getString(clh));
		e.setYwjkc(rs.getBoolean(ywjkc));
		e.setFwtdzl(rs.getString(fwtdzl));
		e.setFczh(rs.getString(fczh));
		e.setJcsj(rs.getString(jcsj));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00357DAO#ImportExcelData(java.util.ArrayList)
	 */
	
	@Override
	public Pgv00357 ImportExcelData(ArrayList<Pgv00357> kbslkList) throws Exception{
		Pgv00357 v00357 = new Pgv00357();
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
			call = conn.prepareCall("{call PGSP_ADDT003571(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			for(int i=0; i<kbslkList.size(); i++){
				Pgv00357 kbslk = kbslkList.get(i);
				try {
					call.registerOutParameter(1, OracleTypes.CURSOR);
					
					// 传入输入参数
					call.setString(2, kbslk.getCd00301Swid());
					call.setString(3, kbslk.getNsrmc());
					call.setString(4, kbslk.getCd00303Lfid());
					call.setString(5, kbslk.getFwlx());
					call.setString(6, kbslk.getJylx());
					call.setString(7, kbslk.getJzjg());
					call.setDouble(8, kbslk.getJzmj());
					call.setShort(9, kbslk.getSzlc());
					call.setString(10, kbslk.getBwjfh());
					call.setDouble(11, kbslk.getPgjg());
					call.setDate(12, ConvertUtil.utilDateToSqlDate(kbslk.getJysj()));
					call.setString(13, kbslk.getFdcdat());
					call.setString(14, kbslk.getCd00002Czr());
					call.setString(15, kbslk.getNote());
					call.setString(16, kbslk.getXqnm());
					call.setString(17, kbslk.getCd00001Jzjg());
					call.setBoolean(18, CheckUtil.chkNull(kbslk.getYwdt()));
					call.setShort(19, ConvertUtil.toShort(kbslk.getZlc()));
					call.setString(20, kbslk.getNote());
					call.setString(21, kbslk.getZcdzl());
					call.setString(22, kbslk.getZcdzbm());
					call.setString(23, kbslk.getJgzk());
					call.setString(24, kbslk.getCd00001Ssgx());
					call.setString(25, kbslk.getFczh());
					call.setString(26, kbslk.getZhxzs());
					call.setString(27, kbslk.getClh());
					call.setBoolean(28, CheckUtil.chkNull(kbslk.getYwjkc()));
					call.setString(29, kbslk.getSzqy());
					call.setString(30, kbslk.getLm());
					call.setString(31, kbslk.getDy());
					call.setString(32, kbslk.getXqdmh());
					call.setString(33, kbslk.getJcnf());
					call.execute();
					
					rs = (ResultSet) call.getObject(1); 
					if (null!=rs && rs.next()) {
						if (rs.getInt("flag") == 0) {
							sResultCount++;
							//标记哪一列字段错误
							kbslk.setCd00352Xqdm(rs.getString("TXQDM"));
							kbslk.setCd00001Fwlx(rs.getString("TFWLX"));
							kbslk.setCd00001Jylx(rs.getString("TJYLX"));
							kbslk.setCd00001Jzjg(rs.getString("TJZJG"));
							kbslk.setCd00001Szqy(rs.getString("TSZQY"));
							kbslk.setXqdmhid(rs.getString("TDMH"));
							kbslk.setJgzkId(rs.getString("QTXZIDS"));
							kbslk.setZhxzId(rs.getString("ZHXZS"));
							kbslk.setCwxx("");
							//将数据封装到list
							v00357.getOutList().add(kbslk);
						}
						rs.close();
					}
				} catch (Exception e) {
					sResultCount++;
					kbslk.setCwxx(e.getMessage());
					//将数据封装到list
					v00357.getOutList().add(kbslk);
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
			v00357.setOutFlag(resultValue);
		}
		return v00357;
	}
	
	
	
	@Override
	public ArrayList<Pgv00357> LoadCSKbsl(Pgv00357 v00357) throws Exception {
		ArrayList<Pgv00357> resultList = new ArrayList<Pgv00357>();
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		ResultSet rs =  null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003572(?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v00357.getPageIndex());
			call.setInt(3, v00357.getPageSize());
			call.setString(4, v00357.getSlid());
			call.setInt(5, v00357.getCsyf());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				resultList.add(SetCSKBSLParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		
		return resultList;
	}
	
	
	
	@Override
	public Integer MakeBZF(Pgv00357 v00357) throws Exception {
		Integer iResult = 0;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT003512(?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.INTEGER);
			call.setString(2, v00357.getCd00001Szqy());
			call.setString(3, v00357.getCd00352Xqdm());
			call.setString(4, v00357.getCd00001Fwlx());
			call.setString(5, v00357.getSsgx());
			call.setString(6, v00357.getCd00002Czr());
			call.execute();
			tran.commit();
			iResult = call.getInt(1);
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return iResult;
	}
	
	
	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00357 SetCSKBSLParameters(ResultSet rs) throws Exception {
		Pgv00357 e = new Pgv00357();
		e.setRecordCount(rs.getInt(total));
		e.setSlid(rs.getString(slid));
		e.setCd00301Swid(rs.getString(cd00301Swid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJzmj(rs.getDouble(jzmj));
		e.setSzlc(rs.getShort(szlc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setPgjg(rs.getDouble(pgjg));
		e.setJysj(rs.getDate(jysj));
		e.setFdcdat(rs.getString(fdcdat));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00352Xqdm(rs.getString(cd00352Xqdm));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setYwdt(rs.getBoolean(ywdt));
		e.setZlc(rs.getString(zlc));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setFwlx(rs.getString(fwlx));
		e.setJylx(rs.getString(jylx));
		e.setJzjg(rs.getString(jzjg));
		e.setCzr(rs.getString(czr));
		e.setZcdzl(rs.getString(zcdzl));
//		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
//		e.setCd00001Fqwz(rs.getString(cd00001Fqwz));
//		e.setCd00001Dywz(rs.getString(cd00001Dywz));
//		e.setFwcx(rs.getString(fwcx));
//		e.setFqwz(rs.getString(fqwz));
//		e.setDywz(rs.getString(dywz));
//		e.setZh(rs.getString(zh));
//		e.setQdh(rs.getString(qdh));
//		e.setJcsj(rs.getString(jcsj));
//		e.setDmh(rs.getString(cd00352Xqdm));
//		//e.setZhxzs(rs.getString(zhxz));
//		e.setXqdmhm(rs.getString("xqdmhm"));
//		if(rs.getDouble(pgjg) != 0){
//			e.setPfmjg(rs.getDouble(pgjg)/rs.getDouble(jzmj));
//		}else{
//			Double i = 0d;
//			e.setPfmjg(i);
//		}
		
		return e;
	}
}
