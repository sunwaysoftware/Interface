

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

import com.sunway.dao.IPgt00310DAO;
import com.sunway.vo.Pgv00310;

public class Pgt00310DAO extends BaseDAO implements IPgt00310DAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgv00310DAO#GetDeleteCommand(com.sunway.vo.Pgv00310)
	 */
	@Override
	public boolean GetDeleteCommand(Pgv00310 b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;	
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = getConnection();
			call = conn.prepareCall("{call PGSP_Delt00310(?)}");
			//传入输入参数
			call.setString(1, b.getCd00302Fcid());
          
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
	 * @see com.sunway.dao.IPgv00310DAO#GetInsertCommand(com.sunway.vo.Pgv00310)
	 */
	@Override
	public boolean GetInsertCommand(Pgv00310 b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00310(?,?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, b.getCd00302Fcid());
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
	 * @see com.sunway.dao.IPgv00310DAO#LoadAll(com.sunway.vo.Pgv00310)
	 */
	@Override
	public ArrayList<Pgv00310> LoadAll(Pgv00310 b) throws Exception {
		ArrayList<Pgv00310> listResult = new ArrayList<Pgv00310>();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00310(?,?,?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setInt(2, b.getPageIndex());
			call.setInt(3, b.getPageSize());
			call.setString(4, b.getZjhm());
			call.setString(5, b.getSbr());
			call.setString(6, b.getCd00302Fcid());
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
	 * @see com.sunway.dao.IPgv00310DAO#LoadAll(com.sunway.vo.Pgv00310)
	 */
	@Override
	public ArrayList<Pgv00310> LoadAllV(Pgv00310 b) throws Exception {
		ArrayList<Pgv00310> listResult = new ArrayList<Pgv00310>();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003105(?,?,?,?,?,?,?)}");
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
	 * @see com.sunway.dao.IPgv00310DAO#LoadAll(com.sunway.vo.Pgv00310)
	 */
	@Override
	public ArrayList<Pgv00310> LoadAllB(Pgv00310 b) throws Exception {
		ArrayList<Pgv00310> listResult = new ArrayList<Pgv00310>();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00310_B(?,?,?,?,?,?,?)}");
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
	 * @see com.sunway.dao.IPgv00310DAO#LoadAll(com.sunway.vo.Pgv00310)
	 */
	@Override
	public ArrayList<Pgv00310> LoadDCYJ() throws Exception {
		ArrayList<Pgv00310> listResult = new ArrayList<Pgv00310>();
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
				Pgv00310 tmpB = new Pgv00310();	
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
	 * @see com.sunway.dao.IPgv00310DAO#LoadAll(com.sunway.vo.Pgv00310)
	 */
	@Override
	public ArrayList<String> LoadSLSY(Pgv00310 b) throws Exception {
		ArrayList<String> listResult = new ArrayList<String>();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT003101(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, b.getCd00002Slczr());
			call.execute();
			//返回数据集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(rs.getString(Pgv00310.SLSY));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgv00310DAO#LoadAll(com.sunway.vo.Pgv00310)
	 */
	@Override
	public String InfoMsg(Pgv00310 b) throws Exception {
		String listResult = "";
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00310(?,?,?)}");
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
	 * @see com.sunway.dao.IPgv00310DAO#GetUpdateCommand(com.sunway.vo.Pgv00310)
	 */
	@Override
	public boolean GetUpdateCommand(Pgv00310 b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00310(?,?,?,?,?,?,?,?)}");
			//传入输入参数
				call.setString(1, b.getCd00302Fcid());
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
	 * @see com.sunway.dao.IPgv00310DAO#GetUpdateCommand(com.sunway.vo.Pgv00310)
	 */
	@Override
	public boolean GetUpdateCommand1(Pgv00310 b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT003101(?,?,?,?,?,?,?)}");
			//传入输入参数
				call.setString(1, b.getCd00302Fcid());
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
	 * @see com.sunway.dao.IPgv00310DAO#GetUpdateCommand(com.sunway.vo.Pgv00310)
	 */
	@Override
	public boolean GetUpdateCommand2(Pgv00310 b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT003102(?,?,?,?,?,?)}");
			//传入输入参数
				call.setString(1, b.getCd00302Fcid());
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
	 * @see com.sunway.dao.IPgv00310DAO#GetUpdateCommand(com.sunway.vo.Pgv00310)
	 */
	@Override
	public boolean GetUpdateCommand3(Pgv00310 b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT003103(?,?,?,?,?,?)}");
			//传入输入参数
				call.setString(1, b.getCd00302Fcid());				
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
	 * @see com.sunway.dao.IPgv00310DAO#GetUpdateCommand(com.sunway.vo.Pgv00310)
	 */
	@Override
	public boolean GetUpdateCommand4(Pgv00310 b) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT003104(?,?,?,?,?)}");
			//传入输入参数
				call.setString(1, b.getCd00302Fcid());				
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
	 * @see com.sunway.dao.IPgv00310DAO#LoadByPrimaryKey(com.sunway.vo.Pgv00310)
	 */
	@Override
	public Pgv00310 LoadByPrimaryKey(Pgv00310 b) throws Exception {
		Pgv00310 bResult = new Pgv00310();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00310(?,?)}");
			//注冊输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, b.getCd00302Fcid());
          
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
	 * @see com.sunway.dao.IPgv00310DAO#LoadByPrimaryKey(com.sunway.vo.Pgv00310)
	 */
	@Override
	public Pgv00310 LoadByPrimaryKeyB(Pgv00310 b) throws Exception {
		Pgv00310 bResult = new Pgv00310();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00310_B(?,?)}");
			//注冊输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, b.getCd00302Fcid());
          
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
	 * @see com.sunway.dao.IPgv00310DAO#LoadByPrimaryKey(com.sunway.vo.Pgv00310)
	 */
	@Override
	public Pgv00310 JdsPrint(Pgv00310 b) throws Exception {
		Pgv00310 bResult = new Pgv00310();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_00310(?,?,?)}");
			//注冊输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, b.getCd00302Fcid());
			call.setString(3, b.getCd00002Clczr());
          
			call.execute();
			//返回数据集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				bResult = SetTParameters(rs);
				bResult.setJsjg(rs.getDouble(Pgv00310.JSJG));
				bResult.setZzjg(rs.getDouble(Pgv00310.ZZJG));
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
	protected Pgv00310 SetParameters(ResultSet rs)throws Exception{
		Pgv00310 tmpB = new Pgv00310();				
		tmpB.setTotal(rs.getInt(Pgv00310.TOTAL));
		tmpB.setCd00302Fcid(rs.getString(Pgv00310.CD_00302_FCID));
		tmpB.setSbr(rs.getString(Pgv00310.SBR));
		tmpB.setCd00001Zjlx(rs.getString(Pgv00310.CD_00001_ZJLX));
		tmpB.setZjhm(rs.getString(Pgv00310.ZJHM));
		tmpB.setLxdh(rs.getString(Pgv00310.LXDH));
		tmpB.setYyly(rs.getString(Pgv00310.YYLY));
		tmpB.setSbdate(rs.getDate(Pgv00310.SBDATE));
		tmpB.setCd00002Sbczr(rs.getString(Pgv00310.CD_00002_SBCZR));
		tmpB.setSbzt(rs.getShort(Pgv00310.SBZT));
		tmpB.setSlyj(rs.getString(Pgv00310.SLYJ));
		tmpB.setSldate(rs.getDate(Pgv00310.SLDATE));
		tmpB.setCd00002Slczr(rs.getString(Pgv00310.CD_00002_SLCZR));
		tmpB.setSlzt(rs.getShort(Pgv00310.SLZT));
		tmpB.setDcyj(rs.getShort(Pgv00310.DCYJ));
		tmpB.setDcdate(rs.getDate(Pgv00310.DCDATE));
		tmpB.setCd00002Dcczr(rs.getString(Pgv00310.CD_00002_DCCZR));
		tmpB.setDczt(rs.getShort(Pgv00310.DCZT));
		tmpB.setCljd(rs.getString(Pgv00310.CLJD));
		tmpB.setCldate(rs.getDate(Pgv00310.CLDATE));
		tmpB.setCd00002Clczr(rs.getString(Pgv00310.CD_00002_CLCZR));
		tmpB.setClzt(rs.getShort(Pgv00310.CLZT));
		tmpB.setSlsy(rs.getString(Pgv00310.SLSY));
		tmpB.setDcjg(rs.getDouble(Pgv00310.DCJG));
		tmpB.setDcdsfjg(rs.getDouble(Pgv00310.DCDSFJG));
		tmpB.setDcsfcx(rs.getShort(Pgv00310.DCSFCX));
		tmpB.setDcbcxyy(rs.getString(Pgv00310.DCBCXYY));
		tmpB.setSzqy(rs.getString(Pgv00310.SZQY));
		tmpB.setXqnm(rs.getString(Pgv00310.XQNM));
		tmpB.setFwtdzl(rs.getString(Pgv00310.FWTDZL));
		tmpB.setPgjg(rs.getDouble(Pgv00310.PGJG));
		tmpB.setJzmj(rs.getDouble(Pgv00310.JZMJ));
		tmpB.setJyjg(rs.getDouble(Pgv00310.JYJG));
		tmpB.setZt(rs.getInt(Pgv00310.ZT));
		tmpB.setGajg(rs.getDouble(Pgv00310.GAJG));
		tmpB.setPggsmc(rs.getString(Pgv00310.PGGSMC));
		return tmpB;
	}
	
	/**
	 * 装载数据
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	protected Pgv00310 SetTParameters(ResultSet rs)throws Exception{
		Pgv00310 tmpB = new Pgv00310();				
		tmpB.setCd00302Fcid(rs.getString(Pgv00310.CD_00302_FCID));
		tmpB.setSbr(rs.getString(Pgv00310.SBR));
		tmpB.setCd00001Zjlx(rs.getString(Pgv00310.CD_00001_ZJLX));
		tmpB.setZjhm(rs.getString(Pgv00310.ZJHM));
		tmpB.setLxdh(rs.getString(Pgv00310.LXDH));
		tmpB.setYyly(rs.getString(Pgv00310.YYLY));
		tmpB.setSbdate(rs.getDate(Pgv00310.SBDATE));
		tmpB.setCd00002Sbczr(rs.getString(Pgv00310.CD_00002_SBCZR));
		tmpB.setSbzt(rs.getShort(Pgv00310.SBZT));
		tmpB.setSlyj(rs.getString(Pgv00310.SLYJ));
		tmpB.setSldate(rs.getDate(Pgv00310.SLDATE));
		tmpB.setCd00002Slczr(rs.getString(Pgv00310.CD_00002_SLCZR));
		tmpB.setSlzt(rs.getShort(Pgv00310.SLZT));
		tmpB.setDcyj(rs.getShort(Pgv00310.DCYJ));
		tmpB.setDcdate(rs.getDate(Pgv00310.DCDATE));
		tmpB.setCd00002Dcczr(rs.getString(Pgv00310.CD_00002_DCCZR));
		tmpB.setDczt(rs.getShort(Pgv00310.DCZT));
		tmpB.setCljd(rs.getString(Pgv00310.CLJD));
		tmpB.setCldate(rs.getDate(Pgv00310.CLDATE));
		tmpB.setCd00002Clczr(rs.getString(Pgv00310.CD_00002_CLCZR));
		tmpB.setClzt(rs.getShort(Pgv00310.CLZT));
		tmpB.setSlsy(rs.getString(Pgv00310.SLSY));
		tmpB.setDcjg(rs.getDouble(Pgv00310.DCJG));
		tmpB.setDcdsfjg(rs.getDouble(Pgv00310.DCDSFJG));
		tmpB.setDcsfcx(rs.getShort(Pgv00310.DCSFCX));
		tmpB.setDcbcxyy(rs.getString(Pgv00310.DCBCXYY));
		tmpB.setSlbslly(rs.getString(Pgv00310.SLBSLLY));
		tmpB.setZjlx(rs.getString(Pgv00310.ZJLX));
		tmpB.setMc(rs.getString("MC"));
		tmpB.setSsgx(rs.getString(Pgv00310.SSGX));
		tmpB.setFwtdzl(rs.getString(Pgv00310.FWTDZL));
		tmpB.setLh(rs.getString(Pgv00310.LH));
		tmpB.setDyh(rs.getString(Pgv00310.DYH));
		tmpB.setBwjfh(rs.getString(Pgv00310.BWJFH));
		tmpB.setJzmj(rs.getDouble(Pgv00310.JZMJ));
		tmpB.setPgjg(rs.getDouble(Pgv00310.PGJG));
		tmpB.setZlqd(rs.getString(Pgv00310.ZLQD));
		tmpB.setJysj(rs.getDate(Pgv00310.JYSJ));
		tmpB.setJyjg(rs.getDouble(Pgv00310.JYJG));
		tmpB.setGajg(rs.getDouble(Pgv00310.GAJG));
		tmpB.setPggsmc(rs.getString(Pgv00310.PGGSMC));
		tmpB.setSbhZr(rs.getString(Pgv00310.SBHZR));
		return tmpB;
	}
	
}
