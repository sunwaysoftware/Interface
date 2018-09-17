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

import com.sunway.dao.IPgt02050DAO;
import com.sunway.util.CheckUtil;

import com.sunway.util.Excel;
import com.sunway.util.FormatUtil;
import com.sunway.vo.ExcelBean;
import com.sunway.vo.Pgt02050;
import com.sunway.vo.Pgv02050;

/**
 * 商业评估分区名称维护
 * @author LeiJia
 * @version 1.0
 */
public class Pgt02050DAO extends BaseDAO implements IPgt02050DAO {

	private static final String xqdm =  "XQDM";
	private static final String cd00001Szqylx = "CD_00001_SZQYLX";
	private static final String cd00001Szqy = "CD_00001_SZQY";
	private static final String parentdm =  "PARENTDM";
	private static final String xqnm =  "XQNM";
	private static final String xqbm =  "XQBM";
	private static final String vieworder = "VIEWORDER";
	private static final String upddate =  "UPDDATE";
	private static final String cd00002Czr =  "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String isdir = "ISDIR";
	private static final String szqy =  "SZQY";
	private static final String czr =  "CZR";
	private static final String parentnm =  "PARENTNM";
	private static final String total = "total";
	private static final String level =  "level";
	private static final String JCNF = "jcnf";
	private static final String xqdmhm = "XQDMHM";
	private static final String qdhh = "QDHH";
	private static final String cd00001Fwlx = "CD_00001_FWLX";
	private static final String cd00001Fwlxlx = "CD_00001_FWLXLX";
	private static final String fwlx = "FWLX";
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt02050DAO#LoadAll(com.sunway.vo.Pgv02050)
	 */
	
