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

import com.sunway.dao.IPgt02031DAO;
import com.sunway.vo.Pgt02031;
import com.sunway.vo.Pgv02031;

/**
 * 
 * 收益法评税结果
 * @author Andy.Gao
 *
 */
public class Pgt02031DAO extends BaseDAO implements IPgt02031DAO {

	private static final String cd12004Mxid = "CD_12004_MXID";		//房产明细编码
	private static final String cd00002Pssdy = "CD_00002_PSSDY";	//评税时点
	private static final String pgjg = "PGJG";						//收益法评税结果(元)
	private static final String cd00002Pssd = "CD_00002_PSSD";		//显示用的评税时点（详细时间）
	private static final String mjxz = "MJXZ";						//面积修正
	private static final String cxxz = "CXXZ";						//朝向修正
	private static final String xjbzxz = "XJBZXZ";					//星级修正
	private static final String lcxz = "LCXZ";						//楼层修正
	private static final String ssxz = "SSXZ";						//设施修正
	private static final String zjbz = "ZJBZ";						//租金标准
	private static final String zbhl = "ZBHL";						//资本化率
	private static final String synx = "SYNX";						//收益年限
	private static final String ytjzmj = "YTJZMJ";					//建筑面积
	private static final String szqy = "SZQY";						//所在区域
	private static final String fwyt = "FWYT";						//房屋用途
	private static final String fwcx = "FWCX";						//房屋朝向
	private static final String xjbz = "XJBZ";						//星级标准
	private static final String jzjg = "JZJG";						//建筑结构
	private static final String szcc = "SZCC";						//所在楼层
	private static final String ddid = "DDID";						//地段编码
	private static final String jcnf = "JCNF";						//建成年份
	private static final String upddate = "UPDDATE";				//更改时间
	private static final String czr = "CZR";						//操作人字段
	private static final String note = "NOTE";						//备注信息
	private static final String qtxz = "QTXZ";						//其它修正系统
	private static final String cd12001Swid = "CD_12001_SWID";		//税务登记代码
	private static final String nsrmc = "NSRMC";					//纳税人名称
	private static final String cd00001Ssgx = "CD_00001_SSGX";		//税收管辖
	private static final String jsy = "JSY";						
	private static final String gbpgjg = "GBPGJG";
	private static final String gbxzxs = "GBXZXS";
	private static final String recordCount = "TOTAL";
	private static final String recordIndex = "RID";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02031DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10031)
	 */
	
	@Override
	public Pgt02031 LoadByPrimaryKey(Pgt02031 bean) throws Exception {
		ArrayList<Pgt02031> listResult = new ArrayList<Pgt02031>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02031(?,?,?)}");
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
	protected Pgt02031 SetTParameters(ResultSet rs) throws Exception {
		Pgt02031 e = new Pgt02031();
		e.setCd00002Pssd(rs.getDate(cd00002Pssd));
		e.setCd00002Pssdy(rs.getString(cd00002Pssdy));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setCd12004Mxid(rs.getString(cd12004Mxid));
		e.setCzr(rs.getString(czr));
		e.setFwyt(rs.getString(fwyt));
		e.setJzjg(rs.getString(jzjg));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setPgjg(rs.getDouble(pgjg));
		e.setSzqy(rs.getString(szqy));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setXjbz(rs.getString(xjbz));
		e.setMjxz(rs.getDouble(mjxz));
		e.setCxxz(rs.getDouble(cxxz));
		e.setXjbzxz(rs.getDouble(xjbzxz));
		e.setLcxz(rs.getDouble(lcxz));
		e.setSsxz(rs.getDouble(ssxz));
		e.setZjbz(rs.getDouble(zjbz));
		e.setZbhl(rs.getDouble(zbhl));
		e.setSynx(rs.getDouble(synx));
		e.setYtjzmj(rs.getDouble(ytjzmj));
		e.setFwcx(rs.getString(fwcx));
		e.setQtxz(rs.getDouble(qtxz));
		e.setSzcc(rs.getString(szcc));
		e.setJcnf(rs.getString(jcnf));
		e.setDdid(rs.getString(ddid));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setJsy(rs.getDouble(jsy));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02031DAO#LoadBySwid(com.sunway.vo.Pgv02031)
	 */
	
	@Override
	public ArrayList<Pgv02031> LoadBySwid(Pgv02031 bean) throws Exception {
		ArrayList<Pgv02031> listResult = new ArrayList<Pgv02031>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02031(?,?,?,?,?)}");
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
	protected Pgv02031 SetVParameters(ResultSet rs) throws Exception {
		Pgv02031 e = new Pgv02031();
		e.setCd00002Pssd(rs.getDate(cd00002Pssd));
		e.setCd00002Pssdy(rs.getString(cd00002Pssdy));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setCd12004Mxid(rs.getString(cd12004Mxid));
		e.setCzr(rs.getString(czr));
		e.setFwyt(rs.getString(fwyt));
		e.setJzjg(rs.getString(jzjg));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setPgjg(rs.getDouble(pgjg));
		e.setSzqy(rs.getString(szqy));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setXjbz(rs.getString(xjbz));
		e.setMjxz(rs.getDouble(mjxz));
		e.setCxxz(rs.getDouble(cxxz));
		e.setXjbzxz(rs.getDouble(xjbzxz));
		e.setLcxz(rs.getDouble(lcxz));
		e.setSsxz(rs.getDouble(ssxz));
		e.setZjbz(rs.getDouble(zjbz));
		e.setZbhl(rs.getDouble(zbhl));
		e.setSynx(rs.getDouble(synx));
		e.setYtjzmj(rs.getDouble(ytjzmj));
		e.setFwcx(rs.getString(fwcx));
		e.setQtxz(rs.getDouble(qtxz));
		e.setSzcc(rs.getString(szcc));
		e.setJcnf(rs.getString(jcnf));
		e.setDdid(rs.getString(ddid));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setGbpgjg(rs.getDouble(gbpgjg));
		e.setGbxzxs(rs.getDouble(gbxzxs));
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		return e;		
	}
	
}
