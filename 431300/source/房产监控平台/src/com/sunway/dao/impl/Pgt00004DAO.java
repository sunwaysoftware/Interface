package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt00004DAO;
import com.sunway.util.Common;
import com.sunway.vo.Pgv00004;
import com.sunway.vo.Pgt00004;
import java.io.ByteArrayOutputStream;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Label;
import jxl.Workbook;
import java.io.OutputStream;

/**
 * 单层工业厂房跨数修正系数
 * @author LeiJia
 */

public class Pgt00004DAO extends BaseDAO implements IPgt00004DAO {
	private static final String JS = "JS";	//简述
	private static final String XS = "XS";	//详述
	private static final String UPDDATE="upddate";					//更改时间
	private static final String CD00002CZR = "cd_00002_czr";		//操作人编号	
	private static final String CZR = "czr";						//操作人
	private static final String RID = "rid";						//行号
	private static final String TOTAL = "total";					//总纪录数	
	private static final String ID = "id";						//行号
	@Override
	public boolean GetDeleteCommand(Pgt00004 rjl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00004(?,?)}");
			//传入输入参数
			call.setString(1, rjl.getId());
			call.setString(2, rjl.getCd00002Czr());
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
	 * @see com.sunway.dao.IPgt00004DAO#GetDeleteImpCommand(com.sunway.vo.Pgv00004)
	 */
	
