package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt00012DAO;
import com.sunway.vo.Pgt00012;
import com.sunway.vo.Pgv00012;

/**
 * @category 系统常规配置
 * @author Lee
 * @version 1.0
 * 
 */
public class Pgt00012DAO extends BaseDAO implements IPgt00012DAO {

	private static final String ISLOGADD = "islogadd"; // 是否记录用户添加操作
	private static final String ISLOGUPD = "islogupd"; // 是否记录用户更新操作
	private static final String ISLOGDEL = "islogdel"; // 是否记录用户删除操作
	private static final String ISLOGPG = "islogpg"; // 是否记录用户评税操作
	private static final String ISLOGSH = "islogsh"; // 是否记录用户审核操作
	private static final String ISLOGGPG = "isloggpg"; // 是否记录用户个案评税操作
	private static final String ISLOGSS = "islogss"; // 是否记录用户算税操作
	private static final String ISLOGDY = "islogdy"; // 是否记录用户打印操作
	private static final String UPDDATE = "upddate"; // 更改时间
	private static final String CD00002CZR = "cd_00002_czr"; // 操作人编号
	private static final String CZR = "czr"; // 操作人
	private static final String NOTE = "note"; // 备注信息
	private static final String CD00001SSGXLX = "CD_00001_SSGXLX"; // 税收管辖类型
	private static final String CD00001SSGX = "CD_00001_SSGX"; // 税收管辖
	private static final String SSGX = "SSGX"; // 税收管辖
	private static final String FCJKDZ = "FCJKDZ"; // 跟国土的接口地址
	private static final String CHANNEL_PWD = "CHANNEL_PWD"; // 跟征管的接口密码
	private static final String CHANNEL_ACC = "CHANNEL_ACC"; // 跟征管的接口帐户
	private static final String CHANNEL_CODE = "CHANNEL_CODE"; // 跟征管的接口代码
	private static final String WBMBM = "WBMBM"; // 跟征管的接口代码
	private static final String FCBMBM = "FCBMBM"; // 国土部门编码

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunway.dao.IPgt00004DAO#GetDeleteCommand(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00012 sysConfig) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00012(?,?)}");
			// 传入输入参数
			call.setLong(1, sysConfig.getId());
			call.setString(2, sysConfig.getCd00002Czr());
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
	 * 
	 * @see com.sunway.dao.IPgt00004DAO#GetInsertCommand(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt00012 sysConfig) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn
					.prepareCall("{call PGSP_ADDT00012(?,?,?,?,?,?,?,?,?,?,?)}");
			// 传入输入参数
			call.setLong(1, sysConfig.getId());
			call.setBoolean(2, sysConfig.getIslogadd());
			call.setBoolean(3, sysConfig.getIslogupd());
			call.setBoolean(4, sysConfig.getIslogdel());
			call.setBoolean(5, sysConfig.getIslogpg());
			call.setBoolean(6, sysConfig.getIslogsh());
			call.setBoolean(7, sysConfig.getIsloggpg());
			call.setBoolean(8, sysConfig.getIslogss());
			call.setBoolean(9, sysConfig.getIslogdy());
			call.setString(10, sysConfig.getCd00002Czr());
			call.setString(11, sysConfig.getNote());
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
	 * 
	 * @see com.sunway.dao.IPgt00004DAO#GetUpdateCommand(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt00012 sysConfig) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00012(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 传入输入参数
			call.setInt(1, sysConfig.getLogadd());
			call.setInt(2, sysConfig.getLogupd());
			call.setInt(3, sysConfig.getLogdel());
			call.setInt(4, sysConfig.getLogpg());
			call.setInt(5, sysConfig.getLogsh());
			call.setInt(6, sysConfig.getLoggpg());
			call.setInt(7, sysConfig.getLogss());
			call.setInt(8, sysConfig.getLogdy());
			call.setString(9, sysConfig.getCd00002Czr());
			call.setString(10, sysConfig.getNote());
			call.setString(11, sysConfig.getCd00001Ssgxlx());
			call.setString(12, sysConfig.getCd00001Ssgx());
			call.setString(13, sysConfig.getFcjkdz());
			call.setString(14, sysConfig.getChannel_Pwd());
			call.setString(15, sysConfig.getChannel_Acc());
			call.setString(16, sysConfig.getChannel_Code());
			call.setString(17, sysConfig.getWbmbm());
			call.setString(18, sysConfig.getFcbmbm());
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
	 * 
	 * @see com.sunway.dao.IPgt00004DAO#LoadAll(com.sunway.vo.Pgv00004)
	 */
	
	@Override
	public ArrayList<Pgv00012> LoadAll(Pgv00012 sysConfig) throws Exception {
		ArrayList<Pgv00012> listResult = new ArrayList<Pgv00012>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00012(?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
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
	 * 
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00012 SetVParameters(ResultSet rs) throws Exception {
		Pgv00012 e = new Pgv00012();
		e.setIslogadd(rs.getBoolean(ISLOGADD));
		e.setIslogupd(rs.getBoolean(ISLOGUPD));
		e.setIslogdel(rs.getBoolean(ISLOGDEL));
		e.setIslogpg(rs.getBoolean(ISLOGPG));
		e.setIslogsh(rs.getBoolean(ISLOGSH));
		e.setIsloggpg(rs.getBoolean(ISLOGGPG));
		e.setIslogss(rs.getBoolean(ISLOGSS));
		e.setIslogdy(rs.getBoolean(ISLOGDY));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCzr(rs.getString(CZR));
		return e;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunway.dao.IPgt00004DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public Pgt00012 LoadByPrimaryKey(Pgt00012 sysConfig) throws Exception {
		ArrayList<Pgt00012> listResult = new ArrayList<Pgt00012>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00012(?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, sysConfig.getCd00001Ssgxlx());
			call.setString(3, sysConfig.getCd00001Ssgx());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		if (listResult != null && listResult.size() > 0)
			return listResult.get(0);
		else
			return sysConfig;
	}

	/**
	 * View数据转存
	 * 
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00012 SetTParameters(ResultSet rs) throws Exception {
		Pgt00012 e = new Pgt00012();
		e.setIslogadd(rs.getBoolean(ISLOGADD));
		e.setIslogupd(rs.getBoolean(ISLOGUPD));
		e.setIslogdel(rs.getBoolean(ISLOGDEL));
		e.setIslogpg(rs.getBoolean(ISLOGPG));
		e.setIslogsh(rs.getBoolean(ISLOGSH));
		e.setIsloggpg(rs.getBoolean(ISLOGGPG));
		e.setIslogss(rs.getBoolean(ISLOGSS));
		e.setIslogdy(rs.getBoolean(ISLOGDY));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00001Ssgxlx(rs.getString(CD00001SSGXLX));
		e.setCd00001Ssgx(rs.getString(CD00001SSGX));
		e.setSsgx(rs.getString(SSGX));
		e.setNote(rs.getString(NOTE));
		e.setFcjkdz(rs.getString(FCJKDZ));
		e.setChannel_Pwd(rs.getString(CHANNEL_PWD));
		e.setChannel_Acc(rs.getString(CHANNEL_ACC));
		e.setChannel_Code(rs.getString(CHANNEL_CODE));
		e.setWbmbm(rs.getString(WBMBM));
		e.setFcbmbm(rs.getString(FCBMBM));
		return e;
	}
}
