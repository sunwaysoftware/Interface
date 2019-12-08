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

import com.sunway.dao.IPgt10031DAO;
import com.sunway.vo.Pgt10031;
import com.sunway.vo.Pgv10031;

/**
 * 
 * 成本法评税结果
 * @author Andy.Gao
 *
 */
public class Pgt10031DAO extends BaseDAO implements IPgt10031DAO {

	private static final String cd12004Mxid = "CD_12004_MXID";		//房产编码
	private static final String fcpgjg = "FCPGJG";					//房产评税结果(元)
	private static final String dcpgjg = "DCPGJG";					//地产评税结果(元)
	private static final String pgjg = "PGJG";						//成本法评税结果(元)
	private static final String cd00002Pssdy = "CD_00002_PSSDY";	//评税时点
	private static final String cd00002Pssd = "CD_00002_PSSD";		//显示用的评税时点（详细时间）
	private static final String cxl = "CXL";						//成新率
	private static final String czl = "CZL";						//残值率
	private static final String ysynx = "YSYNX";					//已使用年现
	private static final String jjnynx = "JJNYNX";					//经济耐用年现
	private static final String jazj = "JAZJ";						//建安造价
	private static final String jjbbl = "JJBBL";					//间接费用比率
	private static final String jzmj = "JZMJ";						//建筑面积
	private static final String rjlxs = "RJLXS";					//容税率
	private static final String psss = "PSSS";						//评税时修正系数
	private static final String dj = "DJ";							//基准地价
	private static final String gyttdmj = "GYTTDMJ";				//各用途土地面积
	private static final String cqf = "CQF";						//拆迁费
	private static final String tdyt = "TDYT";						//土地用途
	private static final String gbrjl = "GBRJL";					//个别容积率
	private static final String szqy = "SZQY";						//所在区域
	private static final String tddj = "TDDJ";						//土地等级
	private static final String fwyt = "FWYT";						//房屋用途
	private static final String xjbz = "XJBZ";						//星级标准
	private static final String jzjg = "JZJG";						//建筑结构
	private static final String upddate = "UPDDATE";				//更新时间
	private static final String czr = "CZR";						//录入人
	private static final String note = "NOTE";						//备注信息
	private static final String dcqtxz = "DCQTXZ";					//土地其它修正系统
	private static final String fcqtxz = "FCQTXZ";					//房产其它修正系统
	private static final String cd12001Swid = "CD_12001_SWID";		//税务登记代码
	private static final String nsrmc = "NSRMC";					//纳税人名称
	private static final String fcczcb = "FCCZCB";					//房产重置成本
	private static final String dczddj = "DCZDDJ";					//宗地地价
	private static final String gbfcpgjg = "GBFCPGJG";
	private static final String gbdcpgjg = "GBDCPGJG";
	private static final String gbpgjg = "GBPGJG";
	private static final String gbfcxzxs = "GBFCXZXS";
	private static final String gbdcxzxs = "GBDCXZXS";
	private static final String recordCount = "TOTAL";
	private static final String recordIndex = "RID";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10031DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10031)
	 */
	
	@Override
	public Pgt10031 LoadByPrimaryKey(Pgt10031 bean) throws Exception {
		ArrayList<Pgt10031> listResult = new ArrayList<Pgt10031>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT10031(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd00002Pssdy());
			call.setString(3, bean.getCd12004Mxid());
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
			return null;
	}
	
	/**
	 * Table数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt10031 SetTParameters(ResultSet rs) throws Exception {
		Pgt10031 e = new Pgt10031();
		e.setCd00002Pssd(rs.getDate(cd00002Pssd));
		e.setCd00002Pssdy(rs.getString(cd00002Pssdy));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setCd12004Mxid(rs.getString(cd12004Mxid));
		e.setCqf(rs.getDouble(cqf));
		e.setCxl(rs.getDouble(cxl));
		e.setCzl(rs.getDouble(czl));
		e.setCzr(rs.getString(czr));
		e.setDcpgjg(rs.getDouble(dcpgjg));
		e.setDcqtxz(rs.getDouble(dcqtxz));
		e.setDj(rs.getDouble(dj));
		e.setFcpgjg(rs.getDouble(fcpgjg));
		e.setFcqtxz(rs.getDouble(fcqtxz));
		e.setFwyt(rs.getString(fwyt));
		e.setGbrjl(rs.getDouble(gbrjl));
		e.setGyttdmj(rs.getDouble(gyttdmj));
		e.setJazj(rs.getDouble(jazj));
		e.setJjbbl(rs.getDouble(jjbbl));
		e.setJjnynx(rs.getLong(jjnynx));
		e.setJzjg(rs.getString(jzjg));
		e.setJzmj(rs.getDouble(jzmj));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setPgjg(rs.getDouble(pgjg));
		e.setPsss(rs.getDouble(psss));
		e.setRjlxs(rs.getDouble(rjlxs));
		e.setSzqy(rs.getString(szqy));
		e.setTddj(rs.getString(tddj));
		e.setTdyt(rs.getString(tdyt));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setXjbz(rs.getString(xjbz));
		e.setYsynx(rs.getLong(ysynx));
		e.setFcczcb(rs.getDouble(fcczcb));
		e.setDczddj(rs.getDouble(dczddj));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10031DAO#LoadBySwid(com.sunway.vo.Pgv10031)
	 */
	
	@Override
	public ArrayList<Pgv10031> LoadBySwid(Pgv10031 bean) throws Exception {
		ArrayList<Pgv10031> listResult = new ArrayList<Pgv10031>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT10031(?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getCd00002Pssdy());
			call.setString(5, bean.getCd12001Swid());
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

	/**
	 * Table数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv10031 SetVParameters(ResultSet rs) throws Exception {
		Pgv10031 e = new Pgv10031();
		e.setCd00002Pssd(rs.getDate(cd00002Pssd));
		e.setCd00002Pssdy(rs.getString(cd00002Pssdy));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setCd12004Mxid(rs.getString(cd12004Mxid));
		e.setCqf(rs.getDouble(cqf));
		e.setCxl(rs.getDouble(cxl));
		e.setCzl(rs.getDouble(czl));
		e.setCzr(rs.getString(czr));
		e.setDcpgjg(rs.getDouble(dcpgjg));
		e.setDcqtxz(rs.getDouble(dcqtxz));
		e.setDj(rs.getDouble(dj));
		e.setFcpgjg(rs.getDouble(fcpgjg));
		e.setFcqtxz(rs.getDouble(fcqtxz));
		e.setFwyt(rs.getString(fwyt));
		e.setGbrjl(rs.getDouble(gbrjl));
		e.setGyttdmj(rs.getDouble(gyttdmj));
		e.setJazj(rs.getDouble(jazj));
		e.setJjbbl(rs.getDouble(jjbbl));
		e.setJjnynx(rs.getLong(jjnynx));
		e.setJzjg(rs.getString(jzjg));
		e.setJzmj(rs.getDouble(jzmj));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setPgjg(rs.getDouble(pgjg));
		e.setPsss(rs.getDouble(psss));
		e.setRjlxs(rs.getDouble(rjlxs));
		e.setSzqy(rs.getString(szqy));
		e.setTddj(rs.getString(tddj));
		e.setTdyt(rs.getString(tdyt));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setXjbz(rs.getString(xjbz));
		e.setYsynx(rs.getLong(ysynx));
		e.setGbdcpgjg(rs.getDouble(gbdcpgjg));
		e.setGbdcxzxs(rs.getDouble(gbdcxzxs));
		e.setGbfcpgjg(rs.getDouble(gbfcpgjg));
		e.setGbfcxzxs(rs.getDouble(gbfcxzxs));
		e.setGbpgjg(rs.getDouble(gbpgjg));
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		return e;
	}
}