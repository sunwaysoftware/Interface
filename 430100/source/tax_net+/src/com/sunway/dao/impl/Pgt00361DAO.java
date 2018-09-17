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

import com.sunway.dao.IPgt00361DAO;
import com.sunway.util.Excel;
import com.sunway.util.FormatUtil;
import com.sunway.vo.Pgt00361;
import com.sunway.vo.Pgv00361;
/**
 * 建筑成新修正系统维护
 * @author HuanWei
 *
 */
public class Pgt00361DAO extends BaseDAO implements IPgt00361DAO {
	
	private static final String ID = "id";
	private static final String SYNXMIN = "synx_min";
	private static final String SYNXMAX = "synx_max";
	private static final String XZXS = "xzxs";
	private static final String UPDDATE = "upddate";
	private static final String CD00002CZR = "cd_00002_czr";
	private static final String NOTE = "note";
	private static final String CZLX = "czlx";
	private static final String TOTAL = "total";
	private static final String CD00002PSSD = "cd_00002_pssd";
	private static final String CD00001FWLXLX = "cd_00001_fwlxlx";
	private static final String CD00001FWLX = "cd_00001_fwlx";
	private static final String FWLX = "fwlx";
	private static final String CZR = "czr";
	private static final String CD00001SZQYLX = "cd_00001_szqylx";
	private static final String CD00001SZQY = "cd_00001_szqy";
	private static final String SZQY = "szqy";
//	private static final String CD00352XQDM = "cd_00352_xqdm";    //小区编码
//	private static final String XQNM = "xqnm";                      //小区名称
	 

	
	@Override
	public boolean GetDeleteCommand(Pgt00361 test361) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("call PGSP_DELT00361(?,?,?)");
			call.setInt(1, test361.getId());
			call.setString(2, test361.getCd_00002_czr());
			call.setString(3, test361.getCd_00001_ssgx());
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
	public boolean GetInsertCommand(Pgt00361 test361) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("call PGSP_ADDT00361(?,?,?,?,?,?,?,?,?)");
			call.setInt(1, test361.getSynx_min());
			call.setInt(2, test361.getSynx_max());
			call.setDouble(3, test361.getXzxs());
			call.setString(4, test361.getCd_00002_czr());
			call.setString(5, test361.getNote());
			call.setString(6, test361.getCd_00002_pssd());
			call.setString(7, test361.getCd_00001_fwlx());
			call.setString(8, test361.getCd_00001_szqy());
			call.setString(9, test361.getCd_00001_ssgx());
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
	public boolean GetUpdateCommand(Pgt00361 test361) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("call PGSP_UPDT00361(?,?,?,?,?,?,?,?,?)");
			call.setInt(1, test361.getId());
			call.setInt(2, test361.getSynx_min());
			call.setInt(3, test361.getSynx_max());
			call.setDouble(4, test361.getXzxs());
			call.setString(5, test361.getCd_00002_czr());
			call.setString(6, test361.getNote());
			call.setString(7, test361.getCd_00002_pssd());
			call.setString(8, test361.getCd_00001_fwlx());
			call.setString(9, test361.getCd_00001_szqy());
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
	public ArrayList<Pgv00361> LoadAll(Pgv00361 test361) throws Exception {
		ArrayList<Pgv00361> listResult = new ArrayList<Pgv00361>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("call PGSP_GETALLT00361(?,?,?,?,?,?)");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, test361.getPageIndex());
			call.setInt(3, test361.getPageSize());
			call.setString(4, test361.getCd_00001_fwlx());
			call.setString(5,test361.getSsgx());
			call.setString(6, test361.getCd_00001_szqy());
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

	
	

	
	
	protected Pgv00361 SetVParameters(ResultSet rs)throws Exception{
		Pgv00361 e = new Pgv00361();
		e.setCd_00002_czr(rs.getString(CD00002CZR));
		e.setCzlx(rs.getInt(CZLX));
		e.setId(rs.getInt(ID));
		e.setNote(rs.getString(NOTE));
		e.setSynx_max(rs.getInt(SYNXMAX));
		e.setSynx_min(rs.getInt(SYNXMIN));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setXzxs(rs.getDouble(XZXS));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setCd_00002_pssd(rs.getString(CD00002PSSD));
		e.setCd_00001_fwlx(rs.getString(CD00001FWLX));
		e.setCd_00001_fwlxlx(rs.getString(CD00001FWLXLX));
		e.setCzr(rs.getString(CZR));
		e.setFwlx(rs.getString(FWLX));
		e.setCd_00001_szqylx(rs.getString(CD00001SZQYLX));
		e.setCd_00001_szqy(rs.getString(CD00001SZQY));
		e.setSzqy(rs.getString(SZQY));
		return e;
	}
	
	
	
