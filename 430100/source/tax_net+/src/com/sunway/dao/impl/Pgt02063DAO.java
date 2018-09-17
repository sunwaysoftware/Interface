package com.sunway.dao.impl;

import java.io.ByteArrayOutputStream;
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

import com.sunway.dao.IPgt02063DAO;

import com.sunway.util.Excel;
import com.sunway.util.FormatUtil;
import com.sunway.vo.Pgt02063;
import com.sunway.vo.Pgv02063;

/**
 * 评估方法权重比维护
 * @author LeiJia
 *
 */
public class Pgt02063DAO extends BaseDAO implements IPgt02063DAO {

	
	private static final String SZQY = "szqy";	
	private static final String CD00001SZQY = "cd_00001_szqy";
	private static final String FWLX = "FWLX";	
	private static final String CD00001FWLX = "cd_00001_FWLX";
	private static final String SCQZB = "SCQZB";
	private static final String SYQZB = "SYQZB";
	private static final String UPDDATE = "upddate";
	private static final String CD00002CZR = "cd_00002_czr";
	private static final String CZR = "czr";
	private static final String TOTAL = "total";
	

	
	@Override
	public boolean GetDeleteCommand(Pgt02063 t02063) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02063(?,?,?,?)}");
			call.setString(1, t02063.getCd00001Szqy());
			call.setString(2, t02063.getCd00001Fwlx());
			call.setString(3, t02063.getCd00002Czr());
			call.setString(4, t02063.getCd00001Ssgx());
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
	public boolean GetInsertCommand(Pgt02063 t02063) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02063(?,?,?,?,?,?)}");
			call.setString(1, t02063.getCd00001Szqy());
			call.setString(2, t02063.getCd00001Fwlx());
			call.setDouble(3, t02063.getScqzb());
			call.setDouble(4, t02063.getSyqzb());
			call.setString(5, t02063.getCd00002Czr());
			call.setString(6, t02063.getCd00001Ssgx());
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
	public boolean GetUpdateCommand(Pgt02063 t02063) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02063(?,?,?,?,?)}");
			call.setString(1, t02063.getCd00001Szqy());
			call.setString(2, t02063.getCd00001Fwlx());
			call.setDouble(3, t02063.getScqzb());
			call.setDouble(4, t02063.getSyqzb());
			call.setString(5, t02063.getCd00002Czr());
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
	public ArrayList<Pgv02063> LoadAll(Pgv02063 v02063) throws Exception {
		ArrayList<Pgv02063> listResult = new ArrayList<Pgv02063>();
		CallableStatement call = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02063(?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v02063.getPageIndex());
			call.setInt(3, v02063.getPageSize());
			call.setString(4, v02063.getCd00001Ssgx());
			call.setString(5, v02063.getCd00001Szqy());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				listResult.add(SetVParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		
		return listResult;
	}
	
	
	
	protected Pgv02063 SetVParameters(ResultSet rs)throws Exception{
		Pgv02063 e = new Pgv02063();
		e.setSzqy(rs.getString(SZQY));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setFwlx(rs.getString(FWLX));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setCd00002Czr(rs.getString(CD00002CZR));	
		e.setScqzb(rs.getDouble(SCQZB));
		e.setSyqzb(rs.getDouble(SYQZB));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setCzr(rs.getString(CZR));
		return e;
	}

	
	@Override
	public Pgt02063 LoadByPrimaryKey(Pgt02063 t02063) throws Exception {
		ArrayList<Pgt02063> listResult = new ArrayList<Pgt02063>();
		CallableStatement call = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02063(?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, t02063.getCd00001Szqy());
			call.setString(3, t02063.getCd00001Fwlx());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				listResult.add(SetTParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		if(null != listResult && listResult.size() > 0){
			return listResult.get(0);
		}else{
			return t02063;
		}
		
	}
	
	
	protected Pgt02063 SetTParameters(ResultSet rs)throws Exception{
		Pgt02063 e = new Pgt02063();
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setScqzb(rs.getDouble(SCQZB));
		e.setSyqzb(rs.getDouble(SYQZB));
		return e;
	}



	@Override
	public Pgv02063 ImportExcelData(ArrayList<Pgv02063> v02063List)
			throws Exception {
		Pgv02063 v02063 = new Pgv02063();
		ArrayList<Pgv02063> tempList = new ArrayList<Pgv02063>();
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
			
			call = conn.prepareCall("{call PGSP_ADDT020631(?,?,?,?,?,?,?)}");
			for(int i = 0;i < v02063List.size();i++){
				Pgv02063 v02063Bean = v02063List.get(i);
				try{
				
					tran = session.beginTransaction();
					
					call.registerOutParameter(1, OracleTypes.CURSOR);
					call.setString(2, v02063Bean.getSzqy());
					call.setString(3, v02063Bean.getFwlx());
					call.setDouble(4, v02063Bean.getScqzb());
					call.setDouble(5, v02063Bean.getSyqzb());
					call.setString(6, v02063Bean.getCd00002Czr());
					call.setString(7, v02063Bean.getCd00001Ssgx());
					call.execute();
					rs = (ResultSet)call.getObject(1);
					if(null != rs && rs.next()){
						if(rs.getInt("flag") == 0){
							sResultCount++;
							v02063Bean.setCd00001Szqy(rs.getString("SZQYID"));
							v02063Bean.setCd00001Fwlx(rs.getString("FWLX"));
							v02063Bean.setImpErrorMsg("");
							tempList.add(v02063Bean);
							v02063.setOutList(tempList);
						}
					}
					tran.commit();
				}catch(Exception e){
					tran.rollback();
					sResultCount++;
					e.printStackTrace();
					v02063Bean.setImpErrorMsg(e.getMessage());
					tempList.add(v02063Bean);
					v02063.setOutList(tempList);
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
				//WriteLogImp(v02063List.get(0).getCd00001Ssgx(), "PGT02063", v02063List.get(0).getCd00002Czr(), "商业评估法权重比修正导入成功");
			}else if(sResultCount > 0 && fResultCount == 0){
				resultValue = 1;
				//WriteLogImp(v02063List.get(0).getCd00001Ssgx(), "PGT02063", v02063List.get(0).getCd00002Czr(), "商业评估法权重比修正导入有异常");
			}
			v02063.setOutFlag(resultValue);
		}
		return v02063;
	}



	@Override
	public ByteArrayOutputStream ExportQzb(Pgv02063 v02063) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		WritableWorkbook workbook=null;
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try {
			strBufResult =new ByteArrayOutputStream();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02063(?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, v02063.getPageIndex());
			call.setInt(3, v02063.getPageSize());
			call.setString(4, v02063.getCd00001Ssgx());
			call.setString(5, v02063.getCd00001Szqy());			
			call.execute();
			rs = (ResultSet)call.getObject(1);			
			if(rs != null){
				Label label;
				workbook = Workbook.createWorkbook(strBufResult);
				WritableSheet sheet = workbook.createSheet("资本化率系数修正",0);
				WritableCellFormat wcf =Excel.getExcelTitleStyle();
				
				label = new Label(0, 0, "所在区域",wcf);
				sheet.addCell(label);	
				label = new Label(1, 0, "房屋类型",wcf);
				sheet.addCell(label);	
				label = new Label(2, 0, "商场法权重比(%)",wcf);
				sheet.addCell(label);
				label = new Label(3, 0, "收益法权重比(%)",wcf);
				sheet.addCell(label);
				label = new Label(4, 0, "更新时间",wcf);
				sheet.addCell(label);
				label = new Label(5, 0, "操作人",wcf);
				sheet.addCell(label);
				
				while(rs != null && rs.next()){
					Integer rowIndex = rs.getRow();
					
					label = new Label(0, rowIndex, rs.getString(SZQY));
					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString(FWLX));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(SCQZB));
					sheet.addCell(label);
					label = new Label(3, rowIndex, rs.getString(SYQZB));
					sheet.addCell(label);
					label = new Label(4, rowIndex, FormatUtil.toYMDHMS(rs.getTimestamp(UPDDATE)));
					sheet.addCell(label);
					label = new Label(5, rowIndex, rs.getString(CD00002CZR));
					sheet.addCell(label);
				}
				
				workbook.write();
				//workbook.close();
			}
			//填写导出日志
			//WriteLogExp(v02063.getCd00001Ssgx(), "PGT02063", v02063.getCd00002Czr(), "资本化率系数修正数据导出成功");
		}catch(Exception e){
			if(null != strBufResult){
				try{
					strBufResult.close();
				}catch(Exception e1){}
			}
			throw e;
		}finally{
			getFree(rs, call, conn, null);
			if(null != workbook){
				try{
					workbook.close();
				}catch(Exception e){}
			}
			
		}
		return strBufResult;
	}
	
	


}
