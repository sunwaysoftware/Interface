/**
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
import com.sunway.dao.IPgt00371aDAO;
import com.sunway.vo.Pgt00371a;

/**
 * 
 * 市场法登记信息
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt00371aDAO extends BaseDAO implements IPgt00371aDAO {

	// property constants
	private static final String FCID = "FCID";					//税务编码/证件号码
	private static final String CD_00302_FCID = "CD_00302_FCID";					//税务编码/证件号码
	private static final String CD_02002_FCID = "CD_02002_FCID";					//税务编码/证件号码
	private static final String LX = "LX";				//姓名
	private static final String cd00001Zjlx = "CD_00001_ZJLX";	//证件类型
	private static final String SFID = "SFID";						//住址
	private static final String MC = "MC";					//联系电话
	private static final String CD_00001_GJDM = "CD_00001_GJDM";	//税收管辖
	private static final String ZJLX = "ZJLX";			//更新时间
	private static final String GJDM = "GJDM";	//录入人
	private static final String LXDH = "LXDH";					//联系电话
	private static final String ID = "ID";
	
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00371aDAO#GetDeleteCommand(com.sunway.vo.Pgt00371a)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00371a t00371a) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00371a_TEMP(?)}");
			call.setString(1, t00371a.getId());
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
	 * @see com.sunway.dao.IPgt00371aDAO#GetInsertCommand(com.sunway.vo.Pgt00371a)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt00371a t00371a) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00371a_TEMP(?,?,?,?,?,?,?)}");
			call.setInt(1, t00371a.getLx());
			call.setString(2, t00371a.getCd00001Zjlx());
			call.setString(3, t00371a.getSfid());
			call.setString(4, t00371a.getMc());
			call.setString(5, t00371a.getCd00001Gjdm());
			call.setString(6, t00371a.getFcid());
			call.setString(7, t00371a.getLxdh());
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
	 * @see com.sunway.dao.IPgt00371aDAO#GetUpdateCommand(com.sunway.vo.Pgt00371a)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt00371a t00371a) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00371a_TEMP(?,?,?,?,?,?,?)}");
			call.setString(1, t00371a.getId());
			call.setInt(2, t00371a.getLx());
			call.setString(3, t00371a.getCd00001Zjlx());
			call.setString(4, t00371a.getSfid());
			call.setString(5, t00371a.getMc());
			call.setString(6, t00371a.getCd00001Gjdm());
			call.setString(7, t00371a.getLxdh());
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
	 * @see com.sunway.dao.IPgt00371aDAO#LoadAll(com.sunway.vo.Pgt00371a)
	 */
	
	@Override
	public ArrayList<Pgt00371a> LoadAll(Pgt00371a v00371a) throws Exception {
		ArrayList<Pgt00371a> listResult = new ArrayList<Pgt00371a>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00371a_TEMP(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, v00371a.getFcid());
			call.execute();
			//返回數據集
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
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00371aDAO#LoadAll(com.sunway.vo.Pgt00371a)
	 */
	
	@Override
	public ArrayList<Pgt00371a> LoadAll00302(Pgt00371a v00371a) throws Exception {
		ArrayList<Pgt00371a> listResult = new ArrayList<Pgt00371a>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00302D(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, v00371a.getFcid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVParameters00302(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00371aDAO#LoadAll(com.sunway.vo.Pgt00371a)
	 */
	
	@Override
	public ArrayList<Pgt00371a> LoadAll00302_B(Pgt00371a v00371a) throws Exception {
		ArrayList<Pgt00371a> listResult = new ArrayList<Pgt00371a>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00302D_B(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, v00371a.getFcid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVParameters00302(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00371aDAO#LoadAll(com.sunway.vo.Pgt00371a)
	 */
	
	@Override
	public ArrayList<Pgt00371a> LoadAll02002(Pgt00371a v00371a) throws Exception {
		ArrayList<Pgt00371a> listResult = new ArrayList<Pgt00371a>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02002D(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, v00371a.getFcid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVParameters02002(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00371aDAO#LoadAll(com.sunway.vo.Pgt00371a)
	 */
	
	@Override
	public ArrayList<Pgt00371a> LoadAll02002_B(Pgt00371a v00371a) throws Exception {
		ArrayList<Pgt00371a> listResult = new ArrayList<Pgt00371a>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02002D_B(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, v00371a.getFcid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVParameters02002(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00371aDAO#LoadByPrimaryKey(com.sunway.vo.Pgt00371a)
	 */
	
	@Override
	public Pgt00371a LoadByPrimaryKey(Pgt00371a t00371a) throws Exception {
		ArrayList<Pgt00371a> listResult = new ArrayList<Pgt00371a>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00371a_TEMP(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, t00371a.getId());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return new Pgt00371a();
	}
	

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00371a SetVParameters(ResultSet rs) throws Exception {
		Pgt00371a e = new Pgt00371a();
		e.setCd00001Gjdm(rs.getString(CD_00001_GJDM));
		e.setCd00001Zjlx(rs.getString(cd00001Zjlx));
		e.setFcid(rs.getString(FCID));
		e.setGjdm(rs.getString(GJDM));
		e.setId(rs.getString(ID));
		e.setLx(rs.getInt(LX));
		e.setMc(rs.getString(MC));
		e.setSfid(rs.getString(SFID));
		e.setZjlx(rs.getString(ZJLX));
		e.setLxdh(rs.getString(LXDH));
		return e;
	}
	
	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00371a SetVParameters00302(ResultSet rs) throws Exception {
		Pgt00371a e = new Pgt00371a();
		e.setCd00001Gjdm(rs.getString(CD_00001_GJDM));
		e.setCd00001Zjlx(rs.getString(cd00001Zjlx));
		e.setFcid(rs.getString(CD_00302_FCID));
		e.setGjdm(rs.getString(GJDM));
		e.setLx(rs.getInt(LX));
		e.setMc(rs.getString(MC));
		e.setSfid(rs.getString(SFID));
		e.setZjlx(rs.getString(ZJLX));
		e.setLxdh(rs.getString(LXDH));
		return e;
	}
	
	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00371a SetVParameters02002(ResultSet rs) throws Exception {
		Pgt00371a e = new Pgt00371a();
		e.setCd00001Gjdm(rs.getString(CD_00001_GJDM));
		e.setCd00001Zjlx(rs.getString(cd00001Zjlx));
		e.setFcid(rs.getString(CD_02002_FCID));
		e.setGjdm(rs.getString(GJDM));
		e.setLx(rs.getInt(LX));
		e.setMc(rs.getString(MC));
		e.setSfid(rs.getString(SFID));
		e.setZjlx(rs.getString(ZJLX));
		e.setLxdh(rs.getString(LXDH));
		return e;
	}

	/**
	 * Table数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00371a SetTParameters(ResultSet rs) throws Exception {
		Pgt00371a e = new Pgt00371a();
		e.setCd00001Gjdm(rs.getString(CD_00001_GJDM));
		e.setCd00001Zjlx(rs.getString(cd00001Zjlx));
		e.setFcid(rs.getString(FCID));
		e.setId(rs.getString(ID));
		e.setLx(rs.getInt(LX));
		e.setMc(rs.getString(MC));
		e.setSfid(rs.getString(SFID));
		e.setLxdh(rs.getString(LXDH));
		return e;
	}

	

}
