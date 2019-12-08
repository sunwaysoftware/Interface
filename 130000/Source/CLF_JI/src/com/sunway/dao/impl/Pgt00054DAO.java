package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt00054DAO;
import com.sunway.vo.Pgt00054;
import com.sunway.vo.Pgv00054;

/**
 * @category 评税结果检验标准维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00054DAO extends BaseDAO implements IPgt00054DAO {

//	private static final String CD00001SZQYLX = "cd_00001_szqylx";	//所在区域类型
	private static final String CD00001SZQY = "cd_00001_szqy";;		//所在区域编码
	private static final String SZQY =  "szqy";						//所在区域名称
	private static final String BZBM = "BZBM";						//标准编码
	private static final String BZMC = "BZMC";						//标准名称
	private static final String JZQSMIN =  "JZQS_MIN";				//集中趋势(下限)
	private static final String JZQSMAX = "JZQS_MAX";				//集中趋势(上限)
	private static final String LSXSMIN = "LSXS_MIN";;				//离散系数COD(下限)
	private static final String LSXSMAX =  "LSXS_MAX";				//离散系数COD(上限)
	private static final String CD00002PSSD = "cd_00002_pssd";		//评税时点
	private static final String JGXGCMIN = "JGXGC_MIN";				//价格相关差PRD(下限)
	private static final String JGXGCMAX = "JGXGC_MAX";				//价格相关差PRD(上限)
	private static final String UPDDATE="upddate";					//更改时间
	private static final String CD00002CZR = "cd_00002_czr";		//操作人编号	
	private static final String NOTE = "note";						//备注信息
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00054 psjgjy) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00054(?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, psjgjy.getBzbm());
			call.setString(2, psjgjy.getCd00002Pssd());
			call.setString(3, psjgjy.getCd00001Szqy());
			call.setString(4, psjgjy.getCd00002Czr());
			call.setString(5, psjgjy.getCd00001Ssgx());
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
	public boolean GetInsertCommand(Pgt00054 psjgjy) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00054(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, psjgjy.getCd00002Pssd());
			call.setString(2, psjgjy.getBzbm());
			call.setString(3, psjgjy.getBzmc());
			call.setDouble(4, psjgjy.getJzqsMin());
			call.setDouble(5, psjgjy.getJzqsMax());
			call.setDouble(6, psjgjy.getLsxsMin());
			call.setDouble(7, psjgjy.getLsxsMax());
			call.setDouble(8, psjgjy.getJgxgcMin());
			call.setDouble(9, psjgjy.getJgxgcMax());
			call.setString(10, psjgjy.getCd00002Czr());
			call.setString(11, psjgjy.getNote());
			call.setString(12, psjgjy.getCd00001Szqy());
			call.setString(13, psjgjy.getCd00001Ssgx());
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
	public boolean GetUpdateCommand(Pgt00054 psjgjy) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00054(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, psjgjy.getCd00002Pssd());
			call.setString(2, psjgjy.getBzbm());
			call.setString(3, psjgjy.getBzmc());
			call.setDouble(4, psjgjy.getJzqsMin());
			call.setDouble(5, psjgjy.getJzqsMax());
			call.setDouble(6, psjgjy.getLsxsMin());
			call.setDouble(7, psjgjy.getLsxsMax());
			call.setDouble(8, psjgjy.getJgxgcMin());
			call.setDouble(9, psjgjy.getJgxgcMax());
			call.setString(10, psjgjy.getCd00002Czr());
			call.setString(11, psjgjy.getNote());
			call.setString(12, psjgjy.getCd00001Szqy());
			call.setString(13, psjgjy.getCd00001Ssgx());
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
	public ArrayList<Pgv00054> LoadAll(Pgv00054 psjgjy) throws Exception {
		ArrayList<Pgv00054> listResult = new ArrayList<Pgv00054>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00054(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setString(2, psjgjy.getCd00002Pssd());
			call.setString(3, psjgjy.getCd00001Szqy());
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
	protected Pgv00054 SetVParameters(ResultSet rs) throws Exception {
		Pgv00054 e = new Pgv00054();
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setSzqy(rs.getString(SZQY));
		e.setBzbm(rs.getString(BZBM));
		e.setBzmc(rs.getString(BZMC));
		e.setJzqsMin(rs.getDouble(JZQSMIN));
		e.setJzqsMax(rs.getDouble(JZQSMAX));
		e.setLsxsMin(rs.getDouble(LSXSMIN));
		e.setLsxsMax(rs.getDouble(LSXSMAX));
		e.setJgxgcMin(rs.getDouble(JGXGCMIN));
		e.setJgxgcMax(rs.getDouble(JGXGCMAX));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt00054 LoadByPrimaryKey(Pgt00054 psjgjy) throws Exception {
		ArrayList<Pgt00054> listResult = new ArrayList<Pgt00054>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00054(?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, psjgjy.getBzbm());
			call.setString(3, psjgjy.getCd00002Pssd());
			call.setString(4, psjgjy.getCd00001Szqy());
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
			return psjgjy;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00054 SetTParameters(ResultSet rs) throws Exception {
		Pgt00054 e = new Pgt00054();
		e.setBzbm(rs.getString(BZBM));
		e.setBzmc(rs.getString(BZMC));
		e.setJzqsMin(rs.getDouble(JZQSMIN));
		e.setJzqsMax(rs.getDouble(JZQSMAX));
		e.setLsxsMin(rs.getDouble(LSXSMIN));
		e.setLsxsMax(rs.getDouble(LSXSMAX));
		e.setJgxgcMin(rs.getDouble(JGXGCMIN));
		e.setJgxgcMax(rs.getDouble(JGXGCMAX));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00054DAO#LoadAll000541(com.sunway.vo.Pgv00054)
	 */
	
	@Override
	public ArrayList<Pgv00054> LoadAll000541(Pgv00054 v00054) throws Exception {
		ArrayList<Pgv00054> listResult = new ArrayList<Pgv00054>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000541(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setString(2, v00054.getCd00002Pssd());
			call.setString(3, v00054.getCd00001Szqy());
			call.setDouble(4, v00054.getJzqs());
			call.setDouble(5, v00054.getLsxs());
			call.setDouble(6, v00054.getJgxgc());
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

}
