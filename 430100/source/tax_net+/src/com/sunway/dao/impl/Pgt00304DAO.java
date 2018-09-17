package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00304DAO;
import com.sunway.util.CheckUtil;
import com.sunway.util.ConvertUtil;
import com.sunway.vo.Pgt00304;
import com.sunway.vo.Pgt00304a;
import com.sunway.vo.Pgv00304;

/**
 * @category 挂牌数据维护 
 * @author Lee
 * @version 1.0						
 */
public class Pgt00304DAO extends BaseDAO implements IPgt00304DAO {

	
	private static final String GPID = "GPID";						//编码
	private static final String CD00304GPID="CD_00304_GPID";						// 挂牌编号
	private static final String QTID="QTID";								//其他修正编码	
	private static final String QTMC="QTMC";								//其他修正名称
	private static final String SWID = "SWID";						//税务编码/证件号码
	private static final String CD00352XQDM = "CD_00352_XQDM";		//小区代码
	private static final String YWDT = "YWDT";						//有无电梯(0无)
	private static final String ZLC =  "ZLC";						//总楼层
	private static final String FWTDZL = "FWTDZL";;					//座落地址
	private static final String CD00001FWLX =  "CD_00001_FWLX";		//房屋类型
	private static final String CD00001JYLX = "CD_00001_JYLX";		//交易类型(0新)
	private static final String CD00001JZJG = "CD_00001_JZJG";		//建筑结构
	private static final String JZMJ = "JZMJ";						//建筑面积
	private static final String CD00001FWCX = "CD_00001_FWCX";		//房屋朝向
	private static final String CD00001CGZK = "CD_00001_CGZK";		//采光状况
	private static final String SZLC = "SZLC";						//所在楼层
	private static final String BWJFH = "BWJFH";					//部位及房号
	private static final String ZBJG="ZBJG";						//自报价
	private static final String TDSYQMJ = "TDSYQMJ";				//土地使用权面积	
	private static final String SFZJ = "SFZJ";						//是否中介
	private static final String GPSJ = "GPSJ";						//挂牌时间
	private static final String UPDDATE = "UPDDATE";				//更改时间
	private static final String CD00002CZR = "CD_00002_CZR";		//操作人
	private static final String NOTE="NOTE";						//备注信息
	private static final String HX = "HX";							//户型
	private static final String XQMC = "XQMC";						//小区名称
	private static final String NSRMC = "NSRMC";					//纳税人名称
	private static final String CD00001SZQY = "CD_00001_SZQY";		//所在区域
	private static final String FWLX = "FWLX";						
	private static final String JYLX = "JYLX";						
	private static final String JZJG= "JZJG";						
	private static final String FWCX= "FWCX";						
	private static final String CGZK= "CGZK";						
	private static final String SZQY= "SZQY";						
	private static final String CZR= "CZR";							
	private static final String TOTAL = "total";					//总纪录数
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00304 gpsj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00304(?)}");
			//传入输入参数
			call.setString(1, gpsj.getGpid());
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
	public boolean GetInsertCommand(Pgt00304 gpsj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00304(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, gpsj.getSwid());
			call.setString(2, gpsj.getCd00352Xqdm());
			call.setBoolean(3, CheckUtil.chkNull(gpsj.getYwdt()));
			call.setShort(4, gpsj.getZlc());
			call.setString(5, gpsj.getFwtdzl());
			call.setString(6, gpsj.getCd00001Fwlx());
			call.setString(7, gpsj.getCd00001Jylx());
			call.setString(8, gpsj.getCd00001Jzjg());
			call.setBigDecimal(9, gpsj.getJzmj());
			call.setString(10, gpsj.getCd00001Fwcx());
			call.setString(11, gpsj.getCd00001Cgzk());
			call.setShort(12, gpsj.getSzlc());
			call.setString(13, gpsj.getBwjfh());
			call.setBigDecimal(14, gpsj.getZbjg());
			call.setDouble(15, gpsj.getTdsyqmj());
			call.setBoolean(16, gpsj.getSfzj());
			call.setDate(17, ConvertUtil.utilDateToSqlDate(gpsj.getGpsj()));
			call.setString(18, gpsj.getCd00002Czr());
			call.setString(19, gpsj.getNote());
			call.setString(20, gpsj.getHx());
			call.setString(21, gpsj.getXqmc());
			call.setString(22, gpsj.getNsrmc());
			call.setString(23, gpsj.getCd00001Szqy());
			call.setString(24, gpsj.getQtids());
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
	public boolean GetUpdateCommand(Pgt00304 gpsj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00304(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, gpsj.getGpid());
			call.setString(2, gpsj.getSwid());
			call.setString(3, gpsj.getCd00352Xqdm());
			call.setBoolean(4, CheckUtil.chkNull(gpsj.getYwdt()));
			call.setShort(5, gpsj.getZlc());
			call.setString(6, gpsj.getFwtdzl());
			call.setString(7, gpsj.getCd00001Fwlx());
			call.setString(8, gpsj.getCd00001Jylx());
			call.setString(9, gpsj.getCd00001Jzjg());
			call.setBigDecimal(10, gpsj.getJzmj());
			call.setString(11, gpsj.getCd00001Fwcx());
			call.setString(12, gpsj.getCd00001Cgzk());
			call.setShort(13, gpsj.getSzlc());
			call.setString(14, gpsj.getBwjfh());
			call.setBigDecimal(15, gpsj.getZbjg());
			call.setDouble(16, gpsj.getTdsyqmj());
			call.setBoolean(17, gpsj.getSfzj());
			call.setDate(18, ConvertUtil.utilDateToSqlDate(gpsj.getGpsj()));
			call.setString(19, gpsj.getCd00002Czr());
			call.setString(20, gpsj.getNote());
			call.setString(21, gpsj.getHx());
			call.setString(22, gpsj.getXqmc());
			call.setString(23, gpsj.getNsrmc());
			call.setString(24, gpsj.getCd00001Szqy());
			call.setString(25, gpsj.getQtids());
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
	public ArrayList<Pgv00304> LoadAll(Pgv00304 gpsj) throws Exception {
		ArrayList<Pgv00304> listResult = new ArrayList<Pgv00304>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00304(?,?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, gpsj.getPageIndex());
			call.setInt(3, gpsj.getPageSize());
			call.setString(4, gpsj.getSwid());
			call.setString(5, gpsj.getNsrmc());
			call.setString(6, gpsj.getCd00352Xqdm());
			call.setString(7, gpsj.getFwtdzl());
			call.setString(8, gpsj.getCd00001Szqy());
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
	protected Pgv00304 SetVParameters(ResultSet rs) throws Exception {
		Pgv00304 e = new Pgv00304();
		e.setGpid(rs.getString(GPID));
		e.setSwid(rs.getString(SWID));
		e.setCd00352Xqdm(rs.getString(CD00352XQDM));
		e.setYwdt(rs.getBoolean(YWDT));
		e.setZlc(rs.getShort(ZLC));
		e.setFwtdzl(rs.getString(FWTDZL));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setCd00001Jylx(rs.getString(CD00001JYLX));
		e.setCd00001Jzjg(rs.getString(CD00001JZJG));
		e.setJzmj(rs.getDouble(JZMJ));
		e.setCd00001Fwcx(rs.getString(CD00001FWCX));
		e.setCd00001Cgzk(rs.getString(CD00001CGZK));
		e.setSzlc(rs.getShort(SZLC));
		e.setBwjfh(rs.getString(BWJFH));
		e.setZbjg(rs.getDouble(ZBJG));
		e.setTdsyqmj(rs.getDouble(TDSYQMJ));
		e.setSfzj(rs.getBoolean(SFZJ));
		e.setGpsj(rs.getDate(GPSJ));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setHx(rs.getString(HX));
		e.setXqmc(rs.getString(XQMC));
		e.setNsrmc(rs.getString(NSRMC));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setFwlx(rs.getString(FWLX));
		e.setJylx(rs.getString(JYLX));
		e.setJzjg(rs.getString(JZJG));
		e.setFwcx(rs.getString(FWCX));
		e.setCgzk(rs.getString(CGZK));
		e.setSzqy(rs.getString(SZQY));
		e.setCzr(rs.getString(CZR));
		e.setRecordCount(rs.getInt(TOTAL));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt00304 LoadByPrimaryKey(Pgt00304 gpsj) throws Exception {
		ArrayList<Pgt00304> listResult = new ArrayList<Pgt00304>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00304(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, gpsj.getGpid());
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
			return gpsj;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00304 SetTParameters(ResultSet rs) throws Exception {
		Pgt00304 e = new Pgt00304();
		e.setGpid(rs.getString(GPID));
		e.setSwid(rs.getString(SWID));
		e.setCd00352Xqdm(rs.getString(CD00352XQDM));
		e.setYwdt(rs.getBoolean(YWDT));
		e.setZlc(rs.getShort(ZLC));
		e.setFwtdzl(rs.getString(FWTDZL));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setCd00001Jylx(rs.getString(CD00001JYLX));
		e.setCd00001Jzjg(rs.getString(CD00001JZJG));
		e.setJzmj(rs.getBigDecimal(JZMJ));
		e.setCd00001Fwcx(rs.getString(CD00001FWCX));
		e.setCd00001Cgzk(rs.getString(CD00001CGZK));
		e.setSzlc(rs.getShort(SZLC));
		e.setBwjfh(rs.getString(BWJFH));
		e.setZbjg(rs.getBigDecimal(ZBJG));
		e.setTdsyqmj(rs.getDouble(TDSYQMJ));
		e.setSfzj(rs.getBoolean(SFZJ));
		e.setGpsj(rs.getDate(GPSJ));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setHx(rs.getString(HX));
		e.setXqmc(rs.getString(XQMC));
		e.setNsrmc(rs.getString(NSRMC));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setFwlx(rs.getString(FWLX));
		e.setJylx(rs.getString(JYLX));
		e.setJzjg(rs.getString(JZJG));
		e.setFwcx(rs.getString(FWCX));
		e.setCgzk(rs.getString(CGZK));
		return e;
	}

	
	@Override
	public ArrayList<Pgt00304a> LoadAlla(Pgt00304a gpsj) throws Exception {
		ArrayList<Pgt00304a> listResult = new ArrayList<Pgt00304a>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00304E(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setString(2, gpsj.getCd00304Gpid());
			call.execute();
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetAVParameters(rs));
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
	protected Pgt00304a SetAVParameters(ResultSet rs) throws Exception {
		Pgt00304a e = new Pgt00304a();
		e.setCd00304Gpid(rs.getString(CD00304GPID));
		e.setQtid(rs.getString(QTID));
		e.setQtmc(rs.getString(QTMC));
		e.setNote(rs.getString(NOTE));
		return e;
	}
	
	
	
	public Pgv00304 ImportExcelData(ArrayList<Pgv00304> gpsjList) throws Exception{
		Pgv00304 v00304 = new Pgv00304();
		Integer resultValue = 0;
		Integer sResultCount = 0;
		CallableStatement call = null;
		ResultSet rs = null;
		Session session = null;
		Connection conn = null;
		Transaction tran = null;
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_ADDT003041(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			for(int i=0; i<gpsjList.size(); i++){
				Pgv00304 gpsj = gpsjList.get(i);
				try {
					call.registerOutParameter(1, OracleTypes.CURSOR);
					
					call.setString(2, gpsj.getSwid());
					call.setString(3, gpsj.getXqmc());
					call.setBoolean(4, CheckUtil.chkNull(gpsj.getYwdt()));
					call.setShort(5, gpsj.getZlc());
					call.setString(6, gpsj.getFwtdzl());
					call.setString(7, gpsj.getFwlx());
					call.setString(8, gpsj.getJylx());
					call.setString(9, gpsj.getJzjg());
					call.setDouble(10, CheckUtil.chkNull(gpsj.getJzmj()));
					call.setString(11, gpsj.getFwcx());
					call.setString(12, gpsj.getCgzk());
					call.setShort(13, gpsj.getSzlc());
					call.setString(14, gpsj.getBwjfh());
					call.setDouble(15, gpsj.getZbjg());
					call.setDouble(16, CheckUtil.chkNull(gpsj.getTdsyqmj()));
					call.setBoolean(17, CheckUtil.chkNull(gpsj.getSfzj()));
					call.setDate(18, ConvertUtil.utilDateToSqlDate(gpsj.getGpsj()));
					call.setString(19, gpsj.getCd00002Czr());
					call.setString(20, gpsj.getNote());
					call.setString(21, gpsj.getHx());
					call.setString(22, gpsj.getXqmc());
					call.setString(23, gpsj.getNsrmc());
					call.setString(24, gpsj.getSzqy());
					call.setString(25,	gpsj.getQtids());
					call.setString(26, gpsj.getCd00001Ssgx());
					call.execute();
					
					rs = (ResultSet) call.getObject(1); 
					if (null!=rs && rs.next()) {
						if (rs.getInt("flag") == 0) {
							sResultCount++;
							//标记那一列字段错误
							gpsj.setCd00352Xqdm(rs.getString("TXQDM"));
							gpsj.setCd00001Fwlx(rs.getString("TFWLX"));
							gpsj.setCd00001Jylx(rs.getString("TJYLX"));
							gpsj.setCd00001Jzjg(rs.getString("TJZJG"));
							gpsj.setCd00001Fwcx(rs.getString("TFWCX"));
							gpsj.setCd00001Cgzk(rs.getString("TCGZK"));
							gpsj.setCd00001Szqy(rs.getString("TSZQY"));
//							gpsj.setQtxzId(rs.getString("QTXZIDS"));
							//将数据封装到list
							v00304.getOutList().add(gpsj);
						}
						rs.close();
					}
				} catch (Exception e) {
					sResultCount++;
					continue;
				}	
			}
			tran.commit();
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(rs, call, conn, session);
			if(sResultCount == 0)
				resultValue = 2;
			else if(sResultCount > 0)
				resultValue = 1;
			v00304.setOutFlag(resultValue);
		}
		return v00304;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00304DAO#LoadDetail(com.sunway.vo.Pgv00304)
	 */
	
	@Override
	public Pgv00304 LoadDetail(Pgv00304 gpsj) throws Exception {
		ArrayList<Pgv00304> listResult = new ArrayList<Pgv00304>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT003041(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, gpsj.getGpid());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetDParameters(rs));			
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return gpsj;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00304 SetDParameters(ResultSet rs) throws Exception {
		Pgv00304 e = new Pgv00304();
		e.setGpid(rs.getString(GPID));
		e.setSwid(rs.getString(SWID));
		e.setCd00352Xqdm(rs.getString(CD00352XQDM));
		e.setYwdt(rs.getBoolean(YWDT));
		e.setZlc(rs.getShort(ZLC));
		e.setFwtdzl(rs.getString(FWTDZL));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setCd00001Jylx(rs.getString(CD00001JYLX));
		e.setCd00001Jzjg(rs.getString(CD00001JZJG));
		e.setJzmj(rs.getDouble(JZMJ));
		e.setCd00001Fwcx(rs.getString(CD00001FWCX));
		e.setCd00001Cgzk(rs.getString(CD00001CGZK));
		e.setSzlc(rs.getShort(SZLC));
		e.setBwjfh(rs.getString(BWJFH));
		e.setZbjg(rs.getDouble(ZBJG));
		e.setTdsyqmj(rs.getDouble(TDSYQMJ));
		e.setSfzj(rs.getBoolean(SFZJ));
		e.setGpsj(rs.getDate(GPSJ));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setHx(rs.getString(HX));
		e.setXqmc(rs.getString(XQMC));
		e.setNsrmc(rs.getString(NSRMC));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setFwlx(rs.getString(FWLX));
		e.setJylx(rs.getString(JYLX));
		e.setJzjg(rs.getString(JZJG));
		e.setFwcx(rs.getString(FWCX));
		e.setCgzk(rs.getString(CGZK));
		e.setCzr(rs.getString(CZR));
		return e;
	}
}
