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

import com.sunway.dao.IPgt00002DAO;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.vo.Pgt00002;
import com.sunway.vo.Pgt00003;
import com.sunway.vo.Pgt00004;
import com.sunway.vo.Pgv00002;

/**
 * @category 用户表维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00002DAO extends BaseDAO implements IPgt00002DAO {

	// property constants
	private static final String USERID="userid";									//人员编码
	private static final String USERNM="usernm";                   				    //人员名称
	private static final String USERPWD="userpwd";									//密码
	private static final String USERIP = "userip";									//限制用户登陆的IP地址，如果不设置任何地方都可以登陆
	private static final String LASTLOGINDATE = "lastlogindate";    				//最后登陆时间
	private static final String PHONE = "phone";									//联系电话
	//private static final String ISLOCKEDOUT = "islockedout";						//该用户是否锁定（锁定用户无法登陆）
	private static final String LASTLOCKEDOUTDATE = "lastlockedoutdate";			//该用户最后解锁时间（如果为空则一直锁定）
//	private static final String FAILEDPWDATTEMPTCOUNT = "failedpwdattemptcount";    //错误的密码认证数:大于3时锁定用户
	private static final String ISUSER = "isuser";
	//private static final String PAGECOUNT = "pagecount";							//每一页显示的个数
	private static final String PSSD = "pssd";										//评税时点
	private static final String UPDDATE="upddate";									//更改时间
	private static final String CD00002CZR = "cd_00002_czr";						//操作人编号	
	private static final String CD00001SSGXLX = "cd_00001_ssgxlx";					//税收管辖编号
	private static final String CD00001SSGX = "cd_00001_ssgx";						//税收管辖编号
	private static final String SSGX = "ssgx";										//税收管辖名称
	private static final String CZR = "czr";										//操作人
	private static final String NOTE = "note";										//备注信息
	private static final String RID = "rid";										//行号
	private static final String TOTAL = "total";									//总纪录数
	private static final String ISADMIN = "isadmin";								//是否是管理员
	private static final String QXID="qxid";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00002DAO#GetDeleteCommand(com.sunway.vo.Pgt00002)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00002 user) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00002(?)}");
			//传入输入参数
			call.setString(1, user.getUserid());
		/*	call.setString(2, user.getCd00002Czr());
			call.setString(3, user.getCd00001Ssgx());*/
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
	 * @see com.sunway.dao.IPgt00002DAO#GetInsertCommand(com.sunway.vo.Pgt00002)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt00002 user) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00002(?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, user.getUserid());
			call.setString(2, user.getUsernm());
			call.setString(3, user.getCd00002Czr());
			call.setString(4, user.getNote());
			call.setInt(5, user.getIsadmin());
			call.setString(6, user.getCd00001Ssgx());
			call.setInt(7, user.getQxid());
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
	 * @see com.sunway.dao.IPgt00002DAO#GetUpdateCommand(com.sunway.vo.Pgt00002)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt00002 user) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00002(?,?,?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, user.getUserid());
			call.setString(2, user.getUsernm());
			call.setString(3, user.getUserpwd());
			call.setString(4, user.getCd00002Czr());
			call.setString(5, user.getNote());
			call.setInt(6, user.getIsadmin());
			call.setString(7, user.getCd00001Ssgx());
			call.setString(8, user.getUseridOld());
			call.setInt(9, user.getQxid());
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
	 * @see com.sunway.dao.IPgt00002DAO#LoadAll(com.sunway.vo.Pgv00002)
	 */
	
	@Override
	public ArrayList<Pgv00002> LoadAll(Pgv00002 user) throws Exception {
		ArrayList<Pgv00002> listResult = new ArrayList<Pgv00002>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00002(?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setInt(2, user.getPageIndex());
			call.setInt(3, user.getPageSize());
			call.setString(4, user.getUserid());
			call.setString(5, user.getUsernm());
			call.setString(6, user.getCd00001Ssgx());
			call.setString(7, user.getCd00002Czr());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				Pgv00002 e = SetVParameters(rs);
				//e.setSzqyList(rs.getString("SZQYLIST"));
				listResult.add(e);			
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn);
		}
		return listResult;
	}

	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00002 SetVParameters(ResultSet rs) throws Exception {
		Pgv00002 e = new Pgv00002();
		e.setUserid(rs.getString(USERID));
		e.setUsernm(rs.getString(USERNM));
		e.setUserpwd(rs.getString(USERPWD));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		//e.setUserip(rs.getString(USERIP));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		e.setCzr(rs.getString(CZR));
		//e.setPagecount(rs.getInt(PAGECOUNT));
		//e.setUserip(rs.getString(USERIP));
//		e.setLastlogindate(rs.getTimestamp(LASTLOGINDATE));
//		e.setPhone(rs.getString(PHONE));
//		e.setIslockedout(rs.getBoolean(ISLOCKEDOUT));
//		e.setLastlockedoutdate(rs.getTimestamp(LASTLOCKEDOUTDATE));
//		e.setFailedpwdattemptcount(rs.getShort(FAILEDPWDATTEMPTCOUNT));
		e.setCd00001Ssgxlx(rs.getString(CD00001SSGXLX));
		e.setCd00001Ssgx(rs.getString(CD00001SSGX));
		e.setSsgx(rs.getString(SSGX));
		e.setIsAdmin(rs.getInt(ISADMIN));
		e.setQxid(rs.getInt(QXID));
	//	e.setPssd(rs.getDate(PSSD));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00002DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00002)
	 */
	
	@Override
	public Pgt00002 LoadByPrimaryKey(Pgt00002 user) throws Exception {
		ArrayList<Pgt00002> listResult = new ArrayList<Pgt00002>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00002(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, user.getUserid());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetTParameters(rs, true));			
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return new Pgt00002();
	}
	
	/**
	 * Table 数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00002 SetTParameters(ResultSet rs, Boolean flag) throws Exception {
		Pgt00002 e = new Pgt00002();
		e.setUserid(rs.getString(USERID));
		e.setUsernm(rs.getString(USERNM));
		e.setUserpwd(rs.getString(USERPWD));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		//e.setUserip(rs.getString(USERIP));
	//	e.setLastlogindate(rs.getTimestamp(LASTLOGINDATE));
	//	e.setPhone(rs.getString(PHONE));
	//	e.setIslockedout(rs.getBoolean(ISLOCKEDOUT));
		e.setIsadmin(rs.getInt(ISADMIN));
	//	e.setLastlockedoutdate(rs.getTimestamp(LASTLOCKEDOUTDATE));
	//	e.setFailedpwdattemptcount(rs.getShort(FAILEDPWDATTEMPTCOUNT));
		//e.setPagecount(rs.getInt(PAGECOUNT));
		//e.setPssd(rs.getDate(PSSD));
		e.setCd00001Ssgx(rs.getString(CD00001SSGX));
		//e.setPssdtime(rs.getDate(PSSDTIME));
		if(flag)
			e.setSsgx(rs.getString(SSGX));
		e.setQxid(rs.getInt(QXID));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00002DAO#getUsersByRole(com.sunway.vo.Pgt00003)
	 */
	
	@Override
	public ArrayList<Pgv00002> LoadUsersByRole(Pgt00003 role) throws Exception {
		ArrayList<Pgv00002> listResult = new ArrayList<Pgv00002>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000022(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			//call.setString(2, role.getRoleid());
			call.setString(3, role.getCd00001Ssgx());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetOParameters(rs));			
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn);
		}
		return listResult;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00002 SetOParameters(ResultSet rs) throws Exception {
		Pgv00002 e = new Pgv00002();
		e.setUserid(rs.getString(USERID));
		e.setUsernm(rs.getString(USERNM));
		e.setIsuser(rs.getBoolean(ISUSER));
		e.setNote(rs.getString(NOTE));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00002DAO#LoadUsersByRight(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public ArrayList<Pgv00002> LoadUsersByRight(Pgt00004 right)	throws Exception {
		ArrayList<Pgv00002> listResult = new ArrayList<Pgv00002>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000021(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
		//	call.setString(2, right.getRightid());
			call.setString(3, right.getCd00001Ssgx());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetOParameters(rs));			
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00002DAO#CheckLogin(com.sunway.vo.Pgt00002)
	 */
	
	@Override
	public Pgt00002 CheckLogin(Pgt00002 user) throws Exception {
		ArrayList<Pgt00002> listResult = new ArrayList<Pgt00002>();
		Pgt00002 resultT00002 = null;
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00002(?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(4, OracleTypes.INTEGER);
			call.registerOutParameter(5, OracleTypes.VARCHAR);
			//传入输入参数
			call.setString(2, user.getUserid());
			call.setString(3, user.getUserpwd());
			//call.setString(4, user.getUserip());
			call.execute();
			if(call.getInt(4)==1) {
				//返回数据集
				rs = (ResultSet)call.getObject(1);
				while (null!=rs && rs.next()) {
					listResult.add(SetTParameters(rs, false));			
				}
			}
			if(listResult!=null && listResult.size()>0)
				resultT00002 = listResult.get(0);
			else
				resultT00002 = new Pgt00002();
			resultT00002.setLoginState(call.getInt(4));
			resultT00002.setLoginMessage(call.getString(5));
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn);
		}
		return resultT00002;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00002DAO#LoadRightByUser(com.sunway.vo.Pgt00002)
	 */
	
	@Override
	public ArrayList<String> LoadRightByUser(Pgt00002 user) throws Exception {
		ArrayList<String> listResult = new ArrayList<String>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000051(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, user.getUserid());
			call.setString(3, user.getCd00001Ssgx());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(rs.getString(1));			
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00002DAO#ChangePWD(com.sunway.vo.Pgt00002)
	 */
	
	@Override
	public String ChangePWD(Pgt00002 user) throws Exception {
		String updResult="";
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		//ResultSet rs = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_000023(?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(4, OracleTypes.INTEGER);
			call.registerOutParameter(5, OracleTypes.VARCHAR);
			//传入输入参数
			call.setString(1, user.getUserid());
			call.setString(2, user.getOlduserpwd());
			call.setString(3, user.getNewuserpwd());
			call.execute();
//			rs = (ResultSet)call.getObject(5);
			updResult = call.getString(5);
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return updResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00002DAO#InitPWD(com.sunway.vo.Pgt00002)
	 */
	
	@Override
	public boolean InitPWD(Pgt00002 user) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_000021(?)}");
			//传入输入参数
			call.setString(1, user.getUserid());
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
	 * @see com.sunway.dao.IPgt00002DAO#SettingPersonal(com.sunway.vo.Pgt00002)
	 */
	
	@Override
	public boolean SettingPersonal(Pgt00002 user) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_000022(?,?,?)}");
			//传入输入参数
			call.setString(1, user.getUserid());
			call.setInt(2, user.getPagecount());
			call.setDate(3, Common.converDate(user.getPssd()));
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
	 * @see com.sunway.dao.IPgt00002DAO#ExportAll(com.sunway.vo.Pgv00002)
	 */
	
	@Override
	public StringBuffer ExportAll(Pgv00002 user) throws Exception {
		StringBuffer strBufResult = new StringBuffer();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00002(?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, 1);
			call.setInt(3, -1);
			call.setString(4, user.getUserid());
			call.setString(5, user.getUsernm());
			call.setString(6, user.getCd00001Ssgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				strBufResult.append(rs.getString(USERID)).append(Constant.STRING_COMMA)
							.append(rs.getString(USERNM)).append(Constant.STRING_COMMA)
				            .append(Common.checkNull(rs.getString(USERIP))).append(Constant.STRING_COMMA)
				            .append(Common.checkNull(rs.getString(PHONE))).append(Constant.STRING_COMMA)
				            .append(Common.convertTimestampToString(rs.getTimestamp(LASTLOCKEDOUTDATE))).append(Constant.STRING_COMMA)
				            .append(rs.getDate(PSSD).toString()).append(Constant.STRING_COMMA)
				            .append(rs.getString(SSGX)).append(Constant.STRING_COMMA)
				            .append(Common.convertTimestampToString(rs.getTimestamp(UPDDATE)))
				            .append(Constant.STRING_ENTER);
			}
			//填写导出日志
			WriteLogExp(user.getCd00001Ssgx(), "PGT00002", user.getCd00002Czr(), "用户管理导出成功");
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn);
		}
		return strBufResult;
	}

	
	@Override
	public OutputStream ExportUserInform(Pgv00002 v00002) throws Exception {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream();
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00002(?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setInt(2, v00002.getPageIndex());
			call.setInt(3, v00002.getPageSize());
			call.setString(4, v00002.getUserid());
			call.setString(5, v00002.getUsernm());
			call.setString(6, v00002.getCd00001Ssgx());
			call.setString(7, v00002.getCd00002Czr());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			
			if(null != rs){
				Label label;
				WritableWorkbook workbook;
				workbook = Workbook.createWorkbook(strBufResult);
				WritableSheet sheet = workbook.createSheet("用户信息", 0);
				WritableCellFormat wcf =Common.getExcelTitleStyle();
				label = new Label(0, 0, "人员编码",wcf);
				sheet.addCell(label);
				label = new Label(1, 0, "人员名称",wcf);
				sheet.addCell(label);
				label = new Label(2, 0, "税收管辖",wcf);
				sheet.addCell(label);
				label = new Label(3, 0, "所在区域",wcf);
				sheet.addCell(label);
				/*label = new Label(3, 0, "IP地址",wcf);
				sheet.addCell(label);
				label = new Label(4, 0, "联系电话",wcf);
				sheet.addCell(label);
				label = new Label(5, 0, "管理员级别",wcf);
				sheet.addCell(label);
				label = new Label(6, 0, "是否锁定",wcf);
				sheet.addCell(label);
				label = new Label(7, 0, "密码认证次数",wcf);
				sheet.addCell(label);
				label = new Label(8, 0, "最后解锁时间",wcf);
				sheet.addCell(label);*/
				label = new Label(4, 0, "最后登录时间",wcf);
				sheet.addCell(label);
				label = new Label(5, 0, "更新时间",wcf);
				sheet.addCell(label);
				label = new Label(6, 0, "操作人",wcf);
				sheet.addCell(label);
				
				while(null != rs && rs.next()){
					Integer rowIndex = rs.getRow();
					
					label = new Label(0, rowIndex, rs.getString(USERID));
					sheet.addCell(label);
					label = new Label(1, rowIndex, rs.getString(USERNM));
					sheet.addCell(label);
					label = new Label(2, rowIndex, rs.getString(SSGX));
					sheet.addCell(label);
					label = new Label(3, rowIndex, rs.getString("SZQYLIST"));
					sheet.addCell(label);
					/*label = new Label(3, rowIndex, rs.getString(USERIP));
					sheet.addCell(label);
					label = new Label(4, rowIndex, rs.getString(PHONE));
					sheet.addCell(label);
					if(rs.getString(ISADMIN).equals("0")){
						label = new Label(5, rowIndex, "非管理员");
					}else{
						label = new Label(5, rowIndex, "管理员");
					}
					
					sheet.addCell(label);
					
					if(rs.getString(ISLOCKEDOUT).equals("0")){
						label = new Label(6, rowIndex, "否");
					}else{
						label = new Label(6, rowIndex, "是");
					}
					
					sheet.addCell(label);
					label = new Label(7, rowIndex, rs.getString(FAILEDPWDATTEMPTCOUNT));
					sheet.addCell(label);
					label = new Label(8, rowIndex, Common.formatExportDateTime(rs, LASTLOCKEDOUTDATE));
					sheet.addCell(label);*/
					label = new Label(4, rowIndex, Common.formatExportDateTime(rs, LASTLOGINDATE));
					sheet.addCell(label);
					label = new Label(5, rowIndex, Common.formatExportDateTime(rs, UPDDATE));
					sheet.addCell(label);
					label = new Label(6, rowIndex, rs.getString(CZR));
					sheet.addCell(label);
				}
				workbook.write();
				workbook.close();
			}
			//填写导出日志
			WriteLogExp(v00002.getCd00001Ssgx(), "PGT00002", v00002.getCd00002Czr(), "用户管理导出成功");
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn);
		}
		return strBufResult;
	}

	
	@Override
	public boolean validateUserIdIsExist(Pgv00002 v00002) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{?=call FN_USERIDISEXIST(?)}");
			call.registerOutParameter(1, OracleTypes.NUMBER);
			call.setString(2, v00002.getUserid());
			call.execute();
			bResult = call.getInt(1)==0?false:true;
		}catch(Exception e){
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return bResult;
	}
}