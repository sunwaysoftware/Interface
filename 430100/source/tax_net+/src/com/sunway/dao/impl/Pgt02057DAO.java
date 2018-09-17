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

import com.sunway.dao.IPgt02057DAO;

import com.sunway.util.Excel;
import com.sunway.util.FormatUtil;
import com.sunway.vo.Pgt02057;
import com.sunway.vo.Pgv02057;
/**
 * @category 收益法资本化率
 * @author Lee
 * @version 1.0
 */
public class Pgt02057DAO extends BaseDAO implements IPgt02057DAO {

	
	
	private static final String CD00001FWLX = "cd_00001_fwlx";			//房屋用途名称
	private static final String FWLX = "fwlx";        //房屋类型名称 
	private static final String CD00001SZQY = "cd_00001_szqy";	//所在区域编码
	private static final String SZQY =  "SZQY";						//所在区域名称
	private static final String ZBHL = "zbhl";						//资本化率(%)
	private static final String UPDDATE = "upddate";					//更改时间
	private static final String CD00002CZR = "cd_00002_czr";		//操作人编号	
	private static final String CZR = "czr";						//操作人
	private static final String NOTE = "note";						//备注信息
	private static final String TOTAL = "total";					//总纪录数
	private static final String XQNM = "XQNM";
	private static final String CD02050XQDM = "cd_02050_xqdm";
	private static final String XQDMHM = "XQDMHM";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt02057 zbhl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02057(?,?,?,?)}");			
			call.setString(1, zbhl.getCd00001Szqy());
			call.setString(2, zbhl.getCd00001Fwlx());
			call.setString(3, zbhl.getCd00002Czr());
			call.setString(4, zbhl.getCd00001Ssgx());
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
	public boolean GetSelDeleteCommand(Pgt02057 zbhl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT020571(?,?,?)}");
			call.setString(1, zbhl.getChkDel());
			call.setString(2, zbhl.getCd00002Czr());
			call.setString(3, zbhl.getCd00001Ssgx());
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
	public boolean GetSelDeleteCommandA(Pgt02057 zbhl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02057A1(?,?,?)}");
			call.setString(1, zbhl.getChkDel());
			call.setString(2, zbhl.getCd00002Czr());
			call.setString(3, zbhl.getCd00001Ssgx());
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
	public boolean GetInsertCommand(Pgt02057 zbhl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02057(?,?,?,?,?,?)}");
			call.setString(1, zbhl.getCd00001Fwlx());
			call.setString(2, zbhl.getCd00001Szqy());
			call.setDouble(3, zbhl.getZbhl());
			call.setString(4, zbhl.getCd00002Czr());
			call.setString(5, zbhl.getNote());
			call.setString(6, zbhl.getCd00001Ssgx());
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
	public boolean GetUpdateCommand(Pgt02057 zbhl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02057(?,?,?,?,?,?)}");
			call.setString(1, zbhl.getCd00001Fwlx());
			call.setString(2, zbhl.getCd00001Szqy());
			call.setDouble(3, zbhl.getZbhl());
			call.setString(4, zbhl.getCd00002Czr());
			call.setString(5, zbhl.getNote());
			call.setString(6, zbhl.getCd00001Ssgx());
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
	public ArrayList<Pgv02057> LoadAll(Pgv02057 zbhl) throws Exception {
		ArrayList<Pgv02057> listResult = new ArrayList<Pgv02057>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02057(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, zbhl.getPageIndex());
			call.setInt(3, zbhl.getPageSize());
			call.setString(4, zbhl.getCd00001Fwlx());
			call.setString(5, zbhl.getCd00001Szqy());
			call.setString(6, zbhl.getCd00001Ssgx());
			call.execute();
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVParameters(rs));
			}
		} catch (Exception e) {
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
	protected Pgv02057 SetVParameters(ResultSet rs) throws Exception {
		Pgv02057 e = new Pgv02057();
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setFwlx(rs.getString(FWLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setSzqy(rs.getString(SZQY));
		e.setZbhl(rs.getDouble(ZBHL));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCzr(rs.getString(CZR));
		e.setNote(rs.getString(NOTE));
		e.setRecordCount(rs.getInt(TOTAL));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt02057 LoadByPrimaryKey(Pgt02057 zbhl) throws Exception {
		ArrayList<Pgt02057> listResult = new ArrayList<Pgt02057>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02057(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, zbhl.getCd00001Fwlx());
			call.setString(3, zbhl.getCd00001Szqy());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetTParameters(rs));			
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return zbhl;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt02057 SetTParameters(ResultSet rs) throws Exception {
		Pgt02057 e = new Pgt02057();
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setZbhl(rs.getDouble(ZBHL));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExecuteParamCopy(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean ExecuteParamCopy(Pgt02057 zbhl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {	
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02057(?,?,?,?)}");
			call.setString(1, zbhl.getSpssd());
			call.setString(2, zbhl.getTpssd());
			call.setString(3, zbhl.getCd00001Szqy());
			call.setString(4, zbhl.getCd00002Czr());
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
	
	public Pgv02057 ImportExcelData(ArrayList<Pgv02057> v02057List) throws Exception {
		Pgv02057 v02057 = new Pgv02057();
		ArrayList<Pgv02057> tempList = new ArrayList<Pgv02057>();
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
			
			call = conn.prepareCall("{call PGSP_ADDT020571(?,?,?,?,?,?,?)}");	
			
			for(int i = 0;i < v02057List.size();i++){
				Pgv02057 v02057Bean = v02057List.get(i);
				try{
					tran = session.beginTransaction();			
					
					call.registerOutParameter(1, OracleTypes.CURSOR);
					call.setString(2, v02057Bean.getFwlx());
					call.setString(3, v02057Bean.getSzqy());
					call.setDouble(4, v02057Bean.getZbhl());
					call.setString(5, v02057Bean.getCd00002Czr());
					call.setString(6, v02057Bean.getNote());
					call.setString(7, v02057Bean.getCd00001Ssgx());
					call.execute();
					rs = (ResultSet)call.getObject(1);
					if(null != rs && rs.next()){
						if(rs.getInt("flag") == 0){
							sResultCount++;
							v02057Bean.setCd00001Szqy(rs.getString("SZQYID"));
							v02057Bean.setCd00001Fwlx(rs.getString("FWLX"));
							v02057Bean.setImpErrorMsg("");
							tempList.add(v02057Bean);
							v02057.setOutList(tempList);
						}
					}
					tran.commit();
				}catch(Exception e){
					tran.rollback();
					sResultCount++;
					e.printStackTrace();
					v02057Bean.setImpErrorMsg(e.getMessage());
					tempList.add(v02057Bean);
					v02057.setOutList(tempList);
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
				//WriteLogImp(v02057List.get(0).getCd00001Ssgx(), "PGT02057", v02057List.get(0).getCd00002Czr(), "资本化率系数修正导入成功");
			}else if(sResultCount > 0 && fResultCount == 0){
				resultValue = 1;
				//WriteLogImp(v02057List.get(0).getCd00001Ssgx(), "PGT02057", v02057List.get(0).getCd00002Czr(), "资本化率系数修正导入有异常");
			}
			v02057.setOutFlag(resultValue);
		}
		return v02057;
	}
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02057DAO#ExportZBHLxtwh(com.sunway.vo.Pgv02057)
	 */		
		@Override
		public OutputStream ExportZBHLxtwh(Pgv02057 v02057) throws Exception {
			ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
			ResultSet rs = null;
			Connection conn = null;
			CallableStatement call = null;
			try {
				conn = super.getConnection();
				call = conn.prepareCall("{call PGSP_GETALLT02057(?,?,?,?,?,?)}");
				//注册输出参数
				call.registerOutParameter(1, OracleTypes.CURSOR);
				//注册输入参数
				call.setInt(2, 1);
				call.setInt(3, -1);
				call.setString(4, v02057.getCd00001Fwlx());
				call.setString(5, v02057.getCd00001Szqy());
				call.setString(6, v02057.getCd00001Ssgx());
				call.execute();
				//返回數據集
				rs = (ResultSet) call.getObject(1);
				if(null!=rs){
					// 创建excel对象
			        Label label;   
			        WritableWorkbook workbook; 
		            workbook = Workbook.createWorkbook(strBufResult);   
		            WritableSheet sheet = workbook.createSheet("资本化率", 0);
		            int m=-1;
		            // 写入标头
	//	            label = new Label(0, 0, "评税时点");
	//				sheet.addCell(label);
		            label = new Label(++m, 0, "所在区域");
					sheet.addCell(label);	
					label = new Label(++m, 0, "房屋类型");
					sheet.addCell(label);	
					label = new Label(++m, 0, "资本化率(%)");
					sheet.addCell(label);	
					label = new Label(++m, 0, "更新时间");
					sheet.addCell(label);	
					label = new Label(++m, 0, "操作人");
					sheet.addCell(label);	
					label = new Label(++m, 0, "备注");
					sheet.addCell(label);	
						
		            // 写入数据
					while(null!=rs && rs.next()){
						m=-1;
						Integer rowIndex = rs.getRow();
	//					label = new Label(0, rowIndex, rs.getString(CD00002PSSD));
	//					sheet.addCell(label);
						label = new Label(++m, rowIndex, rs.getString(SZQY));
						sheet.addCell(label);		
						label = new Label(++m, rowIndex, rs.getString(FWLX));
						sheet.addCell(label);	
						label = new Label(++m, rowIndex, rs.getString(ZBHL));
						sheet.addCell(label);	
						label = new Label(++m, rowIndex,FormatUtil.toYMDHMS( rs.getTimestamp(UPDDATE)));
						sheet.addCell(label);		
						label = new Label(++m, rowIndex, rs.getString(CZR));
						sheet.addCell(label);	
						label = new Label(++m, rowIndex, rs.getString(NOTE));
						sheet.addCell(label);		
						
					}
		            workbook.write();   
		            workbook.close();  
				}
			} catch (Exception e) {
				throw e;
			} finally {
				getFree(rs, call, conn, null);
			}
			return strBufResult;
		}
	




	@Override
	public ByteArrayOutputStream ExportJYSJA(Pgv02057 v02057) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		WritableWorkbook workbook=null;
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try {
			strBufResult =new ByteArrayOutputStream();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02057A(?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, v02057.getPageIndex());
			call.setInt(3, v02057.getPageSize());
			call.setString(4,v02057.getCd00001Fwlx());
			call.setString(5, v02057.getCd00001Szqy());
			call.setString(6, v02057.getCd00001Ssgx());
			call.setString(7,v02057.getCd02050Xqdm());
			call.execute();
			rs = (ResultSet)call.getObject(1);			
			if(rs != null){
				Label label;
				workbook = Workbook.createWorkbook(strBufResult);
				WritableSheet sheet = workbook.createSheet("小区资本化率系数修正",0);
				WritableCellFormat wcf =Excel.getExcelTitleStyle();
				
				label = new Label(0, 0, "所在区域",wcf);
				sheet.addCell(label);
				label = new Label(1, 0, "代码号",wcf);
				sheet.addCell(label);
				label = new Label(2, 0, "小区名称",wcf);
				sheet.addCell(label);
				label = new Label(3, 0, "房屋类型",wcf);
				sheet.addCell(label);
				label = new Label(4, 0, "修正数（%）",wcf);
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
					label = new Label(1, rowIndex, rs.getString(XQDMHM));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(XQNM));
					sheet.addCell(label);
					label = new Label(3, rowIndex, rs.getString(FWLX));
					sheet.addCell(label);
					label = new Label(4, rowIndex, rs.getString(ZBHL));
					sheet.addCell(label);
					label = new Label(5, rowIndex, FormatUtil.toYMDHMS(rs.getTimestamp(UPDDATE)));
					sheet.addCell(label);
					label = new Label(6, rowIndex, rs.getString(CZR));
					sheet.addCell(label);
					label = new Label(7, rowIndex, rs.getString(NOTE));
					sheet.addCell(label);
				}
				
				workbook.write();
				//workbook.close();
			}
			//填写导出日志
			//WriteLogExp(v02057.getCd00001Ssgx(), "PGT02057", v02057.getCd00002Czr(), "小区资本化率系数修正导出成功");
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
	public ByteArrayOutputStream ExportJYSJ(Pgv02057 v02057) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		WritableWorkbook workbook=null;
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try {
			strBufResult =new ByteArrayOutputStream();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02057(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, v02057.getPageIndex());
			call.setInt(3, v02057.getPageSize());
			call.setString(4,v02057.getCd00001Fwlx());
			call.setString(5, v02057.getCd00001Szqy());
			call.setString(6, v02057.getCd00001Ssgx());
			call.execute();
			rs = (ResultSet)call.getObject(1);			
			if(rs != null){
				Label label;
				workbook = Workbook.createWorkbook(strBufResult);
				WritableSheet sheet = workbook.createSheet("分区资本化率系数修正",0);
				WritableCellFormat wcf =Excel.getExcelTitleStyle();
				
				label = new Label(0, 0, "所在区域",wcf);
				sheet.addCell(label);	
				label = new Label(1, 0, "房屋类型",wcf);
				sheet.addCell(label);	
				label = new Label(2, 0, "资本化率(%)",wcf);
				sheet.addCell(label);
				label = new Label(3, 0, "更新时间",wcf);
				sheet.addCell(label);
				label = new Label(4, 0, "操作人",wcf);
				sheet.addCell(label);
				label = new Label(5, 0, "备注",wcf);
				sheet.addCell(label);
				
				while(rs != null && rs.next()){
					Integer rowIndex = rs.getRow();
					
					label = new Label(0, rowIndex, rs.getString(SZQY));
					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString(FWLX));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(ZBHL));
					sheet.addCell(label);
					label = new Label(3, rowIndex, FormatUtil.toYMDHMS(rs.getTimestamp(UPDDATE)));
					sheet.addCell(label);
					label = new Label(4, rowIndex, rs.getString(CD00002CZR));
					sheet.addCell(label);
					label = new Label(5, rowIndex, rs.getString(NOTE));
				}
				
				workbook.write();
				//workbook.close();
			}
			//填写导出日志
			//WriteLogExp(v02057.getCd00001Ssgx(), "PGT02057", v02057.getCd00002Czr(), "分区资本化率系数修正导出成功");
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
	public boolean GetDeleteCommandA(Pgt02057 t02057) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn =super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02057A(?,?,?,?)}");
			call.setString(1, t02057.getCd02050Xqdm());
			call.setString(2,t02057.getCd00001Fwlx());
			call.setString(3, t02057.getCd00002Czr());
			call.setString(4, t02057.getCd00001Ssgx());
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
	public Pgv02057 ImportExcelDataA(ArrayList<Pgv02057> v02057List)
			throws Exception {
		Pgv02057 v02057 = new Pgv02057();
		ArrayList<Pgv02057> tempList = new ArrayList<Pgv02057>();
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
			
			call = conn.prepareCall("{call PGSP_ADDT02057A1(?,?,?,?,?,?,?,?,?)}");
			
			for(int i = 0;i < v02057List.size();i++){
				Pgv02057 v02057Bean = v02057List.get(i);
				try{
					tran = session.beginTransaction();
					
					call.registerOutParameter(1, OracleTypes.CURSOR);
					call.setString(2, v02057Bean.getFwlx());
					call.setString(3, v02057Bean.getSzqy());
					call.setDouble(4, v02057Bean.getZbhl());
					call.setString(5, v02057Bean.getCd00002Czr());
					call.setString(6, v02057Bean.getNote());
					call.setString(7, v02057Bean.getCd00001Ssgx());
					call.setString(8, v02057Bean.getXqnm());
					call.setString(9, v02057Bean.getXqdmhm());
					call.execute();
					rs = (ResultSet)call.getObject(1);
					if(null != rs && rs.next()){
						if(rs.getInt("flag") == 0){
							sResultCount++;
							v02057Bean.setCd00001Szqy(rs.getString("SZQYID"));
							v02057Bean.setCd02050Xqdm(rs.getString("XQDM"));
							v02057Bean.setDmhId(rs.getString("TDMH"));
							v02057Bean.setImpErrorMsg("");
							v02057Bean.setCd00001Fwlx(rs.getString("TFWLX"));
							tempList.add(v02057Bean);
							v02057.setOutList(tempList);
						}
					}
					tran.commit();
				}catch(Exception e){
					tran.rollback();
					sResultCount++;
					e.printStackTrace();
					v02057Bean.setImpErrorMsg(e.getMessage());
					tempList.add(v02057Bean);
					v02057.setOutList(tempList);
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
				//WriteLogImp(v02057List.get(0).getCd00001Ssgx(), "PGT02057", v02057List.get(0).getCd00002Czr(), "资本化率系数修正导入成功");
			}else if(sResultCount > 0 && fResultCount == 0){
				resultValue = 1;
				//WriteLogImp(v02057List.get(0).getCd00001Ssgx(), "PGT02057", v02057List.get(0).getCd00002Czr(), "资本化率系数修正导入有异常");
			}
			v02057.setOutFlag(resultValue);
		}
		return v02057;
	}
	
	


	@Override
	public boolean GetUpdateCommandA(Pgt02057 t02057Bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02057A(?,?,?,?,?,?)}");
			call.setString(1, t02057Bean.getCd00001Fwlx());
			call.setString(2, t02057Bean.getCd02050Xqdm());
			call.setDouble(3, t02057Bean.getZbhl());
			call.setString(4, t02057Bean.getCd00002Czr());
			call.setString(5, t02057Bean.getNote());
			call.setString(6, t02057Bean.getCd00001Ssgx());			
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
	public boolean GetInsertCommandA(Pgt02057 t02057Bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02057A(?,?,?,?,?,?)}");
			call.setString(1, t02057Bean.getCd00001Fwlx());
			call.setString(2, t02057Bean.getCd02050Xqdm());
			call.setDouble(3, t02057Bean.getZbhl());
			call.setString(4, t02057Bean.getCd00002Czr());
			call.setString(5, t02057Bean.getNote());
			call.setString(6, t02057Bean.getCd00001Ssgx());		
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
	public Pgt02057 LoadByPrimaryKeyA(Pgt02057 t02057Bean) throws Exception {
		ArrayList<Pgt02057> listResult = new ArrayList<Pgt02057>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02057A(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, t02057Bean.getCd00001Fwlx());
			call.setString(3, t02057Bean.getCd02050Xqdm());
			
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetTParametersA(rs));			
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return t02057Bean;
	}


	@Override
	public ArrayList<Pgv02057> LoadAllA(Pgv02057 t02057Bean) throws Exception {
		ArrayList<Pgv02057> listResult = new ArrayList<Pgv02057>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02057A(?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, t02057Bean.getPageIndex());
			call.setInt(3, t02057Bean.getPageSize());
			call.setString(4, t02057Bean.getCd00001Fwlx());			
			call.setString(5, t02057Bean.getCd00001Szqy());
			call.setString(6, t02057Bean.getCd00001Ssgx());
			call.setString(7, t02057Bean.getCd02050Xqdm());
			call.execute();
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVParametersA(rs));
			}
		} catch (Exception e) {
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
	protected Pgt02057 SetTParametersA(ResultSet rs) throws Exception {
		Pgt02057 e = new Pgt02057();
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setFwlx(rs.getString(FWLX));
		e.setCd02050Xqdm(rs.getString(CD02050XQDM));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setZbhl(rs.getDouble(ZBHL));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setXqnm(rs.getString(XQNM));
		return e;
	}

	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv02057 SetVParametersA(ResultSet rs) throws Exception {
		Pgv02057 e = new Pgv02057();
		e.setSzqy(rs.getString(SZQY));
		e.setCd02050Xqdm(rs.getString(CD02050XQDM));
		e.setXqdmhm(rs.getString(XQDMHM));
		e.setXqnm(rs.getString(XQNM));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setFwlx(rs.getString(FWLX));
		e.setZbhl(rs.getDouble(ZBHL));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setCzr(rs.getString(CZR));
		e.setNote(rs.getString(NOTE));
		e.setRecordCount(rs.getInt(TOTAL));
		return e;
	}

	
}
