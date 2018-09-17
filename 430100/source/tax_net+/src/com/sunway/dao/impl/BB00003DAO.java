/**
 * 
 */
package com.sunway.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IBB00003DAO;
import com.sunway.office.ExcelUtil;
import com.sunway.vo.BF00003;

/**
 * @author Lee
 *
 */
public class BB00003DAO extends BaseDAO implements IBB00003DAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IBB00003DAO#LoadAll(com.sunway.vo.BF00003)
	 */
	
	@Override
	public ArrayList<BF00003> LoadAll(BF00003 bean) throws Exception {
		ArrayList<BF00003> listResult = new ArrayList<BF00003>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_00003(?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getOrder());
			call.setString(3, bean.getSort());
			call.setString(4, bean.getSqlData());
			call.setString(5, bean.getCd00001Ssgx());
			call.setString(6, bean.getCd00002Pssd());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				BF00003 e = new BF00003();
				e.setBm(rs.getInt("bm"));
				e.setCd00001Ssgx(rs.getString("CD_00001_SSGX"));
				e.setCd00002Pssd(rs.getString("CD_00002_PSSD"));
				e.setSbjg(rs.getBigDecimal("sbjg"));
				e.setPgjg(rs.getBigDecimal("pgjg"));
				e.setCd00002Czr(rs.getString("CD_00002_CZR"));
				e.setHdjg(rs.getBigDecimal("hdjg"));
				e.setSsgx(rs.getString("ssgx"));
				listResult.add(e);
				e = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IBB00008DAO#ExportDataW(com.sunway.vo.BF00008)
	 */
	
	@Override
	public OutputStream ExportData(BF00003 bean) throws Exception {
		ByteArrayOutputStream result;
		Connection conn = null;
		ResultSet rs = null;
		CallableStatement call = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_00003(?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getOrder());
			call.setString(3, bean.getSort());
			call.setString(4, bean.getSqlData());
			call.setString(5, bean.getCd00001Ssgx());
			call.setString(6, bean.getCd00002Pssd());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			//创建替换独自单元格列表
			//ArrayList<HashMap<String, String>> hashList = new ArrayList<HashMap<String, String>>();
			/*HashMap<String, String> hm = new HashMap<String, String>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			hm.put("cxsj", sdf.format(bean.getJysjMin()) + "    至    " + sdf.format(bean.getJysjMax()));
			hashList.add(hm);*/
			result = ExcelUtil.expExcel(rs, bean.getExpFileName(), null);
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return result;
	}
	
	@Override
	public ArrayList<BF00003> LoadAll02(BF00003 bean) throws Exception {
		ArrayList<BF00003> listResult = new ArrayList<BF00003>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_02003(?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getOrder());
			call.setString(3, bean.getSort());
			call.setString(4, bean.getSqlData());
			call.setString(5, bean.getCd00001Ssgx());
			call.setString(6, bean.getCd00002Pssd());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				BF00003 e = new BF00003();
				e.setBm(rs.getInt("bm"));
				e.setCd00001Ssgx(rs.getString("CD_00001_SSGX"));
				e.setCd00002Pssd(rs.getString("CD_00002_PSSD"));
				e.setSbjg(rs.getBigDecimal("sbjg"));
				e.setPgjg(rs.getBigDecimal("pgjg"));
				e.setCd00002Czr(rs.getString("CD_00002_CZR"));
				e.setHdjg(rs.getBigDecimal("hdjg"));
				e.setSsgx(rs.getString("ssgx"));
				listResult.add(e);
				e = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IBB00008DAO#ExportDataW(com.sunway.vo.BF00008)
	 */
	
	@Override
	public OutputStream ExportData02(BF00003 bean) throws Exception {
		ByteArrayOutputStream result;
		Connection conn = null;
		ResultSet rs = null;
		CallableStatement call = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_02003(?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getOrder());
			call.setString(3, bean.getSort());
			call.setString(4, bean.getSqlData());
			call.setString(5, bean.getCd00001Ssgx());
			call.setString(6, bean.getCd00002Pssd());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			//创建替换独自单元格列表
			//ArrayList<HashMap<String, String>> hashList = new ArrayList<HashMap<String, String>>();
			/*HashMap<String, String> hm = new HashMap<String, String>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			hm.put("cxsj", sdf.format(bean.getJysjMin()) + "    至    " + sdf.format(bean.getJysjMax()));
			hashList.add(hm);*/
			result = ExcelUtil.expExcel(rs, bean.getExpFileName(), null);
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return result;
	}
}