	public boolean GetDeleteImpCommand(Pgv00004 rjl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT000041(?,?)}");
			//传入输入参数
			call.setString(1, rjl.getIds());
			call.setString(2, rjl.getCd00002Czr());
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
	public boolean GetInsertCommand(Pgt00004 rjl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00004(?,?,?)}");
			//传入输入参数
			call.setString(1, rjl.getJs());
			call.setString(2, rjl.getXs());
			call.setString(3, rjl.getCd00002Czr());
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
	public boolean GetUpdateCommand(Pgt00004 rjl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00004(?,?,?,?)}");
			//传入输入参数
			call.setString(1, rjl.getId());
			call.setString(2, rjl.getJs());
			call.setString(3, rjl.getXs());
			call.setString(4, rjl.getCd00002Czr());
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
	public ArrayList<Pgv00004> LoadAll(Pgv00004 czl) throws Exception {
		ArrayList<Pgv00004> listResult = new ArrayList<Pgv00004>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00004(?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, czl.getPageIndex());
			call.setInt(3, czl.getPageSize());
			call.setString(4, czl.getJs());
			call.setString(5, czl.getXs());
			//call.setString(6, czl.getCd00002Czr());
			call.execute();
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn);
		}
		return listResult;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00004 SetVParameters(ResultSet rs) throws Exception {
		Pgv00004 e = new Pgv00004();
		e.setId(rs.getString(ID));
		e.setJs(rs.getString(JS));
		e.setXs(rs.getString(XS));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCzr(rs.getString(CZR));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt00004 LoadByPrimaryKey(Pgt00004 rjl) throws Exception {
		ArrayList<Pgt00004> listResult = new ArrayList<Pgt00004>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00004(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, rjl.getId());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetTParameters(rs));			
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return rjl;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00004 SetTParameters(ResultSet rs) throws Exception {
		Pgt00004 e = new Pgt00004();
		e.setId(rs.getString(ID));
		e.setJs(rs.getString(JS));
		e.setXs(rs.getString(XS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		return e;
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#ImportExcelData(java.util.ArrayList)
	 */
	
	public Pgv00004 ImportExcelData(ArrayList<Pgv00004> ebList) throws Exception {
		Pgv00004 Pgv00004 = new Pgv00004();
		ArrayList<Pgv00004> tempList = new ArrayList<Pgv00004>();
		Integer resultValue = 0;
		Integer sResultCount = 0;
		Integer fResultCount = 0;
		
		Session session = null;
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		Transaction tran = null;
		try{
			session = getSession();
			conn = super.getConnection();
			
			
			for(int i=0; i<ebList.size(); i++){
				tran = session.beginTransaction();
				call = conn.prepareCall("{call PGSP_ADDT000041(?,?,?,?)}");
				Pgv00004 bean = ebList.get(i);
				try {
					//注册输出参数
					call.registerOutParameter(1, OracleTypes.CURSOR);
					//注册输入参数
					call.setString(2, bean.getJs());
					call.setString(3, bean.getXs());
					call.setString(4, bean.getCd00002Czr());
					call.execute();
					
					rs = (ResultSet) call.getObject(1); 
					if (null!=rs && rs.next()) {
						if (rs.getInt("flag") == 0) {
							sResultCount++;
							//标记哪列字段错误
							bean.setImpErrorMsg("如若无错误提示，请确定该数据在数据库中不存在。");
							//将数据封装到list
							tempList.add(bean);
							Pgv00004.setOutList(tempList);
						}
					}
					tran.commit();
				} catch (Exception e) {
					tran.rollback();
					sResultCount++;
					e.printStackTrace();
					bean.setImpErrorMsg(e.getMessage());
					//将数据封装到list
					tempList.add(bean);
					Pgv00004.setOutList(tempList);
					continue;
				}	finally{
					if(null != call){
						call.close();
					}
					if(null != rs){
						rs.close();
					}
				}
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			getFree(call, conn, session);
			if(sResultCount == 0){
				resultValue = 2;
				//WriteLogImp(ebList.get(0).getCd00001Ssgx(), "PGT00004", ebList.get(0).getCd00002Czr(), "工业厂房跨数修正系数数据导入成功");
			}
			else if(sResultCount > 0 && fResultCount == 0){
				resultValue = 1;
				//WriteLogImp(ebList.get(0).getCd00001Ssgx(), "PGT00004", ebList.get(0).getCd00002Czr(), "工业厂房跨数修正系数数据导入有异常");
			}
			Pgv00004.setExportOutCome(resultValue);
		}
		return Pgv00004;
	}
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExportDjxxSjcx(com.sunway.vo.Pgv10051)
	 */
	
	@Override
	public OutputStream ExportRJLxtwh(Pgv00004 v00004) throws Exception {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Integer i = 0;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00004(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v00004.getPageIndex());
			call.setInt(3, v00004.getPageSize());
			call.setString(4, v00004.getJs());
			call.setString(5, v00004.getXs());
			call.setString(6, v00004.getCd00002Czr());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			if(null!=rs){
				// 创建excel对象
		        Label label;   
		        WritableWorkbook workbook; 
	            workbook = Workbook.createWorkbook(strBufResult);   
	            WritableSheet sheet = workbook.createSheet("免税政策维护", 0);
	            // 写入标头	            
				label = new Label(i++, 0, "详述");
				sheet.addCell(label);
				label = new Label(i++, 0, "简述");
				sheet.addCell(label);	
				label = new Label(i++, 0, "更新时间");
				sheet.addCell(label);	
				label = new Label(i++, 0, "操作人");
				sheet.addCell(label);
	            // 写入数据
				while(null!=rs && rs.next()){
					i=0;
					Integer rowIndex = rs.getRow();
					label = new Label(i++, rowIndex, rs.getString(JS));
					sheet.addCell(label);		
					label = new Label(i++, rowIndex,  rs.getString(XS));
					sheet.addCell(label);	
					label = new Label(i++, rowIndex, Common.convertTimestampToString( rs.getTimestamp(UPDDATE)));
					sheet.addCell(label);		
					label = new Label(i++, rowIndex, rs.getString(CZR));
					sheet.addCell(label);	
				}
	            workbook.write();   
	            workbook.close(); 
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn);
		}
		return strBufResult;
	}
	@Override
	public ArrayList<Pgt00004> LoadAllMsZcYj() throws Exception {
		
		ArrayList<Pgt00004> listResult = new ArrayList<Pgt00004>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT000041(?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVMSZCYJParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn);
		}
		return listResult;
	}
	protected Pgt00004 SetVMSZCYJParameters(ResultSet rs) throws Exception {
		Pgt00004 e = new Pgt00004();
		e.setJs(rs.getString(JS));
		e.setId(rs.getString(ID));
		return e;
	}
}
