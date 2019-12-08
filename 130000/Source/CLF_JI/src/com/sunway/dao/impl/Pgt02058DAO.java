package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt02058DAO;
import com.sunway.vo.Pgt02058;
import com.sunway.vo.Pgv02058;

/**
 * @category 收益法综合修正
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02058DAO extends BaseDAO implements IPgt02058DAO {
	
	private static final String CD00001FWYTLX = "cd_00001_fwytlx";	//房屋用途类型编号
	private static final String CD00001FWYT = "cd_00001_fwyt";		//房屋用途编号
	private static final String FWYT = "fwyt";						//房屋用途名称
	private static final String CD00001SZQYLX = "cd_00001_szqylx";	//所在区域类型
	private static final String CD00001SZQY = "cd_00001_szqy";;		//所在区域编码
	private static final String SZQY =  "szqy";						//所在区域名称
	private static final String CD00002PSSD = "cd_00002_pssd";		//评税时点
	private static final String CX = "cx";							//是否朝向修正
	private static final String SS = "ss";							//是否设施修正	
	private static final String LC = "lc";							//是否楼层修正
	private static final String XJBZ = "xjbz";						//是否星级标准修正
	private static final String MJ = "mj";							//是否面积修正
	private static final String UPDDATE="upddate";					//更改时间
	private static final String CD00002CZR = "cd_00002_czr";		//操作人编号	
	private static final String CZR = "czr";						//操作人
	private static final String NOTE = "note";						//备注信息
	private static final String RID = "rid";						//行号
	private static final String TOTAL = "total";					//总纪录数
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt02058 zhxz) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02058(?,?,?,?,?,?,?)}");
			call.setString(1, zhxz.getCd00001Fwyt());
			call.setString(2, zhxz.getCd00001Fwytlx());
			call.setString(3, zhxz.getCd00001Szqy());
			call.setString(4, zhxz.getCd00001Szqylx());
			call.setString(5, zhxz.getCd00002Pssd());
			call.setString(6, zhxz.getCd00002Czr());
			call.setString(7, zhxz.getCd00001Ssgx());
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
	public boolean GetInsertCommand(Pgt02058 zhxz) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02058(?,?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, zhxz.getCd00001Fwyt());
			call.setString(2, zhxz.getCd00001Szqy());
			call.setString(3, zhxz.getCd00002Pssd());
			call.setBoolean(4, zhxz.getCx());
			call.setBoolean(5, zhxz.getSs());
			call.setBoolean(6, zhxz.getLc());
			call.setBoolean(7, zhxz.getXjbz());
			call.setBoolean(8, zhxz.getMj());
			call.setString(9, zhxz.getCd00002Czr());
			call.setString(10, zhxz.getNote());
			call.setString(11, zhxz.getCd00001Ssgx());
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
	public boolean GetUpdateCommand(Pgt02058 zhxz) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02058(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, zhxz.getCd00001Fwytlx());
			call.setString(2, zhxz.getCd00001Fwyt());
			call.setString(3, zhxz.getCd00001Szqylx());
			call.setString(4, zhxz.getCd00001Szqy());
			call.setString(5, zhxz.getCd00002Pssd());
			call.setBoolean(6, zhxz.getCx());
			call.setBoolean(7, zhxz.getSs());
			call.setBoolean(8, zhxz.getLc());
			call.setBoolean(9, zhxz.getXjbz());
			call.setBoolean(10, zhxz.getMj());
			call.setString(11, zhxz.getCd00002Czr());
			call.setString(12, zhxz.getNote());
			call.setString(13, zhxz.getCd00001Ssgx());
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
	public ArrayList<Pgv02058> LoadAll(Pgv02058 zhxz) throws Exception {
		ArrayList<Pgv02058> listResult = new ArrayList<Pgv02058>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02058(?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, zhxz.getPageIndex());
			call.setInt(3, zhxz.getPageSize());
			call.setString(4, zhxz.getCd00001Fwyt());
			call.setString(5, zhxz.getCd00001Szqy());
			call.setString(6, zhxz.getCd00002Pssd());
			call.setString(7, zhxz.getCd00001Ssgx());
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
	protected Pgv02058 SetVParameters(ResultSet rs) throws Exception {
		Pgv02058 e = new Pgv02058();
		e.setCd00001Fwytlx(rs.getString(CD00001FWYTLX));
		e.setCd00001Fwyt(rs.getString(CD00001FWYT));
		e.setFwyt(rs.getString(FWYT));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setSzqy(rs.getString(SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setCx(rs.getBoolean(CX));
		e.setSs(rs.getBoolean(SS));
		e.setLc(rs.getBoolean(LC));
		e.setXjbz(rs.getBoolean(XJBZ));
		e.setMj(rs.getBoolean(MJ));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setCzr(rs.getString(CZR));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt02058 LoadByPrimaryKey(Pgt02058 zhxz) throws Exception {
		ArrayList<Pgt02058> listResult = new ArrayList<Pgt02058>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02058(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, zhxz.getCd00001Fwyt());
			call.setString(3, zhxz.getCd00001Fwytlx());
			call.setString(4, zhxz.getCd00001Szqy());
			call.setString(5, zhxz.getCd00001Szqylx());
			call.setString(6, zhxz.getCd00002Pssd());
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
			return zhxz;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt02058 SetTParameters(ResultSet rs) throws Exception {
		Pgt02058 e = new Pgt02058();
		e.setCd00001Fwytlx(rs.getString(CD00001FWYTLX));
		e.setCd00001Fwyt(rs.getString(CD00001FWYT));
		e.setFwyt(rs.getString(FWYT));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setCx(rs.getBoolean(CX));
		e.setSs(rs.getBoolean(SS));
		e.setLc(rs.getBoolean(LC));
		e.setXjbz(rs.getBoolean(XJBZ));
		e.setMj(rs.getBoolean(MJ));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExecuteParamCopy(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean ExecuteParamCopy(Pgt02058 zhxz) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {	
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02058(?,?,?,?,?)}");
			call.setString(1, zhxz.getSpssd());
			call.setString(2, zhxz.getTpssd());
			call.setString(3, zhxz.getCd00001Szqy());
			call.setString(4, zhxz.getCd00002Czr());
			call.setString(5, zhxz.getCd00001Ssgx());
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
}
