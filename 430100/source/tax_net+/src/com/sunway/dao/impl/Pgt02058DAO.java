package com.sunway.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt02058DAO;
import com.sunway.util.ConvertUtil;
import com.sunway.util.Excel;
import com.sunway.util.FormatUtil;
import com.sunway.vo.Pgt02058;
import com.sunway.vo.Pgv02058;

/**
 * @category 商业法分区交易日期修正
 * @author LeiJia
 * @version 1.0
 *
 */
public class Pgt02058DAO extends BaseDAO implements IPgt02058DAO {
	
	private static final String CD00001SZQYLX = "cd_00001_szqylx";	//所在区域类型
	private static final String CD00001SZQY = "cd_00001_szqy";;		//所在区域编码
	private static final String SZQY =  "szqy";						//所在区域名称
	private static final String CD00002PSSD = "cd_00002_pssd";		//评税时点
	private static final String XZXS = "xzxs";						//修正系数
	private static final String UPDDATE="upddate";					//更改时间
	private static final String CD00002CZR = "cd_00002_czr";		//操作人编号	
	private static final String CZR = "czr";						//操作人
	private static final String NOTE = "note";						//备注信息
	private static final String TOTAL = "total";					//总纪录数
	private static final String ISTRUE = "istrue";
	private static final String TRUENM = "truenm";
	private static final String FWLX = "fwlx";                     // 房屋类型
	private static final String CD00001FWLX = "cd_00001_fwlx";
	private static final String CD02050XQDM = "cd_02050_xqdm";    //小区编码
	private static final String XQNM = "xqnm";         
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02058 wjzs) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02058(?,?,?)}");
			call.setString(1, wjzs.getId());
			//call.setString(2, wjzs.getCd00001Szqylx());
			//call.setString(3, wjzs.getCd00002Pssd());
			//call.setInt(4, wjzs.getIstrue());
			call.setString(2, wjzs.getCd00002Czr());
			call.setString(3, wjzs.getCd00001Ssgx());
			call.execute();
			tran.commit();
			bResult = true;
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetDeleteCommandA(Pgt02058 wjzs) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn =super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02058A(?,?,?)}");
			call.setString(1, wjzs.getId());
			//call.setString(2, wjzs.getCd00002Pssd());
			//call.setInt(3, wjzs.getIstrue());
			call.setString(2, wjzs.getCd00002Czr());
			call.setString(3, wjzs.getCd00001Ssgx());
			call.execute();
			tran.commit();
			bResult = true;
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetInsertCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt02058 wjzs) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn =super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02058(?,?,?,?,?,?,?,?,?)}");
			call.setString(1, wjzs.getCd00001Szqy());
			call.setString(2, wjzs.getCd00002Pssd());
			call.setDouble(3, wjzs.getXzxs());
			call.setString(4, wjzs.getCd00002Czr());
			call.setString(5, wjzs.getNote());
			call.setString(6, wjzs.getCd00001Ssgx());
			call.setInt(7, wjzs.getIstrue());
		    call.setInt(8, wjzs.getSfsc());
	        call.setString(9, wjzs.getCd00001Fwlx());
			
			call.execute();
			tran.commit();
			bResult = true;
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}
	
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetInsertCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetInsertCommandA(Pgt02058 wjzs) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn =super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02058A(?,?,?,?,?,?,?,?,?)}");
			call.setString(1, wjzs.getCd02050Xqdm());
			call.setString(2, wjzs.getCd00002Pssd());
			call.setDouble(3, wjzs.getXzxs());
			call.setString(4, wjzs.getCd00002Czr());
			call.setString(5, wjzs.getNote());
			call.setString(6, wjzs.getCd00001Ssgx());
			call.setInt(7, wjzs.getIstrue());
            call.setInt(8, wjzs.getSfsc());
            call.setString(9, wjzs.getCd00001Fwlx());
			call.execute();
			tran.commit();
			bResult = true;
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetUpdateCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt02058 wjzs) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn =super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02058(?,?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, wjzs.getCd00001Szqylx());
			call.setString(2, wjzs.getCd00001Szqy());
			call.setString(3, wjzs.getCd00002Pssd());
			call.setDouble(4, wjzs.getXzxs());
			call.setString(5, wjzs.getCd00002Czr());
			call.setString(6, wjzs.getNote());
			call.setString(7, wjzs.getCd00001Ssgx());
			call.setInt(8, wjzs.getIstrue());
			call.setString(9, wjzs.getId());
			call.setInt(10, wjzs.getSfsc());
            call.setString(11, wjzs.getCd00001Fwlx());
			call.execute();
			tran.commit();
			bResult = true;
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}
	
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetUpdateCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetUpdateCommandA(Pgt02058 wjzs) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn =super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02058A(?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, wjzs.getCd02050Xqdm());
			call.setString(2, wjzs.getCd00002Pssd());
			call.setDouble(3, wjzs.getXzxs());
			call.setString(4, wjzs.getCd00002Czr());
			call.setString(5, wjzs.getNote());
			call.setString(6, wjzs.getCd00001Ssgx());
			call.setInt(7, wjzs.getIstrue());
			call.setString(8, wjzs.getId());
		    call.setInt(9, wjzs.getSfsc());
            call.setString(10, wjzs.getCd00001Fwlx());
			call.execute();
			tran.commit();
			bResult = true;
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadAll(com.sunway.vo.Pgv10051)
	 */
	
	@Override
	public ArrayList<Pgv02058> LoadAll(Pgv02058 wjzs) throws Exception {
		ArrayList<Pgv02058> listResult = new ArrayList<Pgv02058>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		try {
			conn =super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02058(?,?,?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, wjzs.getPageIndex());
			call.setInt(3, wjzs.getPageSize());
			call.setString(4, wjzs.getCd00001Szqy());
			call.setDate(5, ConvertUtil.utilDateToSqlDate(wjzs.getPssd()));
			call.setString(6, wjzs.getSysSsgx());
			call.setInt(7, wjzs.getIstrue());
			call.setInt(8, wjzs.getSfsc());
			call.setString(9, wjzs.getCd00001Fwlx());
			call.execute();
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVParameters(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}
	
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadAll(com.sunway.vo.Pgv10051)
	 */
	
	@Override
	public ArrayList<Pgv02058> LoadAllA(Pgv02058 wjzs) throws Exception {
		ArrayList<Pgv02058> listResult = new ArrayList<Pgv02058>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			
			conn =super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02058A(?,?,?,?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, wjzs.getPageIndex());
			call.setInt(3, wjzs.getPageSize());
			call.setString(4, wjzs.getCd00001Szqy());
			call.setDate(5, ConvertUtil.utilDateToSqlDate(wjzs.getPssd()));
			call.setString(6, wjzs.getSysSsgx());
			call.setInt(7, wjzs.getIstrue());
			call.setString(8, wjzs.getCd02050Xqdm());
			call.setInt(9, wjzs.getSfsc());
			call.setString(10, wjzs.getCd00001Fwlx());
			call.execute();
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVParametersA(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv02058 SetVParameters(ResultSet rs) throws Exception {
		Pgv02058 e = new Pgv02058();
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setFwlx(rs.getString(FWLX));
		e.setSfsc(rs.getInt("sfsc"));
		e.setSzqy(rs.getString(SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setXzxs(rs.getDouble(XZXS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setCzr(rs.getString(CZR));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setIstrue(rs.getInt(ISTRUE));
		e.setTruenm(rs.getString(TRUENM));
		e.setId(rs.getString("id"));
		return e;
	}
	
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv02058 SetVParametersA(ResultSet rs) throws Exception {
		Pgv02058 e = new Pgv02058();
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setFwlx(rs.getString(FWLX));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setSfsc(rs.getInt("sfsc"));
		e.setSzqy(rs.getString(SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setXzxs(rs.getDouble(XZXS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setCzr(rs.getString(CZR));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setIstrue(rs.getInt(ISTRUE));
		e.setTruenm(rs.getString(TRUENM));
		e.setCd02050Xqdm(rs.getString(CD02050XQDM));
		e.setXqnm(rs.getString(XQNM));
		e.setXqdmhm(rs.getString("xqdmhm"));
		e.setId(rs.getString("id"));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt02058 LoadByPrimaryKey(Pgt02058 wjzs) throws Exception {
		ArrayList<Pgt02058> listResult = new ArrayList<Pgt02058>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			
			conn =super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02058(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, wjzs.getId());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetTParameters(rs));			
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return wjzs;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt02058 LoadByPrimaryKeyA(Pgt02058 wjzs) throws Exception {
		ArrayList<Pgt02058> listResult = new ArrayList<Pgt02058>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			
			conn =super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02058A(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, wjzs.getId());
			//call.setString(2, wjzs.getCd02050Xqdm());
			//call.setString(3, wjzs.getCd00002Pssd());
			//call.setInt(4, wjzs.getIstrue());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetTParametersA(rs));			
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return wjzs;
	}
	
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt02058 SetTParameters(ResultSet rs) throws Exception {
		Pgt02058 e = new Pgt02058();
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setSfsc(rs.getInt("sfsc"));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setXzxs(rs.getDouble(XZXS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setIstrue(rs.getInt(ISTRUE));
	    e.setId(rs.getString("id"));	  
		return e;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt02058 SetTParametersA(ResultSet rs) throws Exception {
		Pgt02058 e = new Pgt02058();
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
	    e.setCd00001Fwlx(rs.getString(CD00001FWLX));
	    e.setSfsc(rs.getInt("sfsc"));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setXzxs(rs.getDouble(XZXS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setIstrue(rs.getInt(ISTRUE));
		e.setCd02050Xqdm(rs.getString(CD02050XQDM));
		e.setXqnm(rs.getString(XQNM));
		e.setId(rs.getString("id"));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExecuteParamCopy(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean ExecuteParamCopy(Pgt02058 wjzs) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {	
			session = getSession();
			tran = session.beginTransaction();
			conn =super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02058(?,?,?,?,?)}");
			call.setString(1, wjzs.getSpssd());
			call.setString(2, wjzs.getTpssd());
			call.setString(3, wjzs.getCd00001Szqy());
			call.setString(4, wjzs.getCd00002Czr());
			call.setString(5, wjzs.getCd00001Ssgx());
			call.execute();
			tran.commit();
			bResult = true;
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	
	@Override
	public Pgt02058 FormulaVal(Pgt02058 wjzs) throws Exception {
		Pgt02058 t02058 = new Pgt02058();
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;

		try{
			session = getSession();
			
			conn =super.getConnection();
			call = conn.prepareCall("call PGSP_CZ_EXPRESSION(?,?,?,?,?,?)");
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			call.registerOutParameter(2, OracleTypes.FLOAT);
			call.registerOutParameter(3, OracleTypes.FLOAT);
			call.registerOutParameter(4, OracleTypes.FLOAT);
			call.setString(5, wjzs.getCd00001Szqy());
			call.setString(6,wjzs.getCd00002Pssd());
			call.execute();			
			t02058.setXzxs(Double.valueOf(call.getFloat(2)));
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return t02058;		
	}

	
	@Override
	public OutputStream ExportJYSJ(Pgv02058 v02058) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		WritableWorkbook workbook = null;
		Connection conn = null;
		
		CallableStatement call = null;
		ResultSet rs = null;
		try {
			strBufResult =new ByteArrayOutputStream();
			
			conn =super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02058(?,?,?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, v02058.getPageIndex());
			call.setInt(3, v02058.getPageSize());
			call.setString(4, v02058.getCd00001Szqy());
			call.setDate(5, ConvertUtil.utilDateToSqlDate(v02058.getPssd()));
			call.setString(6, v02058.getSysSsgx());
			call.setInt(7, v02058.getIstrue());
			call.setInt(8, v02058.getSfsc());
			call.setString(9, v02058.getCd00001Fwlx());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			if(rs != null){
				Label label;
				workbook = Workbook.createWorkbook(strBufResult);
				WritableSheet sheet = workbook.createSheet("交易日期修正",0);
				WritableCellFormat wcf =Excel.getExcelTitleStyle();
				label = new Label(0, 0, "所在区域", wcf);
				sheet.addCell(label);
				label = new Label(1, 0, "房屋类型", wcf);
				sheet.addCell(label);
				label = new Label(2, 0, "时间", wcf);
				sheet.addCell(label);
				label = new Label(3, 0, "价格指数(%)", wcf);
				sheet.addCell(label);
				label = new Label(4, 0, "更新时间", wcf);
				sheet.addCell(label);
				label = new Label(5, 0, "操作人", wcf);
				sheet.addCell(label);
				label = new Label(6, 0, "备注", wcf);
				sheet.addCell(label);
				
				while(rs != null && rs.next()){
					Integer rowIndex = rs.getRow();
					
					label = new Label(0, rowIndex, rs.getString(SZQY));
					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString(FWLX));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(CD00002PSSD));
					sheet.addCell(label);				
					label = new Label(3, rowIndex, rs.getString(XZXS));
					sheet.addCell(label);				
					label = new Label(4, rowIndex, FormatUtil.toYMDHMS(rs.getTimestamp(UPDDATE)));
					sheet.addCell(label);
					label = new Label(5, rowIndex, rs.getString(CZR));
					sheet.addCell(label);
					label = new Label(6, rowIndex, rs.getString(NOTE));
				}
				
				workbook.write();
				//workbook.close();
			}
			//填写导出日志
			//WriteLogExp(v02058.getSysSsgx(), "PGT02058", v02058.getCd00002Czr(), "交易日期修正导出成功");
		}catch(Exception e){
			if(null != strBufResult){
				try{
					strBufResult.close();
				}catch(Exception e1){}
			}
			e.printStackTrace();
			throw e;
		}finally{
			if(null != workbook){
				try{
					workbook.close();
				}catch(Exception e){
				}
			}
			getFree(rs, call, conn, null);
		}
		return strBufResult;
	}
	
	
	@Override
	public OutputStream ExportJYSJA(Pgv02058 v02058) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		WritableWorkbook workbook=null;
		Connection conn = null;
		
		CallableStatement call = null;
		ResultSet rs = null;
		try {
			strBufResult =new ByteArrayOutputStream();
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02058A(?,?,?,?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, v02058.getPageIndex());
			call.setInt(3, v02058.getPageSize());
			call.setString(4, v02058.getCd00001Szqy());
			call.setDate(5, ConvertUtil.utilDateToSqlDate(v02058.getPssd()));
			call.setString(6, v02058.getSysSsgx());
			call.setInt(7, v02058.getIstrue());
			call.setString(8, v02058.getCd02050Xqdm());
			call.setInt(9, v02058.getSfsc());
			call.setString(10, v02058.getCd00001Fwlx());
			call.execute();
			rs = (ResultSet)call.getObject(1);			
			if(rs != null){
				Label label;
				workbook = Workbook.createWorkbook(strBufResult);
				WritableSheet sheet = workbook.createSheet("交易日期修正",0);
				WritableCellFormat wcf =Excel.getExcelTitleStyle();
				
				label = new Label(0, 0, "所在区域",wcf);
				sheet.addCell(label);
				label = new Label(1, 0, "代码号",wcf);
				sheet.addCell(label);
				label = new Label(2, 0, "小区名称",wcf);
				sheet.addCell(label);
				label = new Label(3, 0, "房屋类型",wcf);
				sheet.addCell(label);
				label = new Label(4, 0, "时间",wcf);
				sheet.addCell(label);
				label = new Label(5, 0, "价格指数(%)",wcf);
				sheet.addCell(label);
				label = new Label(6, 0, "更新时间",wcf);
				sheet.addCell(label);
				label = new Label(7, 0, "操作人",wcf);
				sheet.addCell(label);
				label = new Label(8, 0, "备注",wcf);
				sheet.addCell(label);
				
				while(rs != null && rs.next()){
					Integer rowIndex = rs.getRow();
					
					label = new Label(0, rowIndex, rs.getString(SZQY));
					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString("xqdmhm"));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(XQNM));
					sheet.addCell(label);
					label = new Label(3, rowIndex, rs.getString(FWLX));
					sheet.addCell(label);
					label = new Label(4, rowIndex, rs.getString(CD00002PSSD));
					sheet.addCell(label);
					label = new Label(5, rowIndex, rs.getString(XZXS));
					sheet.addCell(label);
					label = new Label(6, rowIndex, FormatUtil.toYMDHMS(rs.getTimestamp(UPDDATE)));
					sheet.addCell(label);
					label = new Label(7, rowIndex, rs.getString(CZR));
					sheet.addCell(label);
					label = new Label(8, rowIndex, rs.getString(NOTE));
				}
				
				workbook.write();
				//workbook.close();
			}
			//填写导出日志
			//WriteLogExp(v02058.getSysSsgx(), "PGT02058", v02058.getCd00002Czr(), "交易日期修正导出成功");
		}catch(Exception e){
			if(null != strBufResult){
				try{
					strBufResult.close();
				}catch(Exception e1){}
			}
			e.printStackTrace();
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
	
	
	
	protected String formatDouble(String value){
		NumberFormat ddf1 = NumberFormat.getNumberInstance(); 
		ddf1.setMaximumFractionDigits(2); 
		return ddf1.format(Double.valueOf(value));
	}

	
	@Override
	public Pgv02058 ImportExcelData(ArrayList<Pgv02058> v02058List)
			throws Exception {
		Pgv02058 v02058 = new Pgv02058();
		ArrayList<Pgv02058> tempList = new ArrayList<Pgv02058>();
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		Transaction tran = null;
		ResultSet rs = null;
		Integer sResultCount = 0;
		Integer fResultCount = 0;
		Integer resultValue = 0;
		
		try{
			session = getSession();
			conn = super.getConnection();
			
			call = conn.prepareCall("{call PGSP_ADDT020581(?,?,?,?,?,?,?,?)}");
			
			for(int i = 0;i < v02058List.size();i++){
				Pgv02058 v02058Bean = v02058List.get(i);
				try{
					tran = session.beginTransaction();
				
					String[] buffer = FormatUtil.toYYYYMM(v02058Bean.getPssd()).split("-");
					call.registerOutParameter(1, OracleTypes.CURSOR);
					call.setString(2, (buffer[0]+buffer[1]));
					call.setDouble(3, v02058Bean.getXzxs());
					call.setString(4, v02058Bean.getCd00002Czr());
					call.setString(5, v02058Bean.getCd00001Ssgx());
					call.setString(6, v02058Bean.getSzqy());
					call.setInt(7, v02058Bean.getSfsc());
					call.setString(8, v02058Bean.getFwlx());
					call.execute();
					rs = (ResultSet)call.getObject(1);
					if(null != rs && rs.next()){
						if(rs.getInt("flag") == 0){
							sResultCount++;
							v02058Bean.setCd00001Szqy(rs.getString("SZQYID"));
							v02058Bean.setCd00001Fwlx(rs.getString("fwlx"));
							v02058Bean.setImpErrorMsg("");

							tempList.add(v02058Bean);
							v02058.setOutList(tempList);
						}
					}
					tran.commit();
				}catch(Exception e){
					tran.rollback();
					e.printStackTrace();					
					sResultCount++;
					e.printStackTrace();
					v02058Bean.setImpErrorMsg(e.getMessage());
					tempList.add(v02058Bean);
					v02058.setOutList(tempList);
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
				//WriteLogImp(v02058List.get(0).getCd00001Ssgx(), "PGT02058", v02058List.get(0).getCd00002Czr(), "交易日期修正导入成功");
			}else if(sResultCount > 0 && fResultCount == 0){
				resultValue = 1;
				//WriteLogImp(v02058List.get(0).getCd00001Ssgx(), "PGT02058", v02058List.get(0).getCd00002Czr(), "交易日期修正导入有异常");
			}
			v02058.setOutFlag(resultValue);
		}
		return v02058;
	}
	
	
	
	
	
	
	@Override
	public Pgv02058 ImportExcelDataA(ArrayList<Pgv02058> v02058List)
			throws Exception {
		Pgv02058 v02058 = new Pgv02058();
		ArrayList<Pgv02058> tempList = new ArrayList<Pgv02058>();
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		Transaction tran = null;
		ResultSet rs = null;
		Integer sResultCount = 0;
		Integer fResultCount = 0;
		Integer resultValue = 0;
		
		try{
			session = getSession();
			conn = super.getConnection();
			
			call = conn.prepareCall("{call PGSP_ADDT02058A1(?,?,?,?,?,?,?,?,?,?)}");
			
			for(int i = 0;i < v02058List.size();i++){
				Pgv02058 v02058Bean = v02058List.get(i);
				try{
					tran = session.beginTransaction();
				
					String[] buffer = FormatUtil.toYYYYMM(v02058Bean.getPssd()).split("-");
					call.registerOutParameter(1, OracleTypes.CURSOR);
					call.setString(2, (buffer[0]+buffer[1]));
					call.setDouble(3, v02058Bean.getXzxs());
					call.setString(4, v02058Bean.getCd00002Czr());
					call.setString(5, v02058Bean.getCd00001Ssgx());
					call.setString(6, v02058Bean.getSzqy());
					call.setString(7, v02058Bean.getXqnm());
					call.setString(8, v02058Bean.getDmh());
					call.setString(9, v02058Bean.getFwlx());
					call.setInt(10, v02058Bean.getSfsc());
					call.execute();
					rs = (ResultSet)call.getObject(1);
					if(null != rs && rs.next()){
						if(rs.getInt("flag") == 0){
							sResultCount++;
							v02058Bean.setCd00001Szqy(rs.getString("SZQYID"));
							v02058Bean.setCd02050Xqdm(rs.getString("XQDM"));
							v02058Bean.setDmhId(rs.getString("TDMH"));
							v02058Bean.setCd00001Fwlx(rs.getString("TFWLX"));
							v02058Bean.setImpErrorMsg("");							
							tempList.add(v02058Bean);
							v02058.setOutList(tempList);
						}
					}
					tran.commit();
				}catch(Exception e){
					e.printStackTrace();
					tran.rollback();
					sResultCount++;
					e.printStackTrace();
					v02058Bean.setImpErrorMsg(e.getMessage());
					tempList.add(v02058Bean);
					v02058.setOutList(tempList);
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
				//WriteLogImp(v02058List.get(0).getCd00001Ssgx(), "PGT02058", v02058List.get(0).getCd00002Czr(), "交易日期修正导入成功");
			}else if(sResultCount > 0 && fResultCount == 0){
				resultValue = 1;
				//WriteLogImp(v02058List.get(0).getCd00001Ssgx(), "PGT02058", v02058List.get(0).getCd00002Czr(), "交易日期修正导入有异常");
			}
			v02058.setOutFlag(resultValue);
		}
		return v02058;
	}
	
	

	
	@Override
	public boolean GetSelDeleteCommand(Pgt02058 wjzs) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT020581(?,?,?)}");
			call.setString(1, wjzs.getChkDel());
			call.setString(2, wjzs.getCd00002Czr());
			call.setString(3, wjzs.getCd00001Ssgx());
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
	public boolean GetSelDeleteCommandA(Pgt02058 wjzs) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02058A1(?,?,?)}");
			call.setString(1, wjzs.getChkDel());
			call.setString(2, wjzs.getCd00002Czr());
			call.setString(3, wjzs.getCd00001Ssgx());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			e.printStackTrace();
			tran.rollback();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return bResult;
	}

	
	@Override
	public Pgt02058 FormulaVal_JQ(Pgt02058 wjzs) throws Exception {
		Pgt02058 t02058 = new Pgt02058();
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("call PGSP_CZ_EXPRESSION_JQ(?,?,?,?,?,?,?)");
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			call.registerOutParameter(2, OracleTypes.FLOAT);
			call.setInt(3, wjzs.getQz1());
			call.setInt(4, wjzs.getQz2());
			call.setInt(5, wjzs.getQz3());
			call.setString(6, wjzs.getCd00001Szqy());
			call.setString(7,wjzs.getCd00002Pssd());
			call.execute();			
			t02058.setXzxs(Double.valueOf(call.getFloat(2)));
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return t02058;		
	}

	
	@Override
	public Pgt02058 FormulaVal_XQ(Pgt02058 wjzs) throws Exception {
		Pgt02058 t02058 = new Pgt02058();
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("call PGSP_CZ_EXPRESSION_XQ(?,?,?,?,?,?)");
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			call.registerOutParameter(2, OracleTypes.FLOAT);
			call.registerOutParameter(3, OracleTypes.FLOAT);
			call.registerOutParameter(4, OracleTypes.FLOAT);
			call.setString(5, wjzs.getCd02050Xqdm());
			call.setString(6,wjzs.getCd00002Pssd());
			call.execute();			
			t02058.setXzxs(Double.valueOf(call.getFloat(2)));
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return t02058;	
	}

	
	@Override
	public Pgt02058 FormulaVal_JQ_XQ(Pgt02058 wjzs) throws Exception {
		Pgt02058 t02058 = new Pgt02058();
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("call PGSP_CZ_EXPRESSION_JQ_XQ(?,?,?,?,?,?,?)");
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			call.registerOutParameter(2, OracleTypes.FLOAT);
			call.setInt(3, wjzs.getQz1());
			call.setInt(4, wjzs.getQz2());
			call.setInt(5, wjzs.getQz3());
			call.setString(6, wjzs.getCd02050Xqdm());
			call.setString(7,wjzs.getCd00002Pssd());
			call.execute();			
			t02058.setXzxs(Double.valueOf(call.getFloat(2)));
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return t02058;		
	}



	
	@Override
	public Pgt02058 createByAjax(Pgt02058 t02058) throws Exception {
		ArrayList<Pgt02058> resultList = new ArrayList<Pgt02058>();
		Connection conn = null;
		
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT020581(?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, t02058.getCd00001Szqy());
			call.setString(3, t02058.getCd00002Pssd());
			call.setInt(4, t02058.getIstrue());
			call.setString(5, t02058.getFwlx());
			call.setInt(6, t02058.getSfsc());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				resultList.add(SetTAjaxParameters(rs, false));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		if(null != resultList && resultList.size() > 0){
			return resultList.get(0);
		}else{
			return t02058;
		}
	}
	
	
	@Override
	public Pgt02058 createByAjaxA(Pgt02058 v02058) throws Exception {
		ArrayList<Pgt02058> resultList = new ArrayList<Pgt02058>();
		Connection conn = null;
		
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02058A1(?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, v02058.getCd02050Xqdm());
			call.setString(3, v02058.getCd00002Pssd());
			call.setInt(4, v02058.getIstrue());
			call.setString(5, v02058.getFwlx());
			call.setInt(6, v02058.getSfsc());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				resultList.add(SetTTAjaxParameters(rs, true));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		if(null != resultList && resultList.size() > 0){
			return resultList.get(0);
		}else{
			return v02058;
		}
	}
	
	protected Pgv02058 SetAjaxParameters(ResultSet rs, Boolean isXQ)throws Exception{
		Pgv02058 e = new Pgv02058();
		e.setXzxs(ConvertUtil.toDouble(rs.getString(XZXS)));
		e.setNote(rs.getString(NOTE));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setId(rs.getString("id"));
		if(isXQ){
			e.setCd02050Xqdm(rs.getString(CD02050XQDM));
		}
		e.setIstrue(rs.getInt(ISTRUE));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		
		return e;
	}
	protected Pgt02058 SetTTAjaxParameters(ResultSet rs, Boolean isXQ)throws Exception{
		Pgt02058 e = new Pgt02058();
		e.setXzxs(rs.getDouble(XZXS));
		e.setNote(rs.getString(NOTE));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setId(rs.getString("id"));
		if(isXQ){
			e.setCd02050Xqdm(rs.getString(CD02050XQDM));
		}
		e.setIstrue(rs.getInt(ISTRUE));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		
		return e;
	}
	protected Pgt02058 SetTAjaxParameters(ResultSet rs, Boolean isXQ)throws Exception{
		Pgt02058 e = new Pgt02058();
		e.setXzxs(rs.getDouble(XZXS));
		e.setNote(rs.getString(NOTE));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setId(rs.getString("id"));
		if(isXQ){
			e.setCd02050Xqdm(rs.getString(CD02050XQDM));
		}
		e.setIstrue(rs.getInt(ISTRUE));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		
		return e;
	}
	
	@Override
	public Pgt02058 FormulaVal_CS(Pgt02058 wjzs) throws Exception {
		Pgt02058 t02058 = new Pgt02058();
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_EXPRESSION_CS(?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.DOUBLE);
			call.registerOutParameter(2, OracleTypes.DOUBLE);
			call.registerOutParameter(3, OracleTypes.DOUBLE);
			call.registerOutParameter(4, OracleTypes.DOUBLE);
			call.setString(5, wjzs.getCd00001Szqy());
			call.setString(6, wjzs.getCd00002Pssd());
			call.execute();
			t02058.setCs1(call.getDouble(1));
			t02058.setCs2(call.getDouble(2));
			t02058.setCs3(call.getDouble(3));
			t02058.setCs4(call.getDouble(4));
		}catch(Exception e){
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return t02058;
	}


	
	@Override
	public Pgt02058 FormulaVal_CS_XQ(Pgt02058 wjzs) throws Exception {
		Pgt02058 t02058 = new Pgt02058();
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_EXPRESSION_CS_XQ(?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.DOUBLE);
			call.registerOutParameter(2, OracleTypes.DOUBLE);
			call.registerOutParameter(3, OracleTypes.DOUBLE);
			call.registerOutParameter(4, OracleTypes.DOUBLE);
			call.setString(5, wjzs.getCd02050Xqdm());
			call.setString(6, wjzs.getCd00002Pssd());
			call.execute();
			t02058.setCs1(call.getDouble(1));
			t02058.setCs2(call.getDouble(2));
			t02058.setCs3(call.getDouble(3));
			t02058.setCs4(call.getDouble(4));
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return t02058;
	}
}
