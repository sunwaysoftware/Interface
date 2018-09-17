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

import com.sunway.dao.IBB00004DAO;
import com.sunway.office.ExcelUtil;
import com.sunway.vo.BF00004;

/**
 * @author Andy.Gao
 *
 */
public class BB00004DAO extends BaseDAO implements IBB00004DAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IBB00004DAO#LoadAll(com.sunway.vo.BF00004)
	 */
	
	@Override
	public ArrayList<BF00004> LoadAll(BF00004 bean) throws Exception {
		ArrayList<BF00004> listResult = new ArrayList<BF00004>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_00004(?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getOrder());
			call.setString(3, bean.getSort());
			call.setString(4, bean.getSqlData());
			call.setString(5, bean.getCd00001Ssgx());
			call.setString(6, bean.getPssd());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				BF00004 e = new BF00004();
				e.setBm(rs.getInt("bm"));
				e.setHs(rs.getInt("hs"));
				e.setZchs(rs.getInt("zchs"));
				e.setDsfhs(rs.getInt("dsfhs"));
				e.setSsgx(rs.getString("ssgx"));
				e.setCd00001Ssgx(rs.getString("CD_00001_SSGX"));
				e.setPssd(rs.getString("cd_00002_pssd"));
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
	public OutputStream ExportData(BF00004 bean) throws Exception {
		ByteArrayOutputStream result;
		Connection conn = null;
		ResultSet rs = null;
		CallableStatement call = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_00004(?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getOrder());
			call.setString(3, bean.getSort());
			call.setString(4, bean.getSqlData());
			call.setString(5, bean.getCd00001Ssgx());
			call.setString(6, bean.getPssd());
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
	public ArrayList<BF00004> LoadAll02(BF00004 bean) throws Exception {
		ArrayList<BF00004> listResult = new ArrayList<BF00004>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_02004(?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getOrder());
			call.setString(3, bean.getSort());
			call.setString(4, bean.getSqlData());
			call.setString(5, bean.getCd00001Ssgx());
			call.setString(6, bean.getPssd());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				BF00004 e = new BF00004();
				e.setBm(rs.getInt("bm"));
				e.setHs(rs.getInt("hs"));
				e.setZchs(rs.getInt("zchs"));
				e.setDsfhs(rs.getInt("dsfhs"));
				e.setSsgx(rs.getString("ssgx"));
				e.setCd00001Ssgx(rs.getString("CD_00001_SSGX"));
				e.setPssd(rs.getString("cd_00002_pssd"));
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
	public OutputStream ExportData02(BF00004 bean) throws Exception {
		ByteArrayOutputStream result;
		Connection conn = null;
		ResultSet rs = null;
		CallableStatement call = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_02004(?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getOrder());
			call.setString(3, bean.getSort());
			call.setString(4, bean.getSqlData());
			call.setString(5, bean.getCd00001Ssgx());
			call.setString(6, bean.getPssd());
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
