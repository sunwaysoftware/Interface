package com.sunway.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt00355DAO;
import com.sunway.util.Common;
import com.sunway.vo.Pgt00355;
import com.sunway.vo.Pgv00355;


/**
 * @category 市场法楼层系数
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00355DAO extends BaseDAO implements IPgt00355DAO {
	
	private static final String CD00001SZQYLX = "cd_00001_szqylx";	//所在区域类型
	private static final String CD00001SZQY = "cd_00001_szqy";;		//所在区域编码
	private static final String SZQY =  "szqy";						//所在区域名称
	private static final String CD00002PSSD = "cd_00002_pssd";		//评税时点
	private static final String XZXS = "xzxs";						//修正系数
	private static final String LC =  "lc";							//楼层
	private static final String ZCS =  "zcs";						//总楼层
	private static final String UPDDATE="upddate";					//更改时间
	private static final String CD00002CZR = "cd_00002_czr";		//操作人编号	
	private static final String CZR = "czr";						//操作人
	private static final String NOTE = "note";						//备注信息
	private static final String RID = "rid";						//行号
	private static final String TOTAL = "total";					//总纪录数
	private static final String CZLX = "czlx";						//操作类型
	//private static final String YWDT = "ywdt";						//操作类型
	private static final String cd00001Fwlx = "CD_00001_FWLX";
	private static final String CD00001FWLXLX = "CD_00001_FWLXLX";
	private static final String FWLX = "fwlx";
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00355 lcxz) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00355(?,?,?,?,?,?,?,?)}");
			call.setString(1, lcxz.getCd00001Szqy());
			call.setString(2, lcxz.getCd00001Szqylx());
			call.setString(3, lcxz.getCd00002Pssd());
			call.setShort(4, lcxz.getLc());
			call.setShort(5, lcxz.getZcs());
			call.setString(6, lcxz.getCd00002Czr());
			call.setString(7, lcxz.getCd00001Ssgx());
			//call.setInt(8, lcxz.getYwdt());
			call.setString(8, lcxz.getCd00001Fwlx());
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
	public boolean GetDeleteSelCommand(Pgv00355 lcxz) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT003551(?,?,?)}");
			call.setString(1, lcxz.getChkSel());
			call.setString(2, lcxz.getCd00002Czr());
			call.setString(3, lcxz.getCd00001Ssgx());
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
	public boolean GetInsertCommand(Pgt00355 lcxz) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00355(?,?,?,?,?,?,?,?,?,?,?)}");
			call.setShort(1, lcxz.getLc());
			call.setShort(2, lcxz.getZcs());
			call.setString(3, lcxz.getCd00001Szqylx());
			call.setString(4, lcxz.getCd00001Szqy());
			call.setString(5, lcxz.getCd00002Pssd());
			call.setDouble(6, lcxz.getXzxs());
			call.setString(7, lcxz.getCd00002Czr());
			call.setString(8, lcxz.getNote());
			call.setString(9, lcxz.getCd00001Ssgx());
			call.setInt(10, lcxz.getCzlx());
			//call.setInt(11, lcxz.getYwdt());
			call.setString(11, lcxz.getCd00001Fwlx());
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
	public boolean GetUpdateCommand(Pgt00355 lcxz) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00355(?,?,?,?,?,?,?,?,?,?,?)}");
			call.setShort(1, lcxz.getLc());
			call.setShort(2, lcxz.getZcs());
			call.setString(3, lcxz.getCd00001Szqylx());
			call.setString(4, lcxz.getCd00001Szqy());
			call.setString(5, lcxz.getCd00002Pssd());
			call.setDouble(6, lcxz.getXzxs());
			call.setString(7, lcxz.getCd00002Czr());
			call.setString(8, lcxz.getNote());
			call.setString(9, lcxz.getCd00001Ssgx());
			call.setInt(10, lcxz.getCzlx());
			//call.setInt(11, lcxz.getYwdt());
			call.setString(11, lcxz.getCd00001Fwlx());
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
	public ArrayList<Pgv00355> LoadAll(Pgv00355 lcxz) throws Exception {
		ArrayList<Pgv00355> listResult = new ArrayList<Pgv00355>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00355(?,?,?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, lcxz.getPageIndex());
			call.setInt(3, lcxz.getPageSize());
			call.setShort(4, lcxz.getLc());
			call.setShort(5, lcxz.getZcs());
			call.setString(6, lcxz.getCd00001Szqy());
			call.setString(7, lcxz.getCd00002Pssd());
			call.setString(8, lcxz.getCd00001Ssgx());
			call.setString(9, lcxz.getCd00001Fwlx());
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
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00355 SetVParameters(ResultSet rs) throws Exception {
		Pgv00355 e = new Pgv00355();
		e.setLc(rs.getShort(LC));
		e.setZcs(rs.getShort(ZCS));
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
		e.setRecordIndex(rs.getInt(RID));
		e.setCzlx(rs.getInt(CZLX));
		//e.setYwdt(rs.getInt(YWDT));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Fwlxlx(rs.getString(CD00001FWLXLX));
		e.setFwlx(rs.getString(FWLX));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt00355 LoadByPrimaryKey(Pgt00355 lcxz) throws Exception {
		ArrayList<Pgt00355> listResult = new ArrayList<Pgt00355>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00355(?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, lcxz.getCd00001Szqy());
			call.setString(3, lcxz.getCd00001Szqylx());
			call.setString(4, lcxz.getCd00002Pssd());
			call.setShort(5,lcxz.getLc());
			call.setShort(6,lcxz.getZcs());
			//call.setInt(7, lcxz.getYwdt());
			call.setString(7, lcxz.getCd00001Fwlx());
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
			return lcxz;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00355 SetTParameters(ResultSet rs) throws Exception {
		Pgt00355 e = new Pgt00355();
		e.setLc(rs.getShort(LC));
		e.setZcs(rs.getShort(ZCS));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
//		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setXzxs(rs.getDouble(XZXS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setCzlx(rs.getInt(CZLX));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setFwlx(rs.getString(FWLX));
		//e.setYwdt(rs.getInt(YWDT));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExecuteParamCopy(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean ExecuteParamCopy(Pgt00355 lcxz) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {	
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00355(?,?,?,?,?)}");
			call.setString(1, lcxz.getSpssd());
			call.setString(2, lcxz.getTpssd());
			call.setString(3, lcxz.getCd00001Szqy());
			call.setString(4, lcxz.getCd00002Czr());
			call.setString(5, lcxz.getCd00001Ssgx());
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
	public OutputStream ExportLXCZSjcx(Pgv00355 lcxz) throws Exception {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00355(?,?,?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, lcxz.getPageIndex());
			call.setInt(3, lcxz.getPageSize());
			call.setShort(4, lcxz.getLc());
			call.setShort(5, lcxz.getZcs());
			call.setString(6, lcxz.getCd00001Szqy());
			call.setString(7, lcxz.getCd00002Pssd());
			call.setString(8, lcxz.getCd00001Ssgx());
			call.setString(9, lcxz.getCd00001Fwlx());
			call.execute();
			rs = (ResultSet) call.getObject(1); 
			if(rs!=null){
				// 创建excel对象
		        Label label;   
		        WritableWorkbook workbook; 
	            workbook = Workbook.createWorkbook(strBufResult);   
	            WritableSheet sheet = workbook.createSheet("查询信息", 0);
	            WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
	            WritableCellFormat wcf = new WritableCellFormat(wf); 
	            wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
	            wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
	            wcf.setBackground(Colour.GREEN);
	            // 写入标头
	            label = new Label(0, 0, "所在区域",wcf);
				sheet.addCell(label);	
				label = new Label(1, 0, "楼层",wcf);
				sheet.addCell(label);	
				label = new Label(2, 0, "总楼层",wcf);
				sheet.addCell(label);	          
				label = new Label(3, 0, "修正值(%)",wcf);
				sheet.addCell(label);
				label = new Label(4, 0, "运算类别",wcf);
				sheet.addCell(label);	
				//label = new Label(5, 0, "有无电梯");
				label = new Label(5, 0, "房屋类型",wcf);
				sheet.addCell(label);
				label = new Label(6, 0, "更新时间",wcf);
				sheet.addCell(label);
				label = new Label(7, 0, "操作人",wcf);
				sheet.addCell(label);
				label = new Label(8, 0, "备注",wcf);
				sheet.addCell(label);
				
				
				
			
				   // 写入数据
				while(null!=rs && rs.next()){
					Integer rowIndex = rs.getRow();
					label = new Label(0, rowIndex, rs.getString(SZQY));
					sheet.addCell(label);	
					label = new Label(1, rowIndex, rs.getString(LC));
					sheet.addCell(label);		
					label = new Label(2, rowIndex, rs.getString(ZCS));
					sheet.addCell(label);	
					label = new Label(3, rowIndex, rs.getString(XZXS));
					sheet.addCell(label);
					if("0".equals(rs.getString(CZLX))){
						label = new Label(4, rowIndex, "乘法");
					}else{
						label = new Label(4, rowIndex, "加法");
					}
					sheet.addCell(label);	
					//label = new Label(5, rowIndex, (rs.getString(YWDT)=="1")?"是":"否");
					label = new Label(5, rowIndex, rs.getString(FWLX));
					sheet.addCell(label);		
					label = new Label(6, rowIndex, Common.formatExportDateTime(rs, UPDDATE));
					sheet.addCell(label);
					label = new Label(7, rowIndex, rs.getString(CZR));
					sheet.addCell(label);
					label = new Label(8, rowIndex, rs.getString(NOTE));
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
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00352DAO#ImportExcelData(java.util.ArrayList)
	 */
	
	@Override
	public Pgv00355 ImportExcelData(ArrayList<Pgv00355> ebList) throws Exception {
		Pgv00355 v00355 = new Pgv00355();
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
			call = conn.prepareCall("{call PGSP_ADDT003551(?,?,?,?,?,?,?,?,?,?,?)}");
			for(int i=0; i<ebList.size(); i++){
				Pgv00355 bean = ebList.get(i);
				try {//注册数据参数
					call.registerOutParameter(1, OracleTypes.CURSOR);
					//注册输出参数
					call.setShort(2, bean.getLc());
					call.setShort(3, bean.getZcs());
					//call.setString(3, bean.getCd0001Szqylx());
					call.setString(4, bean.getSzqy());
					call.setString(5, bean.getCd00002Pssd());
					call.setDouble(6, bean.getXzxs());
					call.setString(7, bean.getCd00002Czr());
					call.setString(8, bean.getNote());
					call.setString(9, bean.getCd00001Ssgx());
					call.setInt(10,bean.getCzlx());
					call.setString(11, bean.getFwlx());
					//call.setInt(11, bean.getYwdt());
					call.execute();
					
					rs = (ResultSet) call.getObject(1); 
					if (null!=rs && rs.next()) {
						if (rs.getInt("FLAG") == 0) {
							sResultCount++;
							//标记哪列字段错误
							bean.setSzqyId(rs.getString("SQZY"));
							bean.setFwlxId(rs.getString("FWLX"));
							bean.setCwxx("");
							//将数据封装到list
							v00355.getOutList().add(bean);
						}
						rs.close();
					}
				} catch (Exception e) {
					sResultCount++;
					bean.setCwxx(e.getMessage());
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
			v00355.setOutFlag(resultValue);
		}
		return v00355;
	}
}
