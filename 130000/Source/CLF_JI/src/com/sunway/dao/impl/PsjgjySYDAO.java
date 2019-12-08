package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPsjgjySYDAO;
import com.sunway.vo.Pgv020314;
import com.sunway.vo.Pgv120102;
import com.sunway.vo.Pgv12010a2;

/**
 * @author Lee
 *
 */
public class PsjgjySYDAO extends BaseDAO implements IPsjgjySYDAO {

	private static final String cd12004Mxid = "CD_12004_MXID";		//房产编码
	private static final String pgjg = "PGJG";						//成本法评税结果(元)
	private static final String cd00002Pssdy = "CD_00002_PSSDY";	//评税时点
	private static final String cd00002Pssd = "CD_00002_PSSD";		//显示用的评税时点（详细时间）
	private static final String tdyt = "TDYT";						//土地用途
	private static final String szqy = "SZQY";						//所在区域
	private static final String tddj = "TDDJ";						//土地等级
	private static final String fwyt = "FWYT";						//房屋用途
	private static final String xjbz = "XJBZ";						//星级标准
	private static final String jzjg = "JZJG";						//建筑结构
	private static final String upddate = "UPDDATE";				//更新时间
	private static final String czr = "CZR";						//录入人
	private static final String note = "NOTE";						//备注信息
	private static final String cd12001Swid = "CD_12001_SWID";		//税务登记代码
	private static final String nsrmc = "NSRMC";					//纳税人名称
	private static final String cd00001Ssgx = "CD_00001_SSGX";		//税收管辖
	private static final String gbpgjg = "GBPGJG";					//个别评税结果
	private static final String cjid = "CJID";						//采集编号
	private static final String cd12003Fcid = "CD_12003_FCID";		//房产编号
	private static final String cd12002Dcid = "CD_12002_DCID";		//地产编号
	private static final String cd00001Szqy = "CD_00001_SZQY";		//所在区域
	private static final String cd00001Tdyt = "CD_00001_TDYT";		//土地用途
	private static final String cd12054Tddjid = "CD_12054_TDDJID";	//土地等级编号
	private static final String fttdmj = "FTTDMJ";					//土地面积
	private static final String cd00001Fwyt = "CD_00001_FWYT";		//房屋用途
	private static final String cd00001Jzjg = "CD_00001_JZJG";		//建筑结构
	private static final String jcnf = "JCNF";						//建成年份
	private static final String ytjzmj = "YTJZMJ";					//用途建筑面积
	private static final String fcyz = "FCYZ";						//房产原值
	private static final String pglx = "PGLX";						//评税类型
	private static final String cd00002Lrr = "CD_00002_LRR";		//录入人
	private static final String jzqs = "JZQS";						//集中趋势
	private static final String lsxs = "LSXS";						//离散系数
	private static final String jgxgc = "JGXGC";					//价格相关差
	private static final String bl = "BL";							//比率
	private static final String lc = "LC";							//离差
	private static final String lrr = "LRR";						//录入人
	private static final String recordCount = "TOTAL";				//总行数
	private static final String recordIndex = "RID";				//行号
	private static final String sypgjg = "SYPGJG";					//收益评税结果
	private static final String sypgczr = "SYPGCZR";				//收益评税操作人
	private static final String mjxz = "MJXZ";						//面积修正
	private static final String cxxz = "CXXZ";						//朝向修正
	private static final String xjbzxz = "XJBZXZ";					//星级修正
	private static final String lcxz = "LCXZ";						//楼层修正
	private static final String ssxz = "SSXZ";						//设施修正
	private static final String zjbz = "ZJBZ";						//租金标准
	private static final String zbhl = "ZBHL";						//资本化率
	private static final String synx = "SYNX";						//收益年限
	private static final String fwcx = "FWCX";						//房屋朝向
	private static final String szcc = "SZCC";						//所在楼层
	private static final String ddid = "DDID";						//地段编码
	private static final String qtxz = "QTXZ";						//其它修正系统
	private static final String gbxzxs = "GBXZXS";
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPsjgjyCBDAO#GetInsert120101Command(com.sunway.vo.Pgv120101)
	 */
	
