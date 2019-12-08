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

import com.sunway.dao.ISh20001DAO;
import com.sunway.vo.Pgv12001;
import com.sunway.vo.Pgv12004;

/**
 * 
 * 未审核操作[收益法]
 * @author Andy.Gao
 *
 */
public class Sh20001DAO extends BaseDAO implements ISh20001DAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.ISh20001DAO#GetExecForceSH(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public Boolean GetExecForceSH(Pgv12001 bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02082(?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getSwid());
			call.setString(2, bean.getShCzr());
			call.setString(3, bean.getSysPssd());
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
	 * @see com.sunway.dao.ISh20001DAO#GetExecSH(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public Boolean GetExecSH(Pgv12001 bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02081(?,?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getSwid());
			call.setString(2, bean.getShCzr());
			call.setString(3, bean.getSysPssd());
			call.setString(4, bean.getSysSsgx());
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
	 * @see com.sunway.dao.ISh20001DAO#LoadSh(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public ArrayList<Pgv12001> LoadSh(Pgv12001 bean) throws Exception {
		ArrayList<Pgv12001> listResult = new ArrayList<Pgv12001>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120013(?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getSysPssd());
			call.setString(5, bean.getSwid());
			call.setString(6, bean.getNsrmc());
			call.setString(7, bean.getSysSsgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetV12001Parameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.ISh20001DAO#LoadShMxNgList(com.sunway.vo.Pgv12004)
	 */
	
	@Override
	public ArrayList<Pgv12004> LoadShMxNgList(Pgv12004 bean) throws Exception {
		ArrayList<Pgv12004> listResult = new ArrayList<Pgv12004>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120841(?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd12001Swid());
			call.setString(3, bean.getSysPssd());
			call.setInt(4, bean.getShFlag());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetV12004Parameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.ISh20001DAO#LoadShSwidList(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public ArrayList<Pgv12001> LoadShSwidList(Pgv12001 bean) throws Exception {
		ArrayList<Pgv12001> listResult = new ArrayList<Pgv12001>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT1200131(?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getSysPssd());
			call.setString(3, bean.getSwid());
			call.setString(4, bean.getNsrmc());
			call.setString(5, bean.getSysSsgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				Pgv12001 e = new Pgv12001();
				e.setSwid(rs.getString("SWID"));
				listResult.add(e);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/**
	 * View數據轉存
	 * @param rs 數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgv12001 SetV12001Parameters(ResultSet rs) throws Exception {
		
		String swid = "SWID";					//税务登记代码
		String nsrmc = "NSRMC";					//纳税人名称
		String cd00001Ssgx = "CD_00001_SSGX";	//税收管辖
		String lxdh = "LXDH";					//联系电话
		String zgy = "ZGY";						//专管员
		String cd00001Hy = "CD_00001_HY";		//行业
		String cd00001Jjlx = "CD_00001_JJLX";	//经济类型
		//String zyywsr = "ZYYWSR";				//上年度主营业务收入(元)
		//String lrze = "LRZE";					//上年利润总额(元)
		String fcse = "FCSE";					//年应纳房产税税额(元)
		String tdse = "TDSE";					//年应纳土地使用税税额(元)
		String cd00001Mssz = "CD_00001_MSSZ";	//免税设置
		String bh = "BH";						//表号
		String cd00001Xz = "CD_00001_XZ";		//性质
		String lrdate = "LRDATE";				//入库日期
		String upddate = "UPDDATE";				//更新时间
		String cd00002Czr = "CD_00002_CZR";		//录入人
		String note = "NOTE";					//备注信息
		String ssgx = "SSGX";
		String hy = "HY";
		String jjlx = "JJLX";
		String mssz = "MSSZ";
		String xz = "XZ";
		String czr = "CZR";
		String recordCount = "TOTAL";
		String recordIndex = "RID";
		String shCzr = "SYSHCZR";
		String isInfo = "ISINFO";
		
		Pgv12001 e = new Pgv12001();
		e.setBh(rs.getString(bh));
		e.setCd00001Hy(rs.getString(cd00001Hy));
		e.setCd00001Jjlx(rs.getString(cd00001Jjlx));
		e.setCd00001Mssz(rs.getString(cd00001Mssz));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00001Xz(rs.getString(cd00001Xz));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setCzr(rs.getString(czr));
		e.setFcse(rs.getDouble(fcse));
		e.setHy(rs.getString(hy));
		e.setJjlx(rs.getString(jjlx));
		e.setLrdate(rs.getTimestamp(lrdate));
		//e.setLrze(rs.getDouble(lrze));
		e.setLxdh(rs.getString(lxdh));
		e.setMssz(rs.getString(mssz));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		e.setSsgx(rs.getString(ssgx));
		e.setSwid(rs.getString(swid));
		e.setTdse(rs.getDouble(tdse));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setXz(rs.getString(xz));
		e.setZgy(rs.getString(zgy));
		//e.setZyywsr(rs.getDouble(zyywsr));
		e.setShCzr(rs.getString(shCzr));
		e.setIsInfo(rs.getBoolean(isInfo));
		return e;
	}
	
	/**
	 * View數據轉存
	 * @param rs 數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgv12004 SetV12004Parameters(ResultSet rs) throws Exception {
		
		String mxid = "MXID";					//明细编码
		String cd12003Fcid = "CD_12003_FCID";	//房产编码
		String cd12002Dcid = "CD_12002_DCID";	//地产编码
		String cd12001Swid = "CD_12001_SWID";	//税务登记代码
		String fdcmc = "FDCMC";					//房地产名称
		String szcc = "SZCC";					//所在层次
		String bwjfh = "BWJFH";					//部位及房号
		String cd00001Jzjg = "CD_00001_JZJG";	//房屋结构
		String cd00001Fwyt = "CD_00001_FWYT";	//房屋用途
		String ytjzmj = "YTJZMJ";				//各用途建筑面积(平方米)
		String fcyz = "FCYZ";					//房产原值(元)（评税）
		String cd00001Xjbz = "CD_00001_XJBZ";	//星级标准
		String cd00001Fwcx = "CD_00001_FWCX";	//房屋朝向
		String lrdate = "LRDATE";				//入库日期
		String upddate = "UPDDATE";				//更新时间
		String cd00002Czr = "CD_00002_CZR";		//录入人
		String note = "NOTE";					//备注
		String cd12053Ddid = "CD_12053_DDID";	//地段编码
		String gytzj = "GYTZJ";					//各用途租金收入明细(元)
		String ddnm = "DDNM";
		String nsrmc = "NSRMC";
		String cd00001Ssgx = "CD_00001_SSGX";
		String czr = "CZR";
		String jzjg = "JZJG";
		String xjbz = "XJBZ";
		String fwcx = "FWCX";
		String fwyt = "FWYT";
		
		Pgv12004 e = new Pgv12004();
		e.setBwjfh(rs.getString(bwjfh));
		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
		e.setCd00001Fwyt(rs.getString(cd00001Fwyt));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setCd00001Xjbz(rs.getString(cd00001Xjbz));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setCd12002Dcid(rs.getString(cd12002Dcid));
		e.setCd12003Fcid(rs.getString(cd12003Fcid));
		e.setCd12053Ddid(rs.getString(cd12053Ddid));
		e.setFcyz(rs.getDouble(fcyz));
		e.setFdcmc(rs.getString(fdcmc));
		e.setGytzj(rs.getDouble(gytzj));
		e.setMxid(rs.getString(mxid));
		e.setNote(rs.getString(note));
		e.setSzcc(rs.getString(szcc));
		e.setYtjzmj(rs.getDouble(ytjzmj));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setLrdate(rs.getTimestamp(lrdate));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCzr(rs.getString(czr));
		e.setJzjg(rs.getString(jzjg));
		e.setXjbz(rs.getString(xjbz));
		e.setFwcx(rs.getString(fwcx));
		e.setFwyt(rs.getString(fwyt));
		e.setDdnm(rs.getString(ddnm));
		return e;
	}
}
