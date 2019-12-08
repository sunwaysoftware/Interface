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

import com.sunway.dao.IPgt00352DAO;
import com.sunway.util.Common;
import com.sunway.vo.ExcelBean;
import com.sunway.vo.Pgt00352;
import com.sunway.vo.Pgv00352;

/**
 * 小区名称维护
 * @author Lee
 * @version 1.0
 */
public class Pgt00352DAO extends BaseDAO implements IPgt00352DAO {

	private static final String xqdm =  "XQDM";
	private static final String cd00001Szqylx = "CD_00001_SZQYLX";
	private static final String cd00001Szqy = "CD_00001_SZQY";
	private static final String parentdm =  "PARENTDM";
	private static final String xqnm =  "XQNM";
	private static final String xqbm =  "XQBM";
	private static final String vieworder = "VIEWORDER";
	private static final String upddate =  "UPDDATE";
	private static final String cd00002Czr =  "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String isdir = "ISDIR";
	private static final String szqy =  "SZQY";
	private static final String czr =  "CZR";
	private static final String parentnm =  "PARENTNM";
	private static final String total = "total";
	private static final String rid = "RID";
	private static final String level =  "level";
	private static final String xqzt =  "xqzt";
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00352DAO#LoadAll(com.sunway.vo.Pgv00352)
	 */
	
	@Override
	public ArrayList<Pgv00352> LoadAll(Pgv00352 v00352) throws Exception {
		ArrayList<Pgv00352> listResult = new ArrayList<Pgv00352>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00352(?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v00352.getPageIndex());
			call.setInt(3, v00352.getPageSize());
			call.setString(4, v00352.getXqdm());
			call.setString(5, v00352.getXqnm());
			call.setString(6, v00352.getNote());
			call.setString(7, v00352.getCd00001Szqy());
			call.setString(8, v00352.getSsgx());
			call.execute();
			// 返回數據集
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
	 * @see com.sunway.dao.IPgt00352DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00352)
	 */
	
