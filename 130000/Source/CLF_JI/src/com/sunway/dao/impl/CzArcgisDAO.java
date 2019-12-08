package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import com.sunway.dao.ICzArcgisDAO;
import com.sunway.vo.CzArcgis;

/**
 * @author Lee
 *
 */
public class CzArcgisDAO extends BaseDAO implements ICzArcgisDAO {

	private static final String xqnm = "XQNM"; 							//小区名称
	private static final String cd00303lfid = "LFID"; 			//楼房编码
	private static final String minvalue = "MINVALUE"; 					//最小值
	private static final String maxvalue = "MAXVALUE"; 					//最大值
	private static final String title = "title"; 							//企业名称
	private static final String totalsum = "totalsum"; 						//总和
	private static final String dcid = "dcid"; 								//地产编码
	private static final String swid = "swid"; 								//税务代码
	private static final String x = "x"; 									//地理坐标X
	private static final String y = "y"; 									//地理坐标Y
	private static final String nsrmc = "nsrmc"; 							//纳税人名称
	private static final String jjlx = "jjlx"; 								//经济类型
	private static final String cd00001Ssgx = "CD_00001_SSGX"; 				//税收管辖
	private static final String cd00001Tdyt = "CD_00001_TDYT"; 				//土地用途
	private static final String cd12054Tddjid = "CD_12054_TDDJID"; 			//土地等级编码
	
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.ICzArcgisDAO#ExecCommandCZ00062(com.sunway.vo.CzArcgis)
	 */
	
	@Override
	public CzArcgis ExecCommandCZ00062(CzArcgis arcgis) throws Exception {
		CzArcgis bean = new CzArcgis();
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		ResultSet rs = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00062(?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			call.registerOutParameter(2, OracleTypes.INTEGER);
			//传入输入参数
			call.setString(3, arcgis.getId());
			call.setDouble(4, arcgis.getType());
			call.execute();
			//为Bean赋值
			bean.setX(call.getDouble(1));
			bean.setY(call.getDouble(2));
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return bean;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.ICzArcgisDAO#ExecCommandCZ00063(com.sunway.vo.CzArcgis)
	 */
	
	@Override
	public CzArcgis ExecCommandCZ00063(CzArcgis arcgis) throws Exception {
		CzArcgis bean = new CzArcgis();
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		ResultSet rs = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00063(?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, arcgis.getCd00352Xqdm());
			call.setString(3, arcgis.getFwtdzl());
			call.setString(4, arcgis.getCd00002Pssd());
			call.execute();
			//为Bean赋值
			rs = (ResultSet)call.getObject(1);
			if (null!=rs && rs.next()) {
				SetCZ00063Parameters(rs, bean);
			}
			
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return bean;
	}

	/**
	 * 数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected CzArcgis SetCZ00063Parameters(ResultSet rs, CzArcgis arcgis) throws Exception {
		arcgis.setXqnm(rs.getString(xqnm));
		arcgis.setCd00303Lfid(rs.getString(cd00303lfid));
		arcgis.setMinValue(rs.getDouble(minvalue));
		arcgis.setMaxValue(rs.getDouble(maxvalue));
		return arcgis;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.ICzArcgisDAO#ExecCommandCZ00064(com.sunway.vo.CzArcgis)
	 */
	
	@Override
	public ArrayList<CzArcgis> ExecCommandCZ00064(CzArcgis arcgis) throws Exception {
		ArrayList<CzArcgis> listResult = new ArrayList<CzArcgis>();
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		ResultSet rs = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00064(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, arcgis.getCd00001Ssgx());
			call.execute();
			//为Bean赋值
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetCZ00064Parameters(rs));
			}
			
		} catch (Exception e) {
			throw e;
		}finally{
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
	protected CzArcgis SetCZ00064Parameters(ResultSet rs) throws Exception {
		CzArcgis e = new CzArcgis();
		e.setDcid(rs.getString(dcid));
		e.setSwid(rs.getString(swid));
		e.setX(rs.getDouble(x));
		e.setY(rs.getDouble(y));
		e.setNsrmc(rs.getString(nsrmc));
		e.setJjlx(rs.getString(jjlx));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00001Tdyt(rs.getString(cd00001Tdyt));
		e.setCd12054Tddjid(rs.getString(cd12054Tddjid));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.ICzArcgisDAO#ExecCommandCZ00061(com.sunway.vo.CzArcgis)
	 */
	
	@Override
	public ArrayList<CzArcgis> ExecCommandCZ00061(CzArcgis arcgis) throws Exception {
		ArrayList<CzArcgis> listResult = new ArrayList<CzArcgis>();
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		ResultSet rs = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00061(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, arcgis.getDcid());
			call.setString(3, arcgis.getCd00002Pssd());
			call.execute();
			//为Bean赋值
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetCZ00061Parameters(rs));
			}
			
		} catch (Exception e) {
			throw e;
		}finally{
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
	protected CzArcgis SetCZ00061Parameters(ResultSet rs) throws Exception {
		CzArcgis e = new CzArcgis();
		e.setTitle(rs.getString(title));
		e.setTotalsum(rs.getDouble(totalsum));
		return e;
	}
}
