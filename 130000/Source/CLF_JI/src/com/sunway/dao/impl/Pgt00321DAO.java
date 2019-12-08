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

import com.sunway.dao.IPgt00321DAO;
import com.sunway.util.Common;
import com.sunway.vo.Pgt00321;
import com.sunway.vo.Pgv00321;




/**
 * @category 市场法楼层系数
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00321DAO extends BaseDAO implements IPgt00321DAO {
	

	private static final String CD00001SZQY = "cd_00001_szqy";;		//所在区域编码
	private static final String SZQY =  "szqy";						//所在区域名称
	private static final String ZLC =  "zlc";							//楼层
	private static final String SZLC =  "szlc";						//总楼层
	private static final String UPDDATE="upddate";					//更改时间
	private static final String CD00002CZR = "cd_00002_czr";		//操作人编号	
//	private static final String CZR = "czr";						//操作人
	private static final String NOTE = "note";						//备注信息
	private static final String cd00001Fwlx = "CD_00001_FWLX";
	private static final String FWLX = "fwlx";
	private static final String TOTAL = "total";
	private static final String RID = "rid";	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	
	public boolean GetDeleteCommand(Pgt00321 lcxz) throws Exception {
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
	
	public boolean GetDeleteSelCommand(Pgv00321 lcxz) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT003211(?,?,?)}");
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
	public boolean GetInsertCommand(Pgt00321 lcxz) throws Exception {
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
	public boolean GetUpdateCommand(Pgt00321 lcxz) throws Exception {
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
	public ArrayList<Pgv00321> LoadAll(Pgv00321 lcxz) throws Exception {
		ArrayList<Pgv00321> listResult = new ArrayList<Pgv00321>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00321(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, lcxz.getPageIndex());
			call.setInt(3, lcxz.getPageSize());
			call.setString(4, lcxz.getCd00001Szqy());
			call.setString(5, lcxz.getCd00352Xqdm());
			call.setString(6, lcxz.getCd00001Ssgx());
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
	protected Pgv00321 SetVParameters(ResultSet rs) throws Exception {
		Pgv00321 e = new Pgv00321();
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		e.setLc(rs.getShort(SZLC));
		e.setZcs(rs.getShort(ZLC));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setSzqy(rs.getString(SZQY));
		e.setPgjg(rs.getDouble("PGJG"));
		e.setCd00352Xqdm(rs.getString("CD_00352_XQDM"));
		e.setXqdm(rs.getString("XQNM"));
		e.setZcdzl(rs.getString("ZCDZL"));
		e.setJzjg(rs.getString("JZJG"));
		e.setCd00001Jzjg(rs.getString("CD_00001_JZJG"));
		e.setJzmj(rs.getDouble("JZMJ"));
		e.setJysj(rs.getDate("JYSJ"));
		e.setClh(rs.getString("CLH"));
		e.setZh(rs.getString("ZH"));
		e.setDyh(rs.getString("DYH"));
		e.setFh(rs.getString("FH"));
		e.setJcnf(rs.getString("JCNF"));
		e.setFcid(rs.getString("FCID"));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setCzr(rs.getString("CZR"));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setFwlx(rs.getString(FWLX));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt00321 LoadByPrimaryKey(Pgt00321 lcxz) throws Exception {
		ArrayList<Pgt00321> listResult = new ArrayList<Pgt00321>();
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
	protected Pgt00321 SetTParameters(ResultSet rs) throws Exception {
		Pgt00321 e = new Pgt00321();
//		e.setLc(rs.getShort(LC));
//		e.setZcs(rs.getShort(ZCS));
//		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
//		e.setCd00001Szqy(rs.getString(CD00001SZQY));
////		e.setCd00002Pssd(rs.getString(CD00002PSSD));
//		e.setXzxs(rs.getDouble(XZXS));
//		e.setUpddate(rs.getTimestamp(UPDDATE));
//		e.setCd00002Czr(rs.getString(CD00002CZR));
//		e.setNote(rs.getString(NOTE));
//		e.setCzlx(rs.getInt(CZLX));
//		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
//		e.setFwlx(rs.getString(FWLX));
//		//e.setYwdt(rs.getInt(YWDT));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExecuteParamCopy(com.sunway.vo.Pgt10051)
	 */
	
	public boolean ExecuteParamCopy(Pgt00321 lcxz) throws Exception {
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
	public OutputStream ExportLXCZSjcx(Pgv00321 lcxz) throws Exception {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00321(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, lcxz.getPageIndex());
			call.setInt(3, lcxz.getPageSize());
			call.setString(4, lcxz.getCd00001Szqy());
			call.setString(5, lcxz.getCd00352Xqdm());
			call.setString(6, lcxz.getCd00001Ssgx());
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
	            int j = 0;
	            // 写入表头

	            //A.所在区域
	    		label = new Label(j++, 0, "所在区域" ,wcf);
	    		sheet.addCell(label);
	    		//B.小区名称
	    		label = new Label(j++, 0, "小区名称" ,wcf);
	    		sheet.addCell(label);
	    		//C.坐落地址	
	    		label = new Label(j++, 0, "坐落地址" ,wcf);
	    		sheet.addCell(label);
	    		//D.幢号
	    		label = new Label(j++, 0, "幢号" ,wcf);
	    		sheet.addCell(label);
	    		//E.单元号
	    		label = new Label(j++, 0, "" ,wcf);
	    		sheet.addCell(label);
	    		 //F.房号	
	    		label = new Label(j++, 0, "房号" ,wcf);
	    		sheet.addCell(label);
	    		//G.测量号	
	    		label = new Label(j++, 0, "测量号" ,wcf);
	    		sheet.addCell(label);
	    		//H. 房屋类别
	    		label = new Label(j++, 0, "房屋类别" ,wcf);
	    		sheet.addCell(label);	
	    		//I.楼层
	    		label = new Label(j++, 0, "单元号" ,wcf);
	    		sheet.addCell(label);
	    		//J.总楼层
	    		label = new Label(j++, 0, "总楼层" ,wcf);
	    		sheet.addCell(label);
	    		//K.建设年份
	    		label = new Label(j++, 0, "建设年份" ,wcf);
	    		sheet.addCell(label);
	    		//L.建筑结构
	    		label = new Label(j++, 0, "建筑结构" ,wcf);
	    		sheet.addCell(label);
	    		//M.建筑面积（㎡）
	    		label = new Label(j++, 0, "建筑面积（㎡）" ,wcf);
	    		sheet.addCell(label);
	    		//N.评估价格（元/㎡）
	    		label = new Label(j++, 0, "评估价格（元/㎡）" ,wcf);
	    		sheet.addCell(label);
	    		//O.交易日期
	    		label = new Label(j++, 0, "交易日期" ,wcf);
	    		sheet.addCell(label);
	    		//P.综合修正
	    		label = new Label(j++, 0, "综合修正" ,wcf);
	    		sheet.addCell(label);
	    		//Q.备注
	    		//label = new Label(j++, 0, "备注" ,wcf);
	    		//sheet.addCell(label);
				
				
				
			
				   // 写入数据
				while(null!=rs && rs.next()){
					Integer rowIndex = rs.getRow();
					label = new Label(0, rowIndex, rs.getString(SZQY));
					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString("XQNM"));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString("ZCDZL"));
					sheet.addCell(label);
					label = new Label(3, rowIndex, rs.getString("ZH"));
					sheet.addCell(label);
					label = new Label(4, rowIndex, rs.getString("DYH"));
					sheet.addCell(label);
					label = new Label(5, rowIndex, rs.getString("FH"));
					sheet.addCell(label);
					label = new Label(6, rowIndex, rs.getString("CLH"));
					sheet.addCell(label);
					label = new Label(7, rowIndex, rs.getString(FWLX));
					sheet.addCell(label);
					label = new Label(8, rowIndex, rs.getString("SZLC"));
					sheet.addCell(label);
					label = new Label(9, rowIndex, rs.getString("ZLC"));
					sheet.addCell(label);
					label = new Label(10, rowIndex, rs.getString("JCNF"));
					sheet.addCell(label);
					label = new Label(11, rowIndex, rs.getString("JZJG"));
					sheet.addCell(label);
					label = new Label(12, rowIndex, rs.getString("JZMJ"));
					sheet.addCell(label);
					label = new Label(13, rowIndex, rs.getString("PGJG"));
					sheet.addCell(label);
					label = new Label(14, rowIndex, rs.getString("JYSJ"));
					sheet.addCell(label);
					label = new Label(15, rowIndex, rs.getString("ZHXZ"));
					sheet.addCell(label);
					//label = new Label(16, rowIndex, rs.getString("NOTE"));
					//sheet.addCell(label);					
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
	public Pgv00321 ImportExcelData(ArrayList<Pgv00321> ebList) throws Exception {
		Pgv00321 v00321 = new Pgv00321();
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
			call = conn.prepareCall("{call PGSP_ADDT003211(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			for(int i=0; i<ebList.size(); i++){
				Pgv00321 bean = ebList.get(i);
				try {//注册数据参数
					call.registerOutParameter(1, OracleTypes.CURSOR);
					//注册输出参数
					call.setString(2, bean.getSzqy());
					call.setString(3, bean.getClh());
					call.setString(4, bean.getZcdzl());
					call.setString(5, bean.getZh());
					call.setString(6, bean.getDyh());
					call.setString(7, bean.getFh());
					call.setString(8, bean.getXqdm());
					call.setString(9, bean.getFwlx());
					call.setShort(10, bean.getZcs());
					call.setShort(11, bean.getLc());
					call.setString(12, bean.getJcnf());
					call.setString(13, bean.getJzjg());
					call.setDouble(14, bean.getJzmj());
					call.setDouble(15, bean.getPgjg());
					call.setDate(16, Common.converDate(bean.getJysj()));
					call.setString(17, bean.getCd00001Ssgx());
					call.setString(18, bean.getCd00002Czr());
					call.setString(19, bean.getNote());
					call.setString(20, bean.getZhxzs());
					call.setString(21, bean.getXqdmh());
					call.execute();
					
					rs = (ResultSet) call.getObject(1); 
					if (null!=rs && rs.next()) {
						if (rs.getInt("FLAG") == 0) {
							sResultCount++;
							//标记哪列字段错误
							bean.setCd00001Szqy(rs.getString("SZQYID"));
							bean.setCd00001Fwlx(rs.getString("TFWLX"));
							bean.setCd00352Xqdm(rs.getString("TXQDM"));
							bean.setCd00001Jzjg(rs.getString("TJZJG"));
							bean.setXqdmhid(rs.getString("TDMH"));
							bean.setZhxzid(rs.getString("TZHXZ"));
							//将数据封装到list
							v00321.getOutList().add(bean);
							bean.setCwxx("");
						}
						rs.close();
					}
				} catch (Exception e) {
					sResultCount++;
					bean.setCwxx(e.getMessage());
//					LOG.error(e.getMessage());
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
			v00321.setOutFlag(resultValue);
		}
		return v00321;
	}
}
