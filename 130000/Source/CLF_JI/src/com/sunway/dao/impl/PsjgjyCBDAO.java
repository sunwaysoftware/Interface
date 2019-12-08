package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPsjgjyCBDAO;
import com.sunway.vo.Pgv100314;
import com.sunway.vo.Pgv120101;
import com.sunway.vo.Pgv12010a1;

/**
 * @author Lee
 *
 */
public class PsjgjyCBDAO extends BaseDAO implements IPsjgjyCBDAO {

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
	private static final String cd00001Ssgx = "CD_00001_SSGX";		//税收管辖
	private static final String cbpgjg = "CBPGJG";					//成本评税结果
	private static final String cbfcpgjg = "CBFCPGJG";				//成本房产评税结果
	private static final String cbdcpgjg = "CBDCPGJG";				//成本地产评税结果
	private static final String cbpgczr = "CBPGCZR";				//成本评税操作人
	private static final String gbfcpgjg = "GBFCPGJG";				//个别房产评税结果
	private static final String gbdcpgjg = "GBDCPGJG";				//个别地产评税结果
	private static final String gbpgjg = "GBPGJG";					//个别评税结果
	private static final String gbfcxzxs = "GBFCXZXS";				//个别房产修正系数
	private static final String gbdcxzxs = "GBDCXZXS";				//个别地产修正系数.
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
	private static final String lc = "LC";							
	private static final String lrr = "LRR";
	private static final String recordCount = "TOTAL";
	private static final String recordIndex = "RID";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPsjgjyCBDAO#GetInsert120101Command(com.sunway.vo.Pgv120101)
	 */
	
