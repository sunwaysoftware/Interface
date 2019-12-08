package com.sunway.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IBB00007DAO;
import com.sunway.util.Excel;
import com.sunway.vo.BF00007;

/**
 * 年度湘潭市存量房交易纳税评估已开票完税统计表
 * @author Light
 *
 */
public class BB00007DAO extends BaseDAO implements IBB00007DAO{
	
	
	//private static final String CD00001SSGX = "CD_00001_SSGX";
	//private static final String SSGX = "SSGX";
	private static final String CD00002PSSD = "CD_00002_PSSD";
	//private static final String CD00002CZR = "CD_00002_CZR";
	//private static final String CD00001FWLX = "CD_00001_FWLX";
	private static final String FWLX = "FWLX";
	private static final String KPZZS = "KPZZS";							//开票总宗数
	private static final String KPZMJ = "KPZMJ";							//开票总面积
	private static final String HTSBZJ = "HTSBZJ";							//合同申报总价
	private static final String HTSBJJ = "HTSBJJ";							//合同申报均价
	private static final String XTPGZJ = "XTPGZJ";							//系统评估总价
	private static final String XTPGJJ = "XTPGJJ";							//系统评估均价
	private static final String XTPGZJL = "XTPGZJL";						//系统评估增减率
	private static final String QSSB = "QSSB";								//契税申报
	private static final String QSPG = "QSPG";								//契税评估
	private static final String YYSSB = "YYSSB";							//营业税申报
	private static final String YYSPG = "YYSPG";							//营业税评估
	private static final String CSWHJSSSB = "CSWHJSSSB";					//城市维护建设税申报
	private static final String CSWHJSSPG = "CSWHJSSPG";					//城市维护建设税评估
	private static final String JYFFJSB = "JYFFJSB";						//教育费附加申报
	private static final String JYFFJPG = "JYFFJPG";						//教育费附加评估
	private static final String GRSDSSB = "GRSDSSB";						//个人所得税申报
	private static final String GRSDSPG = "GRSDSPG";						//个人所得税评估
	private static final String YHSSB = "YHSSB";							//印花税申报
	private static final String YHSPG = "YHSPG";							//印花税评估
	private static final String TDZZSSB = "TDZZSSB";						//土地增值税申报
	private static final String TDZZSPG = "TDZZSPG";						//土地增值税评估
	private static final String SEHJSB = "SEHJSB";							//税额合计申报
	private static final String SEHJPG = "SEHJPG";							//税额合计评估
	private static final String SEHJZJL = "SEHJZJL";						//数额合计增减率
	
	

	
	@Override
	public ArrayList<BF00007> LoadAll(BF00007 bean) throws Exception {
		ArrayList<BF00007> resList = new ArrayList<BF00007>();
		Connection conn = null;
		Session session = null;
		ResultSet rs = null;
		CallableStatement call = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_00007(?,?,?,?)}");
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
	 * 加载数据
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	protected BF00007 SetParameters(ResultSet rs)throws Exception{
		BF00007 e = new BF00007();
		try{
			//e.setCd00001Ssgx(rs.getString(CD00001SSGX));
			//e.setSsgx(rs.getString(SSGX));
			e.setCd00002Pssd(rs.getString(CD00002PSSD));
			//e.setCd00002Czr(rs.getString(CD00002CZR));
			//e.setCd00001Fwlx(rs.getString(CD00001FWLX));
			e.setFwlx(rs.getString(FWLX));
			e.setKpzzs(rs.getBigDecimal(KPZZS));
			e.setKpzmj(rs.getDouble(KPZMJ));
			e.setHtsbzj(rs.getDouble(HTSBZJ));
			e.setHtsbjj(rs.getDouble(HTSBJJ));
			e.setXtpgzj(rs.getDouble(XTPGZJ));
			e.setXtpgjj(rs.getDouble(XTPGJJ));
			e.setXtpgzjl(rs.getDouble(XTPGZJL));
			e.setQssb(rs.getDouble(QSSB));
			e.setQspg(rs.getDouble(QSPG));
			e.setYyssb(rs.getDouble(YYSSB));
			e.setYyspg(rs.getDouble(YYSPG));
			e.setCswhjsssb(rs.getDouble(CSWHJSSSB));
			e.setCswhjsspg(rs.getDouble(CSWHJSSPG));
			e.setJyffjsb(rs.getDouble(JYFFJSB));
			e.setJyffjpg(rs.getDouble(JYFFJPG));
			e.setGrsdssb(rs.getDouble(GRSDSSB));
			e.setGrsdspg(rs.getDouble(GRSDSPG));
			e.setYhssb(rs.getDouble(YHSSB));
			e.setYhspg(rs.getDouble(YHSPG));
			e.setTdzzssb(rs.getDouble(TDZZSSB));
			e.setTdzzspg(rs.getDouble(TDZZSPG));
			e.setSehjsb(rs.getDouble(SEHJSB));
			e.setSehjpg(rs.getDouble(SEHJPG));
			e.setSehjzjl(rs.getDouble(SEHJZJL));
		}catch(Exception ex){
			throw ex;
		}finally{
			//
		}
		return e;
	}

	
	@Override
	public OutputStream ExportData(BF00007 bean, String fileName) throws Exception {
		ByteArrayOutputStream result;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_00007(?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, bean.getCd00001Ssgx());
			call.setString(3, bean.getPssdMin());
			call.setString(4, bean.getPssdMax());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			result = Excel.getExcelGen(rs, fileName, null);
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return result;
	}

	
}
