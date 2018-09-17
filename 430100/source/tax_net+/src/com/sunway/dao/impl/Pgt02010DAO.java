

/**
 * @author sunxdd
 *
 */

package com.sunway.dao.impl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt02010DAO;
import com.sunway.vo.Pgv02010;

public class Pgt02010DAO extends BaseDAO implements IPgt02010DAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgv02010DAO#GetDeleteCommand(com.sunway.vo.Pgv02010)
	 */
	@Override
	public boolean GetDeleteCommand(Pgv02010 b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;	
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = getConnection();
			call = conn.prepareCall("{call PGSP_Delt02010(?)}");
			//传入输入参数
			call.setString(1, b.getCd02002Fcid());
          
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
	 * @see com.sunway.dao.IPgv02010DAO#GetInsertCommand(com.sunway.vo.Pgv02010)
	 */
	@Override
	public boolean GetInsertCommand(Pgv02010 b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02010(?,?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, b.getCd02002Fcid());
			call.setString(2, b.getSbr());
			call.setString(3, b.getCd00001Zjlx());
			call.setString(4, b.getZjhm());
			call.setString(5, b.getLxdh());
			call.setString(6, b.getYyly());
			call.setString(7, b.getCd00002Sbczr());
			call.setString(8, b.getCd00001Ssgx());
			/*call.setShort(9, b.getSbzt());
			call.setString(10, b.getSlyj());
			call.setDate(11, b.getSldate());
			call.setString(12, b.getCd00002Slczr());
			call.setShort(13, b.getSlzt());
			call.setShort(14, b.getDcyj());
			call.setDate(15, b.getDcdate());
			call.setString(16, b.getCd00002Dcczr());
			call.setShort(17, b.getDczt());
			call.setString(18, b.getCljd());
			call.setDate(19, b.getCldate());
			call.setString(20, b.getCd00002Clczr());
			call.setShort(21, b.getClzt());
			call.setString(22, b.getSlsy());
			call.setDouble(23, b.getDcjg());
			call.setDouble(24, b.getDcdsfjg());
			call.setBoolean(25, b.getDcsfcx());
			call.setString(26, b.getDcbcxyy());*/

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
	 * @see com.sunway.dao.IPgv02010DAO#LoadAll(com.sunway.vo.Pgv02010)
	 */
	@Override
	public ArrayList<Pgv02010> LoadAll(Pgv02010 b) throws Exception {
		ArrayList<Pgv02010> listResult = new ArrayList<Pgv02010>();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02010(?,?,?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setInt(2, b.getPageIndex());
			call.setInt(3, b.getPageSize());
			call.setString(4, b.getZjhm());
			call.setString(5, b.getSbr());
			call.setString(6, b.getCd02002Fcid());
			call.setString(7, b.getFwtdzl());
			call.setString(8, b.getCd00001Ssgx());
			call.setInt(9, b.getZt());
			call.execute();
			//返回数据集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgv02010DAO#LoadAll(com.sunway.vo.Pgv02010)
	 */
	@Override
	public ArrayList<Pgv02010> LoadAllV(Pgv02010 b) throws Exception {
		ArrayList<Pgv02010> listResult = new ArrayList<Pgv02010>();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020105(?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setInt(2, b.getPageIndex());
			call.setInt(3, b.getPageSize());
			call.setString(4, b.getOrder());
			call.setString(5, b.getSort());
			call.setString(6, b.getSqlData());
			call.setString(7, b.getCd00001Ssgx());
			call.execute();
			//返回数据集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgv02010DAO#LoadAll(com.sunway.vo.Pgv02010)
	 */
	@Override
	public ArrayList<Pgv02010> LoadAllB(Pgv02010 b) throws Exception {
		ArrayList<Pgv02010> listResult = new ArrayList<Pgv02010>();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02010_B(?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setInt(2, b.getPageIndex());
			call.setInt(3, b.getPageSize());
			call.setString(4, b.getOrder());
			call.setString(5, b.getSort());
			call.setString(6, b.getSqlData());
			call.setString(7, b.getCd00001Ssgx());
			call.execute();
			//返回数据集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgv02010DAO#LoadAll(com.sunway.vo.Pgv02010)
	 */
	@Override
	public ArrayList<Pgv02010> LoadDCYJ() throws Exception {
		ArrayList<Pgv02010> listResult = new ArrayList<Pgv02010>();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02310(?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			
			call.execute();
			//返回数据集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				Pgv02010 tmpB = new Pgv02010();	
				tmpB.setDm(rs.getString("DM"));
				tmpB.setMc(rs.getString("MC"));
				listResult.add(tmpB);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgv02010DAO#LoadAll(com.sunway.vo.Pgv02010)
	 */
	@Override
	public ArrayList<String> LoadSLSY(Pgv02010 b) throws Exception {
		ArrayList<String> listResult = new ArrayList<String>();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT020101(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, b.getCd00002Slczr());
			call.execute();
			//返回数据集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(rs.getString(Pgv02010.SLSY));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgv02010DAO#LoadAll(com.sunway.vo.Pgv02010)
	 */
	@Override
	public String InfoMsg(Pgv02010 b) throws Exception {
		String listResult = "";
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02010(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			call.setInt(2, b.getZt());
			call.setString(3, b.getCd00001Ssgx());
			call.execute();
			//返回数据集
			listResult = call.getString(1); 
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return listResult;
	}


	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgv02010DAO#GetUpdateCommand(com.sunway.vo.Pgv02010)
	 */
	@Override
	public boolean GetUpdateCommand(Pgv02010 b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02010(?,?,?,?,?,?,?,?)}");
			//传入输入参数
				call.setString(1, b.getCd02002Fcid());
				call.setString(2, b.getSbr());
				call.setString(3, b.getCd00001Zjlx());
				call.setString(4, b.getZjhm());
				call.setString(5, b.getLxdh());
				call.setString(6, b.getYyly());
				call.setString(7, b.getCd00002Sbczr());
				call.setString(8, b.getCd00001Ssgx());
				/*call.setShort(9, b.getSbzt());
				call.setString(10, b.getSlyj());
				call.setString(12, b.getCd00002Slczr());
				call.setShort(13, b.getSlzt());
				call.setShort(14, b.getDcyj());
				call.setString(16, b.getCd00002Dcczr());
				call.setShort(17, b.getDczt());
				call.setString(18, b.getCljd());
				call.setString(20, b.getCd00002Clczr());
				call.setShort(21, b.getClzt());
				call.setString(22, b.getSlsy());
				call.setDouble(23, b.getDcjg());
				call.setDouble(24, b.getDcdsfjg());
				call.setBoolean(25, b.getDcsfcx());
				call.setString(26, b.getDcbcxyy());*/

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
	 * @see com.sunway.dao.IPgv02010DAO#GetUpdateCommand(com.sunway.vo.Pgv02010)
	 */
	@Override
	public boolean GetUpdateCommand1(Pgv02010 b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT020101(?,?,?,?,?,?,?)}");
			//传入输入参数
				call.setString(1, b.getCd02002Fcid());
				call.setString(2, b.getSlyj());
				call.setString(3, b.getSlsy());
				call.setString(4, b.getCd00002Slczr());
				call.setShort(5, b.getSlzt());
				call.setString(6, b.getSlbslly());
				call.setString(7, b.getCd00001Ssgx());
				/*call.setString(2, b.getSbr());
				call.setString(3, b.getCd00001Zjlx());
				call.setString(4, b.getZjhm());
				call.setString(5, b.getLxdh());
				call.setString(6, b.getYyly());
				call.setString(7, b.getCd00002Sbczr());
				call.setString(8, b.getCd00001Ssgx());
				call.setShort(9, b.getSbzt());
				
				
				
				call.setShort(14, b.getDcyj());
				call.setString(16, b.getCd00002Dcczr());
				call.setShort(17, b.getDczt());
				call.setString(18, b.getCljd());
				call.setString(20, b.getCd00002Clczr());
				call.setShort(21, b.getClzt());
				
				call.setDouble(23, b.getDcjg());
				call.setDouble(24, b.getDcdsfjg());
				call.setBoolean(25, b.getDcsfcx());
				call.setString(26, b.getDcbcxyy());*/

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
	 * @see com.sunway.dao.IPgv02010DAO#GetUpdateCommand(com.sunway.vo.Pgv02010)
	 */
	@Override
	public boolean GetUpdateCommand2(Pgv02010 b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT020102(?,?,?,?,?,?)}");
			//传入输入参数
				call.setString(1, b.getCd02002Fcid());
				call.setShort(2, b.getDcyj());
				call.setShort(3, b.getDczt());
				call.setDouble(4, b.getDcjg());
				call.setString(5, b.getCd00002Dcczr());
				call.setString(6, b.getCd00001Ssgx());
				
				
				
				/*call.setShort(9, b.getSbzt());
				call.setString(10, b.getSlyj());
				call.setString(12, b.getCd00002Slczr());
				call.setShort(13, b.getSlzt());
				
				call.setString(16, b.getCd00002Dcczr());
				
				call.setString(18, b.getCljd());
				
				call.setShort(21, b.getClzt());
				call.setString(22, b.getSlsy());
				*/

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
	 * @see com.sunway.dao.IPgv02010DAO#GetUpdateCommand(com.sunway.vo.Pgv02010)
	 */
	@Override
	public boolean GetUpdateCommand3(Pgv02010 b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT020103(?,?,?,?,?,?)}");
			//传入输入参数
				call.setString(1, b.getCd02002Fcid());				
				call.setDouble(2, b.getDcdsfjg());
				call.setShort(3, b.getDcsfcx());
				call.setString(4, b.getDcbcxyy());
				call.setString(5, b.getCd00002Dcczr());
				call.setString(6, b.getCd00001Ssgx());
				
				
				
				/*call.setShort(9, b.getSbzt());
				call.setString(10, b.getSlyj());
				call.setString(12, b.getCd00002Slczr());
				call.setShort(13, b.getSlzt());
				
				call.setString(16, b.getCd00002Dcczr());
				
				call.setString(18, b.getCljd());
				
				call.setShort(21, b.getClzt());
				call.setString(22, b.getSlsy());
				*/

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
	 * @see com.sunway.dao.IPgv02010DAO#GetUpdateCommand(com.sunway.vo.Pgv02010)
	 */
	@Override
	public boolean GetUpdateCommand4(Pgv02010 b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT020104(?,?,?,?,?)}");
			//传入输入参数
				call.setString(1, b.getCd02002Fcid());				
				call.setString(2, b.getCljd());
				call.setString(3, b.getCd00002Clczr());
				call.setShort(4, b.getClzt());				
				call.setString(5, b.getCd00001Ssgx());
				
				
				
				/*call.setShort(9, b.getSbzt());
				call.setString(10, b.getSlyj());
				call.setString(12, b.getCd00002Slczr());
				call.setShort(13, b.getSlzt());
				
				call.setString(16, b.getCd00002Dcczr());
				
				call.setString(18, b.getCljd());
				
				call.setShort(21, b.getClzt());
				call.setString(22, b.getSlsy());
				*/

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
	 * @see com.sunway.dao.IPgv02010DAO#LoadByPrimaryKey(com.sunway.vo.Pgv02010)
	 */
	@Override
	public Pgv02010 LoadByPrimaryKey(Pgv02010 b) throws Exception {
		Pgv02010 bResult = new Pgv02010();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02010(?,?)}");
			//注冊输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, b.getCd02002Fcid());
          
			call.execute();
			//返回数据集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				bResult = SetTParameters(rs);	
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return bResult;
	}	
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgv02010DAO#LoadByPrimaryKey(com.sunway.vo.Pgv02010)
	 */
	@Override
	public Pgv02010 LoadByPrimaryKeyB(Pgv02010 b) throws Exception {
		Pgv02010 bResult = new Pgv02010();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02010_B(?,?)}");
			//注冊输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, b.getCd02002Fcid());
          
			call.execute();
			//返回数据集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				bResult = SetTParameters(rs);	
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return bResult;
	}	
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgv02010DAO#LoadByPrimaryKey(com.sunway.vo.Pgv02010)
	 */
	@Override
	public Pgv02010 JdsPrint(Pgv02010 b) throws Exception {
		Pgv02010 bResult = new Pgv02010();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_02010(?,?,?)}");
			//注冊输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, b.getCd02002Fcid());
			call.setString(3, b.getCd00002Clczr());
          
			call.execute();
			//返回数据集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				bResult = SetTParameters(rs);
				bResult.setJsjg(rs.getDouble(Pgv02010.JSJG));
				bResult.setZzjg(rs.getDouble(Pgv02010.ZZJG));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return bResult;
	}
	
	/**
	 * 装载数据
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	protected Pgv02010 SetParameters(ResultSet rs)throws Exception{
		Pgv02010 tmpB = new Pgv02010();				
		tmpB.setTotal(rs.getInt(Pgv02010.TOTAL));
		tmpB.setCd02002Fcid(rs.getString(Pgv02010.CD_02002_FCID));
		tmpB.setSbr(rs.getString(Pgv02010.SBR));
		tmpB.setCd00001Zjlx(rs.getString(Pgv02010.CD_00001_ZJLX));
		tmpB.setZjhm(rs.getString(Pgv02010.ZJHM));
		tmpB.setLxdh(rs.getString(Pgv02010.LXDH));
		tmpB.setYyly(rs.getString(Pgv02010.YYLY));
		tmpB.setSbdate(rs.getDate(Pgv02010.SBDATE));
		tmpB.setCd00002Sbczr(rs.getString(Pgv02010.CD_00002_SBCZR));
		tmpB.setSbzt(rs.getShort(Pgv02010.SBZT));
		tmpB.setSlyj(rs.getString(Pgv02010.SLYJ));
		tmpB.setSldate(rs.getDate(Pgv02010.SLDATE));
		tmpB.setCd00002Slczr(rs.getString(Pgv02010.CD_00002_SLCZR));
		tmpB.setSlzt(rs.getShort(Pgv02010.SLZT));
		tmpB.setDcyj(rs.getShort(Pgv02010.DCYJ));
		tmpB.setDcdate(rs.getDate(Pgv02010.DCDATE));
		tmpB.setCd00002Dcczr(rs.getString(Pgv02010.CD_00002_DCCZR));
		tmpB.setDczt(rs.getShort(Pgv02010.DCZT));
		tmpB.setCljd(rs.getString(Pgv02010.CLJD));
		tmpB.setCldate(rs.getDate(Pgv02010.CLDATE));
		tmpB.setCd00002Clczr(rs.getString(Pgv02010.CD_00002_CLCZR));
		tmpB.setClzt(rs.getShort(Pgv02010.CLZT));
		tmpB.setSlsy(rs.getString(Pgv02010.SLSY));
		tmpB.setDcjg(rs.getDouble(Pgv02010.DCJG));
		tmpB.setDcdsfjg(rs.getDouble(Pgv02010.DCDSFJG));
		tmpB.setDcsfcx(rs.getShort(Pgv02010.DCSFCX));
		tmpB.setDcbcxyy(rs.getString(Pgv02010.DCBCXYY));
		tmpB.setSzqy(rs.getString(Pgv02010.SZQY));
		tmpB.setXqnm(rs.getString(Pgv02010.XQNM));
		tmpB.setFwtdzl(rs.getString(Pgv02010.FWTDZL));
		tmpB.setPgjg(rs.getDouble(Pgv02010.PGJG));
		tmpB.setJzmj(rs.getDouble(Pgv02010.JZMJ));
		tmpB.setJyjg(rs.getDouble(Pgv02010.JYJG));
		tmpB.setZt(rs.getInt(Pgv02010.ZT));
		tmpB.setGajg(rs.getDouble(Pgv02010.GAJG));
		tmpB.setPggsmc(rs.getString(Pgv02010.PGGSMC));
		return tmpB;
	}
	
	/**
	 * 装载数据
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	protected Pgv02010 SetTParameters(ResultSet rs)throws Exception{
		Pgv02010 tmpB = new Pgv02010();				
		tmpB.setCd02002Fcid(rs.getString(Pgv02010.CD_02002_FCID));
		tmpB.setSbr(rs.getString(Pgv02010.SBR));
		tmpB.setCd00001Zjlx(rs.getString(Pgv02010.CD_00001_ZJLX));
		tmpB.setZjhm(rs.getString(Pgv02010.ZJHM));
		tmpB.setLxdh(rs.getString(Pgv02010.LXDH));
		tmpB.setYyly(rs.getString(Pgv02010.YYLY));
		tmpB.setSbdate(rs.getDate(Pgv02010.SBDATE));
		tmpB.setCd00002Sbczr(rs.getString(Pgv02010.CD_00002_SBCZR));
		tmpB.setSbzt(rs.getShort(Pgv02010.SBZT));
		tmpB.setSlyj(rs.getString(Pgv02010.SLYJ));
		tmpB.setSldate(rs.getDate(Pgv02010.SLDATE));
		tmpB.setCd00002Slczr(rs.getString(Pgv02010.CD_00002_SLCZR));
		tmpB.setSlzt(rs.getShort(Pgv02010.SLZT));
		tmpB.setDcyj(rs.getShort(Pgv02010.DCYJ));
		tmpB.setDcdate(rs.getDate(Pgv02010.DCDATE));
		tmpB.setCd00002Dcczr(rs.getString(Pgv02010.CD_00002_DCCZR));
		tmpB.setDczt(rs.getShort(Pgv02010.DCZT));
		tmpB.setCljd(rs.getString(Pgv02010.CLJD));
		tmpB.setCldate(rs.getDate(Pgv02010.CLDATE));
		tmpB.setCd00002Clczr(rs.getString(Pgv02010.CD_00002_CLCZR));
		tmpB.setClzt(rs.getShort(Pgv02010.CLZT));
		tmpB.setSlsy(rs.getString(Pgv02010.SLSY));
		tmpB.setDcjg(rs.getDouble(Pgv02010.DCJG));
		tmpB.setDcdsfjg(rs.getDouble(Pgv02010.DCDSFJG));
		tmpB.setDcsfcx(rs.getShort(Pgv02010.DCSFCX));
		tmpB.setDcbcxyy(rs.getString(Pgv02010.DCBCXYY));
		tmpB.setSlbslly(rs.getString(Pgv02010.SLBSLLY));
		tmpB.setZjlx(rs.getString(Pgv02010.ZJLX));
		tmpB.setMc(rs.getString("MC"));
		tmpB.setSsgx(rs.getString(Pgv02010.SSGX));
		tmpB.setFwtdzl(rs.getString(Pgv02010.FWTDZL));
		tmpB.setLh(rs.getString(Pgv02010.LH));
		tmpB.setDyh(rs.getString(Pgv02010.DYH));
		tmpB.setBwjfh(rs.getString(Pgv02010.BWJFH));
		tmpB.setJzmj(rs.getDouble(Pgv02010.JZMJ));
		tmpB.setPgjg(rs.getDouble(Pgv02010.PGJG));
		tmpB.setZlqd(rs.getString(Pgv02010.ZLQD));
		tmpB.setJysj(rs.getDate(Pgv02010.JYSJ));
		tmpB.setJyjg(rs.getDouble(Pgv02010.JYJG));
		tmpB.setGajg(rs.getDouble(Pgv02010.GAJG));
		tmpB.setPggsmc(rs.getString(Pgv02010.PGGSMC));
		tmpB.setSbhZr(rs.getString(Pgv02010.SBHZR));
		return tmpB;
	}
	
}