	@Override
	public boolean GetInsert120101Command(Pgv120101 cbpsjgjy) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT120101(?,?,?,?,?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			//传入输入参数
			call.setString(2, cbpsjgjy.getCd12001Swid());
			call.setString(3, cbpsjgjy.getNsrmc());
			call.setString(4, cbpsjgjy.getCd00002Pssd());
			call.setString(5, cbpsjgjy.getCd00001Ssgx());
			call.setString(6, cbpsjgjy.getCd00001Tdyt());
			call.setString(7, cbpsjgjy.getCd00001Fwyt());
			call.setString(8, cbpsjgjy.getCd00001Jzjg());
			call.setString(9, cbpsjgjy.getJcnfbgn());
			call.setString(10, cbpsjgjy.getJcnfend());
			call.setString(11, cbpsjgjy.getCd00002Lrr());
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
	public Integer GetInsert12010A1Command(Pgv12010a1 cbpsjgjy)
			throws Exception {
		Integer iResult = null;
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT12010A1(?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			//传入输入参数
			call.setString(2, cbpsjgjy.getCd00002Pssd());
			call.setString(3, cbpsjgjy.getCd00001Ssgx());
			call.setString(4, cbpsjgjy.getCd00002Lrr());
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
	public ArrayList<Pgv100314> LoadAll100314(Pgv100314 cbpsjgjy)
			throws Exception {
		ArrayList<Pgv100314> listResult = new ArrayList<Pgv100314>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT100314(?,?,?,?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, cbpsjgjy.getPageIndex());
			call.setInt(3, cbpsjgjy.getPageSize());
			call.setString(4, cbpsjgjy.getCd12001Swid());
			call.setString(5, cbpsjgjy.getNsrmc());
			call.setString(6, cbpsjgjy.getCd00002Pssd());
			call.setString(7, cbpsjgjy.getCd00001Ssgx());
			call.setString(8, cbpsjgjy.getCd00001Tdyt());
			call.setString(9, cbpsjgjy.getCd00001Fwyt());
			call.setString(10, cbpsjgjy.getCd00001Jzjg());
			call.setString(11, cbpsjgjy.getJcnfbgn());
			call.setString(12, cbpsjgjy.getJcnfend());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetPgv100314Parameters(rs));
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
	protected Pgv100314 SetPgv100314Parameters(ResultSet rs) throws Exception {
		Pgv100314 e = new Pgv100314();
		e.setCd12004Mxid(rs.getString(cd12004Mxid));
		e.setFcpgjg(rs.getDouble(fcpgjg));
		e.setDcpgjg(rs.getDouble(dcpgjg));
		e.setPgjg(rs.getDouble(pgjg));
		e.setCd00002Pssdy(rs.getString(cd00002Pssdy));
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setCxl(rs.getDouble(cxl));
		e.setCzl(rs.getDouble(czl));
		e.setYsynx(rs.getLong(ysynx));
		e.setJjnynx(rs.getLong(jjnynx));
		e.setJazj(rs.getDouble(jazj));
		e.setJjbbl(rs.getDouble(jjbbl));
		e.setJzmj(rs.getDouble(jzmj));
		e.setRjlxs(rs.getDouble(rjlxs));
		e.setPsss(rs.getDouble(psss));
		e.setDj(rs.getDouble(dj));
		e.setGyttdmj(rs.getDouble(gyttdmj));
		e.setCqf(rs.getDouble(cqf));
		e.setTdyt(rs.getString(tdyt));
		e.setGbrjl(rs.getDouble(gbrjl));
		e.setSzqy(rs.getString(szqy));
		e.setTddj(rs.getString(tddj));
		e.setFwyt(rs.getString(fwyt));
		e.setXjbz(rs.getString(xjbz));
		e.setJzjg(rs.getString(jzjg));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCzr(rs.getString(czr));
		e.setNote(rs.getString(note));
		e.setDcqtxz(rs.getDouble(dcqtxz));
		e.setFcqtxz(rs.getDouble(fcqtxz));
		e.setGbfcpgjg(rs.getDouble(gbfcpgjg));
		e.setGbdcpgjg(rs.getDouble(gbdcpgjg));
		e.setGbpgjg(rs.getDouble(gbpgjg));
		e.setGbfcxzxs(rs.getDouble(gbfcxzxs));
		e.setGbdcxzxs(rs.getDouble(gbdcxzxs));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCbpgjg(rs.getDouble(cbpgjg));
		e.setCbfcpgjg(rs.getDouble(cbfcpgjg));
		e.setCbdcpgjg(rs.getDouble(cbdcpgjg));
		e.setCbpgczr(rs.getString(cbpgczr));
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPsjgjyCBDAO#LoadAll120101(com.sunway.vo.Pgv120101)
	 */
	
	@Override
	public ArrayList<Pgv120101> LoadAll120101(Pgv120101 cbpsjgjy)
			throws Exception {
		ArrayList<Pgv120101> listResult = new ArrayList<Pgv120101>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120101(?,?,?,?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, cbpsjgjy.getPageIndex());
			call.setInt(3, cbpsjgjy.getPageSize());
			call.setString(4, cbpsjgjy.getCd12001Swid());
			call.setString(5, cbpsjgjy.getNsrmc());
			call.setString(6, cbpsjgjy.getCd00002Pssd());
			call.setString(7, cbpsjgjy.getCd00001Ssgx());
			call.setString(8, cbpsjgjy.getCd00001Tdyt());
			call.setString(9, cbpsjgjy.getCd00001Fwyt());
			call.setString(10, cbpsjgjy.getCd00001Jzjg());
			call.setString(11, cbpsjgjy.getJcnfbgn());
			call.setString(12, cbpsjgjy.getJcnfend());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetPgv120101Parameters(rs));
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
	protected Pgv120101 SetPgv120101Parameters(ResultSet rs) throws Exception {
		Pgv120101 e = new Pgv120101();
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
	 * @see com.sunway.dao.IPsjgjyCBDAO#LoadAll12010A1(com.sunway.vo.Pgv12010a1)
	 */
	
	@Override
	public ArrayList<Pgv12010a1> LoadAll12010A1(Pgv12010a1 cbpsjgjy)
			throws Exception {
		ArrayList<Pgv12010a1> listResult = new ArrayList<Pgv12010a1>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12010A1(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, cbpsjgjy.getPageIndex());
			call.setInt(3, cbpsjgjy.getPageSize());
			call.setString(4, cbpsjgjy.getCd00002Pssd());
			call.setString(5, cbpsjgjy.getCd00001Ssgx());
			call.setString(6, cbpsjgjy.getCd00001Szqy());
			call.setString(7, cbpsjgjy.getCdjybz());
			call.setInt(8, cbpsjgjy.getPjzqs());
			call.setInt(9, cbpsjgjy.getPlsxs());
			call.setInt(10, cbpsjgjy.getPjgxgc());
			call.setDouble(11, cbpsjgjy.getBlMin());
			call.setDouble(12, cbpsjgjy.getBlMax());
			call.setDouble(13, cbpsjgjy.getLcMin());
			call.setDouble(14, cbpsjgjy.getLcMax());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetPgv12010a1Parameters(rs));
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
	protected Pgv12010a1 SetPgv12010a1Parameters(ResultSet rs) throws Exception {
		Pgv12010a1 e = new Pgv12010a1();
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
	 * @see com.sunway.dao.IPsjgjyCBDAO#GetDeleteCommand(java.lang.String)
	 */
	
	@Override
	public boolean GetDeleteCommand(String cjid) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12010(?)}");
			call.setString(1, cjid);
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
			call = conn.prepareCall("{call PGSP_DELT120101()}");
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
	 * @see com.sunway.dao.IPsjgjyCBDAO#LoadByPrimaryKey(java.lang.String)
	 */
	
	@Override
	public Pgv12010a1 LoadByPrimaryKey(String cjid) throws Exception {
		ArrayList<Pgv12010a1> listResult = new ArrayList<Pgv12010a1>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT12010A(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, cjid);
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
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv12010a1 SetTParameters(ResultSet rs) throws Exception {
		Pgv12010a1 e = new Pgv12010a1();
		e.setJzqs(rs.getDouble(jzqs));
		e.setLsxs(rs.getDouble(lsxs));
		e.setJgxgc(rs.getDouble(jgxgc));
		return e;
	}
}