	@Override
	public boolean GetInsert120102Command(Pgv120102 sypsjgjy) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT120102(?,?,?,?,?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			//传入输入参数
			call.setString(2, sypsjgjy.getCd12001Swid());
			call.setString(3, sypsjgjy.getNsrmc());
			call.setString(4, sypsjgjy.getCd00002Pssd());
			call.setString(5, sypsjgjy.getCd00001Ssgx());
			call.setString(6, sypsjgjy.getCd00001Tdyt());
			call.setString(7, sypsjgjy.getCd00001Fwyt());
			call.setString(8, sypsjgjy.getCd00001Jzjg());
			call.setString(9, sypsjgjy.getJcnfbgn());
			call.setString(10, sypsjgjy.getJcnfend());
			call.setString(11, sypsjgjy.getCd00002Lrr());
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
	 * @see com.sunway.dao.IPsjgjyCBDAO#GetInsert12010A1Command(com.sunway.vo.Pgv12010a1)
	 */
	
	@Override
	public Integer GetInsert12010A2Command(Pgv12010a2 sypsjgjy) throws Exception {
		Integer iResult = null;
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT12010A2(?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			//传入输入参数
			call.setString(2, sypsjgjy.getCd00002Pssd());
			call.setString(3, sypsjgjy.getCd00001Ssgx());
			call.setString(4, sypsjgjy.getCd00002Lrr());
			call.execute();
			
			//返回数据集
			iResult = call.getInt(1);
			
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
			return iResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPsjgjyCBDAO#LoadAll100314(com.sunway.vo.Pgv100314)
	 */
	
	@Override
	public ArrayList<Pgv020314> LoadAll020314(Pgv020314 sypsjgjy) throws Exception {
		ArrayList<Pgv020314> listResult = new ArrayList<Pgv020314>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020314(?,?,?,?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, sypsjgjy.getPageIndex());
			call.setInt(3, sypsjgjy.getPageSize());
			call.setString(4, sypsjgjy.getCd12001Swid());
			call.setString(5, sypsjgjy.getNsrmc());
			call.setString(6, sypsjgjy.getCd00002Pssd());
			call.setString(7, sypsjgjy.getCd00001Ssgx());
			call.setString(8, sypsjgjy.getCd00001Tdyt());
			call.setString(9, sypsjgjy.getCd00001Fwyt());
			call.setString(10, sypsjgjy.getCd00001Jzjg());
			call.setString(11, sypsjgjy.getJcnfbgn());
			call.setString(12, sypsjgjy.getJcnfend());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetPgv020314Parameters(rs));
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
	protected Pgv020314 SetPgv020314Parameters(ResultSet rs) throws Exception {
		Pgv020314 e = new Pgv020314();
		e.setCd12004Mxid(rs.getString(cd12004Mxid));
		e.setCd00002Pssdy(rs.getString(cd00002Pssdy));
		e.setPgjg(rs.getDouble(pgjg));
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setMjxz(rs.getDouble(mjxz));
		e.setCxxz(rs.getDouble(cxxz));
		e.setXjbzxz(rs.getDouble(xjbzxz));
		e.setLcxz(rs.getDouble(lcxz));
		e.setSsxz(rs.getDouble(ssxz));
		e.setZjbz(rs.getDouble(zjbz));
		e.setZbhl(rs.getDouble(zbhl));
		e.setSynx(rs.getDouble(synx));
		e.setYtjzmj(rs.getDouble(ytjzmj));
		e.setSzqy(rs.getString(szqy));
		e.setFwyt(rs.getString(fwyt));
		e.setFwcx(rs.getString(fwcx));
		e.setXjbz(rs.getString(xjbz));
		e.setJzjg(rs.getString(jzjg));
		e.setSzcc(rs.getString(szcc));
		e.setDdid(rs.getString(ddid));
		e.setJcnf(rs.getString(jcnf));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCzr(rs.getString(czr));
		e.setNote(rs.getString(note));
		e.setQtxz(rs.getDouble(qtxz));
		e.setGbpgjg(rs.getDouble(gbpgjg));
		e.setGbxzxs(rs.getDouble(gbxzxs));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setSypgjg(rs.getDouble(sypgjg));
		e.setSypgczr(rs.getString(sypgczr));
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPsjgjyCBDAO#LoadAll120102(com.sunway.vo.Pgv120102)
	 */
	
	@Override
	public ArrayList<Pgv120102> LoadAll120102(Pgv120102 sypsjgjy)
			throws Exception {
		ArrayList<Pgv120102> listResult = new ArrayList<Pgv120102>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120102(?,?,?,?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, sypsjgjy.getPageIndex());
			call.setInt(3, sypsjgjy.getPageSize());
			call.setString(4, sypsjgjy.getCd12001Swid());
			call.setString(5, sypsjgjy.getNsrmc());
			call.setString(6, sypsjgjy.getCd00002Pssd());
			call.setString(7, sypsjgjy.getCd00001Ssgx());
			call.setString(8, sypsjgjy.getCd00001Tdyt());
			call.setString(9, sypsjgjy.getCd00001Fwyt());
			call.setString(10, sypsjgjy.getCd00001Jzjg());
			call.setString(11, sypsjgjy.getJcnfbgn());
			call.setString(12, sypsjgjy.getJcnfend());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetPgv120102Parameters(rs));
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
	protected Pgv120102 SetPgv120102Parameters(ResultSet rs) throws Exception {
		Pgv120102 e = new Pgv120102();
		e.setCjid(rs.getString(cjid));
		e.setCd12004Mxid(rs.getString(cd12004Mxid));
		e.setCd12003Fcid(rs.getString(cd12003Fcid));
		e.setCd12002Dcid(rs.getString(cd12002Dcid));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCd00001Tdyt(rs.getString(cd00001Tdyt));
		e.setCd12054Tddjid(rs.getString(cd12054Tddjid));
		e.setFttdmj(rs.getDouble(fttdmj));
		e.setCd00001Fwyt(rs.getString(cd00001Fwyt));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJcnf(rs.getString(jcnf));
		e.setYtjzmj(rs.getDouble(ytjzmj));
		e.setFcyz(rs.getDouble(fcyz));
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setPgjg(rs.getDouble(pgjg));
		e.setPglx(rs.getBoolean(pglx));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Lrr(rs.getString(cd00002Lrr));
		e.setNote(rs.getString(note));
		e.setSzqy(rs.getString(szqy));
		e.setTdyt(rs.getString(tdyt));
		e.setTddj(rs.getString(tddj));
		e.setFwyt(rs.getString(fwyt));
		e.setJzjg(rs.getString(jzjg));
		e.setLrr(rs.getString(lrr));
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPsjgjyCBDAO#LoadAll12010A2(com.sunway.vo.Pgv12010a2)
	 */
	
	@Override
	public ArrayList<Pgv12010a2> LoadAll12010A2(Pgv12010a2 sypsjgjy)
			throws Exception {
		ArrayList<Pgv12010a2> listResult = new ArrayList<Pgv12010a2>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12010A2(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, sypsjgjy.getPageIndex());
			call.setInt(3, sypsjgjy.getPageSize());
			call.setString(4, sypsjgjy.getCd00002Pssd());
			call.setString(5, sypsjgjy.getCd00001Ssgx());
			call.setString(6, sypsjgjy.getCd00001Szqy());
			call.setString(7, sypsjgjy.getCdjybz());
			call.setInt(8, sypsjgjy.getPjzqs());
			call.setInt(9, sypsjgjy.getPlsxs());
			call.setInt(10, sypsjgjy.getPjgxgc());
			call.setDouble(11, sypsjgjy.getBlMin());
			call.setDouble(12, sypsjgjy.getBlMax());
			call.setDouble(13, sypsjgjy.getLcMin());
			call.setDouble(14, sypsjgjy.getLcMax());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetPgv12010a2Parameters(rs));
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
	protected Pgv12010a2 SetPgv12010a2Parameters(ResultSet rs) throws Exception {
		Pgv12010a2 e = new Pgv12010a2();
		e.setCjid(rs.getString(cjid));
		e.setCd12004Mxid(rs.getString(cd12004Mxid));
		e.setCd12003Fcid(rs.getString(cd12003Fcid));
		e.setCd12002Dcid(rs.getString(cd12002Dcid));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCd00001Tdyt(rs.getString(cd00001Tdyt));
		e.setCd12054Tddjid(rs.getString(cd12054Tddjid));
		e.setFttdmj(rs.getDouble(fttdmj));
		e.setCd00001Fwyt(rs.getString(cd00001Fwyt));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJcnf(rs.getString(jcnf));
		e.setYtjzmj(rs.getDouble(ytjzmj));
		e.setFcyz(rs.getDouble(fcyz));
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setPgjg(rs.getDouble(pgjg));
		e.setPglx(rs.getBoolean(pglx));
		e.setSzqy(rs.getString(szqy));
		e.setTdyt(rs.getString(tdyt));
		e.setTddj(rs.getString(tddj));
		e.setFwyt(rs.getString(fwyt));
		e.setJzjg(rs.getString(jzjg));
		e.setJzqs(rs.getDouble(jzqs));
		e.setLsxs(rs.getDouble(lsxs));
		e.setJgxgc(rs.getDouble(jgxgc));
		e.setBl(rs.getDouble(bl));
		e.setLc(rs.getDouble(lc));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Lrr(rs.getString(cd00002Lrr));
		e.setNote(rs.getString(note));
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPsjgjyCBDAO#DeleteAllCommand()
	 */
	
	@Override
	public boolean DeleteAllCommand() throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT120102()}");
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
