package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPsjgjySCDAO;
import com.sunway.util.Common;
import com.sunway.vo.Pgv003314;
import com.sunway.vo.Pgv00310;
import com.sunway.vo.Pgv00310A;

/**
 * @author Lee
 *
 */
public class PsjgjySCDAO extends BaseDAO implements IPsjgjySCDAO {

	private static final String cd00302Fcid = "CD_00302_FCID";		//房产编码
	private static final String pgjg = "PGJG";						//成本法评税结果(元)
	private static final String cd00002Pssdy = "CD_00002_PSSDY";	//评税时点
	private static final String cd00002Pssd = "CD_00002_PSSD";		//显示用的评税时点（详细时间）
	private static final String szqy = "SZQY";						//所在区域
	private static final String xqdm = "XQDM";						//小区代码
	private static final String jzjg = "JZJG";						//建筑结构
	private static final String upddate = "UPDDATE";				//更新时间
	private static final String czr = "CZR";						//录入人
	private static final String note = "NOTE";						//备注信息
	private static final String nsrmc = "NSRMC";					//纳税人名称
	private static final String cd00001Ssgx = "CD_00001_SSGX";		//税收管辖
	private static final String gbpgjg = "GBPGJG";					//个别评税结果
	private static final String cjid = "CJID";						//采集编号
	private static final String cd00001Szqy = "CD_00001_SZQY";		//所在区域
	private static final String cd00001Jzjg = "CD_00001_JZJG";		//建筑结构
	private static final String jzqs = "JZQS";						//集中趋势
	private static final String lsxs = "LSXS";						//离散系数
	private static final String jgxgc = "JGXGC";					//价格相关差
	private static final String bl = "BL";							//比率
	private static final String lc = "LC";							//离差
	private static final String recordCount = "TOTAL";				//总行数
	private static final String recordIndex = "RID";				//行号
	private static final String scpgjg = "SCPGJG";					//市场评税结果
	private static final String scpgczr = "SCPGCZR";				//市场评税操作人
	private static final String jzmj = "jzmj";						//建筑面积
	//private static final String cxxz = "CXXZ";						//朝向修正
	private static final String pfmjg = "PFMJG";					//平方米价格
//	private static final String lcxz = "LCXZ";						//楼层修正
	//private static final String cgxz = "CGXZ";						//采光修正
	private static final String fwcx = "FWCX";						//房屋朝向
	private static final String cd00301Swid = "CD_00301_SWID";		//税务代码
	private static final String cd00303Lfid = "CD_00303_LFID";		//
	private static final String cd00001Fwlx = "CD_00001_FWLX";		//房屋朝向
	private static final String cd00001Jylx = "CD_00001_JYLX";		//交易类型
	private static final String cd00001Fwcx = "CD_00001_FWCX";		//房屋朝向
	private static final String cd00001Cgzk = "CD_00001_CGZK";		//采光状况
	private static final String szlc = "SZLC";						//所在楼层
	private static final String jyjg = "JYJG";						//交易结果
	private static final String dtgj = "DTGJ";						//大厅估价
	private static final String rjl = "RJL";						//容积率
	private static final String jysj = "JYSJ";						//交易时间
	private static final String cd00002Czr = "CD_00002_CZR";		//操作人
	private static final String cd00352Xqdm = "CD_00352_XQDM";		//小区代码
	private static final String ywdt = "YWDT";						//有无
	private static final String zlc = "ZLC";						//总楼层
	private static final String fwtdzl = "FWTDZL";					//房屋土地位置
	private static final String xqnm = "XQNM";						//小区名称
	private static final String fwlx = "FWLX";						//房屋类型
	private static final String jylx = "JYLX";						//交易类型
	private static final String cgzk = "CGZK";						//采光状况
	private static final String cd00002Lrr = "CD_00002_LRR";		//录入人人
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPsjgjyCBDAO#GetInsert120101Command(com.sunway.vo.Pgv120101)
	 */
	
