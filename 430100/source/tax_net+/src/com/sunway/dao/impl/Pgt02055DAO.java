/**
 * 
 */
package com.sunway.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.Workbook;
import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt02055DAO;

import com.sunway.util.Excel;
import com.sunway.util.FormatUtil;
import com.sunway.vo.Pgt02055;
import com.sunway.vo.Pgv02055;

/**
 * @author Andy
 *
 */
public class Pgt02055DAO extends BaseDAO implements IPgt02055DAO {

	private static final String id = "ID";							//流水号
	private static final String cd00001Szqy = "CD_00001_SZQY";		//所在区域
	private static final String jsMin = "JS_MIN";				//进深下限
	private static final String jsMax = "JS_MAX";				//进深上限
	private static final String xzxs = "XZXS" ;						//修正系数
	private static final String upddate = "UPDDATE";				//更改时间
	private static final String cd00002Czr = "CD_00002_CZR";		//操作人字段
	private static final String note = "NOTE";						//备注信息
	private static final String szqy = "SZQY";
	private static final String czr = "CZR";
	private static final String total = "TOTAL";					//总纪录数
	private static final String cd00001Fwlx = "CD_00001_FWLX";
	private static final String cd00001Fwlxlx = "CD_00001_FWLXLX";
	private static final String fwlx = "FWLX";
	private static final String cd00001Szqylx = "CD_00001_SZQYLX";
	private static final String cd02050Xqdm = "CD_02050_XQDM";
	private static final String xqnm = "XQNM";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02055DAO#GetDeleteCommand(com.sunway.vo.Pgt02055)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt02055 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;	
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02055(?,?,?)}");
			//傳入輸入參數
			call.setString(1, bean.getId());
			call.setString(2, bean.getCd00002Czr());
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

	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02055DAO#GetDeleteCommand(com.sunway.vo.Pgt02055)
	 */
	
	@Override
	public boolean GetDeleteCommandA(Pgt02055 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;	
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02055A(?,?,?)}");
			//傳入輸入參數
			call.setString(1, bean.getId());
			call.setString(2, bean.getCd00002Czr());
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

	
	
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02055DAO#GetInsertCommand(com.sunway.vo.Pgt02055)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt02055 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02055(?,?,?,?,?,?,?,?)}");
			//傳入輸入參數

			call.setString(1, bean.getCd00001Fwlx());
			call.setString(2, bean.getCd00001Szqy());
			call.setBigDecimal(3, bean.getJsMin());
			call.setBigDecimal(4, bean.getJsMax());
			call.setBigDecimal(5, bean.getXzxs());
			call.setString(6, bean.getCd00002Czr());
			call.setString(7, bean.getNote());
			call.setString(8, bean.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt02055DAO#GetInsertCommand(com.sunway.vo.Pgt02055)
	 */
	
	@Override
	public boolean GetInsertCommandA(Pgt02055 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02055A(?,?,?,?,?,?,?,?)}");
			//傳入輸入參數
			call.setString(1, bean.getCd00001Fwlx());
			call.setString(2, bean.getCd02050Xqdm());
			call.setBigDecimal(3, bean.getJsMin());
			call.setBigDecimal(4, bean.getJsMax());
			call.setBigDecimal(5, bean.getXzxs());
			call.setString(6, bean.getCd00002Czr());
			call.setString(7, bean.getNote());
			call.setString(8, bean.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt02055DAO#LoadByPrimaryKey(com.sunway.vo.Pgt02055)
	 */
	
	@Override
	public Pgt02055 LoadByPrimaryAddKey(Pgt02055 bean) throws Exception {
		Pgt02055 listResult = new Pgt02055();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT020551(?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd00001Szqy());
			call.setString(3, bean.getCd00001Fwlx());
			call.setBigDecimal(4, bean.getJsMin());
			call.setBigDecimal(5, bean.getJsMax());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult = SetParameters(rs, false);
				break;
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02055DAO#LoadByPrimaryKey(com.sunway.vo.Pgt02055)
	 */
	
	@Override
	public Pgt02055 LoadByPrimaryAddKeyA(Pgt02055 bean) throws Exception {
		Pgt02055 listResult = new Pgt02055();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02055A1(?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd02050Xqdm());
			call.setString(3, bean.getCd00001Fwlx());
			call.setBigDecimal(4, bean.getJsMin());
			call.setBigDecimal(5, bean.getJsMax());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult = SetParameters(rs, false);
				break;
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return listResult;
	}
	
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02055DAO#GetUpdateCommand(com.sunway.vo.Pgt02055)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt02055 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02055(?,?,?,?,?,?,?,?,?)}");
			//傳入輸入參數
			call.setString(1, bean.getId());
			call.setBigDecimal(2, bean.getJsMin());
			call.setBigDecimal(3, bean.getJsMax());
			call.setBigDecimal(4, bean.getXzxs());
			call.setString(5, bean.getCd00002Czr());
			call.setString(6, bean.getNote());
			call.setString(7, bean.getCd00001Fwlx());
			call.setString(8, bean.getCd00001Szqy());
			call.setString(9,bean.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt02055DAO#GetUpdateCommand(com.sunway.vo.Pgt02055)
	 */
	
	@Override
	public boolean GetUpdateCommandA(Pgt02055 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02055A(?,?,?,?,?,?,?,?,?)}");
			//傳入輸入參數
			call.setString(1, bean.getId());
			call.setBigDecimal(2, bean.getJsMin());
			call.setBigDecimal(3, bean.getJsMax());
			call.setBigDecimal(4, bean.getXzxs());
			call.setString(5, bean.getCd00002Czr());
			call.setString(6, bean.getNote());
			call.setString(7, bean.getCd00001Fwlx());
			call.setString(8, bean.getCd02050Xqdm());
			call.setString(9,bean.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt02055DAO#LoadAll(com.sunway.vo.Pgt02055)
	 */
	
	@Override
	public ArrayList<Pgv02055> LoadAll(Pgv02055 bean) throws Exception {
		ArrayList<Pgv02055> listResult = new ArrayList<Pgv02055>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02055(?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getCd00001Szqy());
			call.setString(5, bean.getCd00001Fwlx());
			call.setString(6,bean.getSsgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVParameters(rs, true));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02055DAO#LoadAll(com.sunway.vo.Pgt02055)
	 */
	
	@Override
	public ArrayList<Pgv02055> LoadAllA(Pgv02055 bean) throws Exception {
		ArrayList<Pgv02055> listResult = new ArrayList<Pgv02055>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02055A(?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getCd00001Szqy());
			call.setString(5, bean.getCd00001Fwlx());
			call.setString(6, bean.getSsgx());
			call.setString(7, bean.getCd02050Xqdm());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVParametersA(rs, true));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02055DAO#LoadByPrimaryKey(com.sunway.vo.Pgt02055)
	 */
	
	@Override
	public Pgt02055 LoadByPrimaryKey(Pgt02055 bean) throws Exception {
		Pgt02055 listResult = new Pgt02055();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02055(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getId());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult = SetParameters(rs, false);
				break;
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return listResult;
	}
	
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02055DAO#LoadByPrimaryKey(com.sunway.vo.Pgt02055)
	 */
	
	@Override
	public Pgt02055 LoadByPrimaryKeyA(Pgt02055 bean) throws Exception {
		Pgt02055 listResult = new Pgt02055();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02055A(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getId());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult = SetParametersA(rs, false);
				break;
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	/**
	 * Table 数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt02055 SetParameters(ResultSet rs, Boolean flag) throws Exception {
		Pgt02055 e = new Pgt02055();
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setId(rs.getString(id));
		e.setJsMax(rs.getBigDecimal(jsMax));
		e.setJsMin(rs.getBigDecimal(jsMin));
		e.setNote(rs.getString(note));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setXzxs(rs.getBigDecimal(xzxs));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Fwlxlx(rs.getString(cd00001Fwlxlx));
		e.setFwlx(rs.getString(fwlx));
		if(flag){
			e.setRecordCount(rs.getInt(total));
			e.setCzr(rs.getString(czr));
			e.setSzqy(rs.getString(szqy));
		}
		return e;
	}
	
	
	/**
	 * Table 数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt02055 SetParametersA(ResultSet rs, Boolean flag) throws Exception {
		Pgt02055 e = new Pgt02055();
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setId(rs.getString(id));
		e.setJsMax(rs.getBigDecimal(jsMax));
		e.setJsMin(rs.getBigDecimal(jsMin));
		e.setNote(rs.getString(note));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setXzxs(rs.getBigDecimal(xzxs));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Fwlxlx(rs.getString(cd00001Fwlxlx));
		e.setFwlx(rs.getString(fwlx));
		e.setCd02050Xqdm(rs.getString(cd02050Xqdm));
		e.setXqnm(rs.getString(xqnm));
		if(flag){
			e.setRecordCount(rs.getInt(total));
			e.setCzr(rs.getString(czr));
			e.setSzqy(rs.getString(szqy));
		}
		return e;
	}
	
	
	/**
	 * 数据转存
	 */
	protected Pgv02055 SetVParametersA(ResultSet rs,Boolean flag)throws Exception{
		Pgv02055 e = new Pgv02055();
//		e.setCzr(rs.getString(czr));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Fwlxlx(rs.getString(cd00001Fwlxlx));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCd00001Szqylx(rs.getString(cd00001Szqylx));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setFwlx(rs.getString(fwlx));
		e.setId(rs.getString(id));
		e.setJsMax(rs.getBigDecimal(jsMax));
		e.setJsMin(rs.getBigDecimal(jsMin));
		e.setNote(rs.getString(note));
		e.setSzqy(rs.getString(szqy));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setXzxs(rs.getBigDecimal(xzxs));
		e.setCd02050Xqdm(rs.getString(cd02050Xqdm));
		e.setXqnm(rs.getString(xqnm));
		e.setXqdmhm(rs.getString("xqdmhm"));
		if(flag){
			e.setRecordCount(rs.getInt(total));
			e.setCzr(rs.getString(czr));
			e.setSzqy(rs.getString(szqy));
		}
		return e;
	}
	
	/**
	 * 数据转存
	 */
	protected Pgv02055 SetVParameters(ResultSet rs,Boolean flag)throws Exception{
		Pgv02055 e = new Pgv02055();
//		e.setCzr(rs.getString(czr));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Fwlxlx(rs.getString(cd00001Fwlxlx));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCd00001Szqylx(rs.getString(cd00001Szqylx));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setFwlx(rs.getString(fwlx));
		e.setId(rs.getString(id));
		e.setJsMax(rs.getBigDecimal(jsMax));
		e.setJsMin(rs.getBigDecimal(jsMin));
		e.setNote(rs.getString(note));
		e.setSzqy(rs.getString(szqy));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setXzxs(rs.getBigDecimal(xzxs));
		if(flag){
			e.setRecordCount(rs.getInt(total));
			e.setCzr(rs.getString(czr));
			e.setSzqy(rs.getString(szqy));
		}
		return e;
	}

	
	@Override
	public OutputStream ExportT02055(Pgv02055 v02055) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		Connection conn = null;
		
		CallableStatement call = null;
		ResultSet rs = null;
		WritableWorkbook workbook = null;
		try {
			strBufResult = new ByteArrayOutputStream();
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02055(?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, v02055.getPageIndex());
			call.setInt(3, v02055.getPageSize());
			call.setString(4, v02055.getCd00001Szqy());
			call.setString(5, v02055.getCd00001Fwlx());
			call.setString(6, v02055.getSsgx());
			call.execute();
			
			rs = (ResultSet)call.getObject(1);
			if(rs != null){
				Label label;
				workbook = Workbook.createWorkbook(strBufResult);
				WritableSheet sheet = workbook.createSheet("进深修正", 0);
				WritableCellFormat wcf =Excel.getExcelTitleStyle();
				
				label = new Label(0, 0, "所在区域",wcf);
				sheet.addCell(label);
				label = new Label(1, 0, "房屋类型",wcf);
				sheet.addCell(label);
				label = new Label(2, 0, "进深下限(平方米)",wcf);
				sheet.addCell(label);
				label = new Label(3, 0, "进深上限(平方米)",wcf);
				sheet.addCell(label);
				label = new Label(4, 0, "修正值(%)",wcf);
				sheet.addCell(label);
				label = new Label(5, 0, "更新时间",wcf);
				sheet.addCell(label);
				label = new Label(6, 0, "操作人",wcf);
				sheet.addCell(label);
				label = new Label(7, 0, "备注",wcf);
				sheet.addCell(label);
				
				while(rs != null && rs.next()){
					Integer rowIndex = rs.getRow();
					
					label = new Label(0, rowIndex, rs.getString(szqy));
					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString(fwlx));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(jsMin));
					sheet.addCell(label);
					label = new Label(3, rowIndex, rs.getString(jsMax));
					sheet.addCell(label);
					label = new Label(4, rowIndex, rs.getString(xzxs));
					sheet.addCell(label);
					label = new Label(5, rowIndex, FormatUtil.toYMDHMS(rs.getTimestamp(upddate)));
					sheet.addCell(label);
					label = new Label(6, rowIndex, rs.getString(czr));
					sheet.addCell(label);
					label = new Label(7, rowIndex, rs.getString(note));
					sheet.addCell(label);
				}
				workbook.write();
			}
			//填写导出日志
			//WriteLogExp(v02055.getSsgx(), "PGT02055", v02055.getCd00002Czr(), "进深修正导出成功");
		}catch(Exception e){
			if(null != strBufResult){
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
	public OutputStream ExportT02055A(Pgv02055 v02055) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		WritableWorkbook workbook = null;
		Connection conn = null;
		
		CallableStatement call = null;
		ResultSet rs = null;
		try {
			strBufResult = new ByteArrayOutputStream();
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02055A(?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, v02055.getPageIndex());
			call.setInt(3, v02055.getPageSize());
			call.setString(4, v02055.getCd00001Szqy());
			call.setString(5, v02055.getCd00001Fwlx());
			call.setString(6, v02055.getSsgx());
			call.setString(7, v02055.getCd02050Xqdm());
			call.execute();
			
			rs = (ResultSet)call.getObject(1);
			if(rs != null){
				Label label;
				workbook = Workbook.createWorkbook(strBufResult);
				WritableSheet sheet = workbook.createSheet("进深修正", 0);
				WritableCellFormat wcf =Excel.getExcelTitleStyle();
				
				
				
				label = new Label(0, 0, "所在区域",wcf);
				sheet.addCell(label);
				label = new Label(1, 0, "代码号",wcf);
				sheet.addCell(label);
				label = new Label(2, 0, "小区名称",wcf);
				sheet.addCell(label);
				label = new Label(3, 0, "房屋类型",wcf);
				sheet.addCell(label);
				label = new Label(4, 0, "进深下限(平方米)",wcf);
				sheet.addCell(label);
				label = new Label(5, 0, "进深上限(平方米)",wcf);
				sheet.addCell(label);
				label = new Label(6, 0, "修正值(%)",wcf);
				sheet.addCell(label);
				label = new Label(7, 0, "更新时间",wcf);
				sheet.addCell(label);
				label = new Label(8, 0, "操作人",wcf);
				sheet.addCell(label);
				label = new Label(9, 0, "备注",wcf);
				sheet.addCell(label);
				
				while(rs != null && rs.next()){
					Integer rowIndex = rs.getRow();
					
					label = new Label(0, rowIndex, rs.getString(szqy));
					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString("xqdmhm"));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(xqnm));
					sheet.addCell(label);
					label = new Label(3, rowIndex, rs.getString(fwlx));
					sheet.addCell(label);
					label = new Label(4, rowIndex, rs.getString(jsMin));
					sheet.addCell(label);
					label = new Label(5, rowIndex, rs.getString(jsMax));
					sheet.addCell(label);
					label = new Label(6, rowIndex, rs.getString(xzxs));
					sheet.addCell(label);
					label = new Label(7, rowIndex, FormatUtil.toYMDHMS(rs.getTimestamp(upddate)));
					sheet.addCell(label);
					label = new Label(8, rowIndex, rs.getString(czr));
					sheet.addCell(label);
					label = new Label(9, rowIndex, rs.getString(note));
					sheet.addCell(label);
				}
				workbook.write();
				//workbook.close();
			}
			//填写导出日志
			//WriteLogExp(v02055.getSsgx(), "PGT02055", v02055.getCd00002Czr(), "进深修正导出成功");
		}catch(Exception e){
			if(null != strBufResult){
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
	public Pgv02055 ImportExcelData(ArrayList<Pgv02055> v02055List)
			throws Exception {
		Pgv02055 v02055 = new Pgv02055();
		ArrayList<Pgv02055> tempList = new ArrayList<Pgv02055>();
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		ResultSet rs = null;
		Integer sResultCount = 0;
		Integer fResultCount = 0;
		Integer resultValue = 0;
		
		try{
			session = getSession();
			conn = super.getConnection();
			
			call = conn.prepareCall("{call PGSP_ADDT020551(?,?,?,?,?,?,?,?)}");
			for(int i = 0;i < v02055List.size();i++){
				Pgv02055 v02055Bean = v02055List.get(i);
				try{
					tran = session.beginTransaction();
				
					call.registerOutParameter(1, OracleTypes.CURSOR);
					call.setBigDecimal(2,v02055Bean.getJsMin());
					call.setBigDecimal(3, v02055Bean.getJsMax());
					call.setBigDecimal(4, v02055Bean.getXzxs());
					call.setString(5, v02055Bean.getCd00002Czr());
					call.setString(6, v02055Bean.getFwlx());
					call.setString(7, v02055Bean.getSsgx());
					call.setString(8, v02055Bean.getSzqy());
					call.execute();
					rs = (ResultSet)call.getObject(1);
					if(null != rs && rs.next()){
						if(rs.getInt("flag") == 0){
							sResultCount++;
							v02055Bean.setCd00001Fwlx(rs.getString("TFWLX"));
							v02055Bean.setCd00001Szqy(rs.getString("SZQYID"));
							v02055Bean.setImpErrorMsg("");				
							tempList.add(v02055Bean);
							v02055.setOutList(tempList);
						}
					}
					tran.commit();
				}catch(Exception e){
					tran.rollback();
					sResultCount++;
					e.printStackTrace();
					v02055Bean.setImpErrorMsg(e.getMessage());
					tempList.add(v02055Bean);
					v02055.setOutList(tempList);
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
			
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally{
			getFree(rs, call, conn, session);
			if(sResultCount == 0){
				resultValue = 2;
				//WriteLogImp(v02055List.get(0).getSsgx(), "PGT02055", v02055List.get(0).getCd00002Czr(), "进深修正导入成功");
			}else if(sResultCount > 0 && fResultCount == 0){
				resultValue = 1;
				//WriteLogImp(v02055List.get(0).getSsgx(), "PGT02055", v02055List.get(0).getCd00002Czr(), "进深修正导入有异常");
			}
			v02055.setOutFlag(resultValue);
		}
		return v02055;
	}

	
	
	
	
	@Override
	public Pgv02055 ImportExcelDataA(ArrayList<Pgv02055> v02055List)
			throws Exception {
		Pgv02055 v02055 = new Pgv02055();
		ArrayList<Pgv02055> tempList = new ArrayList<Pgv02055>();
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		ResultSet rs = null;
		Integer sResultCount = 0;
		Integer fResultCount = 0;
		Integer resultValue = 0;
		
		try{
			session = getSession();
			conn = super.getConnection();
			
			call = conn.prepareCall("{call PGSP_ADDT02055A1(?,?,?,?,?,?,?,?,?,?)}");
			
			for(int i = 0;i < v02055List.size();i++){
				Pgv02055 v02055Bean = v02055List.get(i);
				try{
					tran = session.beginTransaction();
				
					call.registerOutParameter(1, OracleTypes.CURSOR);
					call.setBigDecimal(2,v02055Bean.getJsMin());
					call.setBigDecimal(3, v02055Bean.getJsMax());
					call.setBigDecimal(4, v02055Bean.getXzxs());
					call.setString(5, v02055Bean.getCd00002Czr());
					call.setString(6, v02055Bean.getFwlx());
					call.setString(7, v02055Bean.getSsgx());
					call.setString(8, v02055Bean.getSzqy());
					call.setString(9, v02055Bean.getXqnm());
					call.setString(10, v02055Bean.getDmh());
					call.execute();
					rs = (ResultSet)call.getObject(1);
					if(null != rs && rs.next()){
						
						if(rs.getInt("flag") == 0){
							sResultCount++;
							v02055Bean.setCd00001Fwlx(rs.getString("TFWLX"));
							v02055Bean.setCd00001Szqy(rs.getString("SZQYID"));
							v02055Bean.setCd02050Xqdm(rs.getString("XQDM"));
							v02055Bean.setDmhId(rs.getString("TDMH"));
							v02055Bean.setImpErrorMsg("");
							tempList.add(v02055Bean);
							v02055.setOutList(tempList);
						}
					}
					tran.commit();
				}catch(Exception e){
					tran.rollback();
					sResultCount++;
					e.printStackTrace();
					v02055Bean.setImpErrorMsg(e.getMessage());
					tempList.add(v02055Bean);
					v02055.setOutList(tempList);
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
			
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally{
			getFree(rs, call, conn, session);
			if(sResultCount == 0){
				resultValue = 2;
				//WriteLogImp(v02055List.get(0).getSsgx(), "PGT02055", v02055List.get(0).getCd00002Czr(), "进深修正导入成功");
			}else if(sResultCount > 0 && fResultCount == 0){
				resultValue = 1;
				//WriteLogImp(v02055List.get(0).getSsgx(), "PGT02055", v02055List.get(0).getCd00002Czr(), "进深修正导入有异常");
			}
			v02055.setOutFlag(resultValue);
		}
		return v02055;
	}
	
	
	
	
	
	@Override
	public boolean GetSelDeleteCommand(Pgt02055 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT020551(?,?,?)}");
			call.setString(1, bean.getChkDel());
			call.setString(2, bean.getCd00002Czr());
			call.setString(3, bean.getCd00001Ssgx());
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
	public boolean GetSelDeleteCommandA(Pgt02055 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02055A1(?,?,?)}");
			call.setString(1, bean.getChkDel());
			call.setString(2, bean.getCd00002Czr());
			call.setString(3, bean.getCd00001Ssgx());
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