	@Override
	public ArrayList<Pgv02050> LoadAll(Pgv02050 v02050) throws Exception {
		ArrayList<Pgv02050> listResult = new ArrayList<Pgv02050>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02050(?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v02050.getPageIndex());
			call.setInt(3, v02050.getPageSize());
			call.setString(4, v02050.getXqdm());
			call.setString(5, v02050.getXqnm());
			call.setString(6, v02050.getNote());
			call.setString(7, v02050.getCd00001Szqy());
			call.setString(8, v02050.getSsgx());
			call.setInt(9, v02050.getParId());
			call.setString(10, v02050.getQdh());
			call.setString(11, v02050.getXqdmhm());
			call.setString(12, v02050.getCd00001Fwlx());
			call.execute();
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetVParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt02050DAO#LoadByPrimaryKey(com.sunway.vo.Pgt02050)
	 */
	
	@Override
	public Pgt02050 LoadByPrimaryKey(Pgt02050 t02050) throws Exception {
		ArrayList<Pgt02050> listResult = new ArrayList<Pgt02050>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02050(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t02050.getXqdm());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		if (listResult != null && listResult.size() > 0) {
			return listResult.get(0);
		} else {
			return new Pgt02050();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt02050DAO#GetInsertCommand(com.sunway.vo.Pgt02050)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt02050 t02050) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02050(?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			// 传入输入参数
			call.setString(2, t02050.getCd00001Szqy());
			call.setString(3, t02050.getCd00001Fwlx());
			call.setString(4, t02050.getParentdm().toUpperCase());
			call.setString(5, t02050.getXqnm());
			call.setString(6, t02050.getXqbm());
			call.setShort(7, t02050.getVieworder());
			call.setString(8, t02050.getCd00002Czr());
			call.setString(9, t02050.getNote());
			call.setBoolean(10, CheckUtil.chkNull(t02050.getIsdir()));
			call.setString(11, t02050.getSsgx());
			call.setString(12,  t02050.getXqdmhm().toUpperCase());
			
			call.execute();
			
			tran.commit();
			if(null != call.getString(1)){
				bResult = true;
			}
			
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
	 * @see com.sunway.dao.IPgt02050DAO#GetDeleteCommand(com.sunway.vo.Pgt02050)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt02050 t02050) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02050(?,?,?)}");
			// 传入输入参数
			call.setString(1, t02050.getXqdm());
			call.setString(2, t02050.getCd00002Czr());
			call.setString(3, t02050.getSsgx());
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
	 * @see com.sunway.dao.IPgt02050DAO#GetUpdateCommand(com.sunway.vo.Pgt02050)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt02050 t02050) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02050(?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 传入输入参数
			call.setString(1, t02050.getXqdm());
			call.setString(2, t02050.getCd00001Fwlx());
			call.setString(3, t02050.getCd00001Szqy());
			call.setString(4, t02050.getParentdm());
			call.setString(5, t02050.getXqnm());
			call.setString(6, t02050.getXqbm());
			call.setShort(7, t02050.getVieworder());
			call.setString(8, t02050.getCd00002Czr());
			call.setString(9, t02050.getNote());
			call.setBoolean(10, CheckUtil.chkNull(t02050.getIsdir()));
			call.setString(11, t02050.getSsgx());
			call.setString(12, t02050.getXqdmhm());
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
	 * @see com.sunway.dao.IPgt02050DAO#LoadNavigator(com.sunway.vo.Pgt02050)
	 */
	
	@Override
	public ArrayList<Pgt02050> LoadNavigator(Pgt02050 t02050) throws Exception {
		ArrayList<Pgt02050> listResult = new ArrayList<Pgt02050>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020502(?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 傳入輸入參數
			call.setString(2, t02050.getXqdm());
			
			call.execute();
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetNParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt02050DAO#LoadTreeList(com.sunway.vo.Pgt02050)
	 */
	
	@Override
	public ArrayList<Pgt02050> LoadTreeList(Pgt02050 t02050) throws Exception {
		ArrayList<Pgt02050> listResult = new ArrayList<Pgt02050>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020503(?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 傳入輸入參數
			call.setString(2, t02050.getCd00001Szqy());			
			call.setString(3, t02050.getXqdm());
			call.setString(4, t02050.getNoxqdm());
			call.setString(5, t02050.getCd00001Fwlx());
			call.execute();
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgt02050 e = SetNParameters(rs);
				e.setXqnm(rs.getString(xqdmhm)+":"+rs.getString("XQNM"));
				listResult.add(e);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt02050DAO#LoadNavStream(java.lang.String)
	 */
	
	@Override
	public String LoadNavStream(String xqdm) throws Exception {
		String resultValue = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{? = call FN_GETXQNM_SY(?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			// 注册输入参数
			call.setString(2, xqdm);
			call.execute();
			// 返回数据集
			if(null!=call.getObject(1))
				resultValue = (String) call.getObject(1);
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return resultValue;
	}
	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv02050 SetVParameters(ResultSet rs) throws Exception {
		Pgv02050 e = new Pgv02050();
		e.setRecordCount(rs.getInt(total));
		e.setXqdm(rs.getString(xqdm));
		e.setCd00001Szqylx(rs.getString(cd00001Szqylx));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setParentdm(rs.getString(parentdm));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setVieworder(rs.getShort(vieworder));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setIsdir(rs.getBoolean(isdir));
		e.setSzqy(rs.getString(szqy));
		e.setCzr(rs.getString(czr));
		e.setParentnm(rs.getString(parentnm));
		e.setXqdmhm(rs.getString(xqdmhm));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setFwlx(rs.getString(fwlx));
		e.setCd00001Fwlxlx(rs.getString(cd00001Fwlxlx));
		return e;
	}
	
	protected String formatQDH(String value){
		if(null != value && !"".equals(value)){
			return value.replace(",", " ");
		}else{
			return value;
		}
		
	}

	/**
	 * Edit数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt02050 SetTParameters(ResultSet rs) throws Exception {
		Pgt02050 e = new Pgt02050();
		e.setXqdm(rs.getString(xqdm));
		e.setCd00001Szqylx(rs.getString(cd00001Szqylx));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setParentdm(rs.getString(parentdm));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setVieworder(rs.getShort(vieworder));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setIsdir(rs.getBoolean(isdir));
		//e.setJcnf(rs.getString(JCNF));
		e.setXqdmhm(rs.getString(xqdmhm));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Fwlxlx(rs.getString(cd00001Fwlxlx));
		return e;
	}

	/**
	 * Tree数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt02050 SetNParameters(ResultSet rs) throws Exception {
		Pgt02050 e = new Pgt02050();
		e.setXqdm(rs.getString(xqdm));
		e.setCd00001Szqylx(rs.getString(cd00001Szqylx));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setParentdm(rs.getString(parentdm));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setVieworder(rs.getShort(vieworder));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setIsdir(rs.getBoolean(isdir));
		e.setLevel(rs.getString(level));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Fwlxlx(rs.getString(cd00001Fwlxlx));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02050DAO#ImportExcelData(java.util.ArrayList)
	 */
	
	@Override
	public ExcelBean ImportExcelData(ArrayList<ExcelBean> ebList) throws Exception {
		ExcelBean excelBean = new ExcelBean();
		ArrayList<ExcelBean> tempList = new ArrayList<ExcelBean>();
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
			call = conn.prepareCall("{call PGSP_ADDT020501(?,?,?,?,?,?,?,?,?,?,?)}");			
			for(int i=0; i<ebList.size(); i++){
				
				ExcelBean bean = ebList.get(i);
				try {
					tran = session.beginTransaction();
					call.registerOutParameter(1, OracleTypes.CURSOR);
					
					call.setString(2, bean.getSzqyNm());
					call.setString(3, bean.getFwlxNm());
					call.setString(4, bean.getParentXQNm());
					call.setString(5, bean.getXqNm());
					call.setString(6, bean.getXqbm());
					call.setString(7, bean.getNote());
					call.setString(8, bean.getCd00002Czr());
					call.setString(9, bean.getSsgx());
 					call.setString(10, bean.getDmh().toUpperCase());
 					call.setString(11, bean.getParentDmh().toUpperCase());
 				
					call.execute();
					
					rs = (ResultSet) call.getObject(1); 
					if (null!=rs && rs.next()) {
						if (rs.getInt("flag") == 0) {
							sResultCount++;
							//标记哪列字段错误
							bean.setXqId(rs.getString("XQID"));
							bean.setSzqyId(rs.getString("SZQYID"));
							bean.setParentXQId(rs.getString("PARENTXQID"));
							bean.setDmhId(rs.getString("TDMH"));
							bean.setParengDmhId(rs.getString("TPARENTDMH"));
							bean.setFwlxId(rs.getString("FWLXID"));
							bean.setImpErrorMsg("如若无错误提示，请确定该数据在数据库中不存在。");
							//将数据封装到list
							tempList.add(bean);
							excelBean.setOutExcelList(tempList);
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
					excelBean.setOutExcelList(tempList);
					continue;
				}	finally{
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
			getFree(call, conn, session);
			if(sResultCount == 0){
				resultValue = 2;
				
			}
			else if(sResultCount > 0 && fResultCount == 0){
				resultValue = 1;
			}
			excelBean.setExportOutCome(resultValue);
		}
		return excelBean;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02050DAO#LoadAllByXqzt(com.sunway.vo.Pgv02050)
	 */
	
	@Override
	public ArrayList<Pgv02050> LoadAllByXqzt(Pgv02050 v02050) throws Exception {
		ArrayList<Pgv02050> listResult = new ArrayList<Pgv02050>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020501(?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v02050.getCd00001Szqy());
			call.setString(3, v02050.getSsgx());
			call.setByte(4, v02050.getXqzt());
			call.execute();
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetVParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02050DAO#GetUpdateCommandForXqzt(com.sunway.vo.Pgt02050)
	 */
	
	@Override
	public boolean GetUpdateCommandForXqzt(Pgt02050 t02050) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT020501(?,?,?,?)}");
			// 传入输入参数
			call.setString(1, t02050.getXqdms_able());
			call.setString(2, t02050.getXqdms_unable());
			call.setString(3, t02050.getCd00002Czr());
			call.setString(4, t02050.getSsgx());
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
	 * @see com.sunway.dao.IPgt02050DAO#GetXQNM(com.sunway.vo.Pgt02050)
	 */
	
	@Override
	public ArrayList<String> GetXQNM(Pgt02050 t02050) throws Exception {
		ArrayList<String> listResult = new ArrayList<String>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020506(?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t02050.getXqnm());
			call.setString(3, t02050.getSsgx());
			call.setString(4, t02050.getCd00001Fwlx());
			call.execute();
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(rs.getString(1));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02050DAO#LoadByXqnm(com.sunway.vo.Pgt02050)
	 */
	
	@Override
	public Pgt02050 LoadByXqnm(Pgt02050 t02050) throws Exception {
		ArrayList<Pgt02050> listResult = new ArrayList<Pgt02050>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		
		try {
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020507(?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t02050.getXqnm());
			call.setString(3, t02050.getSsgx());
			call.setString(4, t02050.getCd00001Fwlx());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		if (listResult != null && listResult.size() > 0) {
			return listResult.get(0);
		} else {
			return new Pgt02050();
		}
	}

	
	@Override
	public OutputStream ExportGJFQ(Pgv02050 v02050) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		WritableWorkbook workbook = null;
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		
		try{
			strBufResult = new ByteArrayOutputStream();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020509(?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v02050.getPageIndex());
			call.setInt(3, v02050.getPageSize());
			call.setString(4, v02050.getXqdm());
			call.setString(5, v02050.getXqnm());
			call.setString(6, v02050.getNote());
			call.setString(7, v02050.getCd00001Szqy());
			call.setString(8, v02050.getSsgx());
			call.setInt(9, v02050.getXqtype());
			call.setString(10, v02050.getCd00001Fwlx());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			if(rs != null){
				Label label;
			
				workbook = Workbook.createWorkbook(strBufResult);
				WritableSheet sheet = workbook.createSheet("估价分区", 0);
				WritableCellFormat wcf =Excel.getExcelTitleStyle();
				label = new Label(0, 0, "所在区域",wcf);
				sheet.addCell(label);
				label = new Label(1, 0, "房屋类型",wcf);
				sheet.addCell(label);
				label = new Label(2, 0, "片区代码号",wcf);
				sheet.addCell(label);
				label = new Label(3, 0, "片区名称",wcf);
				sheet.addCell(label);
				label = new Label(4, 0, "分区代码号",wcf);
				sheet.addCell(label);
				label = new Label(5, 0, "分区名称",wcf);
				sheet.addCell(label);
				label = new Label(6, 0, "别名",wcf);
				sheet.addCell(label);				
				/*label = new Label(7, 0, "建成年份",wcf);
				sheet.addCell(label);*/
				
				
				while(rs != null && rs.next()){
					Integer rowIndex = rs.getRow();
					
					label = new Label(0, rowIndex, rs.getString(szqy));
					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString(fwlx));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString("parenthm"));
					sheet.addCell(label);
					label = new Label(3, rowIndex, rs.getString(parentnm));
					sheet.addCell(label);
					label = new Label(4, rowIndex, rs.getString(xqdmhm));
					sheet.addCell(label);
					label = new Label(5, rowIndex, rs.getString(xqnm));
					sheet.addCell(label);
					label = new Label(6, rowIndex, rs.getString(xqbm));
					sheet.addCell(label);					
//					label = new Label(7, rowIndex, ""); //fwlx
//					sheet.addCell(label);
//					label = new Label(8, rowIndex, ""); //jzjg
//					sheet.addCell(label);
					/*label = new Label(7, rowIndex, rs.getString(JCNF));
					sheet.addCell(label);*/
//					label = new Label(10, rowIndex, ""); //jzsd
//					sheet.addCell(label);
//					label = new Label(11, rowIndex, FormatUtil.toYMDHMS(rs,upddate));
//					sheet.addCell(label);
//					label = new Label(12, rowIndex, rs.getString(czr));
//					sheet.addCell(label);
				}
				workbook.write();
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			if(null !=strBufResult){
				try{
					strBufResult.flush();
					strBufResult.close();
				}catch(Exception e1){}
			}
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
	public ArrayList<Pgv02050> loadAllGJFQDQ(Pgv02050 v02050) throws Exception {
		ArrayList<Pgv02050> resultList = new ArrayList<Pgv02050>();
		Connection conn = null;
		
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020508(?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v02050.getPageIndex());
			call.setInt(3, v02050.getPageSize());
			call.setString(4, v02050.getXqdm());
			call.setString(5, v02050.getXqnm());
			call.setString(6, v02050.getXqdmhm());
			call.setString(7, v02050.getCd00001Szqy());
			call.setString(8, v02050.getSsgx());
			call.setString(9, v02050.getCd00001Fwlx());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(rs != null && rs.next()){
				resultList.add(SetVParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return resultList;
	}

	
	@Override
	public ArrayList<Pgv02050> loadAllGJFQXQ(Pgv02050 v02050) throws Exception {
		ArrayList<Pgv02050> resultList = new ArrayList<Pgv02050>();
		Connection conn = null;
		
		ResultSet rs = null;
		CallableStatement call = null;
		try{
			
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020509(?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v02050.getPageIndex());
			call.setInt(3, v02050.getPageSize());
			call.setString(4, v02050.getXqdm());
			call.setString(5, v02050.getXqnm());
			call.setString(6, v02050.getNote());
			call.setString(7, v02050.getCd00001Szqy());
			call.setString(8, v02050.getSsgx());
			call.setInt(9, v02050.getXqtype());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(rs != null & rs.next()){
				resultList.add(SetVParameters(rs));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return resultList;
	}

	
	@Override
	public OutputStream ExportGJFQDQ(Pgv02050 v02050) throws Exception {
		ByteArrayOutputStream strBufResult = null;
		WritableWorkbook workbook = null;
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		
		try{
			strBufResult = new ByteArrayOutputStream();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020508(?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v02050.getPageIndex());
			call.setInt(3, v02050.getPageSize());
			call.setString(4, v02050.getXqdm());
			call.setString(5, v02050.getXqnm());
			call.setString(6, v02050.getNote());
			call.setString(7, v02050.getCd00001Szqy());
			call.setString(8, v02050.getSsgx());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			if(rs != null){
				Label label;

				workbook = Workbook.createWorkbook(strBufResult);
				WritableSheet sheet = workbook.createSheet("估价分区", 0);
				WritableCellFormat wcf =Excel.getExcelTitleStyle();
				label = new Label(0, 0, "所在区域",wcf);
				sheet.addCell(label);
				label = new Label(1, 0, "片区代码号",wcf);
				sheet.addCell(label);
				label = new Label(2, 0, "片区名称",wcf);
				sheet.addCell(label);
				label = new Label(3, 0, "分区代码号",wcf);
				sheet.addCell(label);
				label = new Label(4, 0, "分区名称",wcf);
				sheet.addCell(label);
				label = new Label(5, 0, "别名",wcf);
				sheet.addCell(label);
				label = new Label(6, 0, "丘(地)号",wcf);
				sheet.addCell(label);
				label = new Label(7, 0, "房屋类型",wcf);
				sheet.addCell(label);
				label = new Label(8, 0, "基准价格(元/㎡)",wcf);
				sheet.addCell(label);
				label = new Label(9, 0, "建成年份",wcf);
				sheet.addCell(label);			
				label = new Label(10, 0, "基准时点",wcf);
				sheet.addCell(label);
				label = new Label(11, 0, "更新时间",wcf);
				sheet.addCell(label);
				label = new Label(12, 0, "操作人",wcf);
				sheet.addCell(label);
				
				while(rs != null && rs.next()){
					Integer rowIndex = rs.getRow();
					
					/*label = new Label(0, rowIndex, rs.getString());
					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString(xqnm));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(xqnm));
					sheet.addCell(label);
					label = new Label(3, rowIndex, rs.getString(JCNF));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(note));
					sheet.addCell(label);
					label = new Label(3, rowIndex, Common.formatQDH(rs.getString("QDHH")));
					sheet.addCell(label);
					label = new Label(4, rowIndex, FormatUtil.toYMDHMS(rs,upddate));
					sheet.addCell(label);
					label = new Label(5, rowIndex, rs.getString(czr));
					sheet.addCell(label);*/
					
					
					
					label = new Label(0, rowIndex, rs.getString(szqy));
					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString(xqdmhm));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(parentnm));
					sheet.addCell(label);
					label = new Label(3, rowIndex, rs.getString(xqdmhm));
					sheet.addCell(label);
					label = new Label(4, rowIndex, rs.getString(xqnm));
					sheet.addCell(label);
					label = new Label(5, rowIndex, rs.getString(xqbm));
					sheet.addCell(label);
					label = new Label(6, rowIndex, rs.getString(qdhh));
					sheet.addCell(label);
					label = new Label(7, rowIndex, ""); //fwlx
					sheet.addCell(label);
					label = new Label(8, rowIndex, ""); //jzjg
					sheet.addCell(label);
					label = new Label(9, rowIndex, rs.getString(JCNF));
					sheet.addCell(label);
					label = new Label(10, rowIndex, ""); //jzsd
					sheet.addCell(label);
					label = new Label(11, rowIndex, FormatUtil.toYMDHMS(rs.getTimestamp(upddate)));
					sheet.addCell(label);
					label = new Label(12, rowIndex, rs.getString(czr));
					sheet.addCell(label);
				}
				workbook.write();
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			getFree(rs, call, conn, null);
			if(null !=strBufResult){
				try{
					strBufResult.close();
				}catch(Exception e1){}
			}
			if(null != workbook){
				try{
					workbook.close();
				}catch(Exception e){}
			}
		}
		return strBufResult;
	}

	
	@Override
	public boolean ValidatePG(Pgv02050 v02050) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02061(?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.INTEGER);
			call.setString(2, v02050.getXqdm());
			call.setString(3, v02050.getFwlx());
			call.setTimestamp(4, v02050.getValdate());
			call.setString(5, v02050.getCd00002Czr());
			call.setString(6, v02050.getSsgx());
			call.execute();
			
			if(call.getInt(1) == 1){
				bResult = true;
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return bResult;
	}

	
	@Override
	public boolean GetSelDeleteCommand(Pgt02050 t02050) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT020501(?,?,?)}");
			call.setString(1, t02050.getChkDel());
			call.setString(2, t02050.getCd00002Czr());
			call.setString(3, t02050.getSsgx());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			tran.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return bResult;
	}

	
	@Override
	public boolean validateXqdmhmIsExist(Pgv02050 v02050) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{?=call FN_XQDMHMISEXIST_SY(?,?)}");
			call.registerOutParameter(1, OracleTypes.NUMBER);
			call.setString(2, v02050.getXqdmhm());
			call.setString(3, v02050.getCd00001Szqy());
			call.execute();
			bResult = call.getInt(1)==0?false:true;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return bResult;
	}

	
	@Override
	public Pgv02050 ImportDataSZMS(ArrayList<Pgv02050> v02050List) throws Exception {
		Pgv02050 rBean = new Pgv02050();
		ArrayList<Pgv02050> tempList = new ArrayList<Pgv02050>();
		Session session = null;
		Connection conn = null;
		Transaction tran = null;
		ResultSet rs = null;
		CallableStatement call = null;
		Integer sResultCount = 0;
		Integer fResultCount = 0;
		Integer resultValue = 0;
		try
		{
			session = getSession();
			conn = super.getConnection();
			
			for(int i = 0; i < v02050List.size(); i++){
				tran = session.beginTransaction();
				call = conn.prepareCall("{call PGSP_ADDT0205012(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				Pgv02050 e = v02050List.get(0);
				try{
					call.registerOutParameter(1, OracleTypes.CURSOR);
					call.setString(2, e.getSzqy());
					call.setString(3, e.getXqdmhm());
					call.setString(4, e.getXqnm());
					call.setString(5, e.getDmms());
					call.setString(6, e.getXmms());
					call.setString(7, e.getNmms());
					call.setString(8, e.getBmms());
					call.setInt(9, e.getNq());
					call.setInt(10, e.getTrq());
					call.setString(11, e.getCd00001Ssgx());
					call.setString(12, e.getCd00002Czr());
					call.setString(13, e.getJdmph());
					call.setString(14, e.getXqlx());
					call.setString(15, e.getFwlx());
					call.setInt(16, e.getZzzzggs());
					call.setInt(17, e.getDmylgs());
					call.setInt(18, e.getDczzgs());
					call.setInt(19, e.getDuczzgs());
					call.setInt(20, e.getZgczzgs());
					call.setInt(21, e.getGczzgs());
					call.setInt(22, e.getCgczzgs());
					call.setInt(23, e.getBszzsgs());
					call.setInt(24, e.getDdbsgs());
					call.setInt(25, e.getSpbsgs());
					call.setInt(26, e.getLpbsgs());
					call.setDouble(27, e.getTdmj());
					call.setDouble(28, e.getJzmj());
					call.setString(29, e.getKfsj());
					call.setDouble(30, e.getRjl());
					call.setInt(31, e.getGjtgs());
					call.setInt(32, e.getCscgs());
					call.setInt(33, e.getWyglgs());
					call.setInt(34, e.getTcwgs());
					call.setDouble(35, e.getLhl());
					call.setInt(36, e.getZbssj());
					call.setInt(37, e.getYey());
					call.setInt(38, e.getXx());
					call.setInt(39, e.getZx());
					call.setInt(40, e.getSc());
					call.setInt(41, e.getTycg());
					call.setInt(42, e.getSjyy());
					call.setInt(43, e.getSqwr());
					call.setInt(44, e.getHlhsm());
					call.setInt(45, e.getGy());
					call.setInt(46, e.getYlcs());
					call.execute();
					rs = (ResultSet)call.getObject(1);
					if(null != rs && rs.next()){
						if(rs.getInt("flag") == 0){
							sResultCount++;
							e.setXqdm(rs.getString("XQID"));
							e.setCd00001Szqy(rs.getString("SZQYID"));
							e.setDmhId(rs.getString("TDMH"));
							e.setImpErrorMsg("");				
							tempList.add(e);
							rBean.setOutList(tempList);
						}
					}
					tran.commit();
				}catch(Exception ex){
					tran.rollback();
					sResultCount++;
					ex.printStackTrace();
					e.setImpErrorMsg(ex.getMessage());
					tempList.add(e);
					rBean.setOutList(tempList);
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
			
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			getFree(call, conn, session);
			if(sResultCount == 0){
				resultValue = 2;				
			}else if(sResultCount > 0 && fResultCount == 0){
				resultValue = 1;
			}
			rBean.setOutFlag(resultValue);
		}
		return rBean;
	}
	
	

}