	@Override
	public boolean GetInsert003101Command(Pgv00310 scpsjgjy) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT003101(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			//传入输入参数
			call.setString(2, scpsjgjy.getCd00301Swid());
			call.setString(3, scpsjgjy.getNsrmc());
			call.setString(4, scpsjgjy.getCd00002Pssd());
			call.setString(5, scpsjgjy.getCd00001Ssgx());
			call.setString(6, scpsjgjy.getCd00352Xqdm());
			call.setString(7, scpsjgjy.getCd00001Fwlx());
			call.setString(8, scpsjgjy.getCd00001Jzjg());
			call.setDate(9, Common.converDate(scpsjgjy.getJcnfbgn()));
			call.setDate(10, Common.converDate(scpsjgjy.getJcnfend()));
			call.setString(11, scpsjgjy.getCd00002Czr());
			call.setString(12, scpsjgjy.getCd00001Szqy());
			call.setDouble(13, scpsjgjy.getJzmjMin());
			call.setDouble(14, scpsjgjy.getJzmjMax());
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
	public Integer GetInsert00310A1Command(Pgv00310A scpsjgjy) throws Exception {
		Integer iResult = null;
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00310A1(?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			//传入输入参数
			call.setString(2, scpsjgjy.getCd00002Pssd());
			call.setString(3, scpsjgjy.getCd00001Ssgx());
			call.setString(4, scpsjgjy.getCd00002Czr());
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
	public ArrayList<Pgv003314> LoadAll003314(Pgv003314 scpsjgjy) throws Exception {
		ArrayList<Pgv003314> listResult = new ArrayList<Pgv003314>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003314(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, scpsjgjy.getPageIndex());
			call.setInt(3, scpsjgjy.getPageSize());
			call.setString(4, scpsjgjy.getCd00301Swid());
			call.setString(5, scpsjgjy.getNsrmc());
			call.setString(6, scpsjgjy.getCd00002Pssd());
			call.setString(7, scpsjgjy.getCd00001Ssgx());
			call.setString(8, scpsjgjy.getCd00352Xqdm());
			call.setString(9, scpsjgjy.getCd00001Fwlx());
			call.setString(10, scpsjgjy.getCd00001Jzjg());
			call.setDate(11, Common.converDate(Common.convertStringToDate(scpsjgjy.getJcnfbgn())));
			call.setDate(12, Common.converDate(Common.convertStringToDate(scpsjgjy.getJcnfend())));
			call.setString(13, scpsjgjy.getSzqy());
			call.setDouble(14, scpsjgjy.getJzmjMin());
			call.setDouble(15, scpsjgjy.getJzmjMax());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetPgv003314Parameters(rs));
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
	protected Pgv003314 SetPgv003314Parameters(ResultSet rs) throws Exception {
		Pgv003314 e = new Pgv003314();
		e.setCd00302Fcid(rs.getString(cd00302Fcid));
		e.setCd00002Pssdy(rs.getString(cd00002Pssdy));
		e.setPgjg(rs.getDouble(pgjg));
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setPfmjg(rs.getDouble(pfmjg));
		e.setJysj(rs.getDate(jysj));
		//e.setLcxz(rs.getDouble(lcxz));
		//e.setCxxz(rs.getDouble(cxxz));
		//e.setCgxz(rs.getDouble(cgxz));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setXqdm(rs.getString(xqdm));
		e.setFwlx(rs.getString(fwlx));
		e.setJylx(rs.getString(jylx));
		e.setJzjg(rs.getString(jzjg));
		//e.setFwcx(rs.getString(fwcx));
		//e.setCgzk(rs.getString(cgzk));
		e.setSzlc(rs.getShort(szlc));
		e.setZlc(rs.getShort(zlc));
		e.setFwtdzl(rs.getString(fwtdzl));
		e.setYwdt(rs.getBoolean(ywdt));
		e.setJzmj(rs.getDouble(jzmj));
		e.setCd00301Swid(rs.getString(cd00301Swid));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCzr(rs.getString(czr));
		e.setNote(rs.getString(note));
		e.setGbpgjg(rs.getDouble(gbpgjg));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setScpgjg(rs.getDouble(scpgjg));
		e.setScpgczr(rs.getString(scpgczr));
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPsjgjyCBDAO#LoadAll00310(com.sunway.vo.Pgv00310)
	 */
	
	@Override
	public ArrayList<Pgv00310> LoadAll00310(Pgv00310 scpsjgjy)
			throws Exception {
		ArrayList<Pgv00310> listResult = new ArrayList<Pgv00310>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00310(?,?,?,?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, scpsjgjy.getPageIndex());
			call.setInt(3, scpsjgjy.getPageSize());
			call.setString(4, scpsjgjy.getCd00301Swid());
			call.setString(5, scpsjgjy.getNsrmc());
			call.setString(6, scpsjgjy.getCd00002Pssd());
			call.setString(7, scpsjgjy.getCd00001Ssgx());
			call.setString(8, scpsjgjy.getCd00352Xqdm());
			call.setString(9, scpsjgjy.getCd00001Fwlx());
			call.setString(9, scpsjgjy.getCd00001Fwyt());
			call.setString(10, scpsjgjy.getCd00001Jzjg());
			call.setDate(11, Common.converDate(scpsjgjy.getJcnfbgn()));
			call.setDate(12, Common.converDate(scpsjgjy.getJcnfend()));
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetPgv00310Parameters(rs));
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
	protected Pgv00310 SetPgv00310Parameters(ResultSet rs) throws Exception {
		Pgv00310 e = new Pgv00310();
		e.setCjid(rs.getString(cjid));
		e.setCd00302Fcid(rs.getString(cd00302Fcid));
		e.setCd00301Swid(rs.getString(cd00301Swid));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCd00352Xqdm(rs.getString(cd00352Xqdm));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setYwdt(rs.getBoolean(ywdt));
		e.setZlc(rs.getInt(zlc));
		e.setJzmj(rs.getDouble(jzmj));
		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
		e.setCd00001Cgzk(rs.getString(cd00001Cgzk));
		e.setSzlc(rs.getInt(szlc));
		e.setJyjg(rs.getDouble(jyjg));
		e.setDtgj(rs.getDouble(dtgj));
		e.setJysj(rs.getDate(jysj));
		e.setRjl(rs.getDouble(rjl));
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setPgjg(rs.getDouble(pgjg));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setSzqy(rs.getString(szqy));
		e.setXqnm(rs.getString(xqnm));
		e.setFwlx(rs.getString(fwlx));
		e.setJylx(rs.getString(jylx));
		e.setJzjg(rs.getString(jzjg));
		e.setFwcx(rs.getString(fwcx));
		e.setCgzk(rs.getString(cgzk));
		e.setCzr(rs.getString(czr));
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPsjgjyCBDAO#LoadAll12010A2(com.sunway.vo.Pgv00310A)
	 */
	
	@Override
	public ArrayList<Pgv00310A> LoadAll00310A(Pgv00310A scpsjgjy)
			throws Exception {
		ArrayList<Pgv00310A> listResult = new ArrayList<Pgv00310A>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00310A(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, scpsjgjy.getPageIndex());
			call.setInt(3, scpsjgjy.getPageSize());
			call.setString(4, scpsjgjy.getCd00002Pssd());
			call.setString(5, scpsjgjy.getCd00001Ssgx());
			call.setString(6, scpsjgjy.getCd00001Szqy());
			call.setString(7, scpsjgjy.getCdjybz());
			call.setInt(8, scpsjgjy.getPjzqs());
			call.setInt(9, scpsjgjy.getPlsxs());
			call.setInt(10, scpsjgjy.getPjgxgc());
			call.setDouble(11, scpsjgjy.getBlMin());
			call.setDouble(12, scpsjgjy.getBlMax());
			call.setDouble(13, scpsjgjy.getLcMin());
			call.setDouble(14, scpsjgjy.getLcMax());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetPgv00310AParameters(rs));
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
	protected Pgv00310A SetPgv00310AParameters(ResultSet rs) throws Exception {
		Pgv00310A e = new Pgv00310A();
		e.setCjid(rs.getString(cjid));
		e.setCd00302Fcid(rs.getString(cd00302Fcid));
		e.setCd00301Swid(rs.getString(cd00301Swid));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCd00352Xqdm(rs.getString(cd00352Xqdm));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setYwdt(rs.getBoolean(ywdt));
		e.setZlc(rs.getInt(zlc));
		e.setJzmj(rs.getDouble(jzmj));
		//e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
		//e.setCd00001Cgzk(rs.getString(cd00001Cgzk));
		e.setSzlc(rs.getInt(szlc));
		e.setJyjg(rs.getDouble(jyjg));
		//e.setDtgj(rs.getDouble(dtgj));
		e.setJysj(rs.getDate(jysj));
		e.setRjl(rs.getDouble(rjl));
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setPgjg(rs.getDouble(pgjg));
		e.setSzqy(rs.getString(szqy));
		e.setXqnm(rs.getString(xqnm));
		e.setFwlx(rs.getString(fwlx));
		e.setJylx(rs.getString(jylx));
		e.setJzjg(rs.getString(jzjg));
		//e.setFwcx(rs.getString(fwcx));
		//e.setCgzk(rs.getString(cgzk));
		e.setCzr(rs.getString(czr));
		e.setJzqs(rs.getDouble(jzqs));
		e.setLsxs(rs.getDouble(lsxs));
		e.setJgxgc(rs.getDouble(jgxgc));
		e.setBl(rs.getDouble(bl));
		e.setLc(rs.getDouble(lc));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Lrr));
		e.setNote(rs.getString(note));
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPsjgjySCDAO#GetDeleteCommand(java.lang.String)
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
			call = conn.prepareCall("{call PGSP_DELT00310(?)}");
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
			call = conn.prepareCall("{call PGSP_DELT003101()}");
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
	 * @see com.sunway.dao.IPsjgjySCDAO#LoadByPrimaryKey(java.lang.String)
	 */
	
	@Override
	public Pgv00310A LoadByPrimaryKey(String cjid) throws Exception {
		ArrayList<Pgv00310A> listResult = new ArrayList<Pgv00310A>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00310A(?,?)}");
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
	protected Pgv00310A SetTParameters(ResultSet rs) throws Exception {
		Pgv00310A e = new Pgv00310A();
		e.setJzqs(rs.getDouble(jzqs));
		e.setLsxs(rs.getDouble(lsxs));
		e.setJgxgc(rs.getDouble(jgxgc));
		return e;
	}
}
