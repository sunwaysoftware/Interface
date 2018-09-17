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

import com.sunway.dao.IPgt02034DAO;
import com.sunway.vo.Pgt02034;

/**
 *
 * 市场法参与评税的实例库
 * @author Andy.Gao
 *
 */
public class Pgt02034DAO extends BaseDAO implements IPgt02034DAO {

	private static final String cd02002Fcid = "CD_02002_FCID";	//评税的编码
	private static final String cdSlid = "CD_SLID";				//可比实例的编码
	private static final String pfmjg = "PFMJG";				//修正后的单价
	//private static final String yxj = "YXJ";					//优先级
	//private static final String zyxj = "ZYXJ";					//最优先级（所在同一个楼时）
	private static final String jysj = "JYSJ";					//交易时间
	private static final String wjxz = "WJXZ";					//物价指数修正
	private static final String xqdm = "XQDM";					//小区代码
	private static final String fwlx = "FWLX";					//房屋类型
	//private static final String jylx = "JYLX";					//交易类型(0新)
	//private static final String jzjg = "JZJG";					//建筑结构
	//private static final String szlc = "SZLC";					//所在楼层
	//private static final String zlc = "ZLC";					//总楼层
	private static final String ypfmjg = "YPFMJG";				//原单价
	//private static final String ywdt = "YWDT";					//有无电梯(0无)
	private static final String upddate = "UPDDATE";			//更新日期
	private static final String czr = "CZR";					//操作人字段
	private static final String note = "NOTE";					//备注信息
	//private static final String fwtdzl = "FWTDZL";				//备注信息
	private static final String cd02061Slid = "CD_02061_SLID";

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02034DAO#LoadAll(com.sunway.vo.Pgt02034)
	 */
	
	@Override
	public ArrayList<Pgt02034> LoadAll(Pgt02034 bean) throws Exception {
		ArrayList<Pgt02034> listResult = new ArrayList<Pgt02034>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02034(?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, bean.getCd02002Fcid());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	
	
	public ArrayList<Pgt02034> LoadAll_B(Pgt02034 bean) throws Exception {
		ArrayList<Pgt02034> listResult = new ArrayList<Pgt02034>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02034_B(?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, bean.getCd02002Fcid());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
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
	protected Pgt02034 SetTParameters(ResultSet rs) throws Exception {
		Pgt02034 e = new Pgt02034();
		e.setCd02002Fcid(rs.getString(cd02002Fcid));
		e.setCdSlid(rs.getString(cdSlid));
		//e.setCgzk(rs.getString(cgzk));
		e.setCzr(rs.getString(czr));
		//e.setFwcx(rs.getString(fwcx));
		e.setFwlx(rs.getString(fwlx));
		//e.setFwtdzl(rs.getString(fwtdzl));
		//e.setJylx(rs.getString(jylx));
		e.setJysj(rs.getDate(jysj));
		//e.setJzjg(rs.getString(jzjg));
		e.setNote(rs.getString(note));
		e.setPfmjg(rs.getDouble(pfmjg));
		//e.setSlcgxz(rs.getDouble(slcgxz));
		//e.setSlcxxz(rs.getDouble(slcxxz));
		//e.setSllcxz(rs.getDouble(sllcxz));
		//e.setSzlc(rs.getShort(szlc));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setWjxz(rs.getDouble(wjxz));
		e.setXqdm(rs.getString(xqdm));
		e.setYpfmjg(rs.getDouble(ypfmjg));
		//e.setYwdt(rs.getBoolean(ywdt));
		//e.setYxj(rs.getShort(yxj));
		//e.setZlc(rs.getShort(zlc));
		//e.setZyxj(rs.getBoolean(zyxj));
		e.setCd02061Slid(rs.getString(cd02061Slid));
		return e;
	}

}