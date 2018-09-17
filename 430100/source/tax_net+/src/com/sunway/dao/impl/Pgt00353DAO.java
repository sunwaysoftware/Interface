package com.sunway.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00353DAO;
import com.sunway.util.FormatUtil;
import com.sunway.vo.Pgt00353;
import com.sunway.vo.Pgv00353;


/**
 * @category 市场法采光修正系数
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00353DAO extends BaseDAO implements IPgt00353DAO {

	private static final String CD00001ROOT = "cd_00001_root";		//采光状况类型编号
	private static final String ROOTNM = "rootnm";					//采光状况类型
	private static final String CD00001INFOID = "cd_00001_infoid";	//采光状况编号
	private static final String INFONM = "infonm";					//采光状况名称
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
	private static final String CZLX = "czlx";						//操作类型
	private static final String cd00001Fwlx = "CD_00001_FWLX";
	private static final String CD00001FWLXLX = "CD_00001_FWLXLX";
	private static final String FWLX = "fwlx";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00353 cgzk) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00353(?,?,?,?,?,?,?)}");
			call.setString(1, cgzk.getCd00001Root());
			call.setString(2, cgzk.getCd00001Infoid());
			call.setString(3, cgzk.getCd00001Szqy());
			call.setString(4, cgzk.getCd00001Szqylx());
			call.setString(5, cgzk.getCd00002Pssd());
			call.setString(6, cgzk.getCd00002Czr());
			call.setString(7, cgzk.getCd00001Ssgx());
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
	public boolean GetInsertCommand(Pgt00353 cgzk) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00353(?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, cgzk.getCd00001Root());
			call.setString(2, cgzk.getCd00001Infoid());
			call.setString(3, cgzk.getCd00001Szqy());
			call.setString(4, cgzk.getCd00002Pssd());
			call.setDouble(5, cgzk.getXzxs());
			call.setString(6, cgzk.getCd00002Czr());
			call.setString(7, cgzk.getNote());
			call.setString(8, cgzk.getCd00001Ssgx());
			call.setInt(9, cgzk.getCzlx());
			call.setString(10, cgzk.getCd00001Fwlx());
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
	public boolean GetUpdateCommand(Pgt00353 cgzk) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00353(?,?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, cgzk.getCd00001Root());
			call.setString(2, cgzk.getCd00001Infoid());
			call.setString(3, cgzk.getCd00001Szqylx());
			call.setString(4, cgzk.getCd00001Szqy());
			call.setString(5, cgzk.getCd00002Pssd());
			call.setDouble(6, cgzk.getXzxs());
			call.setString(7, cgzk.getCd00002Czr());
			call.setString(8, cgzk.getNote());		
			call.setString(9, cgzk.getCd00001Ssgx());
			call.setInt(10, cgzk.getCzlx());
			call.setString(11, cgzk.getCd00001Fwlx());
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
	public ArrayList<Pgv00353> LoadAll(Pgv00353 cgzk) throws Exception {
		ArrayList<Pgv00353> listResult = new ArrayList<Pgv00353>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00353(?,?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, cgzk.getPageIndex());
			call.setInt(3, cgzk.getPageSize());
			call.setString(4, cgzk.getCd00001Root());
			call.setString(5, cgzk.getCd00001Infoid());
			call.setString(6, cgzk.getCd00001Szqy());
			call.setString(7, cgzk.getCd00002Pssd());
			call.setString(8, cgzk.getCd00001Ssgx());
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
	
	
	@Override
	public OutputStream ExportZHXZSjcx(Pgv00353 cgzk) throws Exception {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00353(?,?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, cgzk.getPageIndex());
			call.setInt(3, cgzk.getPageSize());
			call.setString(4, cgzk.getCd00001Root());
			call.setString(5, cgzk.getCd00001Infoid());
			call.setString(6, cgzk.getCd00001Szqy());
			call.setString(7, cgzk.getCd00002Pssd());
			call.setString(8, cgzk.getCd00001Ssgx());
			call.execute();
			rs = (ResultSet) call.getObject(1); 
			if(rs!=null){
				// 创建excel对象
		        Label label;   
		        WritableWorkbook workbook; 
	            workbook = Workbook.createWorkbook(strBufResult);   
	            WritableSheet sheet = workbook.createSheet("综合修正信息", 0);
	            // 写入标头
	            label = new Label(0, 0, "所在区域");
				sheet.addCell(label);	
				label = new Label(1, 0, "类型名称");
				sheet.addCell(label);	
				label = new Label(2, 0, "房屋类型");
				sheet.addCell(label);	          
				label = new Label(3, 0, "修正值(%)");
				sheet.addCell(label);
				label = new Label(4, 0, "运算类别");
				sheet.addCell(label);	
				label = new Label(5, 0, "更新时间");
				sheet.addCell(label);
				label = new Label(6, 0, "操作人");
				sheet.addCell(label);
				label = new Label(7, 0, "备注");
				sheet.addCell(label);
				
				
				
			
				   // 写入数据
				while(null!=rs && rs.next()){
					Integer rowIndex = rs.getRow();
					label = new Label(0, rowIndex, rs.getString(SZQY));
					sheet.addCell(label);			
					label = new Label(1, rowIndex, rs.getString(ROOTNM));
					sheet.addCell(label);	
					label = new Label(2, rowIndex, rs.getString(FWLX));
					sheet.addCell(label);
					label = new Label(3, rowIndex, rs.getString(XZXS));
					sheet.addCell(label);
					if("0".equals(rs.getString(CZLX))){
						label = new Label(4, rowIndex, "乘法");
					}else{
						label = new Label(4, rowIndex, "加法");
					}
					sheet.addCell(label);	
					label = new Label(5, rowIndex, FormatUtil.toYMDHMS(rs.getTimestamp(UPDDATE)));
					sheet.addCell(label);
					label = new Label(6, rowIndex, rs.getString(CZR));
					sheet.addCell(label);
					label = new Label(7, rowIndex, rs.getString(NOTE));
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
	public Pgv00353 ImportExcelData(ArrayList<Pgv00353> ebList) throws Exception {
		Pgv00353 v00353 = new Pgv00353();
		ArrayList<Pgv00353> tempList = new ArrayList<Pgv00353>();
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
			call = conn.prepareCall("{call PGSP_ADDT003531(?,?,?,?,?,?,?,?)}");
			for(int i=0; i<ebList.size(); i++){
				Pgv00353 bean = ebList.get(i);
				try {//注册数据参数
					call.registerOutParameter(1, OracleTypes.CURSOR);
					//注册输出参数
					call.setString(2, bean.getLxmc());
					call.setDouble(3, bean.getXzxs());
					call.setString(4, bean.getFwlx());
					call.setString(5, bean.getCd00002Czr());
					call.setString(6, bean.getCd00001Ssgx());
					call.setString(7, bean.getSzqy());
					call.setInt(8, bean.getCzlx());
					call.execute();
					
					rs = (ResultSet) call.getObject(1); 
					if (null!=rs && rs.next()) {
						if (rs.getInt("FLAG") == 0) {
							sResultCount++;
							//标记哪列字段错误
							bean.setCd00001Szqy(rs.getString("SZQYID"));
							bean.setCd00001Fwlx(rs.getString("TFWLX"));
							bean.setCd00001Infoid(rs.getString("INFOID"));
							bean.setCwxx("");
							//将数据封装到list
							tempList.add(bean);
							v00353.setOutList(tempList);
						}
						rs.close();
					}
				} catch (Exception e) {
					sResultCount++;
					bean.setCwxx(e.getMessage());
					tempList.add(bean);
					v00353.setOutList(tempList);
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
			v00353.setOutFlag(resultValue);
		}
		return v00353;
	}
	
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00353 SetVParameters(ResultSet rs) throws Exception {
		Pgv00353 e = new Pgv00353();
		e.setCd00001Root(rs.getString(CD00001ROOT));
		e.setCd00001Infoid(rs.getString(CD00001INFOID));
		e.setRootNm(rs.getString(ROOTNM));
		e.setInfoNm(rs.getString(INFONM));
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
		e.setCzlx(rs.getInt(CZLX));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Fwlxlx(rs.getString(CD00001FWLXLX));
		e.setFwlx(rs.getString(FWLX));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt00353 LoadByPrimaryKey(Pgt00353 cgzk) throws Exception {
		ArrayList<Pgt00353> listResult = new ArrayList<Pgt00353>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00353(?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, cgzk.getCd00001Root());
			call.setString(3, cgzk.getCd00001Infoid());
			call.setString(4, cgzk.getCd00001Szqy());
			call.setString(5, cgzk.getCd00001Szqylx());
			call.setString(6, cgzk.getCd00002Pssd());
			call.setString(7, cgzk.getCd00001Fwlx());
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
			return cgzk;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00353 SetTParameters(ResultSet rs) throws Exception {
		Pgt00353 e = new Pgt00353();
		e.setCd00001Root(rs.getString(CD00001ROOT));
		e.setCd00001Infoid(rs.getString(CD00001INFOID));
		e.setInfoNm(rs.getString(INFONM));
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
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExecuteParamCopy(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean ExecuteParamCopy(Pgt00353 cgzk) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {	
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00353(?,?,?,?,?)}");
			call.setString(1, cgzk.getSpssd());
			call.setString(2, cgzk.getTpssd());
			call.setString(3, cgzk.getCd00001Szqy());
			call.setString(4, cgzk.getCd00002Czr());
			call.setString(5, cgzk.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt00353DAO#LoadObj()
	 */
	
	@Override
	public Map<String, String> LoadObj(Pgt00353 cgzk) throws Exception {
		Map<String, String> listResult = new HashMap<String, String>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLCZ00353(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//输入参数
			call.setString(2, cgzk.getCd00001Szqy());
			call.execute();
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.put(rs.getString(1), rs.getString(2)) ;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
}
