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

import com.sunway.dao.IPgt00331DAO;
import com.sunway.vo.Pgt00331;
import com.sunway.vo.Pgv00331;

/**
 *
 * 市场法评税结果
 * @author Andy.Gao
 *
 */
public class Pgt00331DAO extends BaseDAO implements IPgt00331DAO {

	private static final String cd00302Fcid = "CD_00302_FCID";		//评税的编码
	private static final String cd00002Pssdy = "CD_00002_PSSDY";	//评税时点
	private static final String pgjg = "PGJG";						//市场法评税结果
	private static final String cd00002Pssd = "CD_00002_PSSD";		//评税时点
	private static final String pfmjg = "PFMJG";					//修正后的单价
	private static final String jysj = "JYSJ";						//交易时间
	//private static final String lcxz = "LCXZ";						//楼层修正系数
	private static final String cd00303Lfid = "CD_00303_LFID";		//楼房ID号
	private static final String xqdm = "XQDM";						//小区代码加名称
	private static final String fwlx = "FWLX";						//房屋类型
	private static final String jylx = "JYLX";						//交易类型(0新)
	private static final String jzjg = "JZJG";						//建筑结构
	private static final String szlc = "SZLC";						//所在楼层
	private static final String zlc = "ZLC";						//总楼层
	private static final String ywdt = "YWDT";						//有无电梯(0无)
	private static final String jzmj = "JZMJ";						//建筑面积(平方米)
	private static final String cd00301Swid = "CD_00301_SWID";		//税务登记代码
	private static final String upddate = "UPDDATE";				//更新日期
	private static final String czr = "CZR";						//操作人字段
	private static final String note = "NOTE";						//备注信息
	private static final String nsrmc = "NSRMC";					//姓名
	private static final String cd00001Ssgx = "CD_00001_SSGX";		//税收管辖
	private static final String gbpgjg = "GBPGJG";
	private static final String gbxzxs = "GBXZXS";
	private static final String recordCount = "TOTAL";
	private static final String zjhm = "ZJHM";
	private static final String pgjgxz = "PGJGXZ";
	private static final String pgxz = "PGXZ";
	private static final String gbpgnote = "GBPGNOTE";
	private static final String zcdzl = "zcdzl";
	private static final String lh = "lh";
	private static final String dyh = "dyh";
	private static final String bwjfh = "bwjfh";
	private static final String jyjg = "jyjg";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00331DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00331)
	 */
	
	@Override
	public Pgt00331 LoadByPrimaryKey(Pgt00331 bean) throws Exception {
		ArrayList<Pgt00331> listResult = new ArrayList<Pgt00331>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00331(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd00302Fcid());
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

	
	
	public Pgt00331 LoadByPrimaryKey_B(Pgt00331 bean) throws Exception {
		ArrayList<Pgt00331> listResult = new ArrayList<Pgt00331>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00331_B(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd00302Fcid());
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
	protected Pgt00331 SetTParameters(ResultSet rs) throws Exception {
		Pgt00331 e = new Pgt00331();
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00002Pssd(rs.getDate(cd00002Pssd));
		e.setCd00002Pssdy(rs.getString(cd00002Pssdy));
		e.setCd00301Swid(rs.getString(cd00301Swid));
		e.setCd00302Fcid(rs.getString(cd00302Fcid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		//e.setCgxz(rs.getDouble(cgxz));
		//e.setCgzk(rs.getString(cgzk));
		//e.setCxxz(rs.getDouble(cxxz));
		e.setCzr(rs.getString(czr));
		//e.setFwcx(rs.getString(fwcx));
		e.setFwlx(rs.getString(fwlx));
		//e.setFwtdzl(rs.getString(fwtdzl));
		e.setJylx(rs.getString(jylx));
		e.setJysj(rs.getDate(jysj));
		e.setJzjg(rs.getString(jzjg));
		e.setJzmj(rs.getDouble(jzmj));
		//e.setLcxz(rs.getDouble(lcxz));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setPfmjg(rs.getDouble(pfmjg));
		e.setPgjg(rs.getDouble(pgjg));
		e.setSzlc(rs.getShort(szlc));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setXqdm(rs.getString(xqdm));
		e.setYwdt(rs.getBoolean(ywdt));
		e.setZlc(rs.getShort(zlc));
		e.setGapgjg(rs.getDouble(gbpgjg));
		e.setZcdzl(rs.getString(zcdzl));
		e.setLh(rs.getString(lh));
		e.setDyh(rs.getString(dyh));
		e.setBwjfh(rs.getString(bwjfh));
		e.setJyjg(rs.getDouble(jyjg));
		/*if(rs.getDouble(gbpgjg)==0.0)
			e.setGapgjg(rs.getDouble(pgjg));
		else
			e.setGapgjg(rs.getDouble(gbpgjg));*/
		e.setGaxzxs(rs.getDouble(gbxzxs));
		e.setZjhm(rs.getString(zjhm));
		e.setPgjgxz(rs.getDouble(pgjgxz));
		e.setPgxz(rs.getDouble(pgxz));
		e.setGaNote(rs.getString(gbpgnote));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00331DAO#LoadBySwid(com.sunway.vo.Pgv00331)
	 */
	
	@Override
	public ArrayList<Pgv00331> LoadBySwid(Pgv00331 bean) throws Exception {
		ArrayList<Pgv00331> listResult = new ArrayList<Pgv00331>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00331(?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getCd00301Swid());
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
	protected Pgv00331 SetVParameters(ResultSet rs) throws Exception {
		Pgv00331 e = new Pgv00331();
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00002Pssd(rs.getDate(cd00002Pssd));
		e.setCd00002Pssdy(rs.getString(cd00002Pssdy));
		e.setCd00301Swid(rs.getString(cd00301Swid));
		e.setCd00302Fcid(rs.getString(cd00302Fcid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		//e.setCgxz(rs.getDouble(cgxz));
		//e.setCgzk(rs.getString(cgzk));
		//e.setCxxz(rs.getDouble(cxxz));
		e.setCzr(rs.getString(czr));
		//e.setFwcx(rs.getString(fwcx));
		e.setFwlx(rs.getString(fwlx));
		//e.setFwtdzl(rs.getString(fwtdzl));
		e.setJylx(rs.getString(jylx));
		e.setJysj(rs.getDate(jysj));
		e.setJzjg(rs.getString(jzjg));
		e.setJzmj(rs.getDouble(jzmj));
		//e.setLcxz(rs.getDouble(lcxz));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setPfmjg(rs.getDouble(pfmjg));
		e.setPgjg(rs.getDouble(pgjg));
		e.setSzlc(rs.getShort(szlc));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setXqdm(rs.getString(xqdm));
		e.setYwdt(rs.getBoolean(ywdt));
		e.setZlc(rs.getShort(zlc));
		e.setGbpgjg(rs.getDouble(gbpgjg));
		e.setRecordCount(rs.getInt(recordCount));
		return e;
	}
}