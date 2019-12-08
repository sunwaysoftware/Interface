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

import com.sunway.dao.IPgt00362DAO;
import com.sunway.util.Common;
import com.sunway.vo.Pgt00362;
import com.sunway.vo.Pgv00362;

/**
 * 建筑结构修正系统维护
 * @author HuanWei
 *
 */
public class Pgt00362DAO extends BaseDAO implements IPgt00362DAO {
	
	private static final String ID = "id";
	private static final String CD00002PSSD = "cd_00002_pssd";
	private static final String CD00001JZJGLX = "cd_00001_jzjglx";
	private static final String CD00001JZJG = "cd_00001_jzjg";
	private static final String XZXS = "xzxs";
	private static final String CZLX = "czlx";
	private static final String UPDDATE = "upddate";
	private static final String CD00002CZR = "cd_00002_czr";
	private static final String NOTE = "note";
	private static final String YWDT = "ywdt";
	private static final String JZJG = "jzjg";
	private static final String CZR = "czr";
	private static final String RID = "rid";
	private static final String TOTAL = "total";
	private static final String CD00001FWLXLX = "cd_00001_fwlxlx";
	private static final String CD00001FWLX = "cd_00001_fwlx";
	private static final String FWLX = "fwlx";
	private static final String CD00001SZQYLX = "cd_00001_szqylx";
	private static final String CD00001SZQY = "cd_00001_szqy";
	private static final String SZQY = "szqy";
	
//	private static final String CD00352XQDM = "cd_00352_xqdm";    //小区编码
//	private static final String XQNM = "xqnm";   
	
	
	
	

	
	@Override
	public boolean GetDeleteCommand(Pgt00362 t00362) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00362(?,?,?)}");
			call.setString(1, t00362.getId());
			call.setString(2, t00362.getCd_00002_czr());
			call.setString(3, t00362.getCd_00001_ssgx());
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
	public boolean GetInsertCommand(Pgt00362 t00362) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00362(?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, t00362.getCd_00002_pssd());
			call.setString(2, t00362.getCd_00001_jzjg());
			call.setDouble(3, t00362.getXzxs());
			call.setDouble(4, t00362.getCzlx());
			call.setString(5, t00362.getCd_00002_czr());
			call.setString(6, t00362.getNote());
			call.setInt(7, t00362.getYwdt());
			call.setString(8, t00362.getCd_00001_fwlx());
			call.setString(9,t00362.getCd_00001_szqy());
			call.setString(10, t00362.getCd_00001_ssgx());
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
	public boolean GetUpdateCommand(Pgt00362 t00362) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		 
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00362(?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, t00362.getId());
			call.setString(2, t00362.getCd_00002_pssd());
			call.setString(3, t00362.getCd_00001_jzjg());
			call.setDouble(4, t00362.getXzxs());
			call.setInt(5, t00362.getCzlx());
			call.setString(6, t00362.getCd_00002_czr());
			call.setString(7, t00362.getNote());
			call.setInt(8, t00362.getYwdt());
			call.setString(9, t00362.getCd_00001_fwlx());
			call.setString(10, t00362.getCd_00001_szqy());
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
	public ArrayList<Pgv00362> LoadAll(Pgv00362 t00362) throws Exception {
		ArrayList<Pgv00362> listResult = new ArrayList<Pgv00362>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00362(?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, t00362.getPageIndex());
			call.setInt(3, t00362.getPageSize());
			call.setString(4, t00362.getCd_00002_pssd());
			call.setString(5, t00362.getCd_00001_jzjg());
			call.setString(6, t00362.getCd_00001_fwlx());
			call.setString(7,t00362.getCd_00001_szqy());
			call.setString(8,t00362.getSsgx());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				listResult.add(SetVParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs,call, conn, session);
		}
		return listResult;
	}
	
	
	
	
	
	protected Pgv00362 SetVParameters(ResultSet rs)throws Exception{
		Pgv00362 e = new Pgv00362();
		e.setCd_00001_jzjg(rs.getString(CD00001JZJG));
		e.setCd_00001_jzjglx(rs.getString(CD00001JZJGLX));
		e.setCd_00002_czr(rs.getString(CD00002CZR));
		e.setCd_00002_pssd(rs.getString(CD00002PSSD));
		e.setCzlx(rs.getInt(CZLX));
		e.setId(rs.getString(ID));
		e.setNote(rs.getString(NOTE));
		e.setRecordIndex(rs.getInt(RID));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setXzxs(rs.getDouble(XZXS));
		e.setYwdt(rs.getInt(YWDT));
		e.setJzjg(rs.getString(JZJG));
		e.setCzr(rs.getString(CZR));
		e.setCd_00001_fwlx(rs.getString(CD00001FWLX));
		e.setCd_00001_fwlxlx(rs.getString(CD00001FWLXLX));
		e.setFwlx(rs.getString(FWLX));
		e.setCd_00001_szqylx(rs.getString(CD00001SZQYLX));
		e.setCd_00001_szqy(rs.getString(CD00001SZQY));
		e.setSzqy(rs.getString(SZQY));
		return e;
	}
	
	@Override
	public Pgt00362 LoadByPrimaryKey(Pgt00362 t00362) throws Exception {
		ArrayList<Pgt00362> listResult = new ArrayList<Pgt00362>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00362(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, t00362.getId());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			if(null != rs && rs.next()){
				listResult.add(SetTParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs,call, conn, session);
		}
		if(null != listResult && listResult.size() > 0){
			return listResult.get(0);
		}else{
			return t00362;
		}
	}
	
	
	
	
	
	@Override
	public Pgt00362 LoadByPrimaryAddKey(Pgt00362 t00362) throws Exception {
		ArrayList<Pgt00362> listResult = new ArrayList<Pgt00362>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT003621(?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, t00362.getCd_00001_szqy());
			call.setString(3, t00362.getCd_00001_fwlx());
			call.setString(4, t00362.getCd_00001_jzjg());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			if(null != rs && rs.next()){
				listResult.add(SetTParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		if(null != listResult && listResult.size() > 0){
			return listResult.get(0);
		}else{
			return t00362;
		}
	}
	
	
	
	
	protected Pgt00362 SetTParameters(ResultSet rs)throws Exception{
		Pgt00362 e = new Pgt00362();
		e.setCd_00001_jzjg(rs.getString(CD00001JZJG));
		e.setCd_00001_jzjglx(rs.getString(CD00001JZJGLX));
		e.setCd_00002_czr(rs.getString(CD00002CZR));
		e.setCd_00002_pssd(rs.getString(CD00002PSSD));
		e.setCzlx(rs.getInt(CZLX));
		e.setId(rs.getString(ID));
		e.setNote(rs.getString(NOTE));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setXzxs(rs.getDouble(XZXS));
		e.setYwdt(rs.getInt(YWDT));
		e.setJzjg(rs.getString(JZJG));
		e.setCd_00001_fwlx(rs.getString(CD00001FWLX));
		e.setCd_00001_fwlxlx(rs.getString(CD00001FWLXLX));
		e.setFwlx(rs.getString(FWLX));
		e.setCd_00001_szqy(rs.getString(CD00001SZQY));
		return e;
	}
	
	
	
	
	
	@Override
	public boolean ExecuteParamCopy(Pgt00362 t00362) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran= null;
		
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGST_}");
			
			
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
	public OutputStream ExportJZJG(Pgv00362 v00362) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		WritableWorkbook workbook=null;
		Connection conn = null;
		Session session = null;
		ResultSet rs = null;
		CallableStatement call = null;
		try{
			 strBufResult =new ByteArrayOutputStream();
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00362(?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v00362.getPageIndex());
			call.setInt(3, v00362.getPageSize());
			call.setString(4, v00362.getCd_00002_pssd());
			call.setString(5, v00362.getCd_00001_jzjg());
			call.setString(6, v00362.getCd_00001_fwlx());
			call.setString(7,v00362.getCd_00001_szqy());
			call.setString(8,v00362.getSsgx());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			if(rs != null){
				Label label;
				
				workbook = Workbook.createWorkbook(strBufResult);
				WritableSheet sheet = workbook.createSheet("建筑结构修正", 0);
				WritableCellFormat wcf =Common.getExcelTitleStyle();
				label = new Label(0, 0, "所在区域",wcf);
				sheet.addCell(label);
				label = new Label(1, 0, "房屋类型",wcf);
				sheet.addCell(label);
				label = new Label(2, 0, "建筑结构",wcf);
				sheet.addCell(label);
				label = new Label(3, 0, "修正值(%)",wcf);
				sheet.addCell(label);
				label = new Label(4, 0, "更新时间",wcf);
				sheet.addCell(label);
				label = new Label(5, 0, "操作人",wcf);
				sheet.addCell(label);
				label = new Label(6, 0, "备注",wcf);
				sheet.addCell(label);
				
				while(rs != null && rs.next()){
					Integer rowIndex = rs.getRow();
					
					label = new Label(0, rowIndex, rs.getString(SZQY));
					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString(FWLX));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(JZJG));
					sheet.addCell(label);
					label = new Label(3, rowIndex, rs.getString(XZXS));
					sheet.addCell(label);
					label = new Label(4, rowIndex, Common.formatExportDateTime(rs, UPDDATE));
					sheet.addCell(label);
					label = new Label(5, rowIndex, rs.getString(CZR));
					sheet.addCell(label);
					label = new Label(6, rowIndex, rs.getString(NOTE));
				}
				workbook.write();
			}
			
			//填写导出日志
			//WriteLogExp(v00362.getSsgx(), "PGT00362", v00362.getCd_00002_czr(), "建筑结构修正导出成功");
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
	public Pgv00362 ImportExcelData(ArrayList<Pgv00362> jzjgList)
			throws Exception {
		Pgv00362 v00362 =new Pgv00362();
		ArrayList<Pgv00362> tempList = new ArrayList<Pgv00362>();
		Integer resultValue = 0;
		Integer sResultCount = 0;
		Integer fResultCount = 0;
		ResultSet rs = null;
		Session session = null;
		Connection conn = null;
		CallableStatement call = null;
		Transaction tran = null;
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			
			for(int i = 0; i < jzjgList.size();i++){
				call = conn.prepareCall("{call PGSP_ADDT003621(?,?,?,?,?,?,?,?)}");
				Pgv00362 jzjg = jzjgList.get(i);
				try{
					call.registerOutParameter(1, OracleTypes.CURSOR);
					call.setString(2, jzjg.getCd_00002_pssd());
					call.setString(3, jzjg.getJzjg());
					call.setDouble(4, jzjg.getXzxs());
					call.setString(5, jzjg.getCd_00002_czr());
					call.setString(6, jzjg.getFwlx());
					call.setString(7, jzjg.getSsgx());
					call.setString(8, jzjg.getSzqy());
					call.execute();
					rs = (ResultSet) call.getObject(1); 
					if (null!=rs && rs.next()) {
						if (rs.getInt("flag") == 0) {
							sResultCount++;
							//标记哪一列字段错误
							jzjg.setCd_00001_szqy(rs.getString("SZQYID"));
							jzjg.setCd_00001_fwlx(rs.getString("TFWLX"));
							jzjg.setCd_00001_jzjg(rs.getString("TJZJG"));
							jzjg.setImpErrorMsg("");
						
							tempList.add(jzjg);
							v00362.setOutList(tempList);
						}
					}
				}catch(Exception e){
					sResultCount++;
					jzjg.setImpErrorMsg(e.getMessage());
					tempList.add(jzjg);
					v00362.setOutList(tempList);
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
			getFree(rs,call,conn,session);
			if(sResultCount == 0){
				resultValue = 2;
//				WriteLogImp(jzjgList.get(0).getSsgx(), "PGT00362", jzjgList.get(0).getCd_00002_czr(), "建筑结构修正导入成功");
			}
			else if(sResultCount > 0 && fResultCount == 0){
				resultValue = 1;
//				WriteLogImp(jzjgList.get(0).getSsgx(), "PGT00362", jzjgList.get(0).getCd_00002_czr(), "建筑结构修正导入有异常");
			}
			v00362.setOutFlag(resultValue);
		}
		return v00362;
	}

	
	@Override
	public boolean GetSelDeleteCommand(Pgt00362 t00362) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT003621(?,?,?)}");
			call.setString(1, t00362.getChkDel());
			call.setString(2, t00362.getCd_00002_czr());
			call.setString(3, t00362.getCd_00001_ssgx());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call,conn,session);
		}
		return bResult;
	}
}
