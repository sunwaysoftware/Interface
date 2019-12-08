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

import com.sunway.dao.IPgt00306DAO;
import com.sunway.util.Common;
import com.sunway.vo.Pgv00306;

/**
 * 楼房信息
 * @author LiuYang
 *
 */
public class Pgt00306DAO extends BaseDAO implements IPgt00306DAO {
	
	private static final String ID = "id";							//流水号
	private static final String CD00352XQDM = "cd_00352_xqdm";		//小区代码
	private static final String LH = "lh";							//楼号
	private static final String ZLC = "zlc";						//总楼层
	private static final String DYGS = "dygs";						//单元个数
	private static final String UPDDATE = "upddate";				//更新时间
	private static final String CD00002CZR = "cd_00002_czr";		//操作人代码
	private static final String NOTE = "note";						//备注
	private static final String XQNM = "xqnm";						//小区名称	
	private static final String XQBM = "xqbm";						//小区别名
	private static final String SZQY = "szqy";						//所在区域
	private static final String PARENTDM = "parentdm";				//上级区代码
	private static final String CD00001SZQY = "cd_00001_szqy";		//所在区域代码
	private static final String CZR = "czr";						//操作人
	private static final String TOTAL = "total";
	private static final String RID = "rid";
	private static final String CLH = "clh";						//测量号
//    private static final String XQDMHM = "xqdmhm";
	
	
	@Override
	public ArrayList<Pgv00306> LoadAll(Pgv00306 v00306) throws Exception {
		ArrayList<Pgv00306> resultList = new ArrayList<Pgv00306>();
		Connection conn = null;
		Session session = null;
		ResultSet rs = null;
		CallableStatement call = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00306(?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v00306.getPageIndex());
			call.setInt(3, v00306.getPageSize());
			call.setString(4, v00306.getCd00001Szqy());
			call.setString(5, v00306.getCd00001Ssgx());
			call.setString(6, v00306.getZcdzl());
			call.setString(7, v00306.getXqnm());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				resultList.add(SetParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return resultList;
	}
	
	/**
	 * 装载数据
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	protected Pgv00306 SetParameters(ResultSet rs)throws Exception{
		Pgv00306 e = new Pgv00306();
		e.setId(rs.getString(ID));
		e.setCd00352Xqdm(rs.getString(CD00352XQDM));
		e.setLh(rs.getString(LH));
		e.setZlc(rs.getInt(ZLC));
		e.setDygs(rs.getInt(DYGS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setXqnm(rs.getString(XQNM));
		e.setXqbm(rs.getString(XQBM));
		e.setSzqy(rs.getString(SZQY));
		e.setParentdm(rs.getString(PARENTDM));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCzr(rs.getString(CZR));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		//e.setXqdmhm(rs.getString("XQDMHM"));
		e.setClh(rs.getString(CLH));
		return e;
	}

	
	/**
	 * 装载数据
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	protected Pgv00306 SetParametersA(ResultSet rs)throws Exception{
		Pgv00306 e = new Pgv00306();
		e.setId(rs.getString(ID));
		e.setCd00352Xqdm(rs.getString(CD00352XQDM));
		e.setLh(rs.getString(LH));
		e.setZlc(rs.getInt(ZLC));
		e.setDygs(rs.getInt(DYGS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setXqnm(rs.getString(XQNM));
		e.setXqbm(rs.getString(XQBM));
		e.setSzqy(rs.getString(SZQY));
		e.setParentdm(rs.getString(PARENTDM));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCzr(rs.getString(CZR));
		e.setClh(rs.getString(CLH));
		//e.setRecordCount(rs.getInt(TOTAL));
		//e.setRecordIndex(rs.getInt(RID));
		return e;
	}
	
	
	
	@Override
	public Pgv00306 LoadByPrimaryKey(Pgv00306 v00306) throws Exception {
		ArrayList<Pgv00306> resultList = new ArrayList<Pgv00306>();
		Connection conn = null;
		Session session= null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00306(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, v00306.getId());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				resultList.add(SetParametersA(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		if(null != resultList && resultList.size() > 0){
			return resultList.get(0);
		}else{
			return v00306;
		}
	}

	
	
	
	@Override
	public boolean GetInsertCommand(Pgv00306 v00306) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00306(?,?,?,?,?,?,?,?)}");
			call.setString(1, v00306.getCd00352Xqdm());
			call.setString(2, v00306.getLh());
			call.setInt(3, 0);
			call.setInt(4, 0);
			call.setString(5, v00306.getCd00002Czr());
			call.setString(6, v00306.getNote());
			call.setString(7, v00306.getCd00001Ssgx());
			call.setString(8, v00306.getClh());
			
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
	
	
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetUpdateCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgv00306 v00306) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00306(?,?,?,?,?,?,?,?,?)}");
			call.setString(1, v00306.getId());
			call.setString(2, v00306.getCd00352Xqdm());
			call.setString(3, v00306.getLh());
			call.setInt(4, 0);
			call.setInt(5, 0);
			call.setString(6, v00306.getCd00002Czr());
			call.setString(7, v00306.getNote());
			call.setString(8, v00306.getCd00001Ssgx());
			call.setString(9, v00306.getClh());
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
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgv00306 v00306) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00306(?,?,?)}");
			call.setString(1, v00306.getId());
			call.setString(2, v00306.getCd00002Czr());
			call.setString(3, v00306.getCd00001Ssgx());
			
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
	public OutputStream ExportT00306(Pgv00306 v00306) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		ResultSet rs = null;
		WritableWorkbook workbook = null;
		try {
			strBufResult = new ByteArrayOutputStream();
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00306(?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v00306.getPageIndex());
			call.setInt(3, v00306.getPageSize());
			call.setString(4, v00306.getCd00001Szqy());
			call.setString(5, v00306.getCd00001Ssgx());
			call.setString(6, v00306.getZcdzl());
			call.setString(7, v00306.getXqnm());
			call.execute();
			
			rs = (ResultSet)call.getObject(1);
			if(rs != null){
				Label label;
				workbook = Workbook.createWorkbook(strBufResult);
				WritableSheet sheet = workbook.createSheet("楼房信息", 0);
				WritableCellFormat wcf =Common.getExcelTitleStyle();
				
				label = new Label(0, 0, "所在区域",wcf);
				sheet.addCell(label);
//				label = new Label(1, 0, "代码号",wcf);
//				sheet.addCell(label);
				label = new Label(1, 0, "小区名称",wcf);
				sheet.addCell(label);
				label = new Label(2, 0, "楼号",wcf);
				sheet.addCell(label);
//				label = new Label(3, 0, "总楼层",wcf);
//				sheet.addCell(label);
//				label = new Label(4, 0, "单元个数",wcf);
//				sheet.addCell(label);
				label = new Label(3, 0, "更新时间",wcf);
				sheet.addCell(label);
				label = new Label(4, 0, "操作人",wcf);
				sheet.addCell(label);
				label = new Label(5, 0, "坐落地址",wcf);
				sheet.addCell(label);
				label = new Label(6, 0, "测量号",wcf);
				sheet.addCell(label);
				
				while(rs != null && rs.next()){
					Integer rowIndex = rs.getRow();
					
					label = new Label(0, rowIndex, rs.getString(SZQY));
					sheet.addCell(label);
//					label = new Label(1, rowIndex, rs.getString(XQDMHM));
//					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString(XQNM));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(LH));
					sheet.addCell(label);
//					label = new Label(3, rowIndex, rs.getString(ZLC));
//					sheet.addCell(label);
//					label = new Label(4, rowIndex, rs.getString(DYGS));
//					sheet.addCell(label);
					label = new Label(3, rowIndex, Common.formatExportDateTime(rs, UPDDATE));
					sheet.addCell(label);
					label = new Label(4, rowIndex, rs.getString(CZR));
					sheet.addCell(label);
					label = new Label(5, rowIndex, rs.getString(NOTE));
					sheet.addCell(label);
					label = new Label(6, rowIndex, rs.getString(CLH));
					sheet.addCell(label);
				}
				workbook.write();
			}
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
			getFree(rs, call, conn, session);
		}
		return strBufResult;
	}
	
	
	
	
	
	
	
	@Override
	public Pgv00306 ImportExcelData(ArrayList<Pgv00306> v00306List) throws Exception {
		Pgv00306 v00306 = new Pgv00306();
		ArrayList<Pgv00306> tempList = new ArrayList<Pgv00306>();
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
			tran = session.beginTransaction();
			for(int i = 0;i < v00306List.size();i++){
				call = conn.prepareCall("{call PGSP_ADDT003061(?,?,?,?,?,?,?,?,?,?)}");
				Pgv00306 v00306Bean = v00306List.get(i);
				try{
					call.registerOutParameter(1, OracleTypes.CURSOR);
					call.setString(2, v00306Bean.getSzqy());
					call.setString(3,v00306Bean.getXqnm());
					call.setString(4,v00306Bean.getLh());
					call.setInt(5, 0);
					call.setInt(6, 0);
					call.setString(7, v00306Bean.getCd00002Czr());
					call.setString(8, v00306Bean.getNote());
					call.setString(9, v00306Bean.getSsgx());
					call.setString(10, v00306Bean.getClh());
					call.execute();
					rs = (ResultSet)call.getObject(1);
					if(null != rs && rs.next()){
						if(rs.getInt("flag") == 0){
							sResultCount++;
							
							v00306Bean.setCd00001Szqy(rs.getString("SZQYID"));
							v00306Bean.setCd00352Xqdm(rs.getString("XQDM"));
//							v00306Bean.setDmhId(rs.getString("TDMH"));
							v00306Bean.setImpErrorMsg("");				
							tempList.add(v00306Bean);
							v00306.setOutList(tempList);
						}
						rs.close();
					}
				}catch(Exception e){
					sResultCount++;
					v00306Bean.setImpErrorMsg(e.getMessage());
					tempList.add(v00306Bean);
					v00306.setOutList(tempList);
					continue;
				}finally{
					if(null != call){
						call.close();
					}
					if(null != rs){
						rs.close();
					}
				}
				
			}
			tran.commit();
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(rs, call,conn,session);
			if(sResultCount == 0){
				resultValue = 2;
			}else if(sResultCount > 0 && fResultCount == 0){
				resultValue = 1;
			}
			v00306.setOutFlag(resultValue);
		}
		return v00306;
	}

	
	@Override
	public Pgv00306 LoadByZCDZL(Pgv00306 v00306) throws Exception {
		ArrayList<Pgv00306> resultList = new ArrayList<Pgv00306>();
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_AUTO_00306A(?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, v00306.getCd00001Ssgx());
			call.setString(3, v00306.getNote());
			call.setString(4, v00306.getClh());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			if(null != rs && rs.next()){
				Pgv00306 e = new Pgv00306();
				e.setNote(rs.getString(NOTE));
				e.setLh(rs.getString(LH));
				e.setCd00352Xqdm(rs.getString(CD00352XQDM));
				e.setCd00001Szqy(rs.getString(CD00001SZQY));
				e.setZlc(rs.getInt(ZLC));
				resultList.add(e);
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		if(null != resultList && resultList.size() > 0){
			return resultList.get(0);
		}else{
			return new Pgv00306();
		}
	}
}
