package com.sunway.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00001DAO;
import com.sunway.util.Common;
import com.sunway.vo.Pgt00001;
import com.sunway.vo.Pgv00001;

/**
 * @author Andy.Gao
 * @version1.0
 * 
 * @author Lee
 * @version2.0
 *
 */
public class Pgt00001DAO extends BaseDAO implements IPgt00001DAO {

	// property constants
	private static final String ROOTID = "rootid";					//类型编号
	private static final String PARENTID = "parentid"; 				//对象所在父节点编号
	private static final String PARENTNM = "parentnm"; 				//对象所在父节点名称
	private static final String INFOID = "infoid";					//对象编号
	private static final String INFONM = "infonm";					//对象名称
	private static final String SYSFIELD = "sysfield";				//是否是系统字段：0：表示普通字段，1：表示系统字段(不能删除或编辑)
	private static final String VIEWORDER = "vieworder";			//显示顺序
	private static final String ROOTNM = "rootnm";					//类型名称
	private static final String ISDIR = "isdir";					//是不是目录
	private static final String LEVEL = "level";					//级别
	private static final String UPDATE = "upddate";					//更改时间
	private static final String CD00002CZR = "cd_00002_czr";		//操作人编号	
	private static final String CZR = "czr";						//操作人
	private static final String NOTE = "note";						//备注信息
	private static final String RID = "rid";						//行号
	private static final String TOTAL = "total";					//总纪录数
	/* (non-Javadoc)
	 * @see com.sunway.dao.IT00001DAO#GetDeleteCommand(com.sunway.vo.T00001)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00001 info) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;	
		try {
			conn = super.getConnection();
			session = super.getSession();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_DELT00001(?,?,?,?)}");
			//傳入輸入參數
			call.setString(1, info.getRootid());
			call.setString(2, info.getInfoid());
			call.setString(3, info.getCd00002Czr());
			call.setString(4, info.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IT00001DAO#GetInsertCommand(com.sunway.vo.T00001)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00001 info) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			conn = super.getConnection();
			session = super.getSession();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_ADDT00001(?,?,?,?,?,?,?,?,?,?)}");
			//傳入輸入參數
			call.setString(1, info.getRootid());
			call.setString(2, info.getParentid());
			call.setString(3, info.getInfoid());
			call.setString(4, info.getInfonm());
			call.setLong(5, info.getVieworder());
			call.setBoolean(6, info.getSysfield());
			call.setString(7, info.getCd00002Czr());
			call.setString(8, info.getNote());
			call.setBoolean(9, info.getIsdir());
			call.setString(10, info.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IT00001DAO#GetUpdateCommand(com.sunway.vo.T00001)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00001 info) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00001(?,?,?,?,?,?,?,?,?,?)}");
			//傳入輸入參數
			call.setString(1, info.getRootid());
			call.setString(2, info.getParentid());
			call.setString(3, info.getInfoid());
			call.setString(4, info.getInfonm());
			call.setLong(5, info.getVieworder());
			call.setBoolean(6, info.getSysfield());
			call.setString(7, info.getCd00002Czr());
			call.setString(8, info.getNote());
			call.setBoolean(9, info.getIsdir());
			call.setString(10, info.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IT00001DAO#LoadAll(com.sunway.vo.T00001)
	 */
	@Override
	public ArrayList<Pgv00001> LoadAll(Pgv00001 info) throws Exception {
		ArrayList<Pgv00001> listResult = new ArrayList<Pgv00001>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00001(?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, info.getPageIndex());
			call.setInt(3, info.getPageSize());
			call.setString(4, info.getRootid());
			call.setString(5, info.getInfonm());
			call.execute();
			//返回數據集
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
	 * View數據轉存
	 * @param rs數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgv00001 SetVParameters(ResultSet rs) throws Exception {
		Pgv00001 e = new Pgv00001();
		e.setRootid(rs.getString(ROOTID));
		e.setParentid(rs.getString(PARENTID));
		e.setParentnm(rs.getString(PARENTNM));
		e.setInfoid(rs.getString(INFOID));
		e.setInfonm(rs.getString(INFONM));
		e.setUpddate(rs.getTimestamp(UPDATE));
		e.setVieworder(rs.getLong(VIEWORDER));
		e.setSysfield(rs.getBoolean(SYSFIELD));
		e.setRootnm(rs.getString(ROOTNM));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		e.setNote(rs.getString(NOTE));
		e.setCzr(rs.getString(CZR));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setIsdir(rs.getBoolean(ISDIR));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IT00001DAO#LoadByPrimaryKey(com.sunway.vo.T00001)
	 */
	@Override
	public Pgt00001 LoadByPrimaryKey(Pgt00001 info) throws Exception {
		ArrayList<Pgt00001> listResult = new ArrayList<Pgt00001>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00001(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(3, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(1, info.getRootid());
			call.setString(2, info.getInfoid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(3); 
			while(null!=rs && rs.next()){
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return new Pgt00001();
	}

	/**
	 * Table數據轉存
	 * @param rs數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgt00001 SetTParameters(ResultSet rs) throws Exception {
		Pgt00001 e = new Pgt00001();
		e.setRootid(rs.getString(ROOTID));
		e.setParentid(rs.getString(PARENTID));
		e.setInfoid(rs.getString(INFOID));
		e.setInfonm(rs.getString(INFONM));
		e.setUpddate(rs.getTimestamp(UPDATE));
		e.setVieworder(rs.getLong(VIEWORDER));
		e.setSysfield(rs.getBoolean(SYSFIELD));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setIsdir(rs.getBoolean(ISDIR));
		e.setNote(rs.getString(NOTE));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#ExportAll(com.sunway.vo.Pgv00001)
	 */
	@Override
	public OutputStream ExportAll(Pgv00001 info) throws Exception {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00001(?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, 1);
			call.setInt(3, -1);
			call.setString(4, info.getRootid());
			call.setString(5, info.getInfonm());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			if(null!=rs){
				// 创建excel对象
		        Label label;   
		        WritableWorkbook workbook; 
	            workbook = Workbook.createWorkbook(strBufResult);   
	            WritableSheet sheet = workbook.createSheet("参数基本信息", 0);
	            // 写入标头
	            label = new Label(0, 0, "类型编号");
	            sheet.addCell(label);
	            label = new Label(1, 0, "类型名称");
	            sheet.addCell(label);
	            label = new Label(2, 0, "父节点名称");
	            sheet.addCell(label);
	            label = new Label(3, 0, "对象编号");
	            sheet.addCell(label);
	            label = new Label(4, 0, "对象名称");
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
					label = new Label(0, rowIndex, rs.getString(ROOTID));
					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString(ROOTNM));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(PARENTNM));
					sheet.addCell(label);
					label = new Label(3, rowIndex, rs.getString(INFOID));
					sheet.addCell(label);
					label = new Label(4, rowIndex, rs.getString(INFONM));
					sheet.addCell(label);
					label = new Label(5, rowIndex, Common.formatExportDateTime(rs, UPDATE));
					sheet.addCell(label);
					label = new Label(6, rowIndex, rs.getString(CD00002CZR));
					sheet.addCell(label);
					label = new Label(7, rowIndex, rs.getString(NOTE));
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

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#LoadAllByRoot(com.sunway.vo.Pgt00001)
	 */
	@Override
	public ArrayList<Pgt00001> LoadAllByRoot() throws Exception {
		ArrayList<Pgt00001> listResult = new ArrayList<Pgt00001>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000011(?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#LoadNavigator(com.sunway.vo.Pgv00001)
	 */
	@Override
	public ArrayList<Pgt00001> LoadNavigator(Pgt00001 info) throws Exception {
		ArrayList<Pgt00001> listResult = new ArrayList<Pgt00001>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000012(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, info.getRootid());
			call.setString(3, info.getInfoid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetNParameters(rs));
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	/**
	 * Table數據轉存
	 * @param rs數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgt00001 SetNParameters(ResultSet rs) throws Exception {
		Pgt00001 e = new Pgt00001();
		e.setRootid(rs.getString(ROOTID));
		e.setParentid(rs.getString(PARENTID));
		e.setInfoid(rs.getString(INFOID));
		e.setInfonm(rs.getString(INFONM));
		e.setUpddate(rs.getTimestamp(UPDATE));
		e.setVieworder(rs.getLong(VIEWORDER));
		e.setSysfield(rs.getBoolean(SYSFIELD));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setIsdir(rs.getBoolean(ISDIR));
		e.setNote(rs.getString(NOTE));
		e.setLevel(rs.getString(LEVEL));
		
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#LoadTreeList(com.sunway.vo.Pgt00001)
	 */
	@Override
	public ArrayList<Pgt00001> LoadTreeList(Pgt00001 info) throws Exception {
		ArrayList<Pgt00001> listResult = new ArrayList<Pgt00001>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000013(?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, info.getRootid());
			call.setString(3, info.getInfoid());
			call.setString(4, info.getNoinfoid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetNParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgtInfoDAO#GetInfoIdByRootId(com.sunway.vo.PgtInfo)
	 */
	@Override
	public String GetInfoIdByRootId(Pgt00001 info) throws Exception {
		String resultValue = null;
		Connection conn = null;
		CallableStatement call = null;
		if (Common.isNullOrEmpty(info.getRootid())){
			return resultValue;
		}
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00003(?,?)}");
			call.registerOutParameter(2, OracleTypes.VARCHAR);
			call.setString(1, info.getRootid());
			call.execute();
			resultValue = call.getString(2);
		}catch(Exception e){
			throw e;
		} finally {
			getFree(call, conn, null);
		}
		return resultValue;
	}

	
	/**
	 * 调用数据库函数获得信息码
	 * @return
	 * @throws Exception
	 */
	private String getInfoCode(String funcName)throws Exception{
		String resultValue = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{?=call "+funcName+"}");
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			call.execute();
			resultValue = call.getString(1);
		}catch(Exception e){
			throw e;
		} finally {
			getFree(call, conn, null);
		}
		return resultValue;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoJZJG()
	 */
	public String GetInfoJZJG() throws Exception {
		return getInfoCode("PGpkg_Global.FN_GetJZJG");
	}
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoGHYT()
	 */
	public String GetInfoGHYT() throws Exception {
		return getInfoCode("PGpkg_Global.FN_GETSJYT_SC");
	}
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoGHYT()
	 */
	public String GetInfoSEZL() throws Exception {
		return getInfoCode("PGpkg_Global.FN_GETSEZL_SC");
	}
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfocdInfoSzqy()
	 */
	@Override
	public String GetInfoSzqy() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GETSZQY");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoCGZK_SC()
	 */
	@Override
	public String GetInfoCGZK_SC() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GetCGZK_SC");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoFWCX()
	 */
	@Override
	public String GetInfoFWCX() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GetFWCX");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoFWLX_SC()
	 */
	@Override
	public String GetInfoFWLX_SC() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GetFWLX_SC");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoFWSS()
	 */
	@Override
	public String GetInfoFWSS() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GetFWSS");
	}


	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoFWYTZH()
	 */
	@Override
	public String GetInfoFWYT() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GetFWYT");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoHY()
	 */
	@Override
	public String GetInfoHY() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GETHY");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoJJLX()
	 */
	@Override
	public String GetInfoJJLX() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GetJJLX");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoJYLX_SC()
	 */
	@Override
	public String GetInfoJYLX_SC() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GetJYLX_SC");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoMSSZ()
	 */
	@Override
	public String GetInfoMSSZ() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GetMSSZ");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoQDFS()
	 */
	@Override
	public String GetInfoQDFS() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GetQDFS");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoSYQLX()
	 */
	@Override
	public String GetInfoSYQLX() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GetSYQLX");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoTDDJ()
	 */
//	@Override
//	public String GetInfoTDDJ() throws Exception {
//		return getInfoCode("PGPKG_GLOBAL.FN_GetTDDJ");
//	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoTDSYQLX()
	 */
	@Override
	public String GetInfoTDSYQLX() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GetTDSYQLX");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoTDYT()
	 */
	@Override
	public String GetInfoTDYT() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GetTDYT");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoXZ()
	 */
	@Override
	public String GetInfoXZ() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GetXZ");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoXZQY()
	 */
	@Override
	public String GetInfoXZQY() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GetXZQY");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoSSGX()
	 */
	@Override
	public String GetInfoSSGX() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GetSSGX");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoZJLX()
	 */
	@Override
	public String GetInfoZJLX() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GetZJLX");
	}

	@Override
	public String GetInfoSZ() throws Exception {
		
		return getInfoCode("PGPKG_GLOBAL.FN_GETSEZL_SC");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#LoadNavString(com.sunway.vo.Pgt00001)
	 */
	@Override
	public String LoadNavString(Pgt00001 info) throws Exception {
		String resultValue = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{?=call FN_GETINFONM(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			//注册输入参数
			call.setString(2, info.getRootid());
			call.setString(3, info.getInfoid());
			//执行查询
			call.execute();
			resultValue = call.getString(1);
		}catch(Exception e){
			throw e;
		} finally {
			getFree(call, conn, null);
		}
		return resultValue;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoJTZK()
	 */
	@Override
	public String GetInfoGJDM() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GetGJDM");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoWYZK()
	 */
	@Override
	public String GetInfoWYZK() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GetWYZK_SC");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoZXZK()
	 */
	@Override
	public String GetInfoZXZK() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GetZXZK_SC");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#GetInfoZHXZ()
	 */
	@Override
	public String GetInfoZHXZ() throws Exception {
		return getInfoCode("PGPKG_GLOBAL.FN_GETZHXZ");
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#LoadAllZHXZ()
	 */
	@Override
	public ArrayList<Pgv00001> LoadAllZHXZ() throws Exception {
		ArrayList<Pgv00001> listResult = new ArrayList<Pgv00001>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000014(?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetZParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}
	
	/**
	 * View數據轉存
	 * @param rs數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgv00001 SetZParameters(ResultSet rs) throws Exception {
		Pgv00001 e = new Pgv00001();
		e.setRootid(rs.getString(ROOTID));
		e.setParentid(rs.getString(PARENTID));
		e.setParentnm(rs.getString(PARENTNM));
		e.setInfoid(rs.getString(INFOID));
		e.setInfonm(rs.getString(INFONM));
		e.setUpddate(rs.getTimestamp(UPDATE));
		e.setVieworder(rs.getLong(VIEWORDER));
		e.setSysfield(rs.getBoolean(SYSFIELD));
		e.setRootnm(rs.getString(ROOTNM));
		e.setRecordIndex(rs.getInt(RID));
		e.setNote(rs.getString(NOTE));
		e.setCzr(rs.getString(CZR));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setIsdir(rs.getBoolean(ISDIR));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00001DAO#LoadZhxzTreeList(com.sunway.vo.Pgt00001)
	 */
	@Override
	public ArrayList<Pgt00001> LoadZhxzTreeList(Pgt00001 info) throws Exception {
		ArrayList<Pgt00001> listResult = new ArrayList<Pgt00001>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLCZ00353(?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, info.getRootid());
			call.setString(3, info.getInfoid());
			call.setString(4, info.getNoinfoid());
			call.setString(5, info.getCd00001Szqy());
			call.setString(6, info.getCd00001Fwlx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetZHParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}
	/**
	 * Table數據轉存
	 * @param rs數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgt00001 SetZHParameters(ResultSet rs) throws Exception {
		Pgt00001 e = new Pgt00001();
		e.setRootid(rs.getString(ROOTID));
		e.setParentid(rs.getString(PARENTID));
		e.setInfoid(rs.getString(INFOID));
		e.setInfonm(rs.getString(INFONM));
		e.setUpddate(rs.getTimestamp(UPDATE));
		e.setVieworder(rs.getLong(VIEWORDER));
		e.setSysfield(rs.getBoolean(SYSFIELD));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setIsdir(rs.getBoolean(ISDIR));
		e.setNote(rs.getString(NOTE));
		e.setLevel(rs.getString(LEVEL));
		e.setParentnm(rs.getString(PARENTNM));
		return e;
	}

	@Override
	public String GetInfoIdByInfoName(String rootId,String infoName) throws Exception {
		String result = null;
		CallableStatement call = null;
		Connection conn = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{? = call FN_GETINFOIDBYNAME(?,?)}");
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			call.setString(2, rootId);
			call.setString(3, infoName);			
			call.execute();
			result = (String)call.getObject(1);
		}catch(Exception e){
			throw e;
		}finally{
			getFree(call,conn,null);
		}
		return result;
	}

	@Override
	public String GetLsh() throws Exception {
		Connection conn = null;
		CallableStatement call = null;
		String result = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{? = call FN_GETLSH()}");
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			call.execute();
			result = (String)call.getObject(1);
		}catch(Exception e){
			throw e;
		}finally{
			getFree(call,conn,null);
		}
		return result;
	}

	@Override
	public ArrayList<Pgt00001> LoadByRootId(Pgt00001 info) throws Exception {
		ArrayList<Pgt00001> listResult = new ArrayList<Pgt00001>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00001(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(3, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(1, info.getRootid());
			call.setString(2, info.getInfoid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(3); 
			while(null!=rs && rs.next()){
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
	
		return listResult;
		
	}
	
	@Override
	public String GetXQDMByXQNM(String xqnm, String cd00001Ssgx)throws Exception {
		CallableStatement call = null;
		Connection conn = null;
		String result = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{? = call FN_GETXQIDBYPHOTOIMP(?,?)}");
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			call.setString(2, xqnm.toUpperCase());
			call.setString(3, cd00001Ssgx);
			call.execute();
			result = call.getString(1);
		}catch(Exception e){
			throw e;
		}finally{
			getFree(call,conn,null);
		}
		return result;
	}


}
