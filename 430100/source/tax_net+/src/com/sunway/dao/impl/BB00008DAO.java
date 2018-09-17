package com.sunway.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import com.sunway.dao.IBB00008DAO;
import com.sunway.office.ExcelUtil;
import com.sunway.util.Excel;
import com.sunway.vo.BF00008;

/**
 * 交易纳税评估分区域统计表
 * @author Light
 *
 */
public class BB00008DAO extends BaseDAO implements IBB00008DAO{

	private static final String FWLX = "FWLX";
	private static final String SSGX = "SSGX";
	private static final String KPZZS = "KPZZS";
	private static final String KPZMJ = "KPZMJ";
	private static final String XTPG = "XTPGZS";
	private static final String GAPG = "GAPGZS";
	private static final String HTSBZJ = "HTSBZJ";
	private static final String HTSBJJ = "HTSBJJ";
	private static final String XTPGZJ = "XTPGZJ";
	private static final String XTPGJJ = "XTPGJJ";
	private static final String XTPGZJL = "XTPGZJL";
	private static final String QSSB = "QSSB";
	private static final String QSPG = "QSPG";
	private static final String YYSSB = "YYSSB";
	private static final String YYSPG = "YYSPG";
	private static final String CSWHJSSSB = "CSWHJSSSB";
	private static final String CSWHJSSPG = "CSWHJSSPG";
	private static final String JYFFJSB = "JYFFJSB";
	private static final String JYFFJPG = "JYFFJPG";
	private static final String GRSDSSB = "GRSDSSB";
	private static final String GRSDSPG = "GRSDSPG";
	private static final String YHSSB = "YHSSB";
	private static final String YHSPG = "YHSPG";
	private static final String TDZZSSB = "TDZZSSB";
	private static final String TDZZSPG = "TDZZSPG";
	private static final String SEHJSB = "SEHJSB";
	private static final String SEHJPG = "SEHJPG";
	private static final String SEHJZJL = "SEHJZJL";

	
	@Override
	public ArrayList<BF00008> LoadAll(BF00008 bean)throws Exception {
		ArrayList<BF00008> resList = new ArrayList<BF00008>();
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_00008(?,?,?,?)}");
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
	 * 数据加载
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	protected BF00008 SetParameters(ResultSet rs)throws Exception{
		BF00008 bean = new BF00008();
		try{
			//bean.setCd00001Ssgx(rs.getString(CD00001SSGX));
			//bean.setCd00001Fwlx(rs.getString(CD00001FWLX));
			bean.setFwlx(rs.getString(FWLX));
			bean.setSsgx(rs.getString(SSGX));
			bean.setPgzzs(rs.getBigDecimal(KPZZS));
			bean.setPgzmj(rs.getBigDecimal(KPZMJ));
			bean.setXtpg(rs.getDouble(XTPG));
			bean.setGapg(rs.getDouble(GAPG));
			bean.setHtsbzj(rs.getDouble(HTSBZJ));
			bean.setHtsbjj(rs.getDouble(HTSBJJ));
			bean.setXtpgzj(rs.getDouble(XTPGZJ));
			bean.setXtpgjj(rs.getDouble(XTPGJJ));
			bean.setXtpgzjl(rs.getDouble(XTPGZJL));
			bean.setQssb(rs.getDouble(QSSB));
			bean.setQspg(rs.getDouble(QSPG));
			bean.setYyssb(rs.getDouble(YYSSB));
			bean.setYyspg(rs.getDouble(YYSPG));
			bean.setCswhjsssb(rs.getDouble(CSWHJSSSB));
			bean.setCswhjsspg(rs.getDouble(CSWHJSSPG));
			bean.setJyffjsb(rs.getDouble(JYFFJSB));
			bean.setJyffjpg(rs.getDouble(JYFFJPG));
			bean.setGrsdssb(rs.getDouble(GRSDSSB));
			bean.setGrsdspg(rs.getDouble(GRSDSPG));
			bean.setYhssb(rs.getDouble(YHSSB));
			bean.setYhspg(rs.getDouble(YHSPG));
			bean.setTdzzssb(rs.getDouble(TDZZSSB));
			bean.setTdzzspg(rs.getDouble(TDZZSPG));
			bean.setSehjsb(rs.getDouble(SEHJSB));
			bean.setSehjpg(rs.getDouble(SEHJPG));
			bean.setSehjzjl(rs.getDouble(SEHJZJL));
		}catch(Exception e){
			throw e;
		}finally{
			//
		}
		return bean;
	}
	
	
	@Override
	public OutputStream ExportData(BF00008 bean, String fileName)throws Exception {
		ByteArrayOutputStream result;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_00008(?,?,?,?)}");
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
