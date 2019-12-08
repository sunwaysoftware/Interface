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

import com.sunway.dao.IPgt00335DAO;
import com.sunway.vo.Pgt00335;

/**
 * @author Andy.Gao
 *
 */
public class Pgt00335DAO extends BaseDAO implements IPgt00335DAO {

	private static final String cd00302Fcid = "CD_00302_FCID";	//评税的编码
	private static final String cdSlid = "CD_SLID";				//可比实例的编码
	private static final String cd00002Pssd = "CD_00002_PSSD";	//评税时点
	private static final String pfmjg = "PFMJG";				//修正后的单价
	private static final String yxj = "YXJ";					//优先级
	private static final String zyxj = "ZYXJ";					//最优先级（所在同一个楼时）
	private static final String jysj = "JYSJ";					//交易时间
	private static final String wjxz = "WJXZ";					//物价指数修正
	private static final String cd00303Lfid = "CD_00303_LFID";	//楼房ID号
	private static final String xqdm = "XQDM";					//小区代码
	private static final String fwlx = "FWLX";					//房屋类型
	private static final String jylx = "JYLX";					//交易类型(0新)
	private static final String jzjg = "JZJG";					//建筑结构
	private static final String szlc = "SZLC";					//所在楼层
	private static final String zlc = "ZLC";					//总楼层
	private static final String ypfmjg = "YPFMJG";				//原单价
	private static final String ywdt = "YWDT";					//有无电梯(0无)
	private static final String upddate = "UPDDATE";			//更新日期
	private static final String czr = "CZR";					//操作人字段
	private static final String note = "NOTE";					//备注信息
	private static final String fwtdzl = "FWTDZL";
	private static final String cd00351Slid = "CD_00351_SLID";


	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00335DAO#LoadAll(com.sunway.vo.Pgt00335)
	 */
	
	@Override
	public ArrayList<Pgt00335> LoadAll(Pgt00335 bean) throws Exception {
		ArrayList<Pgt00335> listResult = new ArrayList<Pgt00335>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00335(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd00302Fcid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/**
	 * 数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00335 SetTParameters(ResultSet rs) throws Exception {
		Pgt00335 e = new Pgt00335();
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setCd00302Fcid(rs.getString(cd00302Fcid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCdSlid(rs.getString(cdSlid));
		//e.setCgzk(rs.getString(cgzk));
		e.setCzr(rs.getString(czr));
		//e.setFwcx(rs.getString(fwcx));
		e.setFwlx(rs.getString(fwlx));
		e.setFwtdzl(rs.getString(fwtdzl));
		e.setJylx(rs.getString(jylx));
		e.setJysj(rs.getDate(jysj));
		e.setJzjg(rs.getString(jzjg));
		e.setNote(rs.getString(note));
		e.setPfmjg(rs.getDouble(pfmjg));
		//e.setSlcgxz(rs.getDouble(slcgxz));
		//e.setSlcxxz(rs.getDouble(slcxxz));
		//e.setSllcxz(rs.getDouble(sllcxz));
		e.setSzlc(rs.getShort(szlc));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setWjxz(rs.getDouble(wjxz));
		e.setXqdm(rs.getString(xqdm));
		e.setYpfmjg(rs.getDouble(ypfmjg));
		e.setYwdt(rs.getBoolean(ywdt));
		e.setYxj(rs.getShort(yxj));
		e.setZlc(rs.getShort(zlc));
		e.setZyxj(rs.getBoolean(zyxj));
		e.setCd00351Slid(rs.getString(cd00351Slid));
		return e;
	}

}