	@Override
	public Pgt00352 LoadByPrimaryKey(Pgt00352 t00352) throws Exception {
		ArrayList<Pgt00352> listResult = new ArrayList<Pgt00352>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00352(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t00352.getXqdm());
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
			return new Pgt00352();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00352DAO#GetInsertCommand(com.sunway.vo.Pgt00352)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt00352 t00352) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00352(?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			// 传入输入参数
			call.setString(2, t00352.getCd00001Szqy());
			call.setString(3, t00352.getParentdm());
			call.setString(4, t00352.getXqnm());
			call.setString(5, t00352.getXqbm());
			call.setShort(6, t00352.getVieworder());
			call.setString(7, t00352.getCd00002Czr());
			call.setString(8, t00352.getNote());
			call.setBoolean(9, t00352.getIsdir());
			call.setString(10, t00352.getSsgx());
			call.setByte(11, t00352.getXqzt());
			call.setString(12, t00352.getXqdmh());
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
	 * @see com.sunway.dao.IPgt00352DAO#GetDeleteCommand(com.sunway.vo.Pgt00352)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00352 t00352) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00352(?,?,?)}");
			// 传入输入参数
			call.setString(1, t00352.getXqdm());
			call.setString(2, t00352.getCd00002Czr());
			call.setString(3, t00352.getSsgx());
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
	 * @see com.sunway.dao.IPgt00352DAO#GetUpdateCommand(com.sunway.vo.Pgt00352)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt00352 t00352) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00352(?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 传入输入参数
			call.setString(1, t00352.getXqdm());
			call.setString(2, t00352.getCd00001Szqylx());
			call.setString(3, t00352.getCd00001Szqy());
			call.setString(4, t00352.getParentdm());
			call.setString(5, t00352.getXqnm());
			call.setString(6, t00352.getXqbm());
			call.setShort(7, t00352.getVieworder());
			call.setString(8, t00352.getCd00002Czr());
			call.setString(9, t00352.getNote());
			call.setBoolean(10, t00352.getIsdir());
			call.setString(11, t00352.getSsgx());
			call.setString(12, t00352.getXqdmh());
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
	 * @see com.sunway.dao.IPgt00352DAO#LoadNavigator(com.sunway.vo.Pgt00352)
	 */
	
	@Override
	public ArrayList<Pgt00352> LoadNavigator(Pgt00352 t00352) throws Exception {
		ArrayList<Pgt00352> listResult = new ArrayList<Pgt00352>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003522(?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 傳入輸入參數
			call.setString(2, t00352.getXqdm());
			call.execute();
			// 返回數據集
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

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00352DAO#LoadTreeList(com.sunway.vo.Pgt00352)
	 */
	
	@Override
	public ArrayList<Pgt00352> LoadTreeList(Pgt00352 t00352) throws Exception {
		ArrayList<Pgt00352> listResult = new ArrayList<Pgt00352>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003523(?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 傳入輸入參數
			call.setString(2, t00352.getCd00001Szqy());
			call.setString(3, t00352.getXqdm());
			call.setString(4, t00352.getNoxqdm());
			call.execute();
			// 返回數據集
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

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00352DAO#LoadNavStream(java.lang.String)
	 */
	
	@Override
	public String LoadNavStream(String xqdm) throws Exception {
		String resultValue = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{? = call FN_GETXQNM(?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			// 注册输入参数
			call.setString(2, xqdm);
			call.execute();
			// 返回数据集
			if(null!=call.getObject(1))
				resultValue = (String) call.getObject(1);
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return resultValue;
	}
	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00352 SetVParameters(ResultSet rs) throws Exception {
		Pgv00352 e = new Pgv00352();
		e.setRecordCount(rs.getInt(total));
		e.setRecordIndex(rs.getInt(rid));
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
		e.setSzqy(rs.getString(szqy));
		e.setCzr(rs.getString(czr));
		e.setParentnm(rs.getString(parentnm));
		e.setXqzt(rs.getByte(xqzt));
		e.setXqdmh(rs.getString("xqdmhm"));
		
		return e;
	}

	/**
	 * Edit数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00352 SetTParameters(ResultSet rs) throws Exception {
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
		e.setXqzt(rs.getByte("XQZT"));
		e.setXqdmh(rs.getString("XQDMHM"));
		return e;
	}

	/**
	 * Tree数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00352 SetNParameters(ResultSet rs) throws Exception {
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
	 * @see com.sunway.dao.IPgt00352DAO#ImportExcelData(java.util.ArrayList)
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
			call = conn.prepareCall("{call PGSP_ADDT003521(?,?,?,?,?,?,?,?,?,?)}");
			for(int i=0; i<ebList.size(); i++){
				ExcelBean bean = ebList.get(i);
				try {
					call.registerOutParameter(1, OracleTypes.CURSOR);
					
					call.setString(2, bean.getSzqyNm());
					call.setString(3, bean.getParentXQNm());
					call.setString(4, bean.getXqNm());
					call.setString(5, bean.getXqdzbm());
					call.setString(6, bean.getZcdzl());
					call.setString(7, bean.getCd00002Czr());
					call.setString(8, bean.getSsgx());
					call.setString(9, bean.getXqdmh());
					call.setString(10, bean.getPqdmh());
					call.execute();
					
					rs = (ResultSet) call.getObject(1); 
					if (null!=rs && rs.next()) {
						if (rs.getInt("flag") == 0) {
							sResultCount++;
							//标记哪列字段错误
							bean.setXqId(rs.getString("XQID"));
							bean.setSzqyId(rs.getString("SZQYID"));
							bean.setParentXQId(rs.getString("PARENTXQID"));
							bean.setNote("");
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

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00352DAO#LoadAllByXqzt(com.sunway.vo.Pgv00352)
	 */
	
	@Override
	public ArrayList<Pgv00352> LoadAllByXqzt(Pgv00352 v00352) throws Exception {
		ArrayList<Pgv00352> listResult = new ArrayList<Pgv00352>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003521(?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v00352.getCd00001Szqy());
			call.setString(3, v00352.getSsgx());
			call.setByte(4, v00352.getXqzt());
			call.execute();
			// 返回數據集
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

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00352DAO#GetUpdateCommandForXqzt(com.sunway.vo.Pgt00352)
	 */
	
	@Override
	public boolean GetUpdateCommandForXqzt(Pgt00352 t00352) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT003521(?,?,?,?)}");
			// 传入输入参数
			call.setString(1, t00352.getXqdms_able());
			call.setString(2, t00352.getXqdms_unable());
			call.setString(3, t00352.getCd00002Czr());
			call.setString(4, t00352.getSsgx());
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
	 * @see com.sunway.dao.IPgt00352DAO#GetXQNM(com.sunway.vo.Pgt00352)
	 */
	
	@Override
	public ArrayList<Pgv00352> GetXQNM(Pgt00352 t00352) throws Exception {
		ArrayList<Pgv00352> listResult = new ArrayList<Pgv00352>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003526(?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t00352.getXqnm());
			call.setString(3, t00352.getSsgx());
			call.execute();
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgv00352 b = new Pgv00352();
				b.setXqnm(rs.getString(xqnm));
				b.setParentnm(rs.getString("PARENTNM"));
				b.setXqdmh(rs.getString("XQDMHM"));	
				b.setNote(rs.getString("FWLX"));
				listResult.add(b);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00352DAO#LoadByXqnm(com.sunway.vo.Pgt00352)
	 */
	
	@Override
	public Pgt00352 LoadByXqnm(Pgt00352 t00352) throws Exception {
		ArrayList<Pgt00352> listResult = new ArrayList<Pgt00352>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003527(?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t00352.getXqnm());
			call.setString(3, t00352.getSsgx());
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
			return new Pgt00352();
		}
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00352DAO#ExportGJFQSjcx(com.sunway.vo.Pgv00352)
	 */
	
	
	@Override
	public OutputStream ExportGJFQSjcx(Pgv00352 v00352) throws Exception {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00352(?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v00352.getPageIndex());
			call.setInt(3, v00352.getPageSize());
			call.setString(4, v00352.getXqdm());
			call.setString(5, v00352.getXqnm());
			call.setString(6, v00352.getNote());
			call.setString(7, v00352.getCd00001Szqy());
			call.setString(8, v00352.getSsgx());
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
				label = new Label(1, 0, "大区名称");
				sheet.addCell(label);	
				label = new Label(2, 0, "小区名称");
				sheet.addCell(label);	          
				label = new Label(3, 0, "更新时间");
				sheet.addCell(label);
				label = new Label(4, 0, "操作人");
				sheet.addCell(label);	
				label = new Label(5, 0, "座落地址");
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
					label = new Label(3, rowIndex, Common.formatExportDateTime(rs, upddate));
					sheet.addCell(label);
					label = new Label(4, rowIndex, rs.getString(cd00002Czr));
					sheet.addCell(label);	
					label = new Label(5, rowIndex, rs.getString(note));
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
	 * @see com.sunway.dao.IPgt00352DAO#LoadQX(com.sunway.vo.Pgt00352)
	 */
	
	@Override
	public Integer LoadQX (Pgt00352 t00352) throws Exception {
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Integer result=0;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003529(?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			// 传入输入参数
			call.setString(2, t00352.getXqnm());
			call.setString(3, t00352.getCd00001Szqy());
			call.setString(4, t00352.getParentdm());
			call.execute();
			// 返回数据集
			result= (Integer) call.getInt(1);
		
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return result;
	}
}