	@Override
	public Pgt00361 LoadByPrimaryKey(Pgt00361 test361)
			throws Exception {
		ArrayList<Pgt00361> listResult = new ArrayList<Pgt00361>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("call PGSP_GETT00361(?,?)");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, test361.getId());
			
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				listResult.add(SetTParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs,call, conn, session);
		}
		if(listResult != null && listResult.size() > 0){
			return listResult.get(0);
		}else{
			return test361;
		}
		
	}
	
	
	
	
	
	
	@Override
	public Pgt00361 LoadByPrimaryAddKey(Pgt00361 test361)
			throws Exception {
		ArrayList<Pgt00361> listResult = new ArrayList<Pgt00361>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("call PGSP_GETT003611(?,?,?,?,?)");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2,test361.getCd_00001_szqy());
			call.setString(3, test361.getCd_00001_fwlx());
			call.setInt(4,test361.getSynx_min());
			call.setInt(5, test361.getSynx_max());
			//call.setDouble(6,test361.getXzxs());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				listResult.add(SetTParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		if(listResult != null && listResult.size() > 0){
			return listResult.get(0);
		}else{
			return test361;
		}
		
	}
	
	
	
	protected Pgt00361 SetTParameters(ResultSet rs)throws Exception{
		Pgt00361 e = new Pgt00361();
		e.setCd_00002_czr(rs.getString(CD00002CZR));
		e.setCzlx(rs.getInt(CZLX));
		e.setId(rs.getInt(ID));
		e.setNote(rs.getString(NOTE));
		e.setSynx_max(rs.getInt(SYNXMAX));
		e.setSynx_min(rs.getInt(SYNXMIN));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setXzxs(rs.getDouble(XZXS));
		e.setCd_00002_pssd(rs.getString(CD00002PSSD));
		e.setFwlx(rs.getString(FWLX));
		e.setCd_00001_fwlx(rs.getString(CD00001FWLX));
		e.setCd_00001_szqy(rs.getString(CD00001SZQY));
		return e;
	}
	
	
	
	
	
	@Override
	public boolean ExecuteParamCopy(Pgt00361 test361) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_}");
			
			
			
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
	public OutputStream ExportT00361(Pgv00361 v00361) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		WritableWorkbook workbook =null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		ResultSet rs = null;
		try{
			strBufResult = new ByteArrayOutputStream();
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("call PGSP_GETALLT00361(?,?,?,?,?,?)");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v00361.getPageIndex());
			call.setInt(3, v00361.getPageSize());
			call.setString(4, v00361.getCd_00001_fwlx());
			call.setString(5, v00361.getSsgx());
			call.setString(6, v00361.getCd_00001_szqy());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			if(rs != null){
				Label label;
				workbook = Workbook.createWorkbook(strBufResult);
				WritableSheet sheet = workbook.createSheet("建筑成新", 0);
				WritableCellFormat wcf =Excel.getExcelTitleStyle();
				label = new Label(0, 0, "所在区域",wcf);
				sheet.addCell(label);
				label = new Label(1, 0, "房屋类型",wcf);
				sheet.addCell(label);
				label = new Label(2, 0, "使用年限下限",wcf);
				sheet.addCell(label);
				label = new Label(3, 0, "使用年限上限",wcf);
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
					
					label = new Label(0, rowIndex, rs.getString(SZQY));
					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString(FWLX));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(SYNXMIN));
					sheet.addCell(label);
					label = new Label(3, rowIndex, rs.getString(SYNXMAX));
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
	public Pgv00361 ImportExcelData(ArrayList<Pgv00361> v00361List)
			throws Exception {
		Pgv00361 v00361 = new Pgv00361();
		ArrayList<Pgv00361> tempList = new ArrayList<Pgv00361>();
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
			
			for(int i = 0; i < v00361List.size();i++){
				call = conn.prepareCall("{call PGSP_ADDT003611(?,?,?,?,?,?,?,?)}");
				Pgv00361 v00361Bean = v00361List.get(i);
				try{
					call.registerOutParameter(1, OracleTypes.CURSOR);
					call.setInt(2, v00361Bean.getSynx_min());
					call.setInt(3, v00361Bean.getSynx_max());
					call.setDouble(4, v00361Bean.getXzxs());
					call.setString(5, v00361Bean.getCd_00002_czr());
					call.setString(6, v00361Bean.getFwlx());
					call.setString(7, v00361Bean.getSsgx());
					call.setString(8, v00361Bean.getSzqy());
					call.execute();
					rs = (ResultSet) call.getObject(1); 
				    if(null != rs && rs.next()){
				    	if(rs.getInt("flag") == 0){
				    		sResultCount++;
				    		v00361Bean.setCd_00001_fwlx(rs.getString("TFWLX"));
				    		v00361Bean.setCd_00001_szqy(rs.getString("SZQYID"));
				    		v00361Bean.setImpErrorMsg("");
				    	
				    		tempList.add(v00361Bean);
				    		v00361.setOutList(tempList);
				    	}
				    }
				}catch(Exception e){
					sResultCount++;
					v00361Bean.setImpErrorMsg(e.getMessage());
		    		tempList.add(v00361Bean);
		    		v00361.setOutList(tempList);
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
//				WriteLogImp(v00361List.get(0).getSsgx(), "PGT00361", v00361List.get(0).getCd_00002_czr(), "建筑成新修正导入成功");
			}else if(sResultCount > 0 && fResultCount == 0){
				resultValue = 1;
//				WriteLogImp(v00361List.get(0).getSsgx(), "PGT00361", v00361List.get(0).getCd_00002_czr(), "建筑成新修正导入有异常");
			}
			v00361.setOutFlag(resultValue);
		}
		return v00361;
	}
	
	


	
	@Override
	public boolean GetSelDeleteCommand(Pgt00361 test361) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT003611(?,?,?)}");
			call.setString(1, test361.getChkDel());
			call.setString(2, test361.getCd_00002_czr());
			call.setString(3, test361.getCd_00001_ssgx());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			tran.rollback();
			throw e;
		} finally {
			getFree(call,conn,session);
		}
		return bResult;
	}
	
	

}
