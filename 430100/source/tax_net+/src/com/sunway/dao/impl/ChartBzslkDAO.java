package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IChartBzslkDAO;
import com.sunway.util.ConvertUtil;
import com.sunway.vo.ChartBzslk;

/**
 * @author Lee
 *
 */
public class ChartBzslkDAO extends BaseDAO implements IChartBzslkDAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IChartBzslkDAO#GetUpdateSlk(java.util.Date, java.lang.Double, java.lang.String)
	 */
	
	@Override
	public Boolean GetUpdateSlk (ChartBzslk chart) throws Exception{
		boolean bResult = false;
		Integer intResult = 0;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;	
		ResultSet rs = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00351A1(?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			//传入输入参数
			call.setDate(2, ConvertUtil.utilDateToSqlDate(chart.getMonth()));
			call.setDouble(3, chart.getCzl());
			call.setString(4, chart.getCd00002Czr());
			call.setString(5, chart.getCd00352Xqdm());
			call.setString(6, chart.getCd00001Szqy());
			call.setString(7, chart.getCd00001Fwlx());
			call.execute();
			tran.commit();
			intResult = call.getInt(1);
			if (intResult ==1) {
				bResult = true;
			}
		} catch (Exception e) {
			tran.rollback();
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return bResult;
	}

	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IChartBzslkDAO#LoadByUpdate(java.lang.String, java.lang.String)
	 */
	
	@Override
	public ArrayList<ChartBzslk> LoadByUpdate(ChartBzslk chart) throws Exception{
		ArrayList<ChartBzslk> listResult = new ArrayList<ChartBzslk>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_003511(?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, chart.getCd00352Xqdm());
			call.setString(3, chart.getCd00002Pssd());
			call.setString(4, chart.getCd00001Szqy());
			call.setString(5, chart.getCd00001Fwlx());
			call.setString(6, chart.getCd00001Ssgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(rs.next()){
				listResult.add(SetChartParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}


	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected ChartBzslk SetChartParameters(ResultSet rs) throws Exception {
		ChartBzslk e = new ChartBzslk();
		e.setLx(rs.getString("lx"));
		e.setJyMonth(rs.getString("jymonth"));
		e.setJe(rs.getDouble("je"));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IChartBzslkDAO#GetZzl(com.sunway.vo.ChartBzslk)
	 */
	
	@Override
	public Double GetZzl(ChartBzslk chart) throws Exception {
		Double bResult = 0.0;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		ResultSet rs = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{? = call FN_GETZZL(?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.NUMBER);
			//传入输入参数
			call.setDate(2, ConvertUtil.utilDateToSqlDate(chart.getMonth()));
			call.setInt(3, chart.getGpqz());
			call.setString(4, chart.getCd00001Szqy());
			call.setString(5, chart.getCd00352Xqdm());
			call.execute();
			bResult = call.getDouble(1);
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return bResult;
	}
}
