package com.sunway.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IBB00006DAO;
import com.sunway.office.ExcelUtil;
import com.sunway.util.Excel;
import com.sunway.vo.BF00006;

/**
 * 交易纳税评估数量统计表
 * @author Light
 *
 */
public class BB00006DAO extends BaseDAO implements IBB00006DAO {
	
	//private static final String CD00001FWLX = "CD_00001_FWLX";
	private static final String FWLX = "FWLX";
	//private static final String CD00001SSGX = "CD_00001_SSGX";
	//private static final String SSGX = "SSGX";
	private static final String CD00002PSSD = "CD_00002_PSSD";
	//private static final String CD00002CZR = "CD_00002_CZR";
	private static final String PGZZS = "PGZZS";						//评估总宗数
	private static final String PGZSBL = "PGZSBL";						//评估宗数占比
	private static final String PGZMJ = "PGZMJ";						//评估总面积
	private static final String XTPGZS = "XTPGZS";						//系统评估宗数
	private static final String XTPGZSBL = "XTPGZSBL";					//系统评估宗数占比
	private static final String GAPGZS = "GAPGZS";						//个案评估宗数
	private static final String GAPGZSBL = "GAPGZSBL";					//个案评估宗数占比
	private static final String YWSZS = "YWSZS";						//已完税宗数
	private static final String YWSZSBL = "YWSZSBL";					//已完税宗数占比
	private static final String WWSZS = "WWSZS";						//未完税宗数
	private static final String WWSZSBL = "WWSZSBL";					//未完税宗数占比

	
	@Override
	public ArrayList<BF00006> LoadAll(BF00006 bean) throws Exception {
		ArrayList<BF00006> resList = new ArrayList<BF00006>();
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_00006(?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, bean.getCd00001Ssgx());
			call.setString(3, bean.getPssdMin());
			call.setString(4, bean.getPssdMax());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				resList.add(SetParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return resList;
	}
	
	/**
	 * 数据装载
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	protected BF00006 SetParameters(ResultSet rs)throws Exception{
		BF00006 e = new BF00006();
		try{
			//e.setCd00001Fwlx(rs.getString(CD00001FWLX));
			e.setFwlx(rs.getString(FWLX));
			//e.setCd00001Ssgx(rs.getString(CD00001SSGX));
			//e.setSsgx(rs.getString(SSGX));
			//e.setCd00002Czr(rs.getString(CD00002CZR));
			e.setCd00002Pssd(rs.getString(CD00002PSSD));
			e.setPgzzs(rs.getBigDecimal(PGZZS));
			e.setPgzsbl(rs.getDouble(PGZSBL));
			e.setPgzmj(rs.getDouble(PGZMJ));
			e.setXtpgzs(rs.getBigDecimal(XTPGZS));
			e.setXtpgzsbl(rs.getDouble(XTPGZSBL));
			e.setGapgzs(rs.getBigDecimal(GAPGZS));
			e.setGapgzsbl(rs.getDouble(GAPGZSBL));
			e.setYwszs(rs.getBigDecimal(YWSZS));
			e.setYwszsbl(rs.getDouble(YWSZSBL));
			e.setWwszs(rs.getBigDecimal(WWSZS));
			e.setWwszsbl(rs.getDouble(WWSZSBL));
		}catch(Exception ex){
			throw ex;
		}finally{
			//
		}
		return e;
	}

	
	@Override
	public OutputStream ExportData(BF00006 bean, String fileName) throws Exception {
		ByteArrayOutputStream result;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_00006(?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, bean.getCd00001Ssgx());
			call.setString(3, bean.getPssdMin());
			call.setString(4, bean.getPssdMax());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			result = ExcelUtil.expExcel(rs, Excel.excelPath(fileName), null);
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return result;
	}

}
