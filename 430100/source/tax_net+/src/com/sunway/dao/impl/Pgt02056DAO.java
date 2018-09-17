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

import com.sunway.dao.IPgt02056DAO;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FormatUtil;
import com.sunway.vo.Pgt02056;
import com.sunway.vo.Pgv02056;
/**
 * @category 物价指数修正
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02056DAO extends BaseDAO implements IPgt02056DAO {
	
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
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt02056 wjzs) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02056(?,?,?,?,?)}");
			call.setString(1, wjzs.getCd00001Szqy());
			call.setString(2, wjzs.getCd00001Szqylx());
			call.setString(3, wjzs.getCd00002Pssd());
			call.setString(4, wjzs.getCd00002Czr());
			call.setString(5, wjzs.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt10051DAO#GetInsertCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt02056 wjzs) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02056(?,?,?,?,?,?)}");
			call.setString(1, wjzs.getCd00001Szqy());
			call.setString(2, wjzs.getCd00002Pssd());
			call.setDouble(3, wjzs.getXzxs());
			call.setString(4, wjzs.getCd00002Czr());
			call.setString(5, wjzs.getNote());
			call.setString(6, wjzs.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt10051DAO#GetUpdateCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt02056 wjzs) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02056(?,?,?,?,?,?,?)}");
			call.setString(1, wjzs.getCd00001Szqylx());
			call.setString(2, wjzs.getCd00001Szqy());
			call.setString(3, wjzs.getCd00002Pssd());
			call.setDouble(4, wjzs.getXzxs());
			call.setString(5, wjzs.getCd00002Czr());
			call.setString(6, wjzs.getNote());
			call.setString(7, wjzs.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt10051DAO#LoadAll(com.sunway.vo.Pgv10051)
	 */
	
	@Override
	public ArrayList<Pgv02056> LoadAll(Pgv02056 wjzs) throws Exception {
		ArrayList<Pgv02056> listResult = new ArrayList<Pgv02056>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02056(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, wjzs.getPageIndex());
			call.setInt(3, wjzs.getPageSize());
			call.setString(4, wjzs.getCd00001Szqy());
			call.setDate(5, ConvertUtil.utilDateToSqlDate(wjzs.getPssd()));
			call.setString(6, wjzs.getSysSsgx());
			call.execute();
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
	 * @see com.sunway.dao.IPgt00352DAO#ExportGJFQSjcx(com.sunway.vo.Pgv00352)
	 */
	
	
	@Override
	public OutputStream ExportjyjgSjcx(Pgv02056 wjzs) throws Exception {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02056(?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, wjzs.getPageIndex());
			call.setInt(3, wjzs.getPageSize());
			call.setString(4, wjzs.getCd00001Szqy());
			call.setDate(5, ConvertUtil.utilDateToSqlDate(wjzs.getPssd()));
			call.setString(6, wjzs.getSysSsgx());
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
	          
				label = new Label(0, 0, "估价时点");
				sheet.addCell(label);	
				label = new Label(1, 0, "所在区域");
				sheet.addCell(label);	
				label = new Label(2, 0, "价格指数(%)");
				sheet.addCell(label);	          
				label = new Label(3, 0, "更新时间");
				sheet.addCell(label);
				label = new Label(4, 0, "操作人");
				sheet.addCell(label);	
			
				   // 写入数据
				while(null!=rs && rs.next()){
					Integer rowIndex = rs.getRow();
					label = new Label(0, rowIndex, rs.getString(CD00002PSSD));
					sheet.addCell(label);	
					label = new Label(1, rowIndex, rs.getString(SZQY));
					sheet.addCell(label);		
					label = new Label(2, rowIndex, rs.getString(XZXS));
					sheet.addCell(label);	
					label = new Label(3, rowIndex, FormatUtil.toYMDHMS(rs.getTimestamp(UPDDATE)));
					sheet.addCell(label);	
					label = new Label(4, rowIndex, rs.getString(CZR));
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
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv02056 SetVParameters(ResultSet rs) throws Exception {
		Pgv02056 e = new Pgv02056();
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setSzqy(rs.getString(SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setXzxs(rs.getDouble(XZXS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setCzr(rs.getString(CZR));
		e.setRecordCount(rs.getInt(TOTAL));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt02056 LoadByPrimaryKey(Pgt02056 wjzs) throws Exception {
		ArrayList<Pgt02056> listResult = new ArrayList<Pgt02056>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02056(?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, wjzs.getCd00001Szqy());
			call.setString(3, wjzs.getCd00001Szqylx());
			call.setString(4, wjzs.getCd00002Pssd());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetTParameters(rs));			
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, session);
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
	protected Pgt02056 SetTParameters(ResultSet rs) throws Exception {
		Pgt02056 e = new Pgt02056();
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setXzxs(rs.getDouble(XZXS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExecuteParamCopy(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean ExecuteParamCopy(Pgt02056 wjzs) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {	
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02056(?,?,?,?,?)}");
			call.setString(1, wjzs.getSpssd());
			call.setString(2, wjzs.getTpssd());
			call.setString(3, wjzs.getCd00001Szqy());
			call.setString(4, wjzs.getCd00002Czr());
			call.setString(5, wjzs.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt00357DAO#ImportExcelData(java.util.ArrayList)
	 */
	
	@Override
	public Pgv02056 ImportExcelData(ArrayList<Pgv02056> jyjgzsList) throws Exception{
		Pgv02056 v02056 = new Pgv02056();
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
			
			call = conn.prepareCall("{call PGSP_ADDT020561(?,?,?,?,?,?,?)}");
			for(int i=0; i<jyjgzsList.size(); i++){
				Pgv02056 jyjgzs = jyjgzsList.get(i);
				try {
					tran = session.beginTransaction();
					call.registerOutParameter(1, OracleTypes.CURSOR);
					// 传入输入参数
					call.setString(2, jyjgzs.getSzqy());
					call.setString(3, jyjgzs.getCd00002Pssd());
					call.setDouble(4, jyjgzs.getXzxs());
					call.setString(5, jyjgzs.getCd00002Czr());
					call.setString(6, jyjgzs.getNote());
					call.setString(7, jyjgzs.getCd00001Ssgx());
					call.execute();
					rs = (ResultSet) call.getObject(1); 
					if (null!=rs && rs.next()) {
						if (rs.getInt("FLAG") == 0) {
							sResultCount++;
							//标记哪一列字段错误
							jyjgzs.setSzqyId(rs.getString("SQZY"));
							jyjgzs.setCwxx("");
							//将数据封装到list
							v02056.getOutList().add(jyjgzs);
						}						
					}
					tran.commit();
				} catch (Exception e) {
					tran.rollback();
					sResultCount++;
					jyjgzs.setCwxx(e.getMessage());
					v02056.getOutList().add(jyjgzs);
					continue;
				} finally{
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
			
			throw e;
		}finally{
			getFree(rs, call, conn, session);
			if(sResultCount == 0)
				resultValue = 2;
			else if(sResultCount > 0)
				resultValue = 1;
			v02056.setOutFlag(resultValue);
		}
		return v02056;
	}
}
