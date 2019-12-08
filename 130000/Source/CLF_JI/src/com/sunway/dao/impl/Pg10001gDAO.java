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

import com.sunway.dao.IPg10001gDAO;
import com.sunway.vo.Pgv10031;

/**
 * 
 * 个案评税[成本法]
 * @author Andy.Gao
 * @category 个案评税
 *
 */
public class Pg10001gDAO extends BaseDAO implements IPg10001gDAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgg10001DAO#LoadPgMx(com.sunway.vo.Pgv12004)
	 */
	
	@Override
	public ArrayList<Pgv10031> LoadPgMx(Pgv10031 bean) throws Exception {
		ArrayList<Pgv10031> listResult = new ArrayList<Pgv10031>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;	
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT100313(?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getSysPssd());
			call.setString(5, bean.getCd12001Swid());
			call.setString(6, bean.getNsrmc());
			call.setString(7, bean.getCd12004Mxid());
			call.setString(8, bean.getSysSsgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetV10031Parameters(rs));
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
	protected Pgv10031 SetV10031Parameters(ResultSet rs) throws Exception {
		String total = "TOTAL";
		String rid = "RID";
		String cd12004Mxid = "CD_12004_MXID";
		String fcpgjg = "FCPGJG";
		String dcpgjg = "DCPGJG";
		String pgjg = "PGJG";
		String cd00002Pssdy = "CD_00002_PSSDY";
		String cd00002Pssd = "CD_00002_PSSD";
		String cxl = "CXL";
		String czl = "CZL";
		String ysynx = "YSYNX";
		String jjnynx = "JJNYNX";
		String jazj = "JAZJ";
		String jjbbl = "JJBBL";
		String jzmj = "JZMJ";
		String rjlxs = "RJLXS";
		String psss = "PSSS";
		String dj = "DJ";
		String gyttdmj = "GYTTDMJ";
		String cqf = "CQF";
		String tdyt = "TDYT";
		String gbrjl = "GBRJL";
		String szqy = "SZQY";
		String tddj = "TDDJ";
		String fwyt = "FWYT";
		String xjbz = "XJBZ";
		String jzjg = "JZJG";
		String upddate = "UPDDATE";
		String czr = "CZR";
		String note = "NOTE";
		String dcqtxz = "DCQTXZ";
		String fcqtxz = "FCQTXZ";
		String gbfcpgjg = "GBFCPGJG";
		String gbdcpgjg = "GBDCPGJG";
		String gbpgjg = "GBPGJG";
		String gbfcxzxs = "GBFCXZXS";
		String gbdcxzxs = "GBDCXZXS";
		String cd12001Swid = "CD_12001_SWID";
		String nsrmc = "NSRMC";
		String cd00001Ssgx = "CD_00001_SSGX";
		String cbpgczr = "CBPGCZR";
		String gzCount = "GZCOUNT";
		
		Pgv10031 e = new Pgv10031();
		e.setRecordCount(rs.getInt(total));	
		e.setRecordIndex(rs.getInt(rid));	        
		e.setCd12004Mxid(rs.getString(cd12004Mxid));	
		e.setFcpgjg(rs.getDouble(fcpgjg));
		e.setDcpgjg(rs.getDouble(dcpgjg));
		e.setPgjg(rs.getDouble(pgjg));	    
		e.setCd00002Pssdy(rs.getString(cd00002Pssdy));
		e.setCd00002Pssd(rs.getDate(cd00002Pssd));	
		e.setCxl(rs.getDouble(cxl));	        
		e.setCzl(rs.getDouble(czl));	        
		e.setYsynx(rs.getLong(ysynx));	    
		e.setJjnynx(rs.getLong(jjnynx));	    
		e.setJazj(rs.getDouble(jazj));	    
		e.setJjbbl(rs.getDouble(jjbbl));	    
		e.setJzmj(rs.getDouble(jzmj));	    
		e.setRjlxs(rs.getDouble(rjlxs));	    
		e.setPsss(rs.getDouble(psss));	    
		e.setDj(rs.getDouble(dj));	        
		e.setGyttdmj(rs.getDouble(gyttdmj));	    
		e.setCqf(rs.getDouble(cqf));	        
		e.setTdyt(rs.getString(tdyt));	    
		e.setGbrjl(rs.getDouble(gbrjl));	    
		e.setSzqy(rs.getString(szqy));	    
		e.setTddj(rs.getString(tddj));	    
		e.setFwyt(rs.getString(fwyt));	    
		e.setXjbz(rs.getString(xjbz));	    
		e.setJzjg(rs.getString(jzjg));
		e.setUpddate(rs.getTimestamp(upddate));	    
		e.setCzr(rs.getString(czr));	        
		e.setNote(rs.getString(note));	    
		e.setDcqtxz(rs.getDouble(dcqtxz));	    
		e.setFcqtxz(rs.getDouble(fcqtxz));	    
		e.setGbfcpgjg(rs.getDouble(gbfcpgjg));	
		e.setGbdcpgjg(rs.getDouble(gbdcpgjg));	
		e.setGbpgjg(rs.getDouble(gbpgjg));	    
		e.setGbfcxzxs(rs.getDouble(gbfcxzxs));	
		e.setGbdcxzxs(rs.getDouble(gbdcxzxs));	
		e.setCd12001Swid(rs.getString(cd12001Swid));	
		e.setNsrmc(rs.getString(nsrmc));	    
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));	
		e.setCbpgczr(rs.getString(cbpgczr));	 
		e.setGzCount(rs.getInt(gzCount));
		return e;
	}
}
