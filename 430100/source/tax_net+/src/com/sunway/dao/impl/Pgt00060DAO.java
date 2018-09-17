package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00060DAO;
import com.sunway.util.CheckUtil;
import com.sunway.util.ConvertUtil;
import com.sunway.vo.Pgt00060;
import com.sunway.vo.Pgv00062;
/**
 * 通用选择控件
 * @author Light
 *
 */
public class Pgt00060DAO extends BaseDAO implements IPgt00060DAO{
	
	private String ip;

	@Override
	public ArrayList<Pgt00060> LoadAll(Pgt00060 t00060) throws Exception {
		ArrayList<Pgt00060> resList = new ArrayList<Pgt00060>();
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00060(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2,t00060.getTablename());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				resList.add(SetParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return resList;
	}
	
	/**
	 * 数据装载
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	private Pgt00060 SetParameters(ResultSet rs)throws Exception{
		Pgt00060 e = new Pgt00060();
		e.setColumnname(rs.getString("COLUMNNAME"));
		e.setColumntype(rs.getString("COLUMNTYPE"));
		e.setJavafield(rs.getString("JAVAFIELD"));
		e.setSql(rs.getString("SQL"));
		e.setTablecolumn(rs.getString("TABLECOLUMN"));
		e.setSfcx(rs.getInt("SFCX"));
		e.setSfdc(rs.getInt("SFDC"));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00060DAO#LoadAllImp(com.sunway.vo.Pgt00060)
	 */
	@Override
	public ArrayList<Pgt00060> LoadAllImp(Pgt00060 t00060) throws Exception {
		ArrayList<Pgt00060> resList = new ArrayList<Pgt00060>();
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000601(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2,t00060.getTablename());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				resList.add(SetImpParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return resList;
	}
	
	/**
	 * 数据装载
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	private Pgt00060 SetImpParameters(ResultSet rs)throws Exception{
		Pgt00060 e = new Pgt00060();
		e.setTablecolumn(rs.getString("TABLECOLUMN"));
		e.setColumntype(rs.getString("COLUMNTYPE"));
		e.setColumnname(rs.getString("COLUMNNAME"));
		e.setSfcx(rs.getInt("SFCX"));
		e.setSfdc(rs.getInt("SFDC"));
		e.setIsNull(rs.getInt("ISNULL"));
		e.setIsDataType(rs.getInt("ISDATATYPE"));
		e.setSfdr(rs.getInt("SFDR"));
		e.setDrmrz(rs.getString("DRMRZ"));
		e.setDataLength(rs.getInt("DATALENGTH"));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00060DAO#LoadAllImpModel(com.sunway.vo.Pgt00060)
	 */
	@Override
	public ArrayList<Pgt00060> LoadAllImpModel(Pgt00060 t00060) throws Exception {
		ArrayList<Pgt00060> resList = new ArrayList<Pgt00060>();
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000602(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2,t00060.getTablename());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				resList.add(SetImpParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return resList;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00060DAO#GetInsertImpDaily(com.sunway.vo.Pgt00062)
	 */
	@Override
	public Boolean GetInsertImpDaily(Pgv00062 v00062) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		Transaction tran = null;
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_ADDT00062(?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, v00062.getTableName());
			call.setString(2, v00062.getDrfjmc());
			call.setString(3, v00062.getDrfjlj());
			call.setString(4, v00062.getDrsblj());
			call.setBigDecimal(5, v00062.getDrfjdx());
			call.setInt(6, v00062.getDrcghs());
			call.setInt(7, v00062.getDrsbhs());
			call.setString(8, v00062.getCd00002Czr());
			call.setString(9, v00062.getNote());
			call.setString(10, v00062.getCd00001Ssgx());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return bResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00060DAO#LoadAllDaily(com.sunway.vo.Pgv00062)
	 */
	@Override
	public ArrayList<Pgv00062> LoadAllDaily(Pgv00062 v00062) throws Exception {
		ArrayList<Pgv00062> resList = new ArrayList<Pgv00062>();
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00062(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, v00062.getTableName());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				Pgv00062 e = SetDailyParameters(rs);
				if(!CheckUtil.chkEmpty(rs.getString("DRFJLJ"))){
					e.setDrfjlj("http://" + ip + ConvertUtil.pathURL(rs.getString("DRFJLJ")));
				}
				if(!CheckUtil.chkEmpty(rs.getString("DRSBLJ"))){
					e.setDrsblj("http://" + ip + ConvertUtil.pathURL(rs.getString("DRSBLJ")));
				}
				
				resList.add(e);
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return resList;
	}
	
	/**
	 * 导入日志数据装载
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	private Pgv00062 SetDailyParameters(ResultSet rs)throws Exception{
		Pgv00062 e = new Pgv00062();
		e.setId(rs.getString("ID"));
		e.setDrfjlj(rs.getString("DRFJLJ"));
		e.setDrsblj(rs.getString("DRSBLJ"));
		e.setTableName(rs.getString("TABLENAME"));
		e.setDrfjmc(rs.getString("DRFJMC"));
		e.setDrfjdx(rs.getBigDecimal("DRFJDX"));
		e.setDrcghs(rs.getInt("DRCGHS"));
		e.setDrsbhs(rs.getInt("DRSBHS"));
		e.setUpddate(rs.getTimestamp("UPDDATE"));
		e.setCd00002Czr(rs.getString("CD_00002_CZR"));
		e.setNote(rs.getString("NOTE"));
		e.setCzr(rs.getString("CZR"));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00060DAO#GetDeleteByPrimaryDaily(com.sunway.vo.Pgt00062)
	 */
	@Override
	public Boolean GetDeleteByPrimaryDaily(Pgv00062 v00062) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_DELT00062(?,?,?)}");
			call.setString(1, v00062.getId());
			call.setString(2, v00062.getCd00002Czr());
			call.setString(3, v00062.getCd00001Ssgx());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return bResult;
	}
	
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00060DAO#LoadByPrimaryDaily(com.sunway.vo.Pgt00062)
	 */
	@Override
	public Pgv00062 LoadByPrimaryDaily(Pgv00062 v00062) throws Exception {
		ArrayList<Pgv00062> resList = new ArrayList<Pgv00062>();
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00062(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, v00062.getId());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				resList.add(SetDailyParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		if(null != resList && resList.size() > 0){
			return resList.get(0);
		}else{
			return v00062;
		}
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
}
