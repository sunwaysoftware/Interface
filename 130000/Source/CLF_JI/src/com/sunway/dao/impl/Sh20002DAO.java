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

import com.sunway.dao.ISh20002DAO;
import com.sunway.vo.Pgv12001;

/**
 * 
 * 通過审核操作[收益法]
 * @author Andy.Gao
 * @category 數據審核[收益法]
 *
 */
public class Sh20002DAO extends BaseDAO implements ISh20002DAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.ISh20002DAO#GetExecShAgain(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public Boolean GetExecShAgain(Pgv12001 bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02083(?,?,?,?)}");
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
	 * @see com.sunway.dao.ISh20002DAO#GetExecShAgainAll(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public Boolean GetExecShAgainAll(Pgv12001 bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02084(?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getSwid());
			call.setString(2, bean.getNsrmc());
			call.setString(3, bean.getSysSsgx());
			call.setString(4, bean.getShCzr());
			call.setString(5, bean.getSysPssd());
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
	 * @see com.sunway.dao.ISh20002DAO#LoadShOK(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public ArrayList<Pgv12001> LoadShOK(Pgv12001 bean) throws Exception {
		ArrayList<Pgv12001> listResult = new ArrayList<Pgv12001>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120014(?,?,?,?,?,?,?)}");
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
				listResult.add(SetV12001Parameters(rs, true));
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
	protected Pgv12001 SetV12001Parameters(ResultSet rs, Boolean flag) throws Exception {
		
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
		return e;
	}
}
